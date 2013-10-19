package herbologica;

import herbologica.api.HerbologicaAPI;
import herbologica.core.CommonProxy;
import herbologica.core.ConfigurationHandler;
import herbologica.core.HerbologicaCreativeTab;
import herbologica.core.HerbologicaIDs;
import herbologica.core.HerbologicaStuff;
import herbologica.core.LocalizationHandler;
import herbologica.core.LogHelper;
import herbologica.core.PacketHandler;
import herbologica.core.Reference;

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
	
	@SidedProxy(clientSide = "herbologica.core.ClientProxy", serverSide = "herbologica.core.CommonProxy")
    public static CommonProxy proxy;
	
	public static CreativeTabs herbologicaTab = new HerbologicaCreativeTab(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		LogHelper.init();
		
		HerbologicaIDs.MUG_UNLOCALIZED.add("mugEmpty");
		
		HerbologicaStuff.addBerries();
		
		HerbologicaStuff.addFruits();
		
		HerbologicaStuff.addPlants();
		
		HerbologicaStuff.addVegetables();
		
		LocalizationHandler.loadLanguages();
		
		ConfigurationHandler.initMain(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_ID + File.separator + Reference.MOD_ID + ".cfg"));
		
		HerbologicaStuff.addTileEntities();
		
		HerbologicaStuff.addFluids();
		
		HerbologicaAPI.addMugFluid("Coffee", HerbologicaStuff.fluidCoffee, Potion.moveSpeed, 1200, 1, Reference.MOD_ID);
		HerbologicaAPI.addMugFluid("Tea", HerbologicaStuff.fluidTea, Potion.moveSpeed, 800, 0, Reference.MOD_ID);
		
		HerbologicaStuff.addItems();
		
		HerbologicaStuff.addBlocks();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.registerRender();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
