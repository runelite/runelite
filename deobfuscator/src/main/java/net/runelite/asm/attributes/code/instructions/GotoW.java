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
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import org.objectweb.asm.MethodVisitor;

public class GotoW extends Instruction implements JumpingInstruction
{
	private org.objectweb.asm.Label asmlabel;
	private Label to;

	public GotoW(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
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
		InstructionContext ctx = new InstructionContext(this, frame);

		frame.jump(ctx, to);

		return ctx;
	}

	@Override
	public boolean isTerminal()
	{
		return true;
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
	public void setLabel(org.objectweb.asm.Label label)
	{
		asmlabel = label;
	}
}
