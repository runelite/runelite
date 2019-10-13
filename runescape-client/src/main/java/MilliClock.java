import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("z")
	long[] field1993;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1174263325
	)
	int field1992;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -133065269
	)
	int field1994;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = 4855142476282651555L
	)
	long field1997;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -118742351
	)
	int field1996;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -432514755
	)
	int field1995;

	MilliClock() {
		this.field1993 = new long[10];
		this.field1992 = 256;
		this.field1994 = 1;
		this.field1996 = 0;
		this.field1997 = class30.currentTimeMillis();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1993[var1] = this.field1997;
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-54"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1993[var1] = 0L;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "569029249"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1992;
		int var4 = this.field1994;
		this.field1992 = 300;
		this.field1994 = 1;
		this.field1997 = class30.currentTimeMillis();
		if (0L == this.field1993[this.field1995]) {
			this.field1992 = var3;
			this.field1994 = var4;
		} else if (this.field1997 > this.field1993[this.field1995]) {
			this.field1992 = (int)((long)(var1 * 2560) / (this.field1997 - this.field1993[this.field1995]));
		}

		if (this.field1992 < 25) {
			this.field1992 = 25;
		}

		if (this.field1992 > 256) {
			this.field1992 = 256;
			this.field1994 = (int)((long)var1 - (this.field1997 - this.field1993[this.field1995]) / 10L);
		}

		if (this.field1994 > var1) {
			this.field1994 = var1;
		}

		this.field1993[this.field1995] = this.field1997;
		this.field1995 = (this.field1995 + 1) % 10;
		if (this.field1994 > 1) {
			for (int var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field1993[var5]) {
					this.field1993[var5] += (long)this.field1994;
				}
			}
		}

		if (this.field1994 < var2) {
			this.field1994 = var2;
		}

		long var10 = (long)this.field1994;
		if (var10 > 0L) {
			if (var10 % 10L == 0L) {
				long var7 = var10 - 1L;

				try {
					Thread.sleep(var7);
				} catch (InterruptedException var16) {
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var15) {
				}
			} else {
				try {
					Thread.sleep(var10);
				} catch (InterruptedException var14) {
				}
			}
		}

		int var13;
		for (var13 = 0; this.field1996 < 256; this.field1996 += this.field1992) {
			++var13;
		}

		this.field1996 &= 255;
		return var13;
	}
}
