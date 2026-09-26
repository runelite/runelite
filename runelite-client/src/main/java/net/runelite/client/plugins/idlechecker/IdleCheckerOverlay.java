
package net.runelite.client.plugins.idlechecker;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class IdleCheckerOverlay extends Overlay
{
	private final IdleCheckerPlugin plugin;
	private final IdleCheckerConfig config;
	private boolean flash;

	@Inject
	private IdleCheckerOverlay(IdleCheckerPlugin plugin, IdleCheckerConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		setPosition(OverlayPosition.TOP_LEFT);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(PRIORITY_HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Color color;
		if (plugin.isInventoryFull())
		{
			if (config.flashOnFull())
			{
				flash = !flash;
				color = flash ? config.getFullInventoryColor() : Color.BLACK;
			}
			else
			{
				color = config.getFullInventoryColor();
			}
		}
		else if (plugin.isIdle())
		{
			color = config.getIdleColor();
		}
		else
		{
			color = config.getActiveColor();
		}

		graphics.setColor(color);

		int size = config.getOverlaySize();
		switch (config.getOverlayShape())
		{
			case SQUARE:
				graphics.fillRect(0, 0, size, size);
				break;
			case CIRCLE:
				graphics.fillOval(0, 0, size, size);
				break;
		}

		return new Dimension(size, size);
	}
}
