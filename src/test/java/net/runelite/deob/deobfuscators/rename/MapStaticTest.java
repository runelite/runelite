package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
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
	
	//@Test
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
		
		Method m1 = group1.findClass("class107").findMethod("method2427");
		Method m2 = group2.findClass("class107").findMethod("method2344");
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
	}
	
	//@Test
	public void test2() throws Exception
	{
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		List<ClassFile> cl1 = group1.getClasses(),
		cl2 = group2.getClasses();
		
		for (int i = 0; i < 200; ++i)
		{
			ClassFile c1 = cl1.get(i), c2 = cl2.get(i);
			System.out.println(c1 + " <-> " + c2);
		}
		//Assert.assertEquals(cl1.size(), cl2.size());
		
		Method m1 = group1.findClass("class66").findMethod("vmethod3787");
		Method m2 = group2.findClass("class66").findMethod("vmethod3664");
		
		List<Method> list = new ArrayList<>();
		findMethodFromClass(m1.getPoolMethod(), list, group1.findClass("class66"));
		
		System.out.println("break");
		
		List<Method> list2 = new ArrayList<>();
		findMethodFromClass(m2.getPoolMethod(), list2, group2.findClass("class66"));
		
		Assert.assertEquals(list.size(), list2.size());
		
		for (int i = 0; i < list.size(); ++i)
		{
			m1 = list.get(i);
			m2 = list2.get(i);
			
			System.out.println(m1 + " vs " + m2);

			Assert.assertEquals(m1.getMethods().getClassFile().getName(), m2.getMethods().getClassFile().getName());
		}
	}
	
	private void findMethodFromClass(net.runelite.deob.pool.Method method, List<Method> list, ClassFile clazz)
	{
		net.runelite.deob.Method m = clazz.findMethodDeep(method.getNameAndType());
		if (m != null && !list.contains(m))
			list.add(m);
	
		for (ClassFile cf : clazz.getChildren())
		{
			System.out.println("Child of " + clazz + ": " +cf);
			findMethodFromClass(method, list, cf);
		}
	}
}
