package net.runelite.client.plugins.pestcontrol.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NpcHighlightStyle
{
	OFF("Off"),
	TILE("Tile"),
	HULL("Hull"),
	BOTH("Hull + Tile");

	private final String style;

	@Override
	public String toString()
	{
		return style;
	}
}
