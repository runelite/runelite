package info.sigterm.deob.execution;

public class Variables
{
	private Object[] variables;

	public Variables(int sz)
	{
		variables = new Object[sz];
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
