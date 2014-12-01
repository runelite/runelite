package info.sigterm.deob.attributes.code;

public class Instruction
{
	private Instructions instructions;
	private InstructionType type;
	private int pc;
	protected int length = 1;

	Instruction(Instructions instructions, InstructionType type, int pc)
	{
		this.instructions = instructions;
		this.type = type;
		this.pc = pc;
	}

	public int getLength()
	{
		return length;
	}
}
