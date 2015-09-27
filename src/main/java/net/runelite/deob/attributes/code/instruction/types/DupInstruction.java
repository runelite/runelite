package net.runelite.deob.attributes.code.instruction.types;

import net.runelite.deob.execution.StackContext;

public interface DupInstruction
{
	public StackContext resolve(StackContext sctx);
	
	public StackContext getOtherBranch(StackContext sctx);
}
