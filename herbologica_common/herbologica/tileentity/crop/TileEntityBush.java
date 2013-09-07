package herbologica.tileentity.crop;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Ars Herbologica
 * 
 * TileEntityBush
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityBush extends TileEntity {
	
	public short growthStage;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setShort("GrowthStage", (short)this.growthStage);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.growthStage = compound.getShort("GrowthStage");
	}
	
	public void grow(int i, RenderGlobal render, int x, int y, int z) {
		this.growthStage = (short)(growthStage + i);
	}
	
	public short getGrowthStage() {
		return this.growthStage;
	}
	
}
