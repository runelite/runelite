package net.runelite.deob.execution;

import edu.ucla.sspace.graph.DirectedEdge;
import edu.ucla.sspace.graph.Graph;
import edu.ucla.sspace.graph.SimpleDirectedEdge;
import edu.ucla.sspace.graph.SparseDirectedGraph;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.util.IdGen;
import org.apache.commons.collections4.map.MultiValueMap;

class MIKey
{
	private List<Method> method;
	private InstructionContext ictx;

	public MIKey(List<Method> method, InstructionContext ictx)
	{
		this.method = method;
		this.ictx = ictx;
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 61 * hash + Objects.hashCode(this.method);
		hash = 61 * hash + Objects.hashCode(this.ictx);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final MIKey other = (MIKey) obj;
		if (!Objects.equals(this.method, other.method))
		{
			return false;
		}
		if (!Objects.equals(this.ictx, other.ictx))
		{
			return false;
		}
		return true;
	}
	
	
}

public class MethodContext
{
	private Execution execution;
	private MultiValueMap<MIKey, Instruction> visited = new MultiValueMap<>();
	private IdGen ids = new IdGen();
	private Map<Integer, Instruction> idMap = new HashMap<>();
	private Map<Instruction, Integer> insMap = new HashMap<>();
	private Graph graph = new SparseDirectedGraph();

	public MethodContext(Execution execution)
	{
		this.execution = execution;
	}
	
	public Map<Integer, Instruction> getIdMap()
	{
		return idMap;
	}

	public Graph getGraph()
	{
		return graph;
	}
	
	protected boolean hasJumped(List<Method> fromm, InstructionContext from, Instruction to)
	{
		// with this true, there are so many frames I can't run a full execution without oom.
		MIKey key = execution.isBuildGraph() ? new MIKey(fromm, from) : new MIKey(null, from);
		Collection<Instruction> i = visited.getCollection(key);
		if (i != null && i.contains(to))
			return true;
		
		visited.put(key, to);
		return false;
	}
	
	private int getIdFor(Instruction i)
	{
		if (insMap.containsKey(i))
			return insMap.get(i);
		
		int id = ids.get();
		
		//graph.add(id);
		
		this.idMap.put(id, i);
		this.insMap.put(i, id);
		
		return id;
	}
	
	protected void buildGraph(Frame frame, Instruction i)
	{
		if (!execution.isBuildGraph())
			return;
		
		if (i instanceof InvokeInstruction)
		{
//			if (i instanceof InvokeStatic)
//				return;
			
			InvokeInstruction ii = (InvokeInstruction) i;
			
			List<Method> methods = ii.getMethods();
			if (methods.isEmpty())
				return;
		}
//		else if (i instanceof FieldInstruction)
//		{
//			FieldInstruction fi = (FieldInstruction) i;
//			
//			if (fi.getMyField() == null)
//				return;
//		}
		else
		{
			return;
		}
		
		if (frame.prevVertex == -1)
		{
			int id = getIdFor(i);
			//int id = ids.get();
			//graph.add(id);
			frame.prevVertex = id;
			//this.idMap.put(id, i);
			return;
		}
		
		int id = getIdFor(i);
		//int id = ids.get();
		//graph.add(id);
		//idMap.put(id, i);
		
		if (id == frame.prevVertex)
			return;
		
		DirectedEdge edge = new SimpleDirectedEdge(frame.prevVertex, id);
		graph.add(edge);
		
		frame.prevVertex = id;
	}
}
