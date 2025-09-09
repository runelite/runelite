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
	boolean[] faceClipped = new boolean[6500];
	int[] modelViewportYs = new int[6500];
	int[] modelViewportXs = new int[6500];
	int[] modelViewportZs = new int[6500];
	int[] modelLocalX = new int[6500];
	int[] modelLocalY = new int[6500];
	int[] modelLocalZ = new int[6500];
	int[] distanceFaceCount = new int[6000];
	int[][] facesByDistance = new int[6000][512];
	int[] numOfPriority = new int[12];
	int[][] orderedFaces = new int[12][2000];
	int[] eq10 = new int[2000];
	int[] eq11 = new int[2000];
	int[] lt10 = new int[12];
	static int[] Model_sine;
	static int[] Model_cosine;
	int verticesCount;
	int[] verticesX;
	int[] verticesY;
	int[] verticesZ;
	int indicesCount;
	int[] indices1;
	int[] indices2;
	int[] indices3;
	int[] faceColors1;
	int[] faceColors2;
	int[] faceColors3;
	byte[] facePriorities;
	byte[] faceTransparencies;
	byte[] textureCoords;
	short[] faceTextures;
	int numTextureFaces;
	int[] texIndices1;
	int[] texIndices2;
	int[] texIndices3;
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
	}

	Model()
	{
		this.verticesCount = 0;
		this.indicesCount = 0;
		this.numTextureFaces = 0;
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

	public final void projectAndDraw(Graphics3D graphics, int yzRotation, int xzRotation, int xyRotation, int orientation, int xOffset, int yOffset, int zOffset)
	{
		distanceFaceCount[0] = -1;
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
		int sinX = Model_sine[orientation];
		int cosX = Model_cosine[orientation];
		int zRelatedVariable = sinX * yOffset + cosX * zOffset >> 16;

		for (int i = 0; i < this.verticesCount; ++i)
		{
			int x = this.verticesX[i];
			int y = this.verticesY[i];
			int z = this.verticesZ[i];
			if (xyRotation != 0)
			{
				int sinZ = Model_sine[xyRotation];
				int cosZ = Model_cosine[xyRotation];
				int tmp;
				tmp = y * sinZ + x * cosZ >> 16;
				y = y * cosZ - x * sinZ >> 16;
				x = tmp;
			}

			if (yzRotation != 0)
			{
				int sinR1 = Model_sine[yzRotation];
				int cosR1 = Model_cosine[yzRotation];
				int tmp;
				tmp = y * cosR1 - z * sinR1 >> 16;
				z = y * sinR1 + z * cosR1 >> 16;
				y = tmp;
			}

			if (xzRotation != 0)
			{
				int sinY = Model_sine[xzRotation];
				int cosY = Model_cosine[xzRotation];
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
			if (faceTextures != null)
			{
				modelLocalX[i] = x;
				modelLocalY[i] = tmp;
				modelLocalZ[i] = z;
			}
		}

		this.draw(graphics);
	}

	private void draw(Graphics3D graphics)
	{
		if (this.diameter < 6000)
		{
			for (int var5 = 0; var5 < this.diameter; ++var5)
			{
				distanceFaceCount[var5] = 0;
			}

			int var7;
			int var9;
			int var10;
			int var11;
			int var12;
			int var13;
			int var14;
			int var15;
			int var17;
			int var27;

			int var26;
			for (var26 = 0; var26 < this.indicesCount; ++var26)
			{
				if (this.faceColors3[var26] != -2)
				{
					var7 = this.indices1[var26];
					var27 = this.indices2[var26];
					var9 = this.indices3[var26];
					var10 = modelViewportYs[var7];
					var11 = modelViewportYs[var27];
					var12 = modelViewportYs[var9];

					if ((var10 - var11) * (modelViewportXs[var9] - modelViewportXs[var27]) - (var12 - var11) * (modelViewportXs[var7] - modelViewportXs[var27]) > 0)
					{
						if (var10 >= 0 && var11 >= 0 && var12 >= 0 && var10 <= graphics.rasterClipX && var11 <= graphics.rasterClipX && var12 <= graphics.rasterClipX)
						{
							faceClipped[var26] = false;
						}
						else
						{
							faceClipped[var26] = true;
						}

						var13 = (modelViewportZs[var7] + modelViewportZs[var27] + modelViewportZs[var9]) / 3 + this.radius;
						facesByDistance[var13][distanceFaceCount[var13]++] = var26;
					}
				}
			}

			int[] var8;
			if (this.facePriorities == null)
			{
				for (var26 = this.diameter - 1; var26 >= 0; --var26)
				{
					var7 = distanceFaceCount[var26];
					if (var7 > 0)
					{
						var8 = facesByDistance[var26];

						for (var9 = 0; var9 < var7; ++var9)
						{
							this.rasterFace(graphics, var8[var9]);
						}
					}
				}

			}
			else
			{
				for (var26 = 0; var26 < 12; ++var26)
				{
					numOfPriority[var26] = 0;
					lt10[var26] = 0;
				}

				for (var26 = this.diameter - 1; var26 >= 0; --var26)
				{
					var7 = distanceFaceCount[var26];
					if (var7 > 0)
					{
						var8 = facesByDistance[var26];

						for (var9 = 0; var9 < var7; ++var9)
						{
							var10 = var8[var9];
							byte var31 = this.facePriorities[var10];
							var12 = numOfPriority[var31]++;
							orderedFaces[var31][var12] = var10;
							if (var31 < 10)
							{
								lt10[var31] += var26;
							}
							else if (var31 == 10)
							{
								eq10[var12] = var26;
							}
							else
							{
								eq11[var12] = var26;
							}
						}
					}
				}

				var26 = 0;
				if (numOfPriority[1] > 0 || numOfPriority[2] > 0)
				{
					var26 = (lt10[1] + lt10[2]) / (numOfPriority[1] + numOfPriority[2]);
				}

				var7 = 0;
				if (numOfPriority[3] > 0 || numOfPriority[4] > 0)
				{
					var7 = (lt10[3] + lt10[4]) / (numOfPriority[3] + numOfPriority[4]);
				}

				var27 = 0;
				if (numOfPriority[6] > 0 || numOfPriority[8] > 0)
				{
					var27 = (lt10[8] + lt10[6]) / (numOfPriority[8] + numOfPriority[6]);
				}

				var10 = 0;
				var11 = numOfPriority[10];
				int[] var28 = orderedFaces[10];
				int[] var29 = eq10;
				if (var10 == var11)
				{
					var10 = 0;
					var11 = numOfPriority[11];
					var28 = orderedFaces[11];
					var29 = eq11;
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
						this.rasterFace(graphics, var28[var10++]);
						if (var10 == var11 && var28 != orderedFaces[11])
						{
							var10 = 0;
							var11 = numOfPriority[11];
							var28 = orderedFaces[11];
							var29 = eq11;
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
						this.rasterFace(graphics, var28[var10++]);
						if (var10 == var11 && var28 != orderedFaces[11])
						{
							var10 = 0;
							var11 = numOfPriority[11];
							var28 = orderedFaces[11];
							var29 = eq11;
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
						this.rasterFace(graphics, var28[var10++]);
						if (var10 == var11 && var28 != orderedFaces[11])
						{
							var10 = 0;
							var11 = numOfPriority[11];
							var28 = orderedFaces[11];
							var29 = eq11;
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

					var15 = numOfPriority[var14];
					int[] var30 = orderedFaces[var14];

					for (var17 = 0; var17 < var15; ++var17)
					{
						this.rasterFace(graphics, var30[var17]);
					}
				}

				while (var9 != -1000)
				{
					this.rasterFace(graphics, var28[var10++]);
					if (var10 == var11 && var28 != orderedFaces[11])
					{
						var10 = 0;
						var28 = orderedFaces[11];
						var11 = numOfPriority[11];
						var29 = eq11;
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

	private void rasterFace(Graphics3D graphics, int face)
	{
		int var2 = this.indices1[face];
		int var3 = this.indices2[face];
		int var4 = this.indices3[face];
		graphics.rasterClipEnable = faceClipped[face];
		if (this.faceTransparencies == null)
		{
			graphics.rasterAlpha = 0;
		}
		else
		{
			graphics.rasterAlpha = this.faceTransparencies[face] & 255;
		}

		if (this.faceTextures != null && this.faceTextures[face] != -1)
		{
			int var5;
			int var6;
			int var7;
			if (this.textureCoords != null && this.textureCoords[face] != -1)
			{
				int var8 = this.textureCoords[face] & 255;
				var5 = this.texIndices1[var8];
				var6 = this.texIndices2[var8];
				var7 = this.texIndices3[var8];
			}
			else
			{
				var5 = var2;
				var6 = var3;
				var7 = var4;
			}

			if (this.faceColors3[face] == -1)
			{
				graphics.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.faceColors1[face], this.faceColors1[face], this.faceColors1[face], modelLocalX[var5], modelLocalX[var6], modelLocalX[var7], modelLocalY[var5], modelLocalY[var6], modelLocalY[var7], modelLocalZ[var5], modelLocalZ[var6], modelLocalZ[var7], this.faceTextures[face]);
			}
			else
			{
				graphics.rasterTextureAffine(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.faceColors1[face], this.faceColors2[face], this.faceColors3[face], modelLocalX[var5], modelLocalX[var6], modelLocalX[var7], modelLocalY[var5], modelLocalY[var6], modelLocalY[var7], modelLocalZ[var5], modelLocalZ[var6], modelLocalZ[var7], this.faceTextures[face]);
			}
		}
		else if (this.faceColors3[face] == -1)
		{
			int[] field1889 = graphics.colorPalette;
			graphics.rasterFlat(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], field1889[this.faceColors1[face]]);
		}
		else
		{
			graphics.rasterGouraud(modelViewportXs[var2], modelViewportXs[var3], modelViewportXs[var4], modelViewportYs[var2], modelViewportYs[var3], modelViewportYs[var4], this.faceColors1[face], this.faceColors2[face], this.faceColors3[face]);
		}
	}
}