import java.awt.Desktop;
import java.awt.Image;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class42 implements WorldMapSection {
	@ObfuscatedName("f")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("ap")
	static Image field358;
	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("mapDotSprites")
	static Sprite[] mapDotSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 114988403
	)
	int field351;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1866285667
	)
	int field346;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -358829747
	)
	int field347;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 158528351
	)
	int field357;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1099424901
	)
	int field349;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 255034921
	)
	int field350;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1506534569
	)
	int field348;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 560033955
	)
	int field352;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -2075605251
	)
	int field353;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 68781873
	)
	int field354;

	class42() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lag;S)V",
		garbageValue = "32767"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field349) {
			var1.regionLowX = this.field349;
		}

		if (var1.regionHighX < this.field349) {
			var1.regionHighX = this.field349;
		}

		if (var1.regionLowY > this.field350) {
			var1.regionLowY = this.field350;
		}

		if (var1.regionHighY < this.field350) {
			var1.regionHighY = this.field350;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "950167825"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field351 && var1 < this.field346 + this.field351) {
			return var2 >= (this.field347 << 6) + (this.field348 << 3) && var2 <= (this.field347 << 6) + (this.field348 << 3) + 7 && var3 >= (this.field357 << 6) + (this.field352 << 3) && var3 <= (this.field357 << 6) + (this.field352 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1510325414"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field349 << 6) + (this.field353 << 3) && var1 <= (this.field349 << 6) + (this.field353 << 3) + 7 && var2 >= (this.field350 << 6) + (this.field354 << 3) && var2 <= (this.field350 << 6) + (this.field354 << 3) + 7;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-771447481"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field349 * 64 - this.field347 * 64 + var2 + (this.field353 * 8 - this.field348 * 8), var3 + (this.field350 * 64 - this.field357 * 64) + (this.field354 * 8 - this.field352 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIB)Lhj;",
		garbageValue = "0"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field347 * 64 - this.field349 * 64 + (this.field348 * 8 - this.field353 * 8) + var1;
			int var4 = this.field357 * 64 - this.field350 * 64 + var2 + (this.field352 * 8 - this.field354 * 8);
			return new Coord(this.field351, var3, var4);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1954302512"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field351 = var1.readUnsignedByte();
		this.field346 = var1.readUnsignedByte();
		this.field347 = var1.readUnsignedShort();
		this.field348 = var1.readUnsignedByte();
		this.field357 = var1.readUnsignedShort();
		this.field352 = var1.readUnsignedByte();
		this.field349 = var1.readUnsignedShort();
		this.field353 = var1.readUnsignedByte();
		this.field350 = var1.readUnsignedShort();
		this.field354 = var1.readUnsignedByte();
		this.method745();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-563197042"
	)
	void method745() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
		garbageValue = "-124"
	)
	static void method754(String var0, boolean var1, String var2, boolean var3) {
		if (var1) {
			if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var5) {
				}
			}

			if (class51.field406.startsWith("win") && !var3) {
				FontName.method5292(var0, 0);
				return;
			}

			if (class51.field406.startsWith("mac")) {
				ReflectionCheck.method2261(var0, 1, var2);
				return;
			}

			FontName.method5292(var0, 2);
		} else {
			FontName.method5292(var0, 3);
		}

	}
}
