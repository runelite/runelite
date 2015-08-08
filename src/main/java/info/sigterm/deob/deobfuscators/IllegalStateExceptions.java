package info.sigterm.deob.deobfuscators;

import java.util.List;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Deobfuscator;
import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.ComparisonInstruction;
import info.sigterm.deob.attributes.code.instruction.types.JumpingInstruction;
import info.sigterm.deob.attributes.code.instructions.AThrow;
import info.sigterm.deob.attributes.code.instructions.Goto;
import info.sigterm.deob.attributes.code.instructions.If;
import info.sigterm.deob.attributes.code.instructions.If0;
import info.sigterm.deob.attributes.code.instructions.New;
import info.sigterm.deob.execution.Execution;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;

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
					info.sigterm.deob.pool.Class clazz = new2.getNewClass();
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
						System.out.println("Unable to locate instruction ctx to remove stack for illegalstateexception " + ins + " in " + m);
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
