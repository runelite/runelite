package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;

public class MonitorExit extends Instruction
{
	public MonitorExit(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
	}
}
