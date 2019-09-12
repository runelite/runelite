import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("j")
	int[] field1005;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1528929727
	)
	int field1006;
	@ObfuscatedName("d")
	int[] field1017;
	@ObfuscatedName("z")
	int[] field1008;
	@ObfuscatedName("n")
	int[] field1009;
	@ObfuscatedName("h")
	int[] field1004;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -514534825
	)
	int field1011;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1900853499
	)
	int field1012;
	@ObfuscatedName("p")
	int[] field1010;
	@ObfuscatedName("e")
	int[] field1001;
	@ObfuscatedName("i")
	int[] field1015;
	@ObfuscatedName("q")
	int[] field1016;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 2099067717
	)
	int field1014;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -2027806404
	)
	int field1018;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 707933173
	)
	int field1007;

	@ObfuscatedSignature(
		signature = "([Llt;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1005 = new int[256];
		this.field1006 = 0;
		this.field1011 = 0;
		this.field1012 = 0;
		this.field1014 = 0;
		this.field1018 = 0;
		this.field1007 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1074416899"
	)
	@Export("initColors")
	void initColors() {
		this.field1008 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1008[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1008[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1008[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1008[var1 + 192] = 16777215;
		}

		this.field1009 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1009[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1009[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1009[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1009[var1 + 192] = 16777215;
		}

		this.field1004 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1004[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1004[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1004[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1004[var1 + 192] = 16777215;
		}

		this.field1017 = new int[256];
		this.field1014 = 0;
		this.field1015 = new int[32768];
		this.field1016 = new int[32768];
		this.method1793((IndexedSprite)null);
		this.field1010 = new int[32768];
		this.field1001 = new int[32768];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1305859350"
	)
	void method1795() {
		this.field1008 = null;
		this.field1009 = null;
		this.field1004 = null;
		this.field1017 = null;
		this.field1015 = null;
		this.field1016 = null;
		this.field1010 = null;
		this.field1001 = null;
		this.field1014 = 0;
		this.field1018 = 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1547011185"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1010 == null) {
			this.initColors();
		}

		if (this.field1007 == 0) {
			this.field1007 = var2;
		}

		int var3 = var2 - this.field1007;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1007 = var2;
		if (var3 > 0) {
			this.method1768(var3);
		}

		this.method1801(var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "640214490"
	)
	final void method1768(int var1) {
		this.field1014 += 128 * var1;
		int var2;
		if (this.field1014 > this.field1015.length) {
			this.field1014 -= this.field1015.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1793(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1010[var2 + var3] - this.field1015[var2 + this.field1014 & this.field1015.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1010[var2++] = var6;
		}

		byte var15 = 10;
		var6 = 128 - var15;

		int var7;
		int var10;
		for (var7 = 256 - var1; var7 < 256; ++var7) {
			int var8 = var7 * 128;

			for (int var9 = 0; var9 < 128; ++var9) {
				var10 = (int)(Math.random() * 100.0D);
				if (var10 < 50 && var9 > var15 && var9 < var6) {
					this.field1010[var9 + var8] = 255;
				} else {
					this.field1010[var9 + var8] = 0;
				}
			}
		}

		if (this.field1011 * 16 > 0) {
			this.field1011 = this.field1011 * 16 - var1 * 4;
		}

		if (this.field1012 * 16 > 0) {
			this.field1012 = this.field1012 * 16 - var1 * 4;
		}

		if (this.field1011 * 16 == 0 && this.field1012 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1011 = 1024;
			}

			if (var7 == 1) {
				this.field1012 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1005[var7] = this.field1005[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1005[var7] = (int)(Math.sin((double)this.field1006 / 14.0D) * 16.0D + Math.sin((double)this.field1006 / 15.0D) * 14.0D + Math.sin((double)this.field1006 / 16.0D) * 12.0D);
			++this.field1006;
		}

		this.field1018 = this.field1018 * 10000 + var1 * 100;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1018 * 10000; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1010[var12 + (var13 << 7)] = 192;
			}

			this.field1018 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var7 + var14 < 128) {
						var12 += this.field1010[var7 + var13 + var14];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1010[var14 + var13 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1001[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1001[var11 + var14 + var7 * 128];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1001[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1010[var14 + var11] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIIS)I",
		garbageValue = "256"
	)
	final int method1769(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-495536529"
	)
	final void method1801(int var1) {
		int var2 = this.field1017.length;
		if (this.field1011 * 16 > 0) {
			this.method1771(this.field1011 * 16, this.field1009);
		} else if (this.field1012 * 16 > 0) {
			this.method1771(this.field1012 * 16, this.field1004);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1017[var3] = this.field1008[var3];
			}
		}

		this.method1770(var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I[IB)V",
		garbageValue = "-27"
	)
	final void method1771(int var1, int[] var2) {
		int var3 = this.field1017.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1017[var4] = this.method1769(this.field1008[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1017[var4] = var2[var4];
			} else {
				this.field1017[var4] = this.method1769(var2[var4], this.field1008[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "8"
	)
	final void method1770(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1005[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= DevicePcmPlayerProvider.rasterProvider.width) {
				var7 = DevicePcmPlayerProvider.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * DevicePcmPlayerProvider.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1010[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1017[var10];
					int var14 = DevicePcmPlayerProvider.rasterProvider.pixels[var8];
					DevicePcmPlayerProvider.rasterProvider.pixels[var8++] = -16777216 | (var13 * (var14 & 65280) + var12 * (var10 & 65280) & 16711680) + ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Llt;I)V",
		garbageValue = "833980793"
	)
	final void method1793(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1015.length; ++var2) {
			this.field1015[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1015[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1016[var5] = (this.field1015[var5 + 128] + this.field1015[var5 - 128] + this.field1015[var5 + 1] + this.field1015[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1015;
			this.field1015 = this.field1016;
			this.field1016 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1015[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([I[IB)V",
		garbageValue = "60"
	)
	public static void method1802(int[] var0, int[] var1) {
		if (var0 != null && var1 != null) {
			ByteArrayPool.ByteArrayPool_alternativeSizes = var0;
			Login.ByteArrayPool_altSizeArrayCounts = new int[var0.length];
			WorldMapEvent.ByteArrayPool_arrays = new byte[var0.length][][];

			for (int var2 = 0; var2 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var2) {
				WorldMapEvent.ByteArrayPool_arrays[var2] = new byte[var1[var2]][];
			}

		} else {
			ByteArrayPool.ByteArrayPool_alternativeSizes = null;
			Login.ByteArrayPool_altSizeArrayCounts = null;
			WorldMapEvent.ByteArrayPool_arrays = null;
		}
	}
}
