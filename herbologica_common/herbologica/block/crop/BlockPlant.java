package herbologica.block.crop;

import herbologica.core.HerbologicaIDs;
import herbologica.core.LogHelper;
import herbologica.core.Reference;

import java.util.List;
import java.util.logging.Level;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * BlockPlant
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockPlant extends BlockFlower {
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public BlockPlant(int par1) {
		super(par1);
		
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		switch (world.getBlockMetadata(x, y, z)) {
		case 0:
			return AxisAlignedBB.getBoundingBox((double) x + 0.25D, (double) y + 0.0D, (double) z + 0.25D, (double) x + 0.75D, (double) y + 0.6D, (double) z + 0.75D);
		case 1:
			return AxisAlignedBB.getBoundingBox((double) x + 0.1D, (double) y + 0.0D, (double) z + 0.1D, (double) x + 0.9D, (double) y + 0.9D, (double) z + 0.9D);
		case 2:
			return AxisAlignedBB.getBoundingBox((double) x + 0.2D, (double) y + 0.0D, (double) z + 0.2D, (double) x + 0.8D, (double) y + 0.9D, (double) z + 0.8D);
		case 3:
			return AxisAlignedBB.getBoundingBox((double) x + 0.1D, (double) y + 0.0D, (double) z + 0.1D, (double) x + 0.9D, (double) y + 0.9D, (double) z + 0.9D);
		case 4:
			return AxisAlignedBB.getBoundingBox((double) x + 0.3D, (double) y + 0.0D, (double) z + 0.3D, (double) x + 0.7D, (double) y + 0.75D, (double) z + 0.7D);
		default:
			return super.getSelectedBoundingBoxFromPool(world, x, y, z);
		}
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		
		if (meta == 0) {
			setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.6F, 0.75F);
		}
		if (meta == 1) {
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.9F, 0.9F);
		}
		if (meta == 2) {
			setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.9F, 0.8F);
		}
		if (meta == 3) {
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.9F, 0.9F);
		}
		if (meta == 4) {
			setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.75F, 0.7F);
		}
		else {
			setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.6F, 0.7F);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		
		icons = new Icon[HerbologicaIDs.PLANT_UNLOCALIZED.size()];
		for (int i = 0; i < HerbologicaIDs.PLANT_UNLOCALIZED.size(); i++) {
			icons[i] = register.registerIcon(Reference.MOD_ID + ":" + HerbologicaIDs.PLANT_UNLOCALIZED.get(i));
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return this.getIcon(par5, par1IBlockAccess.getBlockMetadata(par2, par3, par4));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return icons[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < HerbologicaIDs.PLANT_UNLOCALIZED.size(); i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}

}
