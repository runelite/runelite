package net.runelite.cache.definitions.exporters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.runelite.cache.definitions.InterfaceDefinition;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DefaultExporter {
    private final Object item;
    private final Gson gson;

    public DefaultExporter(Object item)
    {
        this.item = item;

        GsonBuilder builder = new GsonBuilder()
                .setPrettyPrinting();
        gson = builder.create();
    }

    public String export()
    {
        return gson.toJson(item);
    }

    public void exportTo(File file) throws IOException
    {
        try (FileWriter fw = new FileWriter(file))
        {
            fw.write(export());
        }
    }
}
