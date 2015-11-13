package net.runelite.cache.loaders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import net.runelite.cache.StoreLocation;
import net.runelite.cache.definitions.NpcDefinition;
import net.runelite.cache.definitions.loaders.NpcLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.io.InputStream;
import org.junit.Test;

public class NpcLoaderTest
{
	@Test
	public void extract() throws IOException
	{
		NpcLoader loader = new NpcLoader();

		java.io.File base = StoreLocation.LOCATION;
		try (Store store = new Store(base))
		{
			store.load();

			Index index = store.getIndex(NpcLoader.INDEX_TYPE);
			Archive archive = index.getArchive(NpcLoader.ARCHIVE_ID);

			for (File f : archive.getFiles())
			{
				loader.load(f.getFileId(), new InputStream(f.getContents()));
			}
		}

		new java.io.File(base, "npcs").mkdir();

		GsonBuilder builder = new GsonBuilder()
			.setPrettyPrinting();
		Gson g = builder.create();

		for (NpcDefinition def : loader.getNpcs())
		{
			java.io.File targ = new java.io.File(base, "npcs/" + def.id + ".json");
			try (FileWriter fw = new FileWriter(targ))
			{
				fw.write(g.toJson(def));
			}
		}
	}
}
