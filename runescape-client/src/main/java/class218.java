import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class218 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1649772022"
	)
	static final void method4179(String var0) {
		PacketBufferNode var1 = ModelData0.getPacketBufferNode(ClientPacket.field2219, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var0));
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}
}
