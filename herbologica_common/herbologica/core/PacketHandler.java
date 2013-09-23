package herbologica.core;

import herbologica.tileentity.crop.TileEntityBush;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * Ars Herbologica
 * 
 * PacketHandler
 * 
 * @author Myo-kun
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PacketHandler implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
        
    	switch (packet.channel) {
    	case Reference.BUSH_CHANNEL:
    		handleBush(packet, player);
    		break;
    	}
    	
    }
    
    protected void handleBush(Packet250CustomPayload packet, Player player) {
    	DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
    	
    	int x;
    	int y;
    	int z;
    	int stage;
    	
    	try {
    		x = inputStream.readInt();
    		y = inputStream.readInt();
    		z = inputStream.readInt();
    		stage = inputStream.readInt();
    		sendBushUpdate(x, y, z, stage, player);
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    private void sendBushUpdate(int x, int y, int z, int stage, Player player) {
    	
    	EntityPlayerMP playerMP;
    	EntityClientPlayerMP playerClient;
    	
    	if (player instanceof EntityClientPlayerMP) {
    		playerClient = (EntityClientPlayerMP)player;
        	TileEntity te = playerClient.worldObj.getBlockTileEntity(x, y, z);
        	
    		if (te != null) {
    			if (te instanceof TileEntityBush) {
    				TileEntityBush tebush = (TileEntityBush)te;
    				tebush.growthStage = (short)stage;
    				playerClient.worldObj.markBlockForUpdate(x, y, z);
    			}
    		}
    	}
    	if (player instanceof EntityPlayerMP) {
    		playerMP = (EntityPlayerMP)player;
        	TileEntity te = playerMP.worldObj.getBlockTileEntity(x, y, z);
        	
    		if (te != null) {
    			if (te instanceof TileEntityBush) {
    				TileEntityBush tebush = (TileEntityBush)te;
    				tebush.growthStage = (short)stage;
    				playerMP.worldObj.markBlockForUpdate(x, y, z);
    			}
    		}
    	}
    	
    }

}

