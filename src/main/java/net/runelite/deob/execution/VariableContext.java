package net.runelite.deob.execution;

import java.util.ArrayList;
import java.util.List;

public class VariableContext
{
	private StackContext ctx; // the value stored
	private InstructionContext ic; // the instruction which stored it. also ctx.popped?
	private Type type;
	private List<InstructionContext> read = new ArrayList<>(); // instructions which reads this
	private Value value;

	public VariableContext(InstructionContext i, StackContext ctx)
	{
		ic = i;
		this.ctx = ctx;
		type = ctx.getType();
		value = ctx.getValue();
	}
	
	public VariableContext(Type type) // for entrypoints
	{
		this.type = type;
	}
	
	public VariableContext(InstructionContext i, VariableContext other)
	{
		ic = i;
		ctx = other.ctx;
		type = other.type;
		value = other.value;
	}
	
	public VariableContext(InstructionContext i, Type type, Value value)
	{
		ic = i;
		this.type = type;
		this.value = value;
	}
	
	public StackContext getStackContext()
	{
		return ctx;
	}
	
	public InstructionContext getInstructionWhichStored()
	{
		return ic;
	}
	
	public Type getType()
	{
		return type;
	}

	public Value getValue()
	{
		return value;
	}
	
	public void addRead(InstructionContext ctx)
	{
		if (!read.contains(ctx))
			read.add(ctx);
	}

	public List<InstructionContext> getRead()
	{
		return read;
	}	
}
