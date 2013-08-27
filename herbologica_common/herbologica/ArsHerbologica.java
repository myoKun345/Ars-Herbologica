package herbologica;

import java.io.File;

import herbologica.api.BerryHandler;
import herbologica.config.ConfigurationHandler;
import herbologica.core.HerbologicaCreativeTab;
import herbologica.item.ModItems;
import herbologica.lib.Reference;
import herbologica.network.PacketHandler;
import herbologica.proxy.CommonProxy;
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
		
		BerryHandler.addBerry("Raspberry", 2, 4.0F, Reference.MOD_ID);
		BerryHandler.addBerry("Blueberry", 2, 4.5F, Reference.MOD_ID);
		
		ConfigurationHandler.initMain(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_ID + File.separator + Reference.MOD_ID + ".cfg"));
		
		ModItems.addItems();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
