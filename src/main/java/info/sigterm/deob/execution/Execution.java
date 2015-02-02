package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;

import java.util.ArrayList;

public class Execution
{
	private ClassGroup group;
	private ArrayList<Path> paths = new ArrayList<Path>(); // paths of execution

	public Execution(ClassGroup group)
	{
		this.group = group;
	}

	public void run(ClassFile cf, Method method, Object... args)
	{
		Path p = new Path(this);
		ClassInstance instance = p.getClassInstance(cf);
		ObjectInstance object = p.createObject(instance);
		
		p.invoke(method, object);
		
		//process();
	}
	
	public void addPath(Path p)
	{
		paths.add(p);
	}
}
