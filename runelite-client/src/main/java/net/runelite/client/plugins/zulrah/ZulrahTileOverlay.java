package net.runelite.client.plugins.zulrah;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class ZulrahTileOverlay extends Overlay
{
	private final ZulrahConfig config;
	private final ZulrahPlugin plugin;

	@Inject
	private Client client;

	@Inject
	private ZulrahTileOverlay(ZulrahConfig config, ZulrahPlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.MED);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		NPC Zulrah = plugin.Zulrah;
		if (Zulrah != null) {
			OverlayUtil.renderTextLocation(graphics, Zulrah.getCanvasTextLocation(graphics, Integer.toString(plugin.phaseticks - plugin.ticks), Zulrah.getLogicalHeight() + 40), Integer.toString(plugin.phaseticks - plugin.ticks), Color.WHITE);
			Player player = client.getLocalPlayer();
			if (plugin.currenttile != null) {
				if (plugin.currenttile.equals(plugin.nexttile)) {
					final Polygon poly = Perspective.getCanvasTilePoly(client, plugin.currenttile);
					if (poly != null) {
						Point textLocationtile = Perspective.getCanvasTextLocation(client, graphics, plugin.currenttile, "Current & Next", 50);
						OverlayUtil.renderTextLocation(graphics, textLocationtile, "Current & Next", Color.WHITE);
						OverlayUtil.renderPolygon(graphics, poly, Color.WHITE);
					}
				} else {
					if (!player.getLocalLocation().equals(plugin.currenttile)) {
						final Polygon poly = Perspective.getCanvasTilePoly(client, plugin.currenttile);
						if (poly != null) {
							Point textLocationtile = Perspective.getCanvasTextLocation(client, graphics, plugin.currenttile, "Current", 50);
							OverlayUtil.renderTextLocation(graphics, textLocationtile, "Current", Color.WHITE);
							OverlayUtil.renderPolygon(graphics, poly, Color.GREEN);
						}
					}
					if (plugin.nexttile != null) {
						final Polygon poly2 = Perspective.getCanvasTilePoly(client, plugin.nexttile);
						if (poly2 != null) {
							Point textLocationtile = Perspective.getCanvasTextLocation(client, graphics, plugin.nexttile, "Next", 50);
							OverlayUtil.renderTextLocation(graphics, textLocationtile, "Next", Color.WHITE);
							OverlayUtil.renderPolygon(graphics, poly2, Color.RED);
						}
					}
				}
			}
			if (plugin.nextzulrahtile != null) {
				String style = "";
				if (plugin.nztcolor.equals(Color.RED)) {
					style = "MELEE";
				} else if (plugin.nztcolor.equals(Color.BLUE)) {
					style = "MAGE";
				} else if (plugin.nztcolor.equals(Color.GREEN)) {
					style = "RANGE";
				} else if (plugin.nztcolor.equals(Color.YELLOW)) {
					style = "JAD";
				}

				final Polygon poly = Perspective.getCanvasTilePoly(client, plugin.nextzulrahtile);
				Point textLocation = Perspective.getCanvasTextLocation(client, graphics, plugin.nextzulrahtile, style, 200);
				if (poly != null)
				{
					BufferedImage clanchatImage = null;
					if (style.equals("JAD")) {
						if (plugin.phase4 && plugin.phases.size() == 10) {
							clanchatImage = plugin.ProtectionIcons[2];
						} else if (plugin.phase3 && plugin.phases.size() == 9) {
							clanchatImage = plugin.ProtectionIcons[2];
						} else {
							clanchatImage = plugin.ProtectionIcons[0];
						}
					} else {
						clanchatImage = plugin.getProtectionIcon();
					}

					if (clanchatImage != null) {
						Point imageLocation = new Point(textLocation.getX(), textLocation.getY() + 15);
						OverlayUtil.renderImageLocation(graphics, imageLocation, clanchatImage);
					}

					graphics.setFont(FontManager.getRunescapeBoldFont());
					OverlayUtil.renderTextLocation(graphics, textLocation, style, Color.WHITE);
					OverlayUtil.renderPolygon(graphics, poly, plugin.nztcolor);
				}
			}
			if (plugin.MeleeTile != null) {
				final Polygon poly = Perspective.getCanvasTilePoly(client, plugin.MeleeTile);
				if (poly != null) {
					Point textLocationtile = Perspective.getCanvasTextLocation(client, graphics, plugin.MeleeTile, "MOVE HERE NOW!", 50);
					graphics.setFont(FontManager.getRunescapeBoldFont());
					OverlayUtil.renderTextLocation(graphics, textLocationtile, "MOVE HERE NOW!", Color.WHITE);
					OverlayUtil.renderPolygon(graphics, poly, Color.BLACK);
				}
			}
		}
		return null;
	}
}
