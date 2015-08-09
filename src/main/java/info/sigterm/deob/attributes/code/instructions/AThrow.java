package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;

import java.io.IOException;
import java.util.List;

public class AThrow extends Instruction
{
	public AThrow(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		// get exception
		StackContext exception = stack.pop();
		ins.pop(exception);
		
//		// Clear stack
//		while (stack.getSize() > 0)
//		{
//			StackContext value = stack.pop();
//			ins.pop(value);
//		}
//		
//		// push exception back
//		exception = new StackContext(ins, exception.getType());
//		stack.push(exception);
//		
//		// jump to instruction handlers that can catch exceptions here
//		for (info.sigterm.deob.attributes.code.Exception e : this.getInstructions().getCode().getExceptions().getExceptions())
//		{
//			int startIdx = this.getInstructions().getInstructions().indexOf(e.getStart()),
//					endIdx = this.getInstructions().getInstructions().indexOf(e.getEnd()),
//					thisIdx = this.getInstructions().getInstructions().indexOf(this);
//			
//			assert startIdx != -1;
//			assert endIdx != -1;
//			assert thisIdx != -1;
//			
//			// [start, end)
//			if (thisIdx >= startIdx && thisIdx < endIdx)
//			{
//				Frame f = frame.dup();
//				f.jump(e.getHandler());
//			}
//		}
//
//		frame.addInstructionContext(ins);
		
		frame.stop();
	}
	
	@Override
	public boolean isTerminal()
	{
		return true;
	}
}
