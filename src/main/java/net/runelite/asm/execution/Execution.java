package net.runelite.asm.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import org.apache.commons.collections4.map.MultiValueMap;

public class Execution
{
	private ClassGroup group;
	public List<Frame> frames = new ArrayList<>(), framesOther = new ArrayList<>();
	public Set<Method> methods = new HashSet<>(); // all methods
	public Set<Instruction> executed = new HashSet<>(); // executed instructions
	private MultiValueMap<WeakInstructionContext, Method> invokes = new MultiValueMap<>();
	public boolean paused;
	public boolean step = false;
	public boolean processInvokes = true;
	private List<ExecutionVisitor> visitors = new ArrayList<>();
	private List<FrameVisitor> frameVisitors = new ArrayList<>();
	private List<MethodContextVisitor> methodContextVisitors = new ArrayList<>();

	public Execution(ClassGroup group)
	{
		this.group = group;
	}
	
	public List<Method> getInitialMethods()
	{
		List<Method> methods = new ArrayList<>();
		
		group.buildClassGraph(); // required when looking up methods
		group.lookup(); // lookup methods
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (!Deob.isObfuscated(m.getName()) && !m.getName().equals("<init>"))
				{
					if (m.getCode() == null)
					{
						methods.add(m);
						continue;
					}
					
					methods.add(m); // I guess this method name is overriding a jre interface (init, run, ?).
				}
			}
		}
		
		return methods;
	}
	
	public void populateInitialMethods()
	{
		for (Method m : this.getInitialMethods())
		{
			if (m.getCode() == null)
			{
				methods.add(m);
				continue;
			}

			Frame frame = new Frame(this, m);
			frame.initialize();
			addFrame(frame); // I guess this method name is overriding a jre interface (init, run, ?).
		}
	}
	
	public boolean hasInvoked(InstructionContext from, Method to)
	{
		Collection<Method> methods = invokes.getCollection(from.toWeak());
		if (methods != null && methods.contains(to))
			return true;
		
		invokes.put(from.toWeak(), to);
		return false;
	}

	public void addFrame(Frame frame)
	{
		if (frames.isEmpty() || frames.get(0).getMethod() == frame.getMethod())
			frames.add(frame);
		else
			framesOther.add(frame);
	}
	
	public Frame invoke(InstructionContext from, Method to)
	{
		if (step) // step executor
			return null;
		
		if (!processInvokes)
			return null;
		
		if (hasInvoked(from, to))
			return null;
		
		Frame f = new Frame(this, to);
		f.initialize(from);
		this.addFrame(f);
		return f;
	}
	
	public void addMethod(Method to)
	{
		Frame f = new Frame(this, to);
		f.initialize();
		this.addFrame(f);
	}
	
	public void run()
	{
		assert !paused;
		
		int fcount = 0;
		while (!frames.isEmpty())
		{
			Frame frame = frames.get(0);
			
			methods.add(frame.getMethod());
			
			++fcount;
			frame.execute();
			
			assert frames.get(0) == frame;
			assert !frame.isExecuting();

			accept(frame);

			frames.remove(frame);
			
			if (frames.isEmpty())
			{
				accept(frame.getMethodCtx());
				frames.addAll(framesOther);
				framesOther.clear();
			}
		}
		
		System.out.println("Processed " + fcount + " frames");
	}

	public void addExecutionVisitor(ExecutionVisitor ev)
	{
		this.visitors.add(ev);
	}

	public void accept(InstructionContext ic)
	{
		visitors.forEach(v -> v.visit(ic));
	}

	public void addFrameVisitor(FrameVisitor pv)
	{
		this.frameVisitors.add(pv);
	}

	public void accept(Frame f)
	{
		frameVisitors.forEach(v -> v.visit(f));
	}
	
	public void addMethodContextVisitor(MethodContextVisitor mcv)
	{
		methodContextVisitors.add(mcv);
	}
	
	public void accept(MethodContext m)
	{
		methodContextVisitors.forEach(mc -> mc.visit(m));
	}
}
