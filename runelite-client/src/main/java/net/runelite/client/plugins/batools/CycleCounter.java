package net.runelite.client.plugins.batools;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.Counter;

import java.awt.image.BufferedImage;

public class CycleCounter extends Counter
{
	public CycleCounter(BufferedImage img, Plugin plugin, int tick)
	{
		super(img, plugin, tick);
	}
}