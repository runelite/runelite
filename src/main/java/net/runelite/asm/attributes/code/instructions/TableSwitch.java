package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableSwitch extends Instruction implements JumpingInstruction
{
	private List<Instruction> branchi = new ArrayList<>();
	private Instruction defi;
	
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
		for (int i : jumps)
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
		out.writeInt(low);
		out.writeInt(high);
		
		for (Instruction i : branchi)
			out.writeInt(i.getPc() - this.getPc());
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext value = stack.pop();
		ins.pop(value);
	
		if (!frame.getExecution().step)
		{
			for (Instruction i : branchi)
			{
				Frame other = frame.dup();
				other.jump(ins, i);

				ins.branch(other);
			}
		}
		
		frame.jump(ins, defi);
		
		frame.addInstructionContext(ins);
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
