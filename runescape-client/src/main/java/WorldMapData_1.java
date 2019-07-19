import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ac")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
	@ObfuscatedName("sk")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "[Lly;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 234280421
	)
	@Export("chunkXLow")
	int chunkXLow;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1310278341
	)
	@Export("chunkYLow")
	int chunkYLow;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1872036801
	)
	@Export("chunkX")
	int chunkX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1949711027
	)
	@Export("chunkY")
	int chunkY;

	WorldMapData_1() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "1442686433"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field269.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 4096;
			super.regionYLow = var1.readUnsignedShort() * 4096;
			this.chunkXLow = var1.readUnsignedByte();
			this.chunkYLow = var1.readUnsignedByte();
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			this.chunkX = var1.readUnsignedByte();
			this.chunkY = var1.readUnsignedByte();
			super.groupId = var1.method5511();
			super.fileId = var1.method5511();
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-1951934103"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field165 = new byte[super.planes][64][64];
		super.field166 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field258.value) {
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2082336179"
	)
	@Export("getChunkXLow")
	int getChunkXLow() {
		return this.chunkXLow;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-521684078"
	)
	@Export("getChunkYLow")
	int getChunkYLow() {
		return this.chunkYLow;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1825008967"
	)
	@Export("getChunkX")
	int getChunkX() {
		return this.chunkX;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1471448055"
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
			if (var2.regionX == super.regionX && super.regionY == var2.regionY) {
				return var2.chunkX == this.chunkX && var2.chunkY == this.chunkY;
			} else {
				return false;
			}
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-878316811"
	)
	static int method696(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.field700 = 250;
			return 1;
		} else {
			return 2;
		}
	}
}
