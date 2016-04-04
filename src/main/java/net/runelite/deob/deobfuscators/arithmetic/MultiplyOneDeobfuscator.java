package net.runelite.deob.deobfuscators.arithmetic;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.ClassGroup;
import net.runelite.deob.Deobfuscator;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.NOP;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.StackContext;

class MPair
{
	int removeIdx;
	InstructionContext ctx;

	public MPair(int removeIdx, InstructionContext ctx)
	{
		this.removeIdx = removeIdx;
		this.ctx = ctx;
	}
}

public class MultiplyOneDeobfuscator implements Deobfuscator
{
	private int count;
	private List<MPair> pairs = new ArrayList<>();

	private void visit(InstructionContext ictx)
	{
		Instruction instruction = ictx.getInstruction();

		if (!(instruction instanceof IMul) && !(instruction instanceof LMul))
		{
			return;
		}

		Instructions ins = ictx.getInstruction().getInstructions();
		if (ins == null)
		{
			return;
		}

		List<Instruction> ilist = ins.getInstructions();

		if (!ilist.contains(ictx.getInstruction()))
		{
			return; // already done
		}
		StackContext one = ictx.getPops().get(0);
		StackContext two = ictx.getPops().get(1);

		int removeIdx = -1;
		if (one.getPushed().getInstruction() instanceof PushConstantInstruction
			&& DMath.equals((Number) ((PushConstantInstruction) one.getPushed().getInstruction()).getConstant().getObject(), 1))
		{
			removeIdx = 0;
		}
		else if (two.getPushed().getInstruction() instanceof PushConstantInstruction
			&& DMath.equals((Number) ((PushConstantInstruction) two.getPushed().getInstruction()).getConstant().getObject(), 1))
		{
			removeIdx = 1;
		}

		if (removeIdx == -1)
		{
			return;
		}

		pairs.add(new MPair(removeIdx, ictx));

		++count;
	}
	
	private void visit(Frame f)
	{
		for (MPair p : pairs)
		{
			StackContext one = p.ctx.getPops().get(0);
			StackContext two = p.ctx.getPops().get(1);
		
			if (!MultiplicationDeobfuscator.isOnlyPath(p.ctx, p.removeIdx == 0 ? one : two))
			{
				continue;
			}
		
			p.ctx.removeStack(p.removeIdx);
			p.ctx.getInstruction().getInstructions().replace(p.ctx.getInstruction(), new NOP(p.ctx.getInstruction().getInstructions()));
		}
		pairs.clear();
	}
	
	@Override
	public void run(ClassGroup group)
	{
		Execution e = new Execution(group);
		e.addExecutionVisitor(i -> visit(i));
		e.addFrameVisitor(v -> visit(v));
		e.populateInitialMethods();
		e.run();
		
		System.out.println("Removed " + count + " 1 multiplications");
	}

}
