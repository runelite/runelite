package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.attributes.code.instruction.types.WideInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.VariableContext;
import info.sigterm.deob.execution.Variables;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AStore extends Instruction implements LVTInstruction, WideInstruction
{
	private int index;

	public AStore(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		length += 1;
	}
	
	public AStore(Instructions instructions, InstructionType type, Instruction instruction, int pc) throws IOException
	{
		super(instructions, type, pc);
		
		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readShort();
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeByte(index);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		StackContext object = stack.pop();
		ins.pop(object);
		
		variables.set(index, new VariableContext(ins, object.getType()));
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public int getVariableIndex()
	{
		return index;
	}

	@Override
	public boolean store()
	{
		return true;
	}

	@Override
	public void writeWide(DataOutputStream out, int pc) throws IOException
	{
		super.write(out, pc);
		out.writeShort(index);
	}
}
