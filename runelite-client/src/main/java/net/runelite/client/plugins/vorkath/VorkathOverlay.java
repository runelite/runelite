package net.runelite.client.plugins.vorkath;

import java.awt.*;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class VorkathOverlay extends Overlay {
	private final VorkathConfig config;
	private final VorkathPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();


	@Inject
	private Client client;

	@Inject
	private VorkathOverlay(VorkathConfig config, VorkathPlugin plugin) {
		this.config = config;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
		panelComponent.setPreferredSize(new Dimension(150, 0));
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if (!config.EnableVorkath()) {
			return null;
		}
		Actor local = client.getLocalPlayer();

		WorldArea area = local.getWorldArea();
		if (area == null)
		{
			return null;
		}

		NPC Vorkath = plugin.Vorkath;
		if (Vorkath != null) {
			if (plugin.fireball != null) {
				if (config.TileHighlight() == TileHighlight.Single) {
					final Polygon poly = Perspective.getCanvasTilePoly(client, plugin.fireball);
					if (poly != null) {
						OverlayUtil.renderPolygon(graphics, poly, Color.RED);
					}
				} else if (config.TileHighlight() == TileHighlight.All) {
					for (int dx = -1; dx <= 1; dx++) {
						for (int dy = -1; dy <= 1; dy++) {
							if (dx == 0 && dy == 0) {
								continue;
							}
							LocalPoint lp = new LocalPoint(plugin.fireball.getX() + dx * Perspective.LOCAL_TILE_SIZE + dx * Perspective.LOCAL_TILE_SIZE * (area.getWidth() - 1) / 2, plugin.fireball.getY() + dy * Perspective.LOCAL_TILE_SIZE + dy * Perspective.LOCAL_TILE_SIZE * (area.getHeight() - 1) / 2);
							Polygon polyadj = Perspective.getCanvasTilePoly(client, lp);
							if (polyadj != null) {
								OverlayUtil.renderPolygon(graphics, polyadj, Color.ORANGE);
							}
						}
					}
				}
			}

			if (config.BoldText()) {
				graphics.setFont(FontManager.getRunescapeBoldFont());
			}

			if (plugin.venomticks != 0) {
				if (plugin.venomticks + 5 <= plugin.ticks) {
					OverlayUtil.renderTextLocation(graphics, Vorkath.getCanvasTextLocation(graphics, Integer.toString(30 - (plugin.ticks - plugin.venomticks)), Vorkath.getLogicalHeight() + 150), Integer.toString(30 - (plugin.ticks - plugin.venomticks)), Color.ORANGE);
				}
			}

			OverlayUtil.renderTextLocation(graphics, Vorkath.getCanvasTextLocation(graphics, Integer.toString(7 - plugin.hits), Vorkath.getLogicalHeight() + 40), Integer.toString(7 - plugin.hits), config.CounterColor());
			graphics.setFont(FontManager.getRunescapeFont());
		}
		return null;
	}
}
