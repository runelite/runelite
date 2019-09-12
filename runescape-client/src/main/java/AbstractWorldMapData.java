import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1748127744
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1366642688
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -59240115
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1519130577
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -101530507
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1450874669
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 460144759
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 977185489
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("d")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("z")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("n")
	byte[][][] field163;
	@ObfuscatedName("h")
	byte[][][] field159;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[[[[Lb;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("s")
	boolean field166;
	@ObfuscatedName("p")
	boolean field167;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field166 = false;
		this.field167 = false;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-1969615810"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "2950"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field166 && this.field167;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;B)V",
		garbageValue = "20"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field166 = true;
				this.field167 = true;
			}

		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-266968977"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field163 = null;
		this.field159 = null;
		this.decorations = null;
		this.field166 = false;
		this.field167 = false;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IILkz;I)V",
		garbageValue = "1782766503"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method245(var1, var2, var3, var4);
			} else {
				this.method240(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IILkz;II)V",
		garbageValue = "-1638058411"
	)
	void method245(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IILkz;II)V",
		garbageValue = "-1194656986"
	)
	void method240(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedByte();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field163[var9][var1][var2] = (byte)(var11 >> 2);
					this.field159[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5623();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "35"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-13"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "79"
	)
	static void method254() {
		Tiles.Tiles_minPlane = 99;
		Tiles.field476 = new byte[4][104][104];
		class30.field257 = new byte[4][104][104];
		Tiles.field477 = new byte[4][104][104];
		HealthBar.field1089 = new byte[4][104][104];
		UserComparator3.field1961 = new int[4][105][105];
		Tiles.field473 = new byte[4][105][105];
		class160.field1977 = new int[105][105];
		UserComparator7.Tiles_hue = new int[104];
		TileItem.Tiles_saturation = new int[104];
		class1.Tiles_lightness = new int[104];
		class42.Tiles_hueMultiplier = new int[104];
		Tiles.field488 = new int[104];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "([Lbb;II[I[IB)V",
		garbageValue = "-40"
	)
	@Export("sortWorlds")
	static void sortWorlds(World[] var0, int var1, int var2, int[] var3, int[] var4) {
		if (var1 < var2) {
			int var5 = var1 - 1;
			int var6 = var2 + 1;
			int var7 = (var2 + var1) / 2;
			World var8 = var0[var7];
			var0[var7] = var0[var1];
			var0[var1] = var8;

			while (var5 < var6) {
				boolean var9 = true;

				int var10;
				int var11;
				int var12;
				do {
					--var6;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var6].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var6].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var6].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var6].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				var9 = true;

				do {
					++var5;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var5].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var5].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var5].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var5].id;
							var12 = var8.id;
						}

						if (var11 != var12) {
							if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				if (var5 < var6) {
					World var13 = var0[var5];
					var0[var5] = var0[var6];
					var0[var6] = var13;
				}
			}

			sortWorlds(var0, var1, var6, var3, var4);
			sortWorlds(var0, var6 + 1, var2, var3, var4);
		}

	}
}
