import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1863023515
	)
	static int field1029;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "[Llw;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("c")
	int[] field1013;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 816842913
	)
	int field1011;
	@ObfuscatedName("i")
	int[] field1015;
	@ObfuscatedName("d")
	int[] field1016;
	@ObfuscatedName("m")
	int[] field1010;
	@ObfuscatedName("p")
	int[] field1019;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 462290829
	)
	int field1030;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 945230157
	)
	int field1020;
	@ObfuscatedName("x")
	int[] field1021;
	@ObfuscatedName("j")
	int[] field1022;
	@ObfuscatedName("r")
	int[] field1014;
	@ObfuscatedName("e")
	int[] field1024;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1611011869
	)
	int field1025;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -180087120
	)
	int field1026;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -151698419
	)
	int field1018;

	@ObfuscatedSignature(
		signature = "([Llw;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1013 = new int[256];
		this.field1011 = 0;
		this.field1030 = 0;
		this.field1020 = 0;
		this.field1025 = 0;
		this.field1026 = 0;
		this.field1018 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1417087240"
	)
	@Export("initColors")
	void initColors() {
		this.field1016 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1016[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1016[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1016[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1016[var1 + 192] = 16777215;
		}

		this.field1010 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1010[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1010[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1010[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1010[var1 + 192] = 16777215;
		}

		this.field1019 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1019[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1019[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1019[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1019[var1 + 192] = 16777215;
		}

		this.field1015 = new int[256];
		this.field1025 = 0;
		this.field1014 = new int[32768];
		this.field1024 = new int[32768];
		this.method1932((IndexedSprite)null);
		this.field1021 = new int[32768];
		this.field1022 = new int[32768];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-89"
	)
	void method1955() {
		this.field1016 = null;
		this.field1010 = null;
		this.field1019 = null;
		this.field1015 = null;
		this.field1014 = null;
		this.field1024 = null;
		this.field1021 = null;
		this.field1022 = null;
		this.field1025 = 0;
		this.field1026 = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "664773191"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1021 == null) {
			this.initColors();
		}

		if (this.field1018 == 0) {
			this.field1018 = var2;
		}

		int var3 = var2 - this.field1018;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1018 = var2;
		if (var3 > 0) {
			this.method1927(var3);
		}

		this.method1929(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-50"
	)
	final void method1927(int var1) {
		this.field1025 += var1 * 128;
		int var2;
		if (this.field1025 > this.field1014.length) {
			this.field1025 -= this.field1014.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1932(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1021[var2 + var3] - this.field1014[var2 + this.field1025 & this.field1014.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1021[var2++] = var6;
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
					this.field1021[var9 + var8] = 255;
				} else {
					this.field1021[var9 + var8] = 0;
				}
			}
		}

		if (this.field1030 * 16 > 0) {
			this.field1030 = this.field1030 * 16 - var1 * 4;
		}

		if (this.field1020 * 16 > 0) {
			this.field1020 = this.field1020 * 16 - var1 * 4;
		}

		if (this.field1030 * 16 == 0 && this.field1020 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1030 = 1024;
			}

			if (var7 == 1) {
				this.field1020 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1013[var7] = this.field1013[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1013[var7] = (int)(Math.sin((double)this.field1011 / 14.0D) * 16.0D + Math.sin((double)this.field1011 / 15.0D) * 14.0D + Math.sin((double)this.field1011 / 16.0D) * 12.0D);
			++this.field1011;
		}

		this.field1026 = this.field1026 * 10000 + 10000 * var1;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1026 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1021[var12 + (var13 << 7)] = 192;
			}

			this.field1026 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1021[var7 + var13 + var14];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1021[var14 + var13 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1022[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var7 + var13 < 256) {
						var12 += this.field1022[var7 * 128 + var11 + var14];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1022[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1021[var14 + var11] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-805696454"
	)
	final int method1928(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) + (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) >> 8;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "25374"
	)
	final void method1929(int var1) {
		int var2 = this.field1015.length;
		if (this.field1030 * 16 > 0) {
			this.method1930(this.field1030 * 16, this.field1010);
		} else if (this.field1020 * 16 > 0) {
			this.method1930(this.field1020 * 16, this.field1019);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1015[var3] = this.field1016[var3];
			}
		}

		this.method1931(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I[II)V",
		garbageValue = "-1624613392"
	)
	final void method1930(int var1, int[] var2) {
		int var3 = this.field1015.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1015[var4] = this.method1928(this.field1016[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1015[var4] = var2[var4];
			} else {
				this.field1015[var4] = this.method1928(var2[var4], this.field1016[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-782964305"
	)
	final void method1931(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1013[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= AbstractWorldMapData.rasterProvider.width) {
				var7 = AbstractWorldMapData.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * AbstractWorldMapData.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1021[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1015[var10];
					int var14 = AbstractWorldMapData.rasterProvider.pixels[var8];
					AbstractWorldMapData.rasterProvider.pixels[var8++] = -16777216 | (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) + ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Llw;I)V",
		garbageValue = "2025756403"
	)
	final void method1932(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1014.length; ++var2) {
			this.field1014[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1014[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1024[var5] = (this.field1014[var5 - 128] + this.field1014[var5 + 1] + this.field1014[var5 + 128] + this.field1014[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1014;
			this.field1014 = this.field1024;
			this.field1024 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1014[var7] = 0;
					}
				}
			}
		}

	}
}
