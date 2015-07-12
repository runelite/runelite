package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;
import info.sigterm.deob.pool.Class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CheckCast extends Instruction
{
	private Class clazz;

	public CheckCast(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		clazz = this.getPool().getClass(is.readUnsignedShort());
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(clazz));
	}

	@Override
	public void execute(Frame frame)
	{			
		// jump to instruction handlers that can catch exceptions here
		for (info.sigterm.deob.attributes.code.Exception e : this.getInstructions().getCode().getExceptions().getExceptions())
		{
			int startIdx = this.getInstructions().getInstructions().indexOf(e.getStart()),
					endIdx = this.getInstructions().getInstructions().indexOf(e.getEnd()),
					thisIdx = this.getInstructions().getInstructions().indexOf(this);
			
			assert startIdx != -1;
			assert endIdx != -1;
			assert thisIdx != -1;
			
			// [start, end)
			if (thisIdx >= startIdx && thisIdx < endIdx)
			{
				Frame f = frame.dup();
				Stack stack = f.getStack();
				
				InstructionContext ins = new InstructionContext(this, f);
				
				while (stack.getSize() > 0)
				{
					StackContext what = stack.pop();
					ins.pop(what);
				}
				
				// push exception back
				StackContext exception = new StackContext(ins, new Type("java/lang/Exception"));
				stack.push(exception);
				
				ins.push(exception);
				
				f.addInstructionContext(ins);
				
				f.jump(e.getHandler());
			}
		}
	}
	
	@Override
	public void renameClass(ClassFile cf, String name)
	{
		if (clazz.getName().equals(cf.getName()))
			clazz = new Class(name);
	}
}
