package kunlab.leave2die;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.sun.xml.internal.ws.api.message.Packet;
import org.bukkit.entity.Player;

public class SendGlowingEffectPacket {

    private final ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

    private void setGlowing(Player sender, Player target, boolean b) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.ENTITY_METADATA);
        packetContainer.getIntegers().write(0, target.getEntityId());
        WrappedDataWatcher watcher = new WrappedDataWatcher();
        WrappedDataWatcher.Serializer serializer = WrappedDataWatcher.Registry.get(Byte.class);
        watcher.setEntity(target);
        watcher.setObject(0, serializer, (byte) (b ? 0x40 : 0x00));
        packetContainer.getWatchableCollectionModifier().write(0, watcher.getWatchableObjects());
        try {
            protocolManager.sendServerPacket(sender, packetContainer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
