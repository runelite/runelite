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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;

public class SpriteDumper
{
	private final Store store;
	private final File outDir;
	private final List<SpriteDefinition> sprites = new ArrayList<>();

	public SpriteDumper(Store store, File outDir)
	{
		this.store = store;
		this.outDir = outDir;
	}

	public void load()
	{
		Index index = store.getIndex(IndexType.SPRITES);

		for (Archive a : index.getArchives())
		{
			List<net.runelite.cache.fs.File> files = a.getFiles();

			assert files.size() == 1;

			net.runelite.cache.fs.File file = files.get(0);
			byte[] contents = file.getContents();

			SpriteLoader loader = new SpriteLoader();
			SpriteDefinition[] sprites = loader.load(a.getArchiveId(), contents);

			this.sprites.addAll(Arrays.asList(sprites));
		}
	}

	public void dump() throws IOException
	{
		for (SpriteDefinition def : sprites)
		{
			// I don't know why this happens
			if (def.getHeight() <= 0 || def.getWidth() <= 0)
			{
				continue;
			}

			dump(def, outDir);
		}
	}

	public static void dump(SpriteDefinition sprite, File outDir) throws IOException
	{
		BufferedImage image = getBufferedImage(sprite);
		File targ = new File(outDir, sprite.getId() + "-" + sprite.getFrame() + ".png");
		targ.mkdirs();
		ImageIO.write(image, "png", targ);
	}

	private static BufferedImage getBufferedImage(SpriteDefinition def)
	{
		BufferedImage bi = new BufferedImage(def.getWidth(), def.getHeight(), BufferedImage.TYPE_INT_ARGB);
		bi.setRGB(0, 0, def.getWidth(), def.getHeight(), def.getPixels(), 0, def.getWidth());
		return bi;
	}
}
