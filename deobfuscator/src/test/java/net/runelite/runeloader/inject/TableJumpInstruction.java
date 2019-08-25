package net.runelite.runeloader.inject;

import org.objectweb.asm.tree.AbstractInsnNode;

public class TableJumpInstruction
{
	private final TableJumpInstruction$TableJump[] tableJumps;
	private final int[] labels;
	private final int start;
	private final AbstractInsnNode[] instructions;
	private final String owner;
	private final String name;
	private final String desc;

	public TableJumpInstruction(TableJumpInstruction$TableJump[] var1, AbstractInsnNode[] var2, int[] var3, int var4, String var5, String var6, String var7)
	{
		this.tableJumps = var1;
		this.instructions = var2;
		this.labels = var3;
		this.owner = var5;
		this.name = var6;
		this.desc = var7;
		this.start = var4;
	}
}
