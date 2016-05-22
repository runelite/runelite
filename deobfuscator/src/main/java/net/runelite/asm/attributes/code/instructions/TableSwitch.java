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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;

public class TableSwitch extends Instruction implements JumpingInstruction
{
	private List<Label> branchi = new ArrayList<>();
	private Label defi;
	
	private int def;
	private int low;
	private int high;
	private int[] jumps;

	public TableSwitch(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public Instruction clone()
	{
		TableSwitch i = (TableSwitch) super.clone();
		i.branchi = new ArrayList<>(branchi);
		return i;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		int pc = this.getPc();
		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) is.skip(tableSkip);

		def = is.readInt();
		low = is.readInt();
		high = is.readInt();

		int count = high - low + 1;
		jumps = new int[count];

		for (int i = 0; i < count; ++i)
			jumps[i] = is.readInt();

		length += tableSkip + 12 + (count * 4);
	}
	
	// changing the pc changes the instruction length due to padding
	@Override
	public void setPc(int pc)
	{
		super.setPc(pc);
		
		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		
		length = 1 + tableSkip + 12 + (jumps.length * 4);
	}
	
	@Override
	public void resolve()
	{
		Instructions ins = this.getInstructions();

		for (int i : jumps)
		{
			Instruction in = ins.findInstruction(this.getPc() + i);
			branchi.add(ins.createLabelFor(in));
		}

		Instruction in = ins.findInstruction(this.getPc() + def);
		defi = ins.createLabelFor(in);
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		
		int tableSkip = 4 - (this.getPc() + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) out.write(new byte[tableSkip]);
		
		out.writeInt(defi.next().getPc() - this.getPc());
		out.writeInt(low);
		out.writeInt(high);
		
		for (Label i : branchi)
			out.writeInt(i.next().getPc() - this.getPc());
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext value = stack.pop();
		ins.pop(value);
	
		if (!frame.getExecution().step)
		{
			for (Label i : branchi)
			{
				Frame other = frame.dup();
				other.jump(ins, i);

				ins.branch(other);
			}
		}
		
		frame.jump(ins, defi);
		
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
		List<Label> list = new ArrayList<>();
		for (Label i : branchi)
			list.add(i);
		list.add(defi);
		return list.stream().distinct().collect(Collectors.toList());
	}
}
