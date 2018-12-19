package roots.translation;

import java.io.IOException;
import java.util.Properties;

import roots.plugin.translation.ITranslation;

public class TPForfedre
{	
	private static final String LANGUAGE_FILE_SUFFIX = ".properties";
	public static final String LANGUAGE_FILE_LOCATION = "/roots/translation/";
	
	private Properties properties;

	public TPForfedre(ITranslation.enum_language p_language, String p_language_file_location) throws IOException
	{
		properties = new Properties();

		properties.load(TPForfedre.class.getResourceAsStream(p_language_file_location + p_language + LANGUAGE_FILE_SUFFIX));
	}

	public String getLanguagePropertie(String p_tag)
	{
		return this.properties.getProperty(p_tag);
	}

}
