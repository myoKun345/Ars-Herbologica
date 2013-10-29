package myokun.mods.herbologica.item;

import java.util.List;

import myokun.mods.herbologica.ArsHerbologica;
import myokun.mods.herbologica.core.HerbologicaIDs;
import myokun.mods.herbologica.core.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
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
	
	public ItemHerbologicaBerry(int id) {
		super(id - Reference.ITEM_ID_CORRECTION, 2, 4.0F, true);
		setCreativeTab(ArsHerbologica.herbologicaTab);
		setHasSubtypes(true);
		setAlwaysEdible();
	}
	
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
        if (player.canEat(true) && player.getFoodStats().getSaturationLevel() < 18F) {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }

        return stack;
    }
	
	@Override
    public int getMaxItemUseDuration (ItemStack stack) {
        return 16;
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
			icons[i] = register.registerIcon(HerbologicaIDs.BERRY_MOD_ID.get(i) + ":" + HerbologicaIDs.BERRY_UNLOCALIZED.get(i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < HerbologicaIDs.BERRY_UNLOCALIZED.size(); i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}

}
