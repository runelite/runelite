import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1295049317
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 927715995
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 2066187395
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1145498097
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 844773533
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -274372249
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -478444161
	)
	int field185;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1833104023
	)
	int field186;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -697507029
	)
	int field179;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -64934355
	)
	int field181;

	WorldMapSection2() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Laa;B)V",
		garbageValue = "-111"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field185) {
			var1.regionLowX = this.field185;
		}

		if (var1.regionHighX < this.field179) {
			var1.regionHighX = this.field179;
		}

		if (var1.regionLowY > this.field186) {
			var1.regionLowY = this.field186;
		}

		if (var1.regionHighY < this.field181) {
			var1.regionHighY = this.field181;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-1417818612"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-2132898041"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field185 && var1 >> 6 <= this.field179 && var2 >> 6 >= this.field186 && var2 >> 6 <= this.field181;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1209167521"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIS)Lhf;",
		garbageValue = "7283"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-568369534"
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
		this.field179 = var1.readUnsignedShort();
		this.field181 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1560468705"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "16"
	)
	static final void method383() {
		int var0 = MusicPatchNode.menuX;
		int var1 = TextureProvider.menuY;
		int var2 = KeyHandler.menuWidth;
		int var3 = WorldMapData_1.menuHeight;
		int var4 = 6116423;
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
		Rasterizer2D.Rasterizer2D_drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
		class43.fontBold12.draw("Choose Option", var0 + 3, var1 + 14, var4, -1);
		int var5 = MouseHandler.MouseHandler_x;
		int var6 = MouseHandler.MouseHandler_y;

		for (int var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
			int var8 = (Client.menuOptionsCount - 1 - var7) * 15 + var1 + 31;
			int var9 = 16777215;
			if (var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
				var9 = 16776960;
			}

			class43.fontBold12.draw(class65.method1316(var7), var0 + 3, var8, var9, 0);
		}

		WorldMapSection0.method279(MusicPatchNode.menuX, TextureProvider.menuY, KeyHandler.menuWidth, WorldMapData_1.menuHeight);
	}
}
