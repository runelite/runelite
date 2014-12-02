package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.Method;

import java.util.ArrayList;

public class Path
{
	private Execution execution;
	private ArrayList<ClassInstance> classes = new ArrayList<ClassInstance>();
	private java.util.Stack<Frame> frames = new java.util.Stack<Frame>(); // current execution frames

	public Path(Execution execution)
	{
		this.execution = execution;
	}

	public Execution getExecution()
	{
		return execution;
	}

	public ClassInstance getClassInstance(ClassFile clazz)
	{
		for (ClassInstance cl : classes)
			if (cl.getClassFile() == clazz)
				return cl;

		/* load parent */
		ClassFile parent = clazz.getParent();
		if (parent != null)
			getClassInstance(parent);

		ClassInstance cl = new ClassInstance(this, clazz);
		classes.add(cl);

		return cl;
	}

	public void init(Method method, Object[] args)
	{
		Frame f = new Frame(this, method);
		frames.push(f);
		f.init(method, args);
	}
}
