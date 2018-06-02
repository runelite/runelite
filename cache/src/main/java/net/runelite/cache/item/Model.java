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

class Model extends Renderable
{
	boolean[] field1887 = new boolean[4700];
	boolean[] field1885 = new boolean[4700];
	int[] modelViewportYs = new int[4700];
	int[] modelViewportXs = new int[4700];
	int[] modelViewportZs = new int[4700];
	int[] yViewportBuffer = new int[4700];
	int[] field1839 = new int[4700];
	int[] field1869 = new int[4700];
	int[] field1871 = new int[1600];
	int[][] field1868 = new int[1600][512];
	int[] field1872 = new int[12];
	int[][] field1874 = new int[12][2000];
	int[] field1857 = new int[2000];
	int[] field1863 = new int[2000];
	int[] field1877 = new int[12];
	int[] field1831 = new int[10];
	int[] field1837 = new int[10];
	int[] xViewportBuffer = new int[10];
	static int[] Model_sine;
	static int[] Model_cosine;
	static int[] field1890;
	int verticesCount;
	int[] verticesX;
	int[] verticesY;
	int[] verticesZ;
	int indicesCount;
	int[] indices1;
	int[] indices2;
	int[] indices3;
	int[] field1856;
	int[] field1854;
	int[] field1823;
	byte[] field1838;
	byte[] field1882;
	byte[] field1840;
	short[] field1841;
	byte field1842;
	int field1852;
	int[] field1844;
	int[] field1865;
	int[] field1846;
	public boolean isItemModel;
	int boundsType;
	int bottomY;
	int XYZMag;
	int diameter;
	int radius;
	public int extremeX;
	public int extremeY;
	public int extremeZ;

	static
	{
		Model_sine = Graphics3D.SINE;
		Model_cosine = Graphics3D.COSINE;
		field1890 = Graphics3D.field1933;
	}

	Model()
	{
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.field1842 = 0;
		this.field1852 = 0;
		this.isItemModel = false;
		this.extremeX = -1;
		this.extremeY = -1;
		this.extremeZ = -1;
	}

	public void calculateBoundsCylinder()
	{
		if (this.boundsType != 1)
		{
			this.boundsType = 1;
			super.modelHeight = 0;
			this.bottomY = 0;
			this.XYZMag = 0;

			for (int var1 = 0; var1 < this.verticesCount; ++var1)
			{
				int var2 = this.verticesX[var1];
				int var3 = this.verticesY[var1];
				int var4 = this.verticesZ[var1];
				if (-var3 > super.modelHeight)
				{
					super.modelHeight = -var3;
				}

				if (var3 > this.bottomY)
				{
					this.bottomY = var3;
				}

				int var5 = var2 * var2 + var4 * var4;
				if (var5 > this.XYZMag)
				{
					this.XYZMag = var5;
				}
			}

			this.XYZMag = (int) (Math.sqrt((double) this.XYZMag) + 0.99D);
			this.radius = (int) (Math.sqrt((double) (this.XYZMag * this.XYZMag + super.modelHeight * super.modelHeight)) + 0.99D);
			this.diameter = this.radius + (int) (Math.sqrt((double) (this.XYZMag * this.XYZMag + this.bottomY * this.bottomY)) + 0.99D);
		}
	}

	public final void rotateAndProject(Graphics3D graphics, int rotation_1, int yRotation, int zRotation, int xRotation, int xOffset, int yOffset, int zOffset)
	{
		field1871[0] = -1;
		// (re?)Calculate magnitude as necessary
		if (this.boundsType != 2 && this.boundsType != 1)
		{
			this.boundsType = 2;
			this.XYZMag = 0;

			for (int var1 = 0; var1 < this.verticesCount; ++var1)
			{
				int x = this.verticesX[var1];
				int y = this.verticesY[var1];
				int z = this.verticesZ[var1];
				int magnitude_squared = x * x + z * z + y * y;
				if (magnitude_squared > this.XYZMag)
				{
					this.XYZMag = magnitude_squared;
				}
			}

			this.XYZMag = (int) (Math.sqrt((double) this.XYZMag) + 0.99D);
			this.radius = this.XYZMag;
			this.diameter = this.XYZMag + this.XYZMag;
		}

		// rotate + perspective transform
		int sinX = Model_sine[xRotation];
		int cosX = Model_cosine[xRotation];
		int zRelatedVariable = sinX * yOffset + cosX * zOffset >> 16;

		for (int i = 0; i < this.verticesCount; ++i)
		{
			int x = this.verticesX[i];
			int y = this.verticesY[i];
			int z = this.verticesZ[i];
			if (zRotation != 0)
			{
				int sinZ = Model_sine[zRotation];
				int cosZ = Model_cosine[zRotation];
				int tmp;
				tmp = y * sinZ + x * cosZ >> 16;
				y = y * cosZ - x * sinZ >> 16;
				x = tmp;
			}

			if (rotation_1 != 0)
			{
				int sinR1 = Model_sine[rotation_1];
				int cosR1 = Model_cosine[rotation_1];
				int tmp;
				tmp = y * cosR1 - z * sinR1 >> 16;
				z = y * sinR1 + z * cosR1 >> 16;
				y = tmp;
			}

			if (yRotation != 0)
			{
				int sinY = Model_sine[yRotation];
				int cosY = Model_cosine[yRotation];
				int tmp;
				tmp = z * sinY + x * cosY >> 16;
				z = z * cosY - x * sinY >> 16;
				x = tmp;
			}

			x += xOffset;
			y += yOffset;
			z += zOffset;
			int tmp = y * cosX - z * sinX >> 16;
			z = y * sinX + z * cosX >> 16;
			modelViewportZs[i] = z - zRelatedVariable;
			modelViewportYs[i] = x * graphics.Rasterizer3D_zoom / z + graphics.centerX;
			modelViewportXs[i] = tmp * graphics.Rasterizer3D_zoom / z + graphics.centerY;
			if (this.field1852 > 0)
			{
				yViewportBuffer[i] = x;
				field1839[i] = tmp;
				field1869[i] = z;
			}
		}

		this.method0(graphics, false, false, 0);
	}


	private void method0(Graphics3D graphics, boolean var1, boolean var3, int var4)
	{
		if (this.diameter < 1600)
		{
			for (int var5 = 0; var5 < this.diameter; ++var5)
			{
				field1871[var5] = 0;
			}

			int var7;
			int var9;
			int var10;
			int var11;
			int var12;
			int var13;
			int var14;
			int var15;
			int var16;
			int var17;
			int var18;
			int var19;
			int var20;
			int var27;

			int var26;
			for (var26 = 0; var26 < this.indicesCount; ++var26)
			{
				if (this.field1823[var26] != -2)
				{
					var7 = this.indices1[var26];
					var27 = this.indices2[var26];
					var9 = this.indices3[var26];
					var10 = modelViewportYs[var7];
					var11 = modelViewportYs[var27];
					var12 = modelViewportYs[var9];
					if (var1 && (var10 == -5000 || var11 == -5000 || var12 == -5000))
					{
						var13 = yViewportBuffer[var7];
						var14 = yViewportBuffer[var27];
						var15 = yViewportBuffer[var9];
						var16 = field1839[var7];
						var17 = field1839[var27];
						var18 = field1839[var9];
						var19 = field1869[var7];
						var20 = field1869[var27];
						int var21 = field1869[var9];
						var13 -= var14;
						var15 -= var14;
						var16 -= var17;
						var18 -= var17;
						var19 -= var20;
						var21 -= var20;
						int var22 = var16 * var21 - var19 * var18;
						int var23 = var19 * var15 - var13 * var21;
						int var24 = var13 * var18 - var16 * var15;
						if (var14 * var22 + var17 * var23 + var20 * var24 > 0)
						{
							field1885[var26] = true;
							int var25 = (modelViewportZs[var7] + modelViewportZs[var27] + modelViewportZs[var9]) / 3 + this.radius;
							field1868[var25][field1871[var25]++] = var26;
						}
					}
					else
					{
						if ((var10 - var11) * (modelViewportXs[var9] - modelViewportXs[var27]) - (var12 - var11) * (modelViewportXs[var7] - modelViewportXs[var27]) > 0)
						{
							field1885[var26] = false;
							if (var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= graphics.rasterClipX && var11 <= graphics.rasterClipX && var12 <= graphics.rasterClipX)
							{
								field1887[var26] = false;
							}
							else
							{
								field1887[var26] = true;
							}

							var13 = (modelViewportZs[var7] + modelViewportZs[var27] + modelViewportZs[var9]) / 3 + this.radius;
							field1868[var13][field1871[var13]++] = var26;
						}
					}
				}
			}

			int[] var8;
			if (this.field1838 == null)
			{
				for (var26 = this.diameter - 1; var26 >= 0; --var26)
				{
					var7 = field1871[var26];
					if (var7 > 0)
					{
						var8 = field1868[var26];

						for (var9 = 0; var9 < var7; ++var9)
						{
							this.method2706(graphics, var8[var9]);
						}
					}
				}

			}
			else
			{
				for (var26 = 0; var26 < 12; ++var26)
				{
					field1872[var26] = 0;
					field1877[var26] = 0;
				}

				for (var26 = this.diameter - 1; var26 >= 0; --var26)
				{
					var7 = field1871[var26];
					if (var7 > 0)
					{
						var8 = field1868[var26];

						for (var9 = 0; var9 < var7; ++var9)
						{
							var10 = var8[var9];
							byte var31 = this.field1838[var10];
							var12 = field1872[var31]++;
							field1874[var31][var12] = var10;
							if (var31 < 10)
							{
								field1877[var31] += var26;
							}
							else if (var31 == 10)
							{
								field1857[var12] = var26;
							}
							else
							{
								field1863[var12] = var26;
							}
						}
					}
				}

				var26 = 0;
				if (field1872[1] > 0 || field1872[2] > 0)
				{
					var26 = (field1877[1] + field1877[2]) / (field1872[1] + field1872[2]);
				}

				var7 = 0;
				if (field1872[3] > 0 || field1872[4] > 0)
				{
					var7 = (field1877[3] + field1877[4]) / (field1872[3] + field1872[4]);
				}

				var27 = 0;
				if (field1872[6] > 0 || field1872[8] > 0)
				{
					var27 = (field1877[8] + field1877[6]) / (field1872[8] + field1872[6]);
				}

				var10 = 0;
				var11 = field1872[10];
				int[] var28 = field1874[10];
				int[] var29 = field1857;
				if (var10 == var11)
				{
					var10 = 0;
					var11 = field1872[11];
					var28 = field1874[11];
					var29 = field1863;
				}

				if (var10 < var11)
				{
					var9 = var29[var10];
				}
				else
				{
					var9 = -1000;
				}

				for (var14 = 0; var14 < 10; ++var14)
				{
					while (var14 == 0 && var9 > var26)
					{
						this.method2706(graphics, var28[var10++]);
						if (var10 == var11 && var28 != field1874[11])
						{
							var10 = 0;
							var11 = field1872[11];
							var28 = field1874[11];
							var29 = field1863;
						}

						if (var10 < var11)
						{
							var9 = var29[var10];
						}
						else
						{
							var9 = -1000;
						}
					}

					while (var14 == 3 && var9 > var7)
					{
						this.method2706(graphics, var28[var10++]);
						if (var10 == var11 && var28 != field1874[11])
						{
							var10 = 0;
							var11 = field1872[11];
							var28 = field1874[11];
							var29 = field1863;
						}

						if (var10 < var11)
						{
							var9 = var29[var10];
						}
						else
						{
							var9 = -1000;
						}
					}

					while (var14 == 5 && var9 > var27)
					{
						this.method2706(graphics, var28[var10++]);
						if (var10 == var11 && var28 != field1874[11])
						{
							var10 = 0;
							var11 = field1872[11];
							var28 = field1874[11];
							var29 = field1863;
						}

						if (var10 < var11)
						{
							var9 = var29[var10];
						}
						else
						{
							var9 = -1000;
						}
					}

					var15 = field1872[var14];
					int[] var30 = field1874[var14];

					for (var17 = 0; var17 < var15; ++var17)
					{
						this.method2706(graphics, var30[var17]);
					}
				}

				while (var9 != -1000)
				{
					this.method2706(graphics, var28[var10++]);
					if (var10 == var11 && var28 != field1874[11])
					{
						var10 = 0;
						var28 = field1874[11];
						var11 = field1872[11];
						var29 = field1863;
					}

					if (var10 < var11)
					{
						var9 = var29[var10];
					}
					else
					{
						var9 = -1000;
					}
				}

			}
		}
	}

	private void method2706(Graphics3D graphics, int var1)
	{
		if (field1885[var1])
		{
			this.method2707(graphics, var1);
		}
		else
		{
			int var2 = this.indices1[var1];
			int var3 = this.indices2[var1];
			int var4 = this.indices3[var1];
			graphics.rasterClipEnable = field1887[var1];
			if (this.field1882 == null)
			{
				graphics.rasterAlpha = 0;
			}
			else
			{
				graphics.rasterAlpha = this.field1882[var1] & 255;
			}

			if (this.field1841 != null && this.field1841[var1] != -1)
			{
				int var5;
				int var6;
				int var7;
				if (this.field1840 != null && this.field1840[var1] != -1)
				{
					int var8 = this.field1840[var1] & 255;
					var5 = this.field1844[var8];
					var6 = this.field1865[var8];
					var7 = this.field1846[var8];
				}
				else
				{
					var5 = var2;
					var6 = var3;
					var7 = var4;
				}

				if (this.field1823[var1] == -1)
				{
					graphics.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1856[var1], this.field1856[var1], this.field1856[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1839[var5], field1839[var6], field1839[var7], field1869[var5], field1869[var6], field1869[var7], this.field1841[var1]);
				}
				else
				{
					graphics.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1856[var1], this.field1854[var1], this.field1823[var1], yViewportBuffer[var5], yViewportBuffer[var6], yViewportBuffer[var7], field1839[var5], field1839[var6], field1839[var7], field1869[var5], field1869[var6], field1869[var7], this.field1841[var1]);
				}
			}
			else if (this.field1823[var1] == -1)
			{
				int[] field1889 = graphics.colorPalette;
				graphics.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1889[this.field1856[var1]]);
			}
			else
			{
				graphics.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.field1856[var1], this.field1854[var1], this.field1823[var1]);
			}

		}
	}


	private void method2707(Graphics3D graphics, int var1)
	{
		int var2 = graphics.centerX;
		int var3 = graphics.centerY;
		int var4 = 0;
		int var5 = this.indices1[var1];
		int var6 = this.indices2[var1];
		int var7 = this.indices3[var1];
		int var8 = field1869[var5];
		int var9 = field1869[var6];
		int var10 = field1869[var7];
		if (this.field1882 == null)
		{
			graphics.rasterAlpha = 0;
		}
		else
		{
			graphics.rasterAlpha = this.field1882[var1] & 255;
		}

		int var11;
		int var12;
		int var13;
		int var14;
		if (var8 >= 50)
		{
			field1831[var4] = modelViewportYs[var5];
			field1837[var4] = modelViewportXs[var5];
			xViewportBuffer[var4++] = this.field1856[var1];
		}
		else
		{
			var11 = yViewportBuffer[var5];
			var12 = field1839[var5];
			var13 = this.field1856[var1];
			if (var10 >= 50)
			{
				var14 = field1890[var10 - var8] * (50 - var8);
				field1831[var4] = var2 + graphics.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
				field1837[var4] = var3 + graphics.Rasterizer3D_zoom * (var12 + ((field1839[var7] - var12) * var14 >> 16)) / 50;
				xViewportBuffer[var4++] = var13 + ((this.field1823[var1] - var13) * var14 >> 16);
			}

			if (var9 >= 50)
			{
				var14 = field1890[var9 - var8] * (50 - var8);
				field1831[var4] = var2 + graphics.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
				field1837[var4] = var3 + graphics.Rasterizer3D_zoom * (var12 + ((field1839[var6] - var12) * var14 >> 16)) / 50;
				xViewportBuffer[var4++] = var13 + ((this.field1854[var1] - var13) * var14 >> 16);
			}
		}

		if (var9 >= 50)
		{
			field1831[var4] = modelViewportYs[var6];
			field1837[var4] = modelViewportXs[var6];
			xViewportBuffer[var4++] = this.field1854[var1];
		}
		else
		{
			var11 = yViewportBuffer[var6];
			var12 = field1839[var6];
			var13 = this.field1854[var1];
			if (var8 >= 50)
			{
				var14 = field1890[var8 - var9] * (50 - var9);
				field1831[var4] = var2 + graphics.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
				field1837[var4] = var3 + graphics.Rasterizer3D_zoom * (var12 + ((field1839[var5] - var12) * var14 >> 16)) / 50;
				xViewportBuffer[var4++] = var13 + ((this.field1856[var1] - var13) * var14 >> 16);
			}

			if (var10 >= 50)
			{
				var14 = field1890[var10 - var9] * (50 - var9);
				field1831[var4] = var2 + graphics.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var7] - var11) * var14 >> 16)) / 50;
				field1837[var4] = var3 + graphics.Rasterizer3D_zoom * (var12 + ((field1839[var7] - var12) * var14 >> 16)) / 50;
				xViewportBuffer[var4++] = var13 + ((this.field1823[var1] - var13) * var14 >> 16);
			}
		}

		if (var10 >= 50)
		{
			field1831[var4] = modelViewportYs[var7];
			field1837[var4] = modelViewportXs[var7];
			xViewportBuffer[var4++] = this.field1823[var1];
		}
		else
		{
			var11 = yViewportBuffer[var7];
			var12 = field1839[var7];
			var13 = this.field1823[var1];
			if (var9 >= 50)
			{
				var14 = field1890[var9 - var10] * (50 - var10);
				field1831[var4] = var2 + graphics.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var6] - var11) * var14 >> 16)) / 50;
				field1837[var4] = var3 + graphics.Rasterizer3D_zoom * (var12 + ((field1839[var6] - var12) * var14 >> 16)) / 50;
				xViewportBuffer[var4++] = var13 + ((this.field1854[var1] - var13) * var14 >> 16);
			}

			if (var8 >= 50)
			{
				var14 = field1890[var8 - var10] * (50 - var10);
				field1831[var4] = var2 + graphics.Rasterizer3D_zoom * (var11 + ((yViewportBuffer[var5] - var11) * var14 >> 16)) / 50;
				field1837[var4] = var3 + graphics.Rasterizer3D_zoom * (var12 + ((field1839[var5] - var12) * var14 >> 16)) / 50;
				xViewportBuffer[var4++] = var13 + ((this.field1856[var1] - var13) * var14 >> 16);
			}
		}

		var11 = field1831[0];
		var12 = field1831[1];
		var13 = field1831[2];
		var14 = field1837[0];
		int var15 = field1837[1];
		int var16 = field1837[2];
		graphics.rasterClipEnable = false;
		int var17;
		int var18;
		int var19;
		int var20;
		if (var4 == 3)
		{
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > graphics.rasterClipX || var12 > graphics.rasterClipX || var13 > graphics.rasterClipX)
			{
				graphics.rasterClipEnable = true;
			}

			if (this.field1841 != null && this.field1841[var1] != -1)
			{
				if (this.field1840 != null && this.field1840[var1] != -1)
				{
					var20 = this.field1840[var1] & 255;
					var17 = this.field1844[var20];
					var18 = this.field1865[var20];
					var19 = this.field1846[var20];
				}
				else
				{
					var17 = var5;
					var18 = var6;
					var19 = var7;
				}

				if (this.field1823[var1] == -1)
				{
					graphics.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1856[var1], this.field1856[var1], this.field1856[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1839[var17], field1839[var18], field1839[var19], field1869[var17], field1869[var18], field1869[var19], this.field1841[var1]);
				}
				else
				{
					graphics.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1839[var17], field1839[var18], field1839[var19], field1869[var17], field1869[var18], field1869[var19], this.field1841[var1]);
				}
			}
			else if (this.field1823[var1] == -1)
			{
				int[] field1889 = graphics.colorPalette;
				graphics.rasterFlat(var14, var15, var16, var11, var12, var13, field1889[this.field1856[var1]]);
			}
			else
			{
				graphics.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
			}
		}

		if (var4 == 4)
		{
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > graphics.rasterClipX || var12 > graphics.rasterClipX || var13 > graphics.rasterClipX || field1831[3] < 0 || field1831[3] > graphics.rasterClipX)
			{
				graphics.rasterClipEnable = true;
			}

			if (this.field1841 != null && this.field1841[var1] != -1)
			{
				if (this.field1840 != null && this.field1840[var1] != -1)
				{
					var20 = this.field1840[var1] & 255;
					var17 = this.field1844[var20];
					var18 = this.field1865[var20];
					var19 = this.field1846[var20];
				}
				else
				{
					var17 = var5;
					var18 = var6;
					var19 = var7;
				}

				short var21 = this.field1841[var1];
				if (this.field1823[var1] == -1)
				{
					graphics.rasterTextureAffine(var14, var15, var16, var11, var12, var13, this.field1856[var1], this.field1856[var1], this.field1856[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1839[var17], field1839[var18], field1839[var19], field1869[var17], field1869[var18], field1869[var19], var21);
					graphics.rasterTextureAffine(var14, var16, field1837[3], var11, var13, field1831[3], this.field1856[var1], this.field1856[var1], this.field1856[var1], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1839[var17], field1839[var18], field1839[var19], field1869[var17], field1869[var18], field1869[var19], var21);
				}
				else
				{
					graphics.rasterTextureAffine(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1839[var17], field1839[var18], field1839[var19], field1869[var17], field1869[var18], field1869[var19], var21);
					graphics.rasterTextureAffine(var14, var16, field1837[3], var11, var13, field1831[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[var17], yViewportBuffer[var18], yViewportBuffer[var19], field1839[var17], field1839[var18], field1839[var19], field1869[var17], field1869[var18], field1869[var19], var21);
				}
			}
			else if (this.field1823[var1] == -1)
			{
				int[] field1889 = graphics.colorPalette;
				var17 = field1889[this.field1856[var1]];
				graphics.rasterFlat(var14, var15, var16, var11, var12, var13, var17);
				graphics.rasterFlat(var14, var16, field1837[3], var11, var13, field1831[3], var17);
			}
			else
			{
				graphics.rasterGouraud(var14, var15, var16, var11, var12, var13, xViewportBuffer[0], xViewportBuffer[1], xViewportBuffer[2]);
				graphics.rasterGouraud(var14, var16, field1837[3], var11, var13, field1831[3], xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3]);
			}
		}

	}
}