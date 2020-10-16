package net.runelite.cache.definitions.exporters;

import net.runelite.cache.TextureManager;
import net.runelite.cache.definitions.ModelDefinition;
import net.runelite.cache.models.ObjExporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ModelExporter {
	private final ModelDefinition model;

	public ModelExporter(ModelDefinition model)
	{
		this.model = model;
	}

	public void exportTo(TextureManager tm, File objFile, File mtlFile) throws IOException
	{
		ObjExporter exporter = new ObjExporter(tm, model);
		try (PrintWriter objWriter = new PrintWriter(new FileWriter(objFile));
			 PrintWriter mtlWriter = new PrintWriter(new FileWriter(mtlFile)))
		{
			exporter.export(objWriter, mtlWriter);
		}
	}
}