package herbologica.block.crop;

import herbologica.ArsHerbologica;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Ars Herbologica
 * 
 * BlockHerbologicaBush
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockHerbologicaBush extends BlockLeavesBase implements IPlantable {
	
	@SideOnly(Side.CLIENT)
    private Icon[] icons;
	
	public BlockHerbologicaBush(int id) {
		super(id, Material.leaves, false);
		setCreativeTab(ArsHerbologica.herbologicaTab);
		setStepSound(Block.soundGrassFootstep);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        icons = new Icon[HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.size()];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = register.registerIcon(Reference.MOD_ID + ":" + HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.get(i));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return icons[meta];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs tab, List list) {
        for (int i = 0; i < HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.size(); i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
    
    @Override
    public int damageDropped(int meta) {
        return meta;
    }
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}
	
	@Override
	public int getPlantID(World world, int x, int y, int z) {
		return this.blockID;
	}
	
	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

}
