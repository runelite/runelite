import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("s")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("j")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 210861461
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("k")
	static byte[][][] field485;
	@ObfuscatedName("t")
	static byte[][][] field475;
	@ObfuscatedName("d")
	@Export("Tiles_hue")
	static int[] Tiles_hue;
	@ObfuscatedName("p")
	static int[][][] field483;
	@ObfuscatedName("z")
	static final int[] field479;
	@ObfuscatedName("a")
	static final int[] field480;
	@ObfuscatedName("w")
	static final int[] field481;
	@ObfuscatedName("l")
	static final int[] field482;
	@ObfuscatedName("h")
	static final int[] field478;
	@ObfuscatedName("v")
	static final int[] field484;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1482528019
	)
	static int field477;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1522928569
	)
	static int field486;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field479 = new int[]{1, 2, 4, 8};
		field480 = new int[]{16, 32, 64, 128};
		field481 = new int[]{1, 0, -1, 0};
		field482 = new int[]{0, -1, 0, 1};
		field478 = new int[]{1, -1, -1, 1};
		field484 = new int[]{-1, -1, 1, 1};
		field477 = (int)(Math.random() * 17.0D) - 8;
		field486 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-739357854"
	)
	static int method1060(int var0, int var1) {
		FloorOverlayDefinition var3 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
		FloorOverlayDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var4 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0);
			var3 = new FloorOverlayDefinition();
			if (var4 != null) {
				var3.decode(new Buffer(var4), var0);
			}

			var3.postDecode();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var3, (long)var0);
			var2 = var3;
		}

		if (var2 == null) {
			return var1;
		} else if (var2.secondaryRgb >= 0) {
			return var2.secondaryRgb | -16777216;
		} else {
			int var5;
			byte var6;
			int var8;
			int var9;
			if (var2.texture >= 0) {
				var5 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture);
				var6 = 96;
				if (var5 == -2) {
					var8 = 12345678;
				} else if (var5 == -1) {
					if (var6 < 0) {
						var6 = 0;
					} else if (var6 > 127) {
						var6 = 127;
					}

					var9 = 127 - var6;
					var8 = var9;
				} else {
					var9 = var6 * (var5 & 127) / 128;
					if (var9 < 2) {
						var9 = 2;
					} else if (var9 > 126) {
						var9 = 126;
					}

					var8 = var9 + (var5 & 65408);
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var8] | -16777216;
			} else if (var2.primaryRgb == 16711935) {
				return var1;
			} else {
				var8 = WorldMapIcon_0.WorldMap_hslToRgb(var2.hue, var2.saturation, var2.lightness);
				var6 = 96;
				if (var8 == -2) {
					var5 = 12345678;
				} else if (var8 == -1) {
					if (var6 < 0) {
						var6 = 0;
					} else if (var6 > 127) {
						var6 = 127;
					}

					var9 = 127 - var6;
					var5 = var9;
				} else {
					var9 = var6 * (var8 & 127) / 128;
					if (var9 < 2) {
						var9 = 2;
					} else if (var9 > 126) {
						var9 = 126;
					}

					var5 = var9 + (var8 & 65408);
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var5] | -16777216;
			}
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;B)V",
		garbageValue = "-34"
	)
	@Export("VarpDefinition_setArchives")
	public static void VarpDefinition_setArchives(AbstractArchive var0) {
		VarpDefinition.VarpDefinition_archive = var0;
		VarpDefinition.VarpDefinition_fileCount = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(Lbu;I)V",
		garbageValue = "-1027985377"
	)
	static final void method1075(Actor var0) {
		int var1 = var0.field941 - Client.cycle;
		int var2 = var0.field960 * 128 + var0.size * -178253824;
		int var3 = var0.field954 * 128 + var0.size * -178253824;
		var0.x += (var2 - var0.x) / var1;
		var0.y += (var3 - var0.y) / var1;
		var0.field976 = 0;
		var0.orientation = var0.field966;
	}

	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-63"
	)
	@Export("Clan_leaveChat")
	static final void Clan_leaveChat() {
		PacketBufferNode var0 = MenuAction.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.addNode(var0);
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "([BII)V",
		garbageValue = "912146837"
	)
	static void method1088(byte[] var0, int var1) {
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class300.writeRandomDat(var0, var1, Client.randomDatData, 0, 24);
	}
}
