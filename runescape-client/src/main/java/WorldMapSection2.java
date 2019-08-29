import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("rj")
	@ObfuscatedGetter(
		intValue = 148255872
	)
	static int field190;
	@ObfuscatedName("qy")
	@ObfuscatedGetter(
		intValue = -808409095
	)
	static int field191;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = 1175996651
	)
	static int field183;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -15494621
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -608895039
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1639169875
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 360739097
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 212769379
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 221192809
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 852884703
	)
	int field185;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1572504287
	)
	int field186;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1285923191
	)
	int field187;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1597902097
	)
	int field179;

	WorldMapSection2() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lav;I)V",
		garbageValue = "-1068467910"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field185) {
			var1.regionLowX = this.field185;
		}

		if (var1.regionHighX < this.field187) {
			var1.regionHighX = this.field187;
		}

		if (var1.regionLowY > this.field186) {
			var1.regionLowY = this.field186;
		}

		if (var1.regionHighY < this.field179) {
			var1.regionHighY = this.field179;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "1014871771"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "694688168"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field185 && var1 >> 6 <= this.field187 && var2 >> 6 >= this.field186 && var2 >> 6 <= this.field179;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-45443461"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field185 * 64 - this.regionStartX * 64 + var2, var3 + (this.field186 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)Lhd;",
		garbageValue = "1267204541"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field185 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field186 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "1072299144"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field185 = var1.readUnsignedShort();
		this.field186 = var1.readUnsignedShort();
		this.field187 = var1.readUnsignedShort();
		this.field179 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1597340274"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([BIII)Z",
		garbageValue = "1296086556"
	)
	static final boolean method325(byte[] var0, int var1, int var2) {
		boolean var3 = true;
		Buffer var4 = new Buffer(var0);
		int var5 = -1;

		label70:
		while (true) {
			int var6 = var4.method5565();
			if (var6 == 0) {
				return var3;
			}

			var5 += var6;
			int var7 = 0;
			boolean var8 = false;

			while (true) {
				int var9;
				while (!var8) {
					var9 = var4.readUShortSmart();
					if (var9 == 0) {
						continue label70;
					}

					var7 += var9 - 1;
					int var10 = var7 & 63;
					int var11 = var7 >> 6 & 63;
					int var12 = var4.readUnsignedByte() >> 2;
					int var13 = var11 + var1;
					int var14 = var10 + var2;
					if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
						ObjectDefinition var15 = class215.getObjectDefinition(var5);
						if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
							if (!var15.needsModelFiles()) {
								++Client.field678;
								var3 = false;
							}

							var8 = true;
						}
					}
				}

				var9 = var4.readUShortSmart();
				if (var9 == 0) {
					break;
				}

				var4.readUnsignedByte();
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1052050737"
	)
	@Export("WorldMapElement_clearCached")
	public static void WorldMapElement_clearCached() {
		WorldMapElement.WorldMapElement_cachedSprites.clear();
	}
}
