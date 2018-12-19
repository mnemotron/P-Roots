package roots.translation;

import java.util.ArrayList;

import roots.plugin.translation.ITranslation;

public class TranslationListener
{
	private static TranslationListener translationcontroller;

	private ArrayList<ITranslation> list_itranslation;

	private ITranslation.enum_language language;

	public static final TranslationListener getTranslationControllerInstance()
	{
		if (TranslationListener.translationcontroller == null)
		{
			TranslationListener.translationcontroller = new TranslationListener();
		}

		return TranslationListener.translationcontroller;
	}

	private TranslationListener()
	{
		list_itranslation = new ArrayList<ITranslation>();

		language = ITranslation.enum_language.en;
	}

	public void addTranslationListener(ITranslation p_itranslation)
	{
		this.list_itranslation.add(p_itranslation);
	}

	public void removeTranslationListener(ITranslation p_itranslation)
	{
		this.list_itranslation.remove(p_itranslation);
	}

	public void runTranslationListener()
	{
		for (ITranslation itranslation : this.list_itranslation)
		{
			itranslation.do_translation(this.language);
		}
	}

	public void setLanguage(ITranslation.enum_language p_itranslation)
	{
		this.language = p_itranslation;
	}

	public ITranslation.enum_language getLanguage()
	{
		return language;
	}
}
