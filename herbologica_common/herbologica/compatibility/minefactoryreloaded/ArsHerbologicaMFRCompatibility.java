package herbologica.compatibility.minefactoryreloaded;

import herbologica.compatibility.minefactoryreloaded.fluid.DrinkHandlerCoffee;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;
import powercrystals.minefactoryreloaded.MFRRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * Ars Herbologica
 * 
 * ArsHerbologicaMFRCompatibility
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

@Mod(modid = Reference.MOD_ID + "|CompatMFR", name = Reference.MOD_ID + " Compat: MFR", version = Reference.VERSION, dependencies = "after:ArsHerbologica;after:MineFactoryReloaded")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class ArsHerbologicaMFRCompatibility {
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		if(!Loader.isModLoaded("MineFactoryReloaded")) {
            
            FMLLog.warning("MFR missing - Ars Herbologica MFR Compat not loading");
            return;
            
        } try {
        	
        	MFRRegistry.registerLiquidDrinkHandler(HerbologicaIDs.COFFEE_BLOCK, new DrinkHandlerCoffee());
            
        }
        catch (Exception x)
        {
            x.printStackTrace();
        }
	}

}
