
package net.runelite.cache;

import net.runelite.cache.definitions.Definition;
import net.runelite.cache.definitions.exporters.DefaultExporter;
import net.runelite.cache.definitions.loaders.Loader;
import net.runelite.cache.fs.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ConfigManager
{
	private final Store store;
	private final Map<Integer, Definition> definitions = new HashMap<>();

	public ConfigManager(Store store)
	{
		this.store = store;
	}

	public void load(ConfigType config) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.CONFIGS);
		Archive archive = index.getArchive(config.getId());

		byte[] archiveData = storage.loadArchive(archive);
		ArchiveFiles files = archive.getFiles(archiveData);

		Loader loader = (Loader) config.getLoader().getDeclaredConstructor().newInstance();

		for (FSFile file : files.getFiles())
		{
			Definition def = loader.load(file.getFileId(), file.getContents());
			definitions.put(def.id, def);
		}
	}

	public void dump(File out) throws IOException
	{
		out.mkdirs();

		for (Definition def : definitions.values())
		{
			DefaultExporter exporter = new DefaultExporter(def);

			File targ = new File(out, def.id + ".json");
			exporter.exportTo(targ);
		}
	}

	public Collection<Definition> getAreas()
	{
		return Collections.unmodifiableCollection(definitions.values());
	}

	public Definition getArea(int id)
	{
		return definitions.get(id);
	}
}
