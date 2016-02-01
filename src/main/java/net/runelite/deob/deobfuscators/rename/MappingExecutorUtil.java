package net.runelite.deob.deobfuscators.rename;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.attributes.code.instruction.types.MappableInstruction;
import net.runelite.deob.attributes.code.instructions.InvokeStatic;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.ParallellMappingExecutor;

public class MappingExecutorUtil
{
	// won't work with static funcs etc. this is all wrong. XXX
	public static boolean isMappable(Method m1, Method m2)
	{
		assert (m1.getCode() == null) == (m2.getCode() == null);
		
		if (m1.getCode() == null || m2.getCode() == null)
			return false;
		
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
		
		return map1.equals(map2);
	}
	
	public static ParallelExecutorMapping map(Method m1, Method m2)
	{
		ClassGroup group1 = m1.getMethods().getClassFile().getGroup();
		ClassGroup group2 = m2.getMethods().getClassFile().getGroup();

		Execution e = new Execution(group1);
		e.step = true;
		Frame frame = new Frame(e, m1);
		frame.initialize();
		e.frames.add(frame);

		Execution e2 = new Execution(group2);
		e2.step = true;
		Frame frame2 = new Frame(e2, m2);
		frame2.initialize();
		e2.frames.add(frame2);
		
		frame.other = frame2;
		frame2.other = frame;
		
		ParallellMappingExecutor parallel = new ParallellMappingExecutor(e, e2);
		ParallelExecutorMapping mappings = new ParallelExecutorMapping();
		
		while (parallel.step())
		{
			assert e.frames.size() == e2.frames.size();
			
			// get what each frame is paused/exited on
			InstructionContext p1 = parallel.getP1(), p2 = parallel.getP2();
			
			assert e.paused;
			assert e2.paused;
			
			System.out.println(p1.getInstruction() + " <-> " + p2.getInstruction());
			
			//assert p1.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m1;
			//assert p2.getInstruction().getInstructions().getCode().getAttributes().getMethod() == m2;

			assert p1.getInstruction() instanceof MappableInstruction;
			assert p2.getInstruction() instanceof MappableInstruction;
			
			MappableInstruction mi1 = (MappableInstruction) p1.getInstruction(),
				mi2 = (MappableInstruction) p2.getInstruction();
			
			if (!mi1.isSame(p1, p2))
			{
				assert mi1.isSame(p1, p2);
			}
			//assert p1.getInstruction().getClass().equals(p2.getInstruction().getClass());

			mi1.map(mappings, p1, p2);

			assert e.frames.size() == e2.frames.size();
			e.paused = e2.paused = false;
		}
		
		return mappings;
	}
	
	public static boolean isMappable(InvokeInstruction ii)
	{
		net.runelite.deob.pool.Method m = (net.runelite.deob.pool.Method) ii.getMethod();
		String className = m.getClassEntry().getName();
		
		if (className.startsWith("java/") || className.startsWith("netscape/"))
			return false;
		
		return true;
	}
	
	public static boolean isInlineable(Instruction i)
	{
		return i instanceof InvokeStatic && isMappable((InvokeStatic) i);
	}
}
