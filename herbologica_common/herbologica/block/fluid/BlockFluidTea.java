package herbologica.block.fluid;

import herbologica.fluid.ModFluids;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.BlockFluidClassic;

/**
 * Ars Herbologica
 * 
 * BlockFluidTea
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockFluidTea extends BlockFluidClassic {
	
	@SideOnly(Side.CLIENT)
	public static Icon flowingIcon;
	
	@SideOnly(Side.CLIENT)
	public static Icon stillIcon;
	
	public BlockFluidTea(int id) {
		super(id, ModFluids.fluidTea, Material.water);
	}
	
	@Override
	public String getUnlocalizedName() {
		return "tile." + HerbologicaIDs.TEA_BLOCK_UNLOCALIZED;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		flowingIcon = register.registerIcon(Reference.MOD_ID + ":" + this.fluidName + "_flow");
		stillIcon = register.registerIcon(Reference.MOD_ID + ":" + this.fluidName + "_still");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (meta == 0) {
			return stillIcon;
		}
		else {
			return flowingIcon;
		}
	}

}