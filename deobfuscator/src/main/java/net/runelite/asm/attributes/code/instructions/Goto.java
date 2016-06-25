/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.asm.attributes.code.instructions;

import java.util.Arrays;
import java.util.List;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import org.objectweb.asm.MethodVisitor;

public class Goto extends Instruction implements JumpingInstruction
{
	private org.objectweb.asm.Label asmlabel;
	private Label to;

	public Goto(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public Goto(Instructions instructions, Label to)
	{
		super(instructions, InstructionType.GOTO);

		assert to != null;
		this.to = to;
	}

	@Override
	public String toString()
	{
		return "goto " + to;// + " (at pc " + (this.getPc() + offset) + ")";
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
		return Arrays.asList(to);
	}

	@Override
	public void setLabel(org.objectweb.asm.Label label)
	{
		assert label != null;
		asmlabel = label;
	}
}
