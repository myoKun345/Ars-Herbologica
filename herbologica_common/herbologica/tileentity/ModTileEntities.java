package herbologica.tileentity;

import herbologica.tileentity.crop.TileEntityBush;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Ars Herbologica
 * 
 * ModTileEntities
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModTileEntities {
	
	public static void addTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBush.class, "arsHerbologicaBush");
	}

}
