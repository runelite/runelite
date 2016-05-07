/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.cache.loaders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import net.runelite.cache.IndexType;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.definitions.loaders.SpriteLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.io.InputStream;
import net.runelite.cache.renderable.RGBSprite;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpriteLoaderTest
{
	private static final Logger logger = LoggerFactory.getLogger(SpriteLoaderTest.class);

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void extract() throws IOException
	{
		java.io.File base = StoreLocation.LOCATION,
			outDir = folder.newFolder();

		try (Store store = new Store(base))
		{
			store.load();
			
			Index index = store.getIndex(IndexType.SPRITE);
			
			for (Archive a : index.getArchives())
			{
				List<File> files = a.getFiles();
				
				Assert.assertEquals(1, files.size());
				
				File file = files.get(0);
				byte[] contents = file.getContents();
				
				SpriteLoader loader = new SpriteLoader();
				loader.load(new InputStream(contents));
				
				SpriteDefinition[] defs = loader.getSprites();
				
				for (int i = 0; i < defs.length; ++i)
				{
					RGBSprite sp = RGBSprite.fromSpriteDefinition(defs[i]);

					// I don't know why this happens
					if (sp.getSpriteHeight() <= 0 || sp.getSpriteWidth() <= 0)
						continue;

					BufferedImage image = sp.getBufferedImage();
					java.io.File targ = new java.io.File(outDir, a.getArchiveId() + "-" + i + ".png");
					targ.mkdirs();
					ImageIO.write(image, "png", targ);
				}
			}
		}

		logger.info("Dumped to {}", outDir);
	}
}
