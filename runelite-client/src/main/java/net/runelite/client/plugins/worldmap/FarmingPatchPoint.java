package net.runelite.client.plugins.worldmap;

import java.awt.image.BufferedImage;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;

class FarmingPatchPoint extends WorldMapPoint
{

	FarmingPatchPoint(FarmingPatchLocation data, BufferedImage icon)
	{
		super(data.getLocation(), icon);
		setTooltip(data.getTooltip());
	}
}
