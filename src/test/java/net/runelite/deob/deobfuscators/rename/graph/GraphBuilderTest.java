package net.runelite.deob.deobfuscators.rename.graph;

import java.io.File;
import java.io.IOException;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;


public class GraphBuilderTest
{
	@Test
	public void test() throws IOException
	{
		ClassGroup group = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		GraphBuilder.build(group);
	}
}
