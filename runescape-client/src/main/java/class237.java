import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class237 {
	@ObfuscatedName("i")
	static int[] field3174;
	@ObfuscatedName("a")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("n")
	int[] field3178;
	@ObfuscatedName("q")
	int[] field3172;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -82085665
	)
	int field3169;

	public class237() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3178 = new int[2048];
		this.field3172 = new int[2048];
		this.field3169 = 0;
		MusicPatchNode2.method3829();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-324807595"
	)
	void method4474(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = GrandExchangeEvent.method123(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var2 * var8] = (int)(var3[var9] * var3[var8] / var4 * 256.0D);
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
		signature = "(II)Llx;",
		garbageValue = "165886637"
	)
	Sprite method4475(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method4474(var1);
		}

		return (Sprite)this.spriteMap.get(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "0"
	)
	public final void method4476(int var1, int var2) {
		if (this.field3169 < this.field3178.length) {
			this.field3178[this.field3169] = var1;
			this.field3172[this.field3169] = var2;
			++this.field3169;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1020689105"
	)
	public final void method4482() {
		this.field3169 = 0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IILlx;FI)V",
		garbageValue = "1589672394"
	)
	public final void method4478(int var1, int var2, Sprite var3, float var4) {
		int var5 = (int)(18.0F * var4);
		Sprite var6 = this.method4475(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3169; ++var10) {
			var11 = this.field3178[var10];
			var12 = this.field3172[var10];
			int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
			int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method6081(var8, var9);
			this.method4481(var6, var3, var9);
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
					if (var11 > field3174.length) {
						var11 = field3174.length;
					}

					var12 = field3174[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Llx;Llx;Lls;B)V",
		garbageValue = "-75"
	)
	void method4481(Sprite var1, Sprite var2, Bounds var3) {
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1735465507"
	)
	@Export("isKeyDown")
	public static final boolean isKeyDown() {
		synchronized(KeyHandler.KeyHandler_instance) {
			if (KeyHandler.field385 == KeyHandler.field370) {
				return false;
			} else {
				WorldMapLabel.field229 = KeyHandler.field382[KeyHandler.field385];
				DevicePcmPlayerProvider.field395 = KeyHandler.field381[KeyHandler.field385];
				KeyHandler.field385 = KeyHandler.field385 + 1 & 127;
				return true;
			}
		}
	}
}
