package net.runelite.deob.deobfuscators.rename;

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
import net.runelite.deob.execution.ParallellMappingExecutor;
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
	
		Method m1 = group1.findClass("class92").findMethod("method2176");
		Method m2 = group2.findClass("client").findMethod("method540");
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
		
		System.out.println("BEGIN OF MAPPING");
		for (Object o : mappings.getMap().keySet())
		{
			Object value = mappings.get(o);
			System.out.println(o + " <-> " + value);
		}
		System.out.println("END OF MAPPINGS " + mappings.getMap().size());
		
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
		
		Method m1 = group1.findClass("class92").findMethod("method2176");
		Method m2 = group2.findClass("client").findMethod("method540");
		
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
			System.out.println(e.getKey() + " <-> " + e.getValue());

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
		for (int i = 0; i < m1s.size(); ++i)
		{
			Method m1 = m1s.get(i), m2 = m2s.get(i);
			
			assert m1.getPoolMethod().equals(m2.getPoolMethod());
		
			HashMap<Object, Object> all = new HashMap();
			map(all, pmes, m1, m2);
		}
		
		for (int i = 0; i < 250; ++i)
		{
			ClassFile c1 = group1.findClass("class" + i);
			ClassFile c2 = group2.findClass("class" + i);
			
			if (c1 == null || c2 == null)
				continue;
			
			MethodSignatureMapper msm = new MethodSignatureMapper();
			msm.map(c1, c2);
			
			Map<Method, Method> map = msm.getMap();
			for (Entry<Method, Method> e : map.entrySet())
			{
				HashMap<Object, Object> all = new HashMap();
				map(all, pmes, e.getKey(), e.getValue());
			}
		}
		
		ParallelExecutorMapping finalm = new ParallelExecutorMapping(group1, group2);
		for (ParallelExecutorMapping pme : pmes)
			finalm.merge(pme);
		
				
		finalm.merge(testStaticMapperMap(group1, group2));
		finalm.merge(testMapperMap(group1, group2));
		
		summary(finalm, group1);
		
		String sg1 = print(group1),
			sg2 = print(group2);
		
		System.out.println("GROUP 1 " + sg1);
		System.out.println("GROUP 2 " + sg2);

		
		for (Method m : group1.findClass("client").getMethods().getMethods())
		{
			if (!finalm.getMap().containsKey(m))
				System.out.println("missing " + m);
		}
		for (Field m : group1.findClass("client").getFields().getFields())
		{
			if (!finalm.getMap().containsKey(m))
				System.out.println("missing " + m);
		}
	}
	
	//@Test
	public ParallelExecutorMapping testMapperMap(ClassGroup one, ClassGroup two) throws IOException
	{
//		ClassGroup one = JarUtil.loadJar(new File(JAR1));
//		ClassGroup two = JarUtil.loadJar(new File(JAR2));
		
		List<ParallelExecutorMapping> pmes = new ArrayList<>();
		for (int i = 0; i < 250; ++i)
		{
			ClassFile c1 = one.findClass("class" + i);
			ClassFile c2 = two.findClass("class" + i);
			
			if (c1 == null || c2 == null)
				continue;
			
			MethodSignatureMapper msm = new MethodSignatureMapper();
			msm.map(c1, c2);
			
			Map<Method, Method> map = msm.getMap();
			for (Entry<Method, Method> e : map.entrySet())
			{
				HashMap<Object, Object> all = new HashMap();
				map(all, pmes, e.getKey(), e.getValue());
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
					ParallelExecutorMapping pme = MappingExecutorUtil.map(m, other);
					
					if (pme.getMap().isEmpty())
						continue;
				
//					HashMap<Object, Object> all = new HashMap();
//					map(all, pmes, m, other);
					pme.map(m, other);
				
					pmes.add(pme);
					//System.out.println(m + " " + other + " " + pme.getMap().size());
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
		if (m1.getName().equals("vmethod3096"))
			return;
		
		if (m1.getName().equals("method32"))
		{
			int i=5;
		}
		
		ParallelExecutorMapping
//		try
//		{
			mappings = MappingExecutorUtil.map(m1, m2);
//		}
//		catch (Throwable ex)
//		{
//			ex.printStackTrace();
//			System.err.println("Error mapping " + m1 + " to " + m2);
//			//if (test)
//			//	throw ex;
//			return;
//		}
		
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
		//ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		//print(group1);
	}
}
