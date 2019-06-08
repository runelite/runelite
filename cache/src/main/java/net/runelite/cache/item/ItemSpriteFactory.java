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
import net.runelite.cache.models.VertexNormal;

public class ItemSpriteFactory
{
	public static final BufferedImage createSprite(ItemProvider itemProvider, ModelProvider modelProvider,
												SpriteProvider spriteProvider, TextureProvider textureProvider,
												int itemId, int quantity, int border, int shadowColor,
												boolean noted) throws IOException
	{
		Sprite spritePixels = createSpritePixels(itemProvider, modelProvider, spriteProvider, textureProvider,
				itemId, quantity, border, shadowColor, noted);
		return spritePixels == null ? null : spritePixels.toBufferedImage();
	}

	private static final Sprite createSpritePixels(ItemProvider itemProvider, ModelProvider modelProvider,
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

		if (item.notedTemplate != -1)
		{
			item.updateNote(itemProvider.provide(item.notedTemplate), itemProvider.provide(item.notedID));
		}

		Model itemModel = getModel(modelProvider, item);
		if (itemModel == null)
		{
			return null;
		}

		Sprite auxSpritePixels = null;
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
					item.boughtId, quantity, border, shadowColor, false);
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

		Sprite spritePixels = new Sprite(36, 32);
		Graphics3D graphics = new Graphics3D(rsTextureProvider);
		graphics.setBrightness(0.6d);
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
		itemModel.rotateAndProject(graphics, 0,
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
		itemModel.isItemModel = true;
		return itemModel;
	}

	private static Model light(ModelDefinition def, int ambient, int contrast, int x, int y, int z)
	{
		def.computeNormals();
		int somethingMagnitude = (int) Math.sqrt((double) (z * z + x * x + y * y));
		int var7 = somethingMagnitude * contrast >> 8;
		Model litModel = new Model();
		litModel.field1856 = new int[def.faceCount];
		litModel.field1854 = new int[def.faceCount];
		litModel.field1823 = new int[def.faceCount];
		if (def.textureTriangleCount > 0 && def.textureCoordinates != null)
		{
			int[] var9 = new int[def.textureTriangleCount];

			int var10;
			for (var10 = 0; var10 < def.faceCount; ++var10)
			{
				if (def.textureCoordinates[var10] != -1)
				{
					++var9[def.textureCoordinates[var10] & 255];
				}
			}

			litModel.field1852 = 0;

			for (var10 = 0; var10 < def.textureTriangleCount; ++var10)
			{
				if (var9[var10] > 0 && def.textureRenderTypes[var10] == 0)
				{
					++litModel.field1852;
				}
			}

			litModel.field1844 = new int[litModel.field1852];
			litModel.field1865 = new int[litModel.field1852];
			litModel.field1846 = new int[litModel.field1852];
			var10 = 0;


			for (int i = 0; i < def.textureTriangleCount; ++i)
			{
				if (var9[i] > 0 && def.textureRenderTypes[i] == 0)
				{
					litModel.field1844[var10] = def.textureTriangleVertexIndices1[i] & '\uffff';
					litModel.field1865[var10] = def.textureTriangleVertexIndices2[i] & '\uffff';
					litModel.field1846[var10] = def.textureTriangleVertexIndices3[i] & '\uffff';
					var9[i] = var10++;
				}
				else
				{
					var9[i] = -1;
				}
			}

			litModel.field1840 = new byte[def.faceCount];

			for (int i = 0; i < def.faceCount; ++i)
			{
				if (def.textureCoordinates[i] != -1)
				{
					litModel.field1840[i] = (byte) var9[def.textureCoordinates[i] & 255];
				}
				else
				{
					litModel.field1840[i] = -1;
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
			if (def.faceAlphas == null)
			{
				faceAlpha = 0;
			}
			else
			{
				faceAlpha = def.faceAlphas[faceIdx];
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
						litModel.field1856[faceIdx] = method2608(def.faceColors[faceIdx] & '\uffff', tmp);
						litModel.field1823[faceIdx] = -1;
					}
					else if (faceType == 3)
					{
						litModel.field1856[faceIdx] = 128;
						litModel.field1823[faceIdx] = -1;
					}
					else
					{
						litModel.field1823[faceIdx] = -2;
					}
				}
				else
				{
					int var15 = def.faceColors[faceIdx] & '\uffff';
					vertexNormal = def.vertexNormals[def.faceVertexIndices1[faceIdx]];

					tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
					litModel.field1856[faceIdx] = method2608(var15, tmp);
					vertexNormal = def.vertexNormals[def.faceVertexIndices2[faceIdx]];

					tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
					litModel.field1854[faceIdx] = method2608(var15, tmp);
					vertexNormal = def.vertexNormals[def.faceVertexIndices3[faceIdx]];

					tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
					litModel.field1823[faceIdx] = method2608(var15, tmp);
				}
			}
			else if (faceType != 0)
			{
				if (faceType == 1)
				{
					faceNormal = def.faceNormals[faceIdx];
					tmp = (y * faceNormal.y + z * faceNormal.z + x * faceNormal.x) / (var7 / 2 + var7) + ambient;
					litModel.field1856[faceIdx] = bound2to126(tmp);
					litModel.field1823[faceIdx] = -1;
				}
				else
				{
					litModel.field1823[faceIdx] = -2;
				}
			}
			else
			{
				vertexNormal = def.vertexNormals[def.faceVertexIndices1[faceIdx]];

				tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
				litModel.field1856[faceIdx] = bound2to126(tmp);
				vertexNormal = def.vertexNormals[def.faceVertexIndices2[faceIdx]];

				tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
				litModel.field1854[faceIdx] = bound2to126(tmp);
				vertexNormal = def.vertexNormals[def.faceVertexIndices3[faceIdx]];

				tmp = (y * vertexNormal.y + z * vertexNormal.z + x * vertexNormal.x) / (var7 * vertexNormal.magnitude) + ambient;
				litModel.field1823[faceIdx] = bound2to126(tmp);
			}
		}

		litModel.verticesCount = def.vertexCount;
		litModel.verticesX = def.vertexPositionsX;
		litModel.verticesY = def.vertexPositionsY;
		litModel.verticesZ = def.vertexPositionsZ;
		litModel.indicesCount = def.faceCount;
		litModel.indices1 = def.faceVertexIndices1;
		litModel.indices2 = def.faceVertexIndices2;
		litModel.indices3 = def.faceVertexIndices3;
		litModel.field1838 = def.faceRenderPriorities;
		litModel.field1882 = def.faceAlphas;
		litModel.field1842 = def.priority;
		litModel.field1841 = def.faceTextures;
		return litModel;
	}

	static final int method2608(int var0, int var1)
	{
		var1 = ((var0 & 127) * var1) >> 7;
		var1 = bound2to126(var1);

		return (var0 & 65408) + var1;
	}

	static final int bound2to126(int var0)
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
