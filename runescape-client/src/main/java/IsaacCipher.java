import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
@Implements("IsaacCipher")
public final class IsaacCipher {
	@ObfuscatedName("es")
	@ObfuscatedGetter(
		intValue = 553718263
	)
	@Export("port2")
	static int port2;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -2000673999
	)
	@Export("valuesRemaining")
	int valuesRemaining;
	@ObfuscatedName("l")
	@Export("results")
	int[] results;
	@ObfuscatedName("u")
	@Export("mm")
	int[] mm;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -562212667
	)
	@Export("aa")
	int aa;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1651131677
	)
	@Export("bb")
	int bb;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1736617829
	)
	@Export("cc")
	int cc;

	public IsaacCipher(int[] var1) {
		this.mm = new int[256];
		this.results = new int[256];

		for (int var2 = 0; var2 < var1.length; ++var2) {
			this.results[var2] = var1[var2];
		}

		this.method6203();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "361058639"
	)
	@Export("nextInt")
	public final int nextInt() {
		if (this.valuesRemaining == 0) {
			this.generateMoreResults();
			this.valuesRemaining = 256;
		}

		return this.results[--this.valuesRemaining];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1313379717"
	)
	public final int method6210() {
		if (this.valuesRemaining == 0) {
			this.generateMoreResults();
			this.valuesRemaining = 256;
		}

		return this.results[this.valuesRemaining - 1];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1660936627"
	)
	@Export("generateMoreResults")
	final void generateMoreResults() {
		this.bb += ++this.cc;

		for (int var1 = 0; var1 < 256; ++var1) {
			int var2 = this.mm[var1];
			if ((var1 & 2) == 0) {
				if ((var1 & 1) == 0) {
					this.aa ^= this.aa << 13;
				} else {
					this.aa ^= this.aa >>> 6;
				}
			} else if ((var1 & 1) == 0) {
				this.aa ^= this.aa << 2;
			} else {
				this.aa ^= this.aa >>> 16;
			}

			this.aa += this.mm[128 + var1 & 255];
			int var3;
			this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.bb + this.aa;
			this.results[var1] = this.bb = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2007825108"
	)
	final void method6203() {
		int var9 = -1640531527;
		int var8 = -1640531527;
		int var7 = -1640531527;
		int var6 = -1640531527;
		int var5 = -1640531527;
		int var4 = -1640531527;
		int var3 = -1640531527;
		int var2 = -1640531527;

		int var1;
		for (var1 = 0; var1 < 4; ++var1) {
			var2 ^= var3 << 11;
			var5 += var2;
			var3 += var4;
			var3 ^= var4 >>> 2;
			var6 += var3;
			var4 += var5;
			var4 ^= var5 << 8;
			var7 += var4;
			var5 += var6;
			var5 ^= var6 >>> 16;
			var8 += var5;
			var6 += var7;
			var6 ^= var7 << 10;
			var9 += var6;
			var7 += var8;
			var7 ^= var8 >>> 4;
			var2 += var7;
			var8 += var9;
			var8 ^= var9 << 8;
			var3 += var8;
			var9 += var2;
			var9 ^= var2 >>> 9;
			var4 += var9;
			var2 += var3;
		}

		for (var1 = 0; var1 < 256; var1 += 8) {
			var2 += this.results[var1];
			var3 += this.results[var1 + 1];
			var4 += this.results[var1 + 2];
			var5 += this.results[var1 + 3];
			var6 += this.results[var1 + 4];
			var7 += this.results[var1 + 5];
			var8 += this.results[var1 + 6];
			var9 += this.results[var1 + 7];
			var2 ^= var3 << 11;
			var5 += var2;
			var3 += var4;
			var3 ^= var4 >>> 2;
			var6 += var3;
			var4 += var5;
			var4 ^= var5 << 8;
			var7 += var4;
			var5 += var6;
			var5 ^= var6 >>> 16;
			var8 += var5;
			var6 += var7;
			var6 ^= var7 << 10;
			var9 += var6;
			var7 += var8;
			var7 ^= var8 >>> 4;
			var2 += var7;
			var8 += var9;
			var8 ^= var9 << 8;
			var3 += var8;
			var9 += var2;
			var9 ^= var2 >>> 9;
			var4 += var9;
			var2 += var3;
			this.mm[var1] = var2;
			this.mm[var1 + 1] = var3;
			this.mm[var1 + 2] = var4;
			this.mm[var1 + 3] = var5;
			this.mm[var1 + 4] = var6;
			this.mm[var1 + 5] = var7;
			this.mm[var1 + 6] = var8;
			this.mm[var1 + 7] = var9;
		}

		for (var1 = 0; var1 < 256; var1 += 8) {
			var2 += this.mm[var1];
			var3 += this.mm[var1 + 1];
			var4 += this.mm[var1 + 2];
			var5 += this.mm[var1 + 3];
			var6 += this.mm[var1 + 4];
			var7 += this.mm[var1 + 5];
			var8 += this.mm[var1 + 6];
			var9 += this.mm[var1 + 7];
			var2 ^= var3 << 11;
			var5 += var2;
			var3 += var4;
			var3 ^= var4 >>> 2;
			var6 += var3;
			var4 += var5;
			var4 ^= var5 << 8;
			var7 += var4;
			var5 += var6;
			var5 ^= var6 >>> 16;
			var8 += var5;
			var6 += var7;
			var6 ^= var7 << 10;
			var9 += var6;
			var7 += var8;
			var7 ^= var8 >>> 4;
			var2 += var7;
			var8 += var9;
			var8 ^= var9 << 8;
			var3 += var8;
			var9 += var2;
			var9 ^= var2 >>> 9;
			var4 += var9;
			var2 += var3;
			this.mm[var1] = var2;
			this.mm[var1 + 1] = var3;
			this.mm[var1 + 2] = var4;
			this.mm[var1 + 3] = var5;
			this.mm[var1 + 4] = var6;
			this.mm[var1 + 5] = var7;
			this.mm[var1 + 6] = var8;
			this.mm[var1 + 7] = var9;
		}

		this.generateMoreResults();
		this.valuesRemaining = 256;
	}
}
