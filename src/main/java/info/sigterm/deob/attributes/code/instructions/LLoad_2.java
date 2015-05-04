package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.execution.Frame;

import java.io.IOException;

public class LLoad_2 extends Instruction implements LVTInstruction
{
	public LLoad_2(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Object obj = frame.getVariables().get(2);
		assert obj instanceof Long;
		frame.getStack().push(this, obj);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 2;
	}

	@Override
	public boolean store()
	{
		return false;
	}
}
