import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1534521391
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1718210699
	)
	@Export("x")
	int x;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1666415467
	)
	@Export("y")
	int y;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -211420525
	)
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 951647449
	)
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		longValue = 3162324910013074859L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1096622413
	)
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-13"
	)
	public static void method3273(int var0) {
		class197.field2392 = 1;
		Coord.musicTrackArchive = null;
		class16.musicTrackGroupId = -1;
		GrandExchangeOffer.musicTrackFileId = -1;
		class197.musicTrackVolume = 0;
		WorldMapDecoration.musicTrackBoolean = false;
		ParamDefinition.field3275 = var0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)V",
		garbageValue = "-318547131"
	)
	static final void method3274(String var0, int var1) {
		PacketBufferNode var2 = class2.getPacketBufferNode(ClientPacket.field2219, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(ViewportMouse.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		var2.packetBuffer.method5696(var1);
		Client.packetWriter.addNode(var2);
	}
}
