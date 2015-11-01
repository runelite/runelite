package net.runelite.deob.deobfuscators.arithmetic;

import java.util.List;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.LDC2_W;
import net.runelite.deob.attributes.code.instructions.LDC_W;
import net.runelite.deob.attributes.code.instructions.LMul;
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
				if (ins == null)
					continue;
				
				if (!(instruction instanceof IMul) && !(instruction instanceof LMul))
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
					Number value = (Number) pci.getConstant().getObject();
					
					if (DMath.equals(value, 0))
						remove = true;
				}
				if (itwo instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) itwo;
					Number value = (Number) pci.getConstant().getObject();
					
					if (DMath.equals(value, 0))
						remove = true;
				}
				
				if (remove == false)
				{
					continue;
				}
				
				if (!ilist.contains(instruction))
					continue; // already done
				
				if (!MultiplicationDeobfuscator.isOnlyPath(e, ictx))
					continue;
				
				// remove both, remove imul, push 0
				
				ictx.removeStack(1);
				ictx.removeStack(0);
				
				if (instruction instanceof IMul)
					ins.replace(instruction, new LDC_W(ins, new net.runelite.deob.pool.Integer(0)));
				else if (instruction instanceof LMul)
					ins.replace(instruction, new LDC2_W(ins, 0L));
				else
					throw new IllegalStateException();
				
				++count;
			}
		
		System.out.println("Removed " + count + " 0 multiplications");
	}
}
