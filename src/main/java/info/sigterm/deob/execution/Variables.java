package info.sigterm.deob.execution;

import java.util.Arrays;

public class Variables
{
	private Object[] variables;

	public Variables(int sz)
	{
		variables = new Object[sz];
	}
	
	protected Variables(Variables other)
	{
		this.variables = Arrays.copyOf(other.variables, other.variables.length);
	}

	public void set(int index, Object value)
	{
		variables[index] = value;
	}

	public Object get(int index)
	{
		return variables[index];
	}
}
