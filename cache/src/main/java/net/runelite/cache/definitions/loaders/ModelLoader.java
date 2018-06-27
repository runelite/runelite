package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.io.InputStream;

public class ModelLoader
{
	public ModelDefinition load(int modelId, byte[] b)
	{
		ModelDefinition def = new ModelDefinition();
		def.id = modelId;

		if (b[b.length - 1] == -1 && b[b.length - 2] == -1)
		{
			this.load1(def, b);
		}
		else
		{
			this.load2(def, b);
		}

		def.computeNormals();
		def.computeTextureUVCoordinates();
		def.computeAnimationTables();

		return def;
	}

	private void load1(ModelDefinition model, byte[] var1)
	{
		InputStream var2 = new InputStream(var1);
		InputStream var24 = new InputStream(var1);
		InputStream var3 = new InputStream(var1);
		InputStream var28 = new InputStream(var1);
		InputStream var6 = new InputStream(var1);
		InputStream var55 = new InputStream(var1);
		InputStream var51 = new InputStream(var1);
		var2.setOffset(var1.length - 23);
		int verticeCount = var2.readUnsignedShort();
		int triangleCount = var2.readUnsignedShort();
		int textureTriangleCount = var2.readUnsignedByte();
		int var13 = var2.readUnsignedByte();
		int modelPriority = var2.readUnsignedByte();
		int var50 = var2.readUnsignedByte();
		int var17 = var2.readUnsignedByte();
		int modelTexture = var2.readUnsignedByte();
		int modelVertexSkins = var2.readUnsignedByte();
		int var20 = var2.readUnsignedShort();
		int var21 = var2.readUnsignedShort();
		int var42 = var2.readUnsignedShort();
		int var22 = var2.readUnsignedShort();
		int var38 = var2.readUnsignedShort();
		int textureAmount = 0;
		int var7 = 0;
		int var29 = 0;
		int position;
		if (textureTriangleCount > 0)
		{
			model.textureRenderTypes = new byte[textureTriangleCount];
			var2.setOffset(0);

			for (position = 0; position < textureTriangleCount; ++position)
			{
				byte renderType = model.textureRenderTypes[position] = var2.readByte();
				if (renderType == 0)
				{
					++textureAmount;
				}

				if (renderType >= 1 && renderType <= 3)
				{
					++var7;
				}

				if (renderType == 2)
				{
					++var29;
				}
			}
		}

		position = textureTriangleCount + verticeCount;
		int renderTypePos = position;
		if (var13 == 1)
		{
			position += triangleCount;
		}

		int var49 = position;
		position += triangleCount;
		int priorityPos = position;
		if (modelPriority == 255)
		{
			position += triangleCount;
		}

		int triangleSkinPos = position;
		if (var17 == 1)
		{
			position += triangleCount;
		}

		int var35 = position;
		if (modelVertexSkins == 1)
		{
			position += verticeCount;
		}

		int alphaPos = position;
		if (var50 == 1)
		{
			position += triangleCount;
		}

		int var11 = position;
		position += var22;
		int texturePos = position;
		if (modelTexture == 1)
		{
			position += triangleCount * 2;
		}

		int textureCoordPos = position;
		position += var38;
		int colorPos = position;
		position += triangleCount * 2;
		int var40 = position;
		position += var20;
		int var41 = position;
		position += var21;
		int var8 = position;
		position += var42;
		int var43 = position;
		position += textureAmount * 6;
		int var37 = position;
		position += var7 * 6;
		int var48 = position;
		position += var7 * 6;
		int var56 = position;
		position += var7 * 2;
		int var45 = position;
		position += var7;
		int var46 = position;
		position += var7 * 2 + var29 * 2;
		model.vertexCount = verticeCount;
		model.faceCount = triangleCount;
		model.textureTriangleCount = textureTriangleCount;
		model.vertexPositionsX = new int[verticeCount];
		model.vertexPositionsY = new int[verticeCount];
		model.vertexPositionsZ = new int[verticeCount];
		model.faceVertexIndices1 = new int[triangleCount];
		model.faceVertexIndices2 = new int[triangleCount];
		model.faceVertexIndices3 = new int[triangleCount];
		if (modelVertexSkins == 1)
		{
			model.vertexSkins = new int[verticeCount];
		}

		if (var13 == 1)
		{
			model.faceRenderTypes = new byte[triangleCount];
		}

		if (modelPriority == 255)
		{
			model.faceRenderPriorities = new byte[triangleCount];
		}
		else
		{
			model.priority = (byte) modelPriority;
		}

		if (var50 == 1)
		{
			model.faceAlphas = new byte[triangleCount];
		}

		if (var17 == 1)
		{
			model.faceSkins = new int[triangleCount];
		}

		if (modelTexture == 1)
		{
			model.faceTextures = new short[triangleCount];
		}

		if (modelTexture == 1 && textureTriangleCount > 0)
		{
			model.textureCoordinates = new byte[triangleCount];
		}

		model.faceColors = new short[triangleCount];
		if (textureTriangleCount > 0)
		{
			model.textureTriangleVertexIndices1 = new short[textureTriangleCount];
			model.textureTriangleVertexIndices2 = new short[textureTriangleCount];
			model.textureTriangleVertexIndices3 = new short[textureTriangleCount];
			if (var7 > 0)
			{
				model.aShortArray2574 = new short[var7];
				model.aShortArray2575 = new short[var7];
				model.aShortArray2586 = new short[var7];
				model.aShortArray2577 = new short[var7];
				model.aByteArray2580 = new byte[var7];
				model.aShortArray2578 = new short[var7];
			}

			if (var29 > 0)
			{
				model.texturePrimaryColors = new short[var29];
			}
		}

		var2.setOffset(textureTriangleCount);
		var24.setOffset(var40);
		var3.setOffset(var41);
		var28.setOffset(var8);
		var6.setOffset(var35);
		int vX = 0;
		int vY = 0;
		int vZ = 0;

		int vertexZOffset;
		int var10;
		int vertexYOffset;
		int var15;
		int point;
		for (point = 0; point < verticeCount; ++point)
		{
			int vertexFlags = var2.readUnsignedByte();
			int vertexXOffset = 0;
			if ((vertexFlags & 1) != 0)
			{
				vertexXOffset = var24.readShortSmart();
			}

			vertexYOffset = 0;
			if ((vertexFlags & 2) != 0)
			{
				vertexYOffset = var3.readShortSmart();
			}

			vertexZOffset = 0;
			if ((vertexFlags & 4) != 0)
			{
				vertexZOffset = var28.readShortSmart();
			}

			model.vertexPositionsX[point] = vX + vertexXOffset;
			model.vertexPositionsY[point] = vY + vertexYOffset;
			model.vertexPositionsZ[point] = vZ + vertexZOffset;
			vX = model.vertexPositionsX[point];
			vY = model.vertexPositionsY[point];
			vZ = model.vertexPositionsZ[point];
			if (modelVertexSkins == 1)
			{
				model.vertexSkins[point] = var6.readUnsignedByte();
			}
		}

		var2.setOffset(colorPos);
		var24.setOffset(renderTypePos);
		var3.setOffset(priorityPos);
		var28.setOffset(alphaPos);
		var6.setOffset(triangleSkinPos);
		var55.setOffset(texturePos);
		var51.setOffset(textureCoordPos);

		for (point = 0; point < triangleCount; ++point)
		{
			model.faceColors[point] = (short) var2.readUnsignedShort();
			if (var13 == 1)
			{
				model.faceRenderTypes[point] = var24.readByte();
			}

			if (modelPriority == 255)
			{
				model.faceRenderPriorities[point] = var3.readByte();
			}

			if (var50 == 1)
			{
				model.faceAlphas[point] = var28.readByte();
			}

			if (var17 == 1)
			{
				model.faceSkins[point] = var6.readUnsignedByte();
			}

			if (modelTexture == 1)
			{
				model.faceTextures[point] = (short) (var55.readUnsignedShort() - 1);
			}

			if (model.textureCoordinates != null && model.faceTextures[point] != -1)
			{
				model.textureCoordinates[point] = (byte) (var51.readUnsignedByte() - 1);
			}
		}

		var2.setOffset(var11);
		var24.setOffset(var49);
		int trianglePointX = 0;
		int trianglePointY = 0;
		int trianglePointZ = 0;
		vertexYOffset = 0;

		int var16;
		for (vertexZOffset = 0; vertexZOffset < triangleCount; ++vertexZOffset)
		{
			int numFaces = var24.readUnsignedByte();
			if (numFaces == 1)
			{
				trianglePointX = var2.readShortSmart() + vertexYOffset;
				trianglePointY = var2.readShortSmart() + trianglePointX;
				trianglePointZ = var2.readShortSmart() + trianglePointY;
				vertexYOffset = trianglePointZ;
				model.faceVertexIndices1[vertexZOffset] = trianglePointX;
				model.faceVertexIndices2[vertexZOffset] = trianglePointY;
				model.faceVertexIndices3[vertexZOffset] = trianglePointZ;
			}

			if (numFaces == 2)
			{
				trianglePointY = trianglePointZ;
				trianglePointZ = var2.readShortSmart() + vertexYOffset;
				vertexYOffset = trianglePointZ;
				model.faceVertexIndices1[vertexZOffset] = trianglePointX;
				model.faceVertexIndices2[vertexZOffset] = trianglePointY;
				model.faceVertexIndices3[vertexZOffset] = trianglePointZ;
			}

			if (numFaces == 3)
			{
				trianglePointX = trianglePointZ;
				trianglePointZ = var2.readShortSmart() + vertexYOffset;
				vertexYOffset = trianglePointZ;
				model.faceVertexIndices1[vertexZOffset] = trianglePointX;
				model.faceVertexIndices2[vertexZOffset] = trianglePointY;
				model.faceVertexIndices3[vertexZOffset] = trianglePointZ;
			}

			if (numFaces == 4)
			{
				int var57 = trianglePointX;
				trianglePointX = trianglePointY;
				trianglePointY = var57;
				trianglePointZ = var2.readShortSmart() + vertexYOffset;
				vertexYOffset = trianglePointZ;
				model.faceVertexIndices1[vertexZOffset] = trianglePointX;
				model.faceVertexIndices2[vertexZOffset] = var57;
				model.faceVertexIndices3[vertexZOffset] = trianglePointZ;
			}
		}

		var2.setOffset(var43);
		var24.setOffset(var37);
		var3.setOffset(var48);
		var28.setOffset(var56);
		var6.setOffset(var45);
		var55.setOffset(var46);

		for (int texIndex = 0; texIndex < textureTriangleCount; ++texIndex)
		{
			int type = model.textureRenderTypes[texIndex] & 255;
			if (type == 0)
			{
				model.textureTriangleVertexIndices1[texIndex] = (short) var2.readUnsignedShort();
				model.textureTriangleVertexIndices2[texIndex] = (short) var2.readUnsignedShort();
				model.textureTriangleVertexIndices3[texIndex] = (short) var2.readUnsignedShort();
			}

			if (type == 1)
			{
				model.textureTriangleVertexIndices1[texIndex] = (short) var24.readUnsignedShort();
				model.textureTriangleVertexIndices2[texIndex] = (short) var24.readUnsignedShort();
				model.textureTriangleVertexIndices3[texIndex] = (short) var24.readUnsignedShort();
				model.aShortArray2574[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2575[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2586[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2577[texIndex] = (short) var28.readUnsignedShort();
				model.aByteArray2580[texIndex] = var6.readByte();
				model.aShortArray2578[texIndex] = (short) var55.readUnsignedShort();
			}

			if (type == 2)
			{
				model.textureTriangleVertexIndices1[texIndex] = (short) var24.readUnsignedShort();
				model.textureTriangleVertexIndices2[texIndex] = (short) var24.readUnsignedShort();
				model.textureTriangleVertexIndices3[texIndex] = (short) var24.readUnsignedShort();
				model.aShortArray2574[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2575[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2586[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2577[texIndex] = (short) var28.readUnsignedShort();
				model.aByteArray2580[texIndex] = var6.readByte();
				model.aShortArray2578[texIndex] = (short) var55.readUnsignedShort();
				model.texturePrimaryColors[texIndex] = (short) var55.readUnsignedShort();
			}

			if (type == 3)
			{
				model.textureTriangleVertexIndices1[texIndex] = (short) var24.readUnsignedShort();
				model.textureTriangleVertexIndices2[texIndex] = (short) var24.readUnsignedShort();
				model.textureTriangleVertexIndices3[texIndex] = (short) var24.readUnsignedShort();
				model.aShortArray2574[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2575[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2586[texIndex] = (short) var3.readUnsignedShort();
				model.aShortArray2577[texIndex] = (short) var28.readUnsignedShort();
				model.aByteArray2580[texIndex] = var6.readByte();
				model.aShortArray2578[texIndex] = (short) var55.readUnsignedShort();
			}
		}

		var2.setOffset(position);
		vertexZOffset = var2.readUnsignedByte();
		if (vertexZOffset != 0)
		{
			//new Class41();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readInt();
		}
	}

	private void load2(ModelDefinition model, byte[] var1)
	{
		boolean var2 = false;
		boolean var43 = false;
		InputStream var5 = new InputStream(var1);
		InputStream var39 = new InputStream(var1);
		InputStream var26 = new InputStream(var1);
		InputStream var9 = new InputStream(var1);
		InputStream var3 = new InputStream(var1);
		var5.setOffset(var1.length - 18);
		int var10 = var5.readUnsignedShort();
		int var11 = var5.readUnsignedShort();
		int var12 = var5.readUnsignedByte();
		int var13 = var5.readUnsignedByte();
		int var14 = var5.readUnsignedByte();
		int var30 = var5.readUnsignedByte();
		int var15 = var5.readUnsignedByte();
		int var28 = var5.readUnsignedByte();
		int var27 = var5.readUnsignedShort();
		int var20 = var5.readUnsignedShort();
		int var36 = var5.readUnsignedShort();
		int var23 = var5.readUnsignedShort();
		byte var16 = 0;
		int var46 = var16 + var10;
		int var24 = var46;
		var46 += var11;
		int var25 = var46;
		if (var14 == 255)
		{
			var46 += var11;
		}

		int var4 = var46;
		if (var15 == 1)
		{
			var46 += var11;
		}

		int var42 = var46;
		if (var13 == 1)
		{
			var46 += var11;
		}

		int var37 = var46;
		if (var28 == 1)
		{
			var46 += var10;
		}

		int var29 = var46;
		if (var30 == 1)
		{
			var46 += var11;
		}

		int var44 = var46;
		var46 += var23;
		int var17 = var46;
		var46 += var11 * 2;
		int var32 = var46;
		var46 += var12 * 6;
		int var34 = var46;
		var46 += var27;
		int var35 = var46;
		var46 += var20;
		int var10000 = var46 + var36;
		model.vertexCount = var10;
		model.faceCount = var11;
		model.textureTriangleCount = var12;
		model.vertexPositionsX = new int[var10];
		model.vertexPositionsY = new int[var10];
		model.vertexPositionsZ = new int[var10];
		model.faceVertexIndices1 = new int[var11];
		model.faceVertexIndices2 = new int[var11];
		model.faceVertexIndices3 = new int[var11];
		if (var12 > 0)
		{
			model.textureRenderTypes = new byte[var12];
			model.textureTriangleVertexIndices1 = new short[var12];
			model.textureTriangleVertexIndices2 = new short[var12];
			model.textureTriangleVertexIndices3 = new short[var12];
		}

		if (var28 == 1)
		{
			model.vertexSkins = new int[var10];
		}

		if (var13 == 1)
		{
			model.faceRenderTypes = new byte[var11];
			model.textureCoordinates = new byte[var11];
			model.faceTextures = new short[var11];
		}

		if (var14 == 255)
		{
			model.faceRenderPriorities = new byte[var11];
		}
		else
		{
			model.priority = (byte) var14;
		}

		if (var30 == 1)
		{
			model.faceAlphas = new byte[var11];
		}

		if (var15 == 1)
		{
			model.faceSkins = new int[var11];
		}

		model.faceColors = new short[var11];
		var5.setOffset(var16);
		var39.setOffset(var34);
		var26.setOffset(var35);
		var9.setOffset(var46);
		var3.setOffset(var37);
		int var41 = 0;
		int var33 = 0;
		int var19 = 0;

		int var6;
		int var7;
		int var8;
		int var18;
		int var31;
		for (var18 = 0; var18 < var10; ++var18)
		{
			var8 = var5.readUnsignedByte();
			var31 = 0;
			if ((var8 & 1) != 0)
			{
				var31 = var39.readShortSmart();
			}

			var6 = 0;
			if ((var8 & 2) != 0)
			{
				var6 = var26.readShortSmart();
			}

			var7 = 0;
			if ((var8 & 4) != 0)
			{
				var7 = var9.readShortSmart();
			}

			model.vertexPositionsX[var18] = var41 + var31;
			model.vertexPositionsY[var18] = var33 + var6;
			model.vertexPositionsZ[var18] = var19 + var7;
			var41 = model.vertexPositionsX[var18];
			var33 = model.vertexPositionsY[var18];
			var19 = model.vertexPositionsZ[var18];
			if (var28 == 1)
			{
				model.vertexSkins[var18] = var3.readUnsignedByte();
			}
		}

		var5.setOffset(var17);
		var39.setOffset(var42);
		var26.setOffset(var25);
		var9.setOffset(var29);
		var3.setOffset(var4);

		for (var18 = 0; var18 < var11; ++var18)
		{
			model.faceColors[var18] = (short) var5.readUnsignedShort();
			if (var13 == 1)
			{
				var8 = var39.readUnsignedByte();
				if ((var8 & 1) == 1)
				{
					model.faceRenderTypes[var18] = 1;
					var2 = true;
				}
				else
				{
					model.faceRenderTypes[var18] = 0;
				}

				if ((var8 & 2) == 2)
				{
					model.textureCoordinates[var18] = (byte) (var8 >> 2);
					model.faceTextures[var18] = model.faceColors[var18];
					model.faceColors[var18] = 127;
					if (model.faceTextures[var18] != -1)
					{
						var43 = true;
					}
				}
				else
				{
					model.textureCoordinates[var18] = -1;
					model.faceTextures[var18] = -1;
				}
			}

			if (var14 == 255)
			{
				model.faceRenderPriorities[var18] = var26.readByte();
			}

			if (var30 == 1)
			{
				model.faceAlphas[var18] = var9.readByte();
			}

			if (var15 == 1)
			{
				model.faceSkins[var18] = var3.readUnsignedByte();
			}
		}

		var5.setOffset(var44);
		var39.setOffset(var24);
		var18 = 0;
		var8 = 0;
		var31 = 0;
		var6 = 0;

		int var21;
		int var22;
		for (var7 = 0; var7 < var11; ++var7)
		{
			var22 = var39.readUnsignedByte();
			if (var22 == 1)
			{
				var18 = var5.readShortSmart() + var6;
				var8 = var5.readShortSmart() + var18;
				var31 = var5.readShortSmart() + var8;
				var6 = var31;
				model.faceVertexIndices1[var7] = var18;
				model.faceVertexIndices2[var7] = var8;
				model.faceVertexIndices3[var7] = var31;
			}

			if (var22 == 2)
			{
				var8 = var31;
				var31 = var5.readShortSmart() + var6;
				var6 = var31;
				model.faceVertexIndices1[var7] = var18;
				model.faceVertexIndices2[var7] = var8;
				model.faceVertexIndices3[var7] = var31;
			}

			if (var22 == 3)
			{
				var18 = var31;
				var31 = var5.readShortSmart() + var6;
				var6 = var31;
				model.faceVertexIndices1[var7] = var18;
				model.faceVertexIndices2[var7] = var8;
				model.faceVertexIndices3[var7] = var31;
			}

			if (var22 == 4)
			{
				var21 = var18;
				var18 = var8;
				var8 = var21;
				var31 = var5.readShortSmart() + var6;
				var6 = var31;
				model.faceVertexIndices1[var7] = var18;
				model.faceVertexIndices2[var7] = var21;
				model.faceVertexIndices3[var7] = var31;
			}
		}

		var5.setOffset(var32);

		for (var7 = 0; var7 < var12; ++var7)
		{
			model.textureRenderTypes[var7] = 0;
			model.textureTriangleVertexIndices1[var7] = (short) var5.readUnsignedShort();
			model.textureTriangleVertexIndices2[var7] = (short) var5.readUnsignedShort();
			model.textureTriangleVertexIndices3[var7] = (short) var5.readUnsignedShort();
		}

		if (model.textureCoordinates != null)
		{
			boolean var45 = false;

			for (var22 = 0; var22 < var11; ++var22)
			{
				var21 = model.textureCoordinates[var22] & 255;
				if (var21 != 255)
				{
					if ((model.textureTriangleVertexIndices1[var21] & '\uffff') == model.faceVertexIndices1[var22] && (model.textureTriangleVertexIndices2[var21] & '\uffff') == model.faceVertexIndices2[var22] && (model.textureTriangleVertexIndices3[var21] & '\uffff') == model.faceVertexIndices3[var22])
					{
						model.textureCoordinates[var22] = -1;
					}
					else
					{
						var45 = true;
					}
				}
			}

			if (!var45)
			{
				model.textureCoordinates = null;
			}
		}

		if (!var43)
		{
			model.faceTextures = null;
		}

		if (!var2)
		{
			model.faceRenderTypes = null;
		}
	}

}
