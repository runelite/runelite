package net.runelite.deob.attributes.code.instructions;

import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.InstructionType;
import net.runelite.deob.attributes.code.Instructions;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.deob.deobfuscators.arithmetic.DMath;
import net.runelite.deob.deobfuscators.arithmetic.Encryption;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.execution.InstructionContext;
import net.runelite.deob.execution.Stack;
import net.runelite.deob.execution.StackContext;

public class IMul extends Instruction
{
	public IMul(Instructions instructions, InstructionType type, int pc)
	{
		super(instructions, type, pc);
	}

	@Override
	public void execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();
		
		StackContext one = stack.pop();
		StackContext two = stack.pop();
		
		ins.pop(one, two);
		
		Encryption encryption = frame.getExecution().getEncryption();
		int encKey = 0;
		if (encryption != null)
		{
			if (one.encryption != 0)
			{
				assert two.encryption == 0;
				PushConstantInstruction pci = (PushConstantInstruction) two.getPushed().getInstruction();
				int other = (int) pci.getConstant().getObject();
				
				// 'one' is encrypted and we want to decrypt it by dividing by one.encryption
				
				if (other != 1 && other != 0)
				{
					int o = other * DMath.modInverse(one.encryption);

					encryption.change(pci, o);
				}
				else	encKey = one.encryption;
			}
			else if (two.encryption != 0)
			{
				assert one.encryption == 0;
				
				PushConstantInstruction pci = (PushConstantInstruction) one.getPushed().getInstruction();
				int other = (int) pci.getConstant().getObject();
				
				if (other != 1 && other != 0)
				{
					int o = other * DMath.modInverse(two.encryption);

					encryption.change(pci, o);
				}
				else encKey = two.encryption;
			}
		}
		
		StackContext ctx = new StackContext(ins, int.class);
		ctx.encryption = encKey;
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
}
