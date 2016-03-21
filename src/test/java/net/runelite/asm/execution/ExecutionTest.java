package net.runelite.asm.execution;

import net.runelite.asm.execution.Execution;
import java.io.File;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.deobfuscators.rename.MapStaticTest;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class ExecutionTest
{
	private static final String JAR1 = MapStaticTest.class.getResource("/adamin1.jar").getFile(),
		JAR2 = MapStaticTest.class.getResource("/adamin2.jar").getFile();
	
	@Test
	public void test() throws Exception
	{
		ClassGroup group1 = JarUtil.loadJar(new File(JAR1));
		Execution e = new Execution(group1);
		e.populateInitialMethods();
		e.run();
	}
	
	@Test
	public void test2() throws Exception
	{
		ClassGroup group2 = JarUtil.loadJar(new File(JAR2));
		Execution e = new Execution(group2);
		e.populateInitialMethods();
		e.run();
	}
}
