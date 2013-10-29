package myokun.mods.herbologica.tileentity.crop;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import myokun.mods.herbologica.core.LogHelper;
import myokun.mods.herbologica.core.Reference;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Ars Herbologica
 * 
 * TileEntityVegetable
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityVegetable extends TileEntity {
	
	private int vegIndex;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("VegetableIndex", this.vegIndex);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.vegIndex = compound.getInteger("VegetableIndex");
	}
	
	public void sendIndexPacket(World world, int x, int y, int z) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream data = new DataOutputStream(bos);
		
		try {
			data.writeInt(x);
			data.writeInt(y);
			data.writeInt(z);
			data.writeInt(this.vegIndex);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = Reference.VEG_CHANNEL;
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.CLIENT) {
			PacketDispatcher.sendPacketToServer(packet);
		}
		else if (side == Side.SERVER) {
			PacketDispatcher.sendPacketToAllPlayers(packet);
		}
		else {
			LogHelper.log(Level.WARNING, "What side is this?!? I don't understand the side " + side.toString() + "!");
		}
	}
	
	public void setVegIndex(int ny) {
		this.vegIndex = ny;
	}
	
	public int getVegIndex() {
		return this.vegIndex;
	}
	
}
