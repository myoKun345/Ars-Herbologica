package myokun.mods.herbologica.item;

import java.util.List;

import myokun.mods.herbologica.ArsHerbologica;
import myokun.mods.herbologica.core.HerbologicaIDs;
import myokun.mods.herbologica.core.HerbologicaStuff;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ItemFluidContainer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * ItemCoffeeMug
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemCoffeeMug extends ItemFluidContainer {
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemCoffeeMug(int itemID) {
		super(itemID, 500);
		setCreativeTab(ArsHerbologica.herbologicaTab);
		setMaxStackSize(1);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + HerbologicaIDs.MUG_UNLOCALIZED.get(stack.getItemDamage());
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < HerbologicaIDs.MUG_UNLOCALIZED.size(); i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
	
	@Override
	public int fill(ItemStack container, net.minecraftforge.fluids.FluidStack resource, boolean doFill) {
		if (resource == null) {
            return 0;
        }

        if (!doFill) {
            if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Fluid")) {
                return Math.min(capacity, resource.amount);
            }

            FluidStack stack = FluidStack.loadFluidStackFromNBT(container.stackTagCompound.getCompoundTag("Fluid"));

            if (stack == null)
            {
                return Math.min(capacity, resource.amount);
            }

            if (!stack.isFluidEqual(resource))
            {
                return 0;
            }

            return Math.min(capacity - stack.amount, resource.amount);
        }

        if (container.stackTagCompound == null)
        {
            container.stackTagCompound = new NBTTagCompound();
        }

        if (!container.stackTagCompound.hasKey("Fluid"))
        {
            NBTTagCompound fluidTag = resource.writeToNBT(new NBTTagCompound());

            if (capacity < resource.amount)
            {
                fluidTag.setInteger("Amount", capacity);
                container.stackTagCompound.setTag("Fluid", fluidTag);
                return capacity;
            }

            container.stackTagCompound.setTag("Fluid", fluidTag);
            return resource.amount;
        }

        NBTTagCompound fluidTag = container.stackTagCompound.getCompoundTag("Fluid");
        FluidStack stack = FluidStack.loadFluidStackFromNBT(fluidTag);

        if (!stack.isFluidEqual(resource))
        {
            return 0;
        }

        int filled = capacity - resource.amount;
        if (resource.amount < filled)
        {
            stack.amount += resource.amount;
            filled = resource.amount;
        }
        else
        {
            stack.amount = capacity;
        }

        container.stackTagCompound.setTag("Fluid", stack.writeToNBT(fluidTag));
        return filled;
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (stack.getItemDamage() != 0) {
			if (!player.capabilities.isCreativeMode) {
				--stack.stackSize;
				this.drain(stack, capacity, true);
				if (!world.isRemote) {
					player.addPotionEffect(new PotionEffect(HerbologicaIDs.MUG_EFFECT.get(stack.getItemDamage() - 1).getId(), HerbologicaIDs.MUG_EFFECT_DURATION.get(stack.getItemDamage() - 1), HerbologicaIDs.MUG_EFFECT_MULTIPLIER.get(stack.getItemDamage() - 1)));
				}
			}
		}
		return stack.stackSize <= 0 ? new ItemStack(HerbologicaStuff.herbologicaMug, 1, 0) : stack;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 32;
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
        if (stack.getItemDamage() != 0) {
			return EnumAction.drink;
		}
        else {
        	return EnumAction.none;
        }
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

}
