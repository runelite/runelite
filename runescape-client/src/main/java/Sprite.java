import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("Sprite")
public final class Sprite extends Rasterizer2D {
	@ObfuscatedName("q")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("w")
	@Export("subWidth")
	public int subWidth;
	@ObfuscatedName("e")
	@Export("subHeight")
	public int subHeight;
	@ObfuscatedName("p")
	@Export("yOffset")
	public int yOffset;
	@ObfuscatedName("k")
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("l")
	@Export("width")
	public int width;
	@ObfuscatedName("b")
	@Export("height")
	public int height;

	public Sprite(int[] var1, int var2, int var3) {
		this.pixels = var1;
		this.subWidth = this.width = var2;
		this.subHeight = this.height = var3;
		this.xOffset = 0;
		this.yOffset = 0;
	}

	public Sprite(int var1, int var2) {
		this(new int[var2 * var1], var1, var2);
	}

	Sprite() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lly;"
	)
	@Export("mirrorHorizontally")
	public Sprite mirrorHorizontally() {
		Sprite var1 = new Sprite(this.subWidth, this.subHeight);
		var1.width = this.width;
		var1.height = this.height;
		var1.yOffset = this.width - this.subWidth - this.yOffset;
		var1.xOffset = this.xOffset;

		for (int var2 = 0; var2 < this.subHeight; ++var2) {
			for (int var3 = 0; var3 < this.subWidth; ++var3) {
				var1.pixels[var3 + var2 * this.subWidth] = this.pixels[var2 * this.subWidth + this.subWidth - 1 - var3];
			}
		}

		return var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "()Lly;"
	)
	@Export("copyNormalized")
	public Sprite copyNormalized() {
		Sprite var1 = new Sprite(this.width, this.height);

		for (int var2 = 0; var2 < this.subHeight; ++var2) {
			for (int var3 = 0; var3 < this.subWidth; ++var3) {
				var1.pixels[var3 + (var2 + this.xOffset) * this.width + this.yOffset] = this.pixels[var3 + var2 * this.subWidth];
			}
		}

		return var1;
	}

	@ObfuscatedName("e")
	@Export("setRaster")
	public void setRaster() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.subWidth, this.subHeight);
	}

	@ObfuscatedName("p")
	@Export("normalize")
	public void normalize() {
		if (this.subWidth != this.width || this.subHeight != this.height) {
			int[] var1 = new int[this.width * this.height];

			for (int var2 = 0; var2 < this.subHeight; ++var2) {
				for (int var3 = 0; var3 < this.subWidth; ++var3) {
					var1[var3 + (var2 + this.xOffset) * this.width + this.yOffset] = this.pixels[var3 + var2 * this.subWidth];
				}
			}

			this.pixels = var1;
			this.subWidth = this.width;
			this.subHeight = this.height;
			this.yOffset = 0;
			this.xOffset = 0;
		}
	}

	@ObfuscatedName("k")
	public void method6115(int var1) {
		if (this.subWidth != this.width || this.subHeight != this.height) {
			int var2 = var1;
			if (var1 > this.yOffset) {
				var2 = this.yOffset;
			}

			int var3 = var1;
			if (var1 + this.yOffset + this.subWidth > this.width) {
				var3 = this.width - this.yOffset - this.subWidth;
			}

			int var4 = var1;
			if (var1 > this.xOffset) {
				var4 = this.xOffset;
			}

			int var5 = var1;
			if (var1 + this.xOffset + this.subHeight > this.height) {
				var5 = this.height - this.xOffset - this.subHeight;
			}

			int var6 = var2 + var3 + this.subWidth;
			int var7 = var4 + var5 + this.subHeight;
			int[] var8 = new int[var6 * var7];

			for (int var9 = 0; var9 < this.subHeight; ++var9) {
				for (int var10 = 0; var10 < this.subWidth; ++var10) {
					var8[var6 * (var9 + var4) + var10 + var2] = this.pixels[var10 + var9 * this.subWidth];
				}
			}

			this.pixels = var8;
			this.subWidth = var6;
			this.subHeight = var7;
			this.yOffset -= var2;
			this.xOffset -= var4;
		}
	}

	@ObfuscatedName("l")
	public void method6117() {
		int[] var1 = new int[this.subWidth * this.subHeight];
		int var2 = 0;

		for (int var3 = 0; var3 < this.subHeight; ++var3) {
			for (int var4 = this.subWidth - 1; var4 >= 0; --var4) {
				var1[var2++] = this.pixels[var4 + var3 * this.subWidth];
			}
		}

		this.pixels = var1;
		this.yOffset = this.width - this.subWidth - this.yOffset;
	}

	@ObfuscatedName("b")
	public void method6128() {
		int[] var1 = new int[this.subWidth * this.subHeight];
		int var2 = 0;

		for (int var3 = this.subHeight - 1; var3 >= 0; --var3) {
			for (int var4 = 0; var4 < this.subWidth; ++var4) {
				var1[var2++] = this.pixels[var4 + var3 * this.subWidth];
			}
		}

		this.pixels = var1;
		this.xOffset = this.height - this.subHeight - this.xOffset;
	}

	@ObfuscatedName("i")
	@Export("outline")
	public void outline(int var1) {
		int[] var2 = new int[this.subWidth * this.subHeight];
		int var3 = 0;

		for (int var4 = 0; var4 < this.subHeight; ++var4) {
			for (int var5 = 0; var5 < this.subWidth; ++var5) {
				int var6 = this.pixels[var3];
				if (var6 == 0) {
					if (var5 > 0 && this.pixels[var3 - 1] != 0) {
						var6 = var1;
					} else if (var4 > 0 && this.pixels[var3 - this.subWidth] != 0) {
						var6 = var1;
					} else if (var5 < this.subWidth - 1 && this.pixels[var3 + 1] != 0) {
						var6 = var1;
					} else if (var4 < this.subHeight - 1 && this.pixels[var3 + this.subWidth] != 0) {
						var6 = var1;
					}
				}

				var2[var3++] = var6;
			}
		}

		this.pixels = var2;
	}

	@ObfuscatedName("c")
	@Export("shadow")
	public void shadow(int var1) {
		for (int var2 = this.subHeight - 1; var2 > 0; --var2) {
			int var3 = var2 * this.subWidth;

			for (int var4 = this.subWidth - 1; var4 > 0; --var4) {
				if (this.pixels[var4 + var3] == 0 && this.pixels[var4 + var3 - 1 - this.subWidth] != 0) {
					this.pixels[var4 + var3] = var1;
				}
			}
		}

	}

	@ObfuscatedName("u")
	@Export("drawAt")
	public void drawAt(int var1, int var2) {
		var1 += this.yOffset;
		var2 += this.xOffset;
		int var3 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
		int var4 = 0;
		int var5 = this.subHeight;
		int var6 = this.subWidth;
		int var7 = Rasterizer2D.Rasterizer2D_width - var6;
		int var8 = 0;
		int var9;
		if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
			var5 -= var9;
			var2 = Rasterizer2D.Rasterizer2D_yClipStart;
			var4 += var9 * var6;
			var3 += var9 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var5 + var2 > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var5 -= var5 + var2 - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
			var6 -= var9;
			var1 = Rasterizer2D.Rasterizer2D_xClipStart;
			var4 += var9;
			var3 += var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var9 = var6 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
			var6 -= var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 > 0 && var5 > 0) {
			Sprite_something(Rasterizer2D.Rasterizer2D_pixels, this.pixels, var4, var3, var6, var5, var7, var8);
		}
	}

	@ObfuscatedName("r")
	@Export("drawAt2")
	public void drawAt2(int var1, int var2) {
		var1 += this.yOffset;
		var2 += this.xOffset;
		int var3 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
		int var4 = 0;
		int var5 = this.subHeight;
		int var6 = this.subWidth;
		int var7 = Rasterizer2D.Rasterizer2D_width - var6;
		int var8 = 0;
		int var9;
		if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
			var5 -= var9;
			var2 = Rasterizer2D.Rasterizer2D_yClipStart;
			var4 += var9 * var6;
			var3 += var9 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var5 + var2 > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var5 -= var5 + var2 - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
			var6 -= var9;
			var1 = Rasterizer2D.Rasterizer2D_xClipStart;
			var4 += var9;
			var3 += var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var9 = var6 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
			var6 -= var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 > 0 && var5 > 0) {
			Sprite_andAnotherOne(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var4, var3, var6, var5, var7, var8);
		}
	}

	@ObfuscatedName("y")
	public void method6125(int var1, int var2, int var3, int var4) {
		if (var3 > 0 && var4 > 0) {
			int var5 = this.subWidth;
			int var6 = this.subHeight;
			int var7 = 0;
			int var8 = 0;
			int var9 = this.width;
			int var10 = this.height;
			int var11 = (var9 << 16) / var3;
			int var12 = (var10 << 16) / var4;
			int var13;
			if (this.yOffset > 0) {
				var13 = (var11 + (this.yOffset << 16) - 1) / var11;
				var1 += var13;
				var7 += var13 * var11 - (this.yOffset << 16);
			}

			if (this.xOffset > 0) {
				var13 = (var12 + (this.xOffset << 16) - 1) / var12;
				var2 += var13;
				var8 += var13 * var12 - (this.xOffset << 16);
			}

			if (var5 < var9) {
				var3 = (var11 + ((var5 << 16) - var7) - 1) / var11;
			}

			if (var6 < var10) {
				var4 = (var12 + ((var6 << 16) - var8) - 1) / var12;
			}

			var13 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
			int var14 = Rasterizer2D.Rasterizer2D_width - var3;
			if (var2 + var4 > Rasterizer2D.Rasterizer2D_yClipEnd) {
				var4 -= var2 + var4 - Rasterizer2D.Rasterizer2D_yClipEnd;
			}

			int var15;
			if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
				var15 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
				var4 -= var15;
				var13 += var15 * Rasterizer2D.Rasterizer2D_width;
				var8 += var12 * var15;
			}

			if (var3 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
				var15 = var3 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
				var3 -= var15;
				var14 += var15;
			}

			if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
				var15 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
				var3 -= var15;
				var13 += var15;
				var7 += var11 * var15;
				var14 += var15;
			}

			Sprite_somethingElse(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var7, var8, var13, var14, var3, var4, var11, var12, var5);
		}
	}

	@ObfuscatedName("a")
	@Export("drawAtTransOverlay")
	public void drawAtTransOverlay(int var1, int var2, int var3, int var4) {
		if (var3 == 256) {
			this.drawAt2(var1, var2);
		} else {
			var1 += this.yOffset;
			var2 += this.xOffset;
			int var5 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
			int var6 = 0;
			int var7 = this.subHeight;
			int var8 = this.subWidth;
			int var9 = Rasterizer2D.Rasterizer2D_width - var8;
			int var10 = 0;
			int var11;
			if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
				var11 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
				var7 -= var11;
				var2 = Rasterizer2D.Rasterizer2D_yClipStart;
				var6 += var11 * var8;
				var5 += var11 * Rasterizer2D.Rasterizer2D_width;
			}

			if (var7 + var2 > Rasterizer2D.Rasterizer2D_yClipEnd) {
				var7 -= var7 + var2 - Rasterizer2D.Rasterizer2D_yClipEnd;
			}

			if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
				var11 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
				var8 -= var11;
				var1 = Rasterizer2D.Rasterizer2D_xClipStart;
				var6 += var11;
				var5 += var11;
				var10 += var11;
				var9 += var11;
			}

			if (var8 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
				var11 = var8 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
				var8 -= var11;
				var10 += var11;
				var9 += var11;
			}

			if (var8 > 0 && var7 > 0) {
				Sprite_anotherOne(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var6, var5, var8, var7, var9, var10, var3, var4);
			}
		}
	}

	@ObfuscatedName("o")
	public void method6129(int var1, int var2, int var3) {
		var1 += this.yOffset;
		var2 += this.xOffset;
		int var4 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
		int var5 = 0;
		int var6 = this.subHeight;
		int var7 = this.subWidth;
		int var8 = Rasterizer2D.Rasterizer2D_width - var7;
		int var9 = 0;
		int var10;
		if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
			var6 -= var10;
			var2 = Rasterizer2D.Rasterizer2D_yClipStart;
			var5 += var10 * var7;
			var4 += var10 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var6 + var2 > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var6 -= var6 + var2 - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
			var7 -= var10;
			var1 = Rasterizer2D.Rasterizer2D_xClipStart;
			var5 += var10;
			var4 += var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var10 = var7 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
			var7 -= var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 > 0 && var6 > 0) {
			Sprite_alpha1(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var5, var4, var7, var6, var8, var9, var3);
		}
	}

	@ObfuscatedName("s")
	public void method6131(int var1, int var2, int var3, int var4, int var5) {
		if (var3 > 0 && var4 > 0) {
			int var6 = this.subWidth;
			int var7 = this.subHeight;
			int var8 = 0;
			int var9 = 0;
			int var10 = this.width;
			int var11 = this.height;
			int var12 = (var10 << 16) / var3;
			int var13 = (var11 << 16) / var4;
			int var14;
			if (this.yOffset > 0) {
				var14 = (var12 + (this.yOffset << 16) - 1) / var12;
				var1 += var14;
				var8 += var14 * var12 - (this.yOffset << 16);
			}

			if (this.xOffset > 0) {
				var14 = (var13 + (this.xOffset << 16) - 1) / var13;
				var2 += var14;
				var9 += var14 * var13 - (this.xOffset << 16);
			}

			if (var6 < var10) {
				var3 = (var12 + ((var6 << 16) - var8) - 1) / var12;
			}

			if (var7 < var11) {
				var4 = (var13 + ((var7 << 16) - var9) - 1) / var13;
			}

			var14 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
			int var15 = Rasterizer2D.Rasterizer2D_width - var3;
			if (var2 + var4 > Rasterizer2D.Rasterizer2D_yClipEnd) {
				var4 -= var2 + var4 - Rasterizer2D.Rasterizer2D_yClipEnd;
			}

			int var16;
			if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
				var16 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
				var4 -= var16;
				var14 += var16 * Rasterizer2D.Rasterizer2D_width;
				var9 += var13 * var16;
			}

			if (var3 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
				var16 = var3 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
				var3 -= var16;
				var15 += var16;
			}

			if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
				var16 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
				var3 -= var16;
				var14 += var16;
				var8 += var12 * var16;
				var15 += var16;
			}

			Sprite_alpha2(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var8, var9, var14, var15, var3, var4, var12, var13, var6, var5);
		}
	}

	@ObfuscatedName("al")
	public void method6135(int var1, int var2, int var3) {
		var1 += this.yOffset;
		var2 += this.xOffset;
		int var4 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
		int var5 = 0;
		int var6 = this.subHeight;
		int var7 = this.subWidth;
		int var8 = Rasterizer2D.Rasterizer2D_width - var7;
		int var9 = 0;
		int var10;
		if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
			var6 -= var10;
			var2 = Rasterizer2D.Rasterizer2D_yClipStart;
			var5 += var10 * var7;
			var4 += var10 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var6 + var2 > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var6 -= var6 + var2 - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
			var7 -= var10;
			var1 = Rasterizer2D.Rasterizer2D_xClipStart;
			var5 += var10;
			var4 += var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var10 = var7 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
			var7 -= var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 > 0 && var6 > 0) {
			if (var3 == 256) {
				method6134(0, 0, 0, Rasterizer2D.Rasterizer2D_pixels, this.pixels, var5, 0, var4, 0, var7, var6, var8, var9);
			} else {
				method6119(0, 0, 0, Rasterizer2D.Rasterizer2D_pixels, this.pixels, var5, 0, var4, 0, var7, var6, var8, var9, var3);
			}

		}
	}

	@ObfuscatedName("aw")
	public void method6217(int var1, int var2, int var3, int var4, int var5) {
		if (var3 > 0 && var4 > 0) {
			int var6 = this.subWidth;
			int var7 = this.subHeight;
			int var8 = 0;
			int var9 = 0;
			int var10 = this.width;
			int var11 = this.height;
			int var12 = (var10 << 16) / var3;
			int var13 = (var11 << 16) / var4;
			int var14;
			if (this.yOffset > 0) {
				var14 = (var12 + (this.yOffset << 16) - 1) / var12;
				var1 += var14;
				var8 += var14 * var12 - (this.yOffset << 16);
			}

			if (this.xOffset > 0) {
				var14 = (var13 + (this.xOffset << 16) - 1) / var13;
				var2 += var14;
				var9 += var14 * var13 - (this.xOffset << 16);
			}

			if (var6 < var10) {
				var3 = (var12 + ((var6 << 16) - var8) - 1) / var12;
			}

			if (var7 < var11) {
				var4 = (var13 + ((var7 << 16) - var9) - 1) / var13;
			}

			var14 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;
			int var15 = Rasterizer2D.Rasterizer2D_width - var3;
			if (var2 + var4 > Rasterizer2D.Rasterizer2D_yClipEnd) {
				var4 -= var2 + var4 - Rasterizer2D.Rasterizer2D_yClipEnd;
			}

			int var16;
			if (var2 < Rasterizer2D.Rasterizer2D_yClipStart) {
				var16 = Rasterizer2D.Rasterizer2D_yClipStart - var2;
				var4 -= var16;
				var14 += var16 * Rasterizer2D.Rasterizer2D_width;
				var9 += var13 * var16;
			}

			if (var3 + var1 > Rasterizer2D.Rasterizer2D_xClipEnd) {
				var16 = var3 + var1 - Rasterizer2D.Rasterizer2D_xClipEnd;
				var3 -= var16;
				var15 += var16;
			}

			if (var1 < Rasterizer2D.Rasterizer2D_xClipStart) {
				var16 = Rasterizer2D.Rasterizer2D_xClipStart - var1;
				var3 -= var16;
				var14 += var16;
				var8 += var12 * var16;
				var15 += var16;
			}

			if (var5 == 256) {
				method6111(0, 0, 0, var8, this.pixels, Rasterizer2D.Rasterizer2D_pixels, 0, 0, -var4, var9, var14, var15, var3, var12, var13, var6);
			} else {
				method6138(0, 0, 0, var8, this.pixels, Rasterizer2D.Rasterizer2D_pixels, 0, 0, -var4, var9, var14, var15, var3, var12, var13, var6, var5);
			}

		}
	}

	@ObfuscatedName("ar")
	public void method6146(int var1, int var2, int var3, int var4, int var5, int var6, int[] var7, int[] var8) {
		int var9 = var2 < 0 ? -var2 : 0;
		int var10 = var2 + this.subHeight <= var6 ? this.subHeight : var6 - var2;
		int var11 = var1 < 0 ? -var1 : 0;
		int var10000;
		if (this.subWidth + var1 <= var5) {
			var10000 = this.subWidth;
		} else {
			var10000 = var5 - var1;
		}

		int var13 = var3 + var11 + (var9 + var2 + var4) * Rasterizer2D.Rasterizer2D_width + var1;
		int var14 = var9 + var2;

		for (int var15 = var9; var15 < var10; ++var15) {
			int var16 = var7[var14];
			int var17 = var8[var14++];
			int var18 = var13;
			int var19;
			if (var1 < var16) {
				var19 = var16 - var1;
				var18 = var13 + (var19 - var11);
			} else {
				var19 = var11;
			}

			int var12;
			if (this.subWidth + var1 <= var16 + var17) {
				var12 = this.subWidth;
			} else {
				var12 = var16 + var17 - var1;
			}

			for (int var20 = var19; var20 < var12; ++var20) {
				int var21 = this.pixels[var20 + var15 * this.subWidth];
				if (var21 != 0) {
					Rasterizer2D.Rasterizer2D_pixels[var18++] = var21;
				} else {
					++var18;
				}
			}

			var13 += Rasterizer2D.Rasterizer2D_width;
		}

	}

	@ObfuscatedName("ax")
	@Export("drawRotatedMaskedCenteredAround")
	public void drawRotatedMaskedCenteredAround(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int[] var9, int[] var10) {
		try {
			int var11 = -var3 / 2;
			int var12 = -var4 / 2;
			int var13 = (int)(Math.sin((double)var7 / 326.11D) * 65536.0D);
			int var14 = (int)(Math.cos((double)var7 / 326.11D) * 65536.0D);
			var13 = var13 * var8 >> 8;
			var14 = var14 * var8 >> 8;
			int var15 = var12 * var13 + var11 * var14 + (var5 << 16);
			int var16 = var12 * var14 - var11 * var13 + (var6 << 16);
			int var17 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;

			for (var2 = 0; var2 < var4; ++var2) {
				int var18 = var9[var2];
				int var19 = var17 + var18;
				int var20 = var15 + var14 * var18;
				int var21 = var16 - var13 * var18;

				for (var1 = -var10[var2]; var1 < 0; ++var1) {
					Rasterizer2D.Rasterizer2D_pixels[var19++] = this.pixels[this.subWidth * (var21 >> 16) + (var20 >> 16)];
					var20 += var14;
					var21 -= var13;
				}

				var15 += var13;
				var16 += var14;
				var17 += Rasterizer2D.Rasterizer2D_width;
			}
		} catch (Exception var23) {
		}

	}

	@ObfuscatedName("az")
	public void method6193(int var1, int var2, int var3, int var4, int var5, int var6, double var7, int var9) {
		try {
			int var10 = -var3 / 2;
			int var11 = -var4 / 2;
			int var12 = (int)(Math.sin(var7) * 65536.0D);
			int var13 = (int)(Math.cos(var7) * 65536.0D);
			var12 = var12 * var9 >> 8;
			var13 = var13 * var9 >> 8;
			int var14 = var11 * var12 + var10 * var13 + (var5 << 16);
			int var15 = var11 * var13 - var10 * var12 + (var6 << 16);
			int var16 = var1 + var2 * Rasterizer2D.Rasterizer2D_width;

			for (var2 = 0; var2 < var4; ++var2) {
				int var17 = var16;
				int var18 = var14;
				int var19 = var15;

				for (var1 = -var3; var1 < 0; ++var1) {
					int var20 = this.pixels[this.subWidth * (var19 >> 16) + (var18 >> 16)];
					if (var20 != 0) {
						Rasterizer2D.Rasterizer2D_pixels[var17++] = var20;
					} else {
						++var17;
					}

					var18 += var13;
					var19 -= var12;
				}

				var14 += var12;
				var15 += var13;
				var16 += Rasterizer2D.Rasterizer2D_width;
			}
		} catch (Exception var22) {
		}

	}

	@ObfuscatedName("ae")
	public void method6186(int var1, int var2, int var3, int var4) {
		this.method6143(this.width << 3, this.height << 3, var1 << 4, var2 << 4, var3, var4);
	}

	@ObfuscatedName("ao")
	void method6143(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var6 != 0) {
			var1 -= this.yOffset << 4;
			var2 -= this.xOffset << 4;
			double var7 = (double)(var5 & 65535) * 9.587379924285257E-5D;
			int var9 = (int)Math.floor(Math.sin(var7) * (double)var6 + 0.5D);
			int var10 = (int)Math.floor(Math.cos(var7) * (double)var6 + 0.5D);
			int var11 = var10 * -var1 + -var2 * var9;
			int var12 = -var2 * var10 + var9 * -(-var1);
			int var13 = var10 * ((this.subWidth << 4) - var1) + -var2 * var9;
			int var14 = var9 * -((this.subWidth << 4) - var1) + -var2 * var10;
			int var15 = ((this.subHeight << 4) - var2) * var9 + var10 * -var1;
			int var16 = ((this.subHeight << 4) - var2) * var10 + var9 * -(-var1);
			int var17 = ((this.subHeight << 4) - var2) * var9 + var10 * ((this.subWidth << 4) - var1);
			int var18 = ((this.subHeight << 4) - var2) * var10 + var9 * -((this.subWidth << 4) - var1);
			int var19;
			int var20;
			if (var11 < var13) {
				var19 = var11;
				var20 = var13;
			} else {
				var19 = var13;
				var20 = var11;
			}

			if (var15 < var19) {
				var19 = var15;
			}

			if (var17 < var19) {
				var19 = var17;
			}

			if (var15 > var20) {
				var20 = var15;
			}

			if (var17 > var20) {
				var20 = var17;
			}

			int var21;
			int var22;
			if (var12 < var14) {
				var21 = var12;
				var22 = var14;
			} else {
				var21 = var14;
				var22 = var12;
			}

			if (var16 < var21) {
				var21 = var16;
			}

			if (var18 < var21) {
				var21 = var18;
			}

			if (var16 > var22) {
				var22 = var16;
			}

			if (var18 > var22) {
				var22 = var18;
			}

			var19 >>= 12;
			var20 = var20 + 4095 >> 12;
			var21 >>= 12;
			var22 = var22 + 4095 >> 12;
			var19 += var3;
			var20 += var3;
			var21 += var4;
			var22 += var4;
			var19 >>= 4;
			var20 = var20 + 15 >> 4;
			var21 >>= 4;
			var22 = var22 + 15 >> 4;
			if (var19 < Rasterizer2D.Rasterizer2D_xClipStart) {
				var19 = Rasterizer2D.Rasterizer2D_xClipStart;
			}

			if (var20 > Rasterizer2D.Rasterizer2D_xClipEnd) {
				var20 = Rasterizer2D.Rasterizer2D_xClipEnd;
			}

			if (var21 < Rasterizer2D.Rasterizer2D_yClipStart) {
				var21 = Rasterizer2D.Rasterizer2D_yClipStart;
			}

			if (var22 > Rasterizer2D.Rasterizer2D_yClipEnd) {
				var22 = Rasterizer2D.Rasterizer2D_yClipEnd;
			}

			var20 = var19 - var20;
			if (var20 < 0) {
				var22 = var21 - var22;
				if (var22 < 0) {
					int var23 = var19 + var21 * Rasterizer2D.Rasterizer2D_width;
					double var24 = 1.6777216E7D / (double)var6;
					int var26 = (int)Math.floor(Math.sin(var7) * var24 + 0.5D);
					int var27 = (int)Math.floor(Math.cos(var7) * var24 + 0.5D);
					int var28 = (var19 << 4) + 8 - var3;
					int var29 = (var21 << 4) + 8 - var4;
					int var30 = (var1 << 8) - (var29 * var26 >> 4);
					int var31 = (var29 * var27 >> 4) + (var2 << 8);
					int var32;
					int var33;
					int var34;
					int var35;
					int var36;
					int var37;
					int var38;
					if (var27 == 0) {
						if (var26 == 0) {
							for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
								var34 = var23;
								var35 = var30;
								var36 = var31;
								var37 = var20;
								if (var30 >= 0 && var31 >= 0 && var30 - (this.subWidth << 12) < 0 && var31 - (this.subHeight << 12) < 0) {
									for (; var37 < 0; ++var37) {
										var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
										if (var38 != 0) {
											Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
										} else {
											++var34;
										}
									}
								}

								++var33;
							}
						} else if (var26 < 0) {
							for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
								var34 = var23;
								var35 = var30;
								var36 = (var28 * var26 >> 4) + var31;
								var37 = var20;
								if (var30 >= 0 && var30 - (this.subWidth << 12) < 0) {
									if ((var32 = var36 - (this.subHeight << 12)) >= 0) {
										var32 = (var26 - var32) / var26;
										var37 = var20 + var32;
										var36 += var26 * var32;
										var34 = var23 + var32;
									}

									if ((var32 = (var36 - var26) / var26) > var37) {
										var37 = var32;
									}

									while (var37 < 0) {
										var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
										if (var38 != 0) {
											Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
										} else {
											++var34;
										}

										var36 += var26;
										++var37;
									}
								}

								++var33;
								var30 -= var26;
							}
						} else {
							for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
								var34 = var23;
								var35 = var30;
								var36 = (var28 * var26 >> 4) + var31;
								var37 = var20;
								if (var30 >= 0 && var30 - (this.subWidth << 12) < 0) {
									if (var36 < 0) {
										var32 = (var26 - 1 - var36) / var26;
										var37 = var20 + var32;
										var36 += var26 * var32;
										var34 = var23 + var32;
									}

									if ((var32 = (var36 + 1 - (this.subHeight << 12) - var26) / var26) > var37) {
										var37 = var32;
									}

									while (var37 < 0) {
										var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
										if (var38 != 0) {
											Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
										} else {
											++var34;
										}

										var36 += var26;
										++var37;
									}
								}

								++var33;
								var30 -= var26;
							}
						}
					} else if (var27 < 0) {
						if (var26 == 0) {
							for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
								var34 = var23;
								var35 = (var28 * var27 >> 4) + var30;
								var36 = var31;
								var37 = var20;
								if (var31 >= 0 && var31 - (this.subHeight << 12) < 0) {
									if ((var32 = var35 - (this.subWidth << 12)) >= 0) {
										var32 = (var27 - var32) / var27;
										var37 = var20 + var32;
										var35 += var27 * var32;
										var34 = var23 + var32;
									}

									if ((var32 = (var35 - var27) / var27) > var37) {
										var37 = var32;
									}

									while (var37 < 0) {
										var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
										if (var38 != 0) {
											Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
										} else {
											++var34;
										}

										var35 += var27;
										++var37;
									}
								}

								++var33;
								var31 += var27;
							}
						} else if (var26 < 0) {
							for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
								var34 = var23;
								var35 = (var28 * var27 >> 4) + var30;
								var36 = (var28 * var26 >> 4) + var31;
								var37 = var20;
								if ((var32 = var35 - (this.subWidth << 12)) >= 0) {
									var32 = (var27 - var32) / var27;
									var37 = var20 + var32;
									var35 += var27 * var32;
									var36 += var26 * var32;
									var34 = var23 + var32;
								}

								if ((var32 = (var35 - var27) / var27) > var37) {
									var37 = var32;
								}

								if ((var32 = var36 - (this.subHeight << 12)) >= 0) {
									var32 = (var26 - var32) / var26;
									var37 += var32;
									var35 += var27 * var32;
									var36 += var26 * var32;
									var34 += var32;
								}

								if ((var32 = (var36 - var26) / var26) > var37) {
									var37 = var32;
								}

								while (var37 < 0) {
									var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
									if (var38 != 0) {
										Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
									} else {
										++var34;
									}

									var35 += var27;
									var36 += var26;
									++var37;
								}

								++var33;
								var30 -= var26;
								var31 += var27;
							}
						} else {
							for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
								var34 = var23;
								var35 = (var28 * var27 >> 4) + var30;
								var36 = (var28 * var26 >> 4) + var31;
								var37 = var20;
								if ((var32 = var35 - (this.subWidth << 12)) >= 0) {
									var32 = (var27 - var32) / var27;
									var37 = var20 + var32;
									var35 += var27 * var32;
									var36 += var26 * var32;
									var34 = var23 + var32;
								}

								if ((var32 = (var35 - var27) / var27) > var37) {
									var37 = var32;
								}

								if (var36 < 0) {
									var32 = (var26 - 1 - var36) / var26;
									var37 += var32;
									var35 += var27 * var32;
									var36 += var26 * var32;
									var34 += var32;
								}

								if ((var32 = (var36 + 1 - (this.subHeight << 12) - var26) / var26) > var37) {
									var37 = var32;
								}

								while (var37 < 0) {
									var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
									if (var38 != 0) {
										Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
									} else {
										++var34;
									}

									var35 += var27;
									var36 += var26;
									++var37;
								}

								++var33;
								var30 -= var26;
								var31 += var27;
							}
						}
					} else if (var26 == 0) {
						for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
							var34 = var23;
							var35 = (var28 * var27 >> 4) + var30;
							var36 = var31;
							var37 = var20;
							if (var31 >= 0 && var31 - (this.subHeight << 12) < 0) {
								if (var35 < 0) {
									var32 = (var27 - 1 - var35) / var27;
									var37 = var20 + var32;
									var35 += var27 * var32;
									var34 = var23 + var32;
								}

								if ((var32 = (var35 + 1 - (this.subWidth << 12) - var27) / var27) > var37) {
									var37 = var32;
								}

								while (var37 < 0) {
									var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
									if (var38 != 0) {
										Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
									} else {
										++var34;
									}

									var35 += var27;
									++var37;
								}
							}

							++var33;
							var31 += var27;
						}
					} else if (var26 < 0) {
						for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
							var34 = var23;
							var35 = (var28 * var27 >> 4) + var30;
							var36 = (var28 * var26 >> 4) + var31;
							var37 = var20;
							if (var35 < 0) {
								var32 = (var27 - 1 - var35) / var27;
								var37 = var20 + var32;
								var35 += var27 * var32;
								var36 += var26 * var32;
								var34 = var23 + var32;
							}

							if ((var32 = (var35 + 1 - (this.subWidth << 12) - var27) / var27) > var37) {
								var37 = var32;
							}

							if ((var32 = var36 - (this.subHeight << 12)) >= 0) {
								var32 = (var26 - var32) / var26;
								var37 += var32;
								var35 += var27 * var32;
								var36 += var26 * var32;
								var34 += var32;
							}

							if ((var32 = (var36 - var26) / var26) > var37) {
								var37 = var32;
							}

							while (var37 < 0) {
								var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
								if (var38 != 0) {
									Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
								} else {
									++var34;
								}

								var35 += var27;
								var36 += var26;
								++var37;
							}

							++var33;
							var30 -= var26;
							var31 += var27;
						}
					} else {
						for (var33 = var22; var33 < 0; var23 += Rasterizer2D.Rasterizer2D_width) {
							var34 = var23;
							var35 = (var28 * var27 >> 4) + var30;
							var36 = (var28 * var26 >> 4) + var31;
							var37 = var20;
							if (var35 < 0) {
								var32 = (var27 - 1 - var35) / var27;
								var37 = var20 + var32;
								var35 += var27 * var32;
								var36 += var26 * var32;
								var34 = var23 + var32;
							}

							if ((var32 = (var35 + 1 - (this.subWidth << 12) - var27) / var27) > var37) {
								var37 = var32;
							}

							if (var36 < 0) {
								var32 = (var26 - 1 - var36) / var26;
								var37 += var32;
								var35 += var27 * var32;
								var36 += var26 * var32;
								var34 += var32;
							}

							if ((var32 = (var36 + 1 - (this.subHeight << 12) - var26) / var26) > var37) {
								var37 = var32;
							}

							while (var37 < 0) {
								var38 = this.pixels[(var35 >> 12) + (var36 >> 12) * this.subWidth];
								if (var38 != 0) {
									Rasterizer2D.Rasterizer2D_pixels[var34++] = var38;
								} else {
									++var34;
								}

								var35 += var27;
								var36 += var26;
								++var37;
							}

							++var33;
							var30 -= var26;
							var31 += var27;
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("aj")
	public void method6144(int var1, int var2, int var3, int var4) {
		if (var3 <= this.width && var4 <= this.height) {
			int var5 = var3 * this.yOffset / this.width + var1;
			int var6 = (var3 * (this.yOffset + this.subWidth) + this.width - 1) / this.width + var1;
			int var7 = var2 + var4 * this.xOffset / this.height;
			int var8 = var2 + (this.height + (this.xOffset + this.subHeight) * var4 - 1) / this.height;
			if (var5 < Rasterizer2D.Rasterizer2D_xClipStart) {
				var5 = Rasterizer2D.Rasterizer2D_xClipStart;
			}

			if (var6 > Rasterizer2D.Rasterizer2D_xClipEnd) {
				var6 = Rasterizer2D.Rasterizer2D_xClipEnd;
			}

			if (var7 < Rasterizer2D.Rasterizer2D_yClipStart) {
				var7 = Rasterizer2D.Rasterizer2D_yClipStart;
			}

			if (var8 > Rasterizer2D.Rasterizer2D_yClipEnd) {
				var8 = Rasterizer2D.Rasterizer2D_yClipEnd;
			}

			if (var5 < var6 && var7 < var8) {
				int var9 = var5 + var7 * Rasterizer2D.Rasterizer2D_width;
				int var10 = Rasterizer2D.Rasterizer2D_width - (var6 - var5);
				if (var9 < Rasterizer2D.Rasterizer2D_pixels.length) {
					for (int var11 = var7; var11 < var8; ++var11) {
						for (int var12 = var5; var12 < var6; ++var12) {
							int var13 = var12 - var1 << 4;
							int var14 = var11 - var2 << 4;
							int var15 = var13 * this.width / var3 - (this.yOffset << 4);
							int var16 = (var13 + 16) * this.width / var3 - (this.yOffset << 4);
							int var17 = var14 * this.height / var4 - (this.xOffset << 4);
							int var18 = (var14 + 16) * this.height / var4 - (this.xOffset << 4);
							int var19 = (var16 - var15) * (var18 - var17) >> 1;
							if (var19 != 0) {
								if (var15 < 0) {
									var15 = 0;
								}

								if (var16 >= this.subWidth << 4) {
									var16 = this.subWidth << 4;
								}

								if (var17 < 0) {
									var17 = 0;
								}

								if (var18 >= this.subHeight << 4) {
									var18 = this.subHeight << 4;
								}

								--var16;
								--var18;
								int var20 = 16 - (var15 & 15);
								int var21 = (var16 & 15) + 1;
								int var22 = 16 - (var17 & 15);
								int var23 = (var18 & 15) + 1;
								var15 >>= 4;
								var16 >>= 4;
								var17 >>= 4;
								var18 >>= 4;
								int var24 = 0;
								int var25 = 0;
								int var26 = 0;
								int var27 = 0;

								int var28;
								for (var28 = var17; var28 <= var18; ++var28) {
									int var29 = 16;
									if (var28 == var17) {
										var29 = var22;
									}

									if (var28 == var18) {
										var29 = var23;
									}

									for (int var30 = var15; var30 <= var16; ++var30) {
										int var31 = this.pixels[var30 + var28 * this.subWidth];
										if (var31 != 0) {
											int var32;
											if (var30 == var15) {
												var32 = var29 * var20;
											} else if (var30 == var16) {
												var32 = var29 * var21;
											} else {
												var32 = var29 << 4;
											}

											var27 += var32;
											var24 += var32 * (var31 >> 16 & 255);
											var25 += var32 * (var31 >> 8 & 255);
											var26 += (var31 & 255) * var32;
										}
									}
								}

								if (var27 >= var19) {
									var28 = var26 / var27 + (var24 / var27 << 16) + (var25 / var27 << 8);
									if (var28 == 0) {
										var28 = 1;
									}

									Rasterizer2D.Rasterizer2D_pixels[var9] = var28;
								}

								++var9;
							}
						}

						var9 += var10;
					}

				}
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("x")
	@Export("Sprite_something")
	static void Sprite_something(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = -var5; var8 < 0; ++var8) {
			int var9;
			for (var9 = var3 + var4 - 3; var3 < var9; var0[var3++] = var1[var2++]) {
				var0[var3++] = var1[var2++];
				var0[var3++] = var1[var2++];
				var0[var3++] = var1[var2++];
			}

			for (var9 += 3; var3 < var9; var0[var3++] = var1[var2++]) {
			}

			var3 += var6;
			var2 += var7;
		}

	}

	@ObfuscatedName("v")
	@Export("Sprite_andAnotherOne")
	static void Sprite_andAnotherOne(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int var9 = -(var5 >> 2);
		var5 = -(var5 & 3);

		for (int var10 = -var6; var10 < 0; ++var10) {
			int var11;
			for (var11 = var9; var11 < 0; ++var11) {
				var2 = var1[var3++];
				if (var2 != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}

				var2 = var1[var3++];
				if (var2 != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}

				var2 = var1[var3++];
				if (var2 != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}

				var2 = var1[var3++];
				if (var2 != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}
			}

			for (var11 = var5; var11 < 0; ++var11) {
				var2 = var1[var3++];
				if (var2 != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}
			}

			var4 += var7;
			var3 += var8;
		}

	}

	@ObfuscatedName("g")
	@Export("Sprite_somethingElse")
	static void Sprite_somethingElse(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
		int var12 = var3;

		for (int var13 = -var8; var13 < 0; ++var13) {
			int var14 = var11 * (var4 >> 16);

			for (int var15 = -var7; var15 < 0; ++var15) {
				var2 = var1[(var3 >> 16) + var14];
				if (var2 != 0) {
					var0[var5++] = var2;
				} else {
					++var5;
				}

				var3 += var9;
			}

			var4 += var10;
			var3 = var12;
			var5 += var6;
		}

	}

	@ObfuscatedName("j")
	@Export("Sprite_anotherOne")
	static void Sprite_anotherOne(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		int var11 = 256 - var9;
		int var12 = (var10 & 16711935) * var11 & -16711936;
		int var13 = (var10 & 65280) * var11 & 16711680;
		var10 = (var12 | var13) >>> 8;

		for (int var14 = -var6; var14 < 0; ++var14) {
			for (int var15 = -var5; var15 < 0; ++var15) {
				var2 = var1[var3++];
				if (var2 != 0) {
					var12 = var9 * (var2 & 16711935) & -16711936;
					var13 = (var2 & 65280) * var9 & 16711680;
					var0[var4++] = var10 + ((var12 | var13) >>> 8);
				} else {
					++var4;
				}
			}

			var4 += var7;
			var3 += var8;
		}

	}

	@ObfuscatedName("d")
	@Export("Sprite_alpha1")
	static void Sprite_alpha1(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
		int var10 = 256 - var9;

		for (int var11 = -var6; var11 < 0; ++var11) {
			for (int var12 = -var5; var12 < 0; ++var12) {
				var2 = var1[var3++];
				if (var2 != 0) {
					int var13 = var0[var4];
					var0[var4++] = ((var13 & 16711935) * var10 + var9 * (var2 & 16711935) & -16711936) + ((var2 & 65280) * var9 + var10 * (var13 & 65280) & 16711680) >> 8;
				} else {
					++var4;
				}
			}

			var4 += var7;
			var3 += var8;
		}

	}

	@ObfuscatedName("z")
	@Export("Sprite_alpha2")
	static void Sprite_alpha2(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
		int var13 = 256 - var12;
		int var14 = var3;

		for (int var15 = -var8; var15 < 0; ++var15) {
			int var16 = var11 * (var4 >> 16);

			for (int var17 = -var7; var17 < 0; ++var17) {
				var2 = var1[(var3 >> 16) + var16];
				if (var2 != 0) {
					int var18 = var0[var5];
					var0[var5++] = ((var2 & 65280) * var12 + var13 * (var18 & 65280) & 16711680) + ((var18 & 16711935) * var13 + var12 * (var2 & 16711935) & -16711936) >> 8;
				} else {
					++var5;
				}

				var3 += var9;
			}

			var4 += var10;
			var3 = var14;
			var5 += var6;
		}

	}

	@ObfuscatedName("av")
	static void method6134(int var0, int var1, int var2, int[] var3, int[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
		for (var8 = -var10; var8 < 0; ++var8) {
			for (var6 = -var9; var6 < 0; ++var6) {
				var0 = var4[var5++];
				if (var0 != 0) {
					var1 = var3[var7];
					var2 = var0 + var1;
					var0 = (var0 & 16711935) + (var1 & 16711935);
					var1 = (var0 & 16777472) + (var2 - var0 & 65536);
					var3[var7++] = var2 - var1 | var1 - (var1 >>> 8);
				} else {
					++var7;
				}
			}

			var7 += var11;
			var5 += var12;
		}

	}

	@ObfuscatedName("as")
	static void method6119(int var0, int var1, int var2, int[] var3, int[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
		for (var8 = -var10; var8 < 0; ++var8) {
			for (var6 = -var9; var6 < 0; ++var6) {
				var0 = var4[var5++];
				if (var0 != 0) {
					var1 = var13 * (var0 & 16711935);
					var0 = (var1 & -16711936) + (var13 * var0 - var1 & 16711680) >>> 8;
					var1 = var3[var7];
					var2 = var0 + var1;
					var0 = (var0 & 16711935) + (var1 & 16711935);
					var1 = (var0 & 16777472) + (var2 - var0 & 65536);
					var3[var7++] = var2 - var1 | var1 - (var1 >>> 8);
				} else {
					++var7;
				}
			}

			var7 += var11;
			var5 += var12;
		}

	}

	@ObfuscatedName("ad")
	static void method6111(int var0, int var1, int var2, int var3, int[] var4, int[] var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15) {
		for (int var16 = var3; var8 < 0; ++var8) {
			var7 = var15 * (var9 >> 16);

			for (var6 = -var12; var6 < 0; ++var6) {
				var0 = var4[(var3 >> 16) + var7];
				if (var0 != 0) {
					var1 = var5[var10];
					var2 = var0 + var1;
					var0 = (var0 & 16711935) + (var1 & 16711935);
					var1 = (var0 & 16777472) + (var2 - var0 & 65536);
					var5[var10++] = var2 - var1 | var1 - (var1 >>> 8);
				} else {
					++var10;
				}

				var3 += var13;
			}

			var9 += var14;
			var3 = var16;
			var10 += var11;
		}

	}

	@ObfuscatedName("ag")
	static void method6138(int var0, int var1, int var2, int var3, int[] var4, int[] var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16) {
		for (int var17 = var3; var8 < 0; ++var8) {
			var7 = var15 * (var9 >> 16);

			for (var6 = -var12; var6 < 0; ++var6) {
				var0 = var4[(var3 >> 16) + var7];
				if (var0 != 0) {
					var1 = (var0 & 16711935) * var16;
					var0 = (var1 & -16711936) + (var0 * var16 - var1 & 16711680) >>> 8;
					var1 = var5[var10];
					var2 = var0 + var1;
					var0 = (var0 & 16711935) + (var1 & 16711935);
					var1 = (var0 & 16777472) + (var2 - var0 & 65536);
					var5[var10++] = var2 - var1 | var1 - (var1 >>> 8);
				} else {
					++var10;
				}

				var3 += var13;
			}

			var9 += var14;
			var3 = var17;
			var10 += var11;
		}

	}
}
