package net.runelite.client.plugins.clock.config;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum HourFormat
{
	TWELVE("12-Hour"),
	TWENTYFOUR("24-Hour");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}