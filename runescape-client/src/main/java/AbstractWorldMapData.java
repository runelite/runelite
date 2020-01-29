import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1805663379
	)
	static int field190;
	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("mapDotSprites")
	static Sprite[] mapDotSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -894906368
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1390111808
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1468899765
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1986069101
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1726472533
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1228656521
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -672684543
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -199023581
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("j")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("m")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("p")
	byte[][][] field188;
	@ObfuscatedName("h")
	byte[][][] field175;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[[[[Lu;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("n")
	boolean field174;
	@ObfuscatedName("x")
	boolean field185;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field174 = false;
		this.field185 = false;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;S)V",
		garbageValue = "-30591"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1888663118"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field174 && this.field185;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lii;I)V",
		garbageValue = "-60010713"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field174 = true;
				this.field185 = true;
			}

		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "559104793"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field188 = null;
		this.field175 = null;
		this.decorations = null;
		this.field174 = false;
		this.field185 = false;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IILkp;I)V",
		garbageValue = "-1538793396"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method257(var1, var2, var3, var4);
			} else {
				this.method258(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IILkp;II)V",
		garbageValue = "1470319349"
	)
	void method257(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IILkp;II)V",
		garbageValue = "-2109689105"
	)
	void method258(int var1, int var2, Buffer var3, int var4) {
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
					this.field188[var9][var1][var2] = (byte)(var11 >> 2);
					this.field175[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5593();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1419701819"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "879615206"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}
}
