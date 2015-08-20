package net.runelite.deob.execution;

import java.util.ArrayList;
import java.util.List;

public class StackContext
{
	public InstructionContext pushed; // instruction which pushed this
	public InstructionContext popped; // instruction which popped this
	public Type type; // type of this
	public boolean removed;
	
	public StackContext(InstructionContext pushed, Type type)
	{
		this.pushed = pushed;
		this.type = type;
	}
	
	public StackContext(InstructionContext pushed, Class<?> clazz)
	{
		this.pushed = pushed;
		type = new Type(clazz.getCanonicalName());
	}
	
	public StackContext(InstructionContext pushed, net.runelite.deob.pool.Class c)
	{
		this.pushed = pushed;
		type = new Type(c.getName());
	}

	public InstructionContext getPushed()
	{
		return pushed;
	}

	public InstructionContext getPopped()
	{
		return popped;
	}

	public void setPopped(InstructionContext popped)
	{
		this.popped = popped;
	}

	public Type getType()
	{
		return type;
	}
	
	// remove this object from the stack
	public List<StackContext> removeStack()
	{
		List<StackContext> list = new ArrayList<>();
		
		list.add(this);
		
		// remove the instruction which pushed this
		if (!pushed.getInstruction().removeStack())
			// dup will return false as the other objects on the stack below this are necessary
			// for the other branch.
			return list;
		
		// remove from the stack things this instruction read
		for (StackContext ctx : pushed.getPops()) 
			list.addAll(ctx.removeStack());
		
		return list;
	}
}
