package net.runelite.client.plugins.inferno;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum InfernoPrayerOverlayMode
{
	PRAYER_TAB("Prayer Tab"),
	BOTTOM_RIGHT("Bottom Right"),
	BOTH("Both");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
