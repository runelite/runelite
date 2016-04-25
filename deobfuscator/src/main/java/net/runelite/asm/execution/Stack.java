package net.runelite.asm.execution;

import java.util.Arrays;
import java.util.List;

public class Stack
{
	private int size;
	private StackContext[] stack;

	public Stack(int sz)
	{
		stack = new StackContext[sz*2]; // XXX FIXME
	}
	
	public Stack(Stack other)
	{
		this.size = other.size;
		this.stack = Arrays.copyOf(other.stack, other.stack.length);
	}
	
	private void printStack(StackContext ctx, int level)
	{
		for (int i = 0; i < level; ++i)
			System.err.print(" ");
		System.err.println(ctx.getType().type + " pushed by " + ctx.getPushed().getInstruction().getType().getName() + " at " + ctx.getPushed().getInstruction().getPc());
		for (StackContext c : ctx.getPushed().getPops())
			printStack(c, level + 2);
	}

	public void push(StackContext i)
	{
		if (size == stack.length)
		{
			net.runelite.asm.Method m = i.getPushed().getInstruction().getInstructions().getCode().getAttributes().getMethod();
			System.err.println("stack overflow in " + m.getMethods().getClassFile().getName() + " method " + m.getNameAndType().getName());
			for (int c = 0; c < stack.length; ++c)
				printStack(stack[c], 0);
			throw new RuntimeException("Stack overflow");
		}
		
		assert !i.getType().type.equals("V");

		stack[size] = i;
		++size;
	}

	public StackContext pop()
	{
		if (size <= 0)
			throw new RuntimeException("Stack underflow");

		return stack[--size];
	}
	
	public int getSize()
	{
		return size;
	}
	
	public List<StackContext> getStack()
	{
		return Arrays.asList(stack);
	}
}
