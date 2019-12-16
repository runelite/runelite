import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("oj")
	@ObfuscatedSignature(
		signature = "Lck;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("Widget_fontsArchive")
	static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("f")
	long[] field2005;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1395433479
	)
	int field1999;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -814171189
	)
	int field1998;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = 7702672897497334159L
	)
	long field1996;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1971877303
	)
	int field1997;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1477924713
	)
	int field2001;

	MilliClock() {
		this.field2005 = new long[10];
		this.field1999 = 256;
		this.field1998 = 1;
		this.field1997 = 0;
		this.field1996 = WorldMapID.currentTimeMillis();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2005[var1] = this.field1996;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "4"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2005[var1] = 0L;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "670539248"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1999;
		int var4 = this.field1998;
		this.field1999 = 300;
		this.field1998 = 1;
		this.field1996 = WorldMapID.currentTimeMillis();
		if (0L == this.field2005[this.field2001]) {
			this.field1999 = var3;
			this.field1998 = var4;
		} else if (this.field1996 > this.field2005[this.field2001]) {
			this.field1999 = (int)((long)(var1 * 2560) / (this.field1996 - this.field2005[this.field2001]));
		}

		if (this.field1999 < 25) {
			this.field1999 = 25;
		}

		if (this.field1999 > 256) {
			this.field1999 = 256;
			this.field1998 = (int)((long)var1 - (this.field1996 - this.field2005[this.field2001]) / 10L);
		}

		if (this.field1998 > var1) {
			this.field1998 = var1;
		}

		this.field2005[this.field2001] = this.field1996;
		this.field2001 = (this.field2001 + 1) % 10;
		int var5;
		if (this.field1998 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (this.field2005[var5] != 0L) {
					this.field2005[var5] += (long)this.field1998;
				}
			}
		}

		if (this.field1998 < var2) {
			this.field1998 = var2;
		}

		ServerBuild.method4111((long)this.field1998);

		for (var5 = 0; this.field1997 < 256; this.field1997 += this.field1999) {
			++var5;
		}

		this.field1997 &= 255;
		return var5;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "176449942"
	)
	static int method3447(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}
}
