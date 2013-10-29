package myokun.mods.herbologica.core;

import myokun.mods.herbologica.api.HerbologicaAPI;
import myokun.mods.herbologica.block.crop.BlockHerbologicaBush;
import myokun.mods.herbologica.block.crop.BlockPlant;
import myokun.mods.herbologica.block.fluid.BlockFluidCoffee;
import myokun.mods.herbologica.block.fluid.BlockFluidTea;
import myokun.mods.herbologica.block.util.ItemBlockHerbologicaBush;
import myokun.mods.herbologica.block.util.ItemBlockPlant;
import myokun.mods.herbologica.fluid.FluidCoffee;
import myokun.mods.herbologica.fluid.FluidTea;
import myokun.mods.herbologica.item.ItemCoffeeMug;
import myokun.mods.herbologica.item.ItemHerbologicaBerry;
import myokun.mods.herbologica.item.ItemHerbologicaFruit;
import myokun.mods.herbologica.item.ItemHerbologicaVegetable;
import myokun.mods.herbologica.tileentity.crop.TileEntityBush;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Ars Herbologica
 * 
 * HerbologicaStuff
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class HerbologicaStuff {
	
	public static Block herbologicaBush;
	public static Block herbologicaPlant;
	public static Block coffeeFluidBlock;
	public static Block teaFluidBlock;
	
	public static void addBlocks() {
		herbologicaBush = new BlockHerbologicaBush(HerbologicaIDs.BUSH_BLOCK);
		herbologicaPlant = new BlockPlant(HerbologicaIDs.PLANT);
		coffeeFluidBlock = new BlockFluidCoffee(HerbologicaIDs.COFFEE_BLOCK);
		teaFluidBlock = new BlockFluidTea(HerbologicaIDs.TEA_BLOCK);
		
		GameRegistry.registerBlock(herbologicaBush, ItemBlockHerbologicaBush.class, "blockBushHerbologica");
		GameRegistry.registerBlock(herbologicaPlant, ItemBlockPlant.class, "blockPlantHerbologica");
		GameRegistry.registerBlock(coffeeFluidBlock, "blockCoffeeFluid");
		GameRegistry.registerBlock(teaFluidBlock, "blockTeaFluid");
	}
	
	public static Item herbologicaBerry;
	public static Item herbologicaFruit;
	public static Item herbologicaVegetable;
	public static Item herbologicaMug;
	
	public static void addItems() {
		herbologicaBerry = new ItemHerbologicaBerry(HerbologicaIDs.BERRY);
		herbologicaFruit = new ItemHerbologicaFruit(HerbologicaIDs.FRUIT);
		herbologicaVegetable = new ItemHerbologicaVegetable(HerbologicaIDs.VEGETABLE);
		herbologicaMug = new ItemCoffeeMug(HerbologicaIDs.MUG);
	}
	
	public static Fluid fluidCoffee;
	public static Fluid fluidTea;
	
	public static void addFluids() {
		fluidCoffee = new FluidCoffee("fluidCoffee");
		fluidTea = new FluidTea("fluidTea");
	}
	
	public static void addTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBush.class, "arsHerbologicaBush");
	}
	
	public static void addBerries() {
		HerbologicaAPI.addBerry("Raspberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Blueberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Cranberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Barberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Bearberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("RedCurrant", Reference.MOD_ID);
		HerbologicaAPI.addBerry("WhiteCurrant", Reference.MOD_ID);
		HerbologicaAPI.addBerry("BlackCurrant", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Elderberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Gooseberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Grape", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Cherry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Strawberry", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Lychee", Reference.MOD_ID);
		HerbologicaAPI.addBerry("Soarynberry", Reference.MOD_ID);
	}
	
	public static void addFruits() {
		HerbologicaAPI.addFruit("Orange", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Banana", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Pomegranate", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Pear", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Lemon", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Lime", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Plum", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Mango", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Apricot", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Peach", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Guava", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Dragonfruit", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Fig", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Grapefruit", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Kiwi", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Kumquat", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Loquat", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Papaya", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Passionfruit", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Pineapple", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Quince", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Rhubarb", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Starfruit", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Tamarind", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Tangerine", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Durian", Reference.MOD_ID);
	}
	
	public static void addPlants() {
		HerbologicaAPI.addPlant("Coffee", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Barley", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Rubber", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Canola", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Vanilla", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Tea", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Enderbloom", Reference.MOD_ID);
	}
	
	public static void addVegetables() {
		HerbologicaAPI.addVegetable("Beet", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("BrusselSprout", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Cabbage", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Celery", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Kale", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Lettuce", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Spinach", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Avocado", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("BellPepper", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Cucumber", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Eggplant", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Squash", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Tomato", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Zucchini", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Artichoke", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Broccoli", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Cauliflower", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Okra", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Pea", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Asparagus", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Garlic", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Leek", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Onion", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Scallion", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Shallot", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("BambooShoot", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Daikon", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Ginger", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Horseradish", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Parsnip", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Radish", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Rutabaga", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("SweetPotato", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Turnip", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Wasabi", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("WaterChestnut", Reference.MOD_ID);
		HerbologicaAPI.addVegetable("Yam", Reference.MOD_ID);
	}
	
}
