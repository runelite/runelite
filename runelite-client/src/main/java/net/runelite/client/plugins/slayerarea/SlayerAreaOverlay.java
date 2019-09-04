package net.runelite.client.plugins.slayerarea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class SlayerAreaOverlay extends Overlay
{
	private static final Color WHITE_TRANSLUCENT = new Color(255, 255, 255, 127);
	private static final int LABEL_PADDING = 4;
	private static final int REGION_SIZE = 1 << 6;
	// Bitmask to return first coordinate in region
	private static final int REGION_TRUNCATE = ~((1 << 6) - 1);
	private final Client client;
	private final SlayerAreaPlugin plugin;

	@Inject
	private SlayerAreaOverlay(Client client, SlayerAreaPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ABOVE_MAP);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!SlayerAreas.configLockedMap)
		{
			return null;
		}

		//drawRegionOverlay(graphics);
		return null;
	}

	private void drawRegionOverlay(Graphics2D graphics)
	{
		RenderOverview ro = client.getRenderOverview();
		Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
		Float pixelsPerTile = ro.getWorldMapZoom();

		if (map == null)
		{
			return;
		}

		Rectangle worldMapRect = map.getBounds();
		graphics.setClip(worldMapRect);

		int widthInTiles = (int) Math.ceil(worldMapRect.getWidth() / pixelsPerTile);
		int heightInTiles = (int) Math.ceil(worldMapRect.getHeight() / pixelsPerTile);

		Point worldMapPosition = ro.getWorldMapPosition();

		// Offset in tiles from anchor sides
		int yTileMin = worldMapPosition.getY() - heightInTiles / 2;
		int xRegionMin = (worldMapPosition.getX() - widthInTiles / 2) & REGION_TRUNCATE;
		int xRegionMax = ((worldMapPosition.getX() + widthInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;
		int yRegionMin = (yTileMin & REGION_TRUNCATE);
		int yRegionMax = ((worldMapPosition.getY() + heightInTiles / 2) & REGION_TRUNCATE) + REGION_SIZE;
		int regionPixelSize = (int) Math.ceil(REGION_SIZE * pixelsPerTile);

		for (int x = xRegionMin; x < xRegionMax; x += REGION_SIZE)
		{
			for (int y = yRegionMin; y < yRegionMax; y += REGION_SIZE)
			{
				graphics.setColor(new Color(0, 19, 36, 127));

				int yTileOffset = -(yTileMin - y);
				int xTileOffset = x + widthInTiles / 2 - worldMapPosition.getX();

				int xPos = ((int) (xTileOffset * pixelsPerTile)) + (int) worldMapRect.getX();
				int yPos = (worldMapRect.height - (int) (yTileOffset * pixelsPerTile)) + (int) worldMapRect.getY();
				// Offset y-position by a single region to correct for drawRect starting from the top
				yPos -= regionPixelSize;

				graphics.drawRect(xPos, yPos, regionPixelSize, regionPixelSize);

				int regionId = ((x >> 6) << 8) | (y >> 6);
				String regionText = String.valueOf(regionId);
				FontMetrics fm = graphics.getFontMetrics();
				Rectangle2D textBounds = fm.getStringBounds(regionText, graphics);
				int labelWidth = (int) textBounds.getWidth() + 2 * LABEL_PADDING;
				int labelHeight = (int) textBounds.getHeight() + 2 * LABEL_PADDING;
				//graphics.fillRect(xPos, yPos, labelWidth, labelHeight);

				SlayerArea area = SlayerAreas.getArea(regionId);
				if (area == null || !area.unlocked)
				{
					Color color;
					if (area == null || area.strongest == null || area.strongest.equals(""))
						color = new Color(72, 38, 0, 161);
					else
						color = new Color(0, 38, 72, 161);
					graphics.setColor(color);
					graphics.fillRect(xPos, yPos, regionPixelSize, regionPixelSize);
				}
				graphics.setColor(WHITE_TRANSLUCENT);
				if (SlayerAreas.configRegionId)
					graphics.drawString(regionText, xPos + LABEL_PADDING, yPos + (int) textBounds.getHeight() + LABEL_PADDING);
			}
		}
	}
}

