/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm.attributes.code.instructions;

import java.util.Collections;
import java.util.List;
import net.runelite.asm.Field;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.ComparisonInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.objectweb.asm.MethodVisitor;

public abstract class If0 extends Instruction implements JumpingInstruction, ComparisonInstruction, MappableInstruction
{
	private org.objectweb.asm.Label asmlabel;
	private Label to;

	public If0(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}
	
	public If0(Instructions instructions, InstructionType type, Label to)
	{
		super(instructions, type);
		
		assert to.getInstructions() == this.getInstructions();
		
		this.to = to;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		assert getJumps().size() == 1;

		visitor.visitJumpInsn(this.getType().getCode(), getJumps().get(0).getLabel());
	}
	
	@Override
	public void resolve()
	{
		Instructions ins = this.getInstructions();

		to = ins.findLabel(asmlabel);
		assert to != null;
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		
		ins.pop(one);
		
		Frame other = frame.dup();
		other.jump(ins, to);
		
		ins.branch(other);
		
		return ins;
	}

	@Override
	public List<Label> getJumps()
	{
		return Collections.singletonList(to);
	}

	@Override
	public void setJumps(List<Label> labels)
	{
		assert labels.size() == 1;
		to = labels.get(0);
	}
	
	// duplicated from If
	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		Frame branch1 = ctx.getBranches().get(0),
			branch2 = other.getBranches().get(0);
		
		assert branch1.other == null;
		assert branch2.other == null;
		
		branch1.setOther(branch2);
		branch2.setOther(branch1);
		
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

		this.mapArguments(mapping, ctx, other);
	}
	
	private void mapArguments(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		Field f1 = getComparedField(ctx), f2 = getComparedField(other);
		if (f1 == null || f2 == null)
			return;

		assert MappingExecutorUtil.isMaybeEqual(f1.getType(), f2.getType());
		
		mapping.map(this, f1, f2);
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
			if (!MappingExecutorUtil.isMaybeEqual(f1.getClassFile(), f2.getClassFile()))
				return false;
		
		return MappingExecutorUtil.isMaybeEqual(f1.getType(), f2.getType());
	}
	
	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return true;
	}

	@Override
	public void setLabel(org.objectweb.asm.Label label)
	{
		asmlabel = label;
	}

	public Label getTo()
	{
		return to;
	}

	public void setTo(Label to)
	{
		this.to = to;
	}
}
