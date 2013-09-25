package herbologica.block.crop;

import herbologica.tileentity.crop.TileEntityVegetable;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Ars Herbologica
 * 
 * BlockVegetableCrop
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockVegetableCrop extends BlockCrops implements ITileEntityProvider {
	
	public BlockVegetableCrop(int par1) {
		super(par1);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityVegetable();
	}
	
}
