package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.LVTInstruction;
import net.runelite.deob.attributes.code.instruction.types.WideInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Type;
import net.runelite.deob.execution.VariableContext;
import net.runelite.deob.execution.Variables;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IInc extends Instruction implements LVTInstruction, WideInstruction
{
	private short index;
	private short inc;
	private boolean wide;

	public IInc(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}
	
	public IInc(Instructions instructions, InstructionType type, Instruction instruction, int pc)
	{
		super(instructions, type, pc);
		wide = true;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		if (wide)
		{
			index = is.readShort();
			inc = is.readShort();
			length += 4;
		}
		else
		{
			index = is.readByte();
			inc = is.readByte();
			length += 2;
		}
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeByte(index);
		out.writeByte(inc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Variables var = frame.getVariables();
		
		VariableContext vctx = var.get(index);
		assert vctx.getType().equals(new Type(int.class.getCanonicalName()));
		ins.read(vctx);
		
		vctx = new VariableContext(ins, vctx);
		var.set(index, vctx);
		
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
		return false; // This is a get first
	}

	@Override
	public void writeWide(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(index);
		out.writeShort(inc);
	}

	@Override
	public Instruction setVariableIndex(int idx)
	{
		index = (short) idx;
		return this;
	}
}
