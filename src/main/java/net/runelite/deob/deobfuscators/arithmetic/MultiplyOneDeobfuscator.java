package net.runelite.deob.deobfuscators.arithmetic;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.attributes.code.instructions.IMul;
import net.runelite.deob.attributes.code.instructions.NOP;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.StackContext;

public class MultiplyOneDeobfuscator implements Deobfuscator
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
				
				if (!(instruction instanceof IMul))
					continue;
				
				Instructions ins = ictx.getInstruction().getInstructions();
				if (ins == null)
					continue;
				
				List<Instruction> ilist = ins.getInstructions();

				if (!ilist.contains(ictx.getInstruction()))
					continue; // already done
				
				StackContext one = ictx.getPops().get(0);
				StackContext two = ictx.getPops().get(1);
				
				int removeIdx = -1;
				if (one.getPushed().getInstruction() instanceof PushConstantInstruction
					&& (int) ((PushConstantInstruction) one.getPushed().getInstruction()).getConstant().getObject() == 1)
				{
					removeIdx = 0;
				}
				else if (two.getPushed().getInstruction() instanceof PushConstantInstruction
					&& (int) ((PushConstantInstruction) two.getPushed().getInstruction()).getConstant().getObject() == 1)
				{
					removeIdx = 1;
				}
				
				if (removeIdx == -1)
					continue;
				
				if (!MultiplicationDeobfuscator.isOnlyPath(e, ictx, removeIdx == 0 ? one : two))
					continue;
				
				ictx.removeStack(removeIdx);
				ins.replace(ictx.getInstruction(), new NOP(ins));
				//ins.remove(ictx.getInstruction());
				
				++count;
			}
		
		System.out.println("Removed " + count + " 1 multiplications");
	}

}
