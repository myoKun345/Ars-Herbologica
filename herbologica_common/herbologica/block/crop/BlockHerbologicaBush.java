package herbologica.block.crop;

import herbologica.ArsHerbologica;
import herbologica.core.LogHelper;
import herbologica.item.ModItems;
import herbologica.lib.HerbologicaIDs;
import herbologica.lib.Reference;
import herbologica.render.BushRender;
import herbologica.tileentity.crop.TileEntityBush;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.FakePlayer;
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
public class BlockHerbologicaBush extends BlockLeavesBase implements IPlantable,ITileEntityProvider {
	
	@SideOnly(Side.CLIENT)
    private Icon[] fastIcons;
	@SideOnly(Side.CLIENT)
	private Icon[] fancyIcons;
	private Random random;
	
	private World worldClient;
	private World worldServer;
	
	public BlockHerbologicaBush(int id) {
		super(id, Material.leaves, false);
		setCreativeTab(ArsHerbologica.herbologicaTab);
		setStepSound(Block.soundGrassFootstep);
		setTickRandomly(true);
		setHardness(0.3F);
		random = new Random();
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        fastIcons = new Icon[HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.size()];
        fancyIcons = new Icon[HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.size()];
        for (int i = 0; i < fastIcons.length; i++) {
            fastIcons[i] = register.registerIcon(Reference.MOD_ID + ":" + HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.get(i) + "_fast");
            fancyIcons[i] = register.registerIcon(Reference.MOD_ID + ":" + HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.get(i) + "_fancy");
        }
    }
    
	@Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
        if (graphicsLevel) {
            return fancyIcons[metadata];
        }
        else {
            return fancyIcons[metadata];
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs tab, List list) {
        for (int i = 0; i < HerbologicaIDs.BUSH_BLOCK_UNLOCALIZED.size(); i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
    	
        TileEntityBush tileentity = (TileEntityBush)world.getBlockTileEntity(x, y, z);
        
        //LogHelper.log(Level.INFO, "GCBBFP Stage: " + tileentity.growthStage);
        
        if (tileentity == null) {
        	return AxisAlignedBB.getBoundingBox((double) x + 0.25D, y, (double) z + 0.25D, (double) x + 0.75D, (double) y + 0.5D, (double) z + 0.75D);
        }
        if (tileentity.growthStage < 4) {
            return AxisAlignedBB.getBoundingBox((double) x + 0.25D, y, (double) z + 0.25D, (double) x + 0.75D, (double) y + 0.5D, (double) z + 0.75D);
        }
        else if (tileentity.growthStage < 8) {
            return AxisAlignedBB.getBoundingBox((double) x + 0.125D, y, (double) z + 0.125D, (double) x + 0.875D, (double) y + 0.75D, (double) z + 0.875D);
        }
        else {
            return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D);
        }
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
    	
        TileEntityBush tileentity = (TileEntityBush)world.getBlockTileEntity(x, y, z);
        
        //LogHelper.log(Level.INFO, "GSBBFP Stage: " + tileentity.growthStage);
        
        if (tileentity == null) {
        	return AxisAlignedBB.getBoundingBox((double) x + 0.25D, y, (double) z + 0.25D, (double) x + 0.75D, (double) y + 0.5D, (double) z + 0.75D);
        }
        if (tileentity.growthStage < 4) {
            return AxisAlignedBB.getBoundingBox((double) x + 0.25D, y, (double) z + 0.25D, (double) x + 0.75D, (double) y + 0.5D, (double) z + 0.75D);
        }
        else if (tileentity.growthStage < 8) {
            return AxisAlignedBB.getBoundingBox((double) x + 0.125D, y, (double) z + 0.125D, (double) x + 0.875D, (double) y + 0.75D, (double) z + 0.875D);
        }
        else {
            return AxisAlignedBB.getBoundingBox(x, y, z, (double) x + 1.0D, (double) y + 1.0D, (double) z + 1.0D);
        }
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
    	float minX;
        float minY = 0F;
        float minZ;
        float maxX;
        float maxY;
        float maxZ;
    	
    	if (worldClient != null) {
    		TileEntityBush teClient = (TileEntityBush)worldClient.getBlockTileEntity(x, y, z);
    		
    		if (teClient != null) {
				if (teClient.growthStage < 4) {
					minX = minZ = 0.25F;
					maxX = maxZ = 0.75F;
					maxY = 0.5F;
				} 
				else 
				if (teClient.growthStage < 8) {
					minX = minZ = 0.125F;
					maxX = maxZ = 0.875F;
					maxY = 0.75F;
				} 
				else {
					minX = minZ = 0.0F;
					maxX = maxZ = 1.0F;
					maxY = 1.0F;
				}
			}
    		else {
    			minX = minZ = 0.25F;
				maxX = maxZ = 0.75F;
				maxY = 0.5F;
			}
    	}
    	if (worldServer != null) {
    		TileEntityBush teServer = (TileEntityBush)worldServer.getBlockTileEntity(x, y, z);
    		
    		if (teServer != null) {
				if (teServer.growthStage < 4) {
					minX = minZ = 0.25F;
					maxX = maxZ = 0.75F;
					maxY = 0.5F;
				} 
				else 
				if (teServer.growthStage < 8) {
					minX = minZ = 0.125F;
					maxX = maxZ = 0.875F;
					maxY = 0.75F;
				} 
				else {
					minX = minZ = 0.0F;
					maxX = maxZ = 1.0F;
					maxY = 1.0F;
				}
			}
    		else {
    			minX = minZ = 0.25F;
				maxX = maxZ = 0.75F;
				maxY = 0.5F;
			}
    	}
    	else {
    		minX = minZ = 0.25F;
            maxX = maxZ = 0.75F;
            maxY = 0.5F;
    	}
    	
        setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        
    }
    
    @Override
    public int damageDropped(int meta) {
        return meta;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float j, float k, float l) {
    	TileEntityBush te = (TileEntityBush)world.getBlockTileEntity(x, y, z);
    	TileEntityBush teClient = (TileEntityBush)worldClient.getBlockTileEntity(x, y, z);
    	int meta = world.getBlockMetadata(x, y, z);
    	
        if (te.growthStage >= 15)
        {
            if (world.isRemote) {
            	return true;
            }

            te.growthStage = 12;
            teClient.growthStage = 12;
            EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(ModItems.herbologicaBerry.itemID, 1, meta));
            world.spawnEntityInWorld(entityitem);
            if (!(player instanceof FakePlayer)) {
            	entityitem.onCollideWithPlayer(player);
            }
            return true;
        }
        return false;
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
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		if (world.isRemote) {
            if (worldClient == null) {
            	worldClient = world;
            }
        }
        else {
            if (worldServer == null) {
            	worldServer = world;
            }
        }
		
		return new TileEntityBush();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public void setGraphicsLevel(boolean flag) {
		graphicsLevel = flag;
	}
	
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }

	@Override
    public int getRenderType() {
        return BushRender.bushModel;
    }
    
	@Override
    public boolean shouldSideBeRendered(IBlockAccess block, int i, int j, int k, int l) {
        if (l > 7 || graphicsLevel)
        {
            return super.shouldSideBeRendered(block, i, j, k, l);
        }
        else
        {
            return true;
        }
    }
	
	@Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (world.isRemote) {
            return;
        }
        
        TileEntityBush teClient = (TileEntityBush)worldClient.getBlockTileEntity(x, y, z);
        TileEntityBush teServer = (TileEntityBush)worldServer.getBlockTileEntity(x, y, z);
        
        LogHelper.log(Level.INFO, "Ticking bush");

        int height;

        for (height = 1; world.getBlockId(x, y - height, z) == this.blockID; ++height);

        if (random.nextInt(1) == 0 && world.getBlockLightValue(x, y, z) >= 8) {
        	Minecraft mc = Minecraft.getMinecraft();
            int meta = world.getBlockMetadata(x, y, z);
            
            if (teServer.growthStage < 15) {
            	LogHelper.log(Level.INFO, "Growing bush");
            	LogHelper.log(Level.INFO, "Stage before: " + teServer.getGrowthStage());
            	teServer.grow(1, mc.renderGlobal, x, y, z);
            	teClient.grow(1, mc.renderGlobal, x, y, z);
            	mc.renderGlobal.markBlockForUpdate(x, y, z);
            }
            if (random.nextInt(3) == 0 && height < 3 && world.getBlockId(x, y + 1, z) == 0 && teServer.growthStage >= 8) {
                world.setBlock(x, y + 1, z, blockID, meta, 3);
            }
        }
    }

}
