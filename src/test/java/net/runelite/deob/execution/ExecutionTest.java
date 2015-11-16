package net.runelite.deob.execution;

import java.io.File;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class ExecutionTest
{
	@Test
	public void test() throws Exception
	{
		ClassGroup group = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		
		System.out.println("Done loading jar " + System.currentTimeMillis() / 1000);
		
		Execution e = new Execution(group);
		//e.setBuildGraph(true);
		//e.setFollowInvokes(false);
		e.populateInitialMethods();
		e.run();
		
		System.out.println("Done exec " + System.currentTimeMillis() / 1000);
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("Total memory (MB) " + runtime.totalMemory()/1024L/1024L);
	}
}
