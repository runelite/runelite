package net.runelite.cache;

import com.google.gson.*;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.definitions.exporters.DefaultExporter;
import net.runelite.cache.definitions.exporters.ModelExporter;
import net.runelite.cache.definitions.loaders.ModelLoader;
import net.runelite.cache.fs.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ModelManager
{

	private final Store store;
	private final Map<Integer, ModelDefinition> models = new HashMap<>();

	public ModelManager(Store store)
	{
		this.store = store;
	}

	public void load() throws IOException
	{
		Storage storage = store.getStorage();
		Index index = store.getIndex(IndexType.MODELS);

		for (Archive a : index.getArchives())
		{
			byte[] contents = a.decompress(storage.loadArchive(a));

			ModelLoader loader = new ModelLoader();
			ModelDefinition def = loader.load(a.getArchiveId(), contents);
			models.put(def.getId(), def);
		}
	}

	public void export(File outDir) throws IOException
	{
		outDir.mkdirs();

		TextureManager tm = new TextureManager(store);
		tm.load();

		for (ModelDefinition model : models.values())
		{
			ModelExporter exporter = new ModelExporter(model);
			File objFile = new File(outDir, model.id + ".obj");
			File mtlFile = new File(outDir, model.id + ".mtl");
			exporter.exportTo(tm, objFile, mtlFile);
		}
	}

	//used to export relevant info like bones
	public void exportModelInfo(File outDir) throws IOException
	{
		outDir.mkdirs();
		for (ModelDefinition model : models.values())
		{
			GsonBuilder builder = new GsonBuilder()
					.setPrettyPrinting();
			Gson gson = builder.create();

			JsonObject jsonObject = new JsonObject();
			jsonObject.add("vertexGroups", gson.toJsonTree(model.getVertexGroups()));
			jsonObject.add("faceAlphas", gson.toJsonTree(model.getFaceAlphas()));

			try (FileWriter fw = new FileWriter(new File(outDir, model.id + ".json")))
			{
				fw.write(gson.toJson(jsonObject));
			}

		}
	}

	public void exportJson(File outDir) throws IOException
	{
		outDir.mkdirs();
		for (ModelDefinition model : models.values())
		{
			DefaultExporter exporter = new DefaultExporter(model);
			File targ = new File(outDir, model.id + ".json");
			exporter.exportTo(targ);
		}
	}

}