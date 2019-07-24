import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lb")
@Implements("Rasterizer2D")
public class Rasterizer2D extends DualNode {
	@ObfuscatedName("av")
	@Export("Rasterizer2D_pixels")
	public static int[] Rasterizer2D_pixels;
	@ObfuscatedName("as")
	@Export("Rasterizer2D_width")
	public static int Rasterizer2D_width;
	@ObfuscatedName("aw")
	@Export("Rasterizer2D_height")
	public static int Rasterizer2D_height;
	@ObfuscatedName("ad")
	@Export("Rasterizer2D_yClipStart")
	public static int Rasterizer2D_yClipStart;
	@ObfuscatedName("ag")
	@Export("Rasterizer2D_yClipEnd")
	public static int Rasterizer2D_yClipEnd;
	@ObfuscatedName("ar")
	@Export("Rasterizer2D_xClipStart")
	public static int Rasterizer2D_xClipStart;
	@ObfuscatedName("ax")
	@Export("Rasterizer2D_xClipEnd")
	public static int Rasterizer2D_xClipEnd;

	static {
		Rasterizer2D_yClipStart = 0;
		Rasterizer2D_yClipEnd = 0;
		Rasterizer2D_xClipStart = 0;
		Rasterizer2D_xClipEnd = 0;
	}

	protected Rasterizer2D() {
	}

	@ObfuscatedName("cd")
	@Export("Rasterizer2D_replace")
	public static void Rasterizer2D_replace(int[] var0, int var1, int var2) {
		Rasterizer2D_pixels = var0;
		Rasterizer2D_width = var1;
		Rasterizer2D_height = var2;
		Rasterizer2D_setClip(0, 0, var1, var2);
	}

	@ObfuscatedName("dr")
	@Export("Rasterizer2D_resetClip")
	public static void Rasterizer2D_resetClip() {
		Rasterizer2D_xClipStart = 0;
		Rasterizer2D_yClipStart = 0;
		Rasterizer2D_xClipEnd = Rasterizer2D_width;
		Rasterizer2D_yClipEnd = Rasterizer2D_height;
	}

	@ObfuscatedName("dn")
	@Export("Rasterizer2D_setClip")
	public static void Rasterizer2D_setClip(int var0, int var1, int var2, int var3) {
		if (var0 < 0) {
			var0 = 0;
		}

		if (var1 < 0) {
			var1 = 0;
		}

		if (var2 > Rasterizer2D_width) {
			var2 = Rasterizer2D_width;
		}

		if (var3 > Rasterizer2D_height) {
			var3 = Rasterizer2D_height;
		}

		Rasterizer2D_xClipStart = var0;
		Rasterizer2D_yClipStart = var1;
		Rasterizer2D_xClipEnd = var2;
		Rasterizer2D_yClipEnd = var3;
	}

	@ObfuscatedName("dw")
	@Export("Rasterizer2D_expandClip")
	public static void Rasterizer2D_expandClip(int var0, int var1, int var2, int var3) {
		if (Rasterizer2D_xClipStart < var0) {
			Rasterizer2D_xClipStart = var0;
		}

		if (Rasterizer2D_yClipStart < var1) {
			Rasterizer2D_yClipStart = var1;
		}

		if (Rasterizer2D_xClipEnd > var2) {
			Rasterizer2D_xClipEnd = var2;
		}

		if (Rasterizer2D_yClipEnd > var3) {
			Rasterizer2D_yClipEnd = var3;
		}

	}

	@ObfuscatedName("dg")
	@Export("Rasterizer2D_getClipArray")
	public static void Rasterizer2D_getClipArray(int[] var0) {
		var0[0] = Rasterizer2D_xClipStart;
		var0[1] = Rasterizer2D_yClipStart;
		var0[2] = Rasterizer2D_xClipEnd;
		var0[3] = Rasterizer2D_yClipEnd;
	}

	@ObfuscatedName("df")
	@Export("Rasterizer2D_setClipArray")
	public static void Rasterizer2D_setClipArray(int[] var0) {
		Rasterizer2D_xClipStart = var0[0];
		Rasterizer2D_yClipStart = var0[1];
		Rasterizer2D_xClipEnd = var0[2];
		Rasterizer2D_yClipEnd = var0[3];
	}

	@ObfuscatedName("dt")
	@Export("Rasterizer2D_clear")
	public static void Rasterizer2D_clear() {
		int var0 = 0;

		int var1;
		for (var1 = Rasterizer2D_width * Rasterizer2D_height - 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
			Rasterizer2D_pixels[var0++] = 0;
			Rasterizer2D_pixels[var0++] = 0;
			Rasterizer2D_pixels[var0++] = 0;
			Rasterizer2D_pixels[var0++] = 0;
			Rasterizer2D_pixels[var0++] = 0;
			Rasterizer2D_pixels[var0++] = 0;
			Rasterizer2D_pixels[var0++] = 0;
		}

		for (var1 += 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
		}

	}

	@ObfuscatedName("dj")
	@Export("drawCircle")
	static void drawCircle(int var0, int var1, int var2, int var3) {
		if (var2 == 0) {
			Rasterizer2D_setPixel(var0, var1, var3);
		} else {
			if (var2 < 0) {
				var2 = -var2;
			}

			int var4 = var1 - var2;
			if (var4 < Rasterizer2D_yClipStart) {
				var4 = Rasterizer2D_yClipStart;
			}

			int var5 = var2 + var1 + 1;
			if (var5 > Rasterizer2D_yClipEnd) {
				var5 = Rasterizer2D_yClipEnd;
			}

			int var6 = var4;
			int var7 = var2 * var2;
			int var8 = 0;
			int var9 = var1 - var4;
			int var10 = var9 * var9;
			int var11 = var10 - var9;
			if (var1 > var5) {
				var1 = var5;
			}

			int var12;
			int var13;
			int var14;
			int var15;
			while (var6 < var1) {
				while (var11 <= var7 || var10 <= var7) {
					var10 = var10 + var8 + var8;
					var11 += var8++ + var8;
				}

				var12 = var0 - var8 + 1;
				if (var12 < Rasterizer2D_xClipStart) {
					var12 = Rasterizer2D_xClipStart;
				}

				var13 = var0 + var8;
				if (var13 > Rasterizer2D_xClipEnd) {
					var13 = Rasterizer2D_xClipEnd;
				}

				var14 = var12 + var6 * Rasterizer2D_width;

				for (var15 = var12; var15 < var13; ++var15) {
					Rasterizer2D_pixels[var14++] = var3;
				}

				++var6;
				var10 -= var9-- + var9;
				var11 -= var9 + var9;
			}

			var8 = var2;
			var9 = var6 - var1;
			var11 = var7 + var9 * var9;
			var10 = var11 - var2;

			for (var11 -= var9; var6 < var5; var10 += var9++ + var9) {
				while (var11 > var7 && var10 > var7) {
					var11 -= var8-- + var8;
					var10 -= var8 + var8;
				}

				var12 = var0 - var8;
				if (var12 < Rasterizer2D_xClipStart) {
					var12 = Rasterizer2D_xClipStart;
				}

				var13 = var0 + var8;
				if (var13 > Rasterizer2D_xClipEnd - 1) {
					var13 = Rasterizer2D_xClipEnd - 1;
				}

				var14 = var12 + var6 * Rasterizer2D_width;

				for (var15 = var12; var15 <= var13; ++var15) {
					Rasterizer2D_pixels[var14++] = var3;
				}

				++var6;
				var11 = var11 + var9 + var9;
			}

		}
	}

	@ObfuscatedName("dl")
	@Export("Rasterizer2D_drawCircleAlpha")
	public static void Rasterizer2D_drawCircleAlpha(int var0, int var1, int var2, int var3, int var4) {
		if (var4 != 0) {
			if (var4 == 256) {
				drawCircle(var0, var1, var2, var3);
			} else {
				if (var2 < 0) {
					var2 = -var2;
				}

				int var5 = 256 - var4;
				int var6 = (var3 >> 16 & 255) * var4;
				int var7 = (var3 >> 8 & 255) * var4;
				int var8 = var4 * (var3 & 255);
				int var12 = var1 - var2;
				if (var12 < Rasterizer2D_yClipStart) {
					var12 = Rasterizer2D_yClipStart;
				}

				int var13 = var2 + var1 + 1;
				if (var13 > Rasterizer2D_yClipEnd) {
					var13 = Rasterizer2D_yClipEnd;
				}

				int var14 = var12;
				int var15 = var2 * var2;
				int var16 = 0;
				int var17 = var1 - var12;
				int var18 = var17 * var17;
				int var19 = var18 - var17;
				if (var1 > var13) {
					var1 = var13;
				}

				int var9;
				int var10;
				int var11;
				int var20;
				int var21;
				int var22;
				int var23;
				int var24;
				while (var14 < var1) {
					while (var19 <= var15 || var18 <= var15) {
						var18 = var18 + var16 + var16;
						var19 += var16++ + var16;
					}

					var20 = var0 - var16 + 1;
					if (var20 < Rasterizer2D_xClipStart) {
						var20 = Rasterizer2D_xClipStart;
					}

					var21 = var0 + var16;
					if (var21 > Rasterizer2D_xClipEnd) {
						var21 = Rasterizer2D_xClipEnd;
					}

					var22 = var20 + var14 * Rasterizer2D_width;

					for (var23 = var20; var23 < var21; ++var23) {
						var9 = var5 * (Rasterizer2D_pixels[var22] >> 16 & 255);
						var10 = (Rasterizer2D_pixels[var22] >> 8 & 255) * var5;
						var11 = var5 * (Rasterizer2D_pixels[var22] & 255);
						var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
						Rasterizer2D_pixels[var22++] = var24;
					}

					++var14;
					var18 -= var17-- + var17;
					var19 -= var17 + var17;
				}

				var16 = var2;
				var17 = -var17;
				var19 = var15 + var17 * var17;
				var18 = var19 - var2;

				for (var19 -= var17; var14 < var13; var18 += var17++ + var17) {
					while (var19 > var15 && var18 > var15) {
						var19 -= var16-- + var16;
						var18 -= var16 + var16;
					}

					var20 = var0 - var16;
					if (var20 < Rasterizer2D_xClipStart) {
						var20 = Rasterizer2D_xClipStart;
					}

					var21 = var0 + var16;
					if (var21 > Rasterizer2D_xClipEnd - 1) {
						var21 = Rasterizer2D_xClipEnd - 1;
					}

					var22 = var20 + var14 * Rasterizer2D_width;

					for (var23 = var20; var23 <= var21; ++var23) {
						var9 = var5 * (Rasterizer2D_pixels[var22] >> 16 & 255);
						var10 = (Rasterizer2D_pixels[var22] >> 8 & 255) * var5;
						var11 = var5 * (Rasterizer2D_pixels[var22] & 255);
						var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
						Rasterizer2D_pixels[var22++] = var24;
					}

					++var14;
					var19 = var19 + var17 + var17;
				}

			}
		}
	}

	@ObfuscatedName("dz")
	@Export("Rasterizer2D_fillRectangleAlpha")
	public static void Rasterizer2D_fillRectangleAlpha(int var0, int var1, int var2, int var3, int var4, int var5) {
		if (var0 < Rasterizer2D_xClipStart) {
			var2 -= Rasterizer2D_xClipStart - var0;
			var0 = Rasterizer2D_xClipStart;
		}

		if (var1 < Rasterizer2D_yClipStart) {
			var3 -= Rasterizer2D_yClipStart - var1;
			var1 = Rasterizer2D_yClipStart;
		}

		if (var0 + var2 > Rasterizer2D_xClipEnd) {
			var2 = Rasterizer2D_xClipEnd - var0;
		}

		if (var3 + var1 > Rasterizer2D_yClipEnd) {
			var3 = Rasterizer2D_yClipEnd - var1;
		}

		var4 = (var5 * (var4 & 16711935) >> 8 & 16711935) + (var5 * (var4 & 65280) >> 8 & 65280);
		int var6 = 256 - var5;
		int var7 = Rasterizer2D_width - var2;
		int var8 = var0 + Rasterizer2D_width * var1;

		for (int var9 = 0; var9 < var3; ++var9) {
			for (int var10 = -var2; var10 < 0; ++var10) {
				int var11 = Rasterizer2D_pixels[var8];
				var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + (var6 * (var11 & 65280) >> 8 & 65280);
				Rasterizer2D_pixels[var8++] = var11 + var4;
			}

			var8 += var7;
		}

	}

	@ObfuscatedName("dh")
	@Export("Rasterizer2D_fillRectangle")
	public static void Rasterizer2D_fillRectangle(int var0, int var1, int var2, int var3, int var4) {
		if (var0 < Rasterizer2D_xClipStart) {
			var2 -= Rasterizer2D_xClipStart - var0;
			var0 = Rasterizer2D_xClipStart;
		}

		if (var1 < Rasterizer2D_yClipStart) {
			var3 -= Rasterizer2D_yClipStart - var1;
			var1 = Rasterizer2D_yClipStart;
		}

		if (var0 + var2 > Rasterizer2D_xClipEnd) {
			var2 = Rasterizer2D_xClipEnd - var0;
		}

		if (var3 + var1 > Rasterizer2D_yClipEnd) {
			var3 = Rasterizer2D_yClipEnd - var1;
		}

		int var5 = Rasterizer2D_width - var2;
		int var6 = var0 + Rasterizer2D_width * var1;

		for (int var7 = -var3; var7 < 0; ++var7) {
			for (int var8 = -var2; var8 < 0; ++var8) {
				Rasterizer2D_pixels[var6++] = var4;
			}

			var6 += var5;
		}

	}

	@ObfuscatedName("dy")
	@Export("Rasterizer2D_fillRectangleGradient")
	public static void Rasterizer2D_fillRectangleGradient(int var0, int var1, int var2, int var3, int var4, int var5) {
		if (var2 > 0 && var3 > 0) {
			int var6 = 0;
			int var7 = 65536 / var3;
			if (var0 < Rasterizer2D_xClipStart) {
				var2 -= Rasterizer2D_xClipStart - var0;
				var0 = Rasterizer2D_xClipStart;
			}

			if (var1 < Rasterizer2D_yClipStart) {
				var6 += (Rasterizer2D_yClipStart - var1) * var7;
				var3 -= Rasterizer2D_yClipStart - var1;
				var1 = Rasterizer2D_yClipStart;
			}

			if (var0 + var2 > Rasterizer2D_xClipEnd) {
				var2 = Rasterizer2D_xClipEnd - var0;
			}

			if (var3 + var1 > Rasterizer2D_yClipEnd) {
				var3 = Rasterizer2D_yClipEnd - var1;
			}

			int var8 = Rasterizer2D_width - var2;
			int var9 = var0 + Rasterizer2D_width * var1;

			for (int var10 = -var3; var10 < 0; ++var10) {
				int var11 = 65536 - var6 >> 8;
				int var12 = var6 >> 8;
				int var13 = (var12 * (var5 & 16711935) + var11 * (var4 & 16711935) & -16711936) + (var12 * (var5 & 65280) + var11 * (var4 & 65280) & 16711680) >>> 8;

				for (int var14 = -var2; var14 < 0; ++var14) {
					Rasterizer2D_pixels[var9++] = var13;
				}

				var9 += var8;
				var6 += var7;
			}

		}
	}

	@ObfuscatedName("dx")
	@Export("Rasterizer2D_fillRectangleGradientAlpha")
	public static void Rasterizer2D_fillRectangleGradientAlpha(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var2 > 0 && var3 > 0) {
			int var8 = 0;
			int var9 = 65536 / var3;
			if (var0 < Rasterizer2D_xClipStart) {
				var2 -= Rasterizer2D_xClipStart - var0;
				var0 = Rasterizer2D_xClipStart;
			}

			if (var1 < Rasterizer2D_yClipStart) {
				var8 += (Rasterizer2D_yClipStart - var1) * var9;
				var3 -= Rasterizer2D_yClipStart - var1;
				var1 = Rasterizer2D_yClipStart;
			}

			if (var0 + var2 > Rasterizer2D_xClipEnd) {
				var2 = Rasterizer2D_xClipEnd - var0;
			}

			if (var3 + var1 > Rasterizer2D_yClipEnd) {
				var3 = Rasterizer2D_yClipEnd - var1;
			}

			int var10 = Rasterizer2D_width - var2;
			int var11 = var0 + Rasterizer2D_width * var1;

			for (int var12 = -var3; var12 < 0; ++var12) {
				int var13 = 65536 - var8 >> 8;
				int var14 = var8 >> 8;
				int var15 = (var13 * var6 + var14 * var7 & 65280) >>> 8;
				if (var15 == 0) {
					var11 += Rasterizer2D_width;
					var8 += var9;
				} else {
					int var16 = (var14 * (var5 & 16711935) + var13 * (var4 & 16711935) & -16711936) + (var14 * (var5 & 65280) + var13 * (var4 & 65280) & 16711680) >>> 8;
					int var17 = 255 - var15;
					int var18 = ((var16 & 16711935) * var15 >> 8 & 16711935) + (var15 * (var16 & 65280) >> 8 & 65280);

					for (int var19 = -var2; var19 < 0; ++var19) {
						int var20 = Rasterizer2D_pixels[var11];
						if (var20 == 0) {
							Rasterizer2D_pixels[var11++] = var18;
						} else {
							var20 = ((var20 & 16711935) * var17 >> 8 & 16711935) + (var17 * (var20 & 65280) >> 8 & 65280);
							Rasterizer2D_pixels[var11++] = var18 + var20;
						}
					}

					var11 += var10;
					var8 += var9;
				}
			}

		}
	}

	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "(IIIIII[BIZ)V",
		garbageValue = "1"
	)
	@Export("raster2d7")
	public static void raster2d7(int var0, int var1, int var2, int var3, int var4, int var5, byte[] var6, int var7) {
		if (var0 + var2 >= 0 && var3 + var1 >= 0) {
			if (var0 < Rasterizer2D_width && var1 < Rasterizer2D_height) {
				int var8 = 0;
				int var9 = 0;
				if (var0 < 0) {
					var8 -= var0;
					var2 += var0;
				}

				if (var1 < 0) {
					var9 -= var1;
					var3 += var1;
				}

				if (var0 + var2 > Rasterizer2D_width) {
					var2 = Rasterizer2D_width - var0;
				}

				if (var3 + var1 > Rasterizer2D_height) {
					var3 = Rasterizer2D_height - var1;
				}

				int var10 = var6.length / var7;
				int var11 = Rasterizer2D_width - var2;
				int var12 = var4 >>> 24;
				int var13 = var5 >>> 24;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				if (var12 == 255 && var13 == 255) {
					var14 = var0 + var8 + (var9 + var1) * Rasterizer2D_width;

					for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
						for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
							var17 = (var15 - var1) % var10;
							var18 = (var16 - var0) % var7;
							if (var6[var18 + var17 * var7] != 0) {
								Rasterizer2D_pixels[var14++] = var5;
							} else {
								Rasterizer2D_pixels[var14++] = var4;
							}
						}

						var14 += var11;
					}
				} else {
					var14 = var0 + var8 + (var9 + var1) * Rasterizer2D_width;

					for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
						for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
							var17 = (var15 - var1) % var10;
							var18 = (var16 - var0) % var7;
							int var19 = var4;
							if (var6[var18 + var17 * var7] != 0) {
								var19 = var5;
							}

							int var20 = var19 >>> 24;
							int var21 = 255 - var20;
							int var22 = Rasterizer2D_pixels[var14];
							int var23 = ((var19 & 16711935) * var20 + (var22 & 16711935) * var21 & -16711936) + (var20 * (var19 & 65280) + var21 * (var22 & 65280) & 16711680) >> 8;
							Rasterizer2D_pixels[var14++] = var23;
						}

						var14 += var11;
					}
				}

			}
		}
	}

	@ObfuscatedName("de")
	@Export("Rasterizer2D_drawRectangle")
	public static void Rasterizer2D_drawRectangle(int var0, int var1, int var2, int var3, int var4) {
		Rasterizer2D_drawHorizontalLine(var0, var1, var2, var4);
		Rasterizer2D_drawHorizontalLine(var0, var3 + var1 - 1, var2, var4);
		Rasterizer2D_drawVerticalLine(var0, var1, var3, var4);
		Rasterizer2D_drawVerticalLine(var0 + var2 - 1, var1, var3, var4);
	}

	@ObfuscatedName("du")
	@Export("Rasterizer2D_drawRectangleAlpha")
	public static void Rasterizer2D_drawRectangleAlpha(int var0, int var1, int var2, int var3, int var4, int var5) {
		Rasterizer2D_drawHorizontalLineAlpha(var0, var1, var2, var4, var5);
		Rasterizer2D_drawHorizontalLineAlpha(var0, var3 + var1 - 1, var2, var4, var5);
		if (var3 >= 3) {
			Rasterizer2D_drawVerticalLineAlpha(var0, var1 + 1, var3 - 2, var4, var5);
			Rasterizer2D_drawVerticalLineAlpha(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
		}

	}

	@ObfuscatedName("do")
	@Export("Rasterizer2D_drawHorizontalLine")
	public static void Rasterizer2D_drawHorizontalLine(int var0, int var1, int var2, int var3) {
		if (var1 >= Rasterizer2D_yClipStart && var1 < Rasterizer2D_yClipEnd) {
			if (var0 < Rasterizer2D_xClipStart) {
				var2 -= Rasterizer2D_xClipStart - var0;
				var0 = Rasterizer2D_xClipStart;
			}

			if (var0 + var2 > Rasterizer2D_xClipEnd) {
				var2 = Rasterizer2D_xClipEnd - var0;
			}

			int var4 = var0 + Rasterizer2D_width * var1;

			for (int var5 = 0; var5 < var2; ++var5) {
				Rasterizer2D_pixels[var4 + var5] = var3;
			}

		}
	}

	@ObfuscatedName("dc")
	@Export("Rasterizer2D_drawHorizontalLineAlpha")
	static void Rasterizer2D_drawHorizontalLineAlpha(int var0, int var1, int var2, int var3, int var4) {
		if (var1 >= Rasterizer2D_yClipStart && var1 < Rasterizer2D_yClipEnd) {
			if (var0 < Rasterizer2D_xClipStart) {
				var2 -= Rasterizer2D_xClipStart - var0;
				var0 = Rasterizer2D_xClipStart;
			}

			if (var0 + var2 > Rasterizer2D_xClipEnd) {
				var2 = Rasterizer2D_xClipEnd - var0;
			}

			int var5 = 256 - var4;
			int var6 = (var3 >> 16 & 255) * var4;
			int var7 = (var3 >> 8 & 255) * var4;
			int var8 = var4 * (var3 & 255);
			int var12 = var0 + Rasterizer2D_width * var1;

			for (int var13 = 0; var13 < var2; ++var13) {
				int var9 = var5 * (Rasterizer2D_pixels[var12] >> 16 & 255);
				int var10 = (Rasterizer2D_pixels[var12] >> 8 & 255) * var5;
				int var11 = var5 * (Rasterizer2D_pixels[var12] & 255);
				int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
				Rasterizer2D_pixels[var12++] = var14;
			}

		}
	}

	@ObfuscatedName("ds")
	@Export("Rasterizer2D_drawVerticalLine")
	public static void Rasterizer2D_drawVerticalLine(int var0, int var1, int var2, int var3) {
		if (var0 >= Rasterizer2D_xClipStart && var0 < Rasterizer2D_xClipEnd) {
			if (var1 < Rasterizer2D_yClipStart) {
				var2 -= Rasterizer2D_yClipStart - var1;
				var1 = Rasterizer2D_yClipStart;
			}

			if (var2 + var1 > Rasterizer2D_yClipEnd) {
				var2 = Rasterizer2D_yClipEnd - var1;
			}

			int var4 = var0 + Rasterizer2D_width * var1;

			for (int var5 = 0; var5 < var2; ++var5) {
				Rasterizer2D_pixels[var4 + var5 * Rasterizer2D_width] = var3;
			}

		}
	}

	@ObfuscatedName("dk")
	@Export("Rasterizer2D_drawVerticalLineAlpha")
	static void Rasterizer2D_drawVerticalLineAlpha(int var0, int var1, int var2, int var3, int var4) {
		if (var0 >= Rasterizer2D_xClipStart && var0 < Rasterizer2D_xClipEnd) {
			if (var1 < Rasterizer2D_yClipStart) {
				var2 -= Rasterizer2D_yClipStart - var1;
				var1 = Rasterizer2D_yClipStart;
			}

			if (var2 + var1 > Rasterizer2D_yClipEnd) {
				var2 = Rasterizer2D_yClipEnd - var1;
			}

			int var5 = 256 - var4;
			int var6 = (var3 >> 16 & 255) * var4;
			int var7 = (var3 >> 8 & 255) * var4;
			int var8 = var4 * (var3 & 255);
			int var12 = var0 + Rasterizer2D_width * var1;

			for (int var13 = 0; var13 < var2; ++var13) {
				int var9 = var5 * (Rasterizer2D_pixels[var12] >> 16 & 255);
				int var10 = (Rasterizer2D_pixels[var12] >> 8 & 255) * var5;
				int var11 = var5 * (Rasterizer2D_pixels[var12] & 255);
				int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
				Rasterizer2D_pixels[var12] = var14;
				var12 += Rasterizer2D_width;
			}

		}
	}

	@ObfuscatedName("dq")
	@Export("Rasterizer2D_drawLine")
	public static void Rasterizer2D_drawLine(int var0, int var1, int var2, int var3, int var4) {
		var2 -= var0;
		var3 -= var1;
		if (var3 == 0) {
			if (var2 >= 0) {
				Rasterizer2D_drawHorizontalLine(var0, var1, var2 + 1, var4);
			} else {
				Rasterizer2D_drawHorizontalLine(var0 + var2, var1, -var2 + 1, var4);
			}

		} else if (var2 == 0) {
			if (var3 >= 0) {
				Rasterizer2D_drawVerticalLine(var0, var1, var3 + 1, var4);
			} else {
				Rasterizer2D_drawVerticalLine(var0, var3 + var1, -var3 + 1, var4);
			}

		} else {
			if (var3 + var2 < 0) {
				var0 += var2;
				var2 = -var2;
				var1 += var3;
				var3 = -var3;
			}

			int var5;
			int var6;
			if (var2 > var3) {
				var1 <<= 16;
				var1 += 32768;
				var3 <<= 16;
				var5 = (int)Math.floor((double)var3 / (double)var2 + 0.5D);
				var2 += var0;
				if (var0 < Rasterizer2D_xClipStart) {
					var1 += var5 * (Rasterizer2D_xClipStart - var0);
					var0 = Rasterizer2D_xClipStart;
				}

				if (var2 >= Rasterizer2D_xClipEnd) {
					var2 = Rasterizer2D_xClipEnd - 1;
				}

				while (var0 <= var2) {
					var6 = var1 >> 16;
					if (var6 >= Rasterizer2D_yClipStart && var6 < Rasterizer2D_yClipEnd) {
						Rasterizer2D_pixels[var0 + var6 * Rasterizer2D_width] = var4;
					}

					var1 += var5;
					++var0;
				}
			} else {
				var0 <<= 16;
				var0 += 32768;
				var2 <<= 16;
				var5 = (int)Math.floor((double)var2 / (double)var3 + 0.5D);
				var3 += var1;
				if (var1 < Rasterizer2D_yClipStart) {
					var0 += (Rasterizer2D_yClipStart - var1) * var5;
					var1 = Rasterizer2D_yClipStart;
				}

				if (var3 >= Rasterizer2D_yClipEnd) {
					var3 = Rasterizer2D_yClipEnd - 1;
				}

				while (var1 <= var3) {
					var6 = var0 >> 16;
					if (var6 >= Rasterizer2D_xClipStart && var6 < Rasterizer2D_xClipEnd) {
						Rasterizer2D_pixels[var6 + Rasterizer2D_width * var1] = var4;
					}

					var0 += var5;
					++var1;
				}
			}

		}
	}

	@ObfuscatedName("db")
	@Export("Rasterizer2D_setPixel")
	static void Rasterizer2D_setPixel(int var0, int var1, int var2) {
		if (var0 >= Rasterizer2D_xClipStart && var1 >= Rasterizer2D_yClipStart && var0 < Rasterizer2D_xClipEnd && var1 < Rasterizer2D_yClipEnd) {
			Rasterizer2D_pixels[var0 + Rasterizer2D_width * var1] = var2;
		}
	}

	@ObfuscatedName("da")
	@Export("Rasterizer2D_fillMaskedRectangle")
	public static void Rasterizer2D_fillMaskedRectangle(int var0, int var1, int var2, int[] var3, int[] var4) {
		int var5 = var0 + Rasterizer2D_width * var1;

		for (var1 = 0; var1 < var3.length; ++var1) {
			int var6 = var5 + var3[var1];

			for (var0 = -var4[var1]; var0 < 0; ++var0) {
				Rasterizer2D_pixels[var6++] = var2;
			}

			var5 += Rasterizer2D_width;
		}

	}
}
