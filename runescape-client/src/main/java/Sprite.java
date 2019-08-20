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
	@Export("xOffset")
	public int xOffset;
	@ObfuscatedName("k")
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("l")
	@Export("width")
	public int width;
	@ObfuscatedName("b")
	@Export("height")
	public int height;

	public Sprite(int[] px, int w, int h) {
		this.pixels = px;
		this.subWidth = this.width = w;
		this.subHeight = this.height = h;
		this.yOffset = 0;
		this.xOffset = 0;
	}

	public Sprite(int w, int h) {
		this(new int[h * w], w, h);
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
		var1.xOffset = this.width - this.subWidth - this.xOffset;
		var1.yOffset = this.yOffset;

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
				var1.pixels[var3 + (var2 + this.yOffset) * this.width + this.xOffset] = this.pixels[var3 + var2 * this.subWidth];
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
		if (this.subWidth == this.width && this.subHeight == this.height) {
			return;
		}
		int[] var1 = new int[this.width * this.height];

		for (int var2 = 0; var2 < this.subHeight; ++var2) {
			for (int var3 = 0; var3 < this.subWidth; ++var3) {
				var1[var3 + (var2 + this.yOffset) * this.width + this.xOffset] = this.pixels[var3 + var2 * this.subWidth];
			}
		}

		this.pixels = var1;
		this.subWidth = this.width;
		this.subHeight = this.height;
		this.xOffset = 0;
		this.yOffset = 0;
	}

	@ObfuscatedName("k")
	@Export("pad")
	public void pad(int amount) {
		if (this.subWidth == this.width && this.subHeight == this.height) {
			return;
		}
		int var2 = amount;
		if (amount > this.xOffset) {
			var2 = this.xOffset;
		}

		int var3 = amount;
		if (amount + this.xOffset + this.subWidth > this.width) {
			var3 = this.width - this.xOffset - this.subWidth;
		}

		int var4 = amount;
		if (amount > this.yOffset) {
			var4 = this.yOffset;
		}

		int var5 = amount;
		if (amount + this.yOffset + this.subHeight > this.height) {
			var5 = this.height - this.yOffset - this.subHeight;
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
		this.xOffset -= var2;
		this.yOffset -= var4;
	}

	@ObfuscatedName("l")
	@Export("flipHorizontally")
	public void flipHorizontally() {
		int[] var1 = new int[this.subWidth * this.subHeight];
		int var2 = 0;

		for (int var3 = 0; var3 < this.subHeight; ++var3) {
			for (int var4 = this.subWidth - 1; var4 >= 0; --var4) {
				var1[var2++] = this.pixels[var4 + var3 * this.subWidth];
			}
		}

		this.pixels = var1;
		this.xOffset = this.width - this.subWidth - this.xOffset;
	}

	@ObfuscatedName("b")
	@Export("flipVertically")
	public void flipVertically() {
		int[] var1 = new int[this.subWidth * this.subHeight];
		int var2 = 0;

		for (int var3 = this.subHeight - 1; var3 >= 0; --var3) {
			for (int var4 = 0; var4 < this.subWidth; ++var4) {
				var1[var2++] = this.pixels[var4 + var3 * this.subWidth];
			}
		}

		this.pixels = var1;
		this.yOffset = this.height - this.subHeight - this.yOffset;
	}

	@ObfuscatedName("i")
	@Export("outline")
	public void outline(int color) {
		int[] var2 = new int[this.subWidth * this.subHeight];
		int var3 = 0;

		for (int var4 = 0; var4 < this.subHeight; ++var4) {
			for (int var5 = 0; var5 < this.subWidth; ++var5) {
				int var6 = this.pixels[var3];
				if (var6 == 0) {
					if (var5 > 0 && this.pixels[var3 - 1] != 0) {
						var6 = color;
					} else if (var4 > 0 && this.pixels[var3 - this.subWidth] != 0) {
						var6 = color;
					} else if (var5 < this.subWidth - 1 && this.pixels[var3 + 1] != 0) {
						var6 = color;
					} else if (var4 < this.subHeight - 1 && this.pixels[var3 + this.subWidth] != 0) {
						var6 = color;
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
	public void drawAt(int x, int y) {
		x += this.xOffset;
		y += this.yOffset;
		int var3 = x + y * Rasterizer2D.Rasterizer2D_width;
		int var4 = 0;
		int var5 = this.subHeight;
		int var6 = this.subWidth;
		int var7 = Rasterizer2D.Rasterizer2D_width - var6;
		int var8 = 0;
		int var9;
		if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_yClipStart - y;
			var5 -= var9;
			y = Rasterizer2D.Rasterizer2D_yClipStart;
			var4 += var9 * var6;
			var3 += var9 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var5 + y > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var5 -= var5 + y - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_xClipStart - x;
			var6 -= var9;
			x = Rasterizer2D.Rasterizer2D_xClipStart;
			var4 += var9;
			var3 += var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 + x > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var9 = var6 + x - Rasterizer2D.Rasterizer2D_xClipEnd;
			var6 -= var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 > 0 && var5 > 0) {
			Sprite_draw(Rasterizer2D.Rasterizer2D_pixels, this.pixels, var4, var3, var6, var5, var7, var8);
		}
	}

	@ObfuscatedName("r")
	@Export("drawTransBgAt")
	public void drawTransBgAt(int x, int y) {
		x += this.xOffset;
		y += this.yOffset;
		int var3 = x + y * Rasterizer2D.Rasterizer2D_width;
		int var4 = 0;
		int var5 = this.subHeight;
		int var6 = this.subWidth;
		int var7 = Rasterizer2D.Rasterizer2D_width - var6;
		int var8 = 0;
		int var9;
		if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_yClipStart - y;
			var5 -= var9;
			y = Rasterizer2D.Rasterizer2D_yClipStart;
			var4 += var9 * var6;
			var3 += var9 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var5 + y > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var5 -= var5 + y - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
			var9 = Rasterizer2D.Rasterizer2D_xClipStart - x;
			var6 -= var9;
			x = Rasterizer2D.Rasterizer2D_xClipStart;
			var4 += var9;
			var3 += var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 + x > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var9 = var6 + x - Rasterizer2D.Rasterizer2D_xClipEnd;
			var6 -= var9;
			var8 += var9;
			var7 += var9;
		}

		if (var6 > 0 && var5 > 0) {
			Sprite_drawTransBg(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var4, var3, var6, var5, var7, var8);
		}
	}

	@ObfuscatedName("y")
	@Export("drawScaledAt")
	public void drawScaledAt(int x, int y, int width, int height) {
		if (width <= 0 || height <= 0) {
			return;
		}
		int var5 = this.subWidth;
		int var6 = this.subHeight;
		int var7 = 0;
		int var8 = 0;
		int var9 = this.width;
		int var10 = this.height;
		int var11 = (var9 << 16) / width;
		int var12 = (var10 << 16) / height;
		int var13;
		if (this.xOffset > 0) {
			var13 = (var11 + (this.xOffset << 16) - 1) / var11;
			x += var13;
			var7 += var13 * var11 - (this.xOffset << 16);
		}

		if (this.yOffset > 0) {
			var13 = (var12 + (this.yOffset << 16) - 1) / var12;
			y += var13;
			var8 += var13 * var12 - (this.yOffset << 16);
		}

		if (var5 < var9) {
			width = (var11 + ((var5 << 16) - var7) - 1) / var11;
		}

		if (var6 < var10) {
			height = (var12 + ((var6 << 16) - var8) - 1) / var12;
		}

		var13 = x + y * Rasterizer2D.Rasterizer2D_width;
		int var14 = Rasterizer2D.Rasterizer2D_width - width;
		if (y + height > Rasterizer2D.Rasterizer2D_yClipEnd) {
			height -= y + height - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		int var15;
		if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
			var15 = Rasterizer2D.Rasterizer2D_yClipStart - y;
			height -= var15;
			var13 += var15 * Rasterizer2D.Rasterizer2D_width;
			var8 += var12 * var15;
		}

		if (width + x > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var15 = width + x - Rasterizer2D.Rasterizer2D_xClipEnd;
			width -= var15;
			var14 += var15;
		}

		if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
			var15 = Rasterizer2D.Rasterizer2D_xClipStart - x;
			width -= var15;
			var13 += var15;
			var7 += var11 * var15;
			var14 += var15;
		}

		Sprite_drawScaled(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var7, var8, var13, var14, width, height, var11, var12, var5);
	}

	@ObfuscatedName("a")
	@Export("drawTransOverlayAt")
	public void drawTransOverlayAt(int x, int y, int overlayOpacity, int overlayColor) {
		if (overlayOpacity == 256) {
			this.drawTransBgAt(x, y);
			return;
		}
		x += this.xOffset;
		y += this.yOffset;
		int var5 = x + y * Rasterizer2D.Rasterizer2D_width;
		int var6 = 0;
		int var7 = this.subHeight;
		int var8 = this.subWidth;
		int var9 = Rasterizer2D.Rasterizer2D_width - var8;
		int var10 = 0;
		int var11;
		if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
			var11 = Rasterizer2D.Rasterizer2D_yClipStart - y;
			var7 -= var11;
			y = Rasterizer2D.Rasterizer2D_yClipStart;
			var6 += var11 * var8;
			var5 += var11 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var7 + y > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var7 -= var7 + y - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
			var11 = Rasterizer2D.Rasterizer2D_xClipStart - x;
			var8 -= var11;
			x = Rasterizer2D.Rasterizer2D_xClipStart;
			var6 += var11;
			var5 += var11;
			var10 += var11;
			var9 += var11;
		}

		if (var8 + x > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var11 = var8 + x - Rasterizer2D.Rasterizer2D_xClipEnd;
			var8 -= var11;
			var10 += var11;
			var9 += var11;
		}

		if (var8 > 0 && var7 > 0) {
			Sprite_drawTransOverlay(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var6, var5, var8, var7, var9, var10, overlayOpacity, overlayColor);
		}
	}

	@ObfuscatedName("o")
	@Export("drawTransAt")
	public void drawTransAt(int x, int y, int opacity) {
		x += this.xOffset;
		y += this.yOffset;
		int var4 = x + y * Rasterizer2D.Rasterizer2D_width;
		int var5 = 0;
		int var6 = this.subHeight;
		int var7 = this.subWidth;
		int var8 = Rasterizer2D.Rasterizer2D_width - var7;
		int var9 = 0;
		int var10;
		if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_yClipStart - y;
			var6 -= var10;
			y = Rasterizer2D.Rasterizer2D_yClipStart;
			var5 += var10 * var7;
			var4 += var10 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var6 + y > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var6 -= var6 + y - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_xClipStart - x;
			var7 -= var10;
			x = Rasterizer2D.Rasterizer2D_xClipStart;
			var5 += var10;
			var4 += var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 + x > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var10 = var7 + x - Rasterizer2D.Rasterizer2D_xClipEnd;
			var7 -= var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 > 0 && var6 > 0) {
			Sprite_drawTransparent(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var5, var4, var7, var6, var8, var9, opacity);
		}
	}

	@ObfuscatedName("s")
	@Export("drawTransScaledAt")
	public void drawTransScaledAt(int x, int y, int width, int height, int opacity) {
		if (width <= 0 || height <= 0) {
			return;
		}
		int var6 = this.subWidth;
		int var7 = this.subHeight;
		int var8 = 0;
		int var9 = 0;
		int var10 = this.width;
		int var11 = this.height;
		int var12 = (var10 << 16) / width;
		int var13 = (var11 << 16) / height;
		int var14;
		if (this.xOffset > 0) {
			var14 = (var12 + (this.xOffset << 16) - 1) / var12;
			x += var14;
			var8 += var14 * var12 - (this.xOffset << 16);
		}

		if (this.yOffset > 0) {
			var14 = (var13 + (this.yOffset << 16) - 1) / var13;
			y += var14;
			var9 += var14 * var13 - (this.yOffset << 16);
		}

		if (var6 < var10) {
			width = (var12 + ((var6 << 16) - var8) - 1) / var12;
		}

		if (var7 < var11) {
			height = (var13 + ((var7 << 16) - var9) - 1) / var13;
		}

		var14 = x + y * Rasterizer2D.Rasterizer2D_width;
		int var15 = Rasterizer2D.Rasterizer2D_width - width;
		if (y + height > Rasterizer2D.Rasterizer2D_yClipEnd) {
			height -= y + height - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		int var16;
		if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
			var16 = Rasterizer2D.Rasterizer2D_yClipStart - y;
			height -= var16;
			var14 += var16 * Rasterizer2D.Rasterizer2D_width;
			var9 += var13 * var16;
		}

		if (width + x > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var16 = width + x - Rasterizer2D.Rasterizer2D_xClipEnd;
			width -= var16;
			var15 += var16;
		}

		if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
			var16 = Rasterizer2D.Rasterizer2D_xClipStart - x;
			width -= var16;
			var14 += var16;
			var8 += var12 * var16;
			var15 += var16;
		}

		Sprite_drawTransScaled(Rasterizer2D.Rasterizer2D_pixels, this.pixels, 0, var8, var9, var14, var15, width, height, var12, var13, var6, opacity);
	}

	@ObfuscatedName("al")
	public void method6135(int x, int y, int opacity) {
		x += this.xOffset;
		y += this.yOffset;
		int var4 = x + y * Rasterizer2D.Rasterizer2D_width;
		int var5 = 0;
		int var6 = this.subHeight;
		int var7 = this.subWidth;
		int var8 = Rasterizer2D.Rasterizer2D_width - var7;
		int var9 = 0;
		int var10;
		if (y < Rasterizer2D.Rasterizer2D_yClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_yClipStart - y;
			var6 -= var10;
			y = Rasterizer2D.Rasterizer2D_yClipStart;
			var5 += var10 * var7;
			var4 += var10 * Rasterizer2D.Rasterizer2D_width;
		}

		if (var6 + y > Rasterizer2D.Rasterizer2D_yClipEnd) {
			var6 -= var6 + y - Rasterizer2D.Rasterizer2D_yClipEnd;
		}

		if (x < Rasterizer2D.Rasterizer2D_xClipStart) {
			var10 = Rasterizer2D.Rasterizer2D_xClipStart - x;
			var7 -= var10;
			x = Rasterizer2D.Rasterizer2D_xClipStart;
			var5 += var10;
			var4 += var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 + x > Rasterizer2D.Rasterizer2D_xClipEnd) {
			var10 = var7 + x - Rasterizer2D.Rasterizer2D_xClipEnd;
			var7 -= var10;
			var9 += var10;
			var8 += var10;
		}

		if (var7 > 0 && var6 > 0) {
			if (opacity == 256) {
				method6134(0, 0, 0, Rasterizer2D.Rasterizer2D_pixels, this.pixels, var5, 0, var4, 0, var7, var6, var8, var9);
			} else {
				method6119(0, 0, 0, Rasterizer2D.Rasterizer2D_pixels, this.pixels, var5, 0, var4, 0, var7, var6, var8, var9, opacity);
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
			if (this.xOffset > 0) {
				var14 = (var12 + (this.xOffset << 16) - 1) / var12;
				var1 += var14;
				var8 += var14 * var12 - (this.xOffset << 16);
			}

			if (this.yOffset > 0) {
				var14 = (var13 + (this.yOffset << 16) - 1) / var13;
				var2 += var14;
				var9 += var14 * var13 - (this.yOffset << 16);
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
		if (var6 == 0) {
			return;
		}
		var1 -= this.xOffset << 4;
		var2 -= this.yOffset << 4;
		double var7 = (double)(var5 & 0xffff) * 9.587379924285257E-5D;
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
		if (var20 >= 0) {
			return;
		}
		var22 = var21 - var22;
		if (var22 >= 0) {
			return;
		}
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

	@ObfuscatedName("aj")
	@Export("drawScaledWorldmap")
	public void drawScaledWorldmap(int x, int y, int width, int height) {
		if (width > this.width || height > this.height) {
			throw new IllegalArgumentException();
		}
		int var5 = width * this.xOffset / this.width + x;
		int var6 = (width * (this.xOffset + this.subWidth) + this.width - 1) / this.width + x;
		int var7 = y + height * this.yOffset / this.height;
		int var8 = y + (this.height + (this.yOffset + this.subHeight) * height - 1) / this.height;
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

		if (var5 >= var6 || var7 >= var8) {
			return;
		}
		int var9 = var5 + var7 * Rasterizer2D.Rasterizer2D_width;
		int var10 = Rasterizer2D.Rasterizer2D_width - (var6 - var5);
		if (var9 >= Rasterizer2D.Rasterizer2D_pixels.length) {
			return;
		}
		for (int var11 = var7; var11 < var8; ++var11) {
			for (int var12 = var5; var12 < var6; ++var12) {
				int var13 = var12 - x << 4;
				int var14 = var11 - y << 4;
				int var15 = var13 * this.width / width - (this.xOffset << 4);
				int var16 = (var13 + 16) * this.width / width - (this.xOffset << 4);
				int var17 = var14 * this.height / height - (this.yOffset << 4);
				int var18 = (var14 + 16) * this.height / height - (this.yOffset << 4);
				int var19 = (var16 - var15) * (var18 - var17) >> 1;
				if (var19 == 0) {
					continue;
				}
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
						if (var31 == 0) {
							continue;
						}
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

				if (var27 >= var19) {
					var28 = var26 / var27 + (var24 / var27 << 16) + (var25 / var27 << 8);
					if (var28 == 0) {
						var28 = 1;
					}

					Rasterizer2D.Rasterizer2D_pixels[var9] = var28;
				}

				++var9;
			}

			var9 += var10;
		}

	}

	@ObfuscatedName("x")
	@Export("Sprite_draw")
	static void Sprite_draw(int[] rasterPx, int[] spritePx, int spritePxIdx, int rasterPxIdx, int width, int height, int rasterStartOffset, int spriteStartOffset) {
		for (int var8 = -height; var8 < 0; ++var8) {
			int var9;
			for (var9 = rasterPxIdx + width - 3; rasterPxIdx < var9; rasterPx[rasterPxIdx++] = spritePx[spritePxIdx++]) {
				rasterPx[rasterPxIdx++] = spritePx[spritePxIdx++];
				rasterPx[rasterPxIdx++] = spritePx[spritePxIdx++];
				rasterPx[rasterPxIdx++] = spritePx[spritePxIdx++];
			}

			for (var9 += 3; rasterPxIdx < var9; rasterPx[rasterPxIdx++] = spritePx[spritePxIdx++]) {
			}

			rasterPxIdx += rasterStartOffset;
			spritePxIdx += spriteStartOffset;
		}

	}

	@ObfuscatedName("v")
	@Export("Sprite_drawTransBg")
	static void Sprite_drawTransBg(int[] rasterPx, int[] spritePx, int currentPx, int spritePxIdx, int rasterPxIdx, int width, int height, int rasterStartOffset, int spriteStartOffset) {
		int var9 = -(width >> 2);
		width = -(width & 3);

		for (int var10 = -height; var10 < 0; ++var10) {
			for (int var11 = var9; var11 < 0; ++var11) {
				currentPx = spritePx[spritePxIdx++];
				if (currentPx != 0) {
					rasterPx[rasterPxIdx++] = currentPx;
				} else {
					++rasterPxIdx;
				}

				currentPx = spritePx[spritePxIdx++];
				if (currentPx != 0) {
					rasterPx[rasterPxIdx++] = currentPx;
				} else {
					++rasterPxIdx;
				}

				currentPx = spritePx[spritePxIdx++];
				if (currentPx != 0) {
					rasterPx[rasterPxIdx++] = currentPx;
				} else {
					++rasterPxIdx;
				}

				currentPx = spritePx[spritePxIdx++];
				if (currentPx != 0) {
					rasterPx[rasterPxIdx++] = currentPx;
				} else {
					++rasterPxIdx;
				}
			}

			for (int var11 = width; var11 < 0; ++var11) {
				currentPx = spritePx[spritePxIdx++];
				if (currentPx != 0) {
					rasterPx[rasterPxIdx++] = currentPx;
				} else {
					++rasterPxIdx;
				}
			}

			rasterPxIdx += rasterStartOffset;
			spritePxIdx += spriteStartOffset;
		}

	}

	@ObfuscatedName("g")
	@Export("Sprite_drawScaled")
	static void Sprite_drawScaled(int[] rasterPx, int[] spritePx, int currentPx, int xIdx, int yIdx, int rasterPxIdx, int rasterPxOffset, int width, int height, int pixelWidth, int pixelHeight, int subWidth) {
		int var12 = xIdx;

		for (int var13 = -height; var13 < 0; ++var13) {
			int var14 = subWidth * (yIdx >> 16);

			for (int var15 = -width; var15 < 0; ++var15) {
				currentPx = spritePx[(xIdx >> 16) + var14];
				if (currentPx != 0) {
					rasterPx[rasterPxIdx++] = currentPx;
				} else {
					++rasterPxIdx;
				}

				xIdx += pixelWidth;
			}

			yIdx += pixelHeight;
			xIdx = var12;
			rasterPxIdx += rasterPxOffset;
		}

	}

	@ObfuscatedName("j")
	@Export("Sprite_drawTransOverlay")
	static void Sprite_drawTransOverlay(int[] rasterPx, int[] spritePx, int currentPx, int spritePxIdx, int rasterPxIdx, int width, int height, int rasterStartOffset, int spriteStartOffset, int overlayOpacity, int overlayColor) {
		int var11 = 256 - overlayOpacity;
		int var12 = (overlayColor & 0xff00ff) * var11 & 0xff00ff00;
		int var13 = (overlayColor & 0xff00) * var11 & 0xff0000;
		overlayColor = (var12 | var13) >>> 8;

		for (int var14 = -height; var14 < 0; ++var14) {
			for (int var15 = -width; var15 < 0; ++var15) {
				currentPx = spritePx[spritePxIdx++];
				if (currentPx != 0) {
					var12 = overlayOpacity * (currentPx & 0xff00ff) & 0xff00ff00;
					var13 = (currentPx & 0xff00) * overlayOpacity & 0xff0000;
					rasterPx[rasterPxIdx++] = overlayColor + ((var12 | var13) >>> 8);
				} else {
					++rasterPxIdx;
				}
			}

			rasterPxIdx += rasterStartOffset;
			spritePxIdx += spriteStartOffset;
		}

	}

	@ObfuscatedName("d")
	@Export("Sprite_drawTransparent")
	static void Sprite_drawTransparent(int[] rasterPx, int[] spritePx, int currentPx, int spritePxIdx, int rasterPxIdx, int width, int height, int rasterStartOffset, int spriteStartOffset, int opacity) {
		int var10 = 256 - opacity;

		for (int var11 = -height; var11 < 0; ++var11) {
			for (int var12 = -width; var12 < 0; ++var12) {
				currentPx = spritePx[spritePxIdx++];
				if (currentPx != 0) {
					int var13 = rasterPx[rasterPxIdx];
					rasterPx[rasterPxIdx++] = ((var13 & 0xff00ff) * var10 + opacity * (currentPx & 0xff00ff) & 0xff00ff00) + ((currentPx & 0xff00) * opacity + var10 * (var13 & 0xff00) & 0xff0000) >> 8;
				} else {
					++rasterPxIdx;
				}
			}

			rasterPxIdx += rasterStartOffset;
			spritePxIdx += spriteStartOffset;
		}

	}

	@ObfuscatedName("z")
	@Export("Sprite_drawTransScaled")
	static void Sprite_drawTransScaled(int[] rasterPx, int[] spritePx, int currentPx, int xIdx, int yIdx, int rasterPxIdx, int rasterPxOffset, int width, int height, int pxWidth, int pxHeight, int subWidth, int opacity) {
		int var13 = 256 - opacity;
		int var14 = xIdx;

		for (int var15 = -height; var15 < 0; ++var15) {
			int var16 = subWidth * (yIdx >> 16);

			for (int var17 = -width; var17 < 0; ++var17) {
				currentPx = spritePx[(xIdx >> 16) + var16];
				if (currentPx != 0) {
					int var18 = rasterPx[rasterPxIdx];
					rasterPx[rasterPxIdx++] = ((currentPx & 0xff00) * opacity + var13 * (var18 & 0xff00) & 0xff0000) + ((var18 & 0xff00ff) * var13 + opacity * (currentPx & 0xff00ff) & 0xff00ff00) >> 8;
				} else {
					++rasterPxIdx;
				}

				xIdx += pxWidth;
			}

			yIdx += pxHeight;
			xIdx = var14;
			rasterPxIdx += rasterPxOffset;
		}

	}

	@ObfuscatedName("av")
	static void method6134(int curSpritePx, int curRasterPx, int var2, int[] rasterPx, int[] spritePx, int spritePxIdx, int var6, int rasterPxIdx, int var8, int width, int height, int rasterPxOffset, int spritePxOffset) {
		for (var8 = -height; var8 < 0; ++var8) {
			for (var6 = -width; var6 < 0; ++var6) {
				curSpritePx = spritePx[spritePxIdx++];
				if (curSpritePx != 0) {
					curRasterPx = rasterPx[rasterPxIdx];
					var2 = curSpritePx + curRasterPx;
					curSpritePx = (curSpritePx & 0xff00ff) + (curRasterPx & 0xff00ff);
					curRasterPx = (curSpritePx & 0x1000100) + (var2 - curSpritePx & 0x10000);
					rasterPx[rasterPxIdx++] = var2 - curRasterPx | curRasterPx - (curRasterPx >>> 8);
				} else {
					++rasterPxIdx;
				}
			}

			rasterPxIdx += rasterPxOffset;
			spritePxIdx += spritePxOffset;
		}

	}

	@ObfuscatedName("as")
	static void method6119(int var0, int var1, int var2, int[] rasterPx, int[] spritePx, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int opacity) {
		for (var8 = -var10; var8 < 0; ++var8) {
			for (var6 = -var9; var6 < 0; ++var6) {
				var0 = spritePx[var5++];
				if (var0 != 0) {
					var1 = opacity * (var0 & 0xff00ff);
					var0 = (var1 & 0xff00ff00) + (opacity * var0 - var1 & 0xff0000) >>> 8;
					var1 = rasterPx[var7];
					var2 = var0 + var1;
					var0 = (var0 & 0xff00ff) + (var1 & 0xff00ff);
					var1 = (var0 & 16777472) + (var2 - var0 & 65536);
					rasterPx[var7++] = var2 - var1 | var1 - (var1 >>> 8);
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
					var0 = (var0 & 0xff00ff) + (var1 & 0xff00ff);
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
					var1 = (var0 & 0xff00ff) * var16;
					var0 = (var1 & 0xff00ff00) + (var0 * var16 - var1 & 0xff0000) >>> 8;
					var1 = var5[var10];
					var2 = var0 + var1;
					var0 = (var0 & 0xff00ff) + (var1 & 0xff00ff);
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
