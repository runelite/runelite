import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class237 {
	@ObfuscatedName("c")
	static int[] field3189;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 1134867961
	)
	static int field3191;
	@ObfuscatedName("q")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("e")
	int[] field3184;
	@ObfuscatedName("p")
	int[] field3182;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1881453341
	)
	int field3190;

	public class237() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3184 = new int[2048];
		this.field3182 = new int[2048];
		this.field3190 = 0;
		field3189 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = Username.method5217((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.425F * (float)var1 / 16.0F + 0.075F));
			field3189[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < field3189.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = Username.method5217((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < field3189.length; ++var1) {
				field3189[var1] = var5;
			}
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1241140434"
	)
	void method4317(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = ClientParameter.method4992(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var8 * var2] = (int)(256.0D * (var3[var9] * var3[var8] / var4));
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		Sprite var11 = new Sprite(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lly;",
		garbageValue = "314101713"
	)
	Sprite method4318(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4317(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-97"
	)
	public final void method4316(int var1, int var2) {
		if (this.field3190 < this.field3184.length) {
			this.field3184[this.field3190] = var1;
			this.field3182[this.field3190] = var2;
			++this.field3190;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "25"
	)
	public final void method4320() {
		this.field3190 = 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IILly;FI)V",
		garbageValue = "-690333183"
	)
	public final void method4321(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(18.0F * var4);
		Sprite var6 = this.method4318(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3190; ++var10) {
			var11 = this.field3184[var10];
			var12 = this.field3182[var10];
			int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
			int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method5980(var8, var9);
			this.method4322(var6, var3, var9);
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
					if (var11 > field3189.length) {
						var11 = field3189.length;
					}

					var12 = field3189[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lly;Lly;Lls;I)V",
		garbageValue = "1272955038"
	)
	void method4322(Sprite var1, Sprite var2, Bounds var3) {
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
