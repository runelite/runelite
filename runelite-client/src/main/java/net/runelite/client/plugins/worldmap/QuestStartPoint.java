package net.runelite.client.plugins.worldmap;

import lombok.Getter;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import java.awt.image.BufferedImage;

public class QuestStartPoint extends WorldMapPoint
{
	@Getter
	private QuestStartLocation data;

	QuestStartPoint(QuestStartLocation data, BufferedImage icon)
	{
		super(data.getLocation(), icon);

		this.data = data;
		setTooltip(data.getTooltip());
	}
}
