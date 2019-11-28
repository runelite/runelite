import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class216 {
	@ObfuscatedName("z")
	@Export("SpriteBuffer_yOffsets")
	static int[] SpriteBuffer_yOffsets;
	@ObfuscatedName("y")
	@Export("ByteArrayPool_altSizeArrayCounts")
	static int[] ByteArrayPool_altSizeArrayCounts;

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)V",
		garbageValue = "-126430026"
	)
	static final void method4118(String var0, int var1) {
		PacketBufferNode var2 = ModelData0.getPacketBufferNode(ClientPacket.field2319, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		var2.packetBuffer.writeByte(var1);
		Client.packetWriter.addNode(var2);
	}
}
