package info.sigterm.deob.execution;

import java.util.Arrays;

public class Stack
{
	private int size;
	private StackContext[] stack;

	public Stack(int sz)
	{
		stack = new StackContext[sz];
	}
	
	protected Stack(Stack other)
	{
		this.size = other.size;
		this.stack = Arrays.copyOf(other.stack, other.stack.length);
	}
	
	private void printStack(StackContext ctx, int level)
	{
		for (int i = 0; i < level; ++i)
			System.err.print(" ");
		System.err.println(ctx.getType().type + " pushed by " + ctx.getIns().getInstruction().getType().getName() + " at " + ctx.getIns().getInstruction().getPc());
		for (StackContext c : ctx.getIns().getPops())
			printStack(c, level + 2);
	}

	public void push(StackContext i)
	{
		if (size == stack.length)
		{
			info.sigterm.deob.Method m = i.getIns().getInstruction().getInstructions().getCode().getAttributes().getMethod();
			System.err.println("in " + m.getMethods().getClassFile().getName() + " method " + m.getNameAndType().getName());
			for (int c = 0; c < stack.length; ++c)
				printStack(stack[c], 0);
			throw new RuntimeException("Stack overflow");
		}
		
		assert !i.getType().type.equals("V");

		System.out.println("PUSH context " + i.getType().type + " from + " + i.getIns().getInstruction());
		stack[size] = i;
		++size;
	}

	public StackContext pop()
	{
		if (size <= 0)
			throw new RuntimeException("Stack underflow");

		System.out.println("POP");
		if (size == 1)
			System.out.println("STACK SIZE IS NOW ZERO");
		return stack[--size];
	}
	
	public int getSize()
	{
		return size;
	}
}
