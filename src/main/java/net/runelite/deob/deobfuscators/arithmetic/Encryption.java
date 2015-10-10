package net.runelite.deob.deobfuscators.arithmetic;

import java.util.HashMap;
import java.util.Map;
import net.runelite.deob.Field;

public class Encryption
{	
	private final Map<Field, Pair> fields = new HashMap<>();
	
	public void addPair(Pair pair)
	{
		fields.put(pair.field, pair);
	}
	
	public Pair getField(Field field)
	{
		return fields.get(field);
	}
}
