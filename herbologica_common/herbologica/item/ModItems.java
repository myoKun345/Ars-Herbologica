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
	public static Item herbologicaFruit;
	public static Item herbologicaPlant;
	public static Item herbologicaVegetable;
	public static Item herbologicaMug;
	
	public static void addItems() {
		herbologicaBerry = new ItemHerbologicaBerry(HerbologicaIDs.BERRY);
		herbologicaFruit = new ItemHerbologicaFruit(HerbologicaIDs.FRUIT);
		herbologicaPlant = new ItemHerbologicaPlant(HerbologicaIDs.PLANT);
		herbologicaVegetable = new ItemHerbologicaVegetable(HerbologicaIDs.VEGETABLE);
		herbologicaMug = new ItemCoffeeMug(HerbologicaIDs.MUG);
	}

}
