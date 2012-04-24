package org.moreunit.core.preferences;

public class LanguagePreferencesWriter extends LanguagePreferences
{
    public LanguagePreferencesWriter(String languageId, WriteablePreferences parentPreferences)
    {
        super(languageId, parentPreferences);
    }

    @Override
    public String getFileWordSeparator()
    {
        return getString(LanguagePreferences.FILE_WORD_SEPARATOR);
    }

    @Override
    public String getTestFileNameTemplate()
    {
        return getString(LanguagePreferences.TEST_FILE_NAME_TEMPLATE);
    }

    public void setTestFileNameTemplate(String template, String separator)
    {
        setValue(TEST_FILE_NAME_TEMPLATE, template);
        setValue(FILE_WORD_SEPARATOR, separator);
    }

    public boolean isActive()
    {
        return parentPreferences.hasPreferencesForLanguage(languageId);
    }

    public void setActive(boolean active)
    {
        parentPreferences.activatePreferencesForLanguage(languageId, active);
    }
}
