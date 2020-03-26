import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class247 {
	@ObfuscatedName("x")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("k")
	int[] field3186;
	@ObfuscatedName("d")
	int[] field3184;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1540963759
	)
	int field3188;

	public class247() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3186 = new int[2048];
		this.field3184 = new int[2048];
		this.field3188 = 0;
		class69.method1277();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "1"
	)
	void method4411(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = class105.method2395(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var2 * var8] = (int)(256.0D * (var3[var8] * var3[var9] / var4));
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		Sprite var11 = new Sprite(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Lla;",
		garbageValue = "1164975013"
	)
	Sprite method4402(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4411(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1687645228"
	)
	public final void method4405(int var1, int var2) {
		if (this.field3188 < this.field3186.length) {
			this.field3186[this.field3188] = var1;
			this.field3184[this.field3188] = var2;
			++this.field3188;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1569288926"
	)
	public final void method4406() {
		this.field3188 = 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IILla;FI)V",
		garbageValue = "1134396059"
	)
	public final void method4407(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		Sprite var6 = this.method4402(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3188; ++var10) {
			var11 = this.field3186[var10];
			var12 = this.field3184[var10];
			int var13 = (int)((float)(var11 - var1) * var4) - var5;
			int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method6047(var8, var9);
			this.method4426(var6, var3, var9);
		}

		System.nanoTime();
		System.nanoTime();

		for (var10 = 0; var10 < var3.pixels.length; ++var10) {
			if (var3.pixels[var10] == 0) {
				var3.pixels[var10] = -16777216;
			} else {
				var11 = (var3.pixels[var10] + 64 - 1) / 256;
				if (var11 <= 0) {
					var3.pixels[var10] = -16777216;
				} else {
					if (var11 > IntHashTable.field4034.length) {
						var11 = IntHashTable.field4034.length;
					}

					var12 = IntHashTable.field4034[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lla;Lla;Lld;I)V",
		garbageValue = "-1592905794"
	)
	void method4426(Sprite var1, Sprite var2, Bounds var3) {
		if (var3.highX != 0 && var3.highY != 0) {
			int var4 = 0;
			int var5 = 0;
			if (var3.lowX == 0) {
				var4 = var1.subWidth - var3.highX;
			}

			if (var3.lowY == 0) {
				var5 = var1.subHeight - var3.highY;
			}

			int var6 = var4 + var5 * var1.subWidth;
			int var7 = var2.subWidth * var3.lowY + var3.lowX;

			for (int var8 = 0; var8 < var3.highY; ++var8) {
				for (int var9 = 0; var9 < var3.highX; ++var9) {
					int[] var10000 = var2.pixels;
					int var10001 = var7++;
					var10000[var10001] += var1.pixels[var6++];
				}

				var6 += var1.subWidth - var3.highX;
				var7 += var2.subWidth - var3.highX;
			}

		}
	}
}
