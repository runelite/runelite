import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("y")
	static int[] field1129;
	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "Ldt;"
	)
	@Export("textureProvider")
	static TextureProvider textureProvider;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1847436075
	)
	@Export("argument1")
	int argument1;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -833920995
	)
	@Export("argument2")
	int argument2;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1626023363
	)
	@Export("opcode")
	int opcode;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1315061643
	)
	@Export("argument0")
	int argument0;
	@ObfuscatedName("u")
	@Export("action")
	String action;

	MenuAction() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IB)Lir;",
		garbageValue = "65"
	)
	@Export("getEnum")
	public static EnumDefinition getEnum(int var0) {
		EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = EnumDefinition.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumDefinition.EnumDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lgv;Lle;B)Lgq;",
		garbageValue = "35"
	)
	@Export("getPacketBufferNode")
	public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2 = Buffer.method5567();
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2010675599"
	)
	static void method1993() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.field1219[var0] = null;
			Players.field1230[var0] = 1;
		}

	}
}
