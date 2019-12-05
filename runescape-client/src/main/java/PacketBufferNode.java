import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Lgx;"
	)
	@Export("PacketBufferNode_packetBufferNodes")
	static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1218907641
	)
	@Export("PacketBufferNode_packetBufferNodeCount")
	static int PacketBufferNode_packetBufferNodeCount;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	@Export("clientPacket")
	ClientPacket clientPacket;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 328924249
	)
	@Export("clientPacketLength")
	int clientPacketLength;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lkj;"
	)
	@Export("packetBuffer")
	public PacketBuffer packetBuffer;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1715023791
	)
	@Export("index")
	public int index;

	static {
		PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
		PacketBufferNode_packetBufferNodeCount = 0;
	}

	PacketBufferNode() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "13"
	)
	@Export("release")
	public void release() {
		if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
			PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;I)V",
		garbageValue = "-628490328"
	)
	public static void method3679(AbstractArchive var0) {
		EnumDefinition.EnumDefinition_archive = var0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-380587936"
	)
	static final void method3670() {
		WorldMapSection2.method347("Your friend list is full. Max of 200 for free users, and 400 for members");
	}
}
