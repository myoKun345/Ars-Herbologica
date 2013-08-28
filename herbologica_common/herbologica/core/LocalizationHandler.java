package herbologica.core;

import herbologica.lib.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Ars Herbologica
 * 
 * LocalizationHandler
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LocalizationHandler {
    public static void loadLanguages() {
        for (String localizationFile : Localizations.localeFiles) {
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationUtility.getLocaleFromFileName(localizationFile), LocalizationUtility.isXMLLanguageFile(localizationFile));
        }
    }
}