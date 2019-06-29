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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.extern.slf4j.Slf4j;
import net.runelite.cache.IndexType;
import net.runelite.cache.ItemManager;
import net.runelite.cache.SpriteManager;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.TextureManager;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.loaders.ModelLoader;
import net.runelite.cache.definitions.providers.ModelProvider;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

@Slf4j
public class ItemSpriteFactoryTest
{
	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	@Ignore
	public void test() throws IOException
	{
		File base = StoreLocation.LOCATION,
			outDir = folder.newFolder();

		int count = 0;

		try (Store store = new Store(base))
		{
			store.load();

			ItemManager itemManager = new ItemManager(store);
			itemManager.load();

			ModelProvider modelProvider = new ModelProvider()
			{
				@Override
				public ModelDefinition provide(int modelId) throws IOException
				{
					Index models = store.getIndex(IndexType.MODELS);
					Archive archive = models.getArchive(modelId);

					byte[] data = archive.decompress(store.getStorage().loadArchive(archive));
					ModelDefinition inventoryModel = new ModelLoader().load(modelId, data);
					return inventoryModel;
				}
			};

			SpriteManager spriteManager = new SpriteManager(store);
			spriteManager.load();

			TextureManager textureManager = new TextureManager(store);
			textureManager.load();

			for (ItemDefinition itemDef : itemManager.getItems())
			{
				if (itemDef.name == null || itemDef.name.equalsIgnoreCase("null"))
				{
					continue;
				}

				try
				{
					BufferedImage sprite = ItemSpriteFactory.createSprite(itemManager, modelProvider, spriteManager, textureManager,
						itemDef.id, 1, 1, 3153952, false);

					File out = new File(outDir, itemDef.id + ".png");
					BufferedImage img = sprite;
					ImageIO.write(img, "PNG", out);

					++count;
				}
				catch (Exception ex)
				{
					log.warn("error dumping item {}", itemDef.id, ex);
				}
			}
		}

		log.info("Dumped {} item images to {}", count, outDir);
	}
}