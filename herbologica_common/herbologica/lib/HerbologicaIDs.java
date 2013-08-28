package herbologica.lib;

import java.util.LinkedList;

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
		
		/* Current IDs */
		public static int BUSH_BLOCK;
		
		/* Config Keys */
		public static final String BUSH_BLOCK_KEY = "BushID";
		
		/* Unlocalized Names */
		public static final LinkedList<String> BUSH_BLOCK_UNLOCALIZED = new LinkedList<String>();
		
	/* Item */
		/* Config Category */
		public static final String ITEM_CONFIG_CATEGORY = "Item IDs and Settings for Ars Herbologica";
		
		/* Default IDs */
		public static final int BERRY_DEFAULT = 14000;
		public static final int FRUIT_DEFAULT = 14001;
		public static final int PLANT_DEFAULT = 14002;
		
		/* Current IDs */
		public static int BERRY;
		public static int FRUIT;
		public static int PLANT;
		
		/* Config Keys */
		public static final String BERRY_KEY = "BerryID";
		public static final String FRUIT_KEY = "FruitID";
		public static final String PLANT_KEY = "PlantID";
		
		/* Unlocalized Names */
		public static final LinkedList<String> BERRY_UNLOCALIZED = new LinkedList<String>();
		public static final LinkedList<String> FRUIT_UNLOCALIZED = new LinkedList<String>();
		public static final LinkedList<String> PLANT_UNLOCALIZED = new LinkedList<String>();
		
	/* API Utility Lists */
	public static final LinkedList<String> BERRY_MOD_ID = new LinkedList<String>();
	public static final LinkedList<String> FRUIT_MOD_ID = new LinkedList<String>();
	public static final LinkedList<String> PLANT_MOD_ID = new LinkedList<String>();
}
