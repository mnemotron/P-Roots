package roots.config;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import roots.core.SystemProperties;

public class ConfigController
{
	private static ConfigController configcontroller;
	private ConfigEntity configentity;
	private File configfile;

	public static final ConfigController getConfigControllerInstance()
	{

		if (ConfigController.configcontroller == null)
		{
			ConfigController.configcontroller = new ConfigController();
		}

		return ConfigController.configcontroller;
	}

	private ConfigController()
	{
		configfile = new File(SystemProperties.c_config_file);
		this.configentity = new ConfigEntity();

		try
		{
			this.readConfig();
		} catch (Exception e)
		{
			this.saveConfig();
		}
	}

	public ConfigEntity getConfigentity()
	{
		return configentity;
	}

	public void setConfigentity(ConfigEntity configentity)
	{
		this.configentity = configentity;
	}

	private void readConfig() throws Exception
	{
		FileInputStream fis = null;
		ObjectInputStream in = null;
		ConfigEntity config = null;

		fis = new FileInputStream(configfile);
		in = new ObjectInputStream(fis);
		config = (ConfigEntity) in.readObject();
		in.close();

		configentity = config;
	}

	public void saveConfig()
	{
		ObjectOutputStream out = null;

		try
		{

			BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(configfile));
			out = new ObjectOutputStream(bo);
			out.writeObject(configentity);
			out.close();

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
