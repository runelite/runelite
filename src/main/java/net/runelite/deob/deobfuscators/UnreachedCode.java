package net.runelite.deob.deobfuscators;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Execution;
import java.util.ArrayList;
import java.util.List;

public class UnreachedCode implements Deobfuscator
{
	private Execution execution;
	
	private int removeUnused(Method m)
	{
		Instructions ins = m.getCode().getInstructions();
		
		int count = 0;
		List<Instruction> insCopy = new ArrayList<>(ins.getInstructions());
		
		for (int j = 0; j < insCopy.size(); ++j)
		{
			Instruction i = insCopy.get(j);
			
			if (!execution.executed.contains(i))
			{
				for (Instruction i2 : i.from)
					i2.jump.remove(i);
				i.from.clear(); // if this is never executed, anything that jumps here ia also never executed?
				
				// if this is an exception handler, the exception handler is never used...
				for (net.runelite.asm.attributes.code.Exception e : new ArrayList<>(m.getCode().getExceptions().getExceptions()))
				{
					if (e.getStart() == i)
					{
						e.setStart(insCopy.get(j + 1));
						
						if (e.getStart() == e.getEnd())
						{
							m.getCode().getExceptions().remove(e);
							continue;
						}
					}
					if (e.getHandler() == i)
					{
						m.getCode().getExceptions().remove(e);
					}
				}
				
				ins.remove(i);
				++count;
			}
		}
		return count;
	}
	
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		
		execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
		
		int count = 0;
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				if (m.getCode() == null)
					continue;
				
				count += removeUnused(m);
			}
		}
		
		System.out.println("Removed " + count + " unused instructions");
	}
}
