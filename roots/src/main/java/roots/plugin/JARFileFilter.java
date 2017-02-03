package roots.plugin;

import java.io.File;
import java.io.FileFilter;

public class JARFileFilter implements FileFilter
{
	private static final String c_jarfile = ".jar";

	@Override
	public boolean accept(File f)
	{
		return f.getName().toLowerCase().endsWith(JARFileFilter.c_jarfile);
	}

}
