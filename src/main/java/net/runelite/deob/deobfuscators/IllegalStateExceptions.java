package net.runelite.deob.deobfuscators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;

public class IllegalStateExceptions implements Deobfuscator
{
	private int count;
	private Set<Instruction> interesting = new HashSet<>();
	private InstructionContext currentInstruction;

	/* find if, new, ..., athrow, replace with goto */
	private void findInteresting(ClassGroup group)
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods().getMethods())
			{
				Code c = m.getCode();
				if (c == null)
					continue;
				
				Instructions instructions = c.getInstructions();
				
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

					interesting.add(ins);
				}
			}
		}
	}

	private void visit(InstructionContext ic)
	{
		if (interesting.contains(ic.getInstruction()))
		{
			assert currentInstruction == null;
			currentInstruction = ic;
		}
	}

	private void visit(Frame f)
	{
		if (currentInstruction == null)
			return;

		processOne(currentInstruction);
		currentInstruction = null;
	}

	private void processOne(InstructionContext ic)
	{
		Instruction ins = ic.getInstruction();
		Instructions instructions = ins.getInstructions();
		List<Instruction> ilist = instructions.getInstructions();

		JumpingInstruction jumpIns = (JumpingInstruction) ins;
		assert jumpIns.getJumps().size() == 1;
		Instruction to = jumpIns.getJumps().get(0);

		// remove stack of if.
		if (ins instanceof If)
		{
			ic.removeStack(1);
		}
		ic.removeStack(0);

		int i = ilist.indexOf(ins);
		assert i != -1;

		// remove up to athrow
		while (!(ins instanceof AThrow))
		{
			// modify instructions which jump to here to instead jump to 'to'

			for (Instruction from : ilist)
			{
				from.replace(ins, to);
			}

			instructions.remove(ins);
			ins = ilist.get(i); // don't need to ++i because
		}

		// remove athrow
		instructions.remove(ins);

		// insert goto
		assert ilist.contains(to);
		Goto g = new Goto(instructions, to);
		ilist.add(i, g);

		++count;
	}
	
	@Override
	public void run(ClassGroup group)
	{	
		findInteresting(group);
		
		Execution execution = new Execution(group);
		execution.addExecutionVisitor(i -> visit(i));
		execution.addFrameVisitor(i -> visit(i));
		execution.populateInitialMethods();
		execution.run();

		assert currentInstruction == null;
		
		System.out.println("Removed " + count + " illegal state exceptions");
	}
}
