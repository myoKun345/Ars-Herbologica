package herbologica.core;

import java.util.LinkedList;

import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;

/**
 * Ars Herbologica
 * 
 * HerbologicaIDs
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class HerbologicaIDs {
	/* Block */
		/* Config Category */
		public static final String BLOCK_CONFIG_CATEGORY = "Block IDs and Settings for Ars Herbologica";
		
		/* Default IDs */
		public static final int BUSH_BLOCK_DEFAULT = 3400;
		public static final int PLANT_DEFAULT = 3401;
		public static final int COFFEE_BLOCK_DEFAULT = 3450;
		public static final int TEA_BLOCK_DEFAULT = 3451;
		
		/* Current IDs */
		public static int BUSH_BLOCK;
		public static int PLANT;
		public static int COFFEE_BLOCK;
		public static int TEA_BLOCK;
		
		/* Config Keys */
		public static final String BUSH_BLOCK_KEY = "BushID";
		public static final String PLANT_KEY = "PlantID";
		public static final String COFFEE_BLOCK_KEY = "CoffeeID";
		public static final String TEA_BLOCK_KEY = "TeaID";
		
		/* Unlocalized Names */
		public static final LinkedList<String> BUSH_BLOCK_UNLOCALIZED = new LinkedList<String>();
		public static final LinkedList<String> PLANT_UNLOCALIZED = new LinkedList<String>();
		public static final String COFFEE_BLOCK_UNLOCALIZED = "blockFluidCoffee";
		public static final String TEA_BLOCK_UNLOCALIZED = "blockFluidTea";
		
	/* Item */
		/* Config Category */
		public static final String ITEM_CONFIG_CATEGORY = "Item IDs and Settings for Ars Herbologica";
		
		/* Default IDs */
		public static final int BERRY_DEFAULT = 14000;
		public static final int FRUIT_DEFAULT = 14001;
		public static final int VEGETABLE_DEFAULT = 14003;
		public static final int MUG_DEFAULT = 14005;
		
		/* Current IDs */
		public static int BERRY;
		public static int FRUIT;
		public static int VEGETABLE;
		public static int MUG;
		
		/* Config Keys */
		public static final String BERRY_KEY = "BerryID";
		public static final String FRUIT_KEY = "FruitID";
		public static final String VEGETABLE_KEY = "VegetableID";
		public static final String MUG_KEY = "MugID";
		
		/* Unlocalized Names */
		public static final LinkedList<String> BERRY_UNLOCALIZED = new LinkedList<String>();
		public static final LinkedList<String> FRUIT_UNLOCALIZED = new LinkedList<String>();
		public static final LinkedList<String> VEGETABLE_UNLOCALIZED = new LinkedList<String>();
		public static final LinkedList<String> MUG_UNLOCALIZED = new LinkedList<String>();
		
	/* API Utility Lists */
	public static final LinkedList<String> BERRY_MOD_ID = new LinkedList<String>();
	public static final LinkedList<String> FRUIT_MOD_ID = new LinkedList<String>();
	public static final LinkedList<String> PLANT_MOD_ID = new LinkedList<String>();
	public static final LinkedList<String> VEGETABLE_MOD_ID = new LinkedList<String>();
	public static final LinkedList<String> MUG_MOD_ID = new LinkedList<String>();
	public static final LinkedList<Fluid> MUG_FLUID = new LinkedList<Fluid>();
	public static final LinkedList<Potion> MUG_EFFECT = new LinkedList<Potion>();
	public static final LinkedList<Integer> MUG_EFFECT_DURATION = new LinkedList<Integer>();
	public static final LinkedList<Integer> MUG_EFFECT_MULTIPLIER = new LinkedList<Integer>();
}
