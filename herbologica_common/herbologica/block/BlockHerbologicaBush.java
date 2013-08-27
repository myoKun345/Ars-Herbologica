package herbologica.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Ars Herbologica
 * 
 * BlockHerbologicaBush
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockHerbologicaBush extends Block {
	
	public BlockHerbologicaBush(int id) {
		super(id, Material.leaves);
		setStepSound(Block.soundGrassFootstep);
	}

}
