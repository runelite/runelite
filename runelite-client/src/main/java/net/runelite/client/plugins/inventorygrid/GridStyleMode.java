package net.runelite.client.plugins.inventorygrid;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GridStyleMode
{
	FILL("Fill"),
	OUTLINE("Outline");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}