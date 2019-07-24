package net.runelite.runeloader.inject;

import org.objectweb.asm.tree.AbstractInsnNode;

public class ReplaceNodeInstruction
{
	public final String owner;
	public final String method;
	public final String desc;
	public final int index;
	public final AbstractInsnNode replaceWith;

	public ReplaceNodeInstruction(String var1, String var2, String var3, int var4, AbstractInsnNode var5)
	{
		this.owner = var1;
		this.method = var2;
		this.desc = var3;
		this.index = var4;
		this.replaceWith = var5;
	}
}
