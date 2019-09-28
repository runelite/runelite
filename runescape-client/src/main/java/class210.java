import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class210 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("huffman")
	public static Huffman huffman;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "-65"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		WorldMapData_1.addChatMessage(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2143242016"
	)
	static void method3948() {
		PacketBufferNode var0 = InterfaceParent.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(class247.getWindowedMode());
		var0.packetBuffer.writeShort(FloorDecoration.canvasWidth);
		var0.packetBuffer.writeShort(WallDecoration.canvasHeight);
		Client.packetWriter.addNode(var0);
	}
}
