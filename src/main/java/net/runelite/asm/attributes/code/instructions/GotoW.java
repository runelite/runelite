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

public class GotoW extends Instruction implements JumpingInstruction
{
	private Instruction to;
	private int offset;

	public GotoW(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		offset = is.readInt();
		length += 4;
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
		out.writeInt(to.getPc() - this.getPc());
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
