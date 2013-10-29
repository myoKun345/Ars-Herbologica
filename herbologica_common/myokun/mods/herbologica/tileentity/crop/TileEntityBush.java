package myokun.mods.herbologica.tileentity.crop;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.logging.Level;

import myokun.mods.herbologica.core.LogHelper;
import myokun.mods.herbologica.core.Reference;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;

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
	
	public void grow(int i, World world, int x, int y, int z) {
		this.growthStage = (short)(growthStage + i);
		this.sendStagePacket(world, x, y, z);
	}
	
	public void sendStagePacket(World world, int x, int y, int z) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeInt(x);
			outputStream.writeInt(y);
			outputStream.writeInt(z);
	        outputStream.writeInt(this.growthStage);
		} catch (Exception ex) {
	        ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = Reference.BUSH_CHANNEL;
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
	
	public short getGrowthStage() {
		return this.growthStage;
	}
	
}
