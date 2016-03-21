package net.runelite.deob.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.runelite.asm.pool.Class;

public class ClassSerializer implements JsonSerializer<Class>
{
	@Override
	public JsonElement serialize(Class src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject object = new JsonObject();
		object.addProperty("name", src.getName());
		return object;
	}

}
