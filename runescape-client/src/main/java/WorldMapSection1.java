import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("x")
	public static short[][] field269;
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive13")
	static Archive archive13;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -129099459
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2029777559
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1452885269
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1570402195
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 387598709
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1600612691
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Laa;I)V",
		garbageValue = "515570621"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "2033433479"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-66"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1684413985"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)Lht;",
		garbageValue = "21"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkq;B)V",
		garbageValue = "74"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-15"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1906652083"
	)
	static void method584() {
		if (GrandExchangeEvent.worldMap != null) {
			GrandExchangeEvent.worldMap.method6367(UrlRequest.Client_plane, MusicPatchPcmStream.baseX * 64 + (Message.localPlayer.x >> 7), ScriptEvent.baseY * 64 + (Message.localPlayer.y >> 7), false);
			GrandExchangeEvent.worldMap.loadCache();
		}

	}
}
