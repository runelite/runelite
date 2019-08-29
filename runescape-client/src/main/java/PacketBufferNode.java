import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[Lgq;"
	)
	@Export("PacketBufferNode_packetBufferNodes")
	static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -999589245
	)
	@Export("PacketBufferNode_packetBufferNodeCount")
	static int PacketBufferNode_packetBufferNodeCount;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lda;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	@Export("clientPacket")
	ClientPacket clientPacket;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 190922569
	)
	@Export("clientPacketLength")
	int clientPacketLength;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("packetBuffer")
	public PacketBuffer packetBuffer;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2083817253
	)
	@Export("index")
	public int index;

	static {
		PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
		PacketBufferNode_packetBufferNodeCount = 0;
	}

	PacketBufferNode() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("release")
	public void release() {
		if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
			PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lhz;IIIZI)V",
		garbageValue = "-1570089808"
	)
	public static void method3574(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class197.field2378 = 1;
		WorldMapDecoration.musicTrackArchive = var0;
		class197.musicTrackGroupId = var1;
		class197.musicTrackFileId = var2;
		WorldMapSprite.field222 = var3;
		Varcs.musicTrackBoolean = var4;
		class16.field98 = 10000;
	}
}
