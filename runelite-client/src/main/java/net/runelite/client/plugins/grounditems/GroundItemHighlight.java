package net.runelite.client.plugins.grounditems;

import lombok.Getter;

import java.awt.*;

@Getter
public class GroundItemHighlight
{
	private final String name;
	private final Color color;

	public GroundItemHighlight(String name, Color color)
	{
		this.color = color;
		this.name = name;
	}

}
