package roots.plugin.plugin;

import roots.plugin.translation.ITranslation;

public interface IPlugin
{
	public void setPluginManager(IPluginManager p_pluginmanager);
	public void doTranslation(ITranslation.enum_language p_language);
//	public void startProgram(); �bergabe parameter wie person
	public void closeProgram();
}
