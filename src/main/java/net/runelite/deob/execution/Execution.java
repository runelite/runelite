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
	private Map<Method, MethodContext> methodContexts = new HashMap<>();
	private boolean buildGraph; // if true the frame graph is built and execution hasJumped also compares previous instructions
	private Graph graph = new Graph();

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
	
	private boolean hasInvoked(InstructionContext from, Method to)
	{
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
		initializeGraph();
		
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
	
	public MethodContext getMethodContext(Method m)
	{
		MethodContext c = methodContexts.get(m);
		if (c != null)
			return c;
		
		c = new MethodContext(this);
		methodContexts.put(m, c);
		return c;
	}

	public boolean isBuildGraph()
	{
		return buildGraph;
	}

	public void setBuildGraph(boolean buildGraph)
	{
		this.buildGraph = buildGraph;
	}
	
	private void initializeGraph()
	{
		if (!isBuildGraph())
			return;
		
		for (ClassFile cf : this.group.getClasses())
		{
			//graph.addVertex(cf, VertexType.CLASS);
			
			for (Method m : cf.getMethods().getMethods())
			{
				if (m.isStatic() && !m.getName().equals("<clinit>"))
					continue;
				
				graph.addVertex(m, VertexType.METHOD);
			}
			
			for (Field f : cf.getFields().getFields())
			{
				graph.addVertex(f, VertexType.FIELD);
			}
		}
	}
	
	protected void buildGraph(Frame frame, Instruction i, InstructionContext ctx)
	{
		if (!isBuildGraph())
			return;
		
		assert frame.getMethod() == frame.nonStatic || frame.nonStatic.isStatic() == false;
		assert ctx.getInstruction() == i;
		
		if (i instanceof InvokeInstruction)
		{
			if (i instanceof InvokeStatic)
				return;
			
			InvokeInstruction ii = (InvokeInstruction) i;
			
			List<Method> methods = ii.getMethods();
			if (methods.isEmpty())
				return;
			
			for (Method m : methods)
			{
				graph.addEdge(new Edge(i, graph.getVertexFor(frame.nonStatic), graph.getVertexFor(m), EdgeType.INVOKE));
				graph.addEdge(new Edge(i, graph.getVertexFor(m), graph.getVertexFor(frame.nonStatic), EdgeType.INVOKED_FROM));
			}
		}
		else if (i instanceof FieldInstruction)
		{
			FieldInstruction fi = (FieldInstruction) i;
			
			if (fi.getMyField() == null)
				return;
			
			//int id = frame.getMethodCtx().fcount++;
			EdgeType type = fi instanceof GetFieldInstruction ? EdgeType.GETFIELD : EdgeType.SETFIELD;
			graph.addEdge(new Edge(i, graph.getVertexFor(frame.nonStatic), graph.getVertexFor(fi.getMyField()), type));
			EdgeType typeRev = fi instanceof GetFieldInstruction ? EdgeType.GETFIELD_FROM : EdgeType.SETFIELD_FROM;
			graph.addEdge(new Edge(i, graph.getVertexFor(fi.getMyField()), graph.getVertexFor(frame.nonStatic), typeRev));
			
			if (fi instanceof SetFieldInstruction && frame.lastField != null)
			{
				//graph.addEdge(new MethodEdge(i, graph.getVertexFor(fi.getMyField()), graph.getVertexFor(frame.lastField), EdgeType.PREV_FIELD, frame.nonStatic));
				//graph.addEdge(new MethodEdge(i, graph.getVertexFor(frame.lastField), graph.getVertexFor(fi.getMyField()), EdgeType.PREV_FIELD_FROM, frame.nonStatic));
			}
			
//			if (fi instanceof SetFieldInstruction)
//			{
//				StackContext sctx = ctx.getPops().get(0);
//				if (sctx.getPushed().getInstruction() instanceof GetFieldInstruction)
//				{
//					GetFieldInstruction gfi = (GetFieldInstruction) sctx.getPushed().getInstruction();
//					
//					if (gfi.getMyField() != null)
//					{
//						// XXX dup edges
//						graph.addEdge(new MethodEdge(i, graph.getVertexFor(fi.getMyField()), graph.getVertexFor(gfi.getMyField()), EdgeType.FIELD_ASSIGNMENT_FIELD, frame.nonStatic));
//						graph.addEdge(new MethodEdge(i, graph.getVertexFor(gfi.getMyField()), graph.getVertexFor(fi.getMyField()), EdgeType.FIELD_ASSIGNMENT_FIELD_FROM, frame.nonStatic));
//					}
//				}
//			}
			
//			// associated fields
//			for (InstructionContext ic : getInsInExpr(ctx, new HashSet<>()))
//			{
//				Instruction i2 = (Instruction) ic.getInstruction();
//				
//				if (i2 instanceof FieldInstruction)
//				{
//					FieldInstruction fi2 = (FieldInstruction) i2;
//					
//					if (fi2.getMyField() == null)
//						continue;
//					
//					// these are within the context of a method
//					graph.addEdge(new MethodEdge(i2, graph.getVertexFor(fi.getMyField()), graph.getVertexFor(fi2.getMyField()), EdgeType.FIELD_ASSOCIATION, frame.nonStatic));
//					graph.addEdge(new MethodEdge(i2, graph.getVertexFor(fi2.getMyField()), graph.getVertexFor(fi.getMyField()), EdgeType.FIELD_ASSOCIATION_FROM, frame.nonStatic));
//				}
//				else if (i2 instanceof InvokeInstruction)
//				{
//					InvokeInstruction ii2 = (InvokeInstruction) i2;
//					
//					if (ii2 instanceof InvokeStatic)
//						continue;
//					
//					for (Method m : ii2.getMethods())
//					{
//						graph.addEdge(new MethodEdge(i2, graph.getVertexFor(fi.getMyField()), graph.getVertexFor(m), EdgeType.METHOD_ASSOCIATION, frame.nonStatic));
//						graph.addEdge(new MethodEdge(i2, graph.getVertexFor(m), graph.getVertexFor(fi.getMyField()), EdgeType.METHOD_ASSOCIATION_FROM, frame.nonStatic));
//					}
//				}
//			}
		}
	}
	
	private static List<InstructionContext> getInsInExpr(InstructionContext ctx, Set<Instruction> set)
	{
		List<InstructionContext> l = new ArrayList<>();
		
		if (ctx == null || set.contains(ctx.getInstruction()))
			return l;

		set.add(ctx.getInstruction());
		
		l.add(ctx);
		
		for (StackContext s : ctx.getPops())
			l.addAll(getInsInExpr(s.getPushed(), set));
		for (StackContext s : ctx.getPushes())
			for (InstructionContext i : s.getPopped())
				l.addAll(getInsInExpr(i, set));
		
		return l;
	}
	
	public Graph getGraph()
	{
		return graph;
	}
}
