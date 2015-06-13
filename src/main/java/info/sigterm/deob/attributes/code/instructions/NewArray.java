package info.sigterm.deob.attributes.code.instructions;

import info.sigterm.deob.attributes.code.Instruction;
import info.sigterm.deob.attributes.code.InstructionType;
import info.sigterm.deob.attributes.code.Instructions;
import info.sigterm.deob.execution.Frame;
import info.sigterm.deob.execution.InstructionContext;
import info.sigterm.deob.execution.Stack;
import info.sigterm.deob.execution.StackContext;
import info.sigterm.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NewArray extends Instruction
{
	private int type;

	public NewArray(Instructions instructions, InstructionType type, int pc) throws IOException
	{
		super(instructions, type, pc);

		DataInputStream is = instructions.getCode().getAttributes().getStream();
		this.type = is.readUnsignedByte();
		length += 1;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeByte(type);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext count = stack.pop();
		ins.pop(count);
		
		Class<?> t = null;
		switch (type)
		{
			case 4:
				t = boolean.class;
				break;
			case 5:
				t = char.class;
				break;
			case 6:
				t = float.class;
				break;
			case 7:
				t = double.class;
				break;
			case 8:
				t = byte.class;
				break;
			case 9:
				t = short.class;
				break;
			case 10:
				t = int.class;
				break;
			case 11:
				t = long.class;
				break;
		}
		
		StackContext ctx = new StackContext(ins, new Type(t.getName()));
		stack.push(ctx);
		
		frame.addInstructionContext(ins);
	}

}
