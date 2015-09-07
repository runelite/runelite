package net.runelite.deob.deobfuscators.arithmetic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;

public class Encryption
{
	private static class PendingStack
	{
		private Set<PushConstantInstruction> pending = new HashSet<>();
	}
	
	private Map<Field, Pair> fields = new HashMap<>();
	private Map<PushConstantInstruction, Integer> changes = new HashMap<>();
	private Stack<PendingStack> stack = new Stack<>();
	
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
		if (stack.isEmpty())
			return;
		PendingStack ps = stack.peek();
		ps.pending.add(pci);
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
	
	public void begin()
	{
		stack.push(new PendingStack());
	}
	
	public void end()
	{
		stack.pop();
	}
	
	public void rollback()
	{
		PendingStack ps = stack.peek();
		for (PushConstantInstruction pci : ps.pending)
			changes.remove(pci);
	}
}
