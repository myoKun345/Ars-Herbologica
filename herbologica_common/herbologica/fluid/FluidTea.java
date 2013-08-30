package herbologica.fluid;

import herbologica.block.fluid.BlockFluidTea;
import herbologica.lib.HerbologicaIDs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * FluidTea
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FluidTea extends Fluid {
	
private IconRegister register;
	
	@SideOnly(Side.CLIENT)
	public static Icon flowingIcon;
	
	@SideOnly(Side.CLIENT)
	public static Icon stillIcon;
	
	public FluidTea(String name) {
		super(name);
		setBlockID(HerbologicaIDs.TEA_BLOCK);
		FluidRegistry.registerFluid(this);
	}
	
	@Override
	public String getUnlocalizedName() {
		return "fluid." + this.fluidName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getFlowingIcon() {
		//flowingIcon = register.registerIcon(Reference.MOD_ID + ":fluidCoffee_flow");
		return BlockFluidTea.flowingIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getStillIcon() {
		//stillIcon = register.registerIcon(Reference.MOD_ID + ":fluidCoffee_still");
		return BlockFluidTea.stillIcon;
	}

}
