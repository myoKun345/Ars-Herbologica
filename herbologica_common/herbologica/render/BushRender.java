package herbologica.render;

import herbologica.core.LogHelper;
import herbologica.proxy.ClientProxy;
import herbologica.tileentity.crop.TileEntityBush;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Ars Herbologica
 * 
 * BushRender
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BushRender implements ISimpleBlockRenderingHandler
{
    public static int bushModel = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        if (modelId == bushModel) {
            TileEntityBush tileentity = (TileEntityBush)world.getBlockTileEntity(x, y, z);
            
            LogHelper.log(Level.INFO, "renderWorldBlock Stage: " + tileentity.growthStage);
            
            if (tileentity == null) {
            	renderer.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
                renderer.renderStandardBlock(block, x, y, z);
            }
            if (tileentity.growthStage < 4) {
                renderer.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
                renderer.renderStandardBlock(block, x, y, z);
            }
            else if (tileentity.growthStage < 8) {
                renderer.setRenderBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.75F, 0.875F);
                renderer.renderStandardBlock(block, x, y, z);
            }
            else {
                renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
        return true;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        if (modelID == bushModel) {
            renderer.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
            ClientProxy.renderStandardInvBlock(renderer, block, metadata);
        }
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return true;
    }

    @Override
    public int getRenderId() {
        return bushModel;
    }
}