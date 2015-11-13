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
import org.junit.Test;

public class SpriteLoaderTest
{
	@Test
	public void extract() throws IOException
	{
		java.io.File base = StoreLocation.LOCATION;
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
				loader.decode(new InputStream(contents));
				
				SpriteDefinition[] defs = loader.getSprites();
//				Assert.assertEquals(1, defs.length);
				//SpriteDefinition def = new SpriteDefinition(42);
				//def.decode(new InputStream(contents));
				
				RGBSprite sp = RGBSprite.fromSpriteDefinition(defs[0]);
				
				// I don't know why this happens
				if (sp.spriteHeight <= 0 || sp.spriteWidth <= 0)
					continue;
				
				BufferedImage image = sp.getBufferedImage();
				java.io.File targ = new java.io.File(base, "sprites/" + a.getArchiveId() + ".png");
				targ.mkdirs();
				ImageIO.write(image, "png", targ);
				//SpriteDefinition spr[] = SpriteDefinition.loadPaletteSpriteSet();
				int i =5;
				//break;
			}
		}
	}
}
