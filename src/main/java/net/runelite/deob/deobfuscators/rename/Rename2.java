package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.deob.deobfuscators.Renamer;
import net.runelite.deob.deobfuscators.rename.graph.Edge;
import net.runelite.deob.deobfuscators.rename.graph.Graph;
import net.runelite.deob.deobfuscators.rename.graph.Vertex;
import net.runelite.deob.deobfuscators.rename.graph.VertexType;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.signature.Signature;
import net.runelite.deob.util.JarUtil;
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
			Method m0 = (Method) o0;
			Method m1 = (Method) o1;
			Method m2 = (Method) o2;
			
			System.out.println("COLLISION on " + mname(m0) + ": " + mname(m1) + " -> " + mname(m2));
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
	
	private void mapClassMethods(Map<Signature, Method> one, Map<Signature, Method> two)
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
	
	private void mapDeobfuscatedMethods(ClassFile cf1, ClassFile cf2)
	{
		List<Method> m1 = cf1.getMethods().getMethods().stream().filter(m -> !Deob.isObfuscated(m.getName())).collect(Collectors.toList()),
			m2 = cf2.getMethods().getMethods().stream().filter(m -> !Deob.isObfuscated(m.getName())).collect(Collectors.toList());
		
		for (Method m : m1)
		{
			Optional<Method> opt = m2.stream().filter(m2m -> m.getName().equals(m2m.getName()) && m.getDescriptor().equals(m2m.getDescriptor())).findAny();
			if (!opt.isPresent())
				continue;
			
			Vertex v1 = g1.getVertexFor(m);
			Vertex v2 = g2.getVertexFor(opt.get());
			
			v1.is(v2);
			v2.is(v1);
			
			System.out.println(mname(m) + " is " + mname(opt.get()));
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
			
			assert s.getGraph() != other.getGraph();
			
			for (Edge e : s.getEdges())
			{
				assert e.getFrom() == s;
				
				if (e.getTo().getOther() != null)
					continue; // skip solved edges

				Vertex v = e.getTo(); // end of edge in g1
				
				boolean b = false;
				if (s.toString().equals("Vertex{object=class0.<init>()V}") &&
				v.toString().equals("Vertex{object=class207.<init>()V}"))
				{
					b = true;
				}
				
				List<Vertex> l = new ArrayList<>();
				for (Edge e2 : other.getEdges())
				{
					if (e2.getTo().getOther() != null)
						continue; // skip solved edges
					
					if (!e.getTo().couldBeEqual(e2.getTo()))
					{
						System.out.println(e.getTo() + " != " + e2.getTo());
						continue;
					}
					
					if (!e.couldBeEqual(e2))
					{
						System.out.println(e + " != " + e2);
						continue;
					}
					
					Vertex v2 = e2.getTo();
					
					l.add(v2);
				}
				
				v.merge(l);
			}
		}
	}
	
	public NameMappings run(ClassGroup one, ClassGroup two)
	{
		Execution eone = new Execution(one);
		eone.setBuildGraph(true);
		eone.populateInitialMethods();
		eone.run();
		
		Execution etwo = new Execution(two);
		etwo.setBuildGraph(true);
		etwo.populateInitialMethods();
		etwo.run();
		
		g1 = eone.getGraph();
		g2 = etwo.getGraph();
		
		System.out.println(eone.getGraph());
		System.out.println(etwo.getGraph());
		
		for (int i = 0; i < 250; ++i)
		{
			ClassFile c1 = one.findClass("class" + i);
			ClassFile c2 = two.findClass("class" + i);
			
			if (c1 == null || c2 == null)
				continue;
			
			//Map m1 = this.find(c1);
			//Map m2 = this.find(c2);
			
		//	mapClassMethods(m1, m2);
			
			mapDeobfuscatedMethods(c1, c2);
		}
		
		ClassFile cf1 = one.findClass("client"), cf2 = two.findClass("client");
		mapDeobfuscatedMethods(cf1, cf2);
		
//		List<Field> fl1 = getClientFields(one, eone);
//		List<Field> fl2 = getClientFields(two, etwo);
//		
//		for (int i = 0; i < Math.min(fl1.size(), fl2.size()); ++i)
//		{
//			Field f1 = fl1.get(i), f2 = fl2.get(i);
//			
//			Vertex v1 = g1.getVertexFor(f1);
//			Vertex v2 = g2.getVertexFor(f2);
//			
//			v1.is(v2);
//			v2.is(v1);
//			
//			System.out.println(fname(f1) + " is " + fname(f2));
//		}
		
		System.out.println("g1 verticies " + g1.getVerticies().size() + " reachable " + g1.reachableVerticiesFromSolvedVerticies().size());
		Set<Vertex> reachable = g1.reachableVerticiesFromSolvedVerticies();
		for (Vertex v : g1.getVerticies())
			if (!reachable.contains(v))
			{
				System.out.println("unreachable " + v);
			}
		
		for (;;)
		{
			int before = g1.solved(null);
			System.out.println("Before " + before);
			
			solve();
			
			g1.getVerticies().forEach(v -> v.finish());
			//g2
			
			int after = g1.solved(null);
			System.out.println("After " + after);
			
			if (before == after)
				break;
		}
		
		g1.check();
		g2.check();
		
		System.out.println("methods " +g1.solved(VertexType.METHOD));
		System.out.println("f " +g1.solved(VertexType.FIELD));
		
		Vertex stored = null;
		for (Vertex v : g1.getVerticies())
		{
			if (v.getOther() == null)
				continue;
			
			if (!v.toString().equals("Vertex{object=class0.<init>()V}"))
				continue;
			
			assert stored == null;
			stored = v;
			
			for (Edge e : v.getEdges())
			{
				if (e.getTo().getOther() == null)
				{
					System.out.println("Edge " + e + " on vertex " + v + " is unsolved");
				}
			}
		}
		
//		NameMappings col = buildCollisionMap(one, two);
//		rename(col, two);
//		
//		NameMappings mappings = buildMappings(one, two); // two -> one
//		
//		show(mappings);
		
		System.out.println("Solved methods "+ g1.solved(VertexType.METHOD) + ", solved fields " + g1.solved(VertexType.FIELD) + ", total " + g1.getVerticies().size());
		
		//rename(mappings, two);
		
		try
		{
			JarUtil.saveJar(two, new File("/Users/adam/w/rs/07/adamout.jar"));
		}
		catch (IOException ex)
		{
			Logger.getLogger(Rename2.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return null;
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
		
		System.out.println("Mappins size " + mappings.getMap().size());
	}
	
	private NameMappings buildCollisionMap(ClassGroup one, ClassGroup two)
	{
		NameMappings mappings = new NameMappings();
		int count = 0;
		
		for (ClassFile cf : two.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (m.isStatic() && !m.getName().equals("<clinit>"))
					continue;
				
				Vertex v = g2.getVertexFor(m);
				Vertex other = v.getOther();
				
				if (m.getName().equals("<init>") || m.getName().equals("<clinit>"))
					continue;
				
				if (other == null)
					continue;
				
				Method m2 = (Method) other.getObject();
				
				if (m.getName().equals(m2.getName()))
					continue; // already correct
				
				Method existingMethod = cf.findMethod(m2.getName());
				if (existingMethod != null)
				{
					mappings.map(existingMethod.getPoolMethod(), "collidedMethod" + count++);
				}
			}
			
//			for (Field f : cf.getFields().getFields())
//			{
//				Vertex v = g2.getVertexFor(f);
//				Vertex other = v.getOther();
//				
//				if (other == null)
//					continue;
//				
//				Field f2 = (Field) other.getObject();
//				
//				Field existingField = cf.findField(f2.getName());
//				if (existingField != null)
//					mappings.map(existingField.getPoolField(), "collidedField" + count++);
//			}
		}
		
		return mappings;
	}
	
	private NameMappings buildMappings(ClassGroup one, ClassGroup two)
	{
		NameMappings mappings = new NameMappings();
		
		for (ClassFile cf : two.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (m.isStatic() && !m.getName().equals("<clinit>"))
					continue;
				
				Vertex v = g2.getVertexFor(m);
				Vertex other = v.getOther();
				
				if (m.getName().equals("<init>") || m.getName().equals("<clinit>"))
					continue;
				
				if (other == null)
					continue;
				
				Method m2 = (Method) other.getObject();
				
				if (!m.getName().equals(m2.getName()))
				{
					Method existingMethod = cf.findMethod(m2.getName());
					assert existingMethod == null;
				}
				
				mappings.map(m.getPoolMethod(), m2.getName());
			}
			
//			for (Field f : cf.getFields().getFields())
//			{
//				Vertex v = g2.getVertexFor(f);
//				Vertex other = v.getOther();
//				
//				if (other == null)
//					continue;
//				
//				Field f2 = (Field) other.getObject();
//				
//				Field existingField = cf.findField(f2.getName());
//				assert existingField == null;
//				
//				mappings.map(f.getPoolField(), f2.getName());
//			}
		}
		
		return mappings;
	}
	
	private void rename(NameMappings mappings, ClassGroup group)
	{
		Renamer renamer = new Renamer(mappings);
		renamer.run(group);
	}
}
