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

public class LDC_W extends Instruction implements PushConstantInstruction
{
	private PoolEntry value;

	public LDC_W(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
		
		assert type == InstructionType.LDC_W || type == InstructionType.LDC;
	}
	
	public LDC_W(Instructions instructions, PoolEntry value)
	{
		super(instructions, InstructionType.LDC_W, 0);
		
		this.value = value;
		length += 2;
	}
	
	@Override
	public void load(DataInputStream is) throws IOException
	{
		InstructionType type = this.getType();
		
		assert type == InstructionType.LDC_W || type == InstructionType.LDC;
		
		if (type == InstructionType.LDC_W)
		{
			value = this.getPool().getEntry(is.readUnsignedShort());
			length += 2;
		}
		else if (type == InstructionType.LDC)
		{
			value = this.getPool().getEntry(is.readUnsignedByte());
			length += 1;
		}
	}
	
	@Override
	public void prime()
	{
		int index = this.getPool().make(value);
		assert index >= 0 && index <= 0xFFFF;
		if (index > 0xFF && this.getType() == InstructionType.LDC)
		{
			this.setType(InstructionType.LDC_W);
			++length;
		}
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		super.write(out);
		
		int index = this.getPool().make(value);
		
		assert this.getType() == InstructionType.LDC || this.getType() == InstructionType.LDC_W;
		if (this.getType() == InstructionType.LDC)
		{
			assert index >= 0 && index <= 0xFF;
			out.writeByte(index);
		}
		else if (this.getType() == InstructionType.LDC_W)
		{
			assert index >= 0 && index <= 0xFFFF;
			out.writeShort(index);
		}
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext ctx = new StackContext(ins, value.getTypeClass());
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
	
	
	@Override
	public String getDesc(Frame frame)
	{
		return "ldc_w " + value;
	}

	@Override
	public PoolEntry getConstant()
	{
		return value;
	}

	@Override
	public Instruction setConstant(PoolEntry entry)
	{
		value = entry;
		return this;
	}
	
	@Override
	public Instruction makeSpecific()
	{
		switch (value.getType())
		{
			case INTEGER:
			{
				int i = (int) value.getObject();
				switch (i)
				{
					case -1:
						return new IConst_M1(this.getInstructions());
					case 0:
						return new IConst_0(this.getInstructions());
					case 1:
						return new IConst_1(this.getInstructions());
					case 2:
						return new IConst_2(this.getInstructions());
					case 3:
						return new IConst_3(this.getInstructions());
					case 4:
						return new IConst_4(this.getInstructions());
					case 5:
						return new IConst_5(this.getInstructions());
				}
			}
		}
		
		return super.makeSpecific();
	}
}
