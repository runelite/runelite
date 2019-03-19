package net.runelite.client.plugins.statustrayicon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusNumberMode
{
	HITPOINTS("Hitpoints"),
	PRAYER("Prayer"),
	NONE("None");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
