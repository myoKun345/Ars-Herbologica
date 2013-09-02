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
		HerbologicaIDs.COFFEE_BLOCK = config.getBlock(HerbologicaIDs.BLOCK_CONFIG_CATEGORY, HerbologicaIDs.COFFEE_BLOCK_KEY, HerbologicaIDs.COFFEE_BLOCK_DEFAULT).getInt();
		HerbologicaIDs.TEA_BLOCK = config.getBlock(HerbologicaIDs.BLOCK_CONFIG_CATEGORY, HerbologicaIDs.TEA_BLOCK_KEY, HerbologicaIDs.TEA_BLOCK_DEFAULT).getInt();
		
		HerbologicaIDs.BERRY = config.getItem(HerbologicaIDs.ITEM_CONFIG_CATEGORY, HerbologicaIDs.BERRY_KEY, HerbologicaIDs.BERRY_DEFAULT).getInt();
		HerbologicaIDs.FRUIT = config.getItem(HerbologicaIDs.ITEM_CONFIG_CATEGORY, HerbologicaIDs.FRUIT_KEY, HerbologicaIDs.FRUIT_DEFAULT).getInt();
		HerbologicaIDs.PLANT = config.getItem(HerbologicaIDs.ITEM_CONFIG_CATEGORY, HerbologicaIDs.PLANT_KEY, HerbologicaIDs.PLANT_DEFAULT).getInt();
		HerbologicaIDs.VEGETABLE = config.getItem(HerbologicaIDs.ITEM_CONFIG_CATEGORY, HerbologicaIDs.VEGETABLE_KEY, HerbologicaIDs.VEGETABLE_DEFAULT).getInt();
		HerbologicaIDs.MUG = config.getItem(HerbologicaIDs.ITEM_CONFIG_CATEGORY, HerbologicaIDs.MUG_KEY, HerbologicaIDs.MUG_DEFAULT).getInt();
		
		config.save();
	}

}
