package net.runelite.client.plugins.pestcontrol;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.plugins.pestcontrol.config.HighlightPortalOption;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

@Slf4j
public class PortalOverlay extends Overlay
{
	private final PestControlConfig config;
	private final PestControlPlugin plugin;
	private final Client client;

	@Inject
	PortalOverlay(PestControlConfig config, PestControlPlugin plugin, Client client)
	{
		this.config = config;
		this.plugin = plugin;
		this.client = client;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if(config.highlightPortals() == HighlightPortalOption.OFF){
			return null;
		}

		boolean highlightActivePortals = (
			config.highlightPortals() == HighlightPortalOption.ACTIVE ||
				config.highlightPortals() == HighlightPortalOption.ALL
		);

		boolean highlightShieldedPortals = (
			config.highlightPortals() == HighlightPortalOption.SHIELDED ||
				config.highlightPortals() == HighlightPortalOption.ALL
		);

		Point mousePosition = client.getMouseCanvasPosition();

		for(NPC npc : client.getNpcs())
		{
			if(!PestControlPlugin.isPortal(npc.getId()))
			{
				continue;
			}

			if(!(PestControlPlugin.isActivePortal(npc.getId()) && highlightActivePortals) &&
					!(PestControlPlugin.isShieldedPortal(npc.getId()) && highlightShieldedPortals)
			)
			{
				continue;
			}

			Color color = PestControlPlugin.isActivePortal(npc.getId()) ?
				config.activePortalColor() :
				config.shieldedPortalColor();

			Polygon objectClickbox = npc.getConvexHull();
			if (objectClickbox != null)
			{
				graphics.setColor(color);
				graphics.setStroke(new BasicStroke(2));
				graphics.draw(objectClickbox);
				graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
				graphics.fill(objectClickbox);
			}
		}

		return null;
	}
}