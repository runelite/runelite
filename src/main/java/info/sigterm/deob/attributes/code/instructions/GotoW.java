package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.JumpingInstruction;
import info.sigterm.deob.execution.Frame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class GotoW extends Instruction implements JumpingInstruction
{
	private Instruction to;
	private int offset;

	public GotoW(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
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
	public void buildJumpGraph()
	{
		this.addJump(to);
	}
	
	@Override
	public void execute(Frame e)
	{
		e.jump(to);
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
