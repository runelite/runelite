import java.awt.Component;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class237 {
	@ObfuscatedName("c")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llr;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("t")
	int[] field3163;
	@ObfuscatedName("g")
	int[] field3164;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -73461123
	)
	int field3165;

	public class237() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3163 = new int[2048];
		this.field3164 = new int[2048];
		this.field3165 = 0;
		MidiPcmStream.method3769();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-350747484"
	)
	void method4311(int var1) {
		int var2 = var1 * 2 + 1;
		double var4 = (double)((float)var1 / 3.0F);
		int var6 = var1 * 2 + 1;
		double[] var7 = new double[var6];
		int var8 = -var1;

		for (int var9 = 0; var8 <= var1; ++var9) {
			var7[var9] = GameShell.method1020((double)var8, 0.0D, var4);
			++var8;
		}

		double[] var14 = var7;
		double var15 = var7[var1] * var7[var1];
		int[] var17 = new int[var2 * var2];
		boolean var10 = false;

		for (int var11 = 0; var11 < var2; ++var11) {
			for (int var12 = 0; var12 < var2; ++var12) {
				int var13 = var17[var12 + var11 * var2] = (int)(var14[var12] * var14[var11] / var15 * 256.0D);
				if (!var10 && var13 > 0) {
					var10 = true;
				}
			}
		}

		Sprite var18 = new Sprite(var17, var2, var2);
		this.spriteMap.put(var1, var18);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lli;",
		garbageValue = "-1078597763"
	)
	Sprite method4293(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4311(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2019840424"
	)
	public final void method4319(int var1, int var2) {
		if (this.field3165 < this.field3163.length) {
			this.field3163[this.field3165] = var1;
			this.field3164[this.field3165] = var2;
			++this.field3165;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1110307323"
	)
	public final void method4295() {
		this.field3165 = 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IILli;FI)V",
		garbageValue = "-1921897333"
	)
	public final void method4296(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		Sprite var6 = this.method4293(var5);
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
			var12 = this.field3164[var10];
			int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
			int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method5948(var8, var9);
			this.method4297(var6, var3, var9);
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
					if (var11 > GrandExchangeOffer.field67.length) {
						var11 = GrandExchangeOffer.field67.length;
					}

					var12 = GrandExchangeOffer.field67[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lli;Lli;Llr;I)V",
		garbageValue = "-1641281756"
	)
	void method4297(Sprite var1, Sprite var2, Bounds var3) {
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;B)V",
		garbageValue = "1"
	)
	static void method4317(Component var0) {
		var0.setFocusTraversalKeysEnabled(false);
		var0.addKeyListener(KeyHandler.KeyHandler_instance);
		var0.addFocusListener(KeyHandler.KeyHandler_instance);
	}
}
