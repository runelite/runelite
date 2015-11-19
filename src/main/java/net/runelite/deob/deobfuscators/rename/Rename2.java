package net.runelite.deob.deobfuscators.rename;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.deobfuscators.rename.graph.Graph;
import net.runelite.deob.deobfuscators.rename.graph.Vertex;
import net.runelite.deob.deobfuscators.rename.graph.VertexType;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.signature.Signature;

public class Rename2
{
	private Graph g1, g2;
	
	private static String cname(Method m) { return m.getMethods().getClassFile().getName(); }
	private static String mname(Method m) { return cname(m) + "." + m.getName(); }
	private static String fname(Field f) { return f.getFields().getClassFile().getName() + "." + f.getName(); }
	
	public static void collide(Object o0, Object o1, Object o2)
	{
		assert o0.getClass() == o1.getClass();
		assert o1.getClass() == o2.getClass();
		
		if (o1 instanceof Method)
		{
			Method m1 = (Method) o1;
			Method m2 = (Method) o2;
			
			System.out.println("COLLISION " + mname(m1) + " -> " + mname(m2));
		}
		else if (o1 instanceof Field)
		{
			Field f0 = (Field) o0;
			Field f1 = (Field) o1;
			Field f2 = (Field) o2;
			
			System.out.println("COLLISION " + fname(f0) + ": " + fname(f1) + " -> " + fname(f2));
		}
		else
			assert false;
	}
	
	private Map<Signature, Method> find(ClassFile cf)
	{
		Map<Signature, Method> set = new HashMap();
		Set collided = new HashSet();
		for (Method m : cf.getMethods().getMethods())
		{
			if (m.isStatic())
				continue;
			
			Signature sig = m.getDescriptor();
			
			if (set.containsKey(sig) || collided.contains(sig))
			{
				collided.add(sig);
				set.remove(sig);
				continue;
			}
			set.put(sig, m);
		}
		return set;
	}
	
	void mapClassMethods(Map<Signature, Method> one, Map<Signature, Method> two)
	{
		if (!one.keySet().equals(two.keySet()))
			return;
	
		for (Signature sig : one.keySet())
		{
			Method m1 = one.get(sig);
			Method m2 = two.get(sig);
			
			Vertex v1 = g1.getVertexFor(m1);
			Vertex v2 = g2.getVertexFor(m2);
			
			v1.is(v2);
			v2.is(v1);
			
			System.out.println(mname(m1) + " is " + mname(m2));
		}
	}
	
	private void solve()
	{
		List<Vertex> solved = g1.getVerticies().stream().filter(v -> v.getOther() != null).collect(Collectors.toList());
		
		for (Vertex s : solved)
		{
			Vertex other = s.getOther();
			
			s.getEdges().stream()
				.map(e -> e.getTo()) // e.from is always s
				.filter(v -> v.getOther() == null) // only get vertexes that aren't solved yet
				.forEach(v ->
					v.merge(
						other.getEdges().stream()
							.map(e -> e.getTo())
							.filter(v2 -> v2.getOther() == null)
							.filter(v2 -> v.couldBeEqual(v2))
							.collect(Collectors.toList())
					)
				);
		}
	}
	
	public void run(ClassGroup one, ClassGroup two)
	{
		Execution eone = new Execution(one);
		eone.setBuildGraph(true);
		//eone.setFollowInvokes(false);
		eone.populateInitialMethods();
		eone.run();
		
		Execution etwo = new Execution(two);
		etwo.setBuildGraph(true);
		//etwo.setFollowInvokes(false);
		etwo.populateInitialMethods();
		etwo.run();
		
		g1 = eone.getGraph();
		g2 = etwo.getGraph();
		
		System.out.println(eone.getGraph());
		System.out.println(etwo.getGraph());
		
		for (int i = 0; i < Math.min(one.getClasses().size(), two.getClasses().size()); ++i)
		{
			Map m1 = this.find(one.getClasses().get(i));
			Map m2 = this.find(two.getClasses().get(i));
			
			mapClassMethods(m1, m2);
		}
		
		for (;;)
		{
			int before = g1.solved(null);
			System.out.println("Before " + before);
			solve();
			g1.getVerticies().forEach(v -> v.finish());
			int after = g1.solved(null);
			System.out.println("After " + after);
			
			if (before == after)
				break;
		}
		
		g1.check();g2.check();
		
		System.out.println("methods " +g1.solved(VertexType.METHOD));
		System.out.println("f " +g1.solved(VertexType.FIELD));
	}
}
