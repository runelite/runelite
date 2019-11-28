import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("qo")
	@ObfuscatedSignature(
		signature = "Ldn;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("g")
	@Export("Interpreter_stringLocals")
	static String[] Interpreter_stringLocals;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[Llm;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("h")
	int[] field1024;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -522038553
	)
	int field1025;
	@ObfuscatedName("w")
	int[] field1026;
	@ObfuscatedName("i")
	int[] field1042;
	@ObfuscatedName("k")
	int[] field1028;
	@ObfuscatedName("x")
	int[] field1043;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1610876241
	)
	int field1030;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2082958971
	)
	int field1031;
	@ObfuscatedName("n")
	int[] field1036;
	@ObfuscatedName("r")
	int[] field1033;
	@ObfuscatedName("c")
	int[] field1029;
	@ObfuscatedName("a")
	int[] field1035;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -127865793
	)
	int field1020;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 256294268
	)
	int field1037;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 81915263
	)
	int field1034;

	@ObfuscatedSignature(
		signature = "([Llm;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1024 = new int[256];
		this.field1025 = 0;
		this.field1030 = 0;
		this.field1031 = 0;
		this.field1020 = 0;
		this.field1037 = 0;
		this.field1034 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1296235514"
	)
	@Export("initColors")
	void initColors() {
		this.field1042 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1042[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1042[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1042[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1042[var1 + 192] = 16777215;
		}

		this.field1028 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1028[var1 + 192] = 16777215;
		}

		this.field1043 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1043[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1043[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1043[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1043[var1 + 192] = 16777215;
		}

		this.field1026 = new int[256];
		this.field1020 = 0;
		this.field1029 = new int[32768];
		this.field1035 = new int[32768];
		this.method1834((IndexedSprite)null);
		this.field1036 = new int[32768];
		this.field1033 = new int[32768];
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "9"
	)
	void method1828() {
		this.field1042 = null;
		this.field1028 = null;
		this.field1043 = null;
		this.field1026 = null;
		this.field1029 = null;
		this.field1035 = null;
		this.field1036 = null;
		this.field1033 = null;
		this.field1020 = 0;
		this.field1037 = 0;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2116799811"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1036 == null) {
			this.initColors();
		}

		if (this.field1034 == 0) {
			this.field1034 = var2;
		}

		int var3 = var2 - this.field1034;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1034 = var2;
		if (var3 > 0) {
			this.method1830(var3);
		}

		this.method1839(var1);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1116780854"
	)
	final void method1830(int var1) {
		this.field1020 += 128 * var1;
		int var2;
		if (this.field1020 > this.field1029.length) {
			this.field1020 -= this.field1029.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1834(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1036[var3 + var2] - this.field1029[var2 + this.field1020 & this.field1029.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1036[var2++] = var6;
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
					this.field1036[var8 + var9] = 255;
				} else {
					this.field1036[var8 + var9] = 0;
				}
			}
		}

		if (this.field1030 * 16 > 0) {
			this.field1030 = this.field1030 * 16 - var1 * 4;
		}

		if (this.field1031 * 16 > 0) {
			this.field1031 = this.field1031 * 16 - var1 * 4;
		}

		if (this.field1030 * 16 == 0 && this.field1031 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1030 = 1024;
			}

			if (var7 == 1) {
				this.field1031 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1024[var7] = this.field1024[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1024[var7] = (int)(Math.sin((double)this.field1025 / 14.0D) * 16.0D + Math.sin((double)this.field1025 / 15.0D) * 14.0D + Math.sin((double)this.field1025 / 16.0D) * 12.0D);
			++this.field1025;
		}

		this.field1037 = this.field1037 * 10000 + var1 * 100;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1037 * 10000; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1036[var12 + (var13 << 7)] = 192;
			}

			this.field1037 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var7 + var14 < 128) {
						var12 += this.field1036[var14 + var13 + var7];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1036[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1033[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1033[var7 * 128 + var14 + var11];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1033[var14 + var11 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1036[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-2144632316"
	)
	final int method1831(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var3 * (var2 & 16711935) + var4 * (var1 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1401250939"
	)
	final void method1839(int var1) {
		int var2 = this.field1026.length;
		if (this.field1030 * 16 > 0) {
			this.method1844(this.field1030 * 16, this.field1028);
		} else if (this.field1031 * 16 > 0) {
			this.method1844(this.field1031 * 16, this.field1043);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1026[var3] = this.field1042[var3];
			}
		}

		this.method1833(var1);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I[IS)V",
		garbageValue = "732"
	)
	final void method1844(int var1, int[] var2) {
		int var3 = this.field1026.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1026[var4] = this.method1831(this.field1042[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1026[var4] = var2[var4];
			} else {
				this.field1026[var4] = this.method1831(var2[var4], this.field1042[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1303353921"
	)
	final void method1833(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1024[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= DirectByteArrayCopier.rasterProvider.width) {
				var7 = DirectByteArrayCopier.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * DirectByteArrayCopier.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1036[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1026[var10];
					int var14 = DirectByteArrayCopier.rasterProvider.pixels[var8];
					DirectByteArrayCopier.rasterProvider.pixels[var8++] = -16777216 | (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) + ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Llm;I)V",
		garbageValue = "545275077"
	)
	final void method1834(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1029.length; ++var2) {
			this.field1029[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1029[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1035[var5] = (this.field1029[var5 + 128] + this.field1029[var5 - 128] + this.field1029[var5 + 1] + this.field1029[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1029;
			this.field1029 = this.field1035;
			this.field1035 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1029[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "925097007"
	)
	static final int method1832(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}
