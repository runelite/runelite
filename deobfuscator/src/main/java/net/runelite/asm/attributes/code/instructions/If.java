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

import java.util.ArrayList;
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
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.MappingExecutorUtil;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.objectweb.asm.MethodVisitor;

public abstract class If extends Instruction implements JumpingInstruction, ComparisonInstruction, MappableInstruction
{
	private org.objectweb.asm.Label asmlabel;
	private Label to;

	public If(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public If(Instructions instructions, InstructionType type, Label to)
	{
		super(instructions, type);

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
		StackContext two = stack.pop();

		ins.pop(one, two);

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

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		assert ctx.getBranches().size() == other.getBranches().size();

		// can be empty for packet handlers
		if (!ctx.getBranches().isEmpty())
		{
			Frame branch1 = ctx.getBranches().get(0),
				branch2 = other.getBranches().get(0);

			assert branch1.other == null;
			assert branch2.other == null;

			branch1.other = branch2;
			branch2.other = branch1;
		}

		this.mapArguments(mapping, ctx, other, false);
	}

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

		this.mapArguments(mapping, ctx, other, true);
	}

	private void mapArguments(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other, boolean inverse)
	{
		List<Field> f1s = getComparedFields(ctx), f2s = getComparedFields(other);

		if (f1s == null || f2s == null || f1s.size() != f2s.size())
		{
			return;
		}

		if (f1s.size() == 1)
		{
			Field f1 = f1s.get(0), f2 = f2s.get(0);

			assert MappingExecutorUtil.isMaybeEqual(f1.getType(), f2.getType());

			mapping.map(this, f1, f2);
		}
		else if (f1s.size() == 2)
		{
			Field f1 = f1s.get(0), f2 = f2s.get(0);
			Field j1 = f1s.get(1), j2 = f2s.get(1);

//			if (couldBeSame(f1, f2) && couldBeSame(j1, j2) && couldBeSame(f1, j2) && couldBeSame(j1, f2))
//			{
//				mapping.map()
//				return; // ambiguous
//			}
			if (couldBeSame(f1, f2) && couldBeSame(j1, j2))
			{
				mapping.map(this, f1, f2);
				mapping.map(this, j1, j2);
			}

			if (couldBeSame(f1, j2) && couldBeSame(j1, f2))
			{
				mapping.map(this, f1, j2);
				mapping.map(this, j1, f2);
			}
		}
		else
		{
			assert false;
		}
	}

	private List<Field> getComparedFields(InstructionContext ctx)
	{
		List<Field> fields = new ArrayList<>();

		for (StackContext sctx : ctx.getPops())
		{
			InstructionContext base = MappingExecutorUtil.resolve(sctx.getPushed(), sctx);

			if (base.getInstruction() instanceof GetFieldInstruction)
			{
				GetFieldInstruction gfi = (GetFieldInstruction) base.getInstruction();

				if (gfi.getMyField() != null)
				{
					fields.add(gfi.getMyField());
				}
			}
		}

		return fields.isEmpty() ? null : fields;
	}

	protected Integer getConstantInstruction(InstructionContext ctx)
	{
		PushConstantInstruction gfi = null;

		for (StackContext sctx : ctx.getPops())
		{
			InstructionContext base = MappingExecutorUtil.resolve(sctx.getPushed(), sctx);

			if (base.getInstruction() instanceof PushConstantInstruction)
			{
				if (gfi != null)
				{
					return null;
				}

				gfi = (PushConstantInstruction) base.getInstruction();
			}
		}

		if (gfi == null)
		{
			return null;
		}

		return ((Number) gfi.getConstant()).intValue();
	}

	private boolean couldBeSame(Field f1, Field f2)
	{
		if (f1.isStatic() != f2.isStatic())
		{
			return false;
		}

		if (!f1.isStatic())
		{
			if (!MappingExecutorUtil.isMaybeEqual(f1.getClassFile(), f2.getClassFile()))
			{
				return false;
			}
		}

		return MappingExecutorUtil.isMaybeEqual(f1.getType(), f2.getType());
	}

	protected boolean isSameField(InstructionContext thisIc, InstructionContext otherIc)
	{
		List<Field> f1s = getComparedFields(thisIc), f2s = getComparedFields(otherIc);

		if ((f1s != null) != (f2s != null))
		{
			return false;
		}

		if (f1s == null || f2s == null)
		{
			return true;
		}

		if (f1s.size() != f2s.size())
		{
			return false;
		}

		assert f1s.size() == 1 || f1s.size() == 2;

		if (f1s.size() == 2)
		{
			Field f1 = f1s.get(0), f2 = f2s.get(0);
			Field j1 = f1s.get(1), j2 = f2s.get(1);

			if (!f1.isStatic() && !j1.isStatic() && !f2.isStatic() && !j2.isStatic())
			{
				if ((f1.getClassFile() == j1.getClassFile()) != (f2.getClassFile() == j2.getClassFile()))
				{
					return false;
				}
			}

			if (couldBeSame(f1, f2) && couldBeSame(j1, j2) && couldBeSame(f1, j2) && couldBeSame(j1, f2))
			{
				return true;
			}

			if (couldBeSame(f1, f2) && couldBeSame(j1, j2))
			{
				return true;
			}

			if (couldBeSame(f1, j2) && couldBeSame(j1, f2))
			{
				return true;
			}

			return false;
		}
		else
		{
			Field f1 = f1s.get(0), f2 = f2s.get(0);

			return couldBeSame(f1, f2);
		}
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
}
