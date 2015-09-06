package net.runelite.deob.deobfuscators.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;

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
		return fields.get(field);
	}
	
	public boolean hasChange(PushConstantInstruction pci)
	{
		return changes.containsKey(pci);
	}
	
	public void change(PushConstantInstruction pci, int value)
	{
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
