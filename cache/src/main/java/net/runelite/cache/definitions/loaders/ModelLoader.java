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
			decodeType3(def, b);
		}
		else if (b[b.length - 1] == -2 && b[b.length - 2] == -1)
		{
			decodeType2(def, b);
		}
		else if (b[b.length - 1] == -1 && b[b.length - 2] == -1)
		{
			decodeType1(def, b);
		}
		else
		{
			decodeOldFormat(def, b);
		}

		def.computeNormals();
		def.computeTextureUVCoordinates();
		def.computeAnimationTables();

		return def;
	}

	void decodeType3(ModelDefinition def, byte[] var1)
	{
		InputStream var2 = new InputStream(var1);
		InputStream var3 = new InputStream(var1);
		InputStream var4 = new InputStream(var1);
		InputStream var5 = new InputStream(var1);
		InputStream var6 = new InputStream(var1);
		InputStream var7 = new InputStream(var1);
		InputStream var8 = new InputStream(var1);
		var2.setOffset(var1.length - 26);
		int var9 = var2.readUnsignedShort();
		int var10 = var2.readUnsignedShort();
		int var11 = var2.readUnsignedByte();
		int var12 = var2.readUnsignedByte();
		int var13 = var2.readUnsignedByte();
		int var14 = var2.readUnsignedByte();
		int var15 = var2.readUnsignedByte();
		int var16 = var2.readUnsignedByte();
		int var17 = var2.readUnsignedByte();
		int var18 = var2.readUnsignedByte();
		int var19 = var2.readUnsignedShort();
		int var20 = var2.readUnsignedShort();
		int var21 = var2.readUnsignedShort();
		int var22 = var2.readUnsignedShort();
		int var23 = var2.readUnsignedShort();
		int var24 = var2.readUnsignedShort();
		int var25 = 0;
		int var26 = 0;
		int var27 = 0;
		int var28;
		if (var11 > 0)
		{
			def.textureRenderTypes = new byte[var11];
			var2.setOffset(0);

			for (var28 = 0; var28 < var11; ++var28)
			{
				byte var29 = def.textureRenderTypes[var28] = var2.readByte();
				if (var29 == 0)
				{
					++var25;
				}

				if (var29 >= 1 && var29 <= 3)
				{
					++var26;
				}

				if (var29 == 2)
				{
					++var27;
				}
			}
		}

		var28 = var11 + var9;
		int var58 = var28;
		if (var12 == 1)
		{
			var28 += var10;
		}

		int var30 = var28;
		var28 += var10;
		int var31 = var28;
		if (var13 == 255)
		{
			var28 += var10;
		}

		int var32 = var28;
		if (var15 == 1)
		{
			var28 += var10;
		}

		int var33 = var28;
		var28 += var24;
		int var34 = var28;
		if (var14 == 1)
		{
			var28 += var10;
		}

		int var35 = var28;
		var28 += var22;
		int var36 = var28;
		if (var16 == 1)
		{
			var28 += var10 * 2;
		}

		int var37 = var28;
		var28 += var23;
		int var38 = var28;
		var28 += var10 * 2;
		int var39 = var28;
		var28 += var19;
		int var40 = var28;
		var28 += var20;
		int var41 = var28;
		var28 += var21;
		int var42 = var28;
		var28 += var25 * 6;
		int var43 = var28;
		var28 += var26 * 6;
		int var44 = var28;
		var28 += var26 * 6;
		int var45 = var28;
		var28 += var26 * 2;
		int var46 = var28;
		var28 += var26;
		int var47 = var28;
		var28 = var28 + var26 * 2 + var27 * 2;
		def.vertexCount = var9;
		def.faceCount = var10;
		def.numTextureFaces = var11;
		def.vertexX = new int[var9];
		def.vertexY = new int[var9];
		def.vertexZ = new int[var9];
		def.faceIndices1 = new int[var10];
		def.faceIndices2 = new int[var10];
		def.faceIndices3 = new int[var10];
		if (var17 == 1)
		{
			def.packedVertexGroups = new int[var9];
		}

		if (var12 == 1)
		{
			def.faceRenderTypes = new byte[var10];
		}

		if (var13 == 255)
		{
			def.faceRenderPriorities = new byte[var10];
		}
		else
		{
			def.priority = (byte) var13;
		}

		if (var14 == 1)
		{
			def.faceTransparencies = new byte[var10];
		}

		if (var15 == 1)
		{
			def.packedTransparencyVertexGroups = new int[var10];
		}

		if (var16 == 1)
		{
			def.faceTextures = new short[var10];
		}

		if (var16 == 1 && var11 > 0)
		{
			def.textureCoords = new byte[var10];
		}

		if (var18 == 1)
		{
			def.animayaGroups = new int[var9][];
			def.animayaScales = new int[var9][];
		}

		def.faceColors = new short[var10];
		if (var11 > 0)
		{
			def.texIndices1 = new short[var11];
			def.texIndices2 = new short[var11];
			def.texIndices3 = new short[var11];
		}

		var2.setOffset(var11);
		var3.setOffset(var39);
		var4.setOffset(var40);
		var5.setOffset(var41);
		var6.setOffset(var33);
		int var48 = 0;
		int var49 = 0;
		int var50 = 0;

		int var51;
		int var52;
		int var53;
		int var54;
		int var55;
		for (var51 = 0; var51 < var9; ++var51)
		{
			var52 = var2.readUnsignedByte();
			var53 = 0;
			if ((var52 & 1) != 0)
			{
				var53 = var3.readShortSmart();
			}

			var54 = 0;
			if ((var52 & 2) != 0)
			{
				var54 = var4.readShortSmart();
			}

			var55 = 0;
			if ((var52 & 4) != 0)
			{
				var55 = var5.readShortSmart();
			}

			def.vertexX[var51] = var48 + var53;
			def.vertexY[var51] = var49 + var54;
			def.vertexZ[var51] = var50 + var55;
			var48 = def.vertexX[var51];
			var49 = def.vertexY[var51];
			var50 = def.vertexZ[var51];
			if (var17 == 1)
			{
				def.packedVertexGroups[var51] = var6.readUnsignedByte();
			}
		}

		if (var18 == 1)
		{
			for (var51 = 0; var51 < var9; ++var51)
			{
				var52 = var6.readUnsignedByte();
				def.animayaGroups[var51] = new int[var52];
				def.animayaScales[var51] = new int[var52];

				for (var53 = 0; var53 < var52; ++var53)
				{
					def.animayaGroups[var51][var53] = var6.readUnsignedByte();
					def.animayaScales[var51][var53] = var6.readUnsignedByte();
				}
			}
		}

		var2.setOffset(var38);
		var3.setOffset(var58);
		var4.setOffset(var31);
		var5.setOffset(var34);
		var6.setOffset(var32);
		var7.setOffset(var36);
		var8.setOffset(var37);

		for (var51 = 0; var51 < var10; ++var51)
		{
			def.faceColors[var51] = (short) var2.readUnsignedShort();
			if (var12 == 1)
			{
				def.faceRenderTypes[var51] = var3.readByte();
			}

			if (var13 == 255)
			{
				def.faceRenderPriorities[var51] = var4.readByte();
			}

			if (var14 == 1)
			{
				def.faceTransparencies[var51] = var5.readByte();
			}

			if (var15 == 1)
			{
				def.packedTransparencyVertexGroups[var51] = var6.readUnsignedByte();
			}

			if (var16 == 1)
			{
				def.faceTextures[var51] = (short) (var7.readUnsignedShort() - 1);
			}

			if (def.textureCoords != null && def.faceTextures[var51] != -1)
			{
				def.textureCoords[var51] = (byte) (var8.readUnsignedByte() - 1);
			}
		}

		var2.setOffset(var35);
		var3.setOffset(var30);
		var51 = 0;
		var52 = 0;
		var53 = 0;
		var54 = 0;

		int var56;
		for (var55 = 0; var55 < var10; ++var55)
		{
			var56 = var3.readUnsignedByte();
			if (var56 == 1)
			{
				var51 = var2.readShortSmart() + var54;
				var52 = var2.readShortSmart() + var51;
				var53 = var2.readShortSmart() + var52;
				var54 = var53;
				def.faceIndices1[var55] = var51;
				def.faceIndices2[var55] = var52;
				def.faceIndices3[var55] = var53;
			}

			if (var56 == 2)
			{
				var52 = var53;
				var53 = var2.readShortSmart() + var54;
				var54 = var53;
				def.faceIndices1[var55] = var51;
				def.faceIndices2[var55] = var52;
				def.faceIndices3[var55] = var53;
			}

			if (var56 == 3)
			{
				var51 = var53;
				var53 = var2.readShortSmart() + var54;
				var54 = var53;
				def.faceIndices1[var55] = var51;
				def.faceIndices2[var55] = var52;
				def.faceIndices3[var55] = var53;
			}

			if (var56 == 4)
			{
				int var57 = var51;
				var51 = var52;
				var52 = var57;
				var53 = var2.readShortSmart() + var54;
				var54 = var53;
				def.faceIndices1[var55] = var51;
				def.faceIndices2[var55] = var57;
				def.faceIndices3[var55] = var53;
			}
		}

		var2.setOffset(var42);
		var3.setOffset(var43);
		var4.setOffset(var44);
		var5.setOffset(var45);
		var6.setOffset(var46);
		var7.setOffset(var47);

		for (var55 = 0; var55 < var11; ++var55)
		{
			var56 = def.textureRenderTypes[var55] & 255;
			if (var56 == 0)
			{
				def.texIndices1[var55] = (short) var2.readUnsignedShort();
				def.texIndices2[var55] = (short) var2.readUnsignedShort();
				def.texIndices3[var55] = (short) var2.readUnsignedShort();
			}
		}

		var2.setOffset(var28);
		var55 = var2.readUnsignedByte();
		if (var55 != 0)
		{
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readInt();
		}

		boolean hasOffsets = var2.readUnsignedByte() == 1;
		if (hasOffsets)
		{
			def.faceZOffsets = new byte[var10];

			for (int i = 0; i < var10; ++i)
			{
				def.faceZOffsets[i] = var2.readByte();
			}
		}
	}

	void decodeType2(ModelDefinition def, byte[] var1)
	{
		boolean var2 = false;
		boolean var3 = false;
		InputStream var4 = new InputStream(var1);
		InputStream var5 = new InputStream(var1);
		InputStream var6 = new InputStream(var1);
		InputStream var7 = new InputStream(var1);
		InputStream var8 = new InputStream(var1);
		var4.setOffset(var1.length - 23);
		int var9 = var4.readUnsignedShort();
		int var10 = var4.readUnsignedShort();
		int var11 = var4.readUnsignedByte();
		int var12 = var4.readUnsignedByte();
		int var13 = var4.readUnsignedByte();
		int var14 = var4.readUnsignedByte();
		int var15 = var4.readUnsignedByte();
		int var16 = var4.readUnsignedByte();
		int var17 = var4.readUnsignedByte();
		int var18 = var4.readUnsignedShort();
		int var19 = var4.readUnsignedShort();
		int var20 = var4.readUnsignedShort();
		int var21 = var4.readUnsignedShort();
		int var22 = var4.readUnsignedShort();
		byte var23 = 0;
		int var24 = var23 + var9;
		int var25 = var24;
		var24 += var10;
		int var26 = var24;
		if (var13 == 255)
		{
			var24 += var10;
		}

		int var27 = var24;
		if (var15 == 1)
		{
			var24 += var10;
		}

		int var28 = var24;
		if (var12 == 1)
		{
			var24 += var10;
		}

		int var29 = var24;
		var24 += var22;
		int var30 = var24;
		if (var14 == 1)
		{
			var24 += var10;
		}

		int var31 = var24;
		var24 += var21;
		int var32 = var24;
		var24 += var10 * 2;
		int var33 = var24;
		var24 += var11 * 6;
		int var34 = var24;
		var24 += var18;
		int var35 = var24;
		var24 += var19;
		int var36 = var24;
		var24 += var20;
		def.vertexCount = var9;
		def.faceCount = var10;
		def.numTextureFaces = var11;
		def.vertexX = new int[var9];
		def.vertexY = new int[var9];
		def.vertexZ = new int[var9];
		def.faceIndices1 = new int[var10];
		def.faceIndices2 = new int[var10];
		def.faceIndices3 = new int[var10];
		if (var11 > 0)
		{
			def.textureRenderTypes = new byte[var11];
			def.texIndices1 = new short[var11];
			def.texIndices2 = new short[var11];
			def.texIndices3 = new short[var11];
		}

		if (var16 == 1)
		{
			def.packedVertexGroups = new int[var9];
		}

		if (var12 == 1)
		{
			def.faceRenderTypes = new byte[var10];
			def.textureCoords = new byte[var10];
			def.faceTextures = new short[var10];
		}

		if (var13 == 255)
		{
			def.faceRenderPriorities = new byte[var10];
		}
		else
		{
			def.priority = (byte) var13;
		}

		if (var14 == 1)
		{
			def.faceTransparencies = new byte[var10];
		}

		if (var15 == 1)
		{
			def.packedTransparencyVertexGroups = new int[var10];
		}

		if (var17 == 1)
		{
			def.animayaGroups = new int[var9][];
			def.animayaScales = new int[var9][];
		}

		def.faceColors = new short[var10];
		var4.setOffset(var23);
		var5.setOffset(var34);
		var6.setOffset(var35);
		var7.setOffset(var36);
		var8.setOffset(var29);
		int var37 = 0;
		int var38 = 0;
		int var39 = 0;

		int var40;
		int var41;
		int var42;
		int var43;
		int var44;
		for (var40 = 0; var40 < var9; ++var40)
		{
			var41 = var4.readUnsignedByte();
			var42 = 0;
			if ((var41 & 1) != 0)
			{
				var42 = var5.readShortSmart();
			}

			var43 = 0;
			if ((var41 & 2) != 0)
			{
				var43 = var6.readShortSmart();
			}

			var44 = 0;
			if ((var41 & 4) != 0)
			{
				var44 = var7.readShortSmart();
			}

			def.vertexX[var40] = var37 + var42;
			def.vertexY[var40] = var38 + var43;
			def.vertexZ[var40] = var39 + var44;
			var37 = def.vertexX[var40];
			var38 = def.vertexY[var40];
			var39 = def.vertexZ[var40];
			if (var16 == 1)
			{
				def.packedVertexGroups[var40] = var8.readUnsignedByte();
			}
		}

		if (var17 == 1)
		{
			for (var40 = 0; var40 < var9; ++var40)
			{
				var41 = var8.readUnsignedByte();
				def.animayaGroups[var40] = new int[var41];
				def.animayaScales[var40] = new int[var41];

				for (var42 = 0; var42 < var41; ++var42)
				{
					def.animayaGroups[var40][var42] = var8.readUnsignedByte();
					def.animayaScales[var40][var42] = var8.readUnsignedByte();
				}
			}
		}

		var4.setOffset(var32);
		var5.setOffset(var28);
		var6.setOffset(var26);
		var7.setOffset(var30);
		var8.setOffset(var27);

		for (var40 = 0; var40 < var10; ++var40)
		{
			def.faceColors[var40] = (short) var4.readUnsignedShort();
			if (var12 == 1)
			{
				var41 = var5.readUnsignedByte();
				if ((var41 & 1) == 1)
				{
					def.faceRenderTypes[var40] = 1;
					var2 = true;
				}
				else
				{
					def.faceRenderTypes[var40] = 0;
				}

				if ((var41 & 2) == 2)
				{
					def.textureCoords[var40] = (byte) (var41 >> 2);
					def.faceTextures[var40] = def.faceColors[var40];
					def.faceColors[var40] = 127;
					if (def.faceTextures[var40] != -1)
					{
						var3 = true;
					}
				}
				else
				{
					def.textureCoords[var40] = -1;
					def.faceTextures[var40] = -1;
				}
			}

			if (var13 == 255)
			{
				def.faceRenderPriorities[var40] = var6.readByte();
			}

			if (var14 == 1)
			{
				def.faceTransparencies[var40] = var7.readByte();
			}

			if (var15 == 1)
			{
				def.packedTransparencyVertexGroups[var40] = var8.readUnsignedByte();
			}
		}

		var4.setOffset(var31);
		var5.setOffset(var25);
		var40 = 0;
		var41 = 0;
		var42 = 0;
		var43 = 0;

		int var45;
		int var46;
		for (var44 = 0; var44 < var10; ++var44)
		{
			var45 = var5.readUnsignedByte();
			if (var45 == 1)
			{
				var40 = var4.readShortSmart() + var43;
				var41 = var4.readShortSmart() + var40;
				var42 = var4.readShortSmart() + var41;
				var43 = var42;
				def.faceIndices1[var44] = var40;
				def.faceIndices2[var44] = var41;
				def.faceIndices3[var44] = var42;
			}

			if (var45 == 2)
			{
				var41 = var42;
				var42 = var4.readShortSmart() + var43;
				var43 = var42;
				def.faceIndices1[var44] = var40;
				def.faceIndices2[var44] = var41;
				def.faceIndices3[var44] = var42;
			}

			if (var45 == 3)
			{
				var40 = var42;
				var42 = var4.readShortSmart() + var43;
				var43 = var42;
				def.faceIndices1[var44] = var40;
				def.faceIndices2[var44] = var41;
				def.faceIndices3[var44] = var42;
			}

			if (var45 == 4)
			{
				var46 = var40;
				var40 = var41;
				var41 = var46;
				var42 = var4.readShortSmart() + var43;
				var43 = var42;
				def.faceIndices1[var44] = var40;
				def.faceIndices2[var44] = var46;
				def.faceIndices3[var44] = var42;
			}
		}

		var4.setOffset(var33);

		for (var44 = 0; var44 < var11; ++var44)
		{
			def.textureRenderTypes[var44] = 0;
			def.texIndices1[var44] = (short) var4.readUnsignedShort();
			def.texIndices2[var44] = (short) var4.readUnsignedShort();
			def.texIndices3[var44] = (short) var4.readUnsignedShort();
		}

		var4.setOffset(var24);
		boolean hasOffsets = var4.readUnsignedByte() == 1;
		if (hasOffsets)
		{
			def.faceZOffsets = new byte[var10];

			for (var45 = 0; var45 < var10; ++var45)
			{
				def.faceZOffsets[var45] = var4.readByte();
			}
		}

		if (def.textureCoords != null)
		{
			boolean var47 = false;

			for (var45 = 0; var45 < var10; ++var45)
			{
				var46 = def.textureCoords[var45] & 255;
				if (var46 != 255)
				{
					if (def.faceIndices1[var45] == (def.texIndices1[var46] & '\uffff') && def.faceIndices2[var45] == (def.texIndices2[var46] & '\uffff') && def.faceIndices3[var45] == (def.texIndices3[var46] & '\uffff'))
					{
						def.textureCoords[var45] = -1;
					}
					else
					{
						var47 = true;
					}
				}
			}

			if (!var47)
			{
				def.textureCoords = null;
			}
		}

		if (!var3)
		{
			def.faceTextures = null;
		}

		if (!var2)
		{
			def.faceRenderTypes = null;
		}

	}

	void decodeType1(ModelDefinition def, byte[] var1)
	{
		InputStream var2 = new InputStream(var1);
		InputStream var3 = new InputStream(var1);
		InputStream var4 = new InputStream(var1);
		InputStream var5 = new InputStream(var1);
		InputStream var6 = new InputStream(var1);
		InputStream var7 = new InputStream(var1);
		InputStream var8 = new InputStream(var1);
		var2.setOffset(var1.length - 23);
		int var9 = var2.readUnsignedShort();
		int var10 = var2.readUnsignedShort();
		int var11 = var2.readUnsignedByte();
		int var12 = var2.readUnsignedByte();
		int var13 = var2.readUnsignedByte();
		int var14 = var2.readUnsignedByte();
		int var15 = var2.readUnsignedByte();
		int var16 = var2.readUnsignedByte();
		int var17 = var2.readUnsignedByte();
		int var18 = var2.readUnsignedShort();
		int var19 = var2.readUnsignedShort();
		int var20 = var2.readUnsignedShort();
		int var21 = var2.readUnsignedShort();
		int var22 = var2.readUnsignedShort();
		int var23 = 0;
		int var24 = 0;
		int var25 = 0;
		int var26;
		if (var11 > 0)
		{
			def.textureRenderTypes = new byte[var11];
			var2.setOffset(0);

			for (var26 = 0; var26 < var11; ++var26)
			{
				byte var27 = def.textureRenderTypes[var26] = var2.readByte();
				if (var27 == 0)
				{
					++var23;
				}

				if (var27 >= 1 && var27 <= 3)
				{
					++var24;
				}

				if (var27 == 2)
				{
					++var25;
				}
			}
		}

		var26 = var11 + var9;
		int var56 = var26;
		if (var12 == 1)
		{
			var26 += var10;
		}

		int var28 = var26;
		var26 += var10;
		int var29 = var26;
		if (var13 == 255)
		{
			var26 += var10;
		}

		int var30 = var26;
		if (var15 == 1)
		{
			var26 += var10;
		}

		int var31 = var26;
		if (var17 == 1)
		{
			var26 += var9;
		}

		int var32 = var26;
		if (var14 == 1)
		{
			var26 += var10;
		}

		int var33 = var26;
		var26 += var21;
		int var34 = var26;
		if (var16 == 1)
		{
			var26 += var10 * 2;
		}

		int var35 = var26;
		var26 += var22;
		int var36 = var26;
		var26 += var10 * 2;
		int var37 = var26;
		var26 += var18;
		int var38 = var26;
		var26 += var19;
		int var39 = var26;
		var26 += var20;
		int var40 = var26;
		var26 += var23 * 6;
		int var41 = var26;
		var26 += var24 * 6;
		int var42 = var26;
		var26 += var24 * 6;
		int var43 = var26;
		var26 += var24 * 2;
		int var44 = var26;
		var26 += var24;
		int var45 = var26;
		var26 = var26 + var24 * 2 + var25 * 2;
		def.vertexCount = var9;
		def.faceCount = var10;
		def.numTextureFaces = var11;
		def.vertexX = new int[var9];
		def.vertexY = new int[var9];
		def.vertexZ = new int[var9];
		def.faceIndices1 = new int[var10];
		def.faceIndices2 = new int[var10];
		def.faceIndices3 = new int[var10];
		if (var17 == 1)
		{
			def.packedVertexGroups = new int[var9];
		}

		if (var12 == 1)
		{
			def.faceRenderTypes = new byte[var10];
		}

		if (var13 == 255)
		{
			def.faceRenderPriorities = new byte[var10];
		}
		else
		{
			def.priority = (byte) var13;
		}

		if (var14 == 1)
		{
			def.faceTransparencies = new byte[var10];
		}

		if (var15 == 1)
		{
			def.packedTransparencyVertexGroups = new int[var10];
		}

		if (var16 == 1)
		{
			def.faceTextures = new short[var10];
		}

		if (var16 == 1 && var11 > 0)
		{
			def.textureCoords = new byte[var10];
		}

		def.faceColors = new short[var10];
		if (var11 > 0)
		{
			def.texIndices1 = new short[var11];
			def.texIndices2 = new short[var11];
			def.texIndices3 = new short[var11];
		}

		var2.setOffset(var11);
		var3.setOffset(var37);
		var4.setOffset(var38);
		var5.setOffset(var39);
		var6.setOffset(var31);
		int var46 = 0;
		int var47 = 0;
		int var48 = 0;

		int var49;
		int var50;
		int var51;
		int var52;
		int var53;
		for (var49 = 0; var49 < var9; ++var49)
		{
			var50 = var2.readUnsignedByte();
			var51 = 0;
			if ((var50 & 1) != 0)
			{
				var51 = var3.readShortSmart();
			}

			var52 = 0;
			if ((var50 & 2) != 0)
			{
				var52 = var4.readShortSmart();
			}

			var53 = 0;
			if ((var50 & 4) != 0)
			{
				var53 = var5.readShortSmart();
			}

			def.vertexX[var49] = var46 + var51;
			def.vertexY[var49] = var47 + var52;
			def.vertexZ[var49] = var48 + var53;
			var46 = def.vertexX[var49];
			var47 = def.vertexY[var49];
			var48 = def.vertexZ[var49];
			if (var17 == 1)
			{
				def.packedVertexGroups[var49] = var6.readUnsignedByte();
			}
		}

		var2.setOffset(var36);
		var3.setOffset(var56);
		var4.setOffset(var29);
		var5.setOffset(var32);
		var6.setOffset(var30);
		var7.setOffset(var34);
		var8.setOffset(var35);

		for (var49 = 0; var49 < var10; ++var49)
		{
			def.faceColors[var49] = (short) var2.readUnsignedShort();
			if (var12 == 1)
			{
				def.faceRenderTypes[var49] = var3.readByte();
			}

			if (var13 == 255)
			{
				def.faceRenderPriorities[var49] = var4.readByte();
			}

			if (var14 == 1)
			{
				def.faceTransparencies[var49] = var5.readByte();
			}

			if (var15 == 1)
			{
				def.packedTransparencyVertexGroups[var49] = var6.readUnsignedByte();
			}

			if (var16 == 1)
			{
				def.faceTextures[var49] = (short) (var7.readUnsignedShort() - 1);
			}

			if (def.textureCoords != null && def.faceTextures[var49] != -1)
			{
				def.textureCoords[var49] = (byte) (var8.readUnsignedByte() - 1);
			}
		}

		var2.setOffset(var33);
		var3.setOffset(var28);
		var49 = 0;
		var50 = 0;
		var51 = 0;
		var52 = 0;

		int var54;
		for (var53 = 0; var53 < var10; ++var53)
		{
			var54 = var3.readUnsignedByte();
			if (var54 == 1)
			{
				var49 = var2.readShortSmart() + var52;
				var50 = var2.readShortSmart() + var49;
				var51 = var2.readShortSmart() + var50;
				var52 = var51;
				def.faceIndices1[var53] = var49;
				def.faceIndices2[var53] = var50;
				def.faceIndices3[var53] = var51;
			}

			if (var54 == 2)
			{
				var50 = var51;
				var51 = var2.readShortSmart() + var52;
				var52 = var51;
				def.faceIndices1[var53] = var49;
				def.faceIndices2[var53] = var50;
				def.faceIndices3[var53] = var51;
			}

			if (var54 == 3)
			{
				var49 = var51;
				var51 = var2.readShortSmart() + var52;
				var52 = var51;
				def.faceIndices1[var53] = var49;
				def.faceIndices2[var53] = var50;
				def.faceIndices3[var53] = var51;
			}

			if (var54 == 4)
			{
				int var55 = var49;
				var49 = var50;
				var50 = var55;
				var51 = var2.readShortSmart() + var52;
				var52 = var51;
				def.faceIndices1[var53] = var49;
				def.faceIndices2[var53] = var55;
				def.faceIndices3[var53] = var51;
			}
		}

		var2.setOffset(var40);
		var3.setOffset(var41);
		var4.setOffset(var42);
		var5.setOffset(var43);
		var6.setOffset(var44);
		var7.setOffset(var45);

		for (var53 = 0; var53 < var11; ++var53)
		{
			var54 = def.textureRenderTypes[var53] & 255;
			if (var54 == 0)
			{
				def.texIndices1[var53] = (short) var2.readUnsignedShort();
				def.texIndices2[var53] = (short) var2.readUnsignedShort();
				def.texIndices3[var53] = (short) var2.readUnsignedShort();
			}
		}

		var2.setOffset(var26);
		var53 = var2.readUnsignedByte();
		if (var53 != 0)
		{
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readInt();
		}

	}

	void decodeOldFormat(ModelDefinition def, byte[] inputData)
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
		int hasPackedVertexGroups = stream1.readUnsignedByte();
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
			int deltaX = 0;
			if ((vertexFlags & 1) != 0)
			{
				deltaX = stream2.readShortSmart();
			}

			int deltaY = 0;
			if ((vertexFlags & 2) != 0)
			{
				deltaY = stream3.readShortSmart();
			}

			int deltaZ = 0;
			if ((vertexFlags & 4) != 0)
			{
				deltaZ = stream4.readShortSmart();
			}

			def.vertexX[i] = previousVertexX + deltaX;
			def.vertexY[i] = previousVertexY + deltaY;
			def.vertexZ[i] = previousVertexZ + deltaZ;
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
