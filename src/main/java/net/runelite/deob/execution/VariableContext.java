package net.runelite.deob.execution;

public class VariableContext
{
	private StackContext ctx; // the value stored
	private InstructionContext ic; // the instruction which stored it. also ctx.popped?
	private Type type;

	public VariableContext(InstructionContext i, StackContext ctx)
	{
		ic = i;
		this.ctx = ctx;
		type = ctx.getType();
	}
	
	public VariableContext(Type type) // for entrypoints
	{
		this.type = type;
	}
	
	public StackContext getStackContext()
	{
		return ctx;
	}
	
	public Type getType()
	{
		return type;
	}
}
