package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.WideInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.execution.VariableContext;
import net.runelite.deob.execution.Variables;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FStore extends Instruction implements LVTInstruction, WideInstruction
{
	private int index;
	
	public FStore(Instructions instructions, int index)
	{
		super(instructions, InstructionType.FSTORE, 0);
		this.index = index;
		++length;
	}

	public FStore(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		length += 1;
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeByte(index);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		StackContext value = stack.pop();
		ins.pop(value);
		
		variables.set(index, new VariableContext(ins, value.getType()));
		
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
	public void writeWide(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(index);
	}

	@Override
	public Instruction setVariableIndex(int idx)
	{
		index = idx;
		return this;
	}
}
