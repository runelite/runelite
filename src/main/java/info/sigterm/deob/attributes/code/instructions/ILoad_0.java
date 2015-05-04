package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.execution.Frame;

import java.io.IOException;

public class ILoad_0 extends Instruction implements LVTInstruction
{
	public ILoad_0(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Object obj = frame.getVariables().get(0);
		assert obj instanceof Integer;
		frame.getStack().push(this, obj);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 0;
	}

	@Override
	public boolean store()
	{
		return false;
	}
}
