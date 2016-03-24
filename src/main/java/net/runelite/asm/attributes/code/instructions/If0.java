package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.deob.deobfuscators.rename.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.rename.ParallelExecutorMapping;

public abstract class If0 extends Instruction implements JumpingInstruction, ComparisonInstruction, MappableInstruction
{
	private Instruction to;
	private short offset;

	public If0(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public If0(Instructions instructions, InstructionType type, Instruction to)
	{
		super(instructions, type, -1);
		
		assert this != to;
		assert to.getInstructions() == this.getInstructions();
		
		this.to = to;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		offset = is.readShort();
		length += 2;
	}
	
	@Override
	public void resolve()
	{
		to = this.getInstructions().findInstruction(this.getPc() + offset);
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		assert to.getInstructions() == this.getInstructions();
		assert to.getInstructions().getInstructions().contains(to);
		out.writeShort(to.getPc() - this.getPc());
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		
		ins.pop(one);
		
		Frame other = frame.dup();
		other.created = this;
		other.forking = ins;
		other.jump(ins, to);
		
		ins.branch(other);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public void replace(Instruction oldi, Instruction newi)
	{
		if (to == oldi)
			to = newi;
	}
	
	@Override
	public List<Instruction> getJumps()
	{
		return Arrays.asList(to);
	}
	
	// duplicated from If
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		Frame branch1 = ctx.getBranches().get(0),
			branch2 = other.getBranches().get(0);
		
		assert branch1.other == null;
		assert branch2.other == null;
		
		branch1.other = branch2;
		branch2.other = branch1;
		
		this.mapArguments(mapping, ctx, other);
	}
	
	// duplicated from If
	protected void mapOtherBranch(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		Frame f1 = ctx.getFrame(),
			f2 = other.getFrame(),
			branch1 = ctx.getBranches().get(0),
			branch2 = other.getBranches().get(0);

		assert branch1.other == null;
		assert branch2.other == null;

		// currently f1 <-> f2
		assert f1.other == f2;
		assert f2.other == f1;

		// change to f1 <-> branch2, f2 <-> branch1

		f1.other = branch2;
		branch2.other = f1;

		f2.other = branch1;
		branch1.other = f2;

		// switch frame order in executor frame list

//		Execution e = f1.getExecution(),
//			e2 = f2.getExecution();
//
//		int i = e2.frames.indexOf(f2),
//			i2 = e2.frames.indexOf(branch2);
//
//		e2.frames.remove(i);
//		e2.frames.add(i, branch2);
//
//		e2.frames.remove(i2);
//		e2.frames.add(i2, f2);

		this.mapArguments(mapping, ctx, other);
	}
	
	private void mapArguments(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		Field f1 = getComparedField(ctx), f2 = getComparedField(other);
		if (f1 == null || f2 == null)
			return;
		
		assert f1.getType().equals(f2.getType());
		
		mapping.map(f1, f2);
	}
	
	private Field getComparedField(InstructionContext ctx)
	{
		GetFieldInstruction gfi = null;
		
		for (StackContext sctx : ctx.getPops())
		{
			InstructionContext base = MappingExecutorUtil.resolve(sctx.getPushed(), sctx);
			
			if (base.getInstruction() instanceof GetFieldInstruction)
			{
				if (gfi != null)
					return null;
				
				gfi = (GetFieldInstruction) base.getInstruction();
			}
		}
		
		if (gfi == null)
			return null;
		
		return gfi.getMyField();
	}
	
	protected boolean isSameField(InstructionContext thisIc, InstructionContext otherIc)
	{
		Field f1 = getComparedField(thisIc), f2 = getComparedField(otherIc);
		if ((f1 != null) != (f2 != null))
			return false;
		
		if (f1 == null || f2 == null)
			return true;
		
		if (f1.isStatic() != f2.isStatic())
			return false;

		if (!f1.isStatic())
			if (!f1.getFields().getClassFile().getName().equals(f2.getFields().getClassFile().getName()))
				return false;
		
		return f1.getType().equals(f2.getType());
	}
	
	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return true;
	}
}
