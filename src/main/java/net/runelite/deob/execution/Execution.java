package net.runelite.deob.execution;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Execution
{
	private ClassGroup group;
	public List<Frame> frames = new ArrayList<>(),
			processedFrames = new ArrayList<>();
	private List<Method> pendingMethods = new ArrayList<>(); // pending methods
	public Set<Method> methods = new HashSet<>(); // all methods
	public Set<Instruction> executed = new HashSet<>(); // executed instructions

	public Execution(ClassGroup group)
	{
		this.group = group;
	}
	
	public void populateInitialMethods()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (!Deob.isObfuscated(m.getName()) && !m.getName().equals("<init>"))
				{
					addMethod(m); // I guess this method name is overriding a jre interface (init, run, ?).
				}
			}
		}
	}
	
	public void addMethod(Method method)
	{
		assert method != null;
		
		if (methods.contains(method))
			return; // already processed
		
		pendingMethods.add(method);
		methods.add(method);
	}
	
	public void run()
	{
		int count = 0, fcount = 0;
		while (!pendingMethods.isEmpty())
		{
			Method method = pendingMethods.remove(0);
			
			if (method.getCode() == null)
				continue;
				
			Frame f = new Frame(this, method);
			frames.add(f);
				
			fcount += this.runFrames();
			++count;
		}
		
		System.out.println("Processed " + count + " methods and " + fcount + " paths");
	}
	
	private int runFrames()
	{
		int fcount = 0;
		
		while (!frames.isEmpty())
		{
			Frame frame = frames.remove(0);
			++fcount;
			frame.execute();
			processedFrames.add(frame);
		}
		
		return fcount;
	}
}
