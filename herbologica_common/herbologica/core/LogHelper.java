package herbologica.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

/**
 * Ars Herbologica
 * 
 * LogHelper
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LogHelper {
	private static Logger herbologicaLogger = Logger.getLogger(Reference.MOD_ID);
    
    public static void init() {
        herbologicaLogger.setParent(FMLLog.getLogger());
    }
    
    public static void log(Level logLevel, String message) {
        herbologicaLogger.log(logLevel, message);
    }
}
