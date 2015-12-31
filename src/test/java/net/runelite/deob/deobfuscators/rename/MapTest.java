package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.MappableInstruction;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.ParallellMappingExecutor;
import net.runelite.deob.util.JarUtil;
import org.junit.Assert;
import org.junit.Test;

public class MapTest
{
	@Test
	public void testMappable() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		Assert.assertTrue(MappingExecutorUtil.isMappable(
			group1.findClass("class99").findMethod("method2220"),
			group2.findClass("class99").findMethod("method2149")
		));
	}
	
	@Test
	public void main() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		Method m1 = group1.findClass("class99").findMethod("method2220");
		Method m2 = group2.findClass("class99").findMethod("method2149");
		
		ParallelExecutorMapping mappings = MappingExecutorUtil.map(m1, m2);
	}
}
