package myokun.mods.herbologica.api;

import myokun.mods.herbologica.core.HerbologicaIDs;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;

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
		HerbologicaIDs.PLANT_UNLOCALIZED.add("flower" + name);
		HerbologicaIDs.PLANT_MOD_ID.add(modid);
	}
	
	/**
	 * Adds an edible vegetable item. Restores 4 hunger and 6.0 saturation.
	 * @param name - The name of the vegetable you are going to add; Must not have spaces
	 * @param modid - Your mod id, to be used in the folder to store textures
	 */
	public static void addVegetable(String name, String modid) {
		HerbologicaIDs.VEGETABLE_UNLOCALIZED.add("vegetable" + name);
		HerbologicaIDs.VEGETABLE_MOD_ID.add(modid);
	}
	
	/**
	 * Adds a drinkable fluid to the mug item.
	 * @param name - The name of the drink you are going to add; Must not have spaces
	 * @param fluid - The fluid instance that is being registered.
	 * @param effect - The potion effect, if any, that the drink applies to the player. Put null if you don't want it to do anything.
	 * @param duration - The duration of the potion effect, if any. Put null if you don't want it to do anything.
	 * @param multiplier - The multiplier of the potion effect, if any. Put null if you don't want it to do anything.
	 * @param modid - Your mod id, to be used in the folder to store textures.
	 */
	public static void addMugFluid(String name, Fluid fluid, Potion effect, int duration, int multiplier, String modid) {
		HerbologicaIDs.MUG_UNLOCALIZED.add("mug" + name);
		HerbologicaIDs.MUG_MOD_ID.add(modid);
		HerbologicaIDs.MUG_FLUID.add(fluid);
		HerbologicaIDs.MUG_EFFECT.add(effect);
		HerbologicaIDs.MUG_EFFECT_DURATION.add(duration);
		HerbologicaIDs.MUG_EFFECT_MULTIPLIER.add(multiplier);
	}
	
}
