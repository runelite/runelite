import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("q")
	long[] field2011;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 406251697
	)
	int field2014;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1542069259
	)
	int field2013;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = -5256643665710280471L
	)
	long field2012;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 729258425
	)
	int field2015;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1018209541
	)
	int field2016;

	MilliClock() {
		this.field2011 = new long[10];
		this.field2014 = 256;
		this.field2013 = 1;
		this.field2015 = 0;
		this.field2012 = DirectByteArrayCopier.currentTimeMs();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2011[var1] = this.field2012;
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1402657312"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2011[var1] = 0L;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-333181863"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field2014;
		int var4 = this.field2013;
		this.field2014 = 300;
		this.field2013 = 1;
		this.field2012 = DirectByteArrayCopier.currentTimeMs();
		if (this.field2011[this.field2016] == 0L) {
			this.field2014 = var3;
			this.field2013 = var4;
		} else if (this.field2012 > this.field2011[this.field2016]) {
			this.field2014 = (int)((long)(var1 * 2560) / (this.field2012 - this.field2011[this.field2016]));
		}

		if (this.field2014 < 25) {
			this.field2014 = 25;
		}

		if (this.field2014 > 256) {
			this.field2014 = 256;
			this.field2013 = (int)((long)var1 - (this.field2012 - this.field2011[this.field2016]) / 10L);
		}

		if (this.field2013 > var1) {
			this.field2013 = var1;
		}

		this.field2011[this.field2016] = this.field2012;
		this.field2016 = (this.field2016 + 1) % 10;
		int var5;
		if (this.field2013 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field2011[var5]) {
					this.field2011[var5] += (long)this.field2013;
				}
			}
		}

		if (this.field2013 < var2) {
			this.field2013 = var2;
		}

		EnumDefinition.method4550((long)this.field2013);

		for (var5 = 0; this.field2015 < 256; this.field2015 += this.field2014) {
			++var5;
		}

		this.field2015 &= 255;
		return var5;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "-93"
	)
	static int method3468(int var0, int var1, int var2) {
		if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
			return 0;
		} else {
			return var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0 ? var0 - 1 : var0;
		}
	}
}
