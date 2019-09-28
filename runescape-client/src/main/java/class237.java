import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class237 {
	@ObfuscatedName("z")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("v")
	int[] field3163;
	@ObfuscatedName("u")
	int[] field3161;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 459040833
	)
	int field3165;

	public class237() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3163 = new int[2048];
		this.field3161 = new int[2048];
		this.field3165 = 0;
		class267.field3540 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = ScriptFrame.method1158((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.075F + 0.425F * (float)var1 / 16.0F));
			class267.field3540[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < class267.field3540.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = ScriptFrame.method1158((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < class267.field3540.length; ++var1) {
				class267.field3540[var1] = var5;
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1811962046"
	)
	void method4299(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = class287.method5221(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var8 * var2] = (int)(256.0D * (var3[var8] * var3[var9] / var4));
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		Sprite var11 = new Sprite(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)Llf;",
		garbageValue = "-125"
	)
	Sprite method4298(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4299(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-43"
	)
	public final void method4301(int var1, int var2) {
		if (this.field3165 < this.field3163.length) {
			this.field3163[this.field3165] = var1;
			this.field3161[this.field3165] = var2;
			++this.field3165;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1335191014"
	)
	public final void method4300() {
		this.field3165 = 0;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IILlf;FI)V",
		garbageValue = "-177737442"
	)
	public final void method4303(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		Sprite var6 = this.method4298(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3165; ++var10) {
			var11 = this.field3163[var10];
			var12 = this.field3161[var10];
			int var13 = (int)((float)(var11 - var1) * var4) - var5;
			int var14 = (int)((float)var3.subHeight - var4 * (float)(var12 - var2)) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method5913(var8, var9);
			this.method4304(var6, var3, var9);
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
					if (var11 > class267.field3540.length) {
						var11 = class267.field3540.length;
					}

					var12 = class267.field3540[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Llf;Llf;Lll;I)V",
		garbageValue = "-1255792875"
	)
	void method4304(Sprite var1, Sprite var2, Bounds var3) {
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
			int var7 = var3.lowX + var2.subWidth * var3.lowY;

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
