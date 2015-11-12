package net.runelite.cache.loaders;

import java.io.IOException;
import java.util.List;
import net.runelite.cache.IndexType;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.definitions.SpriteDefinition;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.io.InputStream;
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
				
				SpriteDefinition def = new SpriteDefinition(42);
				def.decode(new InputStream(contents));
				
				SpriteDefinition spr[] = SpriteDefinition.loadPaletteSpriteSet();
				int i =5;
			}
		}
	}
}
