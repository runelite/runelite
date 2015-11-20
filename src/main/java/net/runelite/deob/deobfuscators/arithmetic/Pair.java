package net.runelite.deob.deobfuscators.arithmetic;

import net.runelite.deob.Field;

public class Pair
{
	public Field field;
	public Number getter, setter;
	
	public Pair()
	{
	}
	
	public Pair(Pair one, Pair two)
	{
		assert one.getType() == two.getType();
		assert one.field == two.field;
		
		getter = DMath.multiply(one.getter, two.getter);
		setter = DMath.multiply(one.setter, two.setter);
	}
	
	public Class getType()
	{
		assert getter.getClass() == setter.getClass();
		return getter.getClass();
	}
}
