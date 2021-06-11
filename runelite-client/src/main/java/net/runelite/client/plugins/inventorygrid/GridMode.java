package net.runelite.client.plugins.inventorygrid;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GridMode
{
	WHILE_DRAGGING("While dragging"),
	ALWAYS("Always"),
	NEVER("Never");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}