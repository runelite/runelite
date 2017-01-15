package net.runelite.runeloader.inject;

public class AddFieldInstruction
{
	public String owner;
	public String name;
	public String desc;
	public int access;

	public AddFieldInstruction(String var1, String var2, String var3, int var4)
	{
		this.owner = var1;
		this.name = var2;
		this.desc = var3;
		this.access = var4;
	}
}
