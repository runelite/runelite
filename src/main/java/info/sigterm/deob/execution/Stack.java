package info.sigterm.deob.execution;

import info.sigterm.deob.attributes.code.Instruction;

public class Stack
{
	private int size;
	private Object[] stack;
	private Instruction[] ins;

	public Stack(int sz)
	{
		stack = new Object[sz];
		ins = new Instruction[sz];
	}

	public void push(Instruction i, Object obj)
	{
		if (size == stack.length)
			throw new RuntimeException("Stack overflow");

		stack[size] = obj;
		ins[size] = i;
		
		++size;
	}

	public Object pop()
	{
		if (size <= 0)
			throw new RuntimeException("Stack underflow");

		return stack[--size];
	}
}
