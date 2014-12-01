package info.sigterm.deob.execution;

public class Stack
{
	private int size;
	private Object[] stack;

	public Stack(int sz)
	{
		stack = new Object[sz];
	}

	public void push(Object obj)
	{
		if (size == stack.length)
			throw new RuntimeException("Stack overflow");

		stack[size++] = obj;
	}

	public Object pop()
	{
		if (size <= 0)
			throw new RuntimeException("Stack underflow");

		return stack[--size];
	}
}
