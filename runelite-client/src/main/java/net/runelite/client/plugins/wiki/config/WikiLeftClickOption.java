package net.runelite.client.plugins.wiki.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WikiLeftClickOption
{
	LOOKUP("Lookup"),
	SEARCH("Search");

	private final String option;

	@Override
	public String toString()
	{
		return option;
	}
}
