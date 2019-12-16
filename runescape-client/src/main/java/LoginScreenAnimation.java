import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("e")
	int[] field1009;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -225886709
	)
	int field1008;
	@ObfuscatedName("a")
	int[] field1016;
	@ObfuscatedName("d")
	int[] field1012;
	@ObfuscatedName("c")
	int[] field1013;
	@ObfuscatedName("o")
	int[] field1014;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1086641703
	)
	int field1005;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -937900497
	)
	int field1011;
	@ObfuscatedName("s")
	int[] field1017;
	@ObfuscatedName("l")
	int[] field1018;
	@ObfuscatedName("t")
	int[] field1019;
	@ObfuscatedName("j")
	int[] field1020;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 142712185
	)
	int field1021;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1690408336
	)
	int field1022;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -431156339
	)
	int field1023;

	@ObfuscatedSignature(
		signature = "([Lli;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1009 = new int[256];
		this.field1008 = 0;
		this.field1005 = 0;
		this.field1011 = 0;
		this.field1021 = 0;
		this.field1022 = 0;
		this.field1023 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-309533051"
	)
	@Export("initColors")
	void initColors() {
		this.field1012 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1012[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1012[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1012[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1012[var1 + 192] = 16777215;
		}

		this.field1013 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1 + 192] = 16777215;
		}

		this.field1014 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1 + 192] = 16777215;
		}

		this.field1016 = new int[256];
		this.field1021 = 0;
		this.field1019 = new int[32768];
		this.field1020 = new int[32768];
		this.method1824((IndexedSprite)null);
		this.field1017 = new int[32768];
		this.field1018 = new int[32768];
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "140208699"
	)
	void method1812() {
		this.field1012 = null;
		this.field1013 = null;
		this.field1014 = null;
		this.field1016 = null;
		this.field1019 = null;
		this.field1020 = null;
		this.field1017 = null;
		this.field1018 = null;
		this.field1021 = 0;
		this.field1022 = 0;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-211420525"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1017 == null) {
			this.initColors();
		}

		if (this.field1023 == 0) {
			this.field1023 = var2;
		}

		int var3 = var2 - this.field1023;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1023 = var2;
		if (var3 > 0) {
			this.method1807(var3);
		}

		this.method1809(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	final void method1807(int var1) {
		this.field1021 += 128 * var1;
		int var2;
		if (this.field1021 > this.field1019.length) {
			this.field1021 -= this.field1019.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1824(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1017[var3 + var2] - this.field1019[var2 + this.field1021 & this.field1019.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1017[var2++] = var6;
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
					this.field1017[var8 + var9] = 255;
				} else {
					this.field1017[var9 + var8] = 0;
				}
			}
		}

		if (this.field1005 * 16 > 0) {
			this.field1005 = this.field1005 * 16 - var1 * 4;
		}

		if (this.field1011 * 16 > 0) {
			this.field1011 = this.field1011 * 16 - var1 * 4;
		}

		if (this.field1005 * 16 == 0 && this.field1011 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1005 = 1024;
			}

			if (var7 == 1) {
				this.field1011 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1009[var7] = this.field1009[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1009[var7] = (int)(Math.sin((double)this.field1008 / 14.0D) * 16.0D + Math.sin((double)this.field1008 / 15.0D) * 14.0D + Math.sin((double)this.field1008 / 16.0D) * 12.0D);
			++this.field1008;
		}

		this.field1022 = this.field1022 * 10000 + var1 * 10000;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1022 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1017[var12 + (var13 << 7)] = 192;
			}

			this.field1022 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1017[var13 + var14 + var7];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1017[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1018[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1018[var14 + var11 + var7 * 128];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1018[var14 + var11 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1017[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "2136023093"
	)
	final int method1808(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1234876855"
	)
	final void method1809(int var1) {
		int var2 = this.field1016.length;
		if (this.field1005 * 16 > 0) {
			this.method1810(this.field1005 * 16, this.field1013);
		} else if (this.field1011 * 16 > 0) {
			this.method1810(this.field1011 * 16, this.field1014);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1016[var3] = this.field1012[var3];
			}
		}

		this.method1811(var1);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I[IB)V",
		garbageValue = "3"
	)
	final void method1810(int var1, int[] var2) {
		int var3 = this.field1016.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1016[var4] = this.method1808(this.field1012[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1016[var4] = var2[var4];
			} else {
				this.field1016[var4] = this.method1808(var2[var4], this.field1012[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1586915597"
	)
	final void method1811(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1009[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= IgnoreList.rasterProvider.width) {
				var7 = IgnoreList.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * IgnoreList.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1017[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1016[var10];
					int var14 = IgnoreList.rasterProvider.pixels[var8];
					IgnoreList.rasterProvider.pixels[var8++] = -16777216 | (var13 * (var14 & 65280) + var12 * (var10 & 65280) & 16711680) + ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lli;I)V",
		garbageValue = "-1419079809"
	)
	final void method1824(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1019.length; ++var2) {
			this.field1019[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1019[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1020[var5] = (this.field1019[var5 - 128] + this.field1019[var5 + 1] + this.field1019[var5 + 128] + this.field1019[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1019;
			this.field1019 = this.field1020;
			this.field1020 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1019[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)[Lfi;",
		garbageValue = "-1862845897"
	)
	public static class179[] method1832() {
		return new class179[]{class179.field2291, class179.field2290, class179.field2292, class179.field2289, class179.field2293, class179.field2294, class179.field2295, class179.field2296, class179.field2297, class179.field2298};
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1841438031"
	)
	static void method1831() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.field1228[var0] = null;
			Players.field1231[var0] = 1;
		}

	}
}
