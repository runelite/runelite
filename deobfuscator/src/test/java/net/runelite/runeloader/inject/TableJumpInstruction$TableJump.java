package net.runelite.runeloader.inject;

import org.objectweb.asm.Label;

public class TableJumpInstruction$TableJump
{
	public Label label;
	public final int instructionIndex;
	public final int labelArrayIndex;
	public final int opcode;

	public TableJumpInstruction$TableJump(int var1, int var2, int var3)
	{
		this.instructionIndex = var1;
		this.opcode = var3;
		this.labelArrayIndex = var2;
	}
}
