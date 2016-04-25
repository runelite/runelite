package net.runelite.asm.attributes.code.instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Type;
import net.runelite.asm.execution.Value;

public class NewArray extends Instruction
{
	private int type;

	public NewArray(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public int getArrayType()
	{
		return type;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
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
	public InstructionContext execute(Frame frame)
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
			default:
				throw new IllegalStateException("unknown array type " + type);
		}
		
		StackContext ctx = new StackContext(ins, new Type(t.getName()), Value.newArray(count.getValue()));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
	}

}
