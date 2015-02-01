package info.sigterm.deob.execution;

import java.util.Arrays;

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
	
	protected Stack(Stack other)
	{
		this.size = other.size;
		this.stack = Arrays.copyOf(other.stack, other.stack.length);
		this.ins = Arrays.copyOf(other.ins, other.ins.length);
	}

	public void push(Instruction i, Object obj)
	{
		if (size == stack.length)
			throw new RuntimeException("Stack overflow");

		stack[size] = obj;
		ins[size] = i;
		
		++size;
	}
	
	public Instruction getIns()
	{
		if (size <= 0)
			throw new RuntimeException("Stack underflow");
		
		return ins[size - 1];
	}

	public Object pop()
	{
		if (size <= 0)
			throw new RuntimeException("Stack underflow");

		return stack[--size];
	}
	
	public int getSize()
	{
		return size;
	}
}
