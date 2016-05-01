package net.runelite.asm.execution;

import java.util.Arrays;

public class Variables
{
	private VariableContext[] variables;

	public Variables(int sz)
	{
		variables = new VariableContext[sz];
	}
	
	protected Variables(Variables other)
	{
		this.variables = Arrays.copyOf(other.variables, other.variables.length);
	}

	public void set(int index, VariableContext value)
	{
		variables[index] = value;
	}

	public VariableContext get(int index)
	{
		return variables[index];
	}

	public int size()
	{
		return variables.length;
	}
}
