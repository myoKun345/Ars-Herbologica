package herbologica.fluid;

import herbologica.block.fluid.BlockFluidCoffee;
import herbologica.core.HerbologicaIDs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * FluidCoffee
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FluidCoffee extends Fluid {
	
	private IconRegister register;
	
	@SideOnly(Side.CLIENT)
	public static Icon flowingIcon;
	
	@SideOnly(Side.CLIENT)
	public static Icon stillIcon;
	
	public FluidCoffee(String name) {
		super(name);
		setBlockID(HerbologicaIDs.COFFEE_BLOCK);
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
		return BlockFluidCoffee.flowingIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getStillIcon() {
		//stillIcon = register.registerIcon(Reference.MOD_ID + ":fluidCoffee_still");
		return BlockFluidCoffee.stillIcon;
	}
}
