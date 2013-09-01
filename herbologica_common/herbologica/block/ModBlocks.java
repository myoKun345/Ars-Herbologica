package herbologica.block;

import herbologica.block.crop.BlockHerbologicaBush;
import herbologica.block.fluid.BlockFluidCoffee;
import herbologica.block.fluid.BlockFluidTea;
import herbologica.block.util.ItemBlockHerbologicaBush;
import herbologica.lib.HerbologicaIDs;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

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
	public static Block coffeeFluidBlock;
	public static Block teaFluidBlock;
	
	public static void addBlocks() {
		herbologicaBush = new BlockHerbologicaBush(HerbologicaIDs.BUSH_BLOCK);
		coffeeFluidBlock = new BlockFluidCoffee(HerbologicaIDs.COFFEE_BLOCK);
		teaFluidBlock = new BlockFluidTea(HerbologicaIDs.TEA_BLOCK);
		
		GameRegistry.registerBlock(herbologicaBush, ItemBlockHerbologicaBush.class, "blockBushHerbologica");
		GameRegistry.registerBlock(coffeeFluidBlock, "blockCoffeeFluid");
		GameRegistry.registerBlock(teaFluidBlock, "blockTeaFluid");
	}
}
