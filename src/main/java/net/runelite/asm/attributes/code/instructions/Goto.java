package net.runelite.asm.attributes.code.instructions;

import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.JumpingInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Goto extends Instruction implements JumpingInstruction
{
	private Instruction to;
	private short offset;

	public Goto(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public String toString()
	{
		return "goto " + to + " (at pc " + (this.getPc() + offset) + ")";
	}
	
	public Goto(Instructions instructions, Instruction to)
	{
		super(instructions, InstructionType.GOTO, 0);
		this.to = to;
		length += 2;
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
		
		int offset = to.getPc() - this.getPc();
		
		assert offset <= Short.MAX_VALUE;
		assert offset >= Short.MIN_VALUE;
		
		assert to.getInstructions() == this.getInstructions();
		assert to.getInstructions().getInstructions().contains(to);
		
		out.writeShort(offset);
	}
	
	@Override
	public void execute(Frame frame)
	{
		InstructionContext ctx = new InstructionContext(this, frame);
		frame.addInstructionContext(ctx);
		
		frame.jump(ctx, to);
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
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
}
