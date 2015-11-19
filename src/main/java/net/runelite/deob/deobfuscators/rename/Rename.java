package net.runelite.deob.deobfuscators.rename;

import edu.ucla.sspace.graph.Edge;
import edu.ucla.sspace.graph.Graph;
import edu.ucla.sspace.graph.isomorphism.IsomorphismTester;
import edu.ucla.sspace.graph.isomorphism.VF2IsomorphismTester;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Method;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.MethodContext;

public class Rename
{
	private ClassGroup groupOne, groupTwo;
	
	// respective executions
	//private Execution eone, etwo;
	
	// old -> new object mapping
	private Map<Object, Object> objMap = new HashMap<>();
	
	// methods which have been processed in the original
	private Set<Method> processed = new HashSet<>();
	
	private static String cname(Method m) { return m.getMethods().getClassFile().getName(); }
	private static String mname(Method m) { return cname(m) + "." + m.getName(); }
	
	private void compare(MethodContext m1, Graph g1, MethodContext m2, Graph g2)
	{
		Set<Edge> edges = new HashSet<>(g1.edges()); // edges in g1 not in g2
		for (Edge e : (Set<Edge>) g2.edges())
		{
			edges.remove(e);
		}
		
		for (Edge e : edges)
		{
			Method me1 = m1.getIdMap().get(e.from()).get(0);
			Method me2 = m1.getIdMap().get(e.to()).get(0);
			
			System.out.println("EDGE IN 1 NOT IN 2: " + mname(me1) + " -> " + mname(me2));
			
			Method om1 = m2.getIdMap().get(e.from()).get(0);
			Method om2 = m2.getIdMap().get(e.to()).get(0);
			
			System.out.println("  OTHER SIDE: " + mname(om1) + " -> " + mname(om2));
		}
		//System.out.println(edges);
		
		if (g2.order() == g1.order())
		{
			int[] v1 = g1.vertices().toPrimitiveArray(),
				v2 = g2.vertices().toPrimitiveArray();
			for (int i = 0; i < g1.order(); ++i)
			{
				Method me1 = m1.getIdMap().get(v1[i]).get(0);
				Method me2 = m2.getIdMap().get(v2[i]).get(0);
				
				System.out.println("VMATCH " + mname(me1) + " -> " + mname(me2));
			}
		}
	}
	
	private boolean compare(Frame f1, Frame f2)
	{
		Graph g1 = f1.getMethodCtx().getGraph(), g2 = f2.getMethodCtx().getGraph();
		
		IsomorphismTester isoTest = new /*Typed*/VF2IsomorphismTester();
		if (g1.size() != g2.size() || g1.order() != g2.order() || !isoTest.areIsomorphic(g1, g2))
		{
			System.out.println("IN " + mname(f1.getMethod()) + " -> " + mname(f2.getMethod()));
			compare(f1.getMethodCtx(), g1, f2.getMethodCtx(), g2);
			System.out.println("Not isomorphic " + g1.size() + " " + g2.size());
			return false;
		}
		
		Map<Integer, Integer> mapping = isoTest.findIsomorphism(g1, g2);
		Map<Integer, List<Method>> map1 = f1.getMethodCtx().getIdMap(), map2 = f2.getMethodCtx().getIdMap();
		
		for (Entry<Integer, Integer> e : mapping.entrySet())
		{
//			if (e.getKey() == null || e.getValue() == null)
//			{
//				assert e.getKey() == e.getValue();
//				continue;
//			}
			
			List<Method> i1 = map1.get(e.getKey());
			List<Method> i2 = map2.get(e.getValue());
			
			//assert i1.getClass() == i2.getClass();
			
			//InvokeInstruction ii1 = (InvokeInstruction) i1, ii2 = (InvokeInstruction) i2;
			
			//assert ii1.getMethods().size() == ii2.getMethods().size();
			
			assert i1.size() == i2.size();
			
			for (int i = 0; i < i1.size(); ++i)
			{
				Method m1 = i1.get(i), m2 = i2.get(i);
				
//				assert objMap.containsKey(m1) == false || objMap.get(m1) == m2;
				objMap.put(m1, m2);
			}
			
			System.out.println("MATCH " + i1.get(0).getName() + " -> " + i2.get(0).getName());
		}
		
		return true;
	}
	
	private void process(Method one, Method two)
	{
		Execution eone = new Execution(groupOne);
		eone.setBuildGraph(true);
		eone.setFollowInvokes(false);
		eone.addMethod(one);
		eone.run();
		
		Execution etwo = new Execution(groupTwo);
		etwo.setBuildGraph(true);
		etwo.setFollowInvokes(false);
		etwo.addMethod(two);
		etwo.run();
		
		// get frames for respective methods
		List<Frame> f1 = eone.processedFrames, f2 = etwo.processedFrames;
		
		f1 = f1.stream().filter(f -> f.getMethod() == one).collect(Collectors.toList());
		f2 = f2.stream().filter(f -> f.getMethod() == two).collect(Collectors.toList());
		
		//List<Frame> f1 = eone.processedFrames.stream().filter(f -> f.getMethod() == one).collect(Collectors.toList());
		//List<Frame> f2 = etwo.processedFrames.stream().filter(f -> f.getMethod() == two).collect(Collectors.toList());
		
		Frame p1 = null, p2 = null;
		outer:
		for (Frame fr1 : f1)
			for (Frame fr2 : f2)
			{
				if (p1 == null) p1 = fr1;
				if (p2 == null) p2 = fr2;
				
				assert fr1.getMethod() == one;
				assert fr2.getMethod() == two;
				
				assert fr1.getMethodCtx() == p1.getMethodCtx();
				assert fr2.getMethodCtx() == p2.getMethodCtx();
			}
		
		assert p1.getMethod() == one;
		assert p2.getMethod() == two;
		
		outer2:
		for (Frame fr1 : f1)
			for (Frame fr2 : f2)
			{
				boolean b = compare(fr1, fr2);
				if (!b)
				{
					System.out.println("Mismatch " + p1.getMethod().getMethods().getClassFile().getName() + "." +  p1.getMethod().getName() + " <-> " + p2.getMethod().getMethods().getClassFile().getName() + "." + p2.getMethod().getName());
					System.out.println(one.getMethods().getClassFile().getName() + "." + one.getName() + " and " + two.getMethods().getClassFile().getName() + "." + two.getName());
					int i =7;
				}
				break outer2;
			}
		
		System.out.println("end");
	}
	public void run(ClassGroup one, ClassGroup two)
	{
		groupOne = one;
		groupTwo = two;
		
//		Execution eone = new Execution(one);
//		eone.setBuildGraph(true);
//		eone.setFollowInvokes(false);
//		eone.populateInitialMethods();
//		List<Method> initial1 = eone.getInitialMethods().stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList());
//		eone.run();
//		
//		Execution etwo = new Execution(two);
//		etwo.setBuildGraph(true);
//		etwo.setFollowInvokes(false);
//		etwo.populateInitialMethods();
//		List<Method> initial2 = etwo.getInitialMethods().stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList());
//		etwo.run();
//		
//		assert initial1.size() == initial2.size();
//		
//		for (int i = 0; i < initial1.size(); ++i)
//		{
//			Method m1 = initial1.get(i), m2 = initial2.get(i);
//			
//			assert m1.getName().equals(m2.getName());
//			
//			objMap.put(m1, m2);
//		}

		process(
			one.findClass("client").findMethod("vmethod2999"),
			two.findClass("client").findMethod("vmethod2978")
		);
		
		for (;;)
		{
			Optional next = objMap.keySet().stream()
				.filter(m -> !processed.contains(m))
				.findAny();
			if (!next.isPresent())
				break;
			
			Method m = (Method) next.get();
			Method m2 = (Method) objMap.get(m);
			
			if (m.getCode() == null || m2.getCode() == null)
			{
				processed.add(m);
				continue;
			}
			
			System.out.println("Scanning " + m.getMethods().getClassFile().getName() + "." + m.getName() + " -> " + m2.getMethods().getClassFile().getName() + "." + m2.getName());
			process(m, m2);
			processed.add(m);
		}
		
		for (Entry<Object, Object> e : objMap.entrySet())
		{
			Method m1 = (Method) e.getKey();
			Method m2 = (Method) e.getValue();
			
			System.out.println("FINAL " + m1.getMethods().getClassFile().getName() + "." + m1.getName() + " -> " + m2.getMethods().getClassFile().getName() + "." + m2.getName());
		}

		System.out.println("done count " + objMap.size());
	}
}
