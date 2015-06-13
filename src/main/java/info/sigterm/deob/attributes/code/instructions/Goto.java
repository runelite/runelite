package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.JumpingInstruction;
import info.sigterm.deob.execution.Frame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Goto extends Instruction implements JumpingInstruction
{
	private Instruction to;
	private short offset;

	public Goto(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
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
		out.writeShort(offset);
	}

	@Override
	public void buildJumpGraph()
	{
		this.addJump(to);
	}
	
	@Override
	public void execute(Frame e)
	{
		e.jump(offset);
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
}
