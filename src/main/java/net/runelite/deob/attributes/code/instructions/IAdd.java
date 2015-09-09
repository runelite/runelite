package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.deobfuscators.arithmetic.DMath;
import net.runelite.deob.deobfuscators.arithmetic.Encryption;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;

public class IAdd extends Instruction
{
	public IAdd(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext two = stack.pop();
		StackContext one = stack.pop();
		
		ins.pop(two, one);
		
		Encryption encryption = frame.getExecution().getEncryption();
		int encKey = 0;
		if (encryption != null)
		{
			if (one.encryption != 0)
			{
				assert two.encryption == 0;
				
				if (two.getPushed().getInstruction() instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) two.getPushed().getInstruction();
					int value = (int) pci.getConstant().getObject();

					if (value != 0 && value != 1)
					{
						int o = value * one.encryption;

						encryption.change(pci, o);
					}
				}
				
				encKey = one.encryption;
			}
			else if (two.encryption != 0)
			{
				assert one.encryption == 0;
				
				if (one.getPushed().getInstruction() instanceof PushConstantInstruction)
				{
					PushConstantInstruction pci = (PushConstantInstruction) one.getPushed().getInstruction();
					int value = (int) pci.getConstant().getObject();

					if (value != 0 && value != 1)
					{
						int o = value * two.encryption;

						encryption.change(pci, o);
					}
				}
				
				encKey = two.encryption;
			}
		}
		
		StackContext ctx = new StackContext(ins, int.class);
		ctx.encryption = encKey;
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
}
