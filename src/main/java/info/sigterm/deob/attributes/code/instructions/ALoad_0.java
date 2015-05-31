package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.VariableContext;
import info.sigterm.deob.execution.Variables;

import java.io.IOException;

public class ALoad_0 extends Instruction implements LVTInstruction
{
	public ALoad_0(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables var = frame.getVariables();
		
		VariableContext vctx = var.get(0);
		ins.read(vctx);
		
		StackContext ctx = new StackContext(ins, vctx.getType());
		stack.push(ctx);
		
		frame.addInstructionContext(ins);
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
