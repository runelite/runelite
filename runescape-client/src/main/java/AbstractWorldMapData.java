import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive6")
	static Archive archive6;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 111975616
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1782706176
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -577212613
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -248705921
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1296595709
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 380384989
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1445814981
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1373242491
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("w")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("i")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("k")
	byte[][][] field166;
	@ObfuscatedName("x")
	byte[][][] field160;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "[[[[Lj;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("e")
	boolean field169;
	@ObfuscatedName("n")
	boolean field167;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field169 = false;
		this.field167 = false;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "35"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1722967008"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field169 && this.field167;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lhf;I)V",
		garbageValue = "222528841"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field169 = true;
				this.field167 = true;
			}

		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1687680184"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field166 = null;
		this.field160 = null;
		this.decorations = null;
		this.field169 = false;
		this.field167 = false;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IILkg;B)V",
		garbageValue = "3"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method278(var1, var2, var3, var4);
			} else {
				this.method279(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IILkg;IB)V",
		garbageValue = "92"
	)
	void method278(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IILkg;II)V",
		garbageValue = "1096070019"
	)
	void method279(int var1, int var2, Buffer var3, int var4) {
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
					this.field166[var9][var1][var2] = (byte)(var11 >> 2);
					this.field160[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5618();
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
		garbageValue = "1505128614"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-8"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "493677830"
	)
	public static int method284(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if (var4 <= 127) {
				++var2;
			} else if (var4 <= 2047) {
				var2 += 2;
			} else {
				var2 += 3;
			}
		}

		return var2;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-858513722"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}
}
