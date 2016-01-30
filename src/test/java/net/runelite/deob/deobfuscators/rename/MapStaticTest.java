package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
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
import net.runelite.deob.Deob;
import net.runelite.deob.Method;
import net.runelite.deob.util.JarUtil;
import org.junit.Assert;
import org.junit.Test;

public class MapStaticTest
{
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
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
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
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
	
		Method m1 = group1.findClass("class183").findMethod("method3685");
		Method m2 = group2.findClass("class183").findMethod("method3560");
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
		
		System.out.println("BEGIN OF MAPPING");
		for (Entry<Object, Object> e : mappings.getMap().entrySet())
		{
			System.out.println(e.getKey() + " <-> " + e.getValue());
		}
	}
	
	private static boolean test;
	
	@Test
	public void testDeep() throws IOException
	{
		//test = true;
		
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		Method m1 = group1.findClass("class183").findMethod("method3685");
		Method m2 = group2.findClass("class183").findMethod("method3560");
		
		HashMap<Object, Object> all = new HashMap();
		map(all, new HashSet(), m1, m2);
	}
	
	@Test
	public void testAllDeep() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		for (String[] s : methods)
		{
			String[] one = s[0].split("\\."), two = s[1].split("\\.");
			
			Method m1 = group1.findClass(one[0]).findMethod(one[1]);
			Method m2 = group2.findClass(two[0]).findMethod(two[1]);
		
			HashMap<Object, Object> all = new HashMap();
			map(all, new HashSet(), m1, m2);
		}
	}
	
	@Test
	public void testAllMap() throws Exception
	{
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		List<Method> m1s = getInitialMethods(group1), m2s = getInitialMethods(group2);
		//Method m1 = group1.findClass("client").findMethod("init");
		//Method m2 = group2.findClass("client").findMethod("init");
		
		assert m1s.size() == m2s.size();
		
		HashMap<Object, Object> all = new HashMap();
		for (int i = 0; i < m1s.size(); ++i)
		{
			Method m1 = m1s.get(i), m2 = m2s.get(i);
			
			assert m1.getPoolMethod().equals(m2.getPoolMethod());
			
			map(all, new HashSet(), m1, m2);

			for (Entry<Object, Object> e : all.entrySet())
			{
				System.out.println(e.getKey() + " <-> " + e.getValue());
			}
		}
		System.out.println("Total " + all.size());
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
	
	private void map(Map<Object, Object> all, Set<Object> invalid, Method m1, Method m2)
	{
		if (all.containsKey(m1))
			return;
		all.put(m1, m2);
		
		assert (m1.getCode() == null) == (m2.getCode() == null);
		
		if (m1.getCode() == null)
			return;
		
		ParallelExecutorMapping mappings;
		try
		{
			mappings = MappingExecutorUtil.map(m1, m2);
		}
		catch (Throwable ex)
		{
			System.err.println("Error mapping " + m1 + " to " + m2);
			if (test)
				throw ex;
			return;
		}
		
		for (Entry<Object, Object> e : mappings.getMap().entrySet())
		{
			if (e.getKey() instanceof Method)
			{
				Method n1 = (Method) e.getKey(),
					n2 = (Method) e.getValue();
				
				map(all, invalid, n1, n2);
			}
			else
				all.put(e.getKey(), e.getValue());
			//assert all
			//all.put(e.getKey(), e.getValue());
		}
	}
}
