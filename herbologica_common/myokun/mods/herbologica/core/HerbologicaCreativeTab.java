package myokun.mods.herbologica.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * HerbologicaCreativeTab
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class HerbologicaCreativeTab extends CreativeTabs {
	
	public HerbologicaCreativeTab(int id, String name) {
		super(id, name);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return Block.leaves.blockID;
    }
	
}
