package net.runelite.runeloader.inject;

public class GetterInjectInstruction
{
	private final String className;
	private final String getterMethodDesc;
	private final String getterName;
	private final String getterClassName;
	private final String getterFieldName;
	private final Integer multiplier;
	private final boolean staticField;

	public GetterInjectInstruction(String var1, String var2, String var3, String var4, String var5, Integer var6, boolean var7)
	{
		this.className = var1;
		this.getterMethodDesc = "()" + var3;
		this.getterName = var2;
		this.getterClassName = var4;
		this.getterFieldName = var5;
		this.multiplier = var6;
		this.staticField = var7;
	}

	@Override
	public String toString()
	{
		return "GetterInjectInstruction{" + "className=" + className + ", getterMethodDesc=" + getterMethodDesc + ", getterName=" + getterName + ", getterClassName=" + getterClassName + ", getterFieldName=" + getterFieldName + ", multiplier=" + multiplier + ", staticField=" + staticField + '}';
	}

	public String getClassName()
	{
		return this.className;
	}

	public String getGetterMethodDesc()
	{
		return this.getterMethodDesc;
	}

	public String getGetterName()
	{
		return this.getterName;
	}

	public String getGetterClassName()
	{
		return this.getterClassName;
	}

	public String getGetterFieldName()
	{
		return this.getterFieldName;
	}

	public Integer getMultiplier()
	{
		return this.multiplier;
	}

	public boolean isStaticField()
	{
		return this.staticField;
	}
}
