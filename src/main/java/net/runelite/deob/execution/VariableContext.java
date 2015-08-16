package net.runelite.deob.execution;

public class VariableContext
{
	private InstructionContext ic;
	private Type type;

	public VariableContext(InstructionContext i, Type t)
	{
		ic = i;
		type = t;
	}
	
	public Type getType()
	{
		return type;
	}
}
