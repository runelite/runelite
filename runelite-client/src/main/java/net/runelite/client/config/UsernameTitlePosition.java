package net.runelite.client.config;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UsernameTitlePosition
{
	OFF("Off"),
	PREFIX("Before title"),
	SUFFIX("After title");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
