package herbologica.item;

import herbologica.ArsHerbologica;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;

import java.awt.List;

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
 * ItemHerbologicaBerry
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemHerbologicaBerry extends ItemFood {
	
	@SideOnly(Side.CLIENT)
	private static Icon[] icons;
	
	public ItemHerbologicaBerry(int id, int hunger, float saturation) {
		super(id - Reference.ITEM_ID_CORRECTION, hunger, saturation, true);
		setCreativeTab(ArsHerbologica.herbologicaTab);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + HerbologicaIDs.BERRY_UNLOCALIZED.get(stack.getItemDamage());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[HerbologicaIDs.BERRY_UNLOCALIZED.size()];
		for (int i = 0; i < HerbologicaIDs.BERRY_UNLOCALIZED.size(); i++) {
			icons[i] = register.registerIcon(Reference.MOD_ID + ":" + HerbologicaIDs.BERRY_UNLOCALIZED.get(i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < HerbologicaIDs.BERRY_UNLOCALIZED.size(); i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}

}
