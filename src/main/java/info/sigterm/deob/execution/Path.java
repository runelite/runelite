package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Exception;
import info.sigterm.deob.attributes.code.Instruction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Path
{
	private Execution execution;
	private ArrayList<ClassInstance> classes = new ArrayList<ClassInstance>();
	private ArrayList<ObjectInstanceBase> objects = new ArrayList<ObjectInstanceBase>();
	private java.util.Stack<Frame> frames = new java.util.Stack<Frame>(); // current execution frames

	public Path(Execution execution)
	{
		this.execution = execution;
	}
	
	private Path(Path other)
	{
		HashMap<ClassInstance, ClassInstance> classmap = new HashMap<ClassInstance, ClassInstance>();
		
		this.execution = other.execution;
		
		for (ClassInstance c : other.classes)
		{
			ClassInstance newclass = new ClassInstance(this, c);
			classmap.put(c,  newclass);
			this.classes.add(newclass);
		}
		
		for (ObjectInstanceBase o : other.objects)
			o.dup(this, classmap.get(o.getType()));
		
		/* iteration order of a Stack is in reverse */
		for (Frame f : other.frames)
			frames.push(new Frame(this, f));
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
		ArrayInstance arr = new ArrayInstance(this, type, len);
		objects.add(arr);
		return arr;
	}
	
	public Frame getCurrentFrame()
	{
		return frames.peek();
	}
	
	public Path dup()
	{
		Path other = new Path(this);
		execution.addPath(other);
		return other;
	}
	
	public void invoke(Method method, Object... args)
	{
		Frame f = new Frame(this, method);
		Variables vars = f.getVariables();
		for (int i = 0; i < args.length; ++i)
			vars.set(i, args[i]);
		frames.push(f);
		
		while (!frames.isEmpty())
		{
			f = frames.peek();
			f.execute();
			frames.pop();
		}
	}
	
	public void returnFrame(Instruction i, Object value)
	{
		returnFrame();
		Frame prevFrame = getCurrentFrame();
		
		prevFrame.getStack().push(i, value);
	}
	
	public void returnFrame()
	{
		Frame currentFrame = frames.pop();
		currentFrame.executing = false;
	}
	
	public void throwException(Instruction ins, ObjectInstance exception)
	{
		ArrayList<Exception> exceptions = new ArrayList<Exception>();
		
		/* collect all existing exception handlers */
		for (Frame f : frames)
		{
			Collection<Exception> handlers = f.getExceptionHandlers();
			exceptions.addAll(handlers);
		}
		
		for (Exception handler : exceptions)
		{
			/* jump to handler */
			Method handlerMethod = handler.getExceptions().getCode().getAttributes().getMethod();
			
			Path other = this.dup();
			/* walk up the frames until we find the one which holds the exception handler */ 
			while (handlerMethod != other.getCurrentFrame().getMethod())
				other.returnFrame();
			
			/* handler pc is absolute from the beginning instruction */
			other.getCurrentFrame().jumpAbsolute(handler.getHandlerPc());
		}
	}
}
