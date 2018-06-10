package net.runelite.client.plugins.masterfarmer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.temporal.ChronoUnit;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.Timer;

public class MasterFarmerTimer extends Timer
{

	public MasterFarmerTimer(Plugin plugin, BufferedImage image)
	{
		super(5, ChronoUnit.MINUTES, image, plugin);
	}

	public Color getTextColor()
	{
		if (this.getText().matches("0:[012]\\d"))
		{
			return Color.RED;
		}
		else if (this.getText().matches("[01]:\\d\\d"))
		{
			return Color.ORANGE;
		}
		else
		{
			return Color.WHITE;
		}
	}

}
