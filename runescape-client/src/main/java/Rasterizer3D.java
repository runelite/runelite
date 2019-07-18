import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("Rasterizer3D")
public class Rasterizer3D extends Rasterizer2D {
	@ObfuscatedName("q")
	static boolean field1763;
	@ObfuscatedName("w")
	static boolean field1772;
	@ObfuscatedName("e")
	@Export("Rasterizer3D_isLowDetailTexture")
	static boolean Rasterizer3D_isLowDetailTexture;
	@ObfuscatedName("p")
	public static boolean field1768;
	@ObfuscatedName("k")
	@Export("Rasterizer3D_alpha")
	static int Rasterizer3D_alpha;
	@ObfuscatedName("u")
	@Export("Rasterizer3D_zoom")
	public static int Rasterizer3D_zoom;
	@ObfuscatedName("x")
	@Export("Rasterizer3D_clipMidX")
	static int Rasterizer3D_clipMidX;
	@ObfuscatedName("r")
	@Export("Rasterizer3D_clipMidY")
	static int Rasterizer3D_clipMidY;
	@ObfuscatedName("v")
	@Export("Rasterizer3D_clipWidth")
	static int Rasterizer3D_clipWidth;
	@ObfuscatedName("y")
	@Export("Rasterizer3D_clipHeight")
	static int Rasterizer3D_clipHeight;
	@ObfuscatedName("g")
	@Export("Rasterizer3D_clipNegativeMidX")
	static int Rasterizer3D_clipNegativeMidX;
	@ObfuscatedName("a")
	@Export("Rasterizer3D_clipMidX2")
	static int Rasterizer3D_clipMidX2;
	@ObfuscatedName("j")
	@Export("Rasterizer3D_clipNegativeMidY")
	static int Rasterizer3D_clipNegativeMidY;
	@ObfuscatedName("t")
	@Export("Rasterizer3D_clipMidY2")
	static int Rasterizer3D_clipMidY2;
	@ObfuscatedName("h")
	@Export("Rasterizer3D_rowOffsets")
	static int[] Rasterizer3D_rowOffsets;
	@ObfuscatedName("o")
	@Export("Rasterizer3D_colorPalette")
	public static int[] Rasterizer3D_colorPalette;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("Rasterizer3D_textureLoader")
	public static TextureLoader Rasterizer3D_textureLoader;
	@ObfuscatedName("d")
	static int[] field1785;
	@ObfuscatedName("s")
	static int[] field1786;
	@ObfuscatedName("z")
	@Export("Rasterizer3D_sine")
	public static int[] Rasterizer3D_sine;
	@ObfuscatedName("al")
	@Export("Rasterizer3D_cosine")
	public static int[] Rasterizer3D_cosine;

	static {
		field1763 = false;
		field1772 = false;
		Rasterizer3D_isLowDetailTexture = false;
		field1768 = true;
		Rasterizer3D_alpha = 0;
		Rasterizer3D_zoom = 512;
		Rasterizer3D_rowOffsets = new int[1024];
		Rasterizer3D_colorPalette = new int[65536];
		field1785 = new int[512];
		field1786 = new int[2048];
		Rasterizer3D_sine = new int[2048];
		Rasterizer3D_cosine = new int[2048];

		int var0;
		for (var0 = 1; var0 < 512; ++var0) {
			field1785[var0] = 32768 / var0;
		}

		for (var0 = 1; var0 < 2048; ++var0) {
			field1786[var0] = 65536 / var0;
		}

		for (var0 = 0; var0 < 2048; ++var0) {
			Rasterizer3D_sine[var0] = (int)(65536.0D * Math.sin((double)var0 * 0.0030679615D));
			Rasterizer3D_cosine[var0] = (int)(65536.0D * Math.cos((double)var0 * 0.0030679615D));
		}

	}

	@ObfuscatedName("q")
	@Export("Rasterizer3D_setClipFromRasterizer2D")
	public static final void Rasterizer3D_setClipFromRasterizer2D() {
		Rasterizer3D_setClip(Rasterizer2D.Rasterizer2D_xClipStart, Rasterizer2D.Rasterizer2D_yClipStart, Rasterizer2D.Rasterizer2D_xClipEnd, Rasterizer2D.Rasterizer2D_yClipEnd);
	}

	@ObfuscatedName("w")
	@Export("Rasterizer3D_setClip")
	static final void Rasterizer3D_setClip(int var0, int var1, int var2, int var3) {
		Rasterizer3D_clipWidth = var2 - var0;
		Rasterizer3D_clipHeight = var3 - var1;
		Rasterizer3D_method3();
		int var4;
		int var5;
		if (Rasterizer3D_rowOffsets.length < Rasterizer3D_clipHeight) {
			var5 = Rasterizer3D_clipHeight;
			--var5;
			var5 |= var5 >>> 1;
			var5 |= var5 >>> 2;
			var5 |= var5 >>> 4;
			var5 |= var5 >>> 8;
			var5 |= var5 >>> 16;
			var4 = var5 + 1;
			Rasterizer3D_rowOffsets = new int[var4];
		}

		var4 = var0 + Rasterizer2D.Rasterizer2D_width * var1;

		for (var5 = 0; var5 < Rasterizer3D_clipHeight; ++var5) {
			Rasterizer3D_rowOffsets[var5] = var4;
			var4 += Rasterizer2D.Rasterizer2D_width;
		}

	}

	@ObfuscatedName("e")
	@Export("Rasterizer3D_method3")
	public static final void Rasterizer3D_method3() {
		Rasterizer3D_clipMidX = Rasterizer3D_clipWidth / 2;
		Rasterizer3D_clipMidY = Rasterizer3D_clipHeight / 2;
		Rasterizer3D_clipNegativeMidX = -Rasterizer3D_clipMidX;
		Rasterizer3D_clipMidX2 = Rasterizer3D_clipWidth - Rasterizer3D_clipMidX;
		Rasterizer3D_clipNegativeMidY = -Rasterizer3D_clipMidY;
		Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - Rasterizer3D_clipMidY;
	}

	@ObfuscatedName("p")
	public static final void method2976(int var0, int var1) {
		int var2 = Rasterizer3D_rowOffsets[0];
		int var3 = var2 / Rasterizer2D.Rasterizer2D_width;
		int var4 = var2 - var3 * Rasterizer2D.Rasterizer2D_width;
		Rasterizer3D_clipMidX = var0 - var4;
		Rasterizer3D_clipMidY = var1 - var3;
		Rasterizer3D_clipNegativeMidX = -Rasterizer3D_clipMidX;
		Rasterizer3D_clipMidX2 = Rasterizer3D_clipWidth - Rasterizer3D_clipMidX;
		Rasterizer3D_clipNegativeMidY = -Rasterizer3D_clipMidY;
		Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - Rasterizer3D_clipMidY;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lef;)V"
	)
	@Export("Rasterizer3D_setTextureLoader")
	public static final void Rasterizer3D_setTextureLoader(TextureLoader var0) {
		Rasterizer3D_textureLoader = var0;
	}

	@ObfuscatedName("l")
	@Export("Rasterizer3D_setBrightness")
	public static final void Rasterizer3D_setBrightness(double var0) {
		Rasterizer3D_buildPalette(var0, 0, 512);
	}

	@ObfuscatedName("b")
	@Export("Rasterizer3D_buildPalette")
	static final void Rasterizer3D_buildPalette(double var0, int var2, int var3) {
		int var4 = var2 * 128;

		for (int var5 = var2; var5 < var3; ++var5) {
			double var6 = (double)(var5 >> 3) / 64.0D + 0.0078125D;
			double var8 = (double)(var5 & 7) / 8.0D + 0.0625D;

			for (int var10 = 0; var10 < 128; ++var10) {
				double var11 = (double)var10 / 128.0D;
				double var13 = var11;
				double var15 = var11;
				double var17 = var11;
				if (var8 != 0.0D) {
					double var19;
					if (var11 < 0.5D) {
						var19 = var11 * (1.0D + var8);
					} else {
						var19 = var11 + var8 - var11 * var8;
					}

					double var21 = 2.0D * var11 - var19;
					double var23 = var6 + 0.3333333333333333D;
					if (var23 > 1.0D) {
						--var23;
					}

					double var27 = var6 - 0.3333333333333333D;
					if (var27 < 0.0D) {
						++var27;
					}

					if (6.0D * var23 < 1.0D) {
						var13 = var21 + (var19 - var21) * 6.0D * var23;
					} else if (2.0D * var23 < 1.0D) {
						var13 = var19;
					} else if (3.0D * var23 < 2.0D) {
						var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
					} else {
						var13 = var21;
					}

					if (6.0D * var6 < 1.0D) {
						var15 = var21 + (var19 - var21) * 6.0D * var6;
					} else if (2.0D * var6 < 1.0D) {
						var15 = var19;
					} else if (3.0D * var6 < 2.0D) {
						var15 = var21 + (var19 - var21) * (0.6666666666666666D - var6) * 6.0D;
					} else {
						var15 = var21;
					}

					if (6.0D * var27 < 1.0D) {
						var17 = var21 + (var19 - var21) * 6.0D * var27;
					} else if (2.0D * var27 < 1.0D) {
						var17 = var19;
					} else if (3.0D * var27 < 2.0D) {
						var17 = var21 + (var19 - var21) * (0.6666666666666666D - var27) * 6.0D;
					} else {
						var17 = var21;
					}
				}

				int var29 = (int)(var13 * 256.0D);
				int var20 = (int)(var15 * 256.0D);
				int var30 = (int)(var17 * 256.0D);
				int var22 = var30 + (var20 << 8) + (var29 << 16);
				var22 = Rasterizer3D_brighten(var22, var0);
				if (var22 == 0) {
					var22 = 1;
				}

				Rasterizer3D_colorPalette[var4++] = var22;
			}
		}

	}

	@ObfuscatedName("i")
	@Export("Rasterizer3D_brighten")
	static int Rasterizer3D_brighten(int var0, double var1) {
		double var3 = (double)(var0 >> 16) / 256.0D;
		double var5 = (double)(var0 >> 8 & 255) / 256.0D;
		double var7 = (double)(var0 & 255) / 256.0D;
		var3 = Math.pow(var3, var1);
		var5 = Math.pow(var5, var1);
		var7 = Math.pow(var7, var1);
		int var9 = (int)(var3 * 256.0D);
		int var10 = (int)(var5 * 256.0D);
		int var11 = (int)(var7 * 256.0D);
		return var11 + (var10 << 8) + (var9 << 16);
	}

	@ObfuscatedName("c")
	public static void method2981(int var0, int var1, int var2) {
		field1763 = var0 < 0 || var0 > Rasterizer3D_clipWidth || var1 < 0 || var1 > Rasterizer3D_clipWidth || var2 < 0 || var2 > Rasterizer3D_clipWidth;
	}

	@ObfuscatedName("u")
	static final void method3020(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int var9 = var4 - var3;
		int var10 = var1 - var0;
		int var11 = var5 - var3;
		int var12 = var2 - var0;
		int var13 = var7 - var6;
		int var14 = var8 - var6;
		int var15;
		if (var2 != var1) {
			var15 = (var5 - var4 << 14) / (var2 - var1);
		} else {
			var15 = 0;
		}

		int var16;
		if (var0 != var1) {
			var16 = (var9 << 14) / var10;
		} else {
			var16 = 0;
		}

		int var17;
		if (var0 != var2) {
			var17 = (var11 << 14) / var12;
		} else {
			var17 = 0;
		}

		int var18 = var9 * var12 - var11 * var10;
		if (var18 != 0) {
			int var19 = (var13 * var12 - var14 * var10 << 8) / var18;
			int var20 = (var14 * var9 - var13 * var11 << 8) / var18;
			if (var0 <= var1 && var0 <= var2) {
				if (var0 < Rasterizer3D_clipHeight) {
					if (var1 > Rasterizer3D_clipHeight) {
						var1 = Rasterizer3D_clipHeight;
					}

					if (var2 > Rasterizer3D_clipHeight) {
						var2 = Rasterizer3D_clipHeight;
					}

					var6 = var19 + ((var6 << 8) - var3 * var19);
					if (var1 < var2) {
						var5 = var3 <<= 14;
						if (var0 < 0) {
							var5 -= var0 * var17;
							var3 -= var0 * var16;
							var6 -= var0 * var20;
							var0 = 0;
						}

						var4 <<= 14;
						if (var1 < 0) {
							var4 -= var15 * var1;
							var1 = 0;
						}

						if ((var0 == var1 || var17 >= var16) && (var0 != var1 || var17 <= var15)) {
							var2 -= var1;
							var1 -= var0;
							var0 = Rasterizer3D_rowOffsets[var0];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var4 >> 14, var5 >> 14, var6, var19);
										var5 += var17;
										var4 += var15;
										var6 += var20;
										var0 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
								var5 += var17;
								var3 += var16;
								var6 += var20;
								var0 += Rasterizer2D.Rasterizer2D_width;
							}
						} else {
							var2 -= var1;
							var1 -= var0;
							var0 = Rasterizer3D_rowOffsets[var0];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var5 >> 14, var4 >> 14, var6, var19);
										var5 += var17;
										var4 += var15;
										var6 += var20;
										var0 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
								var5 += var17;
								var3 += var16;
								var6 += var20;
								var0 += Rasterizer2D.Rasterizer2D_width;
							}
						}
					} else {
						var4 = var3 <<= 14;
						if (var0 < 0) {
							var4 -= var0 * var17;
							var3 -= var0 * var16;
							var6 -= var0 * var20;
							var0 = 0;
						}

						var5 <<= 14;
						if (var2 < 0) {
							var5 -= var15 * var2;
							var2 = 0;
						}

						if (var0 != var2 && var17 < var16 || var0 == var2 && var15 > var16) {
							var1 -= var2;
							var2 -= var0;
							var0 = Rasterizer3D_rowOffsets[var0];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
										var5 += var15;
										var3 += var16;
										var6 += var20;
										var0 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var4 >> 14, var3 >> 14, var6, var19);
								var4 += var17;
								var3 += var16;
								var6 += var20;
								var0 += Rasterizer2D.Rasterizer2D_width;
							}
						} else {
							var1 -= var2;
							var2 -= var0;
							var0 = Rasterizer3D_rowOffsets[var0];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
										var5 += var15;
										var3 += var16;
										var6 += var20;
										var0 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, 0, 0, var3 >> 14, var4 >> 14, var6, var19);
								var4 += var17;
								var3 += var16;
								var6 += var20;
								var0 += Rasterizer2D.Rasterizer2D_width;
							}
						}
					}
				}
			} else if (var1 <= var2) {
				if (var1 < Rasterizer3D_clipHeight) {
					if (var2 > Rasterizer3D_clipHeight) {
						var2 = Rasterizer3D_clipHeight;
					}

					if (var0 > Rasterizer3D_clipHeight) {
						var0 = Rasterizer3D_clipHeight;
					}

					var7 = var19 + ((var7 << 8) - var19 * var4);
					if (var2 < var0) {
						var3 = var4 <<= 14;
						if (var1 < 0) {
							var3 -= var16 * var1;
							var4 -= var15 * var1;
							var7 -= var20 * var1;
							var1 = 0;
						}

						var5 <<= 14;
						if (var2 < 0) {
							var5 -= var17 * var2;
							var2 = 0;
						}

						if ((var2 == var1 || var16 >= var15) && (var2 != var1 || var16 <= var17)) {
							var0 -= var2;
							var2 -= var1;
							var1 = Rasterizer3D_rowOffsets[var1];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var5 >> 14, var3 >> 14, var7, var19);
										var3 += var16;
										var5 += var17;
										var7 += var20;
										var1 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
								var3 += var16;
								var4 += var15;
								var7 += var20;
								var1 += Rasterizer2D.Rasterizer2D_width;
							}
						} else {
							var0 -= var2;
							var2 -= var1;
							var1 = Rasterizer3D_rowOffsets[var1];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var3 >> 14, var5 >> 14, var7, var19);
										var3 += var16;
										var5 += var17;
										var7 += var20;
										var1 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
								var3 += var16;
								var4 += var15;
								var7 += var20;
								var1 += Rasterizer2D.Rasterizer2D_width;
							}
						}
					} else {
						var5 = var4 <<= 14;
						if (var1 < 0) {
							var5 -= var16 * var1;
							var4 -= var15 * var1;
							var7 -= var20 * var1;
							var1 = 0;
						}

						var3 <<= 14;
						if (var0 < 0) {
							var3 -= var0 * var17;
							var0 = 0;
						}

						if (var16 < var15) {
							var2 -= var0;
							var0 -= var1;
							var1 = Rasterizer3D_rowOffsets[var1];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
										var3 += var17;
										var4 += var15;
										var7 += var20;
										var1 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var5 >> 14, var4 >> 14, var7, var19);
								var5 += var16;
								var4 += var15;
								var7 += var20;
								var1 += Rasterizer2D.Rasterizer2D_width;
							}
						} else {
							var2 -= var0;
							var0 -= var1;
							var1 = Rasterizer3D_rowOffsets[var1];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
										var3 += var17;
										var4 += var15;
										var7 += var20;
										var1 += Rasterizer2D.Rasterizer2D_width;
									}
								}

								Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, 0, 0, var4 >> 14, var5 >> 14, var7, var19);
								var5 += var16;
								var4 += var15;
								var7 += var20;
								var1 += Rasterizer2D.Rasterizer2D_width;
							}
						}
					}
				}
			} else if (var2 < Rasterizer3D_clipHeight) {
				if (var0 > Rasterizer3D_clipHeight) {
					var0 = Rasterizer3D_clipHeight;
				}

				if (var1 > Rasterizer3D_clipHeight) {
					var1 = Rasterizer3D_clipHeight;
				}

				var8 = var19 + ((var8 << 8) - var5 * var19);
				if (var0 < var1) {
					var4 = var5 <<= 14;
					if (var2 < 0) {
						var4 -= var15 * var2;
						var5 -= var17 * var2;
						var8 -= var20 * var2;
						var2 = 0;
					}

					var3 <<= 14;
					if (var0 < 0) {
						var3 -= var0 * var16;
						var0 = 0;
					}

					if (var15 < var17) {
						var1 -= var0;
						var0 -= var2;
						var2 = Rasterizer3D_rowOffsets[var2];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var4 >> 14, var3 >> 14, var8, var19);
									var4 += var15;
									var3 += var16;
									var8 += var20;
									var2 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
							var4 += var15;
							var5 += var17;
							var8 += var20;
							var2 += Rasterizer2D.Rasterizer2D_width;
						}
					} else {
						var1 -= var0;
						var0 -= var2;
						var2 = Rasterizer3D_rowOffsets[var2];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var3 >> 14, var4 >> 14, var8, var19);
									var4 += var15;
									var3 += var16;
									var8 += var20;
									var2 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
							var4 += var15;
							var5 += var17;
							var8 += var20;
							var2 += Rasterizer2D.Rasterizer2D_width;
						}
					}
				} else {
					var3 = var5 <<= 14;
					if (var2 < 0) {
						var3 -= var15 * var2;
						var5 -= var17 * var2;
						var8 -= var20 * var2;
						var2 = 0;
					}

					var4 <<= 14;
					if (var1 < 0) {
						var4 -= var16 * var1;
						var1 = 0;
					}

					if (var15 < var17) {
						var0 -= var1;
						var1 -= var2;
						var2 = Rasterizer3D_rowOffsets[var2];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
									var4 += var16;
									var5 += var17;
									var8 += var20;
									var2 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var3 >> 14, var5 >> 14, var8, var19);
							var3 += var15;
							var5 += var17;
							var8 += var20;
							var2 += Rasterizer2D.Rasterizer2D_width;
						}
					} else {
						var0 -= var1;
						var1 -= var2;
						var2 = Rasterizer3D_rowOffsets[var2];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
									var4 += var16;
									var5 += var17;
									var8 += var20;
									var2 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_vertAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, 0, 0, var5 >> 14, var3 >> 14, var8, var19);
							var3 += var15;
							var5 += var17;
							var8 += var20;
							var2 += Rasterizer2D.Rasterizer2D_width;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("x")
	@Export("Rasterizer3D_vertAlpha")
	static final void Rasterizer3D_vertAlpha(int[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (field1763) {
			if (var5 > Rasterizer3D_clipWidth) {
				var5 = Rasterizer3D_clipWidth;
			}

			if (var4 < 0) {
				var4 = 0;
			}
		}

		if (var4 < var5) {
			var1 += var4;
			var6 += var4 * var7;
			int var8;
			int var9;
			int var10;
			if (field1768) {
				var3 = var5 - var4 >> 2;
				var7 <<= 2;
				if (Rasterizer3D_alpha == 0) {
					if (var3 > 0) {
						do {
							var2 = Rasterizer3D_colorPalette[var6 >> 8];
							var6 += var7;
							var0[var1++] = var2;
							var0[var1++] = var2;
							var0[var1++] = var2;
							var0[var1++] = var2;
							--var3;
						} while(var3 > 0);
					}

					var3 = var5 - var4 & 3;
					if (var3 > 0) {
						var2 = Rasterizer3D_colorPalette[var6 >> 8];

						do {
							var0[var1++] = var2;
							--var3;
						} while(var3 > 0);
					}
				} else {
					var8 = Rasterizer3D_alpha;
					var9 = 256 - Rasterizer3D_alpha;
					if (var3 > 0) {
						do {
							var2 = Rasterizer3D_colorPalette[var6 >> 8];
							var6 += var7;
							var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);
							var10 = var0[var1];
							var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
							var10 = var0[var1];
							var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
							var10 = var0[var1];
							var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
							var10 = var0[var1];
							var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
							--var3;
						} while(var3 > 0);
					}

					var3 = var5 - var4 & 3;
					if (var3 > 0) {
						var2 = Rasterizer3D_colorPalette[var6 >> 8];
						var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);

						do {
							var10 = var0[var1];
							var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
							--var3;
						} while(var3 > 0);
					}
				}

			} else {
				var3 = var5 - var4;
				if (Rasterizer3D_alpha == 0) {
					do {
						var0[var1++] = Rasterizer3D_colorPalette[var6 >> 8];
						var6 += var7;
						--var3;
					} while(var3 > 0);
				} else {
					var8 = Rasterizer3D_alpha;
					var9 = 256 - Rasterizer3D_alpha;

					do {
						var2 = Rasterizer3D_colorPalette[var6 >> 8];
						var6 += var7;
						var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);
						var10 = var0[var1];
						var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
						--var3;
					} while(var3 > 0);
				}

			}
		}
	}

	@ObfuscatedName("r")
	public static final void method3007(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = 0;
		if (var0 != var1) {
			var7 = (var4 - var3 << 14) / (var1 - var0);
		}

		int var8 = 0;
		if (var2 != var1) {
			var8 = (var5 - var4 << 14) / (var2 - var1);
		}

		int var9 = 0;
		if (var0 != var2) {
			var9 = (var3 - var5 << 14) / (var0 - var2);
		}

		if (var0 <= var1 && var0 <= var2) {
			if (var0 < Rasterizer3D_clipHeight) {
				if (var1 > Rasterizer3D_clipHeight) {
					var1 = Rasterizer3D_clipHeight;
				}

				if (var2 > Rasterizer3D_clipHeight) {
					var2 = Rasterizer3D_clipHeight;
				}

				if (var1 < var2) {
					var5 = var3 <<= 14;
					if (var0 < 0) {
						var5 -= var0 * var9;
						var3 -= var0 * var7;
						var0 = 0;
					}

					var4 <<= 14;
					if (var1 < 0) {
						var4 -= var8 * var1;
						var1 = 0;
					}

					if (var0 != var1 && var9 < var7 || var0 == var1 && var9 > var8) {
						var2 -= var1;
						var1 -= var0;
						var0 = Rasterizer3D_rowOffsets[var0];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var5 >> 14, var4 >> 14);
									var5 += var9;
									var4 += var8;
									var0 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var5 >> 14, var3 >> 14);
							var5 += var9;
							var3 += var7;
							var0 += Rasterizer2D.Rasterizer2D_width;
						}
					} else {
						var2 -= var1;
						var1 -= var0;
						var0 = Rasterizer3D_rowOffsets[var0];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var4 >> 14, var5 >> 14);
									var5 += var9;
									var4 += var8;
									var0 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var3 >> 14, var5 >> 14);
							var5 += var9;
							var3 += var7;
							var0 += Rasterizer2D.Rasterizer2D_width;
						}
					}
				} else {
					var4 = var3 <<= 14;
					if (var0 < 0) {
						var4 -= var0 * var9;
						var3 -= var0 * var7;
						var0 = 0;
					}

					var5 <<= 14;
					if (var2 < 0) {
						var5 -= var8 * var2;
						var2 = 0;
					}

					if ((var0 == var2 || var9 >= var7) && (var0 != var2 || var8 <= var7)) {
						var1 -= var2;
						var2 -= var0;
						var0 = Rasterizer3D_rowOffsets[var0];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var3 >> 14, var5 >> 14);
									var5 += var8;
									var3 += var7;
									var0 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var3 >> 14, var4 >> 14);
							var4 += var9;
							var3 += var7;
							var0 += Rasterizer2D.Rasterizer2D_width;
						}
					} else {
						var1 -= var2;
						var2 -= var0;
						var0 = Rasterizer3D_rowOffsets[var0];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var5 >> 14, var3 >> 14);
									var5 += var8;
									var3 += var7;
									var0 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var0, var6, 0, var4 >> 14, var3 >> 14);
							var4 += var9;
							var3 += var7;
							var0 += Rasterizer2D.Rasterizer2D_width;
						}
					}
				}
			}
		} else if (var1 <= var2) {
			if (var1 < Rasterizer3D_clipHeight) {
				if (var2 > Rasterizer3D_clipHeight) {
					var2 = Rasterizer3D_clipHeight;
				}

				if (var0 > Rasterizer3D_clipHeight) {
					var0 = Rasterizer3D_clipHeight;
				}

				if (var2 < var0) {
					var3 = var4 <<= 14;
					if (var1 < 0) {
						var3 -= var7 * var1;
						var4 -= var8 * var1;
						var1 = 0;
					}

					var5 <<= 14;
					if (var2 < 0) {
						var5 -= var9 * var2;
						var2 = 0;
					}

					if (var2 != var1 && var7 < var8 || var2 == var1 && var7 > var9) {
						var0 -= var2;
						var2 -= var1;
						var1 = Rasterizer3D_rowOffsets[var1];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var3 >> 14, var5 >> 14);
									var3 += var7;
									var5 += var9;
									var1 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var3 >> 14, var4 >> 14);
							var3 += var7;
							var4 += var8;
							var1 += Rasterizer2D.Rasterizer2D_width;
						}
					} else {
						var0 -= var2;
						var2 -= var1;
						var1 = Rasterizer3D_rowOffsets[var1];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var5 >> 14, var3 >> 14);
									var3 += var7;
									var5 += var9;
									var1 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var4 >> 14, var3 >> 14);
							var3 += var7;
							var4 += var8;
							var1 += Rasterizer2D.Rasterizer2D_width;
						}
					}
				} else {
					var5 = var4 <<= 14;
					if (var1 < 0) {
						var5 -= var7 * var1;
						var4 -= var8 * var1;
						var1 = 0;
					}

					var3 <<= 14;
					if (var0 < 0) {
						var3 -= var0 * var9;
						var0 = 0;
					}

					if (var7 < var8) {
						var2 -= var0;
						var0 -= var1;
						var1 = Rasterizer3D_rowOffsets[var1];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var3 >> 14, var4 >> 14);
									var3 += var9;
									var4 += var8;
									var1 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var5 >> 14, var4 >> 14);
							var5 += var7;
							var4 += var8;
							var1 += Rasterizer2D.Rasterizer2D_width;
						}
					} else {
						var2 -= var0;
						var0 -= var1;
						var1 = Rasterizer3D_rowOffsets[var1];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var4 >> 14, var3 >> 14);
									var3 += var9;
									var4 += var8;
									var1 += Rasterizer2D.Rasterizer2D_width;
								}
							}

							Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var1, var6, 0, var4 >> 14, var5 >> 14);
							var5 += var7;
							var4 += var8;
							var1 += Rasterizer2D.Rasterizer2D_width;
						}
					}
				}
			}
		} else if (var2 < Rasterizer3D_clipHeight) {
			if (var0 > Rasterizer3D_clipHeight) {
				var0 = Rasterizer3D_clipHeight;
			}

			if (var1 > Rasterizer3D_clipHeight) {
				var1 = Rasterizer3D_clipHeight;
			}

			if (var0 < var1) {
				var4 = var5 <<= 14;
				if (var2 < 0) {
					var4 -= var8 * var2;
					var5 -= var9 * var2;
					var2 = 0;
				}

				var3 <<= 14;
				if (var0 < 0) {
					var3 -= var0 * var7;
					var0 = 0;
				}

				if (var8 < var9) {
					var1 -= var0;
					var0 -= var2;
					var2 = Rasterizer3D_rowOffsets[var2];

					while (true) {
						--var0;
						if (var0 < 0) {
							while (true) {
								--var1;
								if (var1 < 0) {
									return;
								}

								Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var4 >> 14, var3 >> 14);
								var4 += var8;
								var3 += var7;
								var2 += Rasterizer2D.Rasterizer2D_width;
							}
						}

						Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var4 >> 14, var5 >> 14);
						var4 += var8;
						var5 += var9;
						var2 += Rasterizer2D.Rasterizer2D_width;
					}
				} else {
					var1 -= var0;
					var0 -= var2;
					var2 = Rasterizer3D_rowOffsets[var2];

					while (true) {
						--var0;
						if (var0 < 0) {
							while (true) {
								--var1;
								if (var1 < 0) {
									return;
								}

								Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var3 >> 14, var4 >> 14);
								var4 += var8;
								var3 += var7;
								var2 += Rasterizer2D.Rasterizer2D_width;
							}
						}

						Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var5 >> 14, var4 >> 14);
						var4 += var8;
						var5 += var9;
						var2 += Rasterizer2D.Rasterizer2D_width;
					}
				}
			} else {
				var3 = var5 <<= 14;
				if (var2 < 0) {
					var3 -= var8 * var2;
					var5 -= var9 * var2;
					var2 = 0;
				}

				var4 <<= 14;
				if (var1 < 0) {
					var4 -= var7 * var1;
					var1 = 0;
				}

				if (var8 < var9) {
					var0 -= var1;
					var1 -= var2;
					var2 = Rasterizer3D_rowOffsets[var2];

					while (true) {
						--var1;
						if (var1 < 0) {
							while (true) {
								--var0;
								if (var0 < 0) {
									return;
								}

								Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var4 >> 14, var5 >> 14);
								var4 += var7;
								var5 += var9;
								var2 += Rasterizer2D.Rasterizer2D_width;
							}
						}

						Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var3 >> 14, var5 >> 14);
						var3 += var8;
						var5 += var9;
						var2 += Rasterizer2D.Rasterizer2D_width;
					}
				} else {
					var0 -= var1;
					var1 -= var2;
					var2 = Rasterizer3D_rowOffsets[var2];

					while (true) {
						--var1;
						if (var1 < 0) {
							while (true) {
								--var0;
								if (var0 < 0) {
									return;
								}

								Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var5 >> 14, var4 >> 14);
								var4 += var7;
								var5 += var9;
								var2 += Rasterizer2D.Rasterizer2D_width;
							}
						}

						Rasterizer3D_horizAlpha(Rasterizer2D.Rasterizer2D_pixels, var2, var6, 0, var5 >> 14, var3 >> 14);
						var3 += var8;
						var5 += var9;
						var2 += Rasterizer2D.Rasterizer2D_width;
					}
				}
			}
		}
	}

	@ObfuscatedName("v")
	@Export("Rasterizer3D_horizAlpha")
	static final void Rasterizer3D_horizAlpha(int[] var0, int var1, int var2, int var3, int var4, int var5) {
		if (field1763) {
			if (var5 > Rasterizer3D_clipWidth) {
				var5 = Rasterizer3D_clipWidth;
			}

			if (var4 < 0) {
				var4 = 0;
			}
		}

		if (var4 < var5) {
			var1 += var4;
			var3 = var5 - var4 >> 2;
			if (Rasterizer3D_alpha != 0) {
				if (Rasterizer3D_alpha == 254) {
					while (true) {
						--var3;
						if (var3 < 0) {
							var3 = var5 - var4 & 3;

							while (true) {
								--var3;
								if (var3 < 0) {
									return;
								}

								var0[var1++] = var0[var1];
							}
						}

						var0[var1++] = var0[var1];
						var0[var1++] = var0[var1];
						var0[var1++] = var0[var1];
						var0[var1++] = var0[var1];
					}
				} else {
					int var6 = Rasterizer3D_alpha;
					int var7 = 256 - Rasterizer3D_alpha;
					var2 = (var7 * (var2 & 65280) >> 8 & 65280) + (var7 * (var2 & 16711935) >> 8 & 16711935);

					while (true) {
						--var3;
						int var8;
						if (var3 < 0) {
							var3 = var5 - var4 & 3;

							while (true) {
								--var3;
								if (var3 < 0) {
									return;
								}

								var8 = var0[var1];
								var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
							}
						}

						var8 = var0[var1];
						var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
						var8 = var0[var1];
						var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
						var8 = var0[var1];
						var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
						var8 = var0[var1];
						var0[var1++] = ((var8 & 16711935) * var6 >> 8 & 16711935) + var2 + (var6 * (var8 & 65280) >> 8 & 65280);
					}
				}
			} else {
				while (true) {
					--var3;
					if (var3 < 0) {
						var3 = var5 - var4 & 3;

						while (true) {
							--var3;
							if (var3 < 0) {
								return;
							}

							var0[var1++] = var2;
						}
					}

					var0[var1++] = var2;
					var0[var1++] = var2;
					var0[var1++] = var2;
					var0[var1++] = var2;
				}
			}
		}
	}

	@ObfuscatedName("y")
	static final void method2986(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
		int[] var19 = Rasterizer3D_textureLoader.load(var18);
		int var20;
		if (var19 == null) {
			var20 = Rasterizer3D_textureLoader.getAverageTextureRGB(var18);
			method3020(var0, var1, var2, var3, var4, var5, method3045(var20, var6), method3045(var20, var7), method3045(var20, var8));
		} else {
			Rasterizer3D_isLowDetailTexture = Rasterizer3D_textureLoader.isLowDetail(var18);
			field1772 = Rasterizer3D_textureLoader.vmethod3278(var18);
			var20 = var4 - var3;
			int var21 = var1 - var0;
			int var22 = var5 - var3;
			int var23 = var2 - var0;
			int var24 = var7 - var6;
			int var25 = var8 - var6;
			int var26 = 0;
			if (var0 != var1) {
				var26 = (var4 - var3 << 14) / (var1 - var0);
			}

			int var27 = 0;
			if (var2 != var1) {
				var27 = (var5 - var4 << 14) / (var2 - var1);
			}

			int var28 = 0;
			if (var0 != var2) {
				var28 = (var3 - var5 << 14) / (var0 - var2);
			}

			int var29 = var20 * var23 - var22 * var21;
			if (var29 != 0) {
				int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
				int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
				var10 = var9 - var10;
				var13 = var12 - var13;
				var16 = var15 - var16;
				var11 -= var9;
				var14 -= var12;
				var17 -= var15;
				int var32 = var11 * var12 - var9 * var14 << 14;
				int var33 = (int)(((long)(var15 * var14 - var17 * var12) << 3 << 14) / (long)Rasterizer3D_zoom);
				int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)Rasterizer3D_zoom);
				int var35 = var10 * var12 - var13 * var9 << 14;
				int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 3 << 14) / (long)Rasterizer3D_zoom);
				int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)Rasterizer3D_zoom);
				int var38 = var13 * var11 - var10 * var14 << 14;
				int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 3 << 14) / (long)Rasterizer3D_zoom);
				int var40 = (int)(((long)(var17 * var10 - var11 * var16) << 14) / (long)Rasterizer3D_zoom);
				int var41;
				if (var0 <= var1 && var0 <= var2) {
					if (var0 < Rasterizer3D_clipHeight) {
						if (var1 > Rasterizer3D_clipHeight) {
							var1 = Rasterizer3D_clipHeight;
						}

						if (var2 > Rasterizer3D_clipHeight) {
							var2 = Rasterizer3D_clipHeight;
						}

						var6 = var30 + ((var6 << 9) - var3 * var30);
						if (var1 < var2) {
							var5 = var3 <<= 14;
							if (var0 < 0) {
								var5 -= var0 * var28;
								var3 -= var0 * var26;
								var6 -= var0 * var31;
								var0 = 0;
							}

							var4 <<= 14;
							if (var1 < 0) {
								var4 -= var27 * var1;
								var1 = 0;
							}

							var41 = var0 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
								var2 -= var1;
								var1 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var1;
								var1 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var4 = var3 <<= 14;
							if (var0 < 0) {
								var4 -= var0 * var28;
								var3 -= var0 * var26;
								var6 -= var0 * var31;
								var0 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var27 * var2;
								var2 = 0;
							}

							var41 = var0 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var0 != var2 && var28 < var26 || var0 == var2 && var27 > var26) {
								var1 -= var2;
								var2 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var1 -= var2;
								var2 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var1 <= var2) {
					if (var1 < Rasterizer3D_clipHeight) {
						if (var2 > Rasterizer3D_clipHeight) {
							var2 = Rasterizer3D_clipHeight;
						}

						if (var0 > Rasterizer3D_clipHeight) {
							var0 = Rasterizer3D_clipHeight;
						}

						var7 = var30 + ((var7 << 9) - var30 * var4);
						if (var2 < var0) {
							var3 = var4 <<= 14;
							if (var1 < 0) {
								var3 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var28 * var2;
								var2 = 0;
							}

							var41 = var1 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var2 != var1 && var26 < var27 || var2 == var1 && var26 > var28) {
								var0 -= var2;
								var2 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var0 -= var2;
								var2 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var5 = var4 <<= 14;
							if (var1 < 0) {
								var5 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var3 <<= 14;
							if (var0 < 0) {
								var3 -= var0 * var28;
								var0 = 0;
							}

							var41 = var1 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var26 < var27) {
								var2 -= var0;
								var0 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var0;
								var0 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var2 < Rasterizer3D_clipHeight) {
					if (var0 > Rasterizer3D_clipHeight) {
						var0 = Rasterizer3D_clipHeight;
					}

					if (var1 > Rasterizer3D_clipHeight) {
						var1 = Rasterizer3D_clipHeight;
					}

					var8 = (var8 << 9) - var5 * var30 + var30;
					if (var0 < var1) {
						var4 = var5 <<= 14;
						if (var2 < 0) {
							var4 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var3 <<= 14;
						if (var0 < 0) {
							var3 -= var0 * var26;
							var0 = 0;
						}

						var41 = var2 - Rasterizer3D_clipMidY;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var1 -= var0;
							var0 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var1 -= var0;
							var0 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					} else {
						var3 = var5 <<= 14;
						if (var2 < 0) {
							var3 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var4 <<= 14;
						if (var1 < 0) {
							var4 -= var26 * var1;
							var1 = 0;
						}

						var41 = var2 - Rasterizer3D_clipMidY;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var0 -= var1;
							var1 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var0 -= var1;
							var1 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_iDontKnow(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("g")
	@Export("Rasterizer3D_iDontKnow")
	static final void Rasterizer3D_iDontKnow(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
		if (field1763) {
			if (var6 > Rasterizer3D_clipWidth) {
				var6 = Rasterizer3D_clipWidth;
			}

			if (var5 < 0) {
				var5 = 0;
			}
		}

		if (var5 < var6) {
			var4 += var5;
			var7 += var5 * var8;
			int var17 = var6 - var5;
			int var15;
			int var16;
			int var10000;
			int var18;
			int var19;
			int var20;
			int var21;
			int var22;
			int var23;
			if (Rasterizer3D_isLowDetailTexture) {
				var23 = var5 - Rasterizer3D_clipMidX;
				var9 += var23 * (var12 >> 3);
				var10 += (var13 >> 3) * var23;
				var11 += var23 * (var14 >> 3);
				var22 = var11 >> 12;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
					if (var18 < 0) {
						var18 = 0;
					} else if (var18 > 4032) {
						var18 = 4032;
					}
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var12;
				var10 += var13;
				var11 += var14;
				var22 = var11 >> 12;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
					if (var20 < 0) {
						var20 = 0;
					} else if (var20 > 4032) {
						var20 = 4032;
					}
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 20) + var19;
				var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field1772) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var10000 = var16 + var2;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 12;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 4032) {
									var20 = 4032;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 20) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var10000 = var16 + var2;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 12;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 4032) {
									var20 = 4032;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 20) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			} else {
				var23 = var5 - Rasterizer3D_clipMidX;
				var9 += var23 * (var12 >> 3);
				var10 += (var13 >> 3) * var23;
				var11 += var23 * (var14 >> 3);
				var22 = var11 >> 14;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
					if (var18 < 0) {
						var18 = 0;
					} else if (var18 > 16256) {
						var18 = 16256;
					}
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var12;
				var10 += var13;
				var11 += var14;
				var22 = var11 >> 14;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
					if (var20 < 0) {
						var20 = 0;
					} else if (var20 > 16256) {
						var20 = 16256;
					}
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 18) + var19;
				var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field1772) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var10000 = var16 + var2;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 14;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 16256) {
									var20 = 16256;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 18) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var10000 = var16 + var2;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 14;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 16256) {
									var20 = 16256;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 18) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			}

		}
	}

	@ObfuscatedName("a")
	static final void method2988(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
		int[] var19 = Rasterizer3D_textureLoader.load(var18);
		int var20;
		if (var19 == null) {
			var20 = Rasterizer3D_textureLoader.getAverageTextureRGB(var18);
			method3020(var0, var1, var2, var3, var4, var5, method3045(var20, var6), method3045(var20, var7), method3045(var20, var8));
		} else {
			Rasterizer3D_isLowDetailTexture = Rasterizer3D_textureLoader.isLowDetail(var18);
			field1772 = Rasterizer3D_textureLoader.vmethod3278(var18);
			var20 = var4 - var3;
			int var21 = var1 - var0;
			int var22 = var5 - var3;
			int var23 = var2 - var0;
			int var24 = var7 - var6;
			int var25 = var8 - var6;
			int var26 = 0;
			if (var0 != var1) {
				var26 = (var4 - var3 << 14) / (var1 - var0);
			}

			int var27 = 0;
			if (var2 != var1) {
				var27 = (var5 - var4 << 14) / (var2 - var1);
			}

			int var28 = 0;
			if (var0 != var2) {
				var28 = (var3 - var5 << 14) / (var0 - var2);
			}

			int var29 = var20 * var23 - var22 * var21;
			if (var29 != 0) {
				int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
				int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
				var10 = var9 - var10;
				var13 = var12 - var13;
				var16 = var15 - var16;
				var11 -= var9;
				var14 -= var12;
				var17 -= var15;
				int var32 = var11 * var12 - var9 * var14 << 14;
				int var33 = (int)(((long)(var15 * var14 - var17 * var12) << 14) / (long)Rasterizer3D_zoom);
				int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)Rasterizer3D_zoom);
				int var35 = var10 * var12 - var13 * var9 << 14;
				int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 14) / (long)Rasterizer3D_zoom);
				int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)Rasterizer3D_zoom);
				int var38 = var13 * var11 - var10 * var14 << 14;
				int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 14) / (long)Rasterizer3D_zoom);
				int var40 = (int)(((long)(var17 * var10 - var11 * var16) << 14) / (long)Rasterizer3D_zoom);
				int var41;
				if (var0 <= var1 && var0 <= var2) {
					if (var0 < Rasterizer3D_clipHeight) {
						if (var1 > Rasterizer3D_clipHeight) {
							var1 = Rasterizer3D_clipHeight;
						}

						if (var2 > Rasterizer3D_clipHeight) {
							var2 = Rasterizer3D_clipHeight;
						}

						var6 = var30 + ((var6 << 9) - var3 * var30);
						if (var1 < var2) {
							var5 = var3 <<= 14;
							if (var0 < 0) {
								var5 -= var0 * var28;
								var3 -= var0 * var26;
								var6 -= var0 * var31;
								var0 = 0;
							}

							var4 <<= 14;
							if (var1 < 0) {
								var4 -= var27 * var1;
								var1 = 0;
							}

							var41 = var0 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if ((var0 == var1 || var28 >= var26) && (var0 != var1 || var28 <= var27)) {
								var2 -= var1;
								var1 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var1;
								var1 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var4 = var3 <<= 14;
							if (var0 < 0) {
								var4 -= var0 * var28;
								var3 -= var0 * var26;
								var6 -= var0 * var31;
								var0 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var27 * var2;
								var2 = 0;
							}

							var41 = var0 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var0 != var2 && var28 < var26 || var0 == var2 && var27 > var26) {
								var1 -= var2;
								var2 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var1 -= var2;
								var2 -= var0;
								var0 = Rasterizer3D_rowOffsets[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var1 <= var2) {
					if (var1 < Rasterizer3D_clipHeight) {
						if (var2 > Rasterizer3D_clipHeight) {
							var2 = Rasterizer3D_clipHeight;
						}

						if (var0 > Rasterizer3D_clipHeight) {
							var0 = Rasterizer3D_clipHeight;
						}

						var7 = var30 + ((var7 << 9) - var30 * var4);
						if (var2 < var0) {
							var3 = var4 <<= 14;
							if (var1 < 0) {
								var3 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var28 * var2;
								var2 = 0;
							}

							var41 = var1 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if ((var2 == var1 || var26 >= var27) && (var2 != var1 || var26 <= var28)) {
								var0 -= var2;
								var2 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var0 -= var2;
								var2 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var5 = var4 <<= 14;
							if (var1 < 0) {
								var5 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var3 <<= 14;
							if (var0 < 0) {
								var3 -= var0 * var28;
								var0 = 0;
							}

							var41 = var1 - Rasterizer3D_clipMidY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var26 < var27) {
								var2 -= var0;
								var0 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var0;
								var0 -= var1;
								var1 = Rasterizer3D_rowOffsets[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += Rasterizer2D.Rasterizer2D_width;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += Rasterizer2D.Rasterizer2D_width;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var2 < Rasterizer3D_clipHeight) {
					if (var0 > Rasterizer3D_clipHeight) {
						var0 = Rasterizer3D_clipHeight;
					}

					if (var1 > Rasterizer3D_clipHeight) {
						var1 = Rasterizer3D_clipHeight;
					}

					var8 = (var8 << 9) - var5 * var30 + var30;
					if (var0 < var1) {
						var4 = var5 <<= 14;
						if (var2 < 0) {
							var4 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var3 <<= 14;
						if (var0 < 0) {
							var3 -= var0 * var26;
							var0 = 0;
						}

						var41 = var2 - Rasterizer3D_clipMidY;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var1 -= var0;
							var0 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var1 -= var0;
							var0 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					} else {
						var3 = var5 <<= 14;
						if (var2 < 0) {
							var3 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var4 <<= 14;
						if (var1 < 0) {
							var4 -= var26 * var1;
							var1 = 0;
						}

						var41 = var2 - Rasterizer3D_clipMidY;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var0 -= var1;
							var1 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var0 -= var1;
							var1 -= var2;
							var2 = Rasterizer3D_rowOffsets[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += Rasterizer2D.Rasterizer2D_width;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								Rasterizer3D_textureAlpha(Rasterizer2D.Rasterizer2D_pixels, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += Rasterizer2D.Rasterizer2D_width;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("j")
	@Export("Rasterizer3D_textureAlpha")
	static final void Rasterizer3D_textureAlpha(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
		if (field1763) {
			if (var6 > Rasterizer3D_clipWidth) {
				var6 = Rasterizer3D_clipWidth;
			}

			if (var5 < 0) {
				var5 = 0;
			}
		}

		if (var5 < var6) {
			var4 += var5;
			var7 += var5 * var8;
			int var17 = var6 - var5;
			int var15;
			int var16;
			int var18;
			int var19;
			int var20;
			int var21;
			int var22;
			int var23;
			if (Rasterizer3D_isLowDetailTexture) {
				var23 = var5 - Rasterizer3D_clipMidX;
				var9 += var23 * var12;
				var10 += var13 * var23;
				var11 += var23 * var14;
				var22 = var11 >> 12;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var17 * var12;
				var10 += var13 * var17;
				var11 += var17 * var14;
				var22 = var11 >> 12;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 20) + var19;
				var16 = (var21 - var19) / var17 + ((var20 - var18) / var17 << 20);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field1772) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			} else {
				var23 = var5 - Rasterizer3D_clipMidX;
				var9 += var23 * var12;
				var10 += var13 * var23;
				var11 += var23 * var14;
				var22 = var11 >> 14;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var17 * var12;
				var10 += var13 * var17;
				var11 += var17 * var14;
				var22 = var11 >> 14;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 18) + var19;
				var16 = (var21 - var19) / var17 + ((var20 - var18) / var17 << 18);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field1772) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			}

		}
	}

	@ObfuscatedName("o")
	static final int method3045(int var0, int var1) {
		var1 = (var0 & 127) * var1 >> 7;
		if (var1 < 2) {
			var1 = 2;
		} else if (var1 > 126) {
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}

	@ObfuscatedName("d")
	static final int method3040(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var3 * var1 >> 16;
	}

	@ObfuscatedName("s")
	static final int method3061(int var0, int var1, int var2, int var3) {
		return var2 * var1 - var3 * var0 >> 16;
	}

	@ObfuscatedName("z")
	@Export("rot3")
	static final int rot3(int var0, int var1, int var2, int var3) {
		return var0 * var2 - var3 * var1 >> 16;
	}

	@ObfuscatedName("al")
	@Export("rot4")
	static final int rot4(int var0, int var1, int var2, int var3) {
		return var3 * var0 + var2 * var1 >> 16;
	}

	@ObfuscatedName("av")
	@Export("rot1")
	static final int rot1(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var3 * var1 >> 16;
	}

	@ObfuscatedName("as")
	@Export("rot2")
	static final int rot2(int var0, int var1, int var2, int var3) {
		return var2 * var1 - var3 * var0 >> 16;
	}
}
