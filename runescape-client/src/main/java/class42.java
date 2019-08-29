import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class42 implements WorldMapSection {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1666489589
	)
	int field339;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1652591349
	)
	int field347;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1779565127
	)
	int field340;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1405698939
	)
	int field341;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -141873597
	)
	int field342;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1429308519
	)
	int field343;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1809931073
	)
	int field338;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 267647381
	)
	int field345;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1741854477
	)
	int field346;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1323811143
	)
	int field344;

	class42() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lav;I)V",
		garbageValue = "-1068467910"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field342) {
			var1.regionLowX = this.field342;
		}

		if (var1.regionHighX < this.field342) {
			var1.regionHighX = this.field342;
		}

		if (var1.regionLowY > this.field343) {
			var1.regionLowY = this.field343;
		}

		if (var1.regionHighY < this.field343) {
			var1.regionHighY = this.field343;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "1014871771"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field339 && var1 < this.field339 + this.field347) {
			return var2 >= (this.field340 << 6) + (this.field338 << 3) && var2 <= (this.field340 << 6) + (this.field338 << 3) + 7 && var3 >= (this.field341 << 6) + (this.field345 << 3) && var3 <= (this.field341 << 6) + (this.field345 << 3) + 7;
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
		return var1 >= (this.field342 << 6) + (this.field346 << 3) && var1 <= (this.field342 << 6) + (this.field346 << 3) + 7 && var2 >= (this.field343 << 6) + (this.field344 << 3) && var2 <= (this.field343 << 6) + (this.field344 << 3) + 7;
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
			int[] var4 = new int[]{this.field342 * 64 - this.field340 * 64 + var2 + (this.field346 * 8 - this.field338 * 8), var3 + (this.field343 * 64 - this.field341 * 64) + (this.field344 * 8 - this.field345 * 8)};
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
			int var3 = this.field340 * 64 - this.field342 * 64 + (this.field338 * 8 - this.field346 * 8) + var1;
			int var4 = this.field341 * 64 - this.field343 * 64 + var2 + (this.field345 * 8 - this.field344 * 8);
			return new Coord(this.field339, var3, var4);
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "1072299144"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field339 = var1.readUnsignedByte();
		this.field347 = var1.readUnsignedByte();
		this.field340 = var1.readUnsignedShort();
		this.field338 = var1.readUnsignedByte();
		this.field341 = var1.readUnsignedShort();
		this.field345 = var1.readUnsignedByte();
		this.field342 = var1.readUnsignedShort();
		this.field346 = var1.readUnsignedByte();
		this.field343 = var1.readUnsignedShort();
		this.field344 = var1.readUnsignedByte();
		this.method738();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1792228112"
	)
	void method738() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/io/File;",
		garbageValue = "-44"
	)
	@Export("getFile")
	public static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("d")
	static final void method752(long var0) {
		ViewportMouse.ViewportMouse_entityTags[++ViewportMouse.ViewportMouse_entityCount - 1] = var0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	public static void method753() {
		ItemDefinition.ItemDefinition_cachedSprites.clear();
	}
}
