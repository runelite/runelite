import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class237 {
	@ObfuscatedName("a")
	static int[] field3164;
	@ObfuscatedName("f")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("y")
	int[] field3160;
	@ObfuscatedName("w")
	int[] field3161;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1798727119
	)
	int field3162;

	public class237() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3160 = new int[2048];
		this.field3161 = new int[2048];
		this.field3162 = 0;
		field3164 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = Tiles.method1121((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)((float)var1 * 0.425F / 16.0F + 0.075F));
			field3164[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < field3164.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = Tiles.method1121((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < field3164.length; ++var1) {
				field3164[var1] = var5;
			}
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2086190547"
	)
	void method4301(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = class289.method5336(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var8 * var2] = (int)(var3[var8] * var3[var9] / var4 * 256.0D);
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		Sprite var11 = new Sprite(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)Lls;",
		garbageValue = "-60"
	)
	Sprite method4302(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4301(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1391492570"
	)
	public final void method4303(int var1, int var2) {
		if (this.field3162 < this.field3160.length) {
			this.field3160[this.field3162] = var1;
			this.field3161[this.field3162] = var2;
			++this.field3162;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-938639376"
	)
	public final void method4304() {
		this.field3162 = 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IILls;FI)V",
		garbageValue = "-501073565"
	)
	public final void method4318(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		Sprite var6 = this.method4302(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3162; ++var10) {
			var11 = this.field3160[var10];
			var12 = this.field3161[var10];
			int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
			int var14 = (int)((float)var3.subHeight - var4 * (float)(var12 - var2)) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method5997(var8, var9);
			this.method4306(var6, var3, var9);
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
					if (var11 > field3164.length) {
						var11 = field3164.length;
					}

					var12 = field3164[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lls;Lls;Llh;I)V",
		garbageValue = "-17705083"
	)
	void method4306(Sprite var1, Sprite var2, Bounds var3) {
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1561661467"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1306967480"
	)
	public static void method4300() {
		NPCDefinition.NpcDefinition_cached.clear();
		NPCDefinition.NpcDefinition_cachedModels.clear();
	}
}
