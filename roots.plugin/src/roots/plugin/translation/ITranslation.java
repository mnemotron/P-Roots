package roots.plugin.translation;

public interface ITranslation
{
	public static enum enum_language
	{
		de, // German
		en  // English
	}

	public void do_translation(ITranslation.enum_language p_language);
}
