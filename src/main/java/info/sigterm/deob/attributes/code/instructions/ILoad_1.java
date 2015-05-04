package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.execution.Frame;

import java.io.IOException;

public class ILoad_1 extends Instruction implements LVTInstruction
{
	public ILoad_1(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Object obj = frame.getVariables().get(1);
		frame.getStack().push(this, obj);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 1;
	}

	@Override
	public boolean store()
	{
		return false;
	}
}
