import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class42 implements WorldMapSection {
	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("worldSelectBackSprites")
	static Sprite[] worldSelectBackSprites;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	static IndexedSprite field364;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1474152669
	)
	int field370;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1928734715
	)
	int field361;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1228215067
	)
	int field371;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1297027701
	)
	int field363;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -114767203
	)
	int field362;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 318560359
	)
	int field365;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1391575641
	)
	int field366;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1608149363
	)
	int field367;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -2127073261
	)
	int field368;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -395386295
	)
	int field369;

	class42() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Laf;I)V",
		garbageValue = "-567179164"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field362) {
			var1.regionLowX = this.field362;
		}

		if (var1.regionHighX < this.field362) {
			var1.regionHighX = this.field362;
		}

		if (var1.regionLowY > this.field365) {
			var1.regionLowY = this.field365;
		}

		if (var1.regionHighY < this.field365) {
			var1.regionHighY = this.field365;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "0"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field370 && var1 < this.field361 + this.field370) {
			return var2 >= (this.field371 << 6) + (this.field366 << 3) && var2 <= (this.field371 << 6) + (this.field366 << 3) + 7 && var3 >= (this.field363 << 6) + (this.field367 << 3) && var3 <= (this.field363 << 6) + (this.field367 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "110675609"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field362 << 6) + (this.field368 << 3) && var1 <= (this.field362 << 6) + (this.field368 << 3) + 7 && var2 >= (this.field365 << 6) + (this.field369 << 3) && var2 <= (this.field365 << 6) + (this.field369 << 3) + 7;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "69"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field362 * 64 - this.field371 * 64 + var2 + (this.field368 * 8 - this.field366 * 8), var3 + (this.field365 * 64 - this.field363 * 64) + (this.field369 * 8 - this.field367 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)Lhx;",
		garbageValue = "1062204141"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field371 * 64 - this.field362 * 64 + (this.field366 * 8 - this.field368 * 8) + var1;
			int var4 = this.field363 * 64 - this.field365 * 64 + var2 + (this.field367 * 8 - this.field369 * 8);
			return new Coord(this.field370, var3, var4);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-179898655"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field370 = var1.readUnsignedByte();
		this.field361 = var1.readUnsignedByte();
		this.field371 = var1.readUnsignedShort();
		this.field366 = var1.readUnsignedByte();
		this.field363 = var1.readUnsignedShort();
		this.field367 = var1.readUnsignedByte();
		this.field362 = var1.readUnsignedShort();
		this.field368 = var1.readUnsignedByte();
		this.field365 = var1.readUnsignedShort();
		this.field369 = var1.readUnsignedByte();
		this.method795();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1221961977"
	)
	void method795() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Lix;",
		garbageValue = "-2061319703"
	)
	public static HitSplatDefinition method811(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)Liz;",
		garbageValue = "-13"
	)
	public static HealthBarDefinition method810(int var0) {
		HealthBarDefinition var1 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var0);
			var1 = new HealthBarDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IZIZB)V",
		garbageValue = "71"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (Skills.World_worlds != null) {
			WorldMapData_1.doWorldSorting(0, Skills.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)I",
		garbageValue = "-5"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + Skills.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2010130113"
	)
	static void method809() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.field1248[var0] = null;
			Players.field1247[var0] = 1;
		}

	}
}
