package net.runelite.deob.execution;

import java.util.ArrayList;
import java.util.List;

public class StackContext
{
	public InstructionContext pushed; // instruction which pushed this
	public List<InstructionContext> poppeds = new ArrayList<>(); // instructions which popped this
	public Type type; // type of this
	public boolean removed;
	public int encryption; // if this value is encrypted, this is the key to get the real value
	
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

	public List<InstructionContext> getPopped()
	{
		return poppeds;
	}

	public void addPopped(InstructionContext popped)
	{
		if (!this.poppeds.contains(popped))
			this.poppeds.add(popped);
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
