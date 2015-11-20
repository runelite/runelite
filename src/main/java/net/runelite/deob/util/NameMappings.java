package net.runelite.deob.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.runelite.deob.gson.GsonFactory;
import net.runelite.deob.pool.Class;
import net.runelite.deob.pool.Field;
import net.runelite.deob.pool.Method;

public class NameMappings
{
	private final Map<Object, String> map = new HashMap<>();
	
	public void map(Class cf, String name)
	{
		map.put(cf, name);
	}
	
	public void map(Field field, String name)
	{
		map.put(field, name);
	}
	
	public void map(Method method, String name)
	{
		map.put(method, name);
	}
	
	public String get(Object object)
	{
		return map.get(object);
	}

	public Map<Object, String> getMap()
	{
		return map;
	}
	
	public void save(File file) throws IOException
	{
		Gson g = GsonFactory.gson;
		String str = g.toJson(map);
		
		try (FileWriter fw = new FileWriter(file))
		{
			fw.write(str);
		}
	}
}
