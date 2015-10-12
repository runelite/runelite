package net.runelite.deob.deobfuscators.arithmetic;

import java.util.List;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class MultiplyZeroDeobfuscator implements Deobfuscator
{
	@Override
	public void run(ClassGroup group)
	{
		group.buildClassGraph();
		
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
		
		int count = 0;
		
		for (Frame frame : e.processedFrames)
			for (InstructionContext ictx : frame.getInstructions())
			{
				Instruction instruction = ictx.getInstruction();
				Instructions ins = instruction.getInstructions();
				
				if (!(instruction instanceof IMul))
					continue;
				
				List<Instruction> ilist = ins.getInstructions();
				
				StackContext one = ictx.getPops().get(0);
				StackContext two = ictx.getPops().get(1);
				
				Instruction ione = one.getPushed().getInstruction(),
					itwo = two.getPushed().getInstruction();
				
				boolean remove = false;
				if (ione instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) ione;
					int value = (int) pci.getConstant().getObject();
					
					if (value == 0)
						remove = true;
				}
				if (itwo instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) itwo;
					int value = (int) pci.getConstant().getObject();
					
					if (value == 0)
						remove = true;
				}
				
				if (remove == false)
				{
					continue;
				}
				
				if (!ilist.contains(instruction))
					continue; // already done
				
				// remove both, remove imul, push 0
				
				ictx.removeStack(1);
				ictx.removeStack(0);
				
				ins.replace(instruction, new LDC_W(ins, new net.runelite.deob.pool.Integer(0)));
				
				++count;
			}
		
		System.out.println("Removed " + count + " 0 multiplications");
	}
}
