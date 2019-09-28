import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static Bounds field1032;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("q")
	int[] field1017;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 433825167
	)
	int field1018;
	@ObfuscatedName("y")
	int[] field1019;
	@ObfuscatedName("i")
	int[] field1030;
	@ObfuscatedName("c")
	int[] field1021;
	@ObfuscatedName("b")
	int[] field1022;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1054808651
	)
	int field1023;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1416071611
	)
	int field1014;
	@ObfuscatedName("e")
	int[] field1020;
	@ObfuscatedName("w")
	int[] field1027;
	@ObfuscatedName("t")
	int[] field1031;
	@ObfuscatedName("g")
	int[] field1015;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 153935283
	)
	int field1029;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 456974096
	)
	int field1024;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -389038271
	)
	int field1025;

	@ObfuscatedSignature(
		signature = "([Llp;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1017 = new int[256];
		this.field1018 = 0;
		this.field1023 = 0;
		this.field1014 = 0;
		this.field1029 = 0;
		this.field1024 = 0;
		this.field1025 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-27245818"
	)
	@Export("initColors")
	void initColors() {
		this.field1030 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1030[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1030[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1030[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1030[var1 + 192] = 16777215;
		}

		this.field1021 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1021[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1021[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1021[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1021[var1 + 192] = 16777215;
		}

		this.field1022 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1022[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1022[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1022[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1022[var1 + 192] = 16777215;
		}

		this.field1019 = new int[256];
		this.field1029 = 0;
		this.field1031 = new int[32768];
		this.field1015 = new int[32768];
		this.method1828((IndexedSprite)null);
		this.field1020 = new int[32768];
		this.field1027 = new int[32768];
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1384251878"
	)
	void method1821() {
		this.field1030 = null;
		this.field1021 = null;
		this.field1022 = null;
		this.field1019 = null;
		this.field1031 = null;
		this.field1015 = null;
		this.field1020 = null;
		this.field1027 = null;
		this.field1029 = 0;
		this.field1024 = 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-938798150"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1020 == null) {
			this.initColors();
		}

		if (this.field1025 == 0) {
			this.field1025 = var2;
		}

		int var3 = var2 - this.field1025;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1025 = var2;
		if (var3 > 0) {
			this.method1823(var3);
		}

		this.method1840(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1108655518"
	)
	final void method1823(int var1) {
		this.field1029 += var1 * 128;
		int var2;
		if (this.field1029 > this.field1031.length) {
			this.field1029 -= this.field1031.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1828(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1020[var2 + var3] - this.field1031[var2 + this.field1029 & this.field1031.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1020[var2++] = var6;
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
					this.field1020[var9 + var8] = 255;
				} else {
					this.field1020[var8 + var9] = 0;
				}
			}
		}

		if (this.field1023 * 16 > 0) {
			this.field1023 = this.field1023 * 16 - var1 * 4;
		}

		if (this.field1014 * 16 > 0) {
			this.field1014 = this.field1014 * 16 - var1 * 4;
		}

		if (this.field1023 * 16 == 0 && this.field1014 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1023 = 1024;
			}

			if (var7 == 1) {
				this.field1014 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1017[var7] = this.field1017[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1017[var7] = (int)(Math.sin((double)this.field1018 / 14.0D) * 16.0D + Math.sin((double)this.field1018 / 15.0D) * 14.0D + Math.sin((double)this.field1018 / 16.0D) * 12.0D);
			++this.field1018;
		}

		this.field1024 = this.field1024 * 10000 + 10000 * var1;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1024 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1020[var12 + (var13 << 7)] = 192;
			}

			this.field1024 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1020[var7 + var14 + var13];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1020[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1027[var14 + var13] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var7 + var13 < 256) {
						var12 += this.field1027[var7 * 128 + var14 + var11];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1027[var14 + var11 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1020[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "1638746019"
	)
	final int method1824(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "97"
	)
	final void method1840(int var1) {
		int var2 = this.field1019.length;
		if (this.field1023 * 16 > 0) {
			this.method1826(this.field1023 * 16, this.field1021);
		} else if (this.field1014 * 16 > 0) {
			this.method1826(this.field1014 * 16, this.field1022);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1019[var3] = this.field1030[var3];
			}
		}

		this.method1827(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I[II)V",
		garbageValue = "-1982126918"
	)
	final void method1826(int var1, int[] var2) {
		int var3 = this.field1019.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1019[var4] = this.method1824(this.field1030[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1019[var4] = var2[var4];
			} else {
				this.field1019[var4] = this.method1824(var2[var4], this.field1030[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-224486060"
	)
	final void method1827(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1017[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= class42.rasterProvider.width) {
				var7 = class42.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * class42.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1020[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1019[var10];
					int var14 = class42.rasterProvider.pixels[var8];
					class42.rasterProvider.pixels[var8++] = -16777216 | ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) + (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Llp;I)V",
		garbageValue = "1363271921"
	)
	final void method1828(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1031.length; ++var2) {
			this.field1031[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1031[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1015[var5] = (this.field1031[var5 + 1] + this.field1031[var5 + 128] + this.field1031[var5 - 128] + this.field1031[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1031;
			this.field1031 = this.field1015;
			this.field1015 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1031[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "666011978"
	)
	@Export("isValidURL")
	static boolean isValidURL(String var0) {
		if (var0 == null) {
			return false;
		} else {
			try {
				new URL(var0);
				return true;
			} catch (MalformedURLException var2) {
				return false;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1979853088"
	)
	public static boolean method1843(char var0) {
		if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
			if (var0 != 0) {
				char[] var1 = class287.cp1252AsciiExtension;

				for (int var2 = 0; var2 < var1.length; ++var2) {
					char var3 = var1[var2];
					if (var0 == var3) {
						return true;
					}
				}
			}

			return false;
		} else {
			return true;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lho;IIII)V",
		garbageValue = "1378912334"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field2586 == null) {
			throw new RuntimeException();
		} else {
			var0.field2586[var1] = var2;
			var0.field2548[var1] = var3;
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "-1562433827"
	)
	static int method1848(byte[] var0, int var1, int var2) {
		int var3 = -1;

		for (int var4 = var1; var4 < var2; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "([BII)V",
		garbageValue = "-2002563170"
	)
	static void method1832(byte[] var0, int var1) {
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class300.writeRandomDat(var0, var1, Client.randomDatData, 0, 24);
	}
}
