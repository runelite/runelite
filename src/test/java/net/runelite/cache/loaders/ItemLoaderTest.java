package net.runelite.cache.loaders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.definitions.ItemDefinition;
import net.runelite.cache.definitions.loaders.ItemLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.io.InputStream;
import org.junit.Test;

public class ItemLoaderTest
{
	//@Test
	public void extract() throws IOException
	{
		ItemLoader loader = new ItemLoader();
		
		java.io.File base = StoreLocation.LOCATION;
		try (Store store = new Store(base))
		{
			store.load();
			
			Index index = store.getIndex(ItemLoader.INDEX_TYPE);
			Archive archive = index.getArchive(ItemLoader.ARCHIVE_ID);
			
			for (File f : archive.getFiles())
			{
				loader.load(f.getFileId(), new InputStream(f.getContents()));
			}
		}
		
		new java.io.File(base, "items").mkdir();
		
		GsonBuilder builder = new GsonBuilder()
			.setPrettyPrinting();
		Gson g = builder.create();
		
		for (ItemDefinition def : loader.getItems())
		{
			java.io.File targ = new java.io.File(base, "items/" + def.id + ".json");
			try (FileWriter fw = new FileWriter(targ))
			{
				fw.write(g.toJson(def));
			}
		}
	}
}
