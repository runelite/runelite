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
import net.runelite.deob.pool.ConstantType;

public class LDC2_W extends Instruction implements PushConstantInstruction
{
	private PoolEntry value;

	public LDC2_W(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	public LDC2_W(Instructions instructions, long value)
	{
		super(instructions, InstructionType.LDC2_W, -1);
		this.value = new net.runelite.deob.pool.Long(value);
		length += 2;
	}

	public LDC2_W(Instructions instructions, double value)
	{
		super(instructions, InstructionType.LDC2_W, -1);
		this.value = new net.runelite.deob.pool.Double(value);
		length += 2;
	}
	
	public LDC2_W(Instructions instructions, PoolEntry value)
	{
		super(instructions, InstructionType.LDC2_W, -1);
		
		assert value.getType() == ConstantType.LONG || value.getType() == ConstantType.DOUBLE;
		
		this.value = value;
		length += 2;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		value = this.getPool().getEntry(is.readUnsignedShort());
		assert value.getType() == ConstantType.LONG || value.getType() == ConstantType.DOUBLE;
		length += 2;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		out.writeShort(this.getPool().make(value));
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, value.getTypeClass(), new Value(value.getObject()));
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	@Override
	public PoolEntry getConstant()
	{
		return value;
	}
	
	@Override
	public Instruction setConstant(PoolEntry entry)
	{
		assert entry.getType() == ConstantType.LONG || entry.getType() == ConstantType.DOUBLE;
		value = entry;
		return this;
	}
	
	public long getConstantAsLong()
	{
		return (long) value.getObject();
	}
}
