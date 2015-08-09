package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Execution;
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
		//for (Instruction i : new ArrayList<>(ins.getInstructions()))
		{
			Instruction i = insCopy.get(j);
			
			if (!execution.executed.contains(i))
			{
				for (Instruction i2 : i.from)
					i2.jump.remove(i);
				i.from.clear(); // if this is never executed, anything that jumps here ia also never executed?
				
				// if this is an exception handler, the exception handler is never used...
				for (info.sigterm.deob.attributes.code.Exception e : new ArrayList<>(m.getCode().getExceptions().getExceptions()))
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
