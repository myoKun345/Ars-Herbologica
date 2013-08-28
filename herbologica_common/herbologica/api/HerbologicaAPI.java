package herbologica.api;

import herbologica.lib.HerbologicaIDs;

/**
 * Ars Herbologica
 * 
 * HerbologicaAPI
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class HerbologicaAPI {
	
	
	/**
	 * Adds an edible berry item. Restores 2 hunger and 4.0 saturation.
	 * @param name - The name of the berry you are going to add; Must not have spaces
	 * @param modid - Your mod id, to be used in the folder to store textures
	 */
	public static void addBerry(String name, String modid) {
		HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.add("blockBush" + name);
		HerbologicaIDs.BERRY_UNLOCALIZED.add("berry" + name);
		HerbologicaIDs.BERRY_MOD_ID.add(modid);
	}
	
	/**
	 * Adds an edible fruit item. Restores 4 hunger and 3.0 saturation.
	 * @param name - The name of the fruit you are going to add; Must not have spaces
	 * @param modid - Your mod id, to be used in the folder to store textures
	 */
	public static void addFruit(String name, String modid) {
		HerbologicaIDs.FRUIT_UNLOCALIZED.add("fruit" + name);
		HerbologicaIDs.FRUIT_MOD_ID.add(modid);
	}
	
	/**
	 * Adds a non-edible plant item.
	 * @param name - The name of the plant you are going to add; Must not have spaces
	 * @param modid - Your mod id, to be used in the folder to store textures
	 */
	public static void addPlant(String name, String modid) {
		HerbologicaIDs.PLANT_UNLOCALIZED.add("plant" + name);
		HerbologicaIDs.PLANT_MOD_ID.add(modid);
	}
	
}
