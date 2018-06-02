/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.cache;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.exporters.SpriteExporter;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.definitions.providers.SpriteProvider;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;

public class SpriteManager implements SpriteProvider
{
	private final Store store;
	private final Multimap<Integer, SpriteDefinition> sprites = LinkedListMultimap.create();

	public SpriteManager(Store store)
	{
		this.store = store;
	}

	public void load() throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.SPRITES);

		for (Archive a : index.getArchives())
		{
			byte[] contents = a.decompress(storage.loadArchive(a));

			SpriteLoader loader = new SpriteLoader();
			SpriteDefinition[] defs = loader.load(a.getArchiveId(), contents);

			for (SpriteDefinition sprite : defs)
			{
				sprites.put(sprite.getId(), sprite);
			}
		}
	}

	public Collection<SpriteDefinition> getSprites()
	{
		return Collections.unmodifiableCollection(sprites.values());
	}

	public SpriteDefinition findSprite(int spriteId, int frameId)
	{
		for (SpriteDefinition sprite : sprites.get(spriteId))
		{
			if (sprite.getFrame() == frameId)
			{
				return sprite;
			}
		}
		return null;
	}

	public BufferedImage getSpriteImage(SpriteDefinition sprite)
	{
		BufferedImage image = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TYPE_INT_ARGB);
		image.setRGB(0, 0, sprite.getWidth(), sprite.getHeight(), sprite.getPixels(), 0, sprite.getWidth());
		return image;
	}

	public void export(File outDir) throws IOException
	{
		for (SpriteDefinition sprite : sprites.values())
		{
			// I don't know why this happens
			if (sprite.getHeight() <= 0 || sprite.getWidth() <= 0)
			{
				continue;
			}

			SpriteExporter exporter = new SpriteExporter(sprite);
			File png = new File(outDir, sprite.getId() + "-" + sprite.getFrame() + ".png");

			exporter.exportTo(png);
		}
	}

	@Override
	public SpriteDefinition provide(int spriteId, int frameId)
	{
		return findSprite(spriteId, frameId);
	}
}
