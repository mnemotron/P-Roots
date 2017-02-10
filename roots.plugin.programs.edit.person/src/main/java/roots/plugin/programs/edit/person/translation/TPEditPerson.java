package roots.plugin.programs.edit.person.translation;

import java.io.IOException;
import java.util.Properties;
import roots.translation.ITranslation;

public class TPEditPerson
{
	private static final String LANGUAGE_FILE_SUFFIX = ".properties";
	public static final String LANGUAGE_FILE_LOCATION = "/roots/plugin/programs/edit/person/translation/";

	private Properties properties;

	public TPEditPerson(ITranslation.enum_language p_language, String p_language_file_location) throws IOException
	{
		properties = new Properties();

		properties.load(TPEditPerson.class.getResourceAsStream(p_language_file_location + p_language + LANGUAGE_FILE_SUFFIX));
	}

	public String getLanguagePropertie(String p_tag)
	{
		return this.properties.getProperty(p_tag);
	}

}
