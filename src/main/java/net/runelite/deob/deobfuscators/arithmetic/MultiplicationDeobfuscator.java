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

public class MultiplicationDeobfuscator implements Deobfuscator
{
	private ClassGroup group;
	
	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
		
		int i;
		while ((i = runOnce()) > 0)
			System.out.println("Simplified " + i + " multiplication");
	}
	
	private int runOnce()
	{
		Execution e = new Execution(group);
		e.populateInitialMethods();
		e.run();
		
		int count = 0;
		
		for (Frame frame : e.processedFrames)
			for (InstructionContext ictx : frame.getInstructions())
			{
				if (!(ictx.getInstruction() instanceof IMul))
					continue;
					
				Instructions ins = ictx.getInstruction().getInstructions();
				List<Instruction> ilist = ins.getInstructions();

				if (!ilist.contains(ictx.getInstruction()))
					continue; // already done
				
				StackContext one = ictx.getPops().get(0);
				StackContext two = ictx.getPops().get(1);
				
				if (one.getPushed().getInstruction() instanceof PushConstantInstruction
					&& two.getPushed().getInstruction() instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci1 = (PushConstantInstruction) one.getPushed().getInstruction(),
						pci2 = (PushConstantInstruction) two.getPushed().getInstruction();
					
					int i1 = (int) pci1.getConstant().getObject(),
						i2 = (int) pci2.getConstant().getObject();
					
					int result = i1 * i2;
					
					ictx.removeStack(1);
					ictx.removeStack(0);
					
					ins.replace(ictx.getInstruction(), new LDC_W(ins, new net.runelite.deob.pool.Integer(result)));
					++count;
				}
			}
		
		return count;
	}

}
