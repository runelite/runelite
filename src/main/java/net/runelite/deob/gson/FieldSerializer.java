package net.runelite.deob.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.runelite.asm.pool.Field;

public class FieldSerializer implements JsonSerializer<Field>
{
	@Override
	public JsonElement serialize(Field src, Type typeOfSrc, JsonSerializationContext context)
	{
		JsonObject object = new JsonObject();
		object.addProperty("class", src.getClassEntry().getName());
		object.addProperty("name", src.getNameAndType().getName());
		object.add("type", context.serialize(src.getNameAndType().getDescriptorType()));
		return object;
	}

}
