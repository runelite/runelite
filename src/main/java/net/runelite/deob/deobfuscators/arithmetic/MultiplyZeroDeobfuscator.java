package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.LDC2_W;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;

public class MultiplyZeroDeobfuscator implements Deobfuscator
{
	private int count;
	private List<InstructionContext> pending = new ArrayList<>();
	
	private void visit(InstructionContext ictx)
	{
		Instruction instruction = ictx.getInstruction();
		Instructions ins = instruction.getInstructions();
		if (ins == null)
		{
			return;
		}

		if (!(instruction instanceof IMul) && !(instruction instanceof LMul))
		{
			return;
		}

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
			{
				remove = true;
			}
		}
		if (itwo instanceof PushConstantInstruction)
		{
			PushConstantInstruction pci = (PushConstantInstruction) itwo;
			Number value = (Number) pci.getConstant().getObject();

			if (DMath.equals(value, 0))
			{
				remove = true;
			}
		}

		if (remove == false)
		{
			return;
		}

		if (!ilist.contains(instruction))
		{
			return; // already done
		}
		
		pending.add(ictx);

		++count;
	}
	
	private void visit(Frame frame)
	{
		for (InstructionContext ictx : pending)
		{
			Instruction instruction = ictx.getInstruction();
			Instructions ins = instruction.getInstructions();
			
			if (!MultiplicationDeobfuscator.isOnlyPath(ictx, null))
			{
				continue;
			}
			
			// remove both, remove imul, push 0
			ictx.removeStack(1);
			ictx.removeStack(0);

			if (instruction instanceof IMul)
			{
				ins.replace(instruction, new LDC_W(ins, new net.runelite.asm.pool.Integer(0)));
			}
			else if (instruction instanceof LMul)
			{
				ins.replace(instruction, new LDC2_W(ins, 0L));
			}
			else
			{
				throw new IllegalStateException();
			}
		}
		pending.clear();
	}
	
	@Override
	public void run(ClassGroup group)
	{
		Execution e = new Execution(group);
		e.addExecutionVisitor(i -> visit(i));
		e.addFrameVisitor(v -> visit(v));
		e.populateInitialMethods();
		e.run();
		
		System.out.println("Removed " + count + " 0 multiplications");
	}
}
