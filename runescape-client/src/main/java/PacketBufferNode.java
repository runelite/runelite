import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "[Lgn;"
	)
	@Export("PacketBufferNode_packetBufferNodes")
	static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 6984373
	)
	@Export("PacketBufferNode_packetBufferNodeCount")
	static int PacketBufferNode_packetBufferNodeCount;
	@ObfuscatedName("y")
	@Export("SpriteBuffer_pixels")
	public static byte[][] SpriteBuffer_pixels;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgy;"
	)
	@Export("clientPacket")
	ClientPacket clientPacket;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1214677313
	)
	@Export("clientPacketLength")
	int clientPacketLength;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("packetBuffer")
	public PacketBuffer packetBuffer;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 232074557
	)
	@Export("index")
	public int index;

	static {
		PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
		PacketBufferNode_packetBufferNodeCount = 0;
	}

	PacketBufferNode() {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-873176834"
	)
	@Export("release")
	public void release() {
		if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
			PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lil;",
		garbageValue = "1677952312"
	)
	@Export("getNpcDefinition")
	public static NPCDefinition getNpcDefinition(int var0) {
		NPCDefinition var1 = (NPCDefinition)NPCDefinition.NpcDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = NPCDefinition.NpcDefinition_archive.takeFile(9, var0);
			var1 = new NPCDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			NPCDefinition.NpcDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
