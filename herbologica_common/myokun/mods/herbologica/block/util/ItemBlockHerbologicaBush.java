package myokun.mods.herbologica.block.util;

import myokun.mods.herbologica.core.HerbologicaIDs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Ars Herbologica
 * 
 * ItemBlockHerbologicaBush
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlockHerbologicaBush extends ItemBlock {
	
	public ItemBlockHerbologicaBush(int par1) {
		super(par1);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "tile." + HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.get(stack.getItemDamage());
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}

}
