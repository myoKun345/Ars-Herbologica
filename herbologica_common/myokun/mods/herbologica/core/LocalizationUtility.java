package myokun.mods.herbologica.core;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Ars Herbologica
 * 
 * LocalizationUtility
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LocalizationUtility {
    public static boolean isXMLLanguageFile(String fileName) {

        return fileName.endsWith(".xml");
    }
    
    public static String getLocaleFromFileName(String fileName) {

        return fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
    }

    public static String getLocalizedString(String key) {

        return LanguageRegistry.instance().getStringLocalization(key);
    }
}