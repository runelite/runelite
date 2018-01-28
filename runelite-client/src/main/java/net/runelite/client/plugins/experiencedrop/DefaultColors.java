package net.runelite.client.plugins.experiencedrop;

import java.awt.Color;
import lombok.Getter;

enum DefaultColors
{
	WHITE(new Color(0xFF, 0xFF, 0xFF)),
	LILAC(new Color(0xC8, 0xC8, 0xFF)),
	CYAN(new Color(0x00, 0xFF, 0xFF)),
	JADE(new Color(0xC8, 0xFF, 0xC8)),
	LIME(new Color(0x64, 0xFF, 0x64)),
	YELLOW(new Color(0xFF, 0xFF, 0x40)),
	ORANGE(new Color(0xFF, 0x98, 0x1F)),
	PINK(new Color(0xFF, 0xC8, 0xC8));

	@Getter
	private Color color;

	DefaultColors(Color color)
	{
		this.color = color;
	}
}
