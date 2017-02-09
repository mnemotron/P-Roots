package roots.plugin;

import java.io.File;
import java.io.FileFilter;

public class JARFileFilter implements FileFilter
{
	private static final String FILE_JAR = ".jar";

	@Override
	public boolean accept(File f)
	{
		return f.getName().toLowerCase().endsWith(JARFileFilter.FILE_JAR);
	}

}
