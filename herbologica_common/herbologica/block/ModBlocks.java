package herbologica.block;

import cpw.mods.fml.common.registry.GameRegistry;
import herbologica.block.crop.BlockHerbologicaBush;
import herbologica.block.util.ItemBlockHerbologicaBush;
import herbologica.lib.HerbologicaIDs;
import net.minecraft.block.Block;

/**
 * Ars Herbologica
 * 
 * ModBlocks
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModBlocks {
	public static Block herbologicaBush;
	
	public static void addBlocks() {
		herbologicaBush = new BlockHerbologicaBush(HerbologicaIDs.BUSH_BLOCK);
		
		GameRegistry.registerBlock(herbologicaBush, ItemBlockHerbologicaBush.class, "blockBushHerbologica");
	}
}
