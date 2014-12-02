package info.sigterm.deob.execution;

import info.sigterm.deob.Method;

public class Path
{
	private Execution execution;
	private java.util.Stack<Frame> frames = new java.util.Stack<Frame>(); // current execution frames

	public Path(Execution execution)
	{
		this.execution = execution;
	}

	public void init(Method method, Object[] args)
	{
		Frame f = new Frame(this, method);
		frames.push(f);
		f.init(method, args);
	}
}
