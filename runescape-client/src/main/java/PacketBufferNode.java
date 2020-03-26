import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lgq;"
	)
	@Export("PacketBufferNode_packetBufferNodes")
	static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1377216057
	)
	@Export("PacketBufferNode_packetBufferNodeCount")
	static int PacketBufferNode_packetBufferNodeCount;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[Lms;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("lc")
	@ObfuscatedGetter(
		intValue = 1185326295
	)
	@Export("menuY")
	static int menuY;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgn;"
	)
	@Export("clientPacket")
	public ClientPacket clientPacket;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1271614463
	)
	@Export("clientPacketLength")
	public int clientPacketLength;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lkj;"
	)
	@Export("packetBuffer")
	public PacketBuffer packetBuffer;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1670678783
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
		signature = "(I)V",
		garbageValue = "-1494953808"
	)
	@Export("release")
	public void release() {
		if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
			PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1872697875"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1384794944"
	)
	@Export("iLog")
	public static int iLog(int var0) {
		int var1 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var1 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var1 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var1 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var1 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var1;
		}

		return var0 + var1;
	}
}
