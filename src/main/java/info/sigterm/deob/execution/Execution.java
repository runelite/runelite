package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Execution
{
	private ClassGroup group;
	private ArrayList<Path> paths = new ArrayList<Path>(); // paths of execution
	private HashMap<Method, HashSet<Integer>> visited = new HashMap<Method, HashSet<Integer>>();
	//protected HashSet<Method> methods = new HashSet<Method>();

	public Execution(ClassGroup group)
	{
		this.group = group;
	}

	public void run(ClassFile cf, Method method, Object... args)
	{
		Path p = new Path(this);
		ClassInstance instance = p.getClassInstance(cf);
		ObjectInstance object = p.createObject(instance);
		
		int count = 1;
		p.invoke(method, object);
		
		while (!paths.isEmpty())
		{
			p = paths.remove(0);
			++count;
			try
			{
				System.out.println("Resuming path with " + paths.size() + " remaining");
				p.resume();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		System.out.println("Done " + count + " paths");
	}
	
	public void addPath(Path p)
	{
		paths.add(p);
	}
	
	public boolean visit(Method m)
	{
		if (visited.containsKey(m))
			return false;
		
		visited.put(m, new HashSet<Integer>());
		return true;
	}
	
	public boolean visit(Method m, int pc)
	{
		HashSet<Integer> map = visited.get(m);
		if (map == null || !map.contains(pc))
		{
			map.add(pc);
			return true;
		}
		
		return false;
	}
}
