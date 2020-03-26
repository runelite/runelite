import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
public class class303 {
	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "83308919"
	)
	static final void method5397(boolean var0) {
		ChatChannel.playPcmPlayers();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.field728 && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = FaceNormal.getPacketBufferNode(ClientPacket.field2295, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var1);

				try {
					Client.packetWriter.flush();
				} catch (IOException var3) {
					Client.field728 = true;
				}
			}

		}
	}
}
