package info.sigterm.deob.attributes.code;

import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.execution.Frame;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Instruction
{
	private Instructions instructions;
	private InstructionType type;

	private int pc; // offset into method this instructions resides at
	protected int length = 1; // length of this instruction

	public List<Instruction> jump = new ArrayList<>(), // instructions which this instruction jumps to
								from = new ArrayList<>(); // instructions which jump to this instruction
	public List<Exception> exce = new ArrayList<>(); // exception handlers which start here

	public Instruction(Instructions instructions, InstructionType type, int pc)
	{
		this.instructions = instructions;
		this.type = type;
		this.pc = pc;
	}
	
	protected void remove()
	{
		for (Instruction i : jump)
			i.from.remove(this);
		jump.clear();
		
		assert from.isEmpty();
		assert exce.isEmpty();
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
	
	/* does this terminate a block? */
	public boolean isTerminal()
	{
		return false;
	}
}
