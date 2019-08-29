import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "[Llq;"
	)
	@Export("sprites")
	IndexedSprite[] sprites;
	@ObfuscatedName("t")
	int[] field1010;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -792132795
	)
	int field1007;
	@ObfuscatedName("x")
	int[] field1012;
	@ObfuscatedName("d")
	int[] field1013;
	@ObfuscatedName("f")
	int[] field1014;
	@ObfuscatedName("c")
	int[] field1025;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1331139095
	)
	int field1016;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -637921111
	)
	int field1017;
	@ObfuscatedName("p")
	int[] field1018;
	@ObfuscatedName("b")
	int[] field1019;
	@ObfuscatedName("g")
	int[] field1020;
	@ObfuscatedName("e")
	int[] field1024;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 2061231381
	)
	int field1022;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 580244368
	)
	int field1023;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -801970233
	)
	int field1009;

	@ObfuscatedSignature(
		signature = "([Llq;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1010 = new int[256];
		this.field1007 = 0;
		this.field1016 = 0;
		this.field1017 = 0;
		this.field1022 = 0;
		this.field1023 = 0;
		this.field1009 = 0;
		this.sprites = var1;
		this.initColors();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1703436788"
	)
	@Export("initColors")
	void initColors() {
		this.field1013 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1013[var1 + 192] = 16777215;
		}

		this.field1014 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1014[var1 + 192] = 16777215;
		}

		this.field1025 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1025[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1025[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1025[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1025[var1 + 192] = 16777215;
		}

		this.field1012 = new int[256];
		this.field1022 = 0;
		this.field1020 = new int[32768];
		this.field1024 = new int[32768];
		this.method1738((IndexedSprite)null);
		this.field1018 = new int[32768];
		this.field1019 = new int[32768];
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "47"
	)
	void method1731() {
		this.field1013 = null;
		this.field1014 = null;
		this.field1025 = null;
		this.field1012 = null;
		this.field1020 = null;
		this.field1024 = null;
		this.field1018 = null;
		this.field1019 = null;
		this.field1022 = 0;
		this.field1023 = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-52"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1018 == null) {
			this.initColors();
		}

		if (this.field1009 == 0) {
			this.field1009 = var2;
		}

		int var3 = var2 - this.field1009;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1009 = var2;
		if (var3 > 0) {
			this.method1756(var3);
		}

		this.method1754(var1);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2129521769"
	)
	final void method1756(int var1) {
		this.field1022 += 128 * var1;
		int var2;
		if (this.field1022 > this.field1020.length) {
			this.field1022 -= this.field1020.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method1738(this.sprites[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1018[var3 + var2] - this.field1020[var2 + this.field1022 & this.field1020.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1018[var2++] = var6;
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
					this.field1018[var8 + var9] = 255;
				} else {
					this.field1018[var8 + var9] = 0;
				}
			}
		}

		if (this.field1016 * 16 > 0) {
			this.field1016 = this.field1016 * 16 - var1 * 4;
		}

		if (this.field1017 * 16 > 0) {
			this.field1017 = this.field1017 * 16 - var1 * 4;
		}

		if (this.field1016 * 16 == 0 && this.field1017 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1016 = 1024;
			}

			if (var7 == 1) {
				this.field1017 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1010[var7] = this.field1010[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1010[var7] = (int)(Math.sin((double)this.field1007 / 14.0D) * 16.0D + Math.sin((double)this.field1007 / 15.0D) * 14.0D + Math.sin((double)this.field1007 / 16.0D) * 12.0D);
			++this.field1007;
		}

		this.field1023 = this.field1023 * 10000 + var1 * 10000;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1023 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1018[var12 + (var13 << 7)] = 192;
			}

			this.field1023 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var14 + var7 < 128) {
						var12 += this.field1018[var13 + var14 + var7];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1018[var14 + var13 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1019[var13 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1019[var7 * 128 + var14 + var11];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1019[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1018[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-12618056"
	)
	final int method1734(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) + (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) >> 8;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1298717611"
	)
	final void method1754(int var1) {
		int var2 = this.field1012.length;
		if (this.field1016 * 16 > 0) {
			this.method1736(this.field1016 * 16, this.field1014);
		} else if (this.field1017 * 16 > 0) {
			this.method1736(this.field1017 * 16, this.field1025);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1012[var3] = this.field1013[var3];
			}
		}

		this.method1733(var1);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I[IB)V",
		garbageValue = "36"
	)
	final void method1736(int var1, int[] var2) {
		int var3 = this.field1012.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1012[var4] = this.method1734(this.field1013[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1012[var4] = var2[var4];
			} else {
				this.field1012[var4] = this.method1734(var2[var4], this.field1013[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "23"
	)
	final void method1733(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1010[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= SpotAnimationDefinition.rasterProvider.width) {
				var7 = SpotAnimationDefinition.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * SpotAnimationDefinition.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1018[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1012[var10];
					int var14 = SpotAnimationDefinition.rasterProvider.pixels[var8];
					SpotAnimationDefinition.rasterProvider.pixels[var8++] = -16777216 | ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) + (var12 * (var10 & 65280) + var13 * (var14 & 65280) & 16711680) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Llq;I)V",
		garbageValue = "1544028562"
	)
	final void method1738(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1020.length; ++var2) {
			this.field1020[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1020[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1024[var5] = (this.field1020[var5 + 128] + this.field1020[var5 - 128] + this.field1020[var5 + 1] + this.field1020[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1020;
			this.field1020 = this.field1024;
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
						this.field1020[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1780006768"
	)
	static void method1758() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromFriend();
		}

	}

	@ObfuscatedName("ej")
	@ObfuscatedSignature(
		signature = "(I)Llv;",
		garbageValue = "158652413"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return WorldMapCacheName.worldMap;
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(IIIIZI)V",
		garbageValue = "1846245684"
	)
	@Export("setViewportShape")
	static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
		if (var2 < 1) {
			var2 = 1;
		}

		if (var3 < 1) {
			var3 = 1;
		}

		int var5 = var3 - 334;
		int var6;
		if (var5 < 0) {
			var6 = Client.field873;
		} else if (var5 >= 100) {
			var6 = Client.field822;
		} else {
			var6 = (Client.field822 - Client.field873) * var5 / 100 + Client.field873;
		}

		int var7 = var3 * var6 * 512 / (var2 * 334);
		int var8;
		int var9;
		short var10;
		if (var7 < Client.field652) {
			var10 = Client.field652;
			var6 = var10 * var2 * 334 / (var3 * 512);
			if (var6 > Client.field661) {
				var6 = Client.field661;
				var8 = var3 * var6 * 512 / (var10 * 334);
				var9 = (var2 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
				}

				var0 += var9;
				var2 -= var9 * 2;
			}
		} else if (var7 > Client.field791) {
			var10 = Client.field791;
			var6 = var10 * var2 * 334 / (var3 * 512);
			if (var6 < Client.field795) {
				var6 = Client.field795;
				var8 = var10 * var2 * 334 / (var6 * 512);
				var9 = (var3 - var8) / 2;
				if (var4) {
					Rasterizer2D.Rasterizer2D_resetClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
				}

				var1 += var9;
				var3 -= var9 * 2;
			}
		}

		Client.viewportZoom = var3 * var6 / 334;
		if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
			TilePaint.method3005(var2, var3);
		}

		Client.viewportOffsetX = var0;
		Client.viewportOffsetY = var1;
		Client.viewportWidth = var2;
		Client.viewportHeight = var3;
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "121"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
