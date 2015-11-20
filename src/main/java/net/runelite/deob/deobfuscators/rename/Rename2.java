package net.runelite.deob.deobfuscators.rename;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.deobfuscators.rename.graph.Graph;
import net.runelite.deob.deobfuscators.rename.graph.Vertex;
import net.runelite.deob.deobfuscators.rename.graph.VertexType;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.signature.Signature;
import net.runelite.deob.util.NameMappings;

public class Rename2
{
	private Graph g1, g2;
	
	private static String cname(Method m) { return m.getMethods().getClassFile().getName(); }
	public static String mname(Method m) { return cname(m) + "." + m.getName(); }
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
	
	private List<Field> getClientFields(ClassGroup group, Execution e)
	{
		Method clinit = group.findClass("client").findMethod("<clinit>");
		Frame frame = e.processedFrames.stream().filter(f -> f.getMethod() == clinit).findFirst().get();
		
		List<Field> fields = new ArrayList<>();
		for (InstructionContext i : frame.getInstructions())
		{
			if (i.getInstruction() instanceof SetFieldInstruction)
			{
				SetFieldInstruction sfi = (SetFieldInstruction) i.getInstruction();
				Field f = sfi.getMyField();
				
				if (f != null)
					fields.add(f);
			}
		}
		
		return fields;
	}
	
	private void solve()
	{
		List<Vertex> solved = g1.getVerticies().stream().filter(v -> v.getOther() != null).collect(Collectors.toList());
		
		for (Vertex s : solved)
		{
			Vertex other = s.getOther();
			
			s.getEdges().stream()
				.filter(e -> e.getTo().getOther() == null) // only get vertexes that aren't solved yet
				.forEach(e ->
					e.getTo().merge(
						other.getEdges().stream()
							.filter(e2 -> e2.getTo().getOther() == null)
							.filter(e2 -> e.getTo().couldBeEqual(e2.getTo()))
							.filter(e2 -> e.couldBeEqual(e2))
							.map(e2 -> e2.getTo())
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
		
		List<Field> fl1 = getClientFields(one, eone);
		List<Field> fl2 = getClientFields(two, etwo);
		
		for (int i = 0; i < Math.min(fl1.size(), fl2.size()); ++i)
		{
			Field f1 = fl1.get(i), f2 = fl2.get(i);
			
			Vertex v1 = g1.getVertexFor(f1);
			Vertex v2 = g2.getVertexFor(f2);
			
			v1.is(v2);
			v2.is(v1);
			
			System.out.println(fname(f1) + " is " + fname(f2));
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
		
		g1.check();
		g2.check();
		
		System.out.println("methods " +g1.solved(VertexType.METHOD));
		System.out.println("f " +g1.solved(VertexType.FIELD));
		
		NameMappings mappings = rename(one, two); // two -> one
		
	//	show(mappings);
	}
	
	private void show(NameMappings mappings)
	{
		for (Entry<Object, String> e : mappings.getMap().entrySet())
		{
			Object o = e.getKey();
			String n = e.getValue();
			
			if (o instanceof net.runelite.deob.pool.Method)
			{
				net.runelite.deob.pool.Method m = (net.runelite.deob.pool.Method) o;
				System.out.println("FINAL " + n + " -> " + m.getNameAndType().getName());
			}
			else if (o instanceof net.runelite.deob.pool.Field)
			{
				net.runelite.deob.pool.Field f = (net.runelite.deob.pool.Field) o;
				System.out.println("FINAL " + n + " -> " + f.getNameAndType().getName());
			}
		}
	}
	
	private NameMappings rename(ClassGroup one, ClassGroup two)
	{
		NameMappings mappings = new NameMappings();
		
		for (ClassFile cf : two.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Vertex v = g2.getVertexFor(m);
				Vertex other = v.getOther();
				
				if (other == null)
					continue;
				
				Method m2 = (Method) other.getObject();
				mappings.map(m.getPoolMethod(), m2.getName());
			}
			
			for (Field f : cf.getFields().getFields())
			{
				Vertex v = g2.getVertexFor(f);
				Vertex other = v.getOther();
				
				if (other == null)
					continue;
				
				Field f2 = (Field) other.getObject();
				mappings.map(f.getPoolField(), f2.getName());
			}
		}
		
		return mappings;
	}
}
