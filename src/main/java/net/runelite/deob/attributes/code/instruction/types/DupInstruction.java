package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.execution.StackContext;

public interface DupInstruction
{
	public StackContext getOriginal(StackContext sctx);
	
	public StackContext getOtherBranch(StackContext sctx);
}
