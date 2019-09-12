import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("qb")
	@ObfuscatedGetter(
		intValue = -669204480
	)
	static int field1990;
	@ObfuscatedName("c")
	long[] field1982;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1242742979
	)
	int field1983;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1756511381
	)
	int field1991;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = 2067357926353532881L
	)
	long field1985;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1118758251
	)
	int field1986;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1868084299
	)
	int field1987;

	MilliClock() {
		this.field1982 = new long[10];
		this.field1983 = 256;
		this.field1991 = 1;
		this.field1986 = 0;
		this.field1985 = SoundCache.method2480();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1982[var1] = this.field1985;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-250719361"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1982[var1] = 0L;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1652957447"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1983;
		int var4 = this.field1991;
		this.field1983 = 300;
		this.field1991 = 1;
		this.field1985 = SoundCache.method2480();
		if (this.field1982[this.field1987] == 0L) {
			this.field1983 = var3;
			this.field1991 = var4;
		} else if (this.field1985 > this.field1982[this.field1987]) {
			this.field1983 = (int)((long)(var1 * 2560) / (this.field1985 - this.field1982[this.field1987]));
		}

		if (this.field1983 < 25) {
			this.field1983 = 25;
		}

		if (this.field1983 > 256) {
			this.field1983 = 256;
			this.field1991 = (int)((long)var1 - (this.field1985 - this.field1982[this.field1987]) / 10L);
		}

		if (this.field1991 > var1) {
			this.field1991 = var1;
		}

		this.field1982[this.field1987] = this.field1985;
		this.field1987 = (this.field1987 + 1) % 10;
		int var5;
		if (this.field1991 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field1982[var5]) {
					this.field1982[var5] += (long)this.field1991;
				}
			}
		}

		if (this.field1991 < var2) {
			this.field1991 = var2;
		}

		FriendsList.sleepMillis((long)this.field1991);

		for (var5 = 0; this.field1986 < 256; this.field1986 += this.field1983) {
			++var5;
		}

		this.field1986 &= 255;
		return var5;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;ZB)[B",
		garbageValue = "-72"
	)
	@Export("serialize")
	public static byte[] serialize(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var6 = (byte[])((byte[])var0);
			if (var1) {
				int var4 = var6.length;
				byte[] var5 = new byte[var4];
				System.arraycopy(var6, 0, var5, 0, var4);
				return var5;
			} else {
				return var6;
			}
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "578447595"
	)
	public static boolean method3432(int var0) {
		return (var0 >> 30 & 1) != 0;
	}
}
