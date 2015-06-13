package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.attributes.code.instruction.types.WideInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Type;
import info.sigterm.deob.execution.VariableContext;
import info.sigterm.deob.execution.Variables;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IInc extends Instruction implements LVTInstruction, WideInstruction
{
	private short index;
	private short inc;

	public IInc(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readByte();
		inc = is.readByte();
		length += 2;
	}
	
	public IInc(Instructions instructions, InstructionType type, Instruction instruction, int pc) throws IOException
	{
		super(instructions, type, pc);
		
		DataInputStream is = instructions.getCode().getAttributes().getStream();
		index = is.readShort();
		inc = is.readShort();
		length += 4;
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
		
		vctx = new VariableContext(ins, vctx.getType());
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
