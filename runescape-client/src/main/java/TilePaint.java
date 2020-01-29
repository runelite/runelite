import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1255983765
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1109558685
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1229444571
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -906668191
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -2043941121
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("g")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -860591445
	)
	@Export("rgb")
	int rgb;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhc;I)V",
		garbageValue = "-1948306061"
	)
	public static void method3150(Huffman var0) {
		class210.huffman = var0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;Lii;I)V",
		garbageValue = "811407537"
	)
	public static void method3149(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		SequenceDefinition.SequenceDefinition_archive = var0;
		Canvas.SequenceDefinition_animationsArchive = var1;
		SequenceDefinition.SequenceDefinition_skeletonsArchive = var2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lgi;Llw;I)Lgs;",
		garbageValue = "-1858964465"
	)
	@Export("getPacketBufferNode")
	public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2 = UserComparator5.method3488();
		var2.clientPacket = var0;
		var2.clientPacketLength = var0.length;
		if (var2.clientPacketLength == -1) {
			var2.packetBuffer = new PacketBuffer(260);
		} else if (var2.clientPacketLength == -2) {
			var2.packetBuffer = new PacketBuffer(10000);
		} else if (var2.clientPacketLength <= 18) {
			var2.packetBuffer = new PacketBuffer(20);
		} else if (var2.clientPacketLength <= 98) {
			var2.packetBuffer = new PacketBuffer(100);
		} else {
			var2.packetBuffer = new PacketBuffer(260);
		}

		var2.packetBuffer.setIsaacCipher(var1);
		var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
		var2.index = 0;
		return var2;
	}
}
