package roots.properties;

import java.io.IOException;
import java.util.Properties;

public class PropertiesIO
{

	public static final Properties getPropertie(String resource)
	{
		Properties prop = null;

		try
		{
			ClassLoader loader = ClassLoader.getSystemClassLoader();

			prop = new Properties();

			if (loader != null)
			{
				prop.load(loader.getResourceAsStream(resource));
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}
}
