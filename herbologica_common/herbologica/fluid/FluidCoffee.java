package herbologica.fluid;

import herbologica.block.ModBlocks;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;
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
		return "fluid." + HerbologicaIDs.COFFEE_BLOCK_UNLOCALIZED;
	}
	
	@Override
	public Icon getFlowingIcon() {
		flowingIcon = register.registerIcon(Reference.MOD_ID + ":" + this.fluidName + "_flow");
		return flowingIcon;
	}
	
	@Override
	public Icon getStillIcon() {
		stillIcon = register.registerIcon(Reference.MOD_ID + ":" + this.fluidName + "_still");
		return stillIcon;
	}
}
