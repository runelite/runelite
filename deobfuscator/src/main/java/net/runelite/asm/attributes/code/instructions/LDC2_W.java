package net.runelite.asm.attributes.code.instructions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.execution.Frame;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.Stack;
import net.runelite.asm.execution.StackContext;
import net.runelite.asm.execution.Value;
import net.runelite.asm.pool.ConstantType;
import net.runelite.asm.pool.PoolEntry;

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
		this.value = new net.runelite.asm.pool.Long(value);
		length += 2;
	}

	public LDC2_W(Instructions instructions, double value)
	{
		super(instructions, InstructionType.LDC2_W, -1);
		this.value = new net.runelite.asm.pool.Double(value);
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
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, value.getTypeClass(), new Value(value.getObject()));
		stack.push(ctx);
		
		ins.push(ctx);
		
		return ins;
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

	@Override
	public Instruction makeSpecific()
	{
		switch (value.getType())
		{
			case LONG:
			{
				long l = (long) value.getObject();

				if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE)
					break;

				switch ((int) l)
				{
					case 0:
						return new LConst_0(this.getInstructions());
					case 1:
						return new LConst_1(this.getInstructions());
				}
			}
		}

		return super.makeSpecific();
	}
}
