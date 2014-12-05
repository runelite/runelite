package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.Method;

import java.util.ArrayList;

public class Path
{
	private Execution execution;
	private ArrayList<ClassInstance> classes = new ArrayList<ClassInstance>();
	private ArrayList<ObjectInstance> objects = new ArrayList<ObjectInstance>();
	private java.util.Stack<Frame> frames = new java.util.Stack<Frame>(); // current execution frames

	public Path(Execution execution)
	{
		this.execution = execution;
	}
	
	private Path(Path other)
	{
		this.execution = other.execution;
		this.classes = new ArrayList<ClassInstance>(other.classes);
		this.objects = new ArrayList<ObjectInstance>(other.objects);
		this.frames = new java.util.Stack<Frame>();
		this.frames.addAll(other.frames);
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
	
	public ObjectInstance createObject(ClassInstance type)
	{
		ObjectInstance obj = new ObjectInstance(this, type);
		objects.add(obj);
		return obj;
	}
	
	public ArrayInstance createArray(ClassInstance type, int len)
	{
		return new ArrayInstance(this, type, len);
	}
	
	public Frame getCurrentFrame()
	{
		return frames.peek();
	}

	public void init(Method method, Object[] args)
	{
		Frame f = new Frame(this, method);
		frames.push(f);
		f.init(args);
	}
	
	public Path dup()
	{
		Path other = new Path(this);
		execution.addPath(other);
		return other;
	}
}
