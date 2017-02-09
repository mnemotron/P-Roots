package roots.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import roots.core.SystemProperties;
import roots.core.gui.GUICMain;
import roots.translation.ITranslation;

public class CPlugin implements ITranslation
{
	private static CPlugin plugincontroller;

	private ArrayList<IPlugin> plugins;
	private static ClassLoader cl;

	public static CPlugin getPluginControllerInstance()
	{
		if (CPlugin.plugincontroller == null)
		{
			CPlugin.plugincontroller = new CPlugin();
		}

		return CPlugin.plugincontroller;
	}

	private CPlugin()
	{
		plugins = new ArrayList<IPlugin>();
	}

	public void loadExternalPlugins(GUICMain p_guimaincontroller) throws IOException
	{
		List<IPlugin> plugins_tmp = null;

		plugins_tmp = CPlugin.loadPlugins(new File(SystemProperties.PLUGIN_DIR));

		PluginManager pluginmanager = new PluginManager(p_guimaincontroller);

		// set plugin manager
		for (IPlugin p : plugins_tmp)
		{
			p.setPluginManager(pluginmanager);
			plugins.add(p);
		}
	}

	public void loadPlugin(GUICMain p_guimaincontroller, IPlugin p_iplugin)
	{
		PluginManager pluginmanager = new PluginManager(p_guimaincontroller);

		p_iplugin.setPluginManager(pluginmanager);

		this.addPlugin(p_iplugin);
	}

	private static List<IPlugin> loadPlugins(File p_plugdir) throws IOException
	{
		// get all JAR-files in the plugin directory
		File[] plugjars = p_plugdir.listFiles(new JARFileFilter());

		cl = new URLClassLoader(CPlugin.fileArrayToURLArray(plugjars));

		List<Class<IPlugin>> plugClasses = CPlugin.extractClassesFromJARs(plugjars, cl);

		return CPlugin.createPluggableObjects(plugClasses);
	}

	private static URL[] fileArrayToURLArray(File[] p_files) throws MalformedURLException
	{
		URL[] urls = new URL[p_files.length];

		for (int i = 0; i < p_files.length; i++)
		{
			urls[i] = p_files[i].toURI().toURL();
		}

		return urls;
	}

	private static List<Class<IPlugin>> extractClassesFromJARs(File[] p_jars, ClassLoader p_cl) throws IOException
	{
		List<Class<IPlugin>> classes = new ArrayList<Class<IPlugin>>();

		for (File jar : p_jars)
		{
			classes.addAll(CPlugin.extractClassesFromJAR(jar, p_cl));
		}

		return classes;
	}

	@SuppressWarnings("unchecked")
	private static List<Class<IPlugin>> extractClassesFromJAR(File p_jar, ClassLoader p_cl) throws IOException
	{
		List<Class<IPlugin>> classes = new ArrayList<Class<IPlugin>>();

		JarInputStream jaris = new JarInputStream(new FileInputStream(p_jar));

		JarEntry ent = null;

		while ((ent = jaris.getNextJarEntry()) != null)
		{
			if (ent.getName().toLowerCase().endsWith(".class"))
			{
				try
				{
					Class<?> cls = p_cl
							.loadClass(ent.getName().substring(0, ent.getName().length() - 6).replace('/', '.'));
					if (CPlugin.isPluggableClass(cls))
					{
						classes.add((Class<IPlugin>) cls);
					}
				} catch (ClassNotFoundException e)
				{
					System.err.println("Can't load Class " + ent.getName());
					e.printStackTrace();
				}
			}
		}
		jaris.close();

		return classes;
	}

	private static boolean isPluggableClass(Class<?> cls)
	{
		for (Class<?> i : cls.getInterfaces())
		{
			if (i.equals(IPlugin.class))
			{
				return true;
			}
		}
		return false;
	}

	private static List<IPlugin> createPluggableObjects(List<Class<IPlugin>> p_pluggables)
	{
		List<IPlugin> plugs = new ArrayList<IPlugin>(p_pluggables.size());

		for (Class<IPlugin> plug : p_pluggables)
		{
			try
			{
				IPlugin iplug = plug.newInstance();
				plugs.add(iplug);

			} catch (InstantiationException e)
			{
				System.err.println("Can't instantiate plugin: " + plug.getName());
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				System.err.println("IllegalAccess for plugin: " + plug.getName());
				e.printStackTrace();
			}
		}

		return plugs;
	}

	public void fireSingleClosed(IPlugin p_iplugin)
	{
		int i = this.plugins.indexOf(p_iplugin);

		this.plugins.get(i).closeProgram();
	}

	protected void addPlugin(IPlugin p_iplugin)
	{
		this.plugins.add(p_iplugin);
	}

	@Override
	public void do_translation(enum_language p_language)
	{
		for (IPlugin p : this.plugins)
		{
			p.doTranslation(p_language);
		}
	}
}
