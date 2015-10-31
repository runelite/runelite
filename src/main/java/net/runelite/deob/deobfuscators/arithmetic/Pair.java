package net.runelite.deob.deobfuscators.arithmetic;

import net.runelite.deob.Field;

public class Pair
{
	public Field field;
	public Number getter, setter;
	
	public Class getType()
	{
		assert getter.getClass() == setter.getClass();
		return getter.getClass();
	}
}
