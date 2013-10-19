package herbologica.block.util;

import herbologica.core.HerbologicaIDs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Ars Herbologica
 * 
 * ItemBlockPlant
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlockPlant extends ItemBlock {
	
	public ItemBlockPlant(int par1) {
		super(par1);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "tile." + HerbologicaIDs.PLANT_UNLOCALIZED.get(stack.getItemDamage());
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
}
