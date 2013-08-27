package herbologica.item;

import herbologica.lib.HerbologicaIDs;
import net.minecraft.item.Item;

/**
 * Ars Herbologica
 * 
 * ModItems
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModItems {
	public static Item herbologicaBerry;
	
	public static void addItems() {
		herbologicaBerry = new ItemHerbologicaBerry(HerbologicaIDs.BERRY, 3, 3.0F);
	}

}
