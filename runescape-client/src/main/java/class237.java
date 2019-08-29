import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class237 {
	@ObfuscatedName("x")
	static int[] field3171;
	@ObfuscatedName("s")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("i")
	int[] field3168;
	@ObfuscatedName("k")
	int[] field3170;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -719138889
	)
	int field3169;

	public class237() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3168 = new int[2048];
		this.field3170 = new int[2048];
		this.field3169 = 0;
		field3171 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = Decimator.method2452((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.425F * (float)var1 / 16.0F + 0.075F));
			field3171[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < field3171.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = Decimator.method2452((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < field3171.length; ++var1) {
				field3171[var1] = var5;
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "62"
	)
	void method4238(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = Entity.method3211(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var8 * var2] = (int)(var3[var9] * var3[var8] / var4 * 256.0D);
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		Sprite var11 = new Sprite(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Lls;",
		garbageValue = "-588854887"
	)
	Sprite method4240(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4238(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "64"
	)
	public final void method4237(int var1, int var2) {
		if (this.field3169 < this.field3168.length) {
			this.field3168[this.field3169] = var1;
			this.field3170[this.field3169] = var2;
			++this.field3169;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-516549049"
	)
	public final void method4241() {
		this.field3169 = 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IILls;FB)V",
		garbageValue = "20"
	)
	public final void method4242(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		Sprite var6 = this.method4240(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3169; ++var10) {
			var11 = this.field3168[var10];
			var12 = this.field3170[var10];
			int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
			int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method5846(var8, var9);
			this.method4243(var6, var3, var9);
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
					if (var11 > field3171.length) {
						var11 = field3171.length;
					}

					var12 = field3171[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lls;Lls;Llh;I)V",
		garbageValue = "2027026702"
	)
	void method4243(Sprite var1, Sprite var2, Bounds var3) {
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
