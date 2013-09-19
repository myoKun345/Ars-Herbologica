package herbologica;

import herbologica.api.HerbologicaAPI;
import herbologica.block.ModBlocks;
import herbologica.config.ConfigurationHandler;
import herbologica.core.HerbologicaCreativeTab;
import herbologica.core.LocalizationHandler;
import herbologica.core.LogHelper;
import herbologica.fluid.ModFluids;
import herbologica.item.ModItems;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;
import herbologica.network.PacketHandler;
import herbologica.proxy.CommonProxy;
import herbologica.tileentity.ModTileEntities;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * Ars Herbologica
 * 
 * ArsHerbologica
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = {Reference.BUSH_CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class ArsHerbologica {
	@Instance(Reference.MOD_ID)
	public static ArsHerbologica instance;
	
	@SidedProxy(clientSide = "herbologica.proxy.ClientProxy", serverSide = "herbologica.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	public static CreativeTabs herbologicaTab = new HerbologicaCreativeTab(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		LogHelper.init();
		
		HerbologicaIDs.MUG_UNLOCALIZED.add("mugEmpty");
		
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
		
		HerbologicaAPI.addPlant("Coffee", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Barley", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Rubber", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Canola", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Vanilla", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Tea", Reference.MOD_ID);
		
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
		
		LocalizationHandler.loadLanguages();
		
		ConfigurationHandler.initMain(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_ID + File.separator + Reference.MOD_ID + ".cfg"));
		
		ModTileEntities.addTileEntities();
		
		ModFluids.addFluids();
		
		HerbologicaAPI.addMugFluid("Coffee", ModFluids.fluidCoffee, Potion.moveSpeed, 1200, 1, Reference.MOD_ID);
		HerbologicaAPI.addMugFluid("Tea", ModFluids.fluidTea, Potion.moveSpeed, 800, 0, Reference.MOD_ID);
		
		ModItems.addItems();
		
		ModBlocks.addBlocks();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.registerRender();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
