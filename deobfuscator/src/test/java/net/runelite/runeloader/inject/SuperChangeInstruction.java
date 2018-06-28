package net.runelite.runeloader.inject;

import org.objectweb.asm.tree.ClassNode;

public class SuperChangeInstruction
{
	private final String clientName;
	private final String superName;

	public SuperChangeInstruction(String var1, String var2)
	{
		this.clientName = var1;
		this.superName = var2;
	}

	public String getClientName()
	{
		return this.clientName;
	}

	public String getSuperName()
	{
		return this.superName;
	}

	public boolean valid(ClassNode var1)
	{
		return var1.name.equalsIgnoreCase(this.clientName);
	}

	public void inject(ClassNode var1)
	{
		var1.superName = this.superName;
	}
}
