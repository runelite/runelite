package net.runelite.runeloader.inject;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;

public class AddMethodInstruction
{
	private final String clientClass;
	private final String methodName;
	private final String methodDesc;
	private final AbstractInsnNode[] instructions;

	public AddMethodInstruction(String var1, String var2, String var3, AbstractInsnNode[] var4)
	{
		this.clientClass = var1;
		this.methodName = var2;
		this.methodDesc = var3;
		this.instructions = var4;
	}

	public boolean valid(ClassNode var1)
	{
		return var1.name.equalsIgnoreCase(this.clientClass);
	}
}
