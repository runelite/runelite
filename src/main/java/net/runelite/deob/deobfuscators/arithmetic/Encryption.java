package net.runelite.deob.deobfuscators.arithmetic;

import java.util.HashMap;
import java.util.Map;
import net.runelite.deob.Field;

public class Encryption
{
	private Map<Field, Pair> fields = new HashMap<>();
	
	public Pair getField(Field field)
	{
		if (field.getName().equals("field1170"))
		{
			Pair p = new Pair();
			p.field = field;
			p.getter = -1570098313;
			p.setter = DMath.modInverse(p.getter);
			assert p.setter == 1237096007;
			return p;
		}
		return null;
		//return fields.get(field);
	}
}
