package net.runelite.deob.deobfuscators.rename;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.MappableInstruction;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.util.JarUtil;
import org.junit.Test;

public class MapTest
{
	@Test
	public void main() throws IOException
	{
		ClassGroup group1 = JarUtil.loadJar(new File("d:/rs/07/adamin1.jar"));
		ClassGroup group2 = JarUtil.loadJar(new File("d:/rs/07/adamin2.jar"));
		
		Method m1 = group1.findClass("class99").findMethod("method2220");
		Execution e = new Execution(group1);
		Frame frame = new Frame(e, m1);
		frame.initialize();
		e.frames.add(frame);
		
		Method m2 = group2.findClass("class99").findMethod("method2149");
		Execution e2 = new Execution(group2);
		Frame frame2 = new Frame(e2, m2);
		frame2.initialize();
		e2.frames.add(frame2);
		
		frame.other = frame2;
		frame2.other = frame;
		
		List<Instruction> l1 = m1.getCode().getInstructions().getInstructions().stream().filter(i -> i instanceof MappableInstruction).collect(Collectors.toList());
		List<Instruction> l2 = m2.getCode().getInstructions().getInstructions().stream().filter(i -> i instanceof MappableInstruction).collect(Collectors.toList());
		
		while (!e.frames.isEmpty())
		{
			assert e.frames.size() == e2.frames.size();
			Frame f1 = e.frames.get(0), f2 = e2.frames.get(0);
			
			assert f1.other == f2;
			assert f2.other == f1;
			
			assert f1.isExecuting() == f2.isExecuting();
			
			// on if it is duped then jumped,
			if (!f1.isExecuting())
			{
				assert e.frames.get(0) == f1;
				assert e2.frames.get(0) == f2;
				
				e.frames.remove(0);
				e2.frames.remove(0);
				continue;
			}
			
			// step frame
			f1.execute();
			f2.execute();
			
			// get what each frame is paused/exited on
			InstructionContext p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
			InstructionContext p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);
			
			if (!f1.isExecuting() || !f2.isExecuting())
			{
				for (Frame branch : p1.getBranches())
				{
					e.frames.remove(branch);
				}
				for (Frame branch : p2.getBranches())
				{
					e2.frames.remove(branch);
				}
				
			//	System.out.println("Something exited " + f1 + " " + f2);
				
				assert e.frames.get(0) == f1;
				assert e2.frames.get(0) == f2;
				
				e.frames.remove(0);
				e2.frames.remove(0);
				continue;
			}
			
			// frames can stop executing if they've determined that they've executed
			// the ins before, and it won't necessarily be at the same time?
			
			assert e.paused;
			assert e2.paused;
			
			//System.out.println(p1.getInstruction() + " <-> " + p2.getInstruction());
			
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
