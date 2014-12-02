package info.sigterm.deob.attributes.code;

import info.sigterm.deob.execution.Frame;

import java.util.ArrayList;

public abstract class Instruction
{
	private Instructions instructions;
	private InstructionType type;

	private int pc; // offset into method this instructions resides at
	protected int length = 1; // length of this instruction

	private ArrayList<Instruction> jump = new ArrayList<Instruction>(); // instructions which this instruction jumps to
	private ArrayList<Instruction> from = new ArrayList<Instruction>(); // instructions which jump to this instruction

	public Instruction(Instructions instructions, InstructionType type, int pc)
	{
		this.instructions = instructions;
		this.type = type;
		this.pc = pc;
	}

	public Instructions getInstructions()
	{
		return instructions;
	}

	public int getPc()
	{
		return pc;
	}

	public int getLength()
	{
		return length;
	}

	protected void addJump(int offset)
	{
		Instruction other = instructions.findInstruction(pc + offset);
		assert other != null;
		assert other != this;

		this.jump.add(other);
		other.from.add(this);
	}

	public void buildJumpGraph()
	{
	}

	public void buildInstructionGraph()
	{
	}

	//public abstract void execute(Frame e);
	public void execute(Frame e) { }
}
