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

import java.awt.image.BufferedImage;
import java.io.IOException;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.providers.ItemProvider;
import net.runelite.cache.definitions.providers.ModelProvider;
import net.runelite.cache.definitions.providers.SpriteProvider;
import net.runelite.cache.definitions.providers.TextureProvider;
import net.runelite.cache.models.FaceNormal;
import net.runelite.cache.models.JagexColor;
import net.runelite.cache.models.VertexNormal;

public class ItemSpriteFactory
{
	public static BufferedImage createSprite(ItemProvider itemProvider, ModelProvider modelProvider,
		SpriteProvider spriteProvider, TextureProvider textureProvider,
		int itemId, int quantity, int border, int shadowColor,
		boolean noted) throws IOException
	{
		SpritePixels spritePixels = createSpritePixels(itemProvider, modelProvider, spriteProvider, textureProvider,
			itemId, quantity, border, shadowColor, noted);
		return spritePixels == null ? null : spritePixels.toBufferedImage();
	}

	private static SpritePixels createSpritePixels(ItemProvider itemProvider, ModelProvider modelProvider,
		SpriteProvider spriteProvider, TextureProvider textureProvider,
		int itemId, int quantity, int border, int shadowColor,
		boolean noted) throws IOException
	{
		ItemDefinition item = itemProvider.provide(itemId);

		if (quantity > 1 && item.countObj != null)
		{
			int stackItemID = -1;

			for (int i = 0; i < 10; ++i)
			{
				if (quantity >= item.countCo[i] && item.countCo[i] != 0)
				{
					stackItemID = item.countObj[i];
				}
			}

			if (stackItemID != -1)
			{
				item = itemProvider.provide(stackItemID);
			}
		}

		Model itemModel = getModel(modelProvider, item);
		if (itemModel == null)
		{
			return null;
		}

		SpritePixels auxSpritePixels = null;
		if (item.notedTemplate != -1)
		{
			auxSpritePixels = createSpritePixels(itemProvider, modelProvider, spriteProvider, textureProvider,
				item.notedID, 10, 1, 0, true);
			if (auxSpritePixels == null)
			{
				return null;
			}
		}
		else if (item.boughtTemplateId != -1)
		{
			auxSpritePixels = createSpritePixels(itemProvider, modelProvider, spriteProvider, textureProvider,
				item.boughtId, quantity, border, 0, false);
			if (auxSpritePixels == null)
			{
				return null;
			}
		}
		else if (item.placeholderTemplateId != -1)
		{
			auxSpritePixels = createSpritePixels(itemProvider, modelProvider, spriteProvider, textureProvider,
				item.placeholderId, quantity, 0, 0, false);
			if (auxSpritePixels == null)
			{
				return null;
			}
		}

		RSTextureProvider rsTextureProvider = new RSTextureProvider(textureProvider, spriteProvider);
		rsTextureProvider.brightness = JagexColor.BRIGHTNESS_MAX;

		SpritePixels spritePixels = new SpritePixels(36, 32);
		Graphics3D graphics = new Graphics3D(rsTextureProvider);
		graphics.setBrightness(JagexColor.BRIGHTNESS_MAX);
		graphics.setRasterBuffer(spritePixels.pixels, 36, 32);
		graphics.reset();
		graphics.setRasterClipping();
		graphics.setOffset(16, 16);
		graphics.rasterGouraudLowRes = false;
		if (item.placeholderTemplateId != -1)
		{
			auxSpritePixels.drawAtOn(graphics, 0, 0);
		}

		int zoom2d = item.zoom2d;
		if (noted)
		{
			zoom2d = (int) ((double) zoom2d * 1.5D);
		}
		else if (border == 2)
		{
			zoom2d = (int) ((double) zoom2d * 1.04D);
		}

		int var17 = zoom2d * Graphics3D.SINE[item.xan2d] >> 16;
		int var18 = zoom2d * Graphics3D.COSINE[item.xan2d] >> 16;

		itemModel.calculateBoundsCylinder();
		itemModel.projectAndDraw(graphics, 0,
			item.yan2d,
			item.zan2d,
			item.xan2d,
			item.xOffset2d,
			itemModel.modelHeight / 2 + var17 + item.yOffset2d,
			var18 + item.yOffset2d);
		if (item.boughtTemplateId != -1)
		{
			auxSpritePixels.drawAtOn(graphics, 0, 0);
		}

		if (border >= 1)
		{
			spritePixels.drawBorder(1);
		}

		if (border >= 2)
		{
			spritePixels.drawBorder(0xffffff);
		}

		if (shadowColor != 0)
		{
			spritePixels.drawShadow(shadowColor);
		}

		graphics.setRasterBuffer(spritePixels.pixels, 36, 32);
		if (item.notedTemplate != -1)
		{
			auxSpritePixels.drawAtOn(graphics, 0, 0);
		}

		graphics.setRasterBuffer(graphics.graphicsPixels,
			graphics.graphicsPixelsWidth,
			graphics.graphicsPixelsHeight);

		graphics.setRasterClipping();
		graphics.rasterGouraudLowRes = true;
		return spritePixels;
	}

	private static Model getModel(ModelProvider modelProvider, ItemDefinition item) throws IOException
	{
		Model itemModel;
		ModelDefinition inventoryModel = modelProvider.provide(item.inventoryModel);
		if (inventoryModel == null)
		{
			return null;
		}

		if (item.resizeX != 128 || item.resizeY != 128 || item.resizeZ != 128)
		{
			inventoryModel.resize(item.resizeX, item.resizeY, item.resizeZ);
		}

		if (item.colorFind != null)
		{
			for (int i = 0; i < item.colorFind.length; ++i)
			{
				inventoryModel.recolor(item.colorFind[i], item.colorReplace[i]);
			}
		}

		if (item.textureFind != null)
		{
			for (int i = 0; i < item.textureFind.length; ++i)
			{
				inventoryModel.retexture(item.textureFind[i], item.textureReplace[i]);
			}
		}

		itemModel = light(inventoryModel, item.ambient + 64, item.contrast + 768, -50, -10, -50);
		return itemModel;
	}

	private static Model light(ModelDefinition def, int ambient, int contrast, int x, int y, int z)
	{
		def.computeNormals();
		int somethingMagnitude = (int) Math.sqrt((double) (z * z + x * x + y * y));
		int var7 = somethingMagnitude * contrast >> 8;
		Model litModel = new Model();
		litModel.faceColors1 = new int[def.faceCount];
		litModel.faceColors2 = new int[def.faceCount];
		litModel.faceColors3 = new int[def.faceCount];
		if (def.numTextureFaces > 0 && def.textureCoords != null)
		{
			int[] var9 = new int[def.numTextureFaces];

			int var10;
			for (var10 = 0; var10 < def.faceCount; ++var10)
			{
				if (def.textureCoords[var10] != -1)
				{
					++var9[def.textureCoords[var10] & 255];
				}
			}

			litModel.numTextureFaces = 0;

			for (var10 = 0; var10 < def.numTextureFaces; ++var10)
			{
				if (var9[var10] > 0 && def.textureRenderTypes[var10] == 0)
				{
					++litModel.numTextureFaces;
				}
			}

			litModel.texIndices1 = new int[litModel.numTextureFaces];
			litModel.texIndices2 = new int[litModel.numTextureFaces];
			litModel.texIndices3 = new int[litModel.numTextureFaces];
			var10 = 0;


			for (int i = 0; i < def.numTextureFaces; ++i)
			{
				if (var9[i] > 0 && def.textureRenderTypes[i] == 0)
				{
					litModel.texIndices1[var10] = def.texIndices1[i] & '\uffff';
					litModel.texIndices2[var10] = def.texIndices2[i] & '\uffff';
					litModel.texIndices3[var10] = def.texIndices3[i] & '\uffff';
					var9[i] = var10++;
				}
				else
				{
					var9[i] = -1;
				}
			}

			litModel.textureCoords = new byte[def.faceCount];

			for (int i = 0; i < def.faceCount; ++i)
			{
				if (def.textureCoords[i] != -1)
				{
					litModel.textureCoords[i] = (byte) var9[def.textureCoords[i] & 255];
				}
				else
				{
					litModel.textureCoords[i] = -1;
				}
			}
		}

		for (int faceIdx = 0; faceIdx < def.faceCount; ++faceIdx)
		{
			byte faceType;
			if (def.faceRenderTypes == null)
			{
				faceType = 0;
			}
			else
			{
				faceType = def.faceRenderTypes[faceIdx];
			}

			byte faceAlpha;
			if (def.faceTransparencies == null)
			{
				faceAlpha = 0;
			}
			else
			{
				faceAlpha = def.faceTransparencies[faceIdx];
			}

			short faceTexture;
			if (def.faceTextures == null)
			{
				faceTexture = -1;
			}
			else
			{
				faceTexture = def.faceTextures[faceIdx];
			}

			if (faceAlpha == -2)
			{
				faceType = 3;
			}

			if (faceAlpha == -1)
			{
				faceType = 2;
			}

			VertexNormal vertexNormal;
			int tmp;
			FaceNormal faceNormal;
			if (faceTexture == -1)
			{
				if (faceType != 0)
				{
					if (faceType == 1)
					{
						faceNormal = def.faceNormals[faceIdx];
						tmp = (y * faceNormal.y + z * faceNormal.z + x * faceNormal.x) / (var7 / 2 + var7) + ambient;
						litModel.faceColors1[faceIdx] = method2608(def.faceColors[faceIdx] & '\uffff', tmp);
						litModel.faceColors3[faceIdx] = -1;
					}
					else if (faceType == 3)
					{
						litModel.faceColors1[faceIdx] = 128;
						litModel.faceColors3[faceIdx] = -1;
					}
					else
					{
						litModel.faceColors3[faceIdx] = -2;
					}
				}
				else
				{
					int var15 = def.faceColors[faceIdx] & '\uffff';
					vertexNormal = def.vertexNormals[def.faceIndices1[faceIdx]];

					tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
					litModel.faceColors1[faceIdx] = method2608(var15, tmp);
					vertexNormal = def.vertexNormals[def.faceIndices2[faceIdx]];

					tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
					litModel.faceColors2[faceIdx] = method2608(var15, tmp);
					vertexNormal = def.vertexNormals[def.faceIndices3[faceIdx]];

					tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
					litModel.faceColors3[faceIdx] = method2608(var15, tmp);
				}
			}
			else if (faceType != 0)
			{
				if (faceType == 1)
				{
					faceNormal = def.faceNormals[faceIdx];
					tmp = (y * faceNormal.y + z * faceNormal.z + x * faceNormal.x) / (var7 / 2 + var7) + ambient;
					litModel.faceColors1[faceIdx] = bound2to126(tmp);
					litModel.faceColors3[faceIdx] = -1;
				}
				else
				{
					litModel.faceColors3[faceIdx] = -2;
				}
			}
			else
			{
				vertexNormal = def.vertexNormals[def.faceIndices1[faceIdx]];

				tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
				litModel.faceColors1[faceIdx] = bound2to126(tmp);
				vertexNormal = def.vertexNormals[def.faceIndices2[faceIdx]];

				tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
				litModel.faceColors2[faceIdx] = bound2to126(tmp);
				vertexNormal = def.vertexNormals[def.faceIndices3[faceIdx]];

				tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
				litModel.faceColors3[faceIdx] = bound2to126(tmp);
			}
		}

		litModel.verticesCount = def.vertexCount;
		litModel.verticesX = def.vertexX;
		litModel.verticesY = def.vertexY;
		litModel.verticesZ = def.vertexZ;
		litModel.indicesCount = def.faceCount;
		litModel.indices1 = def.faceIndices1;
		litModel.indices2 = def.faceIndices2;
		litModel.indices3 = def.faceIndices3;
		litModel.facePriorities = def.faceRenderPriorities;
		litModel.faceTransparencies = def.faceTransparencies;
		litModel.faceTextures = def.faceTextures;
		return litModel;
	}

	static int method2608(int var0, int var1)
	{
		var1 = ((var0 & 127) * var1) >> 7;
		var1 = bound2to126(var1);

		return (var0 & 65408) + var1;
	}

	static int bound2to126(int var0)
	{
		if (var0 < 2)
		{
			var0 = 2;
		}
		else if (var0 > 126)
		{
			var0 = 126;
		}

		return var0;
	}
}
