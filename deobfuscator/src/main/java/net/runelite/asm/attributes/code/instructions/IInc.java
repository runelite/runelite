package net.runelite.asm.attributes.code.instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instruction.types.WideInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;
import net.runelite.asm.execution.VariableContext;
import net.runelite.asm.execution.Variables;

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
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Variables var = frame.getVariables();
		
		VariableContext vctx = var.get(index);
		assert vctx.getType().isInt();
		ins.read(vctx);
		
		Value value = vctx.getValue();
		if (!vctx.getValue().isUnknownOrNull())
		{
			int i = (int) vctx.getValue().getValue();
			i += inc;
			value = new Value(i);
		}
		
		vctx = new VariableContext(ins, new Type(int.class.getCanonicalName()), value);
		var.set(index, vctx);
		
		return ins;
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
