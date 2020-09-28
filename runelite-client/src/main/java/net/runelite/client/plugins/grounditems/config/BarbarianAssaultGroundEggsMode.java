package net.runelite.client.plugins.grounditems.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BarbarianAssaultGroundEggsMode
{
	CALLED("Called"),
	ALL("All"),
	DISABLED("Disabled");

	private final String name;

	@Override
	public String toString()
	{
		return name;
	}
}
