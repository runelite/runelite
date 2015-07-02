package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.ComparisonInstruction;
import info.sigterm.deob.attributes.code.instruction.types.JumpingInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class If extends Instruction implements JumpingInstruction, ComparisonInstruction
{
	private Instruction to;
	private short offset;

	public If(Instructions instructions, InstructionType type, int pc) throws IOException
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
		out.writeShort(to.getPc() - this.getPc());
	}

	@Override
	public void buildJumpGraph()
	{
		this.addJump(to);
	}
	
	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = stack.pop();
		
		ins.pop(one, two);
		
		frame.addInstructionContext(ins);
		
		Frame other = frame.dup();
		other.jump(to);
	}
	
	@Override
	public void replace(Instruction oldi, Instruction newi)
	{
		if (to == oldi)
			to = newi;
	}
	
	public Instruction getTo()
	{
		return to;
	}
}
