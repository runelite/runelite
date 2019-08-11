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
package net.runelite.http.service.sprite;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.cache.IndexType;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.fs.ArchiveFiles;
import net.runelite.cache.fs.FSFile;
import net.runelite.http.service.cache.CacheService;
import net.runelite.http.service.cache.beans.ArchiveEntry;
import net.runelite.http.service.cache.beans.CacheEntry;
import net.runelite.http.service.cache.beans.IndexEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpriteService
{
	@Autowired
	private CacheService cacheService;

	public SpriteDefinition getSprite(int spriteId, int frameId) throws IOException
	{
		CacheEntry cache = cacheService.findMostRecent();
		if (cache == null)
		{
			return null;
		}

		IndexEntry index = cacheService.findIndexForCache(cache, IndexType.SPRITES.getNumber());
		if (index == null)
		{
			return null;
		}

		ArchiveEntry archive = cacheService.findArchiveForIndex(index, spriteId);
		if (archive == null)
		{
			return null;
		}

		ArchiveFiles files = cacheService.getArchiveFiles(archive);
		if (files == null)
		{
			return null;
		}

		FSFile file = files.getFiles().get(0);
		byte[] contents = file.getContents();
		SpriteDefinition[] sprite = new SpriteLoader().load(archive.getArchiveId(), contents);
		if (frameId < 0 || frameId >= sprite.length)
		{
			return null;
		}

		return sprite[frameId];
	}

	public BufferedImage getImage(int spriteId, int frameId) throws IOException
	{
		SpriteDefinition sprite = getSprite(spriteId, frameId);
		if (sprite == null)
		{
			return null;
		}

		BufferedImage bufferedImage = getSpriteImage(sprite);
		return bufferedImage;
	}

	public byte[] getImagePng(int spriteId, int frameId) throws IOException
	{
		BufferedImage image = getImage(spriteId, frameId);
		if (image == null)
		{
			return null;
		}

		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ImageIO.write(image, "png", bao);
		return bao.toByteArray();
	}

	private BufferedImage getSpriteImage(SpriteDefinition sprite)
	{
		BufferedImage image = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
		image.setRGB(0, 0, sprite.getWidth(), sprite.getHeight(), sprite.getPixels(), 0, sprite.getWidth());
		return image;
	}
}
