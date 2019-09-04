package net.runelite.client.plugins.slayerarea;

import java.awt.image.BufferedImage;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;

public class SlayerAreaPoint extends WorldMapPoint
{
	public SlayerAreaPoint(WorldPoint point, String tooltip, BufferedImage icon)
	{
		super(point, icon);
		setTooltip(tooltip);
	}
}
