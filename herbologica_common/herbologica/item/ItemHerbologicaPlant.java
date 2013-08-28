package herbologica.item;

import java.util.List;

import herbologica.ArsHerbologica;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * ItemHerbologicaPlant
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemHerbologicaPlant extends Item {
	
	@SideOnly(Side.CLIENT)
    private Icon[] icons;
	
	public ItemHerbologicaPlant(int par1) {
		super(par1 - Reference.ITEM_ID_CORRECTION);
		setCreativeTab(ArsHerbologica.herbologicaTab);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + HerbologicaIDs.PLANT_UNLOCALIZED.get(stack.getItemDamage());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[HerbologicaIDs.PLANT_UNLOCALIZED.size()];
		for (int i = 0; i < HerbologicaIDs.PLANT_UNLOCALIZED.size(); i++) {
			icons[i] = register.registerIcon(HerbologicaIDs.PLANT_MOD_ID.get(i) + ":" + HerbologicaIDs.PLANT_UNLOCALIZED.get(i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < HerbologicaIDs.PLANT_UNLOCALIZED.size(); i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
	
}
