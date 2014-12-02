package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

public class IMul extends Instruction
{
	public IMul(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		Integer one = (Integer) frame.getStack().pop(), two = (Integer) frame.getStack().pop();
		int result = one.intValue() * two.intValue();
		frame.getStack().push(result);
	}
}
