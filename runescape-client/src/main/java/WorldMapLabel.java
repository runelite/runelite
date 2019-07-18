import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("q")
	@Export("text")
	String text;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 839300469
	)
	@Export("width")
	int width;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 128259131
	)
	@Export("height")
	int height;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "La;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IILa;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("p")
	static int method420(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkf;IIIIIII)V",
		garbageValue = "-1566017890"
	)
	@Export("loadTerrain")
	static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -class1.method14(var4 + 932731 + var2, var3 + 556238 + var5) * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var7 == 1) {
					int var8 = var0.readUnsignedByte();
					if (var8 == 1) {
						var8 = 0;
					}

					if (var1 == 0) {
						Tiles.Tiles_heights[0][var2][var3] = -var8 * 8;
					} else {
						Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var8 * 8;
					}
					break;
				}

				if (var7 <= 49) {
					Tiles.field505[var1][var2][var3] = var0.readByte();
					Tiles.field506[var1][var2][var3] = (byte)((var7 - 2) / 4);
					class268.field3561[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
				} else if (var7 <= 81) {
					Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var7 - 49);
				} else {
					Tiles.field504[var1][var2][var3] = (byte)(var7 - 81);
				}
			}
		} else {
			while (true) {
				var7 = var0.readUnsignedByte();
				if (var7 == 0) {
					break;
				}

				if (var7 == 1) {
					var0.readUnsignedByte();
					break;
				}

				if (var7 <= 49) {
					var0.readUnsignedByte();
				}
			}
		}

	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "108"
	)
	static String method417(int var0) {
		if (var0 < 0) {
			return "";
		} else {
			return Client.menuTargetNames[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargetNames[var0] : Client.menuActions[var0];
		}
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "-1379117889"
	)
	public static void method418(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = Archive.method4265(ClientPacket.field2296, Client.packetWriter.isaacCipher);
		var4.packetBuffer.writeIntME(var3 ? Client.field855 : 0);
		var4.packetBuffer.writeShortLE(var1);
		var4.packetBuffer.method5521(var2);
		var4.packetBuffer.writeShort(var0);
		Client.packetWriter.method2219(var4);
	}
}
