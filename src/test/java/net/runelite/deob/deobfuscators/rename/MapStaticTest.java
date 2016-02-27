package net.runelite.deob.deobfuscators.rename;

import com.google.common.collect.Multimap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deob;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Annotations;
import net.runelite.deob.attributes.AttributeType;
import net.runelite.deob.attributes.annotation.Annotation;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instructions.If;
import net.runelite.deob.attributes.code.instructions.IfICmpEq;
import net.runelite.deob.attributes.code.instructions.IfICmpNe;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.ParallellMappingExecutor;
import net.runelite.deob.signature.Type;
import net.runelite.deob.util.JarUtil;
import org.junit.Assert;
import org.junit.Test;

public class MapStaticTest
{
	private static final String JAR1 = MapStaticTest.class.getResource("/adamin1.jar").getFile(),
		JAR2 = MapStaticTest.class.getResource("/adamin2.jar").getFile();
	
	private static final String methods[][] = {
		{ "client.vmethod3054", "client.vmethod2973" },
		{ "class99.method2220", "class99.method2149" },
		{ "class146.vmethod3158", "class146.vmethod3070" },
		{ "class166.method3315", "class166.method3254" },
		{ "class167.method3406", "class167.method3296" },
		{ "client.method585", "class44.method930" },
		{ "class222.method4086", "class222.method3957" },
		{ "class40.method851", "class40.method803" },
		{ "class55.method1187", "class55.method1140" },
		{ "class107.method2427", "class107.method2344" },
		{ "client.init", "client.init" },
		{ "class162.method3270", "class86.method2020" },
		{ "class29.method711", "class36.method742" },
		{ "class72.run", "class72.run" },
		{ "class64.vmethod3787", "class64.vmethod3664" },
		{ "class207.method3965", "class207.method3846" },
		{ "class183.method3685", "class183.method3560" },
	};
	
//	@Test
//	public void testMappable() throws IOException
//	{
//		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
//		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
//		
//		for (String[] s : methods)
//		{
//			String[] one = s[0].split("\\."), two = s[1].split("\\.");
//			
//			Method m1 = group1.findClass(one[0]).findMethod(one[1]);
//			Method m2 = group2.findClass(two[0]).findMethod(two[1]);
//			
//			Assert.assertTrue(MappingExecutorUtil.isMappable(
//				m1, m2
//			));
//		}
//	}
	
	@Test
	public void testAll() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		for (String[] s : methods)
		{
			String[] one = s[0].split("\\."), two = s[1].split("\\.");
			
			Method m1 = group1.findClass(one[0]).findMethod(one[1]);
			Method m2 = group2.findClass(two[0]).findMethod(two[1]);
		
			ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
		}
	}
	
	@Test
	public void test() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
	
		Method m1 = group1.findClass("class6").findMethod("method112");
		Method m2 = group2.findClass("class20").findMethod("method551");
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
		
		System.out.println("BEGIN OF MAPPING");
		for (Object o : mappings.getMap().keySet())
		{
			Object value = mappings.get(o);
			System.out.println(o + " <-> " + value);
		}
		System.out.println("END OF MAPPINGS " + mappings.getMap().size() + " " + mappings.crashed);
		
		// I think because this is an array store
		//Object other = mappings.get(group1.findClass("class136").findField("field2098"));
		//Assert.assertNotNull(other);
	}
	
	private static boolean test = true;
	
	@Test
	public void testDeep() throws IOException
	{
		//test = true;
		
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		Method m1 = group1.findClass("client").findMethod("method585");
		Method m2 = group2.findClass("class44").findMethod("method930");
		
		HashMap<Object, Object> all = new HashMap();
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		map(all, pmes, m1, m2);
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(group1, group2);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);
		
		System.out.println("BEGIN OF MAPPING");
		for (Object o : finalm.getMap().keySet())
		{
			Object value = finalm.get(o);
			System.out.println(o + " <-> " + value);
		}
		System.out.println("END OF MAPPINGS " + finalm.getMap().size());
	}
	
	//@Test
	public void testAllDeep() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		for (String[] s : methods)
		{
			String[] one = s[0].split("\\."), two = s[1].split("\\.");
			
			Method m1 = group1.findClass(one[0]).findMethod(one[1]);
			Method m2 = group2.findClass(two[0]).findMethod(two[1]);
		
			HashMap<Object, Object> all = new HashMap();
			map(all, pmes, m1, m2);
		}
	}
	
	private void summary(ParallelExecutorMapping finalm, ClassGroup in)
	{
		int fields = 0, staticMethod = 0, method = 0, total = 0;
		for (Entry<Object, Object> e : finalm.getMap().entrySet())
		{
			//System.out.println(e.getKey() + " <-> " + e.getValue());

			Object o = e.getKey();
			if (o instanceof Field)
			{
				++fields;
				
				Field f = (Field) o;
				assert f.getFields().getClassFile().getGroup() == in;
			}
			else if (o instanceof Method)
			{
				Method m = (Method) o;
				assert m.getMethods().getClassFile().getGroup() == in;

				if (m.isStatic())
					++staticMethod;
				else
					++method;
			}

			++total;
		}
		System.out.println("Total " + total + ". " + fields + " fields, " + staticMethod + " static methods, " + method + " methods");
	}
	
	@Test
	public void testAllMap() throws Exception
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		List<Method> m1s = getInitialMethods(group1), m2s = getInitialMethods(group2);
		//Method m1 = group1.findClass("client").findMethod("init");
		//Method m2 = group2.findClass("client").findMethod("init");
		
		assert m1s.size() == m2s.size();
		
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
//		for (int i = 0; i < m1s.size(); ++i)
//		{
//			Method m1 = m1s.get(i), m2 = m2s.get(i);
//			
//			assert m1.getPoolMethod().equals(m2.getPoolMethod());
//		
//			HashMap<Object, Object> all = new HashMap();
//			map(all, pmes, m1, m2);/fil
//		}
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(group1, group2);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);
		
				
		finalm.merge(testStaticMapperMap(group1, group2));
		finalm.merge(testMapperMap(group1, group2));
		finalm.merge(this.testPackets(group1, group2));

		for (int i = -1; i < 250; ++i)
		{
			ClassFile c1;
			
			if (i == -1)
			{
				c1 = group1.findClass("client");
			}
			else
			{
				c1 = group1.findClass("class" + i);
			}
			
			if (c1 == null)
				continue;
			
			for (Method m : c1.getMethods().getMethods())
			{
				if (!finalm.getMap().containsKey(m))
					System.out.println("missing " + m);
			}
			for (Field m : c1.getFields().getFields())
			{
				if (!finalm.getMap().containsKey(m))
					System.out.println("missing " + m);
			}
		}
		
		summary(finalm, group1);
		
		String sg1 = print(group1),
			sg2 = print(group2);
		
		System.out.println("GROUP 1 " + sg1);
		System.out.println("GROUP 2 " + sg2);
	}
	
	//@Test
	public ParallelExecutorMapping testMapperMap(ClassGroup one, ClassGroup two) throws IOException
	{
//		ClassGroup one = JarUtil.loadJar(new File(JAR1));
//		ClassGroup two = JarUtil.loadJar(new File(JAR2));
		
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		for (int i = -1; i < 250; ++i)
		{
			ClassFile c1, c2;
			
			if (i == -1)
			{
				c1 = one.findClass("client");
				c2 = two.findClass("client");
			}
			else
			{
				c1 = one.findClass("class" + i);
				c2 = two.findClass("class" + i);
			}
			
			if (c1 == null || c2 == null)
				continue;
			
			MethodSignatureMapper msm = new MethodSignatureMapper();
			msm.map(c1, c2);
			
			Multimap<Method, Method> map = msm.getMap();
			for (Method m : map.keySet())
			{
				Collection<Method> methods = map.get(m);
				
				for (Method other : methods)
				{
					HashMap<Object, Object> all = new HashMap();
					map(all, pmes, m, other);
//					ParallelExecutorMapping pme = MappingExecutorUtil.map(m, other);
//					
//					if (pme.getMap().isEmpty())
//						continue;
//					
//					pme.map(m, other);
//				
//					pmes.add(pme);
				}
				//HashMap<Object, Object> all = new HashMap();
				//map(all, pmes, e.getKey(), e.getValue());
			}
		}
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(one, two);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;		
//		summary(finalm);
//		print(one);
	}
	
	//@Test
	public ParallelExecutorMapping testStaticMapperMap(ClassGroup one, ClassGroup two) throws IOException
	{
//		ClassGroup one = JarUtil.loadJar(new File(JAR1));
//		ClassGroup two = JarUtil.loadJar(new File(JAR2));
		
		StaticMethodSignatureMapper smsm = new StaticMethodSignatureMapper();
		smsm.map(one, two);
		
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		
		for (Method m : smsm.getMap().keySet())
		{
			Collection<Method> methods = smsm.getMap().get(m);
			
			//if (methods.size() >= 1)
			{
				for (Method other : methods)
				{
					HashMap<Object, Object> all = new HashMap();
					map(all, pmes, m, other);
					
//					ParallelExecutorMapping pme = MappingExecutorUtil.map(m, other);
//					
//					if (pme.getMap().isEmpty())
//						continue;
//				
//					pme.map(m, other);
//				
//					pmes.add(pme);
				}
			}
		}
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(one, two);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);

		return finalm;		
//		summary(finalm);
//		print(one);
	}
	
	public List<Method> getInitialMethods(ClassGroup group)
	{
		List<Method> methods = new ArrayList<>();
		
		group.buildClassGraph(); // required when looking up methods
		group.lookup(); // lookup methods
		
		for (ClassFile cf : group.getClasses())
		{
			List<Method> cmethods = new ArrayList<>();
			
			for (Method m : cf.getMethods().getMethods())
			{
				if (!Deob.isObfuscated(m.getName()) && !m.getName().startsWith("<"))
				{
					if (m.getCode() == null)
					{
						methods.add(m);
						continue;
					}
					
					cmethods.add(m); // I guess this method name is overriding a jre interface (init, run, ?).
				}
			}
			
			// cmethods are scrambled randomally, so sort by name
			cmethods = cmethods.stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList());
			
			methods.addAll(cmethods);
		}
		
		return methods;
	}
	
	private void map(Map<Object, Object> all, List<ParallelExecutorMapping> result, Method m1, Method m2)
	{
		if (all.containsKey(m1))
			return;
		all.put(m1, m2);
		
		assert (m1.getCode() == null) == (m2.getCode() == null);
		
		if (m1.getCode() == null)
			return;
		
		// XXX this is the packet stuff..
//		if (m1.getName().equals("vmethod3096"))
//			return;
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
		
		if (mappings.getMap().isEmpty() && mappings.crashed)
			return;
		
		mappings.map(m1, m2);
		result.add(mappings);
		
		for (Entry<Object, Object> e : mappings.getMap().entrySet())
		{
			if (e.getKey() instanceof Method)
			{
				Method n1 = (Method) e.getKey(),
					n2 = (Method) e.getValue();
				
				map(all, result, n1, n2);
			}
			else
				all.put(e.getKey(), e.getValue());
			//assert all
			//all.put(e.getKey(), e.getValue());
		}
	}
	
	private String print(ClassGroup cg)
	{
		int methods = 0, fields = 0, classes = 0;
		for (ClassFile cf : cg.getClasses())
		{
			++classes;
			methods += cf.getMethods().getMethods().size();
			fields += cf.getFields().getFields().size();
		}
		int total = methods + fields;
		return "total methods/fields: " + total + ", " + methods + " methods, " + fields + " fields";
	}
	
	@Test
	public void printTotalObjects() throws Exception
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		//print(group1);
	}
	
	@Test
	public void testCore() throws Exception
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		Rename rename = new Rename(group1, group2);
		rename.run();
		
		ParallelExecutorMapping mapping = rename.getMapping();

		mapping.merge(this.testPackets(group1, group2));
		
		summary(rename.getMapping(), group1);
		
		String sg1 = print(group1),
			sg2 = print(group2);
		
		System.out.println("GROUP 1 " + sg1);
		System.out.println("GROUP 2 " + sg2);
		
		List<Field> exported = getExportedFields(group1);
		int mapped = 0, not = 0;
		for (Field f : exported)
		{
			Field other = (Field) mapping.get(f);
			if (other == null)
				System.out.println("missing " + f + " " + other);
			if (other != null) ++mapped;
			else ++not;
		}
		System.out.println("Mapped " + mapped + " total " + (mapped+not));
		
	}
	
	private static final Type OBFUSCATED_NAME = new Type("Lnet/runelite/mapping/ObfuscatedName;");
	private static final Type EXPORT = new Type("Lnet/runelite/mapping/Export;");
	private static final Type IMPLEMENTS = new Type("Lnet/runelite/mapping/Implements;");
	
	private List<Field> getExportedFields(ClassGroup group)
	{
		List<Field> list = new ArrayList<>();
		for (ClassFile cf : group.getClasses())
		{
			for (Field f : cf.getFields().getFields())
			{
				Annotations an = (Annotations) f.getAttributes().findType(AttributeType.RUNTIMEVISIBLEANNOTATIONS);
				if (an == null)
					continue;
				for (Annotation a : an.getAnnotations())
				{
					if (a.getType().equals(EXPORT))
					{
						list.add(f);
					}
				}
			}
		}
		return list;
	}

	@Test
	public void testPackets() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		testPackets(group1, group2);
	}
	
	//@Test
	public ParallelExecutorMapping testPackets(ClassGroup group1, ClassGroup group2) throws IOException
	{
		//ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		//ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		
		group1.findClass("client").findField("field446").packetHandler = true;
		group2.findClass("client").findField("field324").packetHandler = true;
	
		Method m1 = group1.findClass("client").findMethod("vmethod3096");
		Method m2 = group2.findClass("client").findMethod("vmethod2975");
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
		
		System.out.println("BEGIN OF MAPPING");
		for (Object o : mappings.getMap().keySet())
		{
			Object value = mappings.get(o);
			System.out.println(o + " <-> " + value);
		}
		System.out.println("END OF MAPPINGS " + mappings.getMap().size());
		
		System.out.println(mappings.packetHandler1.size() + " vs " + mappings.packetHandler2.size() + " handlers");

		assert mappings.packetHandler1.size() == mappings.packetHandler2.size();

		ParallellMappingExecutor.enable = true;
		ParallelExecutorMapping all = new ParallelExecutorMapping(group1, group2);

		for (int i = 0; i < mappings.packetHandler1.size(); ++i)
		{
			PacketHandler if1 = mappings.packetHandler1.get(i);

			PacketHandler highestHandler = null;
			ParallelExecutorMapping highest = null;
			
			for (int j = 0; j < mappings.packetHandler2.size(); ++j)
			{
				PacketHandler if2 = mappings.packetHandler2.get(j);

				Instruction i1 = if1.getFirstInsOfHandler(),
					i2 = if2.getFirstInsOfHandler();

				ParallelExecutorMapping mapping = MappingExecutorUtil.mapFrame(group1, group2, i1, i2);

				if (mapping.getMap().isEmpty())
					continue;

				if (highest == null || mapping.getMap().size() > highest.getMap().size())
				{
					highest = mapping;
					highestHandler = if2;
				}


//				Execution e1 = new Execution(group1);
//				Execution e2 = new Execution(group2);
//
//				Frame f1 = new Frame(e1, i1.getInstructions().getCode().getAttributes().getMethod(), i1);
//				Frame f2 = new Frame(e2, i2.getInstructions().getCode().getAttributes().getMethod(), i2);

				//e1.frames.add(f1);
				//e2.frames.add(f2);
			}

			System.out.println(if1 + " <-> " + highestHandler + " <-> " + highest.getMap().size() + " " + highest.crashed);
			all.merge(highest);
		}

		ParallellMappingExecutor.enable = false;
		return all;
	}

	private static int handlers[][] = {
		{ 74, 187 }
	};

	@Test
	public void testPacket() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));

		group1.findClass("client").findField("field446").packetHandler = true;
		group2.findClass("client").findField("field324").packetHandler = true;

		Method m1 = group1.findClass("client").findMethod("vmethod3096");
		Method m2 = group2.findClass("client").findMethod("vmethod2975");

		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);

		//                       var55 = class17.method214(); vs var107 = class25.field625[++class25.field624 - 1];
		PacketHandler h1 = mappings.findPacketHandler1(127);
		PacketHandler h2 = mappings.findPacketHandler2(160);

		ParallelExecutorMapping mapping = MappingExecutorUtil.mapFrame(group1, group2, h1.getFirstInsOfHandler(), h2.getFirstInsOfHandler());

		System.out.println(h1 + " <-> " + h2 + " <-> " + mapping.getMap().size() + " " + mapping.crashed);
	}
}
