package net.runelite.deob.deobfuscators.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instructions.SiPush;

public class Encryption
{
	private Map<Field, Pair> fields = new HashMap<>();
	private Map<PushConstantInstruction, Integer> changes = new HashMap<>();
	
	public void addPair(Pair pair)
	{
		fields.put(pair.field, pair);
	}
	
	public Pair getField(Field field)
	{
//		if (i == 0 && field.getName().equals("field1170"))
//		{
//			Pair p = new Pair();
//			p.field = field;
//			p.getter = -1570098313;
//			p.setter = DMath.modInverse(p.getter);
//			assert p.setter == 1237096007;
//			return p;
//		}
//		if (i == 1 && field.getName().equals("field700"))
//		{
//			Pair p = new Pair();
//			p.field = field;
//			p.getter = -478315765;
//			p.setter = DMath.modInverse(p.getter);
//			//assert p.setter == 
//			return p;
//		}
//		return null;
		return fields.get(field);
	}
	
	public void change(PushConstantInstruction pci, int value)
	{
		if (pci instanceof SiPush)
		{
			int i =5;
		}
		assert !changes.containsKey(pci) || changes.get(pci) == value;
		changes.put(pci, value);
	}
	
	public void doChange()
	{
		for (Entry<PushConstantInstruction, Integer> e : changes.entrySet())
		{
			PushConstantInstruction pci = e.getKey();
			int value = e.getValue();
			
			pci.setConstant(new net.runelite.deob.pool.Integer(value));
		}
	}
}
