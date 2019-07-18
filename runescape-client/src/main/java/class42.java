import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class42 implements WorldMapSection {
	@ObfuscatedName("jy")
	@ObfuscatedGetter(
		intValue = 729343295
	)
	@Export("plane")
	static int plane;
	@ObfuscatedName("kl")
	@ObfuscatedGetter(
		intValue = 656519429
	)
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 916978053
	)
	int field368;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1762560759
	)
	int field363;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -342146011
	)
	int field364;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1042956217
	)
	int field365;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 769033825
	)
	int field366;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1279110919
	)
	int field375;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1202415387
	)
	int field376;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 171955233
	)
	int field369;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -432723917
	)
	int field370;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 149120555
	)
	int field371;

	class42() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lal;B)V",
		garbageValue = "-53"
	)
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field366) {
			var1.regionLowX = this.field366;
		}

		if (var1.regionHighX < this.field366) {
			var1.regionHighX = this.field366;
		}

		if (var1.regionLowY > this.field375) {
			var1.regionLowY = this.field375;
		}

		if (var1.regionHighY < this.field375) {
			var1.regionHighY = this.field375;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "59484528"
	)
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field368 && var1 < this.field368 + this.field363) {
			return var2 >= (this.field364 << 6) + (this.field376 << 3) && var2 <= (this.field364 << 6) + (this.field376 << 3) + 7 && var3 >= (this.field365 << 6) + (this.field369 << 3) && var3 <= (this.field365 << 6) + (this.field369 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "56"
	)
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field366 << 6) + (this.field370 << 3) && var1 <= (this.field366 << 6) + (this.field370 << 3) + 7 && var2 >= (this.field375 << 6) + (this.field371 << 3) && var2 <= (this.field375 << 6) + (this.field371 << 3) + 7;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "12"
	)
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field366 * 64 - this.field364 * 64 + var2 + (this.field370 * 8 - this.field376 * 8), var3 + (this.field375 * 64 - this.field365 * 64) + (this.field371 * 8 - this.field369 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIB)Lhv;",
		garbageValue = "-13"
	)
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field364 * 64 - this.field366 * 64 + (this.field376 * 8 - this.field370 * 8) + var1;
			int var4 = this.field365 * 64 - this.field375 * 64 + var2 + (this.field369 * 8 - this.field371 * 8);
			return new Coord(this.field368, var3, var4);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "1767519038"
	)
	public void read(Buffer var1) {
		this.field368 = var1.readUnsignedByte();
		this.field363 = var1.readUnsignedByte();
		this.field364 = var1.readUnsignedShort();
		this.field376 = var1.readUnsignedByte();
		this.field365 = var1.readUnsignedShort();
		this.field369 = var1.readUnsignedByte();
		this.field366 = var1.readUnsignedShort();
		this.field370 = var1.readUnsignedByte();
		this.field375 = var1.readUnsignedShort();
		this.field371 = var1.readUnsignedByte();
		this.method744();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "33671142"
	)
	void method744() {
	}

	@ObfuscatedName("el")
	@ObfuscatedSignature(
		signature = "(Liu;Ljava/lang/String;I)V",
		garbageValue = "446000898"
	)
	static void method763(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field927 += var2.groupCount;
	}
}
