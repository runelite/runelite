package net.runelite.asm.attributes.code.instruction.types;

import net.runelite.asm.execution.StackContext;

public interface DupInstruction
{
	public StackContext getOriginal(StackContext sctx);
	
	public StackContext getOtherBranch(StackContext sctx);
}
