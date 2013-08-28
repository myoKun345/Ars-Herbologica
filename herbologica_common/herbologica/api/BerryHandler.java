package herbologica.api;

import herbologica.lib.HerbologicaIDs;

/**
 * Ars Herbologica
 * 
 * BerryHandler
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BerryHandler {
	
	public static void addBerry(String name, int hunger, float saturation, String modid) {
		HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.add("blockBush" + name);
		HerbologicaIDs.BERRY_UNLOCALIZED.add("berry" + name);
		HerbologicaIDs.BERRY_HUNGER_VALUE.add(hunger);
		HerbologicaIDs.BERRY_SATURATION_VALUE.add(saturation);
		HerbologicaIDs.BERRY_MOD_ID.add(modid);
	}
	
}
