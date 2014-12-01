package info.sigterm.deob.execution;

import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.pool.Method;

public class Execution
{
	private ClassGroup group;
	private java.util.Stack<Frame> frames = new java.util.Stack<Frame>();

	public Execution(ClassGroup group)
	{
		this.group = group;
	}

	public void run(Method method, Object... args)
	{
	}
}
