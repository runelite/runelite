package net.runelite.deob.deobfuscators;

import java.util.List;

import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.Code;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.deob.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.deob.attributes.code.instructions.AThrow;
import net.runelite.deob.attributes.code.instructions.Goto;
import net.runelite.deob.attributes.code.instructions.If;
import net.runelite.deob.attributes.code.instructions.If0;
import net.runelite.deob.attributes.code.instructions.New;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;

public class IllegalStateExceptions implements Deobfuscator
{
	/* find if, new, ..., athrow, replace with goto */
	private int checkOnce(Execution execution, ClassGroup group)
	{
		int count = 0;
		
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				assert execution.methods.contains(m);
				
				Instructions instructions = c.getInstructions();
				instructions.clearBlockGraph();
				
				List<Instruction> ilist = instructions.getInstructions();
				for (int i = 0; i < ilist.size(); ++i)
				{
					Instruction ins = ilist.get(i);
					
					if (!(ins instanceof ComparisonInstruction))
						continue;
					
					Instruction ins2 = ilist.get(i + 1);
					if (!(ins2 instanceof New))
						continue;
					
					New new2 = (New) ins2;
					net.runelite.deob.pool.Class clazz = new2.getNewClass();
					if (!clazz.getName().equals("java/lang/IllegalStateException"))
						continue;
					
					JumpingInstruction jumpIns = (JumpingInstruction) ins;
					assert jumpIns.getJumps().size() == 1;
					Instruction to = jumpIns.getJumps().get(0);
					
					// remove stack of if.
					boolean found = false;
					for (Frame f : execution.processedFrames)
						if (f.getMethod() == m)
						{
							for (InstructionContext ic : f.getInstructions())
								if (ic.getInstruction() == ins) // this is the if
								{
									found = true;
									
									if (ins instanceof If)
										ic.removeStack(1);
									ic.removeStack(0);
								}
						}
					if (!found)
					{
						System.out.println("Unable to locate instruction ctx to remove stack for illegalstateexception " + ins.getType().getName() + " in method " + m.getName() + " class " + m.getMethods().getClassFile().getName());
						continue;
					}
					
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
	
	@Override
	public void run(ClassGroup group)
	{
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
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
