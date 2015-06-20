package info.sigterm.deob.deobfuscators;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instructions.AThrow;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.If;
import info.sigterm.deob.attributes.code.instructions.If0;
import info.sigterm.deob.attributes.code.instructions.New;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IllegalStateExceptions
{
	/* find if, new, ..., athrow, replace with goto */
	private int checkOnce(Execution execution, ClassGroup group)
	{
		int count = 0;
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : new ArrayList<>(cf.getMethods().getMethods()))
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				Instructions instructions = c.getInstructions();
				instructions.clearBlockGraph();
				
				List<Instruction> ilist = instructions.getInstructions();
				for (int i = 0; i < ilist.size(); ++i)
				{
					Instruction ins = ilist.get(i);
					
					if (!(ins instanceof If) && !(ins instanceof If0))
						continue;
					
					Instruction ins2 = ilist.get(i + 1);
					if (!(ins2 instanceof New))
						continue;
					
					New new2 = (New) ins2;
					info.sigterm.deob.pool.Class clazz = new2.getNewClass();
					if (!clazz.getName().equals("java/lang/IllegalStateException"))
						continue;
					
					Instruction to = null;
					if (ins instanceof If)
						to = ((If) ins).getTo();
					else if (ins instanceof If0)
						to = ((If0) ins).getTo();
					
					// remove stack of if.
					boolean found = false;
					for (Frame f : execution.processedFrames)
						if (f.getMethod() == m)
							for (InstructionContext ic : f.getInstructions())
								if (ic.getInstruction() == ins) // this is the if
								{
									found = true;
									
									if (ins instanceof If)
										ic.removeStack(1);
									ic.removeStack(0);
								}
					assert found;
					
					// instruction is no longer at 'i' because we've just removed stuff...
					i = ilist.indexOf(ins);
					
					// remove up to athrow
					while (!(ins instanceof AThrow))
					{
						// modify instructions which jump to here to instead jump to 'to'
						
						for (Instruction from : ins.from)
						{
							from.jump.remove(ins);
							//ins.from.remove(from);
							
							from.replace(ins, to);
							
							from.jump.add(to);
						}
						ins.from.clear();
						
						instructions.remove(ins);
						ins = ilist.get(i); // don't need to ++i because 
					}
					
					// remove athrow
					instructions.remove(ins);
					
					// insert goto
					ilist.add(i, new Goto(instructions, to));
					
					++count;
					break;
				}
			}
		}
		return count;
	}
	
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.run();
		
		int count = 0;
		int passes = 0;
		int i;
		do
		{
			i = checkOnce(execution, group);
		
			count += i;
			++passes;
		}
		while (i > 0);
		
		System.out.println("Removed " + count + " illegal state exceptions in " + passes + " passes");
	}
}
