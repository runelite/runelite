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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;

public class Jsr extends Instruction implements JumpingInstruction
{
	private Label to;
	private Label next;
	private short offset;

	public Jsr(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public Jsr(Instructions instructions, Label to)
	{
		super(instructions, InstructionType.JSR, -1);
		
		this.to = to;
		length += 2;
	}

	@Override
	public String toString()
	{
		return "jsr " + to + " (at pc " + (this.getPc() + offset) + ")";
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
		Instructions ins = this.getInstructions();

		Instruction i = ins.findInstruction(this.getPc() + offset);
		to = ins.createLabelFor(i);
		
		/** Create label for RET to jump back to */
		next = ins.createLabelFor(ins.getInstructions().get(ins.getInstructions().indexOf(this) + 1));
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		
		int offset = to.next().getPc() - this.getPc();
		
		assert offset <= Short.MAX_VALUE;
		assert offset >= Short.MIN_VALUE;
		
		assert to.next().getInstructions() == this.getInstructions();
		assert to.next().getInstructions().getInstructions().contains(to.next());
		
		out.writeShort(offset);
	}
	
	static int iiii = 0;
	
	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		frame.jump(ins, to);

		/* "The return address is the offset of the bytecode immediately following the jsr or jsr_w instruction and its operands." */
		int offset = next.next().getPc();
		
		/* "Note that jsr pushes the address onto the operand stack and ret (§ret) gets it out of a local variable. This asymmetry is intentional." */
		StackContext ctx = new StackContext(ins, Type.RET_ADDRESS, new Value(offset));
		stack.push(ctx);
		
		ins.push(ctx);
		
		System.out.println("JSR: " + this.getPc() + ", Offset: " + offset + ", Count: " + (iiii++));
		
		return ins;
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
}
