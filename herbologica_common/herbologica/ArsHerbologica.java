package herbologica;

import herbologica.api.HerbologicaAPI;
import herbologica.block.ModBlocks;
import herbologica.config.ConfigurationHandler;
import herbologica.core.HerbologicaCreativeTab;
import herbologica.core.LocalizationHandler;
import herbologica.item.ModItems;
import herbologica.lib.Reference;
import herbologica.network.PacketHandler;
import herbologica.proxy.CommonProxy;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
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
@NetworkMod(channels = {Reference.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class ArsHerbologica {
	@Instance(Reference.MOD_ID)
	public static ArsHerbologica instance;
	
	@SidedProxy(clientSide = "herbologica.proxy.ClientProxy", serverSide = "herbologica.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	public static CreativeTabs herbologicaTab = new HerbologicaCreativeTab(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
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
		HerbologicaAPI.addBerry("Soarynberry", Reference.MOD_ID);
		
		HerbologicaAPI.addFruit("Orange", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Banana", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Pomegranate", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Pear", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Lemon", Reference.MOD_ID);
		HerbologicaAPI.addFruit("Lime", Reference.MOD_ID);
		
		HerbologicaAPI.addPlant("Coffee", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Barley", Reference.MOD_ID);
		HerbologicaAPI.addPlant("Rubber", Reference.MOD_ID);
		
		LocalizationHandler.loadLanguages();
		
		ConfigurationHandler.initMain(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_ID + File.separator + Reference.MOD_ID + ".cfg"));
		
		ModItems.addItems();
		
		ModBlocks.addBlocks();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
