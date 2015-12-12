package net.runelite.deob.deobfuscators.rename.graph;

import java.util.HashSet;
import java.util.List;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;

public class GraphBuilder
{
	public static Graph build(ClassGroup group)
	{
		// statically build
		Graph g = new Graph();
		
		// add verticies
		for (ClassFile cf : group.getClasses())
		{
			//g.addVertex(cf, VertexType.CLASS);
			
			for (Field f : cf.getFields().getFields())
			{
				g.addVertex(f, VertexType.FIELD);
			}
			
			for (Method m : cf.getMethods().getMethods())
			{
				g.addVertex(m, VertexType.METHOD);
			}
		}
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				processMethod(g, m);
			}
		}
		
		// remove static methods
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (m.isStatic() && !m.getName().equals("<clinit>"))
				{
					removeMethod(g, m);
					
					Vertex v = g.getVertexFor(m);
					
					assert v.getEdges().isEmpty();
					assert v.getEdgesFrom().isEmpty();
					
					g.removeVertex(m);
				}
			}
		}
		
		return g;
	}
	
	private static void processMethod(Graph graph, Method method)
	{
		Code code = method.getCode();
		if (code == null)
			return;
		
		for (Instruction i : code.getInstructions().getInstructions())
		{
			if (i instanceof InvokeInstruction)
			{
				if (i instanceof InvokeStatic)
					return;

				InvokeInstruction ii = (InvokeInstruction) i;

				List<Method> methods = ii.getMethods();
				if (methods.isEmpty())
					return;
				
				Vertex methodVertex = graph.getVertexFor(method);

				for (Method m : methods)
				{
					Vertex otherMethodVertex = graph.getVertexFor(m);
					
					graph.addEdge(new Edge(null, methodVertex, otherMethodVertex, EdgeType.INVOKE));
					graph.addEdge(new Edge(null, otherMethodVertex, methodVertex, EdgeType.INVOKED_FROM));
				}
			}
			else if (i instanceof FieldInstruction)
			{
				FieldInstruction fi = (FieldInstruction) i;

				if (fi.getMyField() == null)
					return;
				
				Vertex methodVertex = graph.getVertexFor(method),
					fieldVertex = graph.getVertexFor(fi.getMyField());

				EdgeType type = fi instanceof GetFieldInstruction ? EdgeType.GETFIELD : EdgeType.SETFIELD;
				graph.addEdge(new Edge(null, methodVertex, fieldVertex, type));
				EdgeType typeRev = fi instanceof GetFieldInstruction ? EdgeType.GETFIELD_FROM : EdgeType.SETFIELD_FROM;
				graph.addEdge(new Edge(null, fieldVertex, methodVertex, typeRev));
			}
		}
	}
	
	private static void removeMethod(Graph g, Method m)
	{
		Vertex v = g.getVertexFor(m);
		
		// for every object that points to m, make it point to
		// everything that m points to, with edge type of the edge from m.
		
		for (Edge e : new HashSet<>(v.getEdgesFrom()))
		{
			// edge is TO v
			assert e.getTo() == v;
			
			Vertex from = e.getFrom();
			
			// add an edge from -> everything v is to
			
			for (Edge e2 : new HashSet<>(v.getEdges()))
			{
				assert e2.getFrom() == v;
				
				Vertex to = e2.getTo();
				EdgeType type = e2.getType();
				
				// add edge
				from.addEdge(new Edge(null, from, to, type));
			}
			
				
			// remove
			from.removeEdge(e);
		}
		
		// for every object m points to, everything that points to m should point to it.
		for (Edge e : new HashSet<>(v.getEdges()))
		{
			assert e.getFrom() == v;
			
			Vertex to = e.getTo();
			EdgeType type = e.getType();
			
			for (Edge e2 : new HashSet<>(v.getEdgesFrom()))
			{
				assert e2.getTo() == v;
				
				// add edge from -> to
				Vertex from = e2.getFrom();
				
				from.addEdge(new Edge(null, from, to, type));
			}
			
			v.removeEdge(e);
		}
	}
}
