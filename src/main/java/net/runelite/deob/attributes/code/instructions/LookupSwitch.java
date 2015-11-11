package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LookupSwitch extends Instruction implements JumpingInstruction
{
	private List<Instruction> branchi = new ArrayList<>();
	private Instruction defi;
	
	private int def;
	private int count;
	private int[] match;
	private int[] branch;

	public LookupSwitch(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		int pc = this.getPc();
		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) is.skip(tableSkip);

		def = is.readInt();

		count = is.readInt();
		match = new int[count];
		branch = new int[count];

		for (int i = 0; i < count; ++i)
		{
			match[i] = is.readInt();
			branch[i] = is.readInt();
		}

		length += tableSkip + 8 + (count * 8);
	}
	
	@Override
	public void setPc(int pc)
	{
		super.setPc(pc);
		
		int tableSkip = 4 - (pc + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		
		length = 1 + tableSkip + 8 + (count * 8);
	}
	
	@Override
	public void resolve()
	{
		for (int i : branch)
			branchi.add(this.getInstructions().findInstruction(this.getPc() + i));
		defi = this.getInstructions().findInstruction(this.getPc() + def);
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		
		int tableSkip = 4 - (this.getPc() + 1) % 4;
		if (tableSkip == 4) tableSkip = 0;
		if (tableSkip > 0) out.write(new byte[tableSkip]);
		
		out.writeInt(defi.getPc() - this.getPc());
		
		out.writeInt(count);
		for (int i = 0; i < count; ++i)
		{
			out.writeInt(match[i]);
			out.writeInt(branchi.get(i).getPc() - this.getPc());
		}
	}

	@Override
	public void buildJumpGraph()
	{
		for (Instruction i : branchi)
			this.addJump(i);
		this.addJump(defi);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext value = stack.pop();
		ins.pop(value);
		
		frame.addInstructionContext(ins);
		
		for (Instruction i : branchi)
		{
			Frame other = frame.dup();
			other.jump(ins, i);
		}
		
		frame.jump(ins, defi);
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
	
	@Override
	public void replace(Instruction oldi, Instruction newi)
	{
		if (defi == oldi)
			defi = newi;
		
		for (int i = 0; i < branchi.size(); ++i)
			if (branchi.get(i) == oldi)
				branchi.set(i, newi);
	}
	
	@Override
	public List<Instruction> getJumps()
	{
		List<Instruction> list = new ArrayList<>();
		for (Instruction i : branchi)
			list.add(i);
		list.add(defi);
		return list.stream().distinct().collect(Collectors.toList());
	}
}
