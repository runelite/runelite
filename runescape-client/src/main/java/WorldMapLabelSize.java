import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("qv")
	@ObfuscatedSignature(
		signature = "Lca;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lg;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive1")
	static Archive archive1;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1343624191
	)
	final int field107;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1129278847
	)
	final int field108;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1652176271
	)
	final int field109;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(2, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field107 = var1;
		this.field108 = var2;
		this.field109 = var3;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(FI)Z",
		garbageValue = "-1695259698"
	)
	boolean method198(float var1) {
		return var1 >= (float)this.field109;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)[Lg;",
		garbageValue = "1124237372"
	)
	static WorldMapLabelSize[] method196() {
		return new WorldMapLabelSize[]{WorldMapLabelSize_large, WorldMapLabelSize_small, WorldMapLabelSize_medium};
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "255"
	)
	public static int method197() {
		return ++MouseHandler.MouseHandler_idleCycles - 1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-962048478"
	)
	static final int method202(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = Login.method2100(var3, var5);
		int var8 = Login.method2100(var3 + 1, var5);
		int var9 = Login.method2100(var3, var5 + 1);
		int var10 = Login.method2100(var3 + 1, var5 + 1);
		int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
		int var14 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var13 = ((65536 - var14) * var9 >> 16) + (var10 * var14 >> 16);
		int var16 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var6 * 1024 / var2] >> 1;
		int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
		return var15;
	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "-1330882873"
	)
	static void method201(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, WorldMapSection1.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != class223.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(var3[var6]);
					var8.packetBuffer.method5467(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(var3[var6]);
					var8.packetBuffer.method5468(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.method5467(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5476(var3[var6]);
					var8.packetBuffer.method5467(0);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			class210.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
