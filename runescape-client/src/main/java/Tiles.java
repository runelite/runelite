import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("rr")
	@ObfuscatedGetter(
		intValue = 1255791215
	)
	static int field501;
	@ObfuscatedName("q")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("w")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1687687411
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("p")
	static byte[][][] field504;
	@ObfuscatedName("k")
	static byte[][][] field505;
	@ObfuscatedName("l")
	static byte[][][] field506;
	@ObfuscatedName("c")
	static int[][] field515;
	@ObfuscatedName("m")
	static int[] field508;
	@ObfuscatedName("u")
	static int[] field507;
	@ObfuscatedName("j")
	static final int[] field512;
	@ObfuscatedName("t")
	static final int[] field513;
	@ObfuscatedName("h")
	static final int[] field514;
	@ObfuscatedName("o")
	static final int[] field520;
	@ObfuscatedName("n")
	static final int[] field509;
	@ObfuscatedName("d")
	static final int[] field517;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 2138239411
	)
	static int field519;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -217342215
	)
	static int field510;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field512 = new int[]{1, 2, 4, 8};
		field513 = new int[]{16, 32, 64, 128};
		field514 = new int[]{1, 0, -1, 0};
		field520 = new int[]{0, -1, 0, 1};
		field509 = new int[]{1, -1, -1, 1};
		field517 = new int[]{-1, -1, 1, 1};
		field519 = (int)(Math.random() * 17.0D) - 8;
		field510 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(ZLkx;I)V",
		garbageValue = "-1936823520"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var2;
		int var3;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			var2 = var1.method5534();
			var3 = var1.method5518();
			int var4 = var1.readUnsignedShort();
			WorldMapRegion.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					WorldMapRegion.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			DirectByteArrayCopier.regions = new int[var4];
			SecureRandomFuture.regionMapArchiveIds = new int[var4];
			WorldMapRectangle.regionLandArchiveIds = new int[var4];
			class13.regionLandArchives = new byte[var4][];
			class80.regionMapArchives = new byte[var4][];
			boolean var16 = false;
			if ((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
				var16 = true;
			}

			if (var3 / 8 == 48 && var2 / 8 == 148) {
				var16 = true;
			}

			var4 = 0;

			for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
				for (var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
						DirectByteArrayCopier.regions[var4] = var8;
						SecureRandomFuture.regionMapArchiveIds[var4] = WorldMapCacheName.archive5.getGroupId("m" + var6 + "_" + var7);
						WorldMapRectangle.regionLandArchiveIds[var4] = WorldMapCacheName.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			UserComparator8.method3399(var3, var2, true);
		} else {
			var2 = var1.method5518();
			var3 = var1.method5534();
			boolean var15 = var1.readUnsignedByte() == 1;
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			WorldMapRegion.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					WorldMapRegion.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			DirectByteArrayCopier.regions = new int[var5];
			SecureRandomFuture.regionMapArchiveIds = new int[var5];
			WorldMapRectangle.regionLandArchiveIds = new int[var5];
			class13.regionLandArchives = new byte[var5][];
			class80.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (DirectByteArrayCopier.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								DirectByteArrayCopier.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								SecureRandomFuture.regionMapArchiveIds[var5] = WorldMapCacheName.archive5.getGroupId("m" + var13 + "_" + var14);
								WorldMapRectangle.regionLandArchiveIds[var5] = WorldMapCacheName.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			UserComparator8.method3399(var3, var2, !var15);
		}

	}
}
