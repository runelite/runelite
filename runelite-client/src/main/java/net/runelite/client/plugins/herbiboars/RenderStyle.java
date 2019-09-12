package net.runelite.client.plugins.herbiboars;

public enum RenderStyle
{
	THIN_OUTLINE("Thin outline"),
	OUTLINE("Outline"),
	THIN_GLOW("Thin glow"),
	GLOW("Glow");

	private final String name;

	RenderStyle(final String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
