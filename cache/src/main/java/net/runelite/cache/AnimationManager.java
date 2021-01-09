package net.runelite.cache;
import net.runelite.cache.definitions.SequenceDefinition;
import net.runelite.cache.definitions.exporters.DefaultExporter;
import net.runelite.cache.definitions.loaders.SequenceLoader;
import net.runelite.cache.fs.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnimationManager
{
	private final Store store;
	private final Map<Integer, SequenceDefinition> animations = new HashMap<>();

	public AnimationManager(Store store)
	{
		this.store = store;
	}

	public void load() throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.CONFIGS);
		Archive archive = index.getArchive(ConfigType.SEQUENCE.getId());

		byte[] archiveData = storage.loadArchive(archive);
		ArchiveFiles files = archive.getFiles(archiveData);

		for (FSFile file : files.getFiles())
		{
			SequenceLoader loader = new SequenceLoader();
			SequenceDefinition seq = loader.load(file.getFileId(), file.getContents());
			animations.put(seq.id, seq);
		}
	}

	public void export(File out) throws IOException
	{
		out.mkdirs();

		for (SequenceDefinition def : animations.values())
		{
			DefaultExporter exporter = new DefaultExporter(def);

			File targ = new File(out, def.id + ".json");
			exporter.exportTo(targ);
		}
	}
}
