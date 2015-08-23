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
		if (encryption != null)
		{
			if (one.encryption != 0)
			{
				assert two.encryption == 0;
				PushConstantInstruction pci = (PushConstantInstruction) two.getPushed().getInstruction();
				int other = (int) pci.getConstant().getObject();
				
				// 'one' is encrypted and we want to decrypt it by dividing by one.encryption
				
				int o = other * DMath.modInverse(one.encryption);
				
				System.out.println(other + " -> " + o);
				
				encryption.change(pci, o);
				
//				if (one.encryption == other)
//				{
//					System.out.println("decrr");
//				}
			}
			else if (two.encryption != 0)
			{
				PushConstantInstruction pci = (PushConstantInstruction) one.getPushed().getInstruction();
				int other = (int) pci.getConstant().getObject();
				
				int o = other * DMath.modInverse(two.encryption);
				
				System.out.println(other + " -> " + o);
				
				encryption.change(pci, o);
			}
		}
		
		StackContext ctx = new StackContext(ins, int.class);
		stack.push(ctx);
		
		ins.push(ctx);
		
		frame.addInstructionContext(ins);
	}
}
