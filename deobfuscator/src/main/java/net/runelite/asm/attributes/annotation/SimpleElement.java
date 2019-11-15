package net.runelite.asm.attributes.annotation;

public class SimpleElement extends Element<Object>
{
	public SimpleElement(Object value)
	{
		this.value = value;
	}

	public SimpleElement(String name, Object value)
	{
		this.name = name;
		this.value = value;
	}
}
