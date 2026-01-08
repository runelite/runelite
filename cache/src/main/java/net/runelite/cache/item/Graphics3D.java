/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.cache.item;

import net.runelite.cache.models.JagexColor;

class Graphics3D extends Rasterizer2D
{
	private static final double UNIT = Math.PI / 1024d; // How much of the circle each unit of SINE/COSINE is

	public static final int[] SINE = new int[2048]; // sine angles for each of the 2048 units, * 65536 and stored as an int
	public static final int[] COSINE = new int[2048]; // cosine

	static
	{
		for (int i = 0; i < 2048; ++i)
		{
			SINE[i] = (int) (65536.0D * Math.sin((double) i * UNIT));
			COSINE[i] = (int) (65536.0D * Math.cos((double) i * UNIT));
		}
	}

	private final RSTextureProvider textureProvider;
	boolean rasterClipEnable;
	boolean field1909;
	boolean lowMem;
	public boolean rasterGouraudLowRes = true;
	int rasterAlpha;
	public int Rasterizer3D_zoom = 512;
	int centerX;
	int centerY;
	int rasterClipX;
	int Rasterizer3D_clipHeight;
	int Rasterizer3D_clipNegativeMidX;
	int Rasterizer3D_clipMidX2;
	int Rasterizer3D_clipNegativeMidY;
	int Rasterizer3D_clipMidY2;
	int[] rasterClipY = new int[1024];
	public int[] colorPalette;

	public Graphics3D(RSTextureProvider textureProvider)
	{
		this.textureProvider = textureProvider;
	}

	public final void setRasterClipping()
	{
		setRasterClipping(draw_region_x, drawingAreaTop, drawingAreaRight, drawingAreaBottom);
	}

	final void setRasterClipping(int var0, int var1, int var2, int var3)
	{
		rasterClipX = var2 - var0;
		Rasterizer3D_clipHeight = var3 - var1;
		Rasterizer3D_method3();

		if (rasterClipY.length < Rasterizer3D_clipHeight)
		{
			// Find closest 2^n >= v
			int v = Rasterizer3D_clipHeight - 1;
			v |= v >>> 1;
			v |= v >>> 2;
			v |= v >>> 4;
			v |= v >>> 8;
			v |= v >>> 16;
			rasterClipY = new int[v + 1];
		}

		int var4 = var0 + graphicsPixelsWidth * var1;
		for (int i = 0; i < Rasterizer3D_clipHeight; ++i)
		{
			rasterClipY[i] = var4;
			var4 += graphicsPixelsWidth;
		}

	}

	public final void Rasterizer3D_method3()
	{
		centerX = rasterClipX / 2;
		centerY = Rasterizer3D_clipHeight / 2;
		Rasterizer3D_clipNegativeMidX = -centerX;
		Rasterizer3D_clipMidX2 = rasterClipX - centerX;
		Rasterizer3D_clipNegativeMidY = -centerY;
		Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - centerY;
	}

	public final void setOffset(int x, int y)
	{
		int var2 = rasterClipY[0];
		int var3 = var2 / graphicsPixelsWidth;
		int var4 = var2 - var3 * graphicsPixelsWidth;
		centerX = x - var4;
		centerY = y - var3;
		Rasterizer3D_clipNegativeMidX = -centerX;
		Rasterizer3D_clipMidX2 = rasterClipX - centerX;
		Rasterizer3D_clipNegativeMidY = -centerY;
		Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - centerY;
	}

	public final void setBrightness(double brightness)
	{
		colorPalette = JagexColor.createPalette(brightness);
	}

	final void rasterGouraud(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8)
	{
		int var9 = var4 - var3;
		int var10 = var1 - var0;
		int var11 = var5 - var3;
		int var12 = var2 - var0;
		int var13 = var7 - var6;
		int var14 = var8 - var6;
		int var15;
		if (var2 != var1)
		{
			var15 = (var5 - var4 << 14) / (var2 - var1);
		}
		else
		{
			var15 = 0;
		}

		int var16;
		if (var0 != var1)
		{
			var16 = (var9 << 14) / var10;
		}
		else
		{
			var16 = 0;
		}

		int var17;
		if (var0 != var2)
		{
			var17 = (var11 << 14) / var12;
		}
		else
		{
			var17 = 0;
		}

		int var18 = var9 * var12 - var11 * var10;
		if (var18 != 0)
		{
			int var19 = (var13 * var12 - var14 * var10 << 8) / var18;
			int var20 = (var14 * var9 - var13 * var11 << 8) / var18;
			if (var0 <= var1 && var0 <= var2)
			{
				if (var0 < Rasterizer3D_clipHeight)
				{
					if (var1 > Rasterizer3D_clipHeight)
					{
						var1 = Rasterizer3D_clipHeight;
					}

					if (var2 > Rasterizer3D_clipHeight)
					{
						var2 = Rasterizer3D_clipHeight;
					}

					var6 = var19 + ((var6 << 8) - var3 * var19);
					if (var1 < var2)
					{
						var5 = var3 <<= 14;
						if (var0 < 0)
						{
							var5 -= var0 * var17;
							var3 -= var0 * var16;
							var6 -= var0 * var20;
							var0 = 0;
						}

						var4 <<= 14;
						if (var1 < 0)
						{
							var4 -= var15 * var1;
							var1 = 0;
						}

						if (var0 != var1 && var17 < var16 || var0 == var1 && var17 > var15)
						{
							var2 -= var1;
							var1 -= var0;
							var0 = rasterClipY[var0];

							while (true)
							{
								--var1;
								if (var1 < 0)
								{
									while (true)
									{
										--var2;
										if (var2 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var0, 0, 0, var5 >> 14, var4 >> 14, var6, var19);
										var5 += var17;
										var4 += var15;
										var6 += var20;
										var0 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
								var5 += var17;
								var3 += var16;
								var6 += var20;
								var0 += graphicsPixelsWidth;
							}
						}
						else
						{
							var2 -= var1;
							var1 -= var0;
							var0 = rasterClipY[var0];

							while (true)
							{
								--var1;
								if (var1 < 0)
								{
									while (true)
									{
										--var2;
										if (var2 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var0, 0, 0, var4 >> 14, var5 >> 14, var6, var19);
										var5 += var17;
										var4 += var15;
										var6 += var20;
										var0 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
								var5 += var17;
								var3 += var16;
								var6 += var20;
								var0 += graphicsPixelsWidth;
							}
						}
					}
					else
					{
						var4 = var3 <<= 14;
						if (var0 < 0)
						{
							var4 -= var0 * var17;
							var3 -= var0 * var16;
							var6 -= var0 * var20;
							var0 = 0;
						}

						var5 <<= 14;
						if (var2 < 0)
						{
							var5 -= var15 * var2;
							var2 = 0;
						}

						if (var0 != var2 && var17 < var16 || var0 == var2 && var15 > var16)
						{
							var1 -= var2;
							var2 -= var0;
							var0 = rasterClipY[var0];

							while (true)
							{
								--var2;
								if (var2 < 0)
								{
									while (true)
									{
										--var1;
										if (var1 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
										var5 += var15;
										var3 += var16;
										var6 += var20;
										var0 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var0, 0, 0, var4 >> 14, var3 >> 14, var6, var19);
								var4 += var17;
								var3 += var16;
								var6 += var20;
								var0 += graphicsPixelsWidth;
							}
						}
						else
						{
							var1 -= var2;
							var2 -= var0;
							var0 = rasterClipY[var0];

							while (true)
							{
								--var2;
								if (var2 < 0)
								{
									while (true)
									{
										--var1;
										if (var1 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
										var5 += var15;
										var3 += var16;
										var6 += var20;
										var0 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var0, 0, 0, var3 >> 14, var4 >> 14, var6, var19);
								var4 += var17;
								var3 += var16;
								var6 += var20;
								var0 += graphicsPixelsWidth;
							}
						}
					}
				}
			}
			else if (var1 <= var2)
			{
				if (var1 < Rasterizer3D_clipHeight)
				{
					if (var2 > Rasterizer3D_clipHeight)
					{
						var2 = Rasterizer3D_clipHeight;
					}

					if (var0 > Rasterizer3D_clipHeight)
					{
						var0 = Rasterizer3D_clipHeight;
					}

					var7 = var19 + ((var7 << 8) - var19 * var4);
					if (var2 < var0)
					{
						var3 = var4 <<= 14;
						if (var1 < 0)
						{
							var3 -= var16 * var1;
							var4 -= var15 * var1;
							var7 -= var20 * var1;
							var1 = 0;
						}

						var5 <<= 14;
						if (var2 < 0)
						{
							var5 -= var17 * var2;
							var2 = 0;
						}

						if (var2 != var1 && var16 < var15 || var2 == var1 && var16 > var17)
						{
							var0 -= var2;
							var2 -= var1;
							var1 = rasterClipY[var1];

							while (true)
							{
								--var2;
								if (var2 < 0)
								{
									while (true)
									{
										--var0;
										if (var0 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var1, 0, 0, var3 >> 14, var5 >> 14, var7, var19);
										var3 += var16;
										var5 += var17;
										var7 += var20;
										var1 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
								var3 += var16;
								var4 += var15;
								var7 += var20;
								var1 += graphicsPixelsWidth;
							}
						}
						else
						{
							var0 -= var2;
							var2 -= var1;
							var1 = rasterClipY[var1];

							while (true)
							{
								--var2;
								if (var2 < 0)
								{
									while (true)
									{
										--var0;
										if (var0 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var1, 0, 0, var5 >> 14, var3 >> 14, var7, var19);
										var3 += var16;
										var5 += var17;
										var7 += var20;
										var1 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
								var3 += var16;
								var4 += var15;
								var7 += var20;
								var1 += graphicsPixelsWidth;
							}
						}
					}
					else
					{
						var5 = var4 <<= 14;
						if (var1 < 0)
						{
							var5 -= var16 * var1;
							var4 -= var15 * var1;
							var7 -= var20 * var1;
							var1 = 0;
						}

						var3 <<= 14;
						if (var0 < 0)
						{
							var3 -= var0 * var17;
							var0 = 0;
						}

						if (var16 < var15)
						{
							var2 -= var0;
							var0 -= var1;
							var1 = rasterClipY[var1];

							while (true)
							{
								--var0;
								if (var0 < 0)
								{
									while (true)
									{
										--var2;
										if (var2 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
										var3 += var17;
										var4 += var15;
										var7 += var20;
										var1 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var1, 0, 0, var5 >> 14, var4 >> 14, var7, var19);
								var5 += var16;
								var4 += var15;
								var7 += var20;
								var1 += graphicsPixelsWidth;
							}
						}
						else
						{
							var2 -= var0;
							var0 -= var1;
							var1 = rasterClipY[var1];

							while (true)
							{
								--var0;
								if (var0 < 0)
								{
									while (true)
									{
										--var2;
										if (var2 < 0)
										{
											return;
										}

										method2778(graphicsPixels, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
										var3 += var17;
										var4 += var15;
										var7 += var20;
										var1 += graphicsPixelsWidth;
									}
								}

								method2778(graphicsPixels, var1, 0, 0, var4 >> 14, var5 >> 14, var7, var19);
								var5 += var16;
								var4 += var15;
								var7 += var20;
								var1 += graphicsPixelsWidth;
							}
						}
					}
				}
			}
			else if (var2 < Rasterizer3D_clipHeight)
			{
				if (var0 > Rasterizer3D_clipHeight)
				{
					var0 = Rasterizer3D_clipHeight;
				}

				if (var1 > Rasterizer3D_clipHeight)
				{
					var1 = Rasterizer3D_clipHeight;
				}

				var8 = var19 + ((var8 << 8) - var5 * var19);
				if (var0 < var1)
				{
					var4 = var5 <<= 14;
					if (var2 < 0)
					{
						var4 -= var15 * var2;
						var5 -= var17 * var2;
						var8 -= var20 * var2;
						var2 = 0;
					}

					var3 <<= 14;
					if (var0 < 0)
					{
						var3 -= var0 * var16;
						var0 = 0;
					}

					if (var15 < var17)
					{
						var1 -= var0;
						var0 -= var2;
						var2 = rasterClipY[var2];

						while (true)
						{
							--var0;
							if (var0 < 0)
							{
								while (true)
								{
									--var1;
									if (var1 < 0)
									{
										return;
									}

									method2778(graphicsPixels, var2, 0, 0, var4 >> 14, var3 >> 14, var8, var19);
									var4 += var15;
									var3 += var16;
									var8 += var20;
									var2 += graphicsPixelsWidth;
								}
							}

							method2778(graphicsPixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
							var4 += var15;
							var5 += var17;
							var8 += var20;
							var2 += graphicsPixelsWidth;
						}
					}
					else
					{
						var1 -= var0;
						var0 -= var2;
						var2 = rasterClipY[var2];

						while (true)
						{
							--var0;
							if (var0 < 0)
							{
								while (true)
								{
									--var1;
									if (var1 < 0)
									{
										return;
									}

									method2778(graphicsPixels, var2, 0, 0, var3 >> 14, var4 >> 14, var8, var19);
									var4 += var15;
									var3 += var16;
									var8 += var20;
									var2 += graphicsPixelsWidth;
								}
							}

							method2778(graphicsPixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
							var4 += var15;
							var5 += var17;
							var8 += var20;
							var2 += graphicsPixelsWidth;
						}
					}
				}
				else
				{
					var3 = var5 <<= 14;
					if (var2 < 0)
					{
						var3 -= var15 * var2;
						var5 -= var17 * var2;
						var8 -= var20 * var2;
						var2 = 0;
					}

					var4 <<= 14;
					if (var1 < 0)
					{
						var4 -= var16 * var1;
						var1 = 0;
					}

					if (var15 < var17)
					{
						var0 -= var1;
						var1 -= var2;
						var2 = rasterClipY[var2];

						while (true)
						{
							--var1;
							if (var1 < 0)
							{
								while (true)
								{
									--var0;
									if (var0 < 0)
									{
										return;
									}

									method2778(graphicsPixels, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
									var4 += var16;
									var5 += var17;
									var8 += var20;
									var2 += graphicsPixelsWidth;
								}
							}

							method2778(graphicsPixels, var2, 0, 0, var3 >> 14, var5 >> 14, var8, var19);
							var3 += var15;
							var5 += var17;
							var8 += var20;
							var2 += graphicsPixelsWidth;
						}
					}
					else
					{
						var0 -= var1;
						var1 -= var2;
						var2 = rasterClipY[var2];

						while (true)
						{
							--var1;
							if (var1 < 0)
							{
								while (true)
								{
									--var0;
									if (var0 < 0)
									{
										return;
									}

									method2778(graphicsPixels, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
									var4 += var16;
									var5 += var17;
									var8 += var20;
									var2 += graphicsPixelsWidth;
								}
							}

							method2778(graphicsPixels, var2, 0, 0, var5 >> 14, var3 >> 14, var8, var19);
							var3 += var15;
							var5 += var17;
							var8 += var20;
							var2 += graphicsPixelsWidth;
						}
					}
				}
			}
		}
	}


	final void method2778(int[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7)
	{
		if (rasterClipEnable)
		{
			if (var5 > rasterClipX)
			{
				var5 = rasterClipX;
			}

			if (var4 < 0)
			{
				var4 = 0;
			}
		}

		if (var4 < var5)
		{
			var1 += var4;
			var6 += var4 * var7;
			int var8;
			int var9;
			int var10;
			if (rasterGouraudLowRes)
			{
				var3 = var5 - var4 >> 2;
				var7 <<= 2;
				if (rasterAlpha == 0)
				{
					if (var3 > 0)
					{
						do
						{
							var2 = colorPalette[var6 >> 8];
							var6 += var7;
							var0[var1++] = var2;
							var0[var1++] = var2;
							var0[var1++] = var2;
							var0[var1++] = var2;
							--var3;
						} while (var3 > 0);
					}

					var3 = var5 - var4 & 3;
					if (var3 > 0)
					{
						var2 = colorPalette[var6 >> 8];

						do
						{
							var0[var1++] = var2;
							--var3;
						} while (var3 > 0);
					}
				}
				else
				{
					var8 = rasterAlpha;
					var9 = 256 - rasterAlpha;
					if (var3 > 0)
					{
						do
						{
							var2 = colorPalette[var6 >> 8];
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
						} while (var3 > 0);
					}

					var3 = var5 - var4 & 3;
					if (var3 > 0)
					{
						var2 = colorPalette[var6 >> 8];
						var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);

						do
						{
							var10 = var0[var1];
							var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
							--var3;
						} while (var3 > 0);
					}
				}

			}
			else
			{
				var3 = var5 - var4;
				if (rasterAlpha == 0)
				{
					do
					{
						var0[var1++] = colorPalette[var6 >> 8];
						var6 += var7;
						--var3;
					} while (var3 > 0);
				}
				else
				{
					var8 = rasterAlpha;
					var9 = 256 - rasterAlpha;

					do
					{
						var2 = colorPalette[var6 >> 8];
						var6 += var7;
						var2 = (var9 * (var2 & 65280) >> 8 & 65280) + (var9 * (var2 & 16711935) >> 8 & 16711935);
						var10 = var0[var1];
						var0[var1++] = ((var10 & 16711935) * var8 >> 8 & 16711935) + var2 + (var8 * (var10 & 65280) >> 8 & 65280);
						--var3;
					} while (var3 > 0);
				}

			}
		}
	}


	public final void rasterFlat(int var0, int var1, int var2, int var3, int var4, int var5, int var6)
	{
		int var7 = 0;
		if (var0 != var1)
		{
			var7 = (var4 - var3 << 14) / (var1 - var0);
		}

		int var8 = 0;
		if (var2 != var1)
		{
			var8 = (var5 - var4 << 14) / (var2 - var1);
		}

		int var9 = 0;
		if (var0 != var2)
		{
			var9 = (var3 - var5 << 14) / (var0 - var2);
		}

		if (var0 <= var1 && var0 <= var2)
		{
			if (var0 < Rasterizer3D_clipHeight)
			{
				if (var1 > Rasterizer3D_clipHeight)
				{
					var1 = Rasterizer3D_clipHeight;
				}

				if (var2 > Rasterizer3D_clipHeight)
				{
					var2 = Rasterizer3D_clipHeight;
				}

				if (var1 < var2)
				{
					var5 = var3 <<= 14;
					if (var0 < 0)
					{
						var5 -= var0 * var9;
						var3 -= var0 * var7;
						var0 = 0;
					}

					var4 <<= 14;
					if (var1 < 0)
					{
						var4 -= var8 * var1;
						var1 = 0;
					}

					if ((var0 == var1 || var9 >= var7) && (var0 != var1 || var9 <= var8))
					{
						var2 -= var1;
						var1 -= var0;
						var0 = rasterClipY[var0];

						while (true)
						{
							--var1;
							if (var1 < 0)
							{
								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var0, var6, 0, var4 >> 14, var5 >> 14);
									var5 += var9;
									var4 += var8;
									var0 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var0, var6, 0, var3 >> 14, var5 >> 14);
							var5 += var9;
							var3 += var7;
							var0 += graphicsPixelsWidth;
						}
					}
					else
					{
						var2 -= var1;
						var1 -= var0;
						var0 = rasterClipY[var0];

						while (true)
						{
							--var1;
							if (var1 < 0)
							{
								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var0, var6, 0, var5 >> 14, var4 >> 14);
									var5 += var9;
									var4 += var8;
									var0 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var0, var6, 0, var5 >> 14, var3 >> 14);
							var5 += var9;
							var3 += var7;
							var0 += graphicsPixelsWidth;
						}
					}
				}
				else
				{
					var4 = var3 <<= 14;
					if (var0 < 0)
					{
						var4 -= var0 * var9;
						var3 -= var0 * var7;
						var0 = 0;
					}

					var5 <<= 14;
					if (var2 < 0)
					{
						var5 -= var8 * var2;
						var2 = 0;
					}

					if (var0 != var2 && var9 < var7 || var0 == var2 && var8 > var7)
					{
						var1 -= var2;
						var2 -= var0;
						var0 = rasterClipY[var0];

						while (true)
						{
							--var2;
							if (var2 < 0)
							{
								while (true)
								{
									--var1;
									if (var1 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var0, var6, 0, var5 >> 14, var3 >> 14);
									var5 += var8;
									var3 += var7;
									var0 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var0, var6, 0, var4 >> 14, var3 >> 14);
							var4 += var9;
							var3 += var7;
							var0 += graphicsPixelsWidth;
						}
					}
					else
					{
						var1 -= var2;
						var2 -= var0;
						var0 = rasterClipY[var0];

						while (true)
						{
							--var2;
							if (var2 < 0)
							{
								while (true)
								{
									--var1;
									if (var1 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var0, var6, 0, var3 >> 14, var5 >> 14);
									var5 += var8;
									var3 += var7;
									var0 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var0, var6, 0, var3 >> 14, var4 >> 14);
							var4 += var9;
							var3 += var7;
							var0 += graphicsPixelsWidth;
						}
					}
				}
			}
		}
		else if (var1 <= var2)
		{
			if (var1 < Rasterizer3D_clipHeight)
			{
				if (var2 > Rasterizer3D_clipHeight)
				{
					var2 = Rasterizer3D_clipHeight;
				}

				if (var0 > Rasterizer3D_clipHeight)
				{
					var0 = Rasterizer3D_clipHeight;
				}

				if (var2 < var0)
				{
					var3 = var4 <<= 14;
					if (var1 < 0)
					{
						var3 -= var7 * var1;
						var4 -= var8 * var1;
						var1 = 0;
					}

					var5 <<= 14;
					if (var2 < 0)
					{
						var5 -= var9 * var2;
						var2 = 0;
					}

					if ((var2 == var1 || var7 >= var8) && (var2 != var1 || var7 <= var9))
					{
						var0 -= var2;
						var2 -= var1;
						var1 = rasterClipY[var1];

						while (true)
						{
							--var2;
							if (var2 < 0)
							{
								while (true)
								{
									--var0;
									if (var0 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var1, var6, 0, var5 >> 14, var3 >> 14);
									var3 += var7;
									var5 += var9;
									var1 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var1, var6, 0, var4 >> 14, var3 >> 14);
							var3 += var7;
							var4 += var8;
							var1 += graphicsPixelsWidth;
						}
					}
					else
					{
						var0 -= var2;
						var2 -= var1;
						var1 = rasterClipY[var1];

						while (true)
						{
							--var2;
							if (var2 < 0)
							{
								while (true)
								{
									--var0;
									if (var0 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var1, var6, 0, var3 >> 14, var5 >> 14);
									var3 += var7;
									var5 += var9;
									var1 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var1, var6, 0, var3 >> 14, var4 >> 14);
							var3 += var7;
							var4 += var8;
							var1 += graphicsPixelsWidth;
						}
					}
				}
				else
				{
					var5 = var4 <<= 14;
					if (var1 < 0)
					{
						var5 -= var7 * var1;
						var4 -= var8 * var1;
						var1 = 0;
					}

					var3 <<= 14;
					if (var0 < 0)
					{
						var3 -= var0 * var9;
						var0 = 0;
					}

					if (var7 < var8)
					{
						var2 -= var0;
						var0 -= var1;
						var1 = rasterClipY[var1];

						while (true)
						{
							--var0;
							if (var0 < 0)
							{
								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var1, var6, 0, var3 >> 14, var4 >> 14);
									var3 += var9;
									var4 += var8;
									var1 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var1, var6, 0, var5 >> 14, var4 >> 14);
							var5 += var7;
							var4 += var8;
							var1 += graphicsPixelsWidth;
						}
					}
					else
					{
						var2 -= var0;
						var0 -= var1;
						var1 = rasterClipY[var1];

						while (true)
						{
							--var0;
							if (var0 < 0)
							{
								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										return;
									}

									method2842(graphicsPixels, var1, var6, 0, var4 >> 14, var3 >> 14);
									var3 += var9;
									var4 += var8;
									var1 += graphicsPixelsWidth;
								}
							}

							method2842(graphicsPixels, var1, var6, 0, var4 >> 14, var5 >> 14);
							var5 += var7;
							var4 += var8;
							var1 += graphicsPixelsWidth;
						}
					}
				}
			}
		}
		else if (var2 < Rasterizer3D_clipHeight)
		{
			if (var0 > Rasterizer3D_clipHeight)
			{
				var0 = Rasterizer3D_clipHeight;
			}

			if (var1 > Rasterizer3D_clipHeight)
			{
				var1 = Rasterizer3D_clipHeight;
			}

			if (var0 < var1)
			{
				var4 = var5 <<= 14;
				if (var2 < 0)
				{
					var4 -= var8 * var2;
					var5 -= var9 * var2;
					var2 = 0;
				}

				var3 <<= 14;
				if (var0 < 0)
				{
					var3 -= var0 * var7;
					var0 = 0;
				}

				if (var8 < var9)
				{
					var1 -= var0;
					var0 -= var2;
					var2 = rasterClipY[var2];

					while (true)
					{
						--var0;
						if (var0 < 0)
						{
							while (true)
							{
								--var1;
								if (var1 < 0)
								{
									return;
								}

								method2842(graphicsPixels, var2, var6, 0, var4 >> 14, var3 >> 14);
								var4 += var8;
								var3 += var7;
								var2 += graphicsPixelsWidth;
							}
						}

						method2842(graphicsPixels, var2, var6, 0, var4 >> 14, var5 >> 14);
						var4 += var8;
						var5 += var9;
						var2 += graphicsPixelsWidth;
					}
				}
				else
				{
					var1 -= var0;
					var0 -= var2;
					var2 = rasterClipY[var2];

					while (true)
					{
						--var0;
						if (var0 < 0)
						{
							while (true)
							{
								--var1;
								if (var1 < 0)
								{
									return;
								}

								method2842(graphicsPixels, var2, var6, 0, var3 >> 14, var4 >> 14);
								var4 += var8;
								var3 += var7;
								var2 += graphicsPixelsWidth;
							}
						}

						method2842(graphicsPixels, var2, var6, 0, var5 >> 14, var4 >> 14);
						var4 += var8;
						var5 += var9;
						var2 += graphicsPixelsWidth;
					}
				}
			}
			else
			{
				var3 = var5 <<= 14;
				if (var2 < 0)
				{
					var3 -= var8 * var2;
					var5 -= var9 * var2;
					var2 = 0;
				}

				var4 <<= 14;
				if (var1 < 0)
				{
					var4 -= var7 * var1;
					var1 = 0;
				}

				if (var8 < var9)
				{
					var0 -= var1;
					var1 -= var2;
					var2 = rasterClipY[var2];

					while (true)
					{
						--var1;
						if (var1 < 0)
						{
							while (true)
							{
								--var0;
								if (var0 < 0)
								{
									return;
								}

								method2842(graphicsPixels, var2, var6, 0, var4 >> 14, var5 >> 14);
								var4 += var7;
								var5 += var9;
								var2 += graphicsPixelsWidth;
							}
						}

						method2842(graphicsPixels, var2, var6, 0, var3 >> 14, var5 >> 14);
						var3 += var8;
						var5 += var9;
						var2 += graphicsPixelsWidth;
					}
				}
				else
				{
					var0 -= var1;
					var1 -= var2;
					var2 = rasterClipY[var2];

					while (true)
					{
						--var1;
						if (var1 < 0)
						{
							while (true)
							{
								--var0;
								if (var0 < 0)
								{
									return;
								}

								method2842(graphicsPixels, var2, var6, 0, var5 >> 14, var4 >> 14);
								var4 += var7;
								var5 += var9;
								var2 += graphicsPixelsWidth;
							}
						}

						method2842(graphicsPixels, var2, var6, 0, var5 >> 14, var3 >> 14);
						var3 += var8;
						var5 += var9;
						var2 += graphicsPixelsWidth;
					}
				}
			}
		}
	}


	final void method2842(int[] var0, int var1, int var2, int var3, int var4, int var5)
	{
		if (rasterClipEnable)
		{
			if (var5 > rasterClipX)
			{
				var5 = rasterClipX;
			}

			if (var4 < 0)
			{
				var4 = 0;
			}
		}

		if (var4 < var5)
		{
			var1 += var4;
			var3 = var5 - var4 >> 2;
			if (rasterAlpha != 0)
			{
				if (rasterAlpha == 254)
				{
					while (true)
					{
						--var3;
						if (var3 < 0)
						{
							var3 = var5 - var4 & 3;

							while (true)
							{
								--var3;
								if (var3 < 0)
								{
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
				}
				else
				{
					int var6 = rasterAlpha;
					int var7 = 256 - rasterAlpha;
					var2 = (var7 * (var2 & 65280) >> 8 & 65280) + (var7 * (var2 & 16711935) >> 8 & 16711935);

					while (true)
					{
						--var3;
						int var8;
						if (var3 < 0)
						{
							var3 = var5 - var4 & 3;

							while (true)
							{
								--var3;
								if (var3 < 0)
								{
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
			}
			else
			{
				while (true)
				{
					--var3;
					if (var3 < 0)
					{
						var3 = var5 - var4 & 3;

						while (true)
						{
							--var3;
							if (var3 < 0)
							{
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


	final void rasterTextureAffine(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18)
	{
		int[] var19 = textureProvider.load(var18);
		int var20;
		if (var19 == null)
		{
			var20 = textureProvider.getAverageTextureRGB(var18);
			rasterGouraud(var0, var1, var2, var3, var4, var5, method2794(var20, var6), method2794(var20, var7), method2794(var20, var8));
		}
		else
		{
			lowMem = textureProvider.vmethod3066(var18);
			field1909 = textureProvider.vmethod3057(var18);
			var20 = var4 - var3;
			int var21 = var1 - var0;
			int var22 = var5 - var3;
			int var23 = var2 - var0;
			int var24 = var7 - var6;
			int var25 = var8 - var6;
			int var26 = 0;
			if (var0 != var1)
			{
				var26 = (var4 - var3 << 14) / (var1 - var0);
			}

			int var27 = 0;
			if (var2 != var1)
			{
				var27 = (var5 - var4 << 14) / (var2 - var1);
			}

			int var28 = 0;
			if (var0 != var2)
			{
				var28 = (var3 - var5 << 14) / (var0 - var2);
			}

			int var29 = var20 * var23 - var22 * var21;
			if (var29 != 0)
			{
				int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
				int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
				var10 = var9 - var10;
				var13 = var12 - var13;
				var16 = var15 - var16;
				var11 -= var9;
				var14 -= var12;
				var17 -= var15;
				int var32 = var11 * var12 - var9 * var14 << 14;
				int var33 = (int) (((long) (var15 * var14 - var17 * var12) << 3 << 14) / (long) Rasterizer3D_zoom);
				int var34 = (int) (((long) (var17 * var9 - var11 * var15) << 14) / (long) Rasterizer3D_zoom);
				int var35 = var10 * var12 - var13 * var9 << 14;
				int var36 = (int) (((long) (var13 * var15 - var16 * var12) << 3 << 14) / (long) Rasterizer3D_zoom);
				int var37 = (int) (((long) (var16 * var9 - var10 * var15) << 14) / (long) Rasterizer3D_zoom);
				int var38 = var13 * var11 - var10 * var14 << 14;
				int var39 = (int) (((long) (var16 * var14 - var13 * var17) << 3 << 14) / (long) Rasterizer3D_zoom);
				int var40 = (int) (((long) (var17 * var10 - var11 * var16) << 14) / (long) Rasterizer3D_zoom);
				int var41;
				if (var0 <= var1 && var0 <= var2)
				{
					if (var0 < Rasterizer3D_clipHeight)
					{
						if (var1 > Rasterizer3D_clipHeight)
						{
							var1 = Rasterizer3D_clipHeight;
						}

						if (var2 > Rasterizer3D_clipHeight)
						{
							var2 = Rasterizer3D_clipHeight;
						}

						var6 = var30 + ((var6 << 9) - var3 * var30);
						if (var1 < var2)
						{
							var5 = var3 <<= 14;
							if (var0 < 0)
							{
								var5 -= var0 * var28;
								var3 -= var0 * var26;
								var6 -= var0 * var31;
								var0 = 0;
							}

							var4 <<= 14;
							if (var1 < 0)
							{
								var4 -= var27 * var1;
								var1 = 0;
							}

							var41 = var0 - centerY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if ((var0 == var1 || var28 >= var26) && (var0 != var1 || var28 <= var27))
							{
								var2 -= var1;
								var1 -= var0;
								var0 = rasterClipY[var0];

								while (true)
								{
									--var1;
									if (var1 < 0)
									{
										while (true)
										{
											--var2;
											if (var2 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
							else
							{
								var2 -= var1;
								var1 -= var0;
								var0 = rasterClipY[var0];

								while (true)
								{
									--var1;
									if (var1 < 0)
									{
										while (true)
										{
											--var2;
											if (var2 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
						else
						{
							var4 = var3 <<= 14;
							if (var0 < 0)
							{
								var4 -= var0 * var28;
								var3 -= var0 * var26;
								var6 -= var0 * var31;
								var0 = 0;
							}

							var5 <<= 14;
							if (var2 < 0)
							{
								var5 -= var27 * var2;
								var2 = 0;
							}

							var41 = var0 - centerY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var0 != var2 && var28 < var26 || var0 == var2 && var27 > var26)
							{
								var1 -= var2;
								var2 -= var0;
								var0 = rasterClipY[var0];

								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										while (true)
										{
											--var1;
											if (var1 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
							else
							{
								var1 -= var2;
								var2 -= var0;
								var0 = rasterClipY[var0];

								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										while (true)
										{
											--var1;
											if (var1 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				}
				else if (var1 <= var2)
				{
					if (var1 < Rasterizer3D_clipHeight)
					{
						if (var2 > Rasterizer3D_clipHeight)
						{
							var2 = Rasterizer3D_clipHeight;
						}

						if (var0 > Rasterizer3D_clipHeight)
						{
							var0 = Rasterizer3D_clipHeight;
						}

						var7 = var30 + ((var7 << 9) - var30 * var4);
						if (var2 < var0)
						{
							var3 = var4 <<= 14;
							if (var1 < 0)
							{
								var3 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var5 <<= 14;
							if (var2 < 0)
							{
								var5 -= var28 * var2;
								var2 = 0;
							}

							var41 = var1 - centerY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if ((var2 == var1 || var26 >= var27) && (var2 != var1 || var26 <= var28))
							{
								var0 -= var2;
								var2 -= var1;
								var1 = rasterClipY[var1];

								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										while (true)
										{
											--var0;
											if (var0 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
							else
							{
								var0 -= var2;
								var2 -= var1;
								var1 = rasterClipY[var1];

								while (true)
								{
									--var2;
									if (var2 < 0)
									{
										while (true)
										{
											--var0;
											if (var0 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
						else
						{
							var5 = var4 <<= 14;
							if (var1 < 0)
							{
								var5 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var3 <<= 14;
							if (var0 < 0)
							{
								var3 -= var0 * var28;
								var0 = 0;
							}

							var41 = var1 - centerY;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var26 < var27)
							{
								var2 -= var0;
								var0 -= var1;
								var1 = rasterClipY[var1];

								while (true)
								{
									--var0;
									if (var0 < 0)
									{
										while (true)
										{
											--var2;
											if (var2 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
							else
							{
								var2 -= var0;
								var0 -= var1;
								var1 = rasterClipY[var1];

								while (true)
								{
									--var0;
									if (var0 < 0)
									{
										while (true)
										{
											--var2;
											if (var2 < 0)
											{
												return;
											}

											method2791(graphicsPixels, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += graphicsPixelsWidth;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method2791(graphicsPixels, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += graphicsPixelsWidth;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				}
				else if (var2 < Rasterizer3D_clipHeight)
				{
					if (var0 > Rasterizer3D_clipHeight)
					{
						var0 = Rasterizer3D_clipHeight;
					}

					if (var1 > Rasterizer3D_clipHeight)
					{
						var1 = Rasterizer3D_clipHeight;
					}

					var8 = (var8 << 9) - var5 * var30 + var30;
					if (var0 < var1)
					{
						var4 = var5 <<= 14;
						if (var2 < 0)
						{
							var4 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var3 <<= 14;
						if (var0 < 0)
						{
							var3 -= var0 * var26;
							var0 = 0;
						}

						var41 = var2 - centerY;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28)
						{
							var1 -= var0;
							var0 -= var2;
							var2 = rasterClipY[var2];

							while (true)
							{
								--var0;
								if (var0 < 0)
								{
									while (true)
									{
										--var1;
										if (var1 < 0)
										{
											return;
										}

										method2791(graphicsPixels, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += graphicsPixelsWidth;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method2791(graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += graphicsPixelsWidth;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
						else
						{
							var1 -= var0;
							var0 -= var2;
							var2 = rasterClipY[var2];

							while (true)
							{
								--var0;
								if (var0 < 0)
								{
									while (true)
									{
										--var1;
										if (var1 < 0)
										{
											return;
										}

										method2791(graphicsPixels, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += graphicsPixelsWidth;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method2791(graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += graphicsPixelsWidth;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					}
					else
					{
						var3 = var5 <<= 14;
						if (var2 < 0)
						{
							var3 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var4 <<= 14;
						if (var1 < 0)
						{
							var4 -= var26 * var1;
							var1 = 0;
						}

						var41 = var2 - centerY;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28)
						{
							var0 -= var1;
							var1 -= var2;
							var2 = rasterClipY[var2];

							while (true)
							{
								--var1;
								if (var1 < 0)
								{
									while (true)
									{
										--var0;
										if (var0 < 0)
										{
											return;
										}

										method2791(graphicsPixels, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += graphicsPixelsWidth;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method2791(graphicsPixels, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += graphicsPixelsWidth;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
						else
						{
							var0 -= var1;
							var1 -= var2;
							var2 = rasterClipY[var2];

							while (true)
							{
								--var1;
								if (var1 < 0)
								{
									while (true)
									{
										--var0;
										if (var0 < 0)
										{
											return;
										}

										method2791(graphicsPixels, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += graphicsPixelsWidth;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method2791(graphicsPixels, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += graphicsPixelsWidth;
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


	final void method2791(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14)
	{
		if (rasterClipEnable)
		{
			if (var6 > rasterClipX)
			{
				var6 = rasterClipX;
			}

			if (var5 < 0)
			{
				var5 = 0;
			}
		}

		if (var5 < var6)
		{
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
			if (lowMem)
			{
				var23 = var5 - centerX;
				var9 += var23 * (var12 >> 3);
				var10 += (var13 >> 3) * var23;
				var11 += var23 * (var14 >> 3);
				var22 = var11 >> 12;
				if (var22 != 0)
				{
					var18 = var9 / var22;
					var19 = var10 / var22;
					if (var18 < 0)
					{
						var18 = 0;
					}
					else if (var18 > 4032)
					{
						var18 = 4032;
					}
				}
				else
				{
					var18 = 0;
					var19 = 0;
				}

				var9 += var12;
				var10 += var13;
				var11 += var14;
				var22 = var11 >> 12;
				if (var22 != 0)
				{
					var20 = var9 / var22;
					var21 = var10 / var22;
					if (var20 < 0)
					{
						var20 = 0;
					}
					else if (var20 > 4032)
					{
						var20 = 4032;
					}
				}
				else
				{
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 20) + var19;
				var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field1909)
				{
					if (var17 > 0)
					{
						do
						{
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
							if (var22 != 0)
							{
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0)
								{
									var20 = 0;
								}
								else if (var20 > 4032)
								{
									var20 = 4032;
								}
							}
							else
							{
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 20) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while (var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0)
					{
						do
						{
							var3 = var1[(var2 >>> 26) + (var2 & 4032)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							--var17;
						} while (var17 > 0);
					}
				}
				else
				{
					if (var17 > 0)
					{
						do
						{
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
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
							if (var22 != 0)
							{
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0)
								{
									var20 = 0;
								}
								else if (var20 > 4032)
								{
									var20 = 4032;
								}
							}
							else
							{
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 20) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 20);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while (var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0)
					{
						do
						{
							if ((var3 = var1[(var2 >>> 26) + (var2 & 4032)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while (var17 > 0);
					}
				}
			}
			else
			{
				var23 = var5 - centerX;
				var9 += var23 * (var12 >> 3);
				var10 += (var13 >> 3) * var23;
				var11 += var23 * (var14 >> 3);
				var22 = var11 >> 14;
				if (var22 != 0)
				{
					var18 = var9 / var22;
					var19 = var10 / var22;
					if (var18 < 0)
					{
						var18 = 0;
					}
					else if (var18 > 16256)
					{
						var18 = 16256;
					}
				}
				else
				{
					var18 = 0;
					var19 = 0;
				}

				var9 += var12;
				var10 += var13;
				var11 += var14;
				var22 = var11 >> 14;
				if (var22 != 0)
				{
					var20 = var9 / var22;
					var21 = var10 / var22;
					if (var20 < 0)
					{
						var20 = 0;
					}
					else if (var20 > 16256)
					{
						var20 = 16256;
					}
				}
				else
				{
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 18) + var19;
				var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field1909)
				{
					if (var17 > 0)
					{
						do
						{
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
							if (var22 != 0)
							{
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0)
								{
									var20 = 0;
								}
								else if (var20 > 16256)
								{
									var20 = 16256;
								}
							}
							else
							{
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 18) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while (var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0)
					{
						do
						{
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							var2 += var16;
							--var17;
						} while (var17 > 0);
					}
				}
				else
				{
					if (var17 > 0)
					{
						do
						{
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
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
							if (var22 != 0)
							{
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0)
								{
									var20 = 0;
								}
								else if (var20 > 16256)
								{
									var20 = 16256;
								}
							}
							else
							{
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 18) + var19;
							var16 = (var21 - var19 >> 3) + (var20 - var18 >> 3 << 18);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while (var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0)
					{
						do
						{
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0)
							{
								var0[var4] = (var15 * (var3 & 65280) & 16711680) + ((var3 & 16711935) * var15 & -16711936) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while (var17 > 0);
					}
				}
			}

		}
	}

	static final int method2794(int var0, int var1)
	{
		var1 = (var0 & 127) * var1 >> 7;
		if (var1 < 2)
		{
			var1 = 2;
		}
		else if (var1 > 126)
		{
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}
}
