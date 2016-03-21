package net.runelite.asm.attributes.code.instruction.types;

import java.util.List;

import net.runelite.asm.Method;
import net.runelite.asm.pool.PoolEntry;

public interface InvokeInstruction extends MappableInstruction
{
	public void removeParameter(int idx);
	
	public PoolEntry getMethod();
	
	public List<Method> getMethods();
}
