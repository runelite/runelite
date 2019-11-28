import java.net.URL;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class237 {
	@ObfuscatedName("u")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("b")
	int[] field3192;
	@ObfuscatedName("g")
	int[] field3193;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 136920125
	)
	int field3196;

	public class237() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3192 = new int[2048];
		this.field3193 = new int[2048];
		this.field3196 = 0;
		WorldMapSectionType.method265();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1518977792"
	)
	void method4404(int var1) {
		int var2 = var1 * 2 + 1;
		double var4 = (double)((float)var1 / 3.0F);
		int var6 = var1 * 2 + 1;
		double[] var7 = new double[var6];
		int var8 = -var1;

		for (int var9 = 0; var8 <= var1; ++var9) {
			double var16 = (double)(var8 - 0) / var4;
			double var14 = Math.exp(var16 * -var16 / 2.0D) / Math.sqrt(6.283185307179586D);
			double var12 = var14 / var4;
			var7[var9] = var12;
			++var8;
		}

		double[] var18 = var7;
		double var19 = var7[var1] * var7[var1];
		int[] var21 = new int[var2 * var2];
		boolean var22 = false;

		for (int var11 = 0; var11 < var2; ++var11) {
			for (int var23 = 0; var23 < var2; ++var23) {
				int var13 = var21[var23 + var11 * var2] = (int)(256.0D * (var18[var11] * var18[var23] / var19));
				if (!var22 && var13 > 0) {
					var22 = true;
				}
			}
		}

		Sprite var24 = new Sprite(var21, var2, var2);
		this.spriteMap.put(var1, var24);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IS)Lln;",
		garbageValue = "-15422"
	)
	Sprite method4405(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4404(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-106"
	)
	public final void method4406(int var1, int var2) {
		if (this.field3196 < this.field3192.length) {
			this.field3192[this.field3196] = var1;
			this.field3193[this.field3196] = var2;
			++this.field3196;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1194246226"
	)
	public final void method4403() {
		this.field3196 = 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IILln;FI)V",
		garbageValue = "-2013920472"
	)
	public final void method4408(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		Sprite var6 = this.method4405(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3196; ++var10) {
			var11 = this.field3192[var10];
			var12 = this.field3193[var10];
			int var13 = (int)((float)(var11 - var1) * var4) - var5;
			int var14 = (int)((float)var3.subHeight - var4 * (float)(var12 - var2)) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method6069(var8, var9);
			this.method4409(var6, var3, var9);
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
					if (var11 > Skeleton.field1788.length) {
						var11 = Skeleton.field1788.length;
					}

					var12 = Skeleton.field1788[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Lln;Lln;Llw;I)V",
		garbageValue = "244697744"
	)
	void method4409(Sprite var1, Sprite var2, Bounds var3) {
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
		garbageValue = "-79"
	)
	static boolean method4422(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class51.field424.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var4 = 0; var4 < var0.length(); ++var4) {
						if (var10.indexOf(var0.charAt(var4)) == -1) {
							throw new Exception();
						}
					}

					Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
					return true;
				}
			} catch (Throwable var5) {
				return false;
			}
		} else if (var1 == 1) {
			try {
				Object var3 = class47.method865(class51.applet, var2, new Object[]{(new URL(class51.applet.getCodeBase(), var0)).toString()});
				return var3 != null;
			} catch (Throwable var6) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_blank");
				return true;
			} catch (Exception var7) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				class47.method864(class51.applet, "loggedout");
			} catch (Throwable var9) {
			}

			try {
				class51.applet.getAppletContext().showDocument(new URL(class51.applet.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var8) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-152675892"
	)
	public static void method4421() {
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
	}
}
