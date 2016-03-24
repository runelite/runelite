package net.runelite.deob.deobfuscators;

import java.util.Collection;
import java.util.List;

import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instructions.AThrow;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.New;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;

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
				
				//assert execution.methods.contains(m);
				
				Instructions instructions = c.getInstructions();
				instructions.buildJumpGraph();
				
				List<Instruction> ilist = instructions.getInstructions();
				for (int i = 0; i < ilist.size(); ++i)
				{
					Instruction ins = ilist.get(i);
					
					if (!(ins instanceof ComparisonInstruction)) // the if
						continue;
					
					Instruction ins2 = ilist.get(i + 1);
					if (!(ins2 instanceof New))
						continue;
					
					New new2 = (New) ins2;
					net.runelite.asm.pool.Class clazz = new2.getNewClass();
					if (!clazz.getName().equals("java/lang/IllegalStateException"))
						continue;
					
					JumpingInstruction jumpIns = (JumpingInstruction) ins;
					assert jumpIns.getJumps().size() == 1;
					Instruction to = jumpIns.getJumps().get(0);
					
					// remove stack of if.
					Collection<InstructionContext> ics = execution.getInstructonContexts(ins);
					if (ics == null)
						continue; // never executed

					boolean found = false;
					for (InstructionContext ic : ics)
					{
						found = true;

						if (ins instanceof If)
							ic.removeStack(1);
						ic.removeStack(0);
						break;
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
					assert ilist.contains(to);
					Goto g = new Goto(instructions, to);
					g.jump.add(to);
					to.from.add(g);
					ilist.add(i, g);
					
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
		group.buildClassGraph();
		
		Execution execution = new Execution(group);
		execution.populateInitialMethods();
		execution.run();
			
		int count = 0;
		int passes = 0;
		int i;
		do
		{		
			i = checkOnce(execution, group);
			
			System.out.println("ise removal pass " + passes + " removed " + i);
		
			count += i;
			++passes;
		}
		while (i > 0);
		
		System.out.println("Removed " + count + " illegal state exceptions in " + passes + " passes");
	}
}
