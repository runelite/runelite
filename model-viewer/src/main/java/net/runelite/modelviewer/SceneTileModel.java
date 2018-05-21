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
package net.runelite.modelviewer;

import lombok.Getter;

@Getter
public class SceneTileModel
{
	private static final int[][] TILE_VERTICES;
	private static final int[][] TILE_FACES;

	private static final int TILE_SIZE = 128;
	private static final int HALF_TILE_SIZE = TILE_SIZE / 2;
	private static final int QUARTER_TILE_SIZE = TILE_SIZE / 4;
	private static final int THREE_QUARTER_TILE_SIZE = TILE_SIZE * 3 / 4;

	final int[] vertexX;
	final int[] vertexY;
	final int[] vertexZ;

	private final int[] var26;
	private final int[] var27;

	final int[] faceX;
	final int[] faceY;
	final int[] faceZ;

	final int[] triangleColorA;
	final int[] triangleColorB;
	final int[] triangleColorC;

	int[] triangleTextureId;

	static
	{

		TILE_VERTICES = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
		TILE_FACES = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};
	}

	public SceneTileModel(int shape, int overlayRott, int texture, int x, int y,
		int tileHeight, int tileHeightX1, int tileHeightX1Y1, int tileHeightY1,
		int var10, int var11, int var12, int var13,
		int var14, int var15, int var16, int var17,
		int var18, int var19)
	{
		final int[] vertexInfo = TILE_VERTICES[shape];
		final int vertexInfoLength = vertexInfo.length;

		vertexX = new int[vertexInfoLength];
		vertexY = new int[vertexInfoLength];
		vertexZ = new int[vertexInfoLength];
		var26 = new int[vertexInfoLength];
		var27 = new int[vertexInfoLength];

		final int tileBaseX = x * TILE_SIZE;
		final int tileBaseY = y * TILE_SIZE;

		for (int idx = 0; idx < vertexInfoLength; ++idx)
		{
			int curInfo = vertexInfo[idx];
			if ((curInfo & 1) == 0 && curInfo <= 8)
			{
				curInfo = (curInfo - overlayRott - overlayRott - 1 & 7) + 1;
			}

			if (curInfo > 8 && curInfo <= 12)
			{
				curInfo = (curInfo - 9 - overlayRott & 3) + 9;
			}

			if (curInfo > 12 && curInfo <= 16)
			{
				curInfo = (curInfo - 13 - overlayRott & 3) + 13;
			}

			int vertexX, vertexY, vertexZ;
			int var35, var36;

			if (curInfo == 1)
			{
				vertexX = tileBaseX;
				vertexZ = tileBaseY;
				vertexY = tileHeight;
				var35 = var10;
				var36 = var14;
			}
			else if (curInfo == 2)
			{
				vertexX = tileBaseX + HALF_TILE_SIZE;
				vertexZ = tileBaseY;
				vertexY = tileHeightX1 + tileHeight >> 1;
				var35 = var11 + var10 >> 1;
				var36 = var15 + var14 >> 1;
			}
			else if (curInfo == 3)
			{
				vertexX = tileBaseX + TILE_SIZE;
				vertexZ = tileBaseY;
				vertexY = tileHeightX1;
				var35 = var11;
				var36 = var15;
			}
			else if (curInfo == 4)
			{
				vertexX = tileBaseX + TILE_SIZE;
				vertexZ = tileBaseY + HALF_TILE_SIZE;
				vertexY = tileHeightX1Y1 + tileHeightX1 >> 1;
				var35 = var11 + var12 >> 1;
				var36 = var15 + var16 >> 1;
			}
			else if (curInfo == 5)
			{
				vertexX = tileBaseX + TILE_SIZE;
				vertexZ = tileBaseY + TILE_SIZE;
				vertexY = tileHeightX1Y1;
				var35 = var12;
				var36 = var16;
			}
			else if (curInfo == 6)
			{
				vertexX = tileBaseX + HALF_TILE_SIZE;
				vertexZ = tileBaseY + TILE_SIZE;
				vertexY = tileHeightX1Y1 + tileHeightY1 >> 1;
				var35 = var13 + var12 >> 1;
				var36 = var17 + var16 >> 1;
			}
			else if (curInfo == 7)
			{
				vertexX = tileBaseX;
				vertexZ = tileBaseY + TILE_SIZE;
				vertexY = tileHeightY1;
				var35 = var13;
				var36 = var17;
			}
			else if (curInfo == 8)
			{
				vertexX = tileBaseX;
				vertexZ = tileBaseY + HALF_TILE_SIZE;
				vertexY = tileHeightY1 + tileHeight >> 1;
				var35 = var13 + var10 >> 1;
				var36 = var17 + var14 >> 1;
			}
			else if (curInfo == 9)
			{
				vertexX = tileBaseX + HALF_TILE_SIZE;
				vertexZ = tileBaseY + QUARTER_TILE_SIZE;
				vertexY = tileHeightX1 + tileHeight >> 1;
				var35 = var11 + var10 >> 1;
				var36 = var15 + var14 >> 1;
			}
			else if (curInfo == 10)
			{
				vertexX = tileBaseX + THREE_QUARTER_TILE_SIZE;
				vertexZ = tileBaseY + HALF_TILE_SIZE;
				vertexY = tileHeightX1Y1 + tileHeightX1 >> 1;
				var35 = var11 + var12 >> 1;
				var36 = var15 + var16 >> 1;
			}
			else if (curInfo == 11)
			{
				vertexX = tileBaseX + HALF_TILE_SIZE;
				vertexZ = tileBaseY + THREE_QUARTER_TILE_SIZE;
				vertexY = tileHeightX1Y1 + tileHeightY1 >> 1;
				var35 = var13 + var12 >> 1;
				var36 = var17 + var16 >> 1;
			}
			else if (curInfo == 12)
			{
				vertexX = tileBaseX + QUARTER_TILE_SIZE;
				vertexZ = tileBaseY + HALF_TILE_SIZE;
				vertexY = tileHeightY1 + tileHeight >> 1;
				var35 = var13 + var10 >> 1;
				var36 = var17 + var14 >> 1;
			}
			else if (curInfo == 13)
			{
				vertexX = tileBaseX + QUARTER_TILE_SIZE;
				vertexZ = tileBaseY + QUARTER_TILE_SIZE;
				vertexY = tileHeight;
				var35 = var10;
				var36 = var14;
			}
			else if (curInfo == 14)
			{
				vertexX = tileBaseX + THREE_QUARTER_TILE_SIZE;
				vertexZ = tileBaseY + QUARTER_TILE_SIZE;
				vertexY = tileHeightX1;
				var35 = var11;
				var36 = var15;
			}
			else if (curInfo == 15)
			{
				vertexX = tileBaseX + THREE_QUARTER_TILE_SIZE;
				vertexZ = tileBaseY + THREE_QUARTER_TILE_SIZE;
				vertexY = tileHeightX1Y1;
				var35 = var12;
				var36 = var16;
			}
			else
			{
				vertexX = tileBaseX + QUARTER_TILE_SIZE;
				vertexZ = tileBaseY + THREE_QUARTER_TILE_SIZE;
				vertexY = tileHeightY1;
				var35 = var13;
				var36 = var17;
			}

			this.vertexX[idx] = vertexX;
			this.vertexY[idx] = vertexY;
			this.vertexZ[idx] = vertexZ;
			var26[idx] = var35;
			var27[idx] = var36;
		}

		final int[] faceInfo = TILE_FACES[shape];
		final int faceInfoLength = faceInfo.length / 4;

		faceX = new int[faceInfoLength];
		faceY = new int[faceInfoLength];
		faceZ = new int[faceInfoLength];

		triangleColorA = new int[faceInfoLength];
		triangleColorB = new int[faceInfoLength];
		triangleColorC = new int[faceInfoLength];

		if (texture != -1)
		{
			triangleTextureId = new int[faceInfoLength];
		}

		int offset = 0;
		for (int idx = 0; idx < faceInfoLength; ++idx)
		{
			int var = faceInfo[offset];
			int faceX = faceInfo[offset + 1];
			int faceY = faceInfo[offset + 2];
			int faceZ = faceInfo[offset + 3];
			offset += 4;

			if (faceX < 4)
			{
				faceX = faceX - overlayRott & 3;
			}

			if (faceY < 4)
			{
				faceY = faceY - overlayRott & 3;
			}

			if (faceZ < 4)
			{
				faceZ = faceZ - overlayRott & 3;
			}

			this.faceX[idx] = faceX;
			this.faceY[idx] = faceY;
			this.faceZ[idx] = faceZ;

			if (var == 0)
			{
				this.triangleColorA[idx] = var26[faceX];
				this.triangleColorB[idx] = var26[faceY];
				this.triangleColorC[idx] = var26[faceZ];
				if (this.triangleTextureId != null)
				{
					this.triangleTextureId[idx] = -1;
				}
			}
			else
			{
				this.triangleColorA[idx] = var27[faceX];
				this.triangleColorB[idx] = var27[faceY];
				this.triangleColorC[idx] = var27[faceZ];
				if (this.triangleTextureId != null)
				{
					this.triangleTextureId[idx] = texture;
				}
			}
		}
	}
}
