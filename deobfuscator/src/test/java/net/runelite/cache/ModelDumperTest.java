package net.runelite.cache;


import com.google.common.io.Files;
import com.google.gson.Gson;
import java.io.IOException;
import net.runelite.cache.definitions.loaders.ModelLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.File;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Store;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelDumperTest
{
	private static final Logger logger = LoggerFactory.getLogger(ModelDumperTest.class);

	private Gson gson = new Gson();

	@Rule
	public TemporaryFolder folder = StoreLocation.getTemporaryFolder();

	@Test
	public void test() throws IOException
	{
		java.io.File modelDir = folder.newFolder("models");
		int count = 0;

		try (Store store = new Store(StoreLocation.LOCATION))
		{
			store.load();

			Index index = store.getIndex(IndexType.MODELS);

			for (Archive archive : index.getArchives())
			{
				assert archive.getFiles().size() == 1;

				File file = archive.getFiles().get(0);
				byte[] contents = file.getContents();

				ModelLoader loader = new ModelLoader();
				loader.load(contents);

				Files.write(contents, new java.io.File(modelDir, archive.getArchiveId() + ".model"));
				//Files.write(gson.toJson(loader), new java.io.File(modelDir, archive.getArchiveId() + ".json"), Charset.defaultCharset());
				++count;
			}
		}

		logger.info("Dumped {} models to {}", count, modelDir);
	}
}
