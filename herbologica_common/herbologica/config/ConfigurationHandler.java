package herbologica.config;

import herbologica.lib.HerbologicaIDs;

import java.io.File;

import net.minecraftforge.common.Configuration;

/**
 * Ars Herbologica
 * 
 * ConfigurationHandler
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigurationHandler {
	
	public static void initMain(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		HerbologicaIDs.BUSH_BLOCK = config.getBlock(HerbologicaIDs.BLOCK_CONFIG_CATEGORY, HerbologicaIDs.BUSH_BLOCK_KEY, HerbologicaIDs.BUSH_BLOCK_DEFAULT).getInt();
		
		HerbologicaIDs.BERRY = config.getItem(HerbologicaIDs.ITEM_CONFIG_CATEGORY, HerbologicaIDs.BERRY_KEY, HerbologicaIDs.BERRY_DEFAULT).getInt();
		
		config.save();
	}

}
