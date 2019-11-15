import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -372540487
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 889180281
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -400617797
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 399728783
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1763177127
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 923116577
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 335677209
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -2053674359
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1863625007
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -887060215
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1381589897
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1499685421
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1091787841
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1129428397
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Laa;B)V",
		garbageValue = "-111"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-1417818612"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.oldZ + this.newZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
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
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
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
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
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
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-568369534"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "26"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;I)V",
		garbageValue = "667089827"
	)
	public static void method263(AbstractArchive var0) {
		VarpDefinition.VarpDefinition_archive = var0;
		VarpDefinition.VarpDefinition_fileCount = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "128"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (WorldMapRectangle.garbageCollector == null || !WorldMapRectangle.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						WorldMapRectangle.garbageCollector = var2;
						GameShell.garbageCollectorLastCheckTimeMs = -1L;
						GameShell.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (WorldMapRectangle.garbageCollector != null) {
			long var9 = PlayerAppearance.currentTimeMillis();
			long var3 = WorldMapRectangle.garbageCollector.getCollectionTime();
			if (-1L != GameShell.garbageCollectorLastCollectionTime) {
				long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameShell.garbageCollectorLastCheckTimeMs;
				if (0L != var7) {
					var0 = (int)(100L * var5 / var7);
				}
			}

			GameShell.garbageCollectorLastCollectionTime = var3;
			GameShell.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}

	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1258868168"
	)
	static int method285(int var0) {
		return var0 * 3 + 600;
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1698930592"
	)
	static final void method279(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetWidths[var4] + Client.rootWidgetXs[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field837[var4] = true;
			}
		}

	}
}
