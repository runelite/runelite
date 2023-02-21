package net.runelite.client.plugins.thieving;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.ProgressPieComponent;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ColorUtil;

/**
 * Represents the overlay that shows timers on chests that have been plundered by the player.
 */
@Slf4j
public class ChestOverlay extends Overlay
{
	private final Client client;
	private final ThievingPlugin plugin;
	private final ThievingConfig config;

	private final ItemManager itemManager;

	/**
	 * Colors
	 */
	private Color colorPlundered, colorPlunderedBorder;
	private Color colorFull, colorFullBorder;
	private Color colorTrans, colorTransBorder;


	/**
	 * Overlay settings
	 */
	private final static int MAX_DRAW_DISTANCE = 2350;
	private ChestReadyIndicator chestReadyIndicator;

	@Getter
	@AllArgsConstructor
	public enum ChestReadyIndicator
	{
		ICON("Icon"),
		CIRCLE("Circle"),
		NONE("No indicator");

		private final String name;

		@Override
		public String toString()
		{
			return getName();
		}
	}

	@Inject
	ChestOverlay(Client client, ThievingPlugin plugin, ThievingConfig config, ItemManager itemManager)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.itemManager = itemManager;
	}

	/**
	 * Updates the timer colors.
	 */
	public void updateConfig()
	{
		colorPlunderedBorder = config.getPlunderedChestColor();
		colorPlundered = ColorUtil.colorWithAlpha(colorPlunderedBorder, (int) (colorPlunderedBorder.getAlpha() / 2.5));
		colorFullBorder = config.getFullChestColor();
		colorFull = ColorUtil.colorWithAlpha(colorFullBorder, (int) (colorFullBorder.getAlpha() / 2.5));
		colorTransBorder = config.getTransChestColor();
		colorTrans = ColorUtil.colorWithAlpha(colorTransBorder, (int) (colorTransBorder.getAlpha() / 2.5));
		chestReadyIndicator = config.getChestReadyIndicator();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		updateConfig();
		drawTimers(graphics);
		return null;
	}

	/**
	 * Iterates over all the active chests in the plugin, and draws a circle or a timer on the chest, depending on state
	 */
	private void drawTimers(Graphics2D graphics)
	{
		for (Map.Entry<WorldPoint, ThievableChest.ActiveChest> entry : plugin.getActiveChests().entrySet())
		{
			ThievableChest.ActiveChest activeChest = entry.getValue();

			int chestPlane = activeChest.getObject().getPlane();
			if (chestPlane != client.getPlane())
			{
				continue;
			}

			if (client.getLocalPlayer().getWorldLocation().getRegionID() != activeChest.getRegionID())
			{
				continue;
			}

			if (client.getLocalPlayer().getLocalLocation().distanceTo(activeChest.getObject().getLocalLocation()) > MAX_DRAW_DISTANCE)
			{
				continue;
			}

			switch (activeChest.getState())
			{
				case READY:
					switch (chestReadyIndicator)
					{
						case ICON:
							drawIconOnChest(graphics, activeChest);
							break;
						case CIRCLE:
							drawCircleOnChest(graphics, activeChest, colorFull, colorFullBorder);
							break;
						default:
							break;
					}
					break;
				case TRANS:
					drawCircleOnChest(graphics, activeChest, colorTrans, colorTransBorder);
					break;
				case PLUNDERED:
					drawTimerOnChest(graphics, activeChest, colorPlundered, colorPlunderedBorder);
					break;
			}
		}
	}

	/**
	 * Draws a timer on a given chest
	 */
	private void drawTimerOnChest(Graphics2D graphics, ThievableChest.ActiveChest chest, Color fill, Color border)
	{
		LocalPoint localPoint = LocalPoint.fromWorld(client, chest.getObject().getWorldLocation());
		if (localPoint == null)
		{
			return;
		}

		net.runelite.api.Point loc = Perspective.localToCanvas(client, localPoint, client.getPlane());
		if (loc == null)
		{
			return;
		}
		double timeLeft = 1 - chest.getRemainingTime();

		ProgressPieComponent pie = new ProgressPieComponent();
		pie.setFill(fill);
		pie.setBorderColor(border);
		pie.setPosition(loc);
		pie.setProgress(timeLeft);
		pie.render(graphics);
	}

	/**
	 * Draws a circle on a given chest
	 */
	private void drawCircleOnChest(Graphics2D graphics, ThievableChest.ActiveChest chest, Color fill, Color border)
	{
		if (chest.getObject().getWorldLocation().getPlane() != client.getPlane())
		{
			return;
		}
		LocalPoint localLoc = LocalPoint.fromWorld(client, chest.getObject().getWorldLocation());
		if (localLoc == null)
		{
			return;
		}
		net.runelite.api.Point loc = Perspective.localToCanvas(client, localLoc, client.getPlane());

		ProgressPieComponent pie = new ProgressPieComponent();
		pie.setFill(fill);
		pie.setBorderColor(border);
		pie.setPosition(loc);
		pie.setProgress(1);
		pie.render(graphics);
	}

	private void drawIconOnChest(Graphics2D graphics, ThievableChest.ActiveChest chest)
	{
		if (chest.getObject().getWorldLocation().getPlane() != client.getPlane())
		{
			return;
		}
		LocalPoint localLoc = LocalPoint.fromWorld(client, chest.getObject().getWorldLocation());
		if (localLoc == null)
		{
			return;
		}
		net.runelite.api.Point loc = Perspective.localToCanvas(client, localLoc, client.getPlane());
		if (loc != null)
		{
			AsyncBufferedImage img = itemManager.getImage(chest.getIconID());
			OverlayUtil.renderImageLocation(client, graphics, chest.getObject().getLocalLocation(), img, 0);
		}
	}
}
