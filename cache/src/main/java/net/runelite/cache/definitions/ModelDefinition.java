package net.runelite.cache.definitions;

import net.runelite.cache.models.FaceNormal;
import net.runelite.cache.models.VertexNormal;

public class ModelDefinition
{
	public int id;

	public int vertexCount = 0;
	public int[] vertexPositionsX;
	public int[] vertexPositionsY;
	public int[] vertexPositionsZ;
	public transient VertexNormal[] vertexNormals;

	public int faceCount;
	public int[] faceVertexIndices1;
	public int[] faceVertexIndices2;
	public int[] faceVertexIndices3;
	public byte[] faceAlphas;
	public short[] faceColors;
	public byte[] faceRenderPriorities;
	public byte[] faceRenderTypes;
	public transient FaceNormal[] faceNormals;

	public int textureTriangleCount;
	public short[] textureTriangleVertexIndices1;
	public short[] textureTriangleVertexIndices2;
	public short[] textureTriangleVertexIndices3;
	public short[] texturePrimaryColors;
	public short[] faceTextures;
	public byte[] textureCoordinates;
	public byte[] textureRenderTypes;

	public int[] vertexSkins;
	public int[] triangleSkinValues;

	public byte priority;
	public int shadowIntensity;

	public int anInt2562;
	public short aShort2565;
	boolean aBool2579;
	public short[] aShortArray2574;
	public short[] aShortArray2575;
	public short[] aShortArray2577;
	public short[] aShortArray2578;
	public byte[] aByteArray2580;
	public int[][] anIntArrayArray2583;
	public int[][] anIntArrayArray2584;
	public short[] aShortArray2586;
	public short aShort2589;
	public int anInt2592;
	public int anInt2593;
	public int anInt2595;

	public void computeNormals()
	{
		if (this.vertexNormals != null)
		{
			return;
		}

		this.vertexNormals = new VertexNormal[this.vertexCount];

		int var1;
		for (var1 = 0; var1 < this.vertexCount; ++var1)
		{
			this.vertexNormals[var1] = new VertexNormal();
		}

		for (var1 = 0; var1 < this.faceCount; ++var1)
		{
			int vertexA = this.faceVertexIndices1[var1];
			int vertexB = this.faceVertexIndices2[var1];
			int vertexC = this.faceVertexIndices3[var1];

			int xA = this.vertexPositionsX[vertexB] - this.vertexPositionsX[vertexA];
			int yA = this.vertexPositionsY[vertexB] - this.vertexPositionsY[vertexA];
			int zA = this.vertexPositionsZ[vertexB] - this.vertexPositionsZ[vertexA];

			int xB = this.vertexPositionsX[vertexC] - this.vertexPositionsX[vertexA];
			int yB = this.vertexPositionsY[vertexC] - this.vertexPositionsY[vertexA];
			int zB = this.vertexPositionsZ[vertexC] - this.vertexPositionsZ[vertexA];

			// Compute cross product
			int var11 = yA * zB - yB * zA;
			int var12 = zA * xB - zB * xA;
			int var13 = xA * yB - xB * yA;

			while (var11 > 8192 || var12 > 8192 || var13 > 8192 || var11 < -8192 || var12 < -8192 || var13 < -8192)
			{
				var11 >>= 1;
				var12 >>= 1;
				var13 >>= 1;
			}

			int length = (int) Math.sqrt((double) (var11 * var11 + var12 * var12 + var13 * var13));
			if (length <= 0)
			{
				length = 1;
			}

			var11 = var11 * 256 / length;
			var12 = var12 * 256 / length;
			var13 = var13 * 256 / length;

			byte var15;
			if (this.faceRenderTypes == null)
			{
				var15 = 0;
			}
			else
			{
				var15 = this.faceRenderTypes[var1];
			}

			if (var15 == 0)
			{
				VertexNormal var16 = this.vertexNormals[vertexA];
				var16.x += var11;
				var16.y += var12;
				var16.z += var13;
				++var16.magnitude;

				var16 = this.vertexNormals[vertexB];
				var16.x += var11;
				var16.y += var12;
				var16.z += var13;
				++var16.magnitude;

				var16 = this.vertexNormals[vertexC];
				var16.x += var11;
				var16.y += var12;
				var16.z += var13;
				++var16.magnitude;
			}
			else if (var15 == 1)
			{
				if (this.faceNormals == null)
				{
					this.faceNormals = new FaceNormal[this.faceCount];
				}

				FaceNormal var17 = this.faceNormals[var1] = new FaceNormal();
				var17.x = var11;
				var17.y = var12;
				var17.z = var13;
			}
		}
	}

}
