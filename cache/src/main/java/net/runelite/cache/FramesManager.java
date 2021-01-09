package net.runelite.cache;
import net.runelite.cache.definitions.FrameDefinition;
import net.runelite.cache.definitions.FramemapDefinition;
import net.runelite.cache.definitions.exporters.DefaultExporter;
import net.runelite.cache.definitions.loaders.FrameLoader;
import net.runelite.cache.definitions.loaders.FramemapLoader;
import net.runelite.cache.fs.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FramesManager
{
	private final Store store;
	HashMap<Integer, List<FrameDefinition>> finalFrames = new HashMap<>();

	public FramesManager(Store store)
	{
		this.store = store;
	}

	public void load() throws IOException
	{
		Storage storage = store.getStorage();
		Index frameIndex = store.getIndex(IndexType.FRAMES);
		Index framemapIndex = store.getIndex(IndexType.FRAMEMAPS);

		for (Archive archive : frameIndex.getArchives())
		{

			byte[] archiveData = storage.loadArchive(archive);
			List<FrameDefinition> frames = new ArrayList<>();

			ArchiveFiles archiveFiles = archive.getFiles(archiveData);
			for (FSFile archiveFile : archiveFiles.getFiles())
			{
				byte[] contents = archiveFile.getContents();

				int framemapArchiveId = (contents[0] & 0xff) << 8 | contents[1] & 0xff;

				Archive framemapArchive = framemapIndex.getArchive(framemapArchiveId);
				archiveData = storage.loadArchive(framemapArchive);
				byte[] framemapContents = framemapArchive.decompress(archiveData);

				FramemapLoader fmloader = new FramemapLoader();
				FramemapDefinition framemap = fmloader.load(framemapArchive.getArchiveId(), framemapContents);

				try
				{
					FrameLoader frameLoader = new FrameLoader();
					FrameDefinition frame = frameLoader.load(framemap, archiveFile.getFileId(), contents);

					frames.add(frame);
				}
				catch (Exception e)
				{
					continue;
				}
			}
			finalFrames.put(archive.getArchiveId(), frames);

		}
	}

	public void dump(File out) throws IOException
	{
		out.mkdirs();

		for (int key : finalFrames.keySet())
		{
			DefaultExporter exporter = new DefaultExporter(finalFrames.get(key));

			File targ = new File(out, key + ".json");
			exporter.exportTo(targ);
		}
	}
}
