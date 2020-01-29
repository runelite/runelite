import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -352069921
	)
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 650382493
	)
	@Export("chunkXLow")
	int chunkXLow;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 214088681
	)
	@Export("chunkYLow")
	int chunkYLow;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1958393799
	)
	@Export("chunkX")
	int chunkX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1560494711
	)
	@Export("chunkY")
	int chunkY;

	WorldMapData_1() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-431510829"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field278.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 4096;
			super.regionYLow = var1.readUnsignedShort() * 64;
			this.chunkXLow = var1.readUnsignedByte();
			this.chunkYLow = var1.readUnsignedByte();
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			this.chunkX = var1.readUnsignedByte();
			this.chunkY = var1.readUnsignedByte();
			super.groupId = var1.method5593();
			super.fileId = var1.method5593();
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;S)V",
		garbageValue = "-30591"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field188 = new byte[super.planes][64][64];
		super.field175 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field271.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			int var5 = var1.readUnsignedByte();
			int var6 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY && var5 == this.chunkX && var6 == this.chunkY) {
				for (int var7 = 0; var7 < 8; ++var7) {
					for (int var8 = 0; var8 < 8; ++var8) {
						this.readTile(var7 + this.chunkX * 8, var8 + this.chunkY * 8, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "35"
	)
	@Export("getChunkXLow")
	int getChunkXLow() {
		return this.chunkXLow;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "105"
	)
	@Export("getChunkYLow")
	int getChunkYLow() {
		return this.chunkYLow;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1796035286"
	)
	@Export("getChunkX")
	int getChunkX() {
		return this.chunkX;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1186864483"
	)
	@Export("getChunkY")
	int getChunkY() {
		return this.chunkY;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_1)) {
			return false;
		} else {
			WorldMapData_1 var2 = (WorldMapData_1)var1;
			if (var2.regionX == super.regionX && var2.regionY == super.regionY) {
				return this.chunkX == var2.chunkX && this.chunkY == var2.chunkY;
			} else {
				return false;
			}
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1587846163"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = WorldMapRectangle.getPreferencesFile("", class14.field102.name, true);
			Buffer var1 = WorldMapSection2.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("j")
	static boolean method732(long var0) {
		return (int)(var0 >>> 16 & 1L) == 1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1876587331"
	)
	public static int method712(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(ILhj;ZB)V",
		garbageValue = "89"
	)
	static void method731(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = GrandExchangeOfferUnitPriceComparator.getWorldMap().getMapArea(var0);
		int var4 = class192.localPlayer.plane;
		int var5 = Messages.baseX * 64 + (class192.localPlayer.x >> 7);
		int var6 = Language.baseY * 64 + (class192.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		GrandExchangeOfferUnitPriceComparator.getWorldMap().method6377(var3, var7, var1, var2);
	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1054316430"
	)
	static void method733() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
				class51.addPlayerToScene(Client.players[var1[var2]], true);
			}
		}

	}
}
