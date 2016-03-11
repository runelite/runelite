package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;
import net.runelite.deob.pool.PoolEntry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.deob.execution.Value;

public class BiPush extends Instruction implements PushConstantInstruction
{
	private byte b;

	public BiPush(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public BiPush(Instructions instructions, byte b)
	{
		super(instructions, InstructionType.BIPUSH, -1);

		this.b = b;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		b = is.readByte();
		length += 1;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeByte(b);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, int.class, new Value((int) b)); // bipush sign extends the value to an int
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}

	@Override
	public PoolEntry getConstant()
	{
		return new net.runelite.deob.pool.Integer(b);
	}

	@Override
	public Instruction setConstant(PoolEntry entry)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
