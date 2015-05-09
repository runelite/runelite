package info.sigterm.deob.attributes.code;

import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.execution.Frame;

import java.io.DataOutputStream;
import java.io.IOException;
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
	
	public void write(DataOutputStream out, int pc) throws IOException
	{
		out.writeByte(type.getCode());
	}

	public Instructions getInstructions()
	{
		return instructions;
	}
	
	public ConstantPool getPool()
	{
		return instructions.getCode().getAttributes().getClassFile().getPool();
	}

	public int getPc()
	{
		return pc;
	}

	public int getLength()
	{
		return length;
	}
	
	public String getDesc(Frame frame)
	{
		return type.getName() + " at pc " + frame.getPc() + " in " + frame.getMethod().getName() + " " + frame.getMethod().getDescriptor() + " class " + frame.getMethod().getCode().getAttributes().getClassFile().getName();
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
	
	public void buildCallGraph()
	{
	}

	public abstract void execute(Frame e);
}
