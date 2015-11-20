package net.runelite.deob.deobfuscators.arithmetic;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.runelite.deob.gson.GsonFactory;
import net.runelite.deob.pool.Field;

public class Encryption
{	
	private final Map<Field, Pair> fields = new HashMap<>();
	
	public void addPair(Pair pair)
	{
		assert pair.field != null;
		
		Pair existing = fields.get(pair.field);
		if (existing != null)
		{
			fields.put(pair.field, new Pair(pair, existing));
		}
		else
		{
			fields.put(pair.field, pair);
		}
	}
	
	public Pair getField(Field field)
	{
		return fields.get(field);
	}
	
	public void save(File file) throws IOException
	{
		Gson g = GsonFactory.gson;
		String str = g.toJson(fields);
		
		try (FileWriter fw = new FileWriter(file))
		{
			fw.write(str);
		}
	}
}
