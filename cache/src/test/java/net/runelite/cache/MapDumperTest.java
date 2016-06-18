package net.runelite.cache;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import net.runelite.cache.util.XteaKeyManager;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(MapDumperTest.class);

	private static final int MAX_REGIONS = 32768;

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void dump() throws IOException
	{
		File base = StoreLocation.LOCATION,
			outDir = new java.io.File("d:/rs/07/cache/maps");//folder.newFolder();

		try (Store store = new Store(base))
		{
			store.load();

			Index index = store.getIndex(IndexType.MAPS);
			XteaKeyManager keyManager = index.getXteaManager();

			for (int i = 0; i < MAX_REGIONS; i++)
			{
				int[] keys = keyManager.getKeys(i);
				
				int x = i >> 8;
				int y = i & 0xFF;

				Archive map = index.findArchiveByName("m" + x + "_" + y);
				Archive land = index.findArchiveByName("l" + x + "_" + y);
				
				assert (map == null) == (land == null);

				if (map == null || land == null)
					continue;

				assert map.getFiles().size() == 1;
				assert land.getFiles().size() == 1;

				// maps aren't encrypted, but we don't load archive data of any archive in
				// the maps index, so load it
				map.decompressAndLoad(null);

				byte[] data = map.getFiles().get(0).getContents();

				Files.write(data, new File(outDir, "m" + x + "_" + y + ".dat"));

				if (keys != null)
				{
					land.decompressAndLoad(keys);

					data = land.getFiles().get(0).getContents();

					if (data == null)
						continue; // key is probably wrong

					Files.write(data, new File(outDir, "l" + x + "_" + y + ".dat"));
				}
			}
		}
	}

}
