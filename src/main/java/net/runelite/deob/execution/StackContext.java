package net.runelite.deob.execution;

import java.util.ArrayList;
import java.util.List;
import net.runelite.deob.util.PrimitiveUtils;

public class StackContext
{
	public InstructionContext pushed; // instruction which pushed this
	public List<InstructionContext> poppeds = new ArrayList<>(); // instructions which popped this
	public Type type; // type of this
	private Value value;
	public boolean removed;
	
	public StackContext(InstructionContext pushed, Type type, Value value)
	{
		this.pushed = pushed;
		this.type = type;
		this.value = value;
	}
	
	public StackContext(InstructionContext pushed, Class<?> clazz, Value value)
	{
		assert value.isNull() || value.getValue().getClass() == PrimitiveUtils.unbox(clazz);
		
		this.pushed = pushed;
		type = new Type(clazz.getCanonicalName());
		this.value = value;
	}
	
	public StackContext(InstructionContext pushed, VariableContext vctx)
	{
		this.pushed = pushed;
		this.type = vctx.getType();
		this.value = vctx.getValue();
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
//		assert ParallellMappingExecutor.returnStacks.contains(this) == false;
		if (!this.poppeds.contains(popped))
			this.poppeds.add(popped);
	}

	public Type getType()
	{
		return type;
	}

	public Value getValue()
	{
		return value;
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
