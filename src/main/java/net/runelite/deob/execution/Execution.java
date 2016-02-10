package net.runelite.deob.execution;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.deobfuscators.rename.graph.Edge;
import net.runelite.deob.deobfuscators.rename.graph.EdgeType;
import net.runelite.deob.deobfuscators.rename.graph.FieldEdge;
import net.runelite.deob.deobfuscators.rename.graph.Graph;
import net.runelite.deob.deobfuscators.rename.graph.MethodEdge;
import net.runelite.deob.deobfuscators.rename.graph.VertexType;
import org.apache.commons.collections4.map.MultiValueMap;

public class Execution
{
	private ClassGroup group;
	public List<Frame> frames = new LinkedList<>(),
			processedFrames = new LinkedList<>();
	public Set<Method> methods = new HashSet<>(); // all methods
	public Set<Instruction> executed = new HashSet<>(); // executed instructions
	private MultiValueMap<InstructionContext, Method> invokes = new MultiValueMap<>();
	public MultiValueMap<Instruction, InstructionContext> contexts = new MultiValueMap<>();
	public boolean paused;
	public boolean step = false;

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
		// this is wrong because the called of the method of from
		// might be different, for building graph
		Collection<Method> methods = invokes.getCollection(from);
		if (methods != null && methods.contains(to))
			return true;
		
		invokes.put(from, to);
		return false;
	}

	private void addFrame(Frame frame)
	{
		frames.add(frame);
	}
	
	public Frame invoke(InstructionContext from, Method to)
	{
		if (step) // step executor
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

			frames.remove(frame);
			processedFrames.add(frame);
		}
		
		System.out.println("Processed " + fcount + " frames");
	}
	
	public Collection<InstructionContext> getInstructonContexts(Instruction i)
	{
		return contexts.getCollection(i);
	}
}
