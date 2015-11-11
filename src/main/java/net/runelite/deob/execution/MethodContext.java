package net.runelite.deob.execution;

import edu.ucla.sspace.graph.DirectedEdge;
import edu.ucla.sspace.graph.Graph;
import edu.ucla.sspace.graph.SimpleDirectedEdge;
import edu.ucla.sspace.graph.SparseDirectedGraph;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.util.IdGen;
import org.apache.commons.collections4.map.MultiValueMap;

public class MethodContext
{
	private MultiValueMap<InstructionContext, Instruction> visited = new MultiValueMap<>();
	private IdGen ids = new IdGen();
	private Map<Integer, Instruction> idMap = new HashMap<>();
	private Map<Instruction, Integer> insMap = new HashMap<>();
	private Graph graph = new SparseDirectedGraph();
	
	public Map<Integer, Instruction> getIdMap()
	{
		return idMap;
	}

	public Graph getGraph()
	{
		return graph;
	}
	
	protected boolean hasJumped(InstructionContext from, Instruction to)
	{
		Collection<Instruction> i = visited.getCollection(from);
		if (i != null && i.contains(to))
			return true;
		
		visited.put(from, to);
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
		if (i instanceof InvokeInstruction)
		{
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
