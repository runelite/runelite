package net.runelite.cache.definitions;

import java.util.Arrays;
import lombok.Data;
import net.runelite.cache.models.CircularAngle;
import net.runelite.cache.models.FaceNormal;
import net.runelite.cache.models.VertexNormal;

@Data
public class ModelDefinition
{
	public int id;

	public int vertexCount = 0;
	public int[] vertexX;
	public int[] vertexY;
	public int[] vertexZ;
	public transient VertexNormal[] vertexNormals;

	public int faceCount;
	public int[] faceIndices1;
	public int[] faceIndices2;
	public int[] faceIndices3;
	public byte[] faceTransparencies;
	public short[] faceColors;
	public byte[] faceRenderPriorities;
	public byte[] faceRenderTypes;
	public transient FaceNormal[] faceNormals;

	public int numTextureFaces;
	public short[] texIndices1;
	public short[] texIndices2;
	public short[] texIndices3;
	public transient float[][] faceTextureUCoordinates;
	public transient float[][] faceTextureVCoordinates;
	public short[] texturePrimaryColors;
	public short[] faceTextures;
	public byte[] textureCoords;
	public byte[] textureRenderTypes;

	public int[] packedVertexGroups;
	public int[] packedTransparencyVertexGroups;

	public byte priority;

	private transient int[][] vertexGroups;
	public int[][] animayaGroups;
	public int[][] animayaScales;

	private transient int[] origVX;
	private transient int[] origVY;
	private transient int[] origVZ;

	public transient int maxPriority;

	public static transient int animOffsetX, animOffsetY, animOffsetZ;

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
			int vertexA = this.faceIndices1[var1];
			int vertexB = this.faceIndices2[var1];
			int vertexC = this.faceIndices3[var1];

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

	public void computeTextureUVCoordinates()
	{
		this.faceTextureUCoordinates = new float[faceCount][];
		this.faceTextureVCoordinates = new float[faceCount][];

		if (faceTextures == null)
		{
			return;
		}

		for (int i = 0; i < faceCount; i++)
		{
			if (faceTextures[i] == -1)
			{
				continue;
			}

			float u0, u1, u2, v0, v1, v2;

			if (textureCoords != null && textureCoords[i] != -1)
			{
				int tfaceIdx = textureCoords[i] & 0xff;
				int triangleA = faceIndices1[i];
				int triangleB = faceIndices2[i];
				int triangleC = faceIndices3[i];
				int texA = texIndices1[tfaceIdx];
				int texB = texIndices2[tfaceIdx];
				int texC = texIndices3[tfaceIdx];

				// v1 = vertex[texA]
				float v1x = (float) vertexX[texA];
				float v1y = (float) vertexY[texA];
				float v1z = (float) vertexZ[texA];
				// v2 = vertex[texB] - v1
				float v2x = (float) vertexX[texB] - v1x;
				float v2y = (float) vertexY[texB] - v1y;
				float v2z = (float) vertexZ[texB] - v1z;
				// v3 = vertex[texC] - v1
				float v3x = (float) vertexX[texC] - v1x;
				float v3y = (float) vertexY[texC] - v1y;
				float v3z = (float) vertexZ[texC] - v1z;

				// v4 = vertex[triangleA] - v1
				float v4x = (float) vertexX[triangleA] - v1x;
				float v4y = (float) vertexY[triangleA] - v1y;
				float v4z = (float) vertexZ[triangleA] - v1z;
				// v5 = vertex[triangleB] - v1
				float v5x = (float) vertexX[triangleB] - v1x;
				float v5y = (float) vertexY[triangleB] - v1y;
				float v5z = (float) vertexZ[triangleB] - v1z;
				// v6 = vertex[triangleC] - v1
				float v6x = (float) vertexX[triangleC] - v1x;
				float v6y = (float) vertexY[triangleC] - v1y;
				float v6z = (float) vertexZ[triangleC] - v1z;

				// v7 = v2 x v3
				float v7x = v2y * v3z - v2z * v3y;
				float v7y = v2z * v3x - v2x * v3z;
				float v7z = v2x * v3y - v2y * v3x;

				// v8 = v3 x v7
				float v8x = v3y * v7z - v3z * v7y;
				float v8y = v3z * v7x - v3x * v7z;
				float v8z = v3x * v7y - v3y * v7x;

				// f = 1 / (v8 ⋅ v2)
				float f = 1.0F / (v8x * v2x + v8y * v2y + v8z * v2z);

				// u0 = (v8 ⋅ v4) * f
				u0 = (v8x * v4x + v8y * v4y + v8z * v4z) * f;
				// u1 = (v8 ⋅ v5) * f
				u1 = (v8x * v5x + v8y * v5y + v8z * v5z) * f;
				// u2 = (v8 ⋅ v6) * f
				u2 = (v8x * v6x + v8y * v6y + v8z * v6z) * f;

				// v8 = v2 x v7
				v8x = v2y * v7z - v2z * v7y;
				v8y = v2z * v7x - v2x * v7z;
				v8z = v2x * v7y - v2y * v7x;

				// f = 1 / (v8 ⋅ v3)
				f = 1.0F / (v8x * v3x + v8y * v3y + v8z * v3z);

				// v0 = (v8 ⋅ v4) * f
				v0 = (v8x * v4x + v8y * v4y + v8z * v4z) * f;
				// v1 = (v8 ⋅ v5) * f
				v1 = (v8x * v5x + v8y * v5y + v8z * v5z) * f;
				// v2 = (v8 ⋅ v6) * f
				v2 = (v8x * v6x + v8y * v6y + v8z * v6z) * f;
			}
			else
			{
				// Without a texture face, the client assigns tex = triangle, but the resulting
				// calculations can be reduced:
				//
				// v1 = vertex[texA]
				// v2 = vertex[texB] - v1
				// v3 = vertex[texC] - v1
				//
				// v4 = 0
				// v5 = v2
				// v6 = v3
				//
				// v7 = v2 x v3
				//
				// v8 = v3 x v7
				// u0 = (v8 . v4) / (v8 . v2) // 0 because v4 is 0
				// u1 = (v8 . v5) / (v8 . v2) // 1 because v5=v2
				// u2 = (v8 . v6) / (v8 . v2) // 0 because v8 is perpendicular to v3/v6
				//
				// v8 = v2 x v7
				// v0 = (v8 . v4) / (v8 ⋅ v3) // 0 because v4 is 0
				// v1 = (v8 . v5) / (v8 ⋅ v3) // 0 because v8 is perpendicular to v5/v2
				// v2 = (v8 . v6) / (v8 ⋅ v3) // 1 because v6=v3

				u0 = 0f;
				v0 = 0f;

				u1 = 1f;
				v1 = 0f;

				u2 = 0f;
				v2 = 1f;
			}

			this.faceTextureUCoordinates[i] = new float[]{u0, u1, u2};
			this.faceTextureVCoordinates[i] = new float[]{v0, v1, v2};
		}
	}

	public void computeAnimationTables()
	{
		if (this.packedVertexGroups != null)
		{
			int[] groupCounts = new int[256];
			int numGroups = 0;
			int var3, var4;

			for (var3 = 0; var3 < this.vertexCount; ++var3)
			{
				var4 = this.packedVertexGroups[var3];
				++groupCounts[var4];
				if (var4 > numGroups)
				{
					numGroups = var4;
				}
			}

			this.vertexGroups = new int[numGroups + 1][];

			for (var3 = 0; var3 <= numGroups; ++var3)
			{
				this.vertexGroups[var3] = new int[groupCounts[var3]];
				groupCounts[var3] = 0;
			}

			for (var3 = 0; var3 < this.vertexCount; this.vertexGroups[var4][groupCounts[var4]++] = var3++)
			{
				var4 = this.packedVertexGroups[var3];
			}

			this.packedVertexGroups = null;
		}

		// triangleSkinValues is here
	}

	public void rotate(int orientation)
	{
		int sin = CircularAngle.SINE[orientation];
		int cos = CircularAngle.COSINE[orientation];

		assert vertexX.length == vertexY.length;
		assert vertexY.length == vertexZ.length;

		for (int i = 0; i < vertexX.length; ++i)
		{
			vertexX[i] = vertexX[i] * cos + vertexZ[i] * sin >> 16;
			vertexZ[i] = vertexZ[i] * cos - vertexX[i] * sin >> 16;
		}

		reset();
	}

	public void resetAnim()
	{
		if (origVX == null)
		{
			return;
		}

		System.arraycopy(origVX, 0, vertexX, 0, origVX.length);
		System.arraycopy(origVY, 0, vertexY, 0, origVY.length);
		System.arraycopy(origVZ, 0, vertexZ, 0, origVZ.length);
	}

	public void animate(int type, int[] frameMap, int dx, int dy, int dz)
	{
		if (origVX == null)
		{
			origVX = Arrays.copyOf(vertexX, vertexX.length);
			origVY = Arrays.copyOf(vertexY, vertexY.length);
			origVZ = Arrays.copyOf(vertexZ, vertexZ.length);
		}

		final int[] verticesX = vertexX;
		final int[] verticesY = vertexY;
		final int[] verticesZ = vertexZ;
		int var6 = frameMap.length;
		int var7;
		int var8;
		int var11;
		int var12;
		if (type == 0)
		{
			var7 = 0;
			animOffsetX = 0;
			animOffsetY = 0;
			animOffsetZ = 0;

			for (var8 = 0; var8 < var6; ++var8)
			{
				int var9 = frameMap[var8];
				if (var9 < this.vertexGroups.length)
				{
					int[] var10 = this.vertexGroups[var9];

					for (var11 = 0; var11 < var10.length; ++var11)
					{
						var12 = var10[var11];
						animOffsetX += verticesX[var12];
						animOffsetY += verticesY[var12];
						animOffsetZ += verticesZ[var12];
						++var7;
					}
				}
			}

			if (var7 > 0)
			{
				animOffsetX = dx + animOffsetX / var7;
				animOffsetY = dy + animOffsetY / var7;
				animOffsetZ = dz + animOffsetZ / var7;
			}
			else
			{
				animOffsetX = dx;
				animOffsetY = dy;
				animOffsetZ = dz;
			}

		}
		else
		{
			int[] var18;
			int var19;
			if (type == 1)
			{
				for (var7 = 0; var7 < var6; ++var7)
				{
					var8 = frameMap[var7];
					if (var8 < this.vertexGroups.length)
					{
						var18 = this.vertexGroups[var8];

						for (var19 = 0; var19 < var18.length; ++var19)
						{
							var11 = var18[var19];
							verticesX[var11] += dx;
							verticesY[var11] += dy;
							verticesZ[var11] += dz;
						}
					}
				}

			}
			else if (type == 2)
			{
				for (var7 = 0; var7 < var6; ++var7)
				{
					var8 = frameMap[var7];
					if (var8 < this.vertexGroups.length)
					{
						var18 = this.vertexGroups[var8];

						for (var19 = 0; var19 < var18.length; ++var19)
						{
							var11 = var18[var19];
							verticesX[var11] -= animOffsetX;
							verticesY[var11] -= animOffsetY;
							verticesZ[var11] -= animOffsetZ;
							var12 = (dx & 255) * 8;
							int var13 = (dy & 255) * 8;
							int var14 = (dz & 255) * 8;
							int var15;
							int var16;
							int var17;
							if (var14 != 0)
							{
								var15 = CircularAngle.SINE[var14];
								var16 = CircularAngle.COSINE[var14];
								var17 = var15 * verticesY[var11] + var16 * verticesX[var11] >> 16;
								verticesY[var11] = var16 * verticesY[var11] - var15 * verticesX[var11] >> 16;
								verticesX[var11] = var17;
							}

							if (var12 != 0)
							{
								var15 = CircularAngle.SINE[var12];
								var16 = CircularAngle.COSINE[var12];
								var17 = var16 * verticesY[var11] - var15 * verticesZ[var11] >> 16;
								verticesZ[var11] = var15 * verticesY[var11] + var16 * verticesZ[var11] >> 16;
								verticesY[var11] = var17;
							}

							if (var13 != 0)
							{
								var15 = CircularAngle.SINE[var13];
								var16 = CircularAngle.COSINE[var13];
								var17 = var15 * verticesZ[var11] + var16 * verticesX[var11] >> 16;
								verticesZ[var11] = var16 * verticesZ[var11] - var15 * verticesX[var11] >> 16;
								verticesX[var11] = var17;
							}

							verticesX[var11] += animOffsetX;
							verticesY[var11] += animOffsetY;
							verticesZ[var11] += animOffsetZ;
						}
					}
				}

			}
			else if (type == 3)
			{
				for (var7 = 0; var7 < var6; ++var7)
				{
					var8 = frameMap[var7];
					if (var8 < this.vertexGroups.length)
					{
						var18 = this.vertexGroups[var8];

						for (var19 = 0; var19 < var18.length; ++var19)
						{
							var11 = var18[var19];
							verticesX[var11] -= animOffsetX;
							verticesY[var11] -= animOffsetY;
							verticesZ[var11] -= animOffsetZ;
							verticesX[var11] = dx * verticesX[var11] / 128;
							verticesY[var11] = dy * verticesY[var11] / 128;
							verticesZ[var11] = dz * verticesZ[var11] / 128;
							verticesX[var11] += animOffsetX;
							verticesY[var11] += animOffsetY;
							verticesZ[var11] += animOffsetZ;
						}
					}
				}

			}
			else if (type == 5)
			{
				// alpha animation
			}
		}
	}

	public void method1493()
	{
		int var1;
		for (var1 = 0; var1 < this.vertexCount; ++var1)
		{
			this.vertexZ[var1] = -this.vertexZ[var1];
		}

		for (var1 = 0; var1 < this.faceCount; ++var1)
		{
			int var2 = this.faceIndices1[var1];
			this.faceIndices1[var1] = this.faceIndices3[var1];
			this.faceIndices3[var1] = var2;
		}

		reset();
	}

	public void rotate1()
	{
		for (int var1 = 0; var1 < this.vertexCount; ++var1)
		{
			int var2 = this.vertexX[var1];
			this.vertexX[var1] = this.vertexZ[var1];
			this.vertexZ[var1] = -var2;
		}

		reset();
	}

	public void rotate2()
	{
		for (int var1 = 0; var1 < this.vertexCount; ++var1)
		{
			this.vertexX[var1] = -this.vertexX[var1];
			this.vertexZ[var1] = -this.vertexZ[var1];
		}

		reset();
	}

	public void rotate3()
	{
		for (int var1 = 0; var1 < this.vertexCount; ++var1)
		{
			int var2 = this.vertexZ[var1];
			this.vertexZ[var1] = this.vertexX[var1];
			this.vertexX[var1] = -var2;
		}

		reset();
	}

	private void reset()
	{
		vertexNormals = null;
		faceNormals = null;
		faceTextureUCoordinates = faceTextureVCoordinates = null;
	}

	public void resize(int var1, int var2, int var3)
	{
		for (int var4 = 0; var4 < this.vertexCount; ++var4)
		{
			this.vertexX[var4] = this.vertexX[var4] * var1 / 128;
			this.vertexY[var4] = var2 * this.vertexY[var4] / 128;
			this.vertexZ[var4] = var3 * this.vertexZ[var4] / 128;
		}

		reset();
	}

	public void recolor(short var1, short var2)
	{
		for (int var3 = 0; var3 < this.faceCount; ++var3)
		{
			if (this.faceColors[var3] == var1)
			{
				this.faceColors[var3] = var2;
			}
		}

	}

	public void retexture(short var1, short var2)
	{
		if (this.faceTextures != null)
		{
			for (int var3 = 0; var3 < this.faceCount; ++var3)
			{
				if (this.faceTextures[var3] == var1)
				{
					this.faceTextures[var3] = var2;
				}
			}

		}
	}

	public void move(int xOffset, int yOffset, int zOffset)
	{
		for (int i = 0; i < this.vertexCount; i++)
		{
			this.vertexX[i] += xOffset;
			this.vertexY[i] += yOffset;
			this.vertexZ[i] += zOffset;
		}
		this.reset();
	}

	public void computeMaxPriority()
	{
		if (faceRenderPriorities == null)
		{
			return;
		}

		for (int i = 0; i < faceCount; ++i)
		{
			if (faceRenderPriorities[i] > maxPriority)
			{
				maxPriority = faceRenderPriorities[i];
			}
		}
	}
}
