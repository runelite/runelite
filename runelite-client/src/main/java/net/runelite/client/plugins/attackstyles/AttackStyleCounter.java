package net.runelite.client.plugins.attackstyles;

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.Setter;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.Counter;

@Setter
public class AttackStyleCounter extends Counter
{
	private String tooltip;

	AttackStyleCounter(BufferedImage image, Plugin plugin, String text)
	{
		super(image, plugin, text);
	}

	@Override
	public String getTooltip()
	{
		return tooltip;
	}

	@Override
	public Color getTextColor()
	{
		return Color.RED;
	}
}