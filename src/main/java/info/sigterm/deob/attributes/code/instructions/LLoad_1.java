package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.attributes.code.instruction.types.LVTInstruction;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;
import info.sigterm.deob.execution.VariableContext;
import info.sigterm.deob.execution.Variables;

import java.io.IOException;

public class LLoad_1 extends Instruction implements LVTInstruction
{
	public LLoad_1(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		Variables variables = frame.getVariables();
		
		VariableContext vctx = variables.get(1);
		assert vctx.getType().equals(new Type(long.class.getName()));
		ins.read(vctx);
		
		StackContext ctx = new StackContext(ins, vctx.getType());
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public int getVariableIndex()
	{
		return 1;
	}
	
	@Override
	public Instruction setVariableIndex(int idx)
	{
		return new LLoad(this.getInstructions(), idx);
	}

	@Override
	public boolean store()
	{
		return false;
	}
}
