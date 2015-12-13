package net.runelite.deob.attributes.code.instruction.types;

import java.util.List;

import net.runelite.deob.Method;
import net.runelite.deob.pool.PoolEntry;

public interface InvokeInstruction extends MappableInstruction
{
	public void removeParameter(int idx);
	
	public PoolEntry getMethod();
	
	public List<Method> getMethods();
}
