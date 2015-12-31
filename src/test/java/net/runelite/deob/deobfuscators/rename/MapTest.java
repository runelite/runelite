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
	public boolean isMappable(Method m1, Method m2)
	{
		// must have same number of each type
		// invokes
		
		List<Instruction> l1 = m1.getCode().getInstructions().getInstructions().stream().filter(i -> i instanceof MappableInstruction).collect(Collectors.toList());
		List<Instruction> l2 = m2.getCode().getInstructions().getInstructions().stream().filter(i -> i instanceof MappableInstruction).collect(Collectors.toList());
		
		if (l1.size() != l2.size())
			return false;
		
		Map<Class, Integer> map1 = new HashMap<>(),
			map2 = new HashMap<>();
		
		for (int i = 0; i < l1.size(); ++i)
		{
			Instruction i1 = l1.get(i);
			
			Integer c = map1.get(i1.getClass());
			if (c == null)
				map1.put(i1.getClass(), 1);
			else
				map1.put(i1.getClass(), c + 1);
		}
		
		for (int i = 0; i < l2.size(); ++i)
		{
			Instruction i2 = l2.get(i);
			
			Integer c = map2.get(i2.getClass());
			if (c == null)
				map2.put(i2.getClass(), 1);
			else
				map2.put(i2.getClass(), c + 1);
		}
		
		return true;
	}
	
	//@Test
	public void testMappable() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		Assert.assertTrue(isMappable(
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
		Execution e = new Execution(group1);
		e.step = true;
		Frame frame = new Frame(e, m1);
		frame.initialize();
		e.frames.add(frame);
		
		Method m2 = group2.findClass("class99").findMethod("method2149");
		Execution e2 = new Execution(group2);
		e2.step = true;
		Frame frame2 = new Frame(e2, m2);
		frame2.initialize();
		e2.frames.add(frame2);
		
		frame.other = frame2;
		frame2.other = frame;
		
		ParallellMappingExecutor parallel = new ParallellMappingExecutor(e, e2);
		
		while (parallel.step())
		{
			// get what each frame is paused/exited on
			InstructionContext p1 = parallel.getP1(), p2 = parallel.getP2();
			
			assert e.paused;
			assert e2.paused;
			
			System.out.println(p1.getInstruction() + " <-> " + p2.getInstruction());
			
			assert p1.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m1;
			assert p2.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m2;

			assert p1.getInstruction() instanceof MappableInstruction;
			assert p2.getInstruction() instanceof MappableInstruction;
			
			assert p1.getInstruction().getClass().equals(p2.getInstruction().getClass());

			MappableInstruction mi1 = (MappableInstruction) p1.getInstruction();

			mi1.map(p1, p2);

			e.paused = e2.paused = false;
		}
	}
}
