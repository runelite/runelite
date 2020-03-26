import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("ap")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Lle;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("q")
	int[] field1059;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -860296683
	)
	int field1060;
	@ObfuscatedName("t")
	int[] field1074;
	@ObfuscatedName("e")
	int[] field1062;
	@ObfuscatedName("s")
	int[] field1065;
	@ObfuscatedName("p")
	int[] field1064;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1214831443
	)
	int field1063;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 44096223
	)
	int field1066;
	@ObfuscatedName("h")
	int[] field1057;
	@ObfuscatedName("g")
	int[] field1068;
	@ObfuscatedName("i")
	int[] field1069;
	@ObfuscatedName("a")
	int[] field1070;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -702282245
	)
	int field1055;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1031102693
	)
	int field1072;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1396943377
	)
	int field1073;

	@ObfuscatedSignature(
		signature = "([Lle;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1059 = new int[256];
		this.field1060 = 0;
		this.field1063 = 0;
		this.field1066 = 0;
		this.field1055 = 0;
		this.field1072 = 0;
		this.field1073 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-542018665"
	)
	@Export("initColors")
	void initColors() {
		this.field1062 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1062[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1062[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1062[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1062[var1 + 192] = 16777215;
		}

		this.field1065 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1065[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1065[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1065[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1065[var1 + 192] = 16777215;
		}

		this.field1064 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1064[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1064[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1064[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1064[var1 + 192] = 16777215;
		}

		this.field1074 = new int[256];
		this.field1055 = 0;
		this.field1069 = new int[32768];
		this.field1070 = new int[32768];
		this.method1917((IndexedSprite)null);
		this.field1057 = new int[32768];
		this.field1068 = new int[32768];
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "41185107"
	)
	void method1909() {
		this.field1062 = null;
		this.field1065 = null;
		this.field1064 = null;
		this.field1074 = null;
		this.field1069 = null;
		this.field1070 = null;
		this.field1057 = null;
		this.field1068 = null;
		this.field1055 = 0;
		this.field1072 = 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "10"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1057 == null) {
			this.initColors();
		}

		if (this.field1073 == 0) {
			this.field1073 = var2;
		}

		int var3 = var2 - this.field1073;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1073 = var2;
		if (var3 > 0) {
			this.method1912(var3);
		}

		this.method1919(var1);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2136809713"
	)
	final void method1912(int var1) {
		this.field1055 += 128 * var1;
		int var2;
		if (this.field1055 > this.field1069.length) {
			this.field1055 -= this.field1069.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1917(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1057[var2 + var3] - this.field1069[var2 + this.field1055 & this.field1069.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1057[var2++] = var6;
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
					this.field1057[var8 + var9] = 255;
				} else {
					this.field1057[var8 + var9] = 0;
				}
			}
		}

		if (this.field1063 > 0) {
			this.field1063 -= var1 * 4;
		}

		if (this.field1066 > 0) {
			this.field1066 -= var1 * 4;
		}

		if (this.field1063 == 0 && this.field1066 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1063 = 1024;
			}

			if (var7 == 1) {
				this.field1066 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1059[var7] = this.field1059[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1059[var7] = (int)(Math.sin((double)this.field1060 / 14.0D) * 16.0D + Math.sin((double)this.field1060 / 15.0D) * 14.0D + Math.sin((double)this.field1060 / 16.0D) * 12.0D);
			++this.field1060;
		}

		this.field1072 += var1;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1072 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1057[var12 + (var13 << 7)] = 192;
			}

			this.field1072 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1057[var7 + var13 + var14];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1057[var13 + var14 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1068[var14 + var13] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1068[var14 + var11 + var7 * 128];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1068[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1057[var14 + var11] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "743870455"
	)
	final int method1940(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-803188196"
	)
	final void method1919(int var1) {
		int var2 = this.field1074.length;
		if (this.field1063 > 0) {
			this.method1915(this.field1063, this.field1065);
		} else if (this.field1066 > 0) {
			this.method1915(this.field1066, this.field1064);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1074[var3] = this.field1062[var3];
			}
		}

		this.method1916(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I[II)V",
		garbageValue = "1786403761"
	)
	final void method1915(int var1, int[] var2) {
		int var3 = this.field1074.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1074[var4] = this.method1940(this.field1062[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1074[var4] = var2[var4];
			} else {
				this.field1074[var4] = this.method1940(var2[var4], this.field1062[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1017589056"
	)
	final void method1916(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1059[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= class206.rasterProvider.width) {
				var7 = class206.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * class206.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1057[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1074[var10];
					int var14 = class206.rasterProvider.pixels[var8];
					class206.rasterProvider.pixels[var8++] = -16777216 | ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) + (var13 * (var14 & 65280) + var12 * (var10 & 65280) & 16711680) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lle;I)V",
		garbageValue = "-61779781"
	)
	final void method1917(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1069.length; ++var2) {
			this.field1069[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1069[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1070[var5] = (this.field1069[var5 + 128] + this.field1069[var5 - 128] + this.field1069[var5 + 1] + this.field1069[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1069;
			this.field1069 = this.field1070;
			this.field1070 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1069[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "1"
	)
	public static boolean method1939(int var0) {
		return (var0 & 1) != 0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "304486433"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (Widget.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!Widget.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = Widget.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				Widget.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (Widget.Widget_interfaceComponents[var0] == null) {
					Widget.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (Widget.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = Widget.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							Widget.Widget_interfaceComponents[var0][var2] = new Widget();
							Widget.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								Widget.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								Widget.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				Widget.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-232699215"
	)
	static void method1938(int var0) {
		for (IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.first(); var1 != null; var1 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((var1.key >> 48 & 65535L) == (long)var0) {
				var1.remove();
			}
		}

	}
}
