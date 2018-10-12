package net.runelite.client.plugins.worldhopper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.Point;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.WORLD_MAP_ORB;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.api.Actor;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TextComponent;


@Singleton
public class WorldHopperOverlay extends Overlay
{
	@Inject
	private Client client;

	@Inject
	private WorldHopperOverlay()
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGHEST);
	}

	// TODO: onWorldHopChange event in Plugin, update some manager/variable, and just display here
	// 	     instead of getting world number every time from client. Not sure if this exists tho.

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Get orb location
		Widget widget = client.getWidget(WidgetInfo.WORLD_MAP_ORB);


		if (widget != null && !widget.isHidden())
		{
			String world = Integer.toString(client.getWorld());
			Point worldOverlayLocation = widget.getCanvasLocation();
			int x = worldOverlayLocation.getX();
			int y = worldOverlayLocation.getY();
//			int width = widget.getWidth();
			int height = widget.getHeight();
			int fontSize = 18;
			int pixelSize = fontSize * 4 / 3;

			Font currentFont = graphics.getFont();
			graphics.setFont(new Font("Arial", Font.BOLD, fontSize));

			graphics.setColor(Color.BLACK);
			graphics.drawString(world, x + 1, y + height - pixelSize / 2 + 1);
			graphics.setColor(Color.WHITE);
			graphics.drawString(world, x, y + height - pixelSize / 2);
		}

		return null;
	}

}