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
