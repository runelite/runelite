import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("bi")
	static String field1994;
	@ObfuscatedName("a")
	long[] field1998;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1886190585
	)
	int field1995;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 741454683
	)
	int field1996;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = 1567518656598544647L
	)
	long field1997;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1704132259
	)
	int field1999;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1589265453
	)
	int field2000;

	public MilliClock() {
		this.field1998 = new long[10];
		this.field1995 = 256;
		this.field1996 = 1;
		this.field1999 = 0;
		this.field1997 = PlayerAppearance.currentTimeMillis();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1998[var1] = this.field1997;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1605126906"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1998[var1] = 0L;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "432238723"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1995;
		int var4 = this.field1996;
		this.field1995 = 300;
		this.field1996 = 1;
		this.field1997 = PlayerAppearance.currentTimeMillis();
		if (this.field1998[this.field2000] == 0L) {
			this.field1995 = var3;
			this.field1996 = var4;
		} else if (this.field1997 > this.field1998[this.field2000]) {
			this.field1995 = (int)((long)(var1 * 2560) / (this.field1997 - this.field1998[this.field2000]));
		}

		if (this.field1995 < 25) {
			this.field1995 = 25;
		}

		if (this.field1995 > 256) {
			this.field1995 = 256;
			this.field1996 = (int)((long)var1 - (this.field1997 - this.field1998[this.field2000]) / 10L);
		}

		if (this.field1996 > var1) {
			this.field1996 = var1;
		}

		this.field1998[this.field2000] = this.field1997;
		this.field2000 = (this.field2000 + 1) % 10;
		int var5;
		if (this.field1996 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (this.field1998[var5] != 0L) {
					this.field1998[var5] += (long)this.field1996;
				}
			}
		}

		if (this.field1996 < var2) {
			this.field1996 = var2;
		}

		ClanChat.method5367((long)this.field1996);

		for (var5 = 0; this.field1999 < 256; this.field1999 += this.field1995) {
			++var5;
		}

		this.field1999 &= 255;
		return var5;
	}

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "436263166"
	)
	static final void method3604() {
		Client.field824 = Client.cycleCntr;
	}
}
