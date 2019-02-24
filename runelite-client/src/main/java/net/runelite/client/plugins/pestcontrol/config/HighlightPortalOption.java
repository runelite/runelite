package net.runelite.client.plugins.pestcontrol.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HighlightPortalOption
{
	OFF("Off"),
	ACTIVE("Active"),
	SHIELDED("Shielded"),
	ALL("All");

	private final String option;

	@Override
	public String toString()
	{
		return option;
	}
}
