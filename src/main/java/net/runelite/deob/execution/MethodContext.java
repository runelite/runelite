package net.runelite.deob.execution;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.deobfuscators.rename.graph.Graph;
import org.apache.commons.collections4.map.MultiValueMap;

public class MethodContext
{
	private Execution execution;
	private MultiValueMap<InstructionContext, Instruction> visited = new MultiValueMap<>();
	//private IdGen ids = new IdGen();
	//private Map<Integer, List<Method>> idMap = new HashMap<>();
	//private Map<List<Method>, Integer> insMap = new HashMap<>();
//	private Graph graph = new Graph();

	public MethodContext(Execution execution)
	{
		this.execution = execution;
	}
	
//	public Map<Integer, List<Method>> getIdMap()
//	{
//		return idMap;
//	}


	
	protected boolean hasJumped(InstructionContext from, Instruction to)
	{
		Collection<Instruction> i = visited.getCollection(from);
		if (i != null && i.contains(to))
			return true;
		
		visited.put(from, to);
		return false;
	}
	
//	private int getIdFor(List<Method> i)
//	{
//		if (insMap.containsKey(i))
//			return insMap.get(i);
//		
//		assert idMap.values().contains(i) == false;
//		
//		int id = ids.get();
//		
//		//graph.add(id);
//		
//		this.idMap.put(id, i);
//		this.insMap.put(i, id);
//		
//		return id;
//	}
	
//	protected void buildGraph(Frame frame, Instruction i)
//	{
//		if (!execution.isBuildGraph())
//			return;
//		
//		List<Object> to;
//		//List<Method> methods;
//		if (i instanceof InvokeInstruction)
//		{
//			if (i instanceof InvokeStatic)
//				return;
//			
//			InvokeInstruction ii = (InvokeInstruction) i;
//			
//			List<Method> methods = ii.getMethods();
//			if (methods.isEmpty())
//				return;
//			
//			to = (List) methods;
//		}
//		else if (i instanceof FieldInstruction)
//		{
//			FieldInstruction fi = (FieldInstruction) i;
//			
//			if (fi.getMyField() == null)
//				return;
//			
//			to = Arrays.asList(fi.getMyField());
//		}
//		else
//		{
//			return;
//		}
//		
//		to.stream().forEach(o -> graph.addEdge(frame.getMethod(), o));
//		
////		if (frame.prevVertex.intValue() == -1)
////		{
////			int id = getIdFor(methods);
////			//int id = ids.get();
////			//graph.add(id);
////			frame.prevVertex.setValue(id);
////			//this.idMap.put(id, i);
////			return;
////		}
////		
////		int id = getIdFor(methods);
////		//int id = ids.get();
////		//graph.add(id);
////		//idMap.put(id, i);
////		
////		if (frame.prevVertex.intValue() == id)
////			return;
////		
////		DirectedEdge edge = new SimpleDirectedEdge(frame.prevVertex.intValue(), id);
////		
////		if (graph.contains(edge) == false)
////		{
////			List<Method> from = this.idMap.get(frame.prevVertex.intValue()), to = this.idMap.get(id);
////			System.out.println("Added edge " + from.get(0).getMethods().getClassFile().getName() + "." + from.get(0).getName() + 
////				" to " + to.get(0).getMethods().getClassFile().getName() + "." + to.get(0).getName() +
////				" (" + frame.prevVertex.intValue() + " -> " + id + ")");
////
////			graph.add(edge);
////		}
////		
////		frame.prevVertex.setValue(id);
//	}
}
