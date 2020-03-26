import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = 1088959325
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 108027763
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -970262457
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1813632253
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 460883399
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -2027857729
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -848152655
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2043506095
	)
	int field232;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1803971443
	)
	int field239;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1772744581
	)
	int field234;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1804974207
	)
	int field241;

	WorldMapSection2() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Las;I)V",
		garbageValue = "1890497148"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field232) {
			var1.regionLowX = this.field232;
		}

		if (var1.regionHighX < this.field234) {
			var1.regionHighX = this.field234;
		}

		if (var1.regionLowY > this.field239) {
			var1.regionLowY = this.field239;
		}

		if (var1.regionHighY < this.field241) {
			var1.regionHighY = this.field241;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-65934716"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-240937232"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field232 && var1 >> 6 <= this.field234 && var2 >> 6 >= this.field239 && var2 >> 6 <= this.field241;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1656767825"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field232 * 64 - this.regionStartX * 64), var3 + (this.field239 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "-226825052"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field232 * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.field239 * 64);
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1393433755"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field232 = var1.readUnsignedShort();
		this.field239 = var1.readUnsignedShort();
		this.field234 = var1.readUnsignedShort();
		this.field241 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1585844448"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lgh;",
		garbageValue = "-615033295"
	)
	public static class194[] method434() {
		return new class194[]{class194.field2324, class194.field2325, class194.field2327, class194.field2326, class194.field2332, class194.field2328, class194.field2329, class194.field2330, class194.field2331, class194.field2323};
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)Ljw;",
		garbageValue = "1650295452"
	)
	@Export("getObjectDefinition")
	public static ObjectDefinition getObjectDefinition(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectDefinition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "65280"
	)
	static boolean method433(char var0) {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var0) != -1;
	}
}
