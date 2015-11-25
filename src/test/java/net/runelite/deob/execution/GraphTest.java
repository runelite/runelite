package net.runelite.deob.execution;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Method;
import net.runelite.deob.deobfuscators.rename.InstructionList;
import net.runelite.deob.deobfuscators.rename.Rename2;
import net.runelite.deob.deobfuscators.rename.graph.Graph;
import net.runelite.deob.deobfuscators.rename.graph.Vertex;
import net.runelite.deob.util.NameMappings;
import org.junit.Assert;
import org.junit.Test;

class TestClass2
{
	int array[];
	int count;
	
	void method1()
	{
		array[++count - 1] = 1;
		array[++count - 1] = 2;
	}
	
	void method2()
	{
		array[++count - 1] = 1;
		array[++count - 1] = 2;
		array[++count - 1] = 3;
		array[++count - 1] = 4;
	}
}

public class GraphTest
{
	private ClassGroup loadClassGroup(String name) throws IOException
	{
		ClassGroup group = new ClassGroup();

		ClassFile cf = this.loadClass(name);
		group.addClass(cf);
		
		return group;
	}
	
	private ClassFile loadClass(String name) throws IOException
	{
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("net/runelite/deob/execution/" + name + ".class");
		Assert.assertNotNull(in);
		
		ClassGroup group = new ClassGroup();
		ClassFile cf = new ClassFile(group, new DataInputStream(in));
		group.addClass(cf);
		return cf;
	}
	
	//@Test
	public void test() throws IOException
	{
		ClassGroup group1 = this.loadClassGroup("TestClass"), group2 = this.loadClassGroup("TestClass");

		Execution e = new Execution(group1);
		e.setBuildGraph(true);
		e.populateInitialMethods();
		e.run();
		
		Execution e2 = new Execution(group2);
		e2.setBuildGraph(true);
		e2.populateInitialMethods();
		e2.run();
		
		Graph graph = e.getGraph();
		Graph graph2 = e2.getGraph();
		
		Assert.assertEquals(4, graph.getVerticies().size());
		
		Method m = group1.getClasses().get(0).findMethod("init");
		Vertex v = graph.getVertexFor(m);
		
		Assert.assertEquals(1, v.getEdges().size());
		
		m = group1.getClasses().get(0).findMethod("method2");
		v = graph.getVertexFor(m);
		
		Assert.assertEquals(1, v.getEdges().size());
	}
	
	@Test
	public void test2() throws IOException
	{
		ClassGroup group1 = this.loadClassGroup("one/TestClass"), group2 = this.loadClassGroup("two/TestClass");
		Rename2 rename2 = new Rename2();
		NameMappings mappings = rename2.run(group1, group2); // 2->1
		
		ClassFile cf1 = group1.getClasses().get(0),
			cf2 = group2.getClasses().get(0);
		
		Method m2 = cf2.findMethod("init");
		Assert.assertTrue(mappings.get(m2.getPoolMethod()).equals("init"));
		
		m2 = cf2.findMethod("method6");
		String to = mappings.get(m2.getPoolMethod());
		Assert.assertNotNull(to);
		Assert.assertTrue(to.equals("method2"));
	}
	
	//@Test
	public void testVertexEquals() throws IOException
	{
		ClassGroup group1 = this.loadClassGroup("one/TestClass"), group2 = this.loadClassGroup("two/TestClass");
		
		ClassFile cf1 = group1.getClasses().get(0),
			cf2 = group2.getClasses().get(0);
		
		Graph g1 = new Graph(), g2 = new Graph();
		
		Vertex v1 = new Vertex(g1, cf2.findMethod("method6")),
			v2 = new Vertex(g2, cf1.findMethod("method2"));
		
		Assert.assertTrue(v1.couldBeEqual(v2));
	}
	
	//@Test
	public void test3() throws IOException
	{
		ClassFile cf1 = this.loadClass("TestClass2"), cf2 = this.loadClass("TestClass2");
		
		Method m1 = cf1.findMethod("method1"), m2 = cf2.findMethod("method2");
		
		InstructionList il1 = new InstructionList(m1.getCode().getInstructions().getInstructions()),
			il2 = new InstructionList(m2.getCode().getInstructions().getInstructions());
		
		Assert.assertFalse(il1.couldBeEqual(il2));
	}
}
