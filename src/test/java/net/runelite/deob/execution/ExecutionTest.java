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
		
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
	}
}
