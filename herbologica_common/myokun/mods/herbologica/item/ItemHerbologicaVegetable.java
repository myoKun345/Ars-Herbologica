package myokun.mods.herbologica.item;

import java.util.List;

import myokun.mods.herbologica.ArsHerbologica;
import myokun.mods.herbologica.core.HerbologicaIDs;
import myokun.mods.herbologica.core.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * ItemHerbologicaVegetable
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemHerbologicaVegetable extends ItemFood {
	
	@SideOnly(Side.CLIENT)
	private static Icon[] icons;
	
	public ItemHerbologicaVegetable(int id) {
		super(id - Reference.ITEM_ID_CORRECTION, 4, 6.0F, true);
		setCreativeTab(ArsHerbologica.herbologicaTab);
		setHasSubtypes(true);
	}
	
	@Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + HerbologicaIDs.VEGETABLE_UNLOCALIZED.get(stack.getItemDamage());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[HerbologicaIDs.VEGETABLE_UNLOCALIZED.size()];
		for (int i = 0; i < HerbologicaIDs.VEGETABLE_UNLOCALIZED.size(); i++) {
			icons[i] = register.registerIcon(HerbologicaIDs.VEGETABLE_MOD_ID.get(i) + ":" + HerbologicaIDs.VEGETABLE_UNLOCALIZED.get(i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < HerbologicaIDs.VEGETABLE_UNLOCALIZED.size(); i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}


}
