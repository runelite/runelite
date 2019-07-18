import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1951013555
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -927462805
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1508174563
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -290088343
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2013070877
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 204062243
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1982766605
	)
	int field202;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1874865145
	)
	int field203;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1506169835
	)
	int field204;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1738066987
	)
	int field205;

	WorldMapSection2() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lal;B)V",
		garbageValue = "-53"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field202) {
			var1.regionLowX = this.field202;
		}

		if (var1.regionHighX < this.field204) {
			var1.regionHighX = this.field204;
		}

		if (var1.regionLowY > this.field203) {
			var1.regionLowY = this.field203;
		}

		if (var1.regionHighY < this.field205) {
			var1.regionHighY = this.field205;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "59484528"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "56"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field202 && var1 >> 6 <= this.field204 && var2 >> 6 >= this.field203 && var2 >> 6 <= this.field205;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "12"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field202 * 64 - this.regionStartX * 64 + var2, var3 + (this.field203 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIB)Lhv;",
		garbageValue = "-13"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field202 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field203 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "1767519038"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field202 = var1.readUnsignedShort();
		this.field203 = var1.readUnsignedShort();
		this.field204 = var1.readUnsignedShort();
		this.field205 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-39"
	)
	@Export("postRead")
	void postRead() {
	}
}
