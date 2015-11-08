package net.runelite.deob.deobfuscators.rename;

import edu.ucla.sspace.graph.Graph;
import edu.ucla.sspace.graph.isomorphism.IsomorphismTester;
import edu.ucla.sspace.graph.isomorphism.TypedVF2IsomorphismTester;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;

public class Rename
{
	// respective executions
	private Execution eone, etwo;
	
	// old -> new object mapping
	private Map<Object, Object> objMap = new HashMap<>();
	
	private boolean compare(Frame f1, Frame f2)
	{
		Graph g1 = f1.getGraph(), g2 = f2.getGraph();
		
		IsomorphismTester isoTest = new TypedVF2IsomorphismTester();
		if (!isoTest.areIsomorphic(g1, g2))
			return false;
		
		Map<Integer, Integer> mapping = isoTest.findIsomorphism(g1, g2);
		Map<Integer, Instruction> map1 = f1.getIdMap(), map2 = f2.getIdMap();
		
		for (Entry<Integer, Integer> e : mapping.entrySet())
		{
			if (e.getKey() == null || e.getValue() == null)
			{
				assert e.getKey() == e.getValue();
				continue;
			}
			
			Instruction i1 = map1.get(e.getKey());
			Instruction i2 = map2.get(e.getValue());
			
			assert i1.getClass() == i2.getClass();
			
			InvokeInstruction ii1 = (InvokeInstruction) i1, ii2 = (InvokeInstruction) i2;
			
			assert ii1.getMethods().size() == ii2.getMethods().size();
			
			for (int i = 0; i < ii1.getMethods().size(); ++i)
			{
				Method m1 = ii1.getMethods().get(i), m2 = ii2.getMethods().get(i);
				
				assert objMap.containsKey(m1) == false || objMap.get(m1) == m2;
				objMap.put(m1, m2);
			}
			
			System.out.println("MATCH " + ii1.getMethods().get(0).getName() + " -> " + ii2.getMethods().get(0).getName());
		}
		
		return true;
	}
	
	private void process(Method one, Method two)
	{
		// get frames for respective methods
		List<Frame> f1 = eone.processedFrames.stream().filter(f -> f.getMethod() == one).collect(Collectors.toList());
		List<Frame> f2 = etwo.processedFrames.stream().filter(f -> f.getMethod() == two).collect(Collectors.toList());
		
		for (Frame fr1 : f1)
			for (Frame fr2 : f2)
				if (compare(fr1, fr2))
					return;
	}
	public void run(ClassGroup one, ClassGroup two)
	{
		eone = new Execution(one);
		eone.populateInitialMethods();
		eone.run();
		
		etwo = new Execution(two);
		etwo.populateInitialMethods();
		etwo.run();
		
		process(
			one.findClass("client").findMethod("init"),
			two.findClass("client").findMethod("init")
		);

		System.out.println("done");
	}
}
