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
import java.util.List;
import java.util.stream.Collectors;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.attributes.code.instruction.types.MappableInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.deobfuscators.mapping.ParallelExecutorMapping;
import org.objectweb.asm.MethodVisitor;

public class TableSwitch extends Instruction implements JumpingInstruction, MappableInstruction
{
	private List<Label> branchi = new ArrayList<>();
	private Label defi;

	private int low;
	private int high;

	public TableSwitch(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	@Override
	public Instruction clone()
	{
		TableSwitch i = (TableSwitch) super.clone();
		i.branchi = new ArrayList<>(branchi);
		return i;
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitTableSwitchInsn(low, high, defi.getLabel(),
			branchi.stream().map(l -> l.getLabel()).toArray(org.objectweb.asm.Label[]::new));
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		StackContext value = stack.pop();
		ins.pop(value);

		for (Label i : branchi)
		{
			Frame other = frame.dup();
			other.jump(ins, i);

			ins.branch(other);
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
		{
			list.add(i);
		}
		list.add(defi);
		return list.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public void setJumps(List<Label> labels)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setLabel(org.objectweb.asm.Label label)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public int getLow()
	{
		return low;
	}

	public void setLow(int low)
	{
		this.low = low;
	}

	public int getHigh()
	{
		return high;
	}

	public void setHigh(int high)
	{
		this.high = high;
	}

	public List<Label> getBranchi()
	{
		return branchi;
	}

	public void setBranchi(List<Label> branchi)
	{
		this.branchi = branchi;
	}

	public Label getDefi()
	{
		return defi;
	}

	public void setDefi(Label defi)
	{
		this.defi = defi;
	}

	@Override
	public void map(ParallelExecutorMapping mappings, InstructionContext ctx, InstructionContext other)
	{
		// Map branches for step executor

		List<Frame> br1 = ctx.getBranches(),
			br2 = other.getBranches();

		assert br1.size() == br2.size();

		for (int i = 0; i < br1.size(); ++i)
		{
			Frame fr1 = br1.get(i), fr2 = br2.get(i);

			assert fr1.other == null;
			assert fr2.other == null;

			fr1.other = fr2;
			fr2.other = fr1;
		}
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getType() != otherIc.getInstruction().getType())
		{
			return false;
		}

		TableSwitch sw1 = (TableSwitch) thisIc.getInstruction();
		TableSwitch sw2 = (TableSwitch) otherIc.getInstruction();

		assert sw1 == this;

		return sw1.branchi.size() == sw2.branchi.size();
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		Method method = thisIc.getFrame().getMethod();
		// client init has randomally scrambled tableswitch
		return method.getName().equals("init") == false;
	}

}
