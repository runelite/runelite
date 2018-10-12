package net.runelite.client.plugins.worldhopper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import net.runelite.api.Client;
import net.runelite.api.Point;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.api.widgets.WidgetInfo.WORLD_MAP_VIEW;
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
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Get orb location
		Widget widget = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

		if (widget != null && !widget.isHidden())
		{
			// Render world
//			final TextComponent textComponent = new TextComponent();
//			textComponent.setColor(Color.WHITE);
//			textComponent.setText(Integer.toString(client.getWorld()));
//			textComponent.setPosition(new java.awt.Point(imageLocation.getX(), imageLocation.getY()));
//			textComponent.render(graphics);
			widget.setText(Integer.toString(client.getWorld()));
		}

		return null;
	}

}