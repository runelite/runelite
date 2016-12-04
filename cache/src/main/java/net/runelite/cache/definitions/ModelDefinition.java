package net.runelite.cache.definitions;

import net.runelite.cache.models.FaceNormal;
import net.runelite.cache.models.VertexNormal;

public class ModelDefinition
{
	public short[] texTriangleX;
	public int[] vertexX;
	public byte[] faceRenderPriorities;
	public int[] vertexY;
	public int triangleFaceCount;
	public int[] trianglePointsX;
	public int[] vertexSkins;
	public int[] trianglePointsZ;
	public int anInt2562;
	public int[] trianglePointsY;
	public byte[] faceAlphas;
	public short aShort2565;
	public byte[] faceRenderType;
	public short[] faceTextures;
	public byte priority;
	public int anInt2569;
	public byte[] textureRenderTypes;
	public short[] texTriangleY;
	public short[] texTriangleZ;
	public short[] aShortArray2574;
	public short[] aShortArray2575;
	public short[] aShortArray2577;
	public short[] aShortArray2578;
	boolean aBool2579;
	public byte[] aByteArray2580;
	public byte[] textureCoords;
	public int[] triangleSkinValues;
	public int[][] anIntArrayArray2583;
	public int[][] anIntArrayArray2584;
	public short[] aShortArray2586;
	public short aShort2589;
	public short[] faceColor;
	public int shadowIntensity;
	public int anInt2592;
	public int anInt2593;
	public int[] vertexZ;
	public int anInt2595;
	public int vertexCount = 0;
	public short[] texturePrimaryColor;
	public VertexNormal[] normals;
	public FaceNormal[] faceNormals;

	public void computeNormals()
	{
		if (this.normals != null)
		{
			return;
		}

		this.normals = new VertexNormal[this.vertexCount];

		int var1;
		for (var1 = 0; var1 < this.vertexCount; ++var1)
		{
			this.normals[var1] = new VertexNormal();
		}

		for (var1 = 0; var1 < this.triangleFaceCount; ++var1)
		{
			int vertexA = this.trianglePointsX[var1];
			int vertexB = this.trianglePointsY[var1];
			int vertexC = this.trianglePointsZ[var1];

			int xA = this.vertexX[vertexB] - this.vertexX[vertexA];
			int yA = this.vertexY[vertexB] - this.vertexY[vertexA];
			int zA = this.vertexZ[vertexB] - this.vertexZ[vertexA];

			int xB = this.vertexX[vertexC] - this.vertexX[vertexA];
			int yB = this.vertexY[vertexC] - this.vertexY[vertexA];
			int zB = this.vertexZ[vertexC] - this.vertexZ[vertexA];

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
			if (this.faceRenderType == null)
			{
				var15 = 0;
			}
			else
			{
				var15 = this.faceRenderType[var1];
			}

			if (var15 == 0)
			{
				VertexNormal var16 = this.normals[vertexA];
				var16.x += var11;
				var16.y += var12;
				var16.z += var13;
				++var16.magnitude;

				var16 = this.normals[vertexB];
				var16.x += var11;
				var16.y += var12;
				var16.z += var13;
				++var16.magnitude;

				var16 = this.normals[vertexC];
				var16.x += var11;
				var16.y += var12;
				var16.z += var13;
				++var16.magnitude;
			}
			else if (var15 == 1)
			{
				if (this.faceNormals == null)
				{
					this.faceNormals = new FaceNormal[this.triangleFaceCount];
				}

				FaceNormal var17 = this.faceNormals[var1] = new FaceNormal();
				var17.x = var11;
				var17.y = var12;
				var17.z = var13;
			}
		}
	}

}
