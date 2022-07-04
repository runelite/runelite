package net.runelite.cache.definitions.loaders;

import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.io.InputStream;

public class ModelLoader
{
	public ModelDefinition load(int modelId, byte[] b)
	{
		ModelDefinition def = new ModelDefinition();
		def.id = modelId;

		if (b[b.length - 1] == -3 && b[b.length - 2] == -1)
		{
			decodeNew_v2(def, b);
		}
		else if (b[b.length - 1] == -2 && b[b.length - 2] == -1)
		{
			decodeOld_v2(def, b);
		}
		else if (b[b.length - 1] == -1 && b[b.length - 2] == -1)
		{
			decodeNew_v1(def, b);
		}
		else
		{
			decodeOld_v1(def, b);
		}

		def.computeNormals();
		def.computeTextureUVCoordinates();
		def.computeAnimationTables();

		return def;
	}

	void decodeNew_v2(ModelDefinition def, byte[] var1)
	{
		InputStream stream1 = new InputStream(var1);
		InputStream stream2 = new InputStream(var1);
		InputStream stream3 = new InputStream(var1);
		InputStream stream4 = new InputStream(var1);
		InputStream stream5 = new InputStream(var1);
		InputStream stream6 = new InputStream(var1);
		InputStream stream7 = new InputStream(var1);
		stream1.setOffset(var1.length - 26);
		int vertexCount = stream1.readUnsignedShort();
		int faceCount = stream1.readUnsignedShort();
		int textureCount = stream1.readUnsignedByte();
		int isTextured = stream1.readUnsignedByte();
		int faceRenderPriority = stream1.readUnsignedByte();
		int hasFaceTransparencies = stream1.readUnsignedByte();
		int hasPackedTransparencyVertexGroups = stream1.readUnsignedByte();
		int _hasFaceTexturesNEW = stream1.readUnsignedByte();
		int hasPackedVertexGroups = stream1.readUnsignedByte();// 7th byte
		int _hasAnimsNEW = stream1.readUnsignedByte();//8th byte
		int vertezXDataByteCount = stream1.readUnsignedShort();
		int vertexYDataByteCount = stream1.readUnsignedShort();
		int vertexZDataByteCount = stream1.readUnsignedShort();
		int _vertCount = stream1.readUnsignedShort();
		int newstuffACount = stream1.readUnsignedShort();
		int newstuffBCount = stream1.readUnsignedShort();
		int textureAmount = 0;
		int newCountA = 0;
		int newCountB = 0;
		int dataOffset;
		if (textureCount > 0)
		{
			def.textureRenderTypes = new byte[textureCount];
			stream1.setOffset(0);

			for (int i = 0; i < textureCount; ++i)
			{
				byte type = def.textureRenderTypes[i] = stream1.readByte();
				if (type == 0)
				{
					++textureAmount;
				}

				if (type >= 1 && type <= 3)
				{
					++newCountA;
				}

				if (type == 2)
				{
					++newCountB;
				}
			}
		}

		dataOffset = textureCount + vertexCount;
		int renderTypePos = dataOffset;
		if (isTextured == 1)
		{
			dataOffset += faceCount;
		}

		int offsetFaceTypes = dataOffset;
		dataOffset += faceCount;
		int priorityPos = dataOffset;
		if (faceRenderPriority == 255)
		{
			dataOffset += faceCount;
		}

		int triangleSkinPos = dataOffset;
		if (hasPackedTransparencyVertexGroups == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfFaceTextureFlags = dataOffset;
		dataOffset += newstuffBCount;
		int alphaPos = dataOffset;
		if (hasFaceTransparencies == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfPackedVertexGroups = dataOffset;
		dataOffset += _vertCount;
		int texturePos = dataOffset;
		if (_hasFaceTexturesNEW == 1)
		{
			dataOffset += faceCount * 2;
		}

		int textureCoordPos = dataOffset;
		dataOffset += newstuffACount;
		int colorPos = dataOffset;
		dataOffset += faceCount * 2;
		int o2b = dataOffset;
		dataOffset += vertezXDataByteCount;
		int o3b = dataOffset;
		dataOffset += vertexYDataByteCount;
		int o4b = dataOffset;
		dataOffset += vertexZDataByteCount;
		int offsetRenderTypes = dataOffset;
		dataOffset += textureAmount * 6;
		int offsetUnused2 = dataOffset;
		dataOffset += newCountA * 6;
		int offsetUnused3 = dataOffset;
		dataOffset += newCountA * 6;
		int offsetUnused4 = dataOffset;
		dataOffset += newCountA * 2;
		int offsetUnused5 = dataOffset;
		dataOffset += newCountA;
		int offsetUnused6 = dataOffset;
		dataOffset = dataOffset + newCountA * 2 + newCountB * 2;
		def.vertexCount = vertexCount;
		def.faceCount = faceCount;
		def.numTextureFaces = textureCount;
		def.vertexX = new int[vertexCount];
		def.vertexY = new int[vertexCount];
		def.vertexZ = new int[vertexCount];
		def.faceIndices1 = new int[faceCount];
		def.faceIndices2 = new int[faceCount];
		def.faceIndices3 = new int[faceCount];
		if (hasPackedVertexGroups == 1)
		{
			def.packedVertexGroups = new int[vertexCount];
		}

		if (isTextured == 1)
		{
			def.faceRenderTypes = new byte[faceCount];
		}

		if (faceRenderPriority == 255)
		{
			def.faceRenderPriorities = new byte[faceCount];
		}
		else
		{
			def.priority = (byte) faceRenderPriority;
		}

		if (hasFaceTransparencies == 1)
		{
			def.faceTransparencies = new byte[faceCount];
		}

		if (hasPackedTransparencyVertexGroups == 1)
		{
			def.packedTransparencyVertexGroups = new int[faceCount];
		}

		if (_hasFaceTexturesNEW == 1)
		{
			def.faceTextures = new short[faceCount];
		}

		if (_hasFaceTexturesNEW == 1 && textureCount > 0)
		{
			def.textureCoords = new byte[faceCount];
		}

		if (_hasAnimsNEW == 1)
		{
			def.animayaGroups = new int[vertexCount][];
			def.animayaScales = new int[vertexCount][];
		}

		def.faceColors = new short[faceCount];
		if (textureCount > 0)
		{
			def.texIndices1 = new short[textureCount];
			def.texIndices2 = new short[textureCount];
			def.texIndices3 = new short[textureCount];
		}

		stream1.setOffset(textureCount);
		stream2.setOffset(o2b);
		stream3.setOffset(o3b);
		stream4.setOffset(o4b);
		stream5.setOffset(offsetOfFaceTextureFlags);
		int previousVertexX = 0;
		int previousVertexY = 0;
		int previousVertexZ = 0;

		for (int i = 0; i < vertexCount; ++i)
		{
			int flags = stream1.readUnsignedByte();
			int vertX = 0;
			if ((flags & 1) != 0)
			{
				vertX = stream2.readShortSmart();
			}

			int vertY = 0;
			if ((flags & 2) != 0)
			{
				vertY = stream3.readShortSmart();
			}

			int vertZ = 0;
			if ((flags & 4) != 0)
			{
				vertZ = stream4.readShortSmart();
			}

			def.vertexX[i] = previousVertexX + vertX;
			def.vertexY[i] = previousVertexY + vertY;
			def.vertexZ[i] = previousVertexZ + vertZ;
			previousVertexX = def.vertexX[i];
			previousVertexY = def.vertexY[i];
			previousVertexZ = def.vertexZ[i];
			if (hasPackedVertexGroups == 1)
			{
				def.packedVertexGroups[i] = stream5.readUnsignedByte();
			}
		}

		if (_hasAnimsNEW == 1)
		{
			for (int i = 0; i < vertexCount; ++i)
			{
				int count = stream5.readUnsignedByte();
				def.animayaGroups[i] = new int[count];
				def.animayaScales[i] = new int[count];

				for (int i2 = 0; i2 < count; ++i2)
				{
					def.animayaGroups[i][i2] = stream5.readUnsignedByte();
					def.animayaScales[i][i2] = stream5.readUnsignedByte();
				}
			}
		}

		stream1.setOffset(colorPos);
		stream2.setOffset(renderTypePos);
		stream3.setOffset(priorityPos);
		stream4.setOffset(alphaPos);
		stream5.setOffset(triangleSkinPos);
		stream6.setOffset(texturePos);
		stream7.setOffset(textureCoordPos);

		for (int i = 0; i < faceCount; ++i)
		{
			def.faceColors[i] = (short) stream1.readUnsignedShort();
			if (isTextured == 1)
			{
				def.faceRenderTypes[i] = stream2.readByte();
			}

			if (faceRenderPriority == 255)
			{
				def.faceRenderPriorities[i] = stream3.readByte();
			}

			if (hasFaceTransparencies == 1)
			{
				def.faceTransparencies[i] = stream4.readByte();
			}

			if (hasPackedTransparencyVertexGroups == 1)
			{
				def.packedTransparencyVertexGroups[i] = stream5.readUnsignedByte();
			}

			if (_hasFaceTexturesNEW == 1)
			{
				def.faceTextures[i] = (short) (stream6.readUnsignedShort() - 1);
			}

			if (def.textureCoords != null && def.faceTextures[i] != -1)
			{
				def.textureCoords[i] = (byte) (stream7.readUnsignedByte() - 1);
			}
		}

		stream1.setOffset(offsetOfPackedVertexGroups);
		stream2.setOffset(offsetFaceTypes);

		for (int i = 0; i < faceCount; ++i)
		{
			int faceIndexCompressionType = stream2.readUnsignedByte();
			if (faceIndexCompressionType == 1)
			{
				previousVertexX = stream1.readShortSmart() + previousVertexZ;
				previousVertexY = stream1.readShortSmart() + previousVertexX;
				previousVertexZ = stream1.readShortSmart() + previousVertexY;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}

			if (faceIndexCompressionType == 2)
			{
				previousVertexY = previousVertexZ;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}

			if (faceIndexCompressionType == 3)
			{
				previousVertexX = previousVertexZ;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}

			if (faceIndexCompressionType == 4)
			{
				int swap = previousVertexX;
				previousVertexX = previousVertexY;
				previousVertexY = swap;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}
		}

		stream1.setOffset(offsetRenderTypes);
		stream2.setOffset(offsetUnused2);
		stream3.setOffset(offsetUnused3);
		stream4.setOffset(offsetUnused4);
		stream5.setOffset(offsetUnused5);
		stream6.setOffset(offsetUnused6);

		for (int i = 0; i < textureCount; ++i)
		{
			int type = def.textureRenderTypes[i] & 255;
			if (type == 0)
			{
				def.texIndices1[i] = (short) stream1.readUnsignedShort();
				def.texIndices2[i] = (short) stream1.readUnsignedShort();
				def.texIndices3[i] = (short) stream1.readUnsignedShort();
			}
		}

		stream1.setOffset(dataOffset);
		int unused = stream1.readUnsignedByte();
		if (unused != 0)
		{
			stream1.readUnsignedShort();
			stream1.readUnsignedShort();
			stream1.readUnsignedShort();
			stream1.readInt();
		}

	}

	void decodeOld_v2(ModelDefinition def, byte[] var1)
	{
		boolean usesFaceRenderTypes = false;
		boolean usesFaceTextures = false;
		InputStream stream1 = new InputStream(var1);
		InputStream stream2 = new InputStream(var1);
		InputStream stream3 = new InputStream(var1);
		InputStream stream4 = new InputStream(var1);
		InputStream stream5 = new InputStream(var1);
		stream1.setOffset(var1.length - 23);
		int vertexCount = stream1.readUnsignedShort();
		int faceCount = stream1.readUnsignedShort();
		int textureCount = stream1.readUnsignedByte();
		int isTextured = stream1.readUnsignedByte();
		int faceRenderPriority = stream1.readUnsignedByte();
		int hasFaceTransparencies = stream1.readUnsignedByte();
		int hasPackedTransparencyVertexGroups = stream1.readUnsignedByte();
		int hasPackedVertexGroups = stream1.readUnsignedByte();
		int _animGroups = stream1.readUnsignedByte();//7th added
		int vertexXDataByteCount = stream1.readUnsignedShort();
		int vertezYDataByteCount = stream1.readUnsignedShort();
		int vertezZDataByteCount = stream1.readUnsignedShort();
		int faceIndexDataByteCount = stream1.readUnsignedShort();
		int animCount = stream1.readUnsignedShort();
		byte offsetOfVertexFlags = 0;
		int dataOffset = offsetOfVertexFlags + vertexCount;
		int offsetOfFaceIndexCompressionTypes = dataOffset;
		dataOffset += faceCount;
		int offsetOfFaceRenderPriorities = dataOffset;
		if (faceRenderPriority == 255)
		{
			dataOffset += faceCount;
		}

		int offsetOfPackedTransparencyVertexGroups = dataOffset;
		if (hasPackedTransparencyVertexGroups == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfFaceTextureFlags = dataOffset;
		if (isTextured == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfPackedVertexGroups = dataOffset;
		dataOffset += animCount;
		int offsetOfFaceTransparencies = dataOffset;
		if (hasFaceTransparencies == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfFaceIndexData = dataOffset;
		dataOffset += faceIndexDataByteCount;
		int offsetOfFaceColorsOrFaceTextures = dataOffset;
		dataOffset += faceCount * 2;
		int offsetOfTextureIndices = dataOffset;
		dataOffset += textureCount * 6;
		int offsetOfVertexXData = dataOffset;
		dataOffset += vertexXDataByteCount;
		int offsetOfVertexYData = dataOffset;
		dataOffset += vertezYDataByteCount;
		int offsetOfVertexZData = dataOffset + vertezZDataByteCount;
		def.vertexCount = vertexCount;
		def.faceCount = faceCount;
		def.numTextureFaces = textureCount;
		def.vertexX = new int[vertexCount];
		def.vertexY = new int[vertexCount];
		def.vertexZ = new int[vertexCount];
		def.faceIndices1 = new int[faceCount];
		def.faceIndices2 = new int[faceCount];
		def.faceIndices3 = new int[faceCount];
		if (textureCount > 0)
		{
			def.textureRenderTypes = new byte[textureCount];
			def.texIndices1 = new short[textureCount];
			def.texIndices2 = new short[textureCount];
			def.texIndices3 = new short[textureCount];
		}

		if (hasPackedVertexGroups == 1)
		{
			def.packedVertexGroups = new int[vertexCount];
		}

		if (isTextured == 1)
		{
			def.faceRenderTypes = new byte[faceCount];
			def.textureCoords = new byte[faceCount];
			def.faceTextures = new short[faceCount];
		}

		if (faceRenderPriority == 255)
		{
			def.faceRenderPriorities = new byte[faceCount];
		}
		else
		{
			def.priority = (byte) faceRenderPriority;
		}

		if (hasFaceTransparencies == 1)
		{
			def.faceTransparencies = new byte[faceCount];
		}

		if (hasPackedTransparencyVertexGroups == 1)
		{
			def.packedTransparencyVertexGroups = new int[faceCount];
		}

		if (_animGroups == 1)
		{
			def.animayaGroups = new int[vertexCount][];
			def.animayaScales = new int[vertexCount][];
		}

		def.faceColors = new short[faceCount];
		stream1.setOffset(offsetOfVertexFlags);
		stream2.setOffset(offsetOfVertexXData);
		stream3.setOffset(offsetOfVertexYData);
		stream4.setOffset(dataOffset);
		stream5.setOffset(offsetOfPackedVertexGroups);
		int previousVertexX = 0;
		int previousVertexY = 0;
		int previousVertexZ = 0;

		for (int i = 0; i < vertexCount; ++i)
		{
			int vertexFlags = stream1.readUnsignedByte();
			int vertX = 0;
			if ((vertexFlags & 1) != 0)
			{
				vertX = stream2.readShortSmart();
			}

			int vertY = 0;
			if ((vertexFlags & 2) != 0)
			{
				vertY = stream3.readShortSmart();
			}

			int vertZ = 0;
			if ((vertexFlags & 4) != 0)
			{
				vertZ = stream4.readShortSmart();
			}

			def.vertexX[i] = previousVertexX + vertX;
			def.vertexY[i] = previousVertexY + vertY;
			def.vertexZ[i] = previousVertexZ + vertZ;
			previousVertexX = def.vertexX[i];
			previousVertexY = def.vertexY[i];
			previousVertexZ = def.vertexZ[i];
			if (hasPackedVertexGroups == 1)
			{
				def.packedVertexGroups[i] = stream5.readUnsignedByte();
			}
		}

		// TODO ADDED IN V2
		if (_animGroups == 1)
		{
			for (int i = 0; i < vertexCount; ++i)
			{
				int count = stream5.readUnsignedByte();
				def.animayaGroups[i] = new int[count];
				def.animayaScales[i] = new int[count];

				for (int i2 = 0; i2 < count; ++i2)
				{
					def.animayaGroups[i][i2] = stream5.readUnsignedByte();
					def.animayaScales[i][i2] = stream5.readUnsignedByte();
				}
			}
		}

		stream1.setOffset(offsetOfFaceColorsOrFaceTextures);
		stream2.setOffset(offsetOfFaceTextureFlags);
		stream3.setOffset(offsetOfFaceRenderPriorities);
		stream4.setOffset(offsetOfFaceTransparencies);
		stream5.setOffset(offsetOfPackedTransparencyVertexGroups);

		for (int i = 0; i < faceCount; ++i)
		{
			def.faceColors[i] = (short) stream1.readUnsignedShort();
			if (isTextured == 1)
			{
				int faceTextureFlags = stream2.readUnsignedByte();
				if ((faceTextureFlags & 1) == 1)
				{
					def.faceRenderTypes[i] = 1;
					usesFaceRenderTypes = true;
				}
				else
				{
					def.faceRenderTypes[i] = 0;
				}

				if ((faceTextureFlags & 2) == 2)
				{
					def.textureCoords[i] = (byte) (faceTextureFlags >> 2);
					def.faceTextures[i] = def.faceColors[i];
					def.faceColors[i] = 127;
					if (def.faceTextures[i] != -1)
					{
						usesFaceTextures = true;
					}
				}
				else
				{
					def.textureCoords[i] = -1;
					def.faceTextures[i] = -1;
				}
			}

			if (faceRenderPriority == 255)
			{
				def.faceRenderPriorities[i] = stream3.readByte();
			}

			if (hasFaceTransparencies == 1)
			{
				def.faceTransparencies[i] = stream4.readByte();
			}

			if (hasPackedTransparencyVertexGroups == 1)
			{
				def.packedTransparencyVertexGroups[i] = stream5.readUnsignedByte();
			}
		}

		stream1.setOffset(offsetOfFaceIndexData);
		stream2.setOffset(offsetOfFaceIndexCompressionTypes);

		for (int i2 = 0; i2 < faceCount; ++i2)
		{
			int faceIndexCompressionType = stream2.readUnsignedByte();
			if (faceIndexCompressionType == 1)
			{
				previousVertexX = stream1.readShortSmart() + previousVertexZ;
				previousVertexY = stream1.readShortSmart() + previousVertexX;
				previousVertexZ = stream1.readShortSmart() + previousVertexY;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i2] = previousVertexX;
				def.faceIndices2[i2] = previousVertexY;
				def.faceIndices3[i2] = previousVertexZ;
			}

			if (faceIndexCompressionType == 2)
			{
				previousVertexY = previousVertexZ;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i2] = previousVertexX;
				def.faceIndices2[i2] = previousVertexY;
				def.faceIndices3[i2] = previousVertexZ;
			}

			if (faceIndexCompressionType == 3)
			{
				previousVertexX = previousVertexZ;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i2] = previousVertexX;
				def.faceIndices2[i2] = previousVertexY;
				def.faceIndices3[i2] = previousVertexZ;
			}

			if (faceIndexCompressionType == 4)
			{
				int swap = previousVertexX;
				previousVertexX = previousVertexY;
				previousVertexY = swap;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i2] = previousVertexX;
				def.faceIndices2[i2] = previousVertexY;
				def.faceIndices3[i2] = previousVertexZ;
			}
		}

		stream1.setOffset(offsetOfTextureIndices);

		for (int i = 0; i < textureCount; ++i)
		{
			def.textureRenderTypes[i] = 0;
			def.texIndices1[i] = (short) stream1.readUnsignedShort();
			def.texIndices2[i] = (short) stream1.readUnsignedShort();
			def.texIndices3[i] = (short) stream1.readUnsignedShort();
		}

		if (def.textureCoords != null)
		{
			boolean usesTextureCoords = false;

			for (int i = 0; i < faceCount; ++i)
			{
				int coord = def.textureCoords[i] & 255;
				if (coord != 255)
				{
					if (def.faceIndices1[i] == (def.texIndices1[coord] & '\uffff') && def.faceIndices2[i] == (def.texIndices2[coord] & '\uffff') && def.faceIndices3[i] == (def.texIndices3[coord] & '\uffff'))
					{
						def.textureCoords[i] = -1;
					}
					else
					{
						usesTextureCoords = true;
					}
				}
			}

			if (!usesTextureCoords)
			{
				def.textureCoords = null;
			}
		}

		if (!usesFaceTextures)
		{
			def.faceTextures = null;
		}

		if (!usesFaceRenderTypes)
		{
			def.faceRenderTypes = null;
		}

	}

	void decodeNew_v1(ModelDefinition def, byte[] var1)
	{
		InputStream stream1 = new InputStream(var1);
		InputStream stream2 = new InputStream(var1);
		InputStream stream3 = new InputStream(var1);
		InputStream stream4 = new InputStream(var1);
		InputStream stream5 = new InputStream(var1);
		InputStream stream6 = new InputStream(var1);
		InputStream stream7 = new InputStream(var1);
		stream1.setOffset(var1.length - 23);
		int vertexCount = stream1.readUnsignedShort();
		int faceCount = stream1.readUnsignedShort();
		int textureCount = stream1.readUnsignedByte();
		int isTextured = stream1.readUnsignedByte();
		int faceRenderPriority = stream1.readUnsignedByte();
		int hasFaceTransparencies = stream1.readUnsignedByte();
		int hasPackedTransparencyVertexGroups = stream1.readUnsignedByte();
		int modelVertexSkins = stream1.readUnsignedByte();
		int _hasPackedVertexGroupsNEW = stream1.readUnsignedByte(); // 7th bytes
		int vertexXDataByteCount = stream1.readUnsignedShort();
		int vertezYDataByteCount = stream1.readUnsignedShort();
		int vertexZDataByteCount = stream1.readUnsignedShort();
		int faceIndexDataByteCount = stream1.readUnsignedShort();
		int _vertCount = stream1.readUnsignedShort();
		int textureAmount = 0;
		int newCountA = 0;
		int newCountB = 0;
		int dataOffset;
		if (textureCount > 0)
		{
			def.textureRenderTypes = new byte[textureCount];
			stream1.setOffset(0);

			for (int i = 0; i < textureCount; ++i)
			{
				byte flag = def.textureRenderTypes[i] = stream1.readByte();
				if (flag == 0)
				{
					++textureAmount;
				}

				if (flag >= 1 && flag <= 3)
				{
					++newCountA;
				}

				if (flag == 2)
				{
					++newCountB;
				}
			}
		}

		dataOffset = textureCount + vertexCount;
		int renderTypePos = dataOffset;
		if (isTextured == 1)
		{
			dataOffset += faceCount;
		}

		int offsetFaceTypes = dataOffset;
		dataOffset += faceCount;
		int priorityPos = dataOffset;
		if (faceRenderPriority == 255)
		{
			dataOffset += faceCount;
		}

		int triangleSkinPos = dataOffset;
		if (hasPackedTransparencyVertexGroups == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfFaceTextureFlags = dataOffset;
		if (_hasPackedVertexGroupsNEW == 1)
		{
			dataOffset += vertexCount;
		}

		int alphaPos = dataOffset;
		if (hasFaceTransparencies == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfPackedVertexGroups = dataOffset;
		dataOffset += faceIndexDataByteCount;
		int texturePos = dataOffset;
		if (modelVertexSkins == 1)
		{
			dataOffset += faceCount * 2;
		}

		int textureCoordPos = dataOffset;
		dataOffset += _vertCount;
		int colorPos = dataOffset;
		dataOffset += faceCount * 2;
		int o2b = dataOffset;
		dataOffset += vertexXDataByteCount;
		int o3b = dataOffset;
		dataOffset += vertezYDataByteCount;
		int o4b = dataOffset;
		dataOffset += vertexZDataByteCount;
		int offsetRenderTypes = dataOffset;
		dataOffset += textureAmount * 6;
		int offsetUnused2 = dataOffset;
		dataOffset += newCountA * 6;
		int offsetUnused3 = dataOffset;
		dataOffset += newCountA * 6;
		int offsetUnused4 = dataOffset;
		dataOffset += newCountA * 2;
		int offsetUnused5 = dataOffset;
		dataOffset += newCountA;
		int offsetUnused6 = dataOffset;
		dataOffset = dataOffset + newCountA * 2 + newCountB * 2;
		def.vertexCount = vertexCount;
		def.faceCount = faceCount;
		def.numTextureFaces = textureCount;
		def.vertexX = new int[vertexCount];
		def.vertexY = new int[vertexCount];
		def.vertexZ = new int[vertexCount];
		def.faceIndices1 = new int[faceCount];
		def.faceIndices2 = new int[faceCount];
		def.faceIndices3 = new int[faceCount];
		if (_hasPackedVertexGroupsNEW == 1)
		{
			def.packedVertexGroups = new int[vertexCount];
		}

		if (isTextured == 1)
		{
			def.faceRenderTypes = new byte[faceCount];
		}

		if (faceRenderPriority == 255)
		{
			def.faceRenderPriorities = new byte[faceCount];
		}
		else
		{
			def.priority = (byte) faceRenderPriority;
		}

		if (hasFaceTransparencies == 1)
		{
			def.faceTransparencies = new byte[faceCount];
		}

		if (hasPackedTransparencyVertexGroups == 1)
		{
			def.packedTransparencyVertexGroups = new int[faceCount];
		}

		if (modelVertexSkins == 1)
		{
			def.faceTextures = new short[faceCount];
		}

		if (modelVertexSkins == 1 && textureCount > 0)
		{
			def.textureCoords = new byte[faceCount];
		}

		def.faceColors = new short[faceCount];
		if (textureCount > 0)
		{
			def.texIndices1 = new short[textureCount];
			def.texIndices2 = new short[textureCount];
			def.texIndices3 = new short[textureCount];
		}

		stream1.setOffset(textureCount);
		stream2.setOffset(o2b);
		stream3.setOffset(o3b);
		stream4.setOffset(o4b);
		stream5.setOffset(offsetOfFaceTextureFlags);
		int previousVertexX = 0;
		int previousVertexY = 0;
		int previousVertexZ = 0;

		for (int i = 0; i < vertexCount; ++i)
		{
			int vertexFlags = stream1.readUnsignedByte();
			int vertX = 0;
			if ((vertexFlags & 1) != 0)
			{
				vertX = stream2.readShortSmart();
			}

			int vertY = 0;
			if ((vertexFlags & 2) != 0)
			{
				vertY = stream3.readShortSmart();
			}

			int vertZ = 0;
			if ((vertexFlags & 4) != 0)
			{
				vertZ = stream4.readShortSmart();
			}

			def.vertexX[i] = previousVertexX + vertX;
			def.vertexY[i] = previousVertexY + vertY;
			def.vertexZ[i] = previousVertexZ + vertZ;
			previousVertexX = def.vertexX[i];
			previousVertexY = def.vertexY[i];
			previousVertexZ = def.vertexZ[i];
			if (_hasPackedVertexGroupsNEW == 1)
			{
				def.packedVertexGroups[i] = stream5.readUnsignedByte();
			}
		}

		stream1.setOffset(colorPos);
		stream2.setOffset(renderTypePos);
		stream3.setOffset(priorityPos);
		stream4.setOffset(alphaPos);
		stream5.setOffset(triangleSkinPos);
		stream6.setOffset(texturePos);
		stream7.setOffset(textureCoordPos);

		for (int i = 0; i < faceCount; ++i)
		{
			def.faceColors[i] = (short) stream1.readUnsignedShort();
			if (isTextured == 1)
			{
				def.faceRenderTypes[i] = stream2.readByte();
			}

			if (faceRenderPriority == 255)
			{
				def.faceRenderPriorities[i] = stream3.readByte();
			}

			if (hasFaceTransparencies == 1)
			{
				def.faceTransparencies[i] = stream4.readByte();
			}

			if (hasPackedTransparencyVertexGroups == 1)
			{
				def.packedTransparencyVertexGroups[i] = stream5.readUnsignedByte();
			}

			if (modelVertexSkins == 1)
			{
				def.faceTextures[i] = (short) (stream6.readUnsignedShort() - 1);
			}

			if (def.textureCoords != null && def.faceTextures[i] != -1)
			{
				def.textureCoords[i] = (byte) (stream7.readUnsignedByte() - 1);
			}
		}

		stream1.setOffset(offsetOfPackedVertexGroups);
		stream2.setOffset(offsetFaceTypes);

		for (int i = 0; i < faceCount; ++i)
		{
			int faceIndexCompressionType = stream2.readUnsignedByte();
			if (faceIndexCompressionType == 1)
			{
				previousVertexX = stream1.readShortSmart() + previousVertexZ;
				previousVertexY = stream1.readShortSmart() + previousVertexX;
				previousVertexZ = stream1.readShortSmart() + previousVertexY;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}

			if (faceIndexCompressionType == 2)
			{
				previousVertexY = previousVertexZ;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}

			if (faceIndexCompressionType == 3)
			{
				previousVertexX = previousVertexZ;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}

			if (faceIndexCompressionType == 4)
			{
				int swap = previousVertexX;
				previousVertexX = previousVertexY;
				previousVertexY = swap;
				previousVertexZ = stream1.readShortSmart() + previousVertexZ;
				previousVertexZ = previousVertexZ;
				def.faceIndices1[i] = previousVertexX;
				def.faceIndices2[i] = previousVertexY;
				def.faceIndices3[i] = previousVertexZ;
			}
		}

		stream1.setOffset(offsetRenderTypes);
		stream2.setOffset(offsetUnused2);
		stream3.setOffset(offsetUnused3);
		stream4.setOffset(offsetUnused4);
		stream5.setOffset(offsetUnused5);
		stream6.setOffset(offsetUnused6);

		for (int i = 0; i < textureCount; ++i)
		{
			int type = def.textureRenderTypes[i] & 255;
			if (type == 0)
			{
				def.texIndices1[i] = (short) stream1.readUnsignedShort();
				def.texIndices2[i] = (short) stream1.readUnsignedShort();
				def.texIndices3[i] = (short) stream1.readUnsignedShort();
			}
		}

		stream1.setOffset(dataOffset);
		int unused = stream1.readUnsignedByte();
		if (unused != 0)
		{
			stream1.readUnsignedShort();
			stream1.readUnsignedShort();
			stream1.readUnsignedShort();
			stream1.readInt();
		}

	}

	void decodeOld_v1(ModelDefinition def, byte[] inputData)
	{
		boolean usesFaceRenderTypes = false;
		boolean usesFaceTextures = false;
		InputStream stream1 = new InputStream(inputData);
		InputStream stream2 = new InputStream(inputData);
		InputStream stream3 = new InputStream(inputData);
		InputStream stream4 = new InputStream(inputData);
		InputStream stream5 = new InputStream(inputData);
		stream1.setOffset(inputData.length - 18);
		int vertexCount = stream1.readUnsignedShort();
		int faceCount = stream1.readUnsignedShort();
		int textureCount = stream1.readUnsignedByte();
		int isTextured = stream1.readUnsignedByte();
		int faceRenderPriority = stream1.readUnsignedByte();
		int hasFaceTransparencies = stream1.readUnsignedByte();
		int hasPackedTransparencyVertexGroups = stream1.readUnsignedByte();
		int hasPackedVertexGroups = stream1.readUnsignedByte(); // 6th byte, 6 total
		int vertexXDataByteCount = stream1.readUnsignedShort();
		int vertexYDataByteCount = stream1.readUnsignedShort();
		int vertezZDataByteCount = stream1.readUnsignedShort();
		int faceIndexDataByteCount = stream1.readUnsignedShort();
		byte offsetOfVertexFlags = 0;
		int dataOffset = offsetOfVertexFlags + vertexCount;
		int offsetOfFaceIndexCompressionTypes = dataOffset;
		dataOffset += faceCount;
		int offsetOfFaceRenderPriorities = dataOffset;
		if (faceRenderPriority == 255)
		{
			dataOffset += faceCount;
		}

		int offsetOfPackedTransparencyVertexGroups = dataOffset;
		if (hasPackedTransparencyVertexGroups == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfFaceTextureFlags = dataOffset;
		if (isTextured == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfPackedVertexGroups = dataOffset;
		if (hasPackedVertexGroups == 1)
		{
			dataOffset += vertexCount;
		}

		int offsetOfFaceTransparencies = dataOffset;
		if (hasFaceTransparencies == 1)
		{
			dataOffset += faceCount;
		}

		int offsetOfFaceIndexData = dataOffset;
		dataOffset += faceIndexDataByteCount;
		int offsetOfFaceColorsOrFaceTextures = dataOffset;
		dataOffset += faceCount * 2;
		int offsetOfTextureIndices = dataOffset;
		dataOffset += textureCount * 6;
		int offsetOfVertexXData = dataOffset;
		dataOffset += vertexXDataByteCount;
		int offsetOfVertexYData = dataOffset;
		dataOffset += vertexYDataByteCount;
		int offsetOfVertexZData = dataOffset;
		def.vertexCount = vertexCount;
		def.faceCount = faceCount;
		def.numTextureFaces = textureCount;
		def.vertexX = new int[vertexCount];
		def.vertexY = new int[vertexCount];
		def.vertexZ = new int[vertexCount];
		def.faceIndices1 = new int[faceCount];
		def.faceIndices2 = new int[faceCount];
		def.faceIndices3 = new int[faceCount];
		if (textureCount > 0)
		{
			def.textureRenderTypes = new byte[textureCount];
			def.texIndices1 = new short[textureCount];
			def.texIndices2 = new short[textureCount];
			def.texIndices3 = new short[textureCount];
		}

		if (hasPackedVertexGroups == 1)
		{
			def.packedVertexGroups = new int[vertexCount];
		}

		if (isTextured == 1)
		{
			def.faceRenderTypes = new byte[faceCount];
			def.textureCoords = new byte[faceCount];
			def.faceTextures = new short[faceCount];
		}

		if (faceRenderPriority == 255)
		{
			def.faceRenderPriorities = new byte[faceCount];
		}
		else
		{
			def.priority = (byte) faceRenderPriority;
		}

		if (hasFaceTransparencies == 1)
		{
			def.faceTransparencies = new byte[faceCount];
		}

		if (hasPackedTransparencyVertexGroups == 1)
		{
			def.packedTransparencyVertexGroups = new int[faceCount];
		}

		def.faceColors = new short[faceCount];
		stream1.setOffset(offsetOfVertexFlags);
		stream2.setOffset(offsetOfVertexXData);
		stream3.setOffset(offsetOfVertexYData);
		stream4.setOffset(offsetOfVertexZData);
		stream5.setOffset(offsetOfPackedVertexGroups);
		int previousVertexX = 0;
		int previousVertexY = 0;
		int previousVertexZ = 0;

		for (int i = 0; i < vertexCount; ++i)
		{
			int vertexFlags = stream1.readUnsignedByte();
			int vertX = 0;
			if ((vertexFlags & 1) != 0)
			{
				vertX = stream2.readShortSmart();
			}

			int vertY = 0;
			if ((vertexFlags & 2) != 0)
			{
				vertY = stream3.readShortSmart();
			}

			int vertZ = 0;
			if ((vertexFlags & 4) != 0)
			{
				vertZ = stream4.readShortSmart();
			}

			def.vertexX[i] = previousVertexX + vertX;
			def.vertexY[i] = previousVertexY + vertY;
			def.vertexZ[i] = previousVertexZ + vertZ;
			previousVertexX = def.vertexX[i];
			previousVertexY = def.vertexY[i];
			previousVertexZ = def.vertexZ[i];
			if (hasPackedVertexGroups == 1)
			{
				def.packedVertexGroups[i] = stream5.readUnsignedByte();
			}
		}

		stream1.setOffset(offsetOfFaceColorsOrFaceTextures);
		stream2.setOffset(offsetOfFaceTextureFlags);
		stream3.setOffset(offsetOfFaceRenderPriorities);
		stream4.setOffset(offsetOfFaceTransparencies);
		stream5.setOffset(offsetOfPackedTransparencyVertexGroups);

		for (int i = 0; i < faceCount; ++i)
		{
			def.faceColors[i] = (short) stream1.readUnsignedShort();
			if (isTextured == 1)
			{
				int faceTextureFlags = stream2.readUnsignedByte();
				if ((faceTextureFlags & 1) == 1)
				{
					def.faceRenderTypes[i] = 1;
					usesFaceRenderTypes = true;
				}
				else
				{
					def.faceRenderTypes[i] = 0;
				}

				if ((faceTextureFlags & 2) == 2)
				{
					def.textureCoords[i] = (byte) (faceTextureFlags >> 2);
					def.faceTextures[i] = def.faceColors[i];
					def.faceColors[i] = 127;
					if (def.faceTextures[i] != -1)
					{
						usesFaceTextures = true;
					}
				}
				else
				{
					def.textureCoords[i] = -1;
					def.faceTextures[i] = -1;
				}
			}

			if (faceRenderPriority == 255)
			{
				def.faceRenderPriorities[i] = stream3.readByte();
			}

			if (hasFaceTransparencies == 1)
			{
				def.faceTransparencies[i] = stream4.readByte();
			}

			if (hasPackedTransparencyVertexGroups == 1)
			{
				def.packedTransparencyVertexGroups[i] = stream5.readUnsignedByte();
			}
		}

		stream1.setOffset(offsetOfFaceIndexData);
		stream2.setOffset(offsetOfFaceIndexCompressionTypes);
		int previousIndex1 = 0;
		int previousIndex2 = 0;
		int previousIndex3 = 0;

		for (int i = 0; i < faceCount; ++i)
		{
			int faceIndexCompressionType = stream2.readUnsignedByte();
			if (faceIndexCompressionType == 1)
			{
				previousIndex1 = stream1.readShortSmart() + previousIndex3;
				previousIndex2 = stream1.readShortSmart() + previousIndex1;
				previousIndex3 = stream1.readShortSmart() + previousIndex2;
				def.faceIndices1[i] = previousIndex1;
				def.faceIndices2[i] = previousIndex2;
				def.faceIndices3[i] = previousIndex3;
			}

			if (faceIndexCompressionType == 2)
			{
				previousIndex2 = previousIndex3;
				previousIndex3 = stream1.readShortSmart() + previousIndex3;
				def.faceIndices1[i] = previousIndex1;
				def.faceIndices2[i] = previousIndex2;
				def.faceIndices3[i] = previousIndex3;
			}

			if (faceIndexCompressionType == 3)
			{
				previousIndex1 = previousIndex3;
				previousIndex3 = stream1.readShortSmart() + previousIndex3;
				def.faceIndices1[i] = previousIndex1;
				def.faceIndices2[i] = previousIndex2;
				def.faceIndices3[i] = previousIndex3;
			}

			if (faceIndexCompressionType == 4)
			{
				int swap = previousIndex1;
				previousIndex1 = previousIndex2;
				previousIndex2 = swap;
				previousIndex3 = stream1.readShortSmart() + previousIndex3;
				def.faceIndices1[i] = previousIndex1;
				def.faceIndices2[i] = previousIndex2;
				def.faceIndices3[i] = previousIndex3;
			}
		}

		stream1.setOffset(offsetOfTextureIndices);

		for (int i = 0; i < textureCount; ++i)
		{
			def.textureRenderTypes[i] = 0;
			def.texIndices1[i] = (short) stream1.readUnsignedShort();
			def.texIndices2[i] = (short) stream1.readUnsignedShort();
			def.texIndices3[i] = (short) stream1.readUnsignedShort();
		}

		if (def.textureCoords != null)
		{
			boolean usesTextureCoords = false;

			for (int i = 0; i < faceCount; ++i)
			{
				int coord = def.textureCoords[i] & 255;
				if (coord != 255)
				{
					if (def.faceIndices1[i] == (def.texIndices1[coord] & '\uffff') && def.faceIndices2[i] == (def.texIndices2[coord] & '\uffff') && def.faceIndices3[i] == (def.texIndices3[coord] & '\uffff'))
					{
						def.textureCoords[i] = -1;
					}
					else
					{
						usesTextureCoords = true;
					}
				}
			}

			if (!usesTextureCoords)
			{
				def.textureCoords = null;
			}
		}

		if (!usesFaceTextures)
		{
			def.faceTextures = null;
		}

		if (!usesFaceRenderTypes)
		{
			def.faceRenderTypes = null;
		}

	}

}
