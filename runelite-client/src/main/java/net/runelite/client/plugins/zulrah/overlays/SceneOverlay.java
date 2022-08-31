package net.runelite.client.plugins.zulrah.overlays;

import com.google.common.base.Strings;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.SetMultimap;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.Objects;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.config.FontType;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.zulrah.ZulrahConfig;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;
import net.runelite.client.plugins.zulrah.constants.StandLocation;
import net.runelite.client.plugins.zulrah.constants.ZulrahLocation;
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahNpc;
import net.runelite.client.plugins.zulrah.util.OverlayUtils;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class SceneOverlay extends Overlay
{
	private final Client client;
	private final ZulrahPlugin plugin;
	private final ZulrahConfig config;
	private final SkillIconManager skillIconManager;

	@Inject
	private SceneOverlay(Client client, ZulrahPlugin plugin, ZulrahConfig config, SkillIconManager skillIconManager)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.skillIconManager = skillIconManager;
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Font prevFont = graphics.getFont();
		graphics.setFont(config.fontType().getFont());
		if (plugin.getZulrahNpc() != null && !plugin.getZulrahNpc().isDead())
		{
			renderZulrahPhaseTiles(graphics);
			renderStandAndStallTiles(graphics);
			renderPrayerConservation(graphics);
			renderZulrahTicks(graphics);
			renderZulrahTile(graphics);
			renderProjectiles(graphics);
			renderToxicClouds(graphics);
		}

		graphics.setFont(prevFont);
		return null;
	}

	private void renderZulrahPhaseTiles(Graphics2D graphics)
	{
		if (config.phaseDisplayType() != ZulrahConfig.DisplayType.OFF && config.phaseDisplayType() != ZulrahConfig.DisplayType.OVERLAY)
		{
			SetMultimap<ZulrahLocation, MutablePair<String, ZulrahNpc>> zulrahLocationsGrouped = LinkedHashMultimap.create();
			plugin.getZulrahData().forEach((data) -> {
				switch (config.phaseDisplayMode())
				{
					case CURRENT:
						data.getCurrentZulrahNpc().ifPresent((npc) -> {
							zulrahLocationsGrouped.put(npc.getZulrahLocation(), new MutablePair<>("Current", npc));
						});
						break;
					case NEXT:
						data.getNextZulrahNpc().ifPresent((npc) -> {
							zulrahLocationsGrouped.put(npc.getZulrahLocation(), new MutablePair<>(getZulrahNextString(), npc));
						});
						break;
					case BOTH:
						data.getCurrentZulrahNpc().ifPresent((npc) -> {
							zulrahLocationsGrouped.put(npc.getZulrahLocation(), new MutablePair<>("Current", npc));
						});
						data.getNextZulrahNpc().ifPresent((npc) -> {
							zulrahLocationsGrouped.put(npc.getZulrahLocation(), new MutablePair<>(getZulrahNextString(), npc));
						});
						break;
					default:
						throw new IllegalStateException("[SceneOverlay] Invalid 'phaseDisplayMode' config state");
				}

			});
			Iterator location = zulrahLocationsGrouped.keys().iterator();

			while (location.hasNext())
			{
				ZulrahLocation zulrahLocation = (ZulrahLocation) location.next();
				int offset = 0;

				for (Iterator groupedLocation = zulrahLocationsGrouped.get(zulrahLocation).iterator(); groupedLocation.hasNext(); offset += graphics.getFontMetrics().getHeight())
				{
					Pair pair = (Pair) groupedLocation.next();
					drawZulrahTile(graphics, (ZulrahNpc) pair.getRight(), (String) pair.getLeft(), offset);
				}
			}
		}
	}

	private String getZulrahNextString()
	{
		return plugin.getCurrentRotation() != null ? "Next" : "P. Next";
	}

	private void drawZulrahTile(Graphics2D graphics, ZulrahNpc zulrahNpc, String addonText, int offset)
	{
		if (zulrahNpc != null)
		{
			LocalPoint localPoint = zulrahNpc.getZulrahLocation().toLocalPoint();
			Polygon tileAreaPoly = Perspective.getCanvasTileAreaPoly(client, localPoint, 5);
			OverlayUtils.renderPolygon(graphics, tileAreaPoly, zulrahNpc.getType().getColor(), config.outlineWidth(), config.fillAlpha());
			Point basePoint = Perspective.localToCanvas(client, localPoint, client.getPlane(), 0);
			if (basePoint != null)
			{
				int bx = basePoint.getX();
				int by = basePoint.getY();
				String text = getZulrahPhaseString(zulrahNpc, addonText);
				Rectangle2D textBounds = graphics.getFontMetrics().getStringBounds(text, graphics);
				Point textLocation = new Point(bx - (int) textBounds.getWidth() / 2, by - offset);
				Color color = zulrahNpc.getType().getColor();
				ZulrahConfig config = this.config;
				Objects.requireNonNull(config);
				OverlayUtils.renderTextLocation(graphics, textLocation, text, color, config::textOutline);
				if (this.config.phaseHats())
				{
					BufferedImage icon = skillIconManager.getSkillImage(zulrahNpc.getType().getSkill(), this.config
							.fontType() != FontType.BOLD);
					int imgPX = bx - icon.getWidth() / 2;
					int imgPY = by - icon.getHeight() / 2 - offset;
					Point imgPoint = new Point(imgPX, imgPY);
					int imgX = imgPoint.getX() - graphics.getFontMetrics().stringWidth(text) / 2 - 15;
					int imgY = imgPoint.getY() - icon.getHeight() / 2 + 1;
					graphics.drawImage(icon, imgX, imgY, (ImageObserver) null);
				}
			}

		}
	}

	private String getZulrahPhaseString(ZulrahNpc npc, String addonText)
	{
		boolean strip = !config.phaseTags() || Strings.isNullOrEmpty(addonText);
		if (npc.isJad())
		{
			return strip ? "Jad" : "[" + addonText + "] Jad";
		}
		else
		{
			return strip ? npc.getType().getName() : "[" + addonText + "] " + npc.getType().getName();
		}
	}

	private void renderStandAndStallTiles(Graphics2D graphics)
	{
		if (config.standLocations() || config.stallLocations())
		{
			SetMultimap standLocationsGrouped = HashMultimap.create();
			plugin.getZulrahData().forEach((data) -> {
				if (config.standLocations())
				{
					if (data.standLocationsMatch())
					{
						data.getCurrentDynamicStandLocation().ifPresent((loc) -> {
							standLocationsGrouped.put(loc, new MutablePair("Stand / Next", config.standAndNextTileColor()));
						});
					}
					else
					{
						data.getCurrentDynamicStandLocation().ifPresent((loc) -> {
							standLocationsGrouped.put(loc, new MutablePair("Stand", config.standTileColor()));
						});
						data.getNextStandLocation().ifPresent((loc) -> {
							standLocationsGrouped.put(loc, new MutablePair("Next", config.nextTileColor()));
						});
					}
				}

				if (config.stallLocations())
				{
					data.getCurrentStallLocation().ifPresent((loc) -> {
						standLocationsGrouped.put(loc, new MutablePair("Stall", config.stallTileColor()));
					});
					data.getNextStallLocation().ifPresent((loc) -> {
						standLocationsGrouped.put(loc, new MutablePair("Stall / next", config.nextTileColor()));
					});
				}

			});
			Iterator location = standLocationsGrouped.keys().iterator();

			while (location.hasNext())
			{
				StandLocation standLocation = (StandLocation) location.next();
				int offset = 0;

				for (Iterator locationGrouped = standLocationsGrouped.get(standLocation).iterator(); locationGrouped.hasNext(); offset += graphics.getFontMetrics().getHeight())
				{
					Pair pair = (Pair) locationGrouped.next();
					drawTile(graphics, standLocation.toLocalPoint(), (String) pair.getLeft(), (Color) pair.getRight(), offset);
				}
			}

		}
	}

	private void drawTile(Graphics2D graphics, LocalPoint localPoint, String text, Color color, int offset)
	{
		if (localPoint != null && !Strings.isNullOrEmpty(text))
		{
			Point textLocation = Perspective.getCanvasTextLocation(client, graphics, localPoint, text, 0);
			Point txtLoc = new Point(textLocation.getX(), textLocation.getY() - offset);
			Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue());
			ZulrahConfig config = this.config;
			Objects.requireNonNull(config);
			OverlayUtils.renderTextLocation(graphics, txtLoc, text, color2, config::textOutline);
			Polygon tilePoly = Perspective.getCanvasTilePoly(client, localPoint);
			OverlayUtils.renderPolygon(graphics, tilePoly, color, this.config.outlineWidth(), this.config.fillAlpha());
		}
	}

	private void renderPrayerConservation(Graphics2D graphics)
	{
		if (config.prayerConservation())
		{
			Player player = client.getLocalPlayer();
			if (player != null && (plugin.getZulrahNpc().getInteracting() == null || plugin.getZulrahNpc().getInteracting() != client.getLocalPlayer()) && player.getOverheadIcon() != null)
			{
				String conserveStr = "Turn off overheads to conserve prayer!";
				Point textLocation = player.getCanvasTextLocation(graphics, "Turn off overheads to conserve prayer!", player.getLogicalHeight() - 22);
				Color color = Color.RED;
				ZulrahConfig config = this.config;
				Objects.requireNonNull(config);
				OverlayUtils.renderTextLocation(graphics, textLocation, "Turn off overheads to conserve prayer!", color, config::textOutline);
			}

		}
	}

	private void renderZulrahTicks(Graphics2D graphics)
	{
		if (config.phaseTickCounter() || config.attackTickCounter())
		{
			StringBuilder sb = new StringBuilder();
			sb = sb.append(config.phaseTickCounter() && plugin.getPhaseTicks() >= 0 ? plugin.getPhaseTicks() : "").append(config.phaseTickCounter() && config.attackTickCounter() && plugin.getPhaseTicks() >= 0 && plugin.getAttackTicks() >= 0 ? " : " : "").append(config.attackTickCounter() && plugin.getAttackTicks() >= 0 ? plugin.getAttackTicks() : "");
			if (!Strings.isNullOrEmpty(sb.toString()))
			{
				Point textLocation = plugin.getZulrahNpc().getCanvasTextLocation(graphics, sb.toString(), plugin.getZulrahNpc().getLogicalHeight() - 130);
				String string = sb.toString();
				Color tickCounterColors = config.tickCounterColors();
				ZulrahConfig config = this.config;
				Objects.requireNonNull(config);
				OverlayUtils.renderTextLocation(graphics, textLocation, string, tickCounterColors, config::textOutline);
			}
		}
	}

	private void renderZulrahTile(Graphics2D graphics)
	{
		if (config.displayZulrahTile())
		{
			Polygon tileAreaPoly = Perspective.getCanvasTileAreaPoly(client, plugin.getZulrahNpc().getLocalLocation(), 5);
			OverlayUtils.renderPolygon(graphics, tileAreaPoly, config.zulrahTileColor(), config.outlineWidth(), config.fillAlpha());
		}
	}

	private void renderProjectiles(Graphics2D graphics)
	{
		if (config.displayProjectiles() && plugin.getProjectilesMap().size() > 0)
		{
			plugin.getProjectilesMap().forEach((localPoint, ticks) -> {
				Point textLocation = Perspective.getCanvasTextLocation(client, graphics, localPoint, "#", 0);
				String string = Integer.toString(ticks);
				Color color = ticks > 0 ? Color.WHITE : Color.RED;
				ZulrahConfig config = this.config;
				Objects.requireNonNull(config);
				OverlayUtils.renderTextLocation(graphics, textLocation, string, color, config::textOutline);
				Polygon tilePoly = Perspective.getCanvasTilePoly(client, localPoint);
				OverlayUtils.renderPolygon(graphics, tilePoly, this.config.projectilesColor(), this.config.outlineWidth(), this.config
						.fillAlpha());
			});
		}
	}

	private void renderToxicClouds(Graphics2D graphics)
	{
		if (!config.displayToxicClouds() || plugin.getToxicCloudsMap().size() <= 0)
		{
			return;
		}
		plugin.getToxicCloudsMap().forEach((obj, ticks) -> {
			LocalPoint localPoint = obj.getLocalLocation();
			Polygon tileAreaPoly = Perspective.getCanvasTileAreaPoly(client, localPoint, 3);
			OverlayUtils.renderPolygon(graphics, tileAreaPoly, config.toxicCloudsColor(), config.outlineWidth(), config.fillAlpha());
			String ticksString = Integer.toString(ticks);
			Point textLocation = Perspective.getCanvasTextLocation(client, graphics, localPoint, ticksString, 0);
			OverlayUtils.renderTextLocation(graphics, textLocation, ticksString, ticks > 0 ? Color.RED : Color.GREEN, config::textOutline);
		});
	}
}
