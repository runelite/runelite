package net.runelite.client.plugins.regionlocker;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

class RegionLockerOverlay extends Overlay {
    private static final Color WHITE_TRANSLUCENT = new Color(255, 255, 255, 127);
    private static final int LABEL_PADDING = 4;
    private static final int REGION_SIZE = 1 << 6;
    // Bitmask to return first coordinate in region
    private static final int REGION_TRUNCATE = ~((1 << 6) - 1);
    private final Client client;
    private final RegionLockerConfig config;

    @Inject
    private RegionLockerOverlay(Client client, RegionLockerConfig config) {
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_MAP);
        this.client = client;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!config.drawMapOverlay()) return null;

        drawRegionOverlay(graphics);
        return null;
    }

    private void drawRegionOverlay(Graphics2D graphics) {
        RenderOverview ro = client.getRenderOverview();
        Widget map = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);
        Float pixelsPerTile = ro.getWorldMapZoom();

        if (map == null) return;

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

        Point mousePos = client.getMouseCanvasPosition();

        for (int x = xRegionMin; x < xRegionMax; x += REGION_SIZE)
        {
            for (int y = yRegionMin; y < yRegionMax; y += REGION_SIZE)
            {

                int yTileOffset = -(yTileMin - y);
                int xTileOffset = x + widthInTiles / 2 - worldMapPosition.getX();

                int xPos = ((int) (xTileOffset * pixelsPerTile)) + (int) worldMapRect.getX();
                int yPos = (worldMapRect.height - (int) (yTileOffset * pixelsPerTile)) + (int) worldMapRect.getY();
                // Offset y-position by a single region to correct for drawRect starting from the top
                yPos -= regionPixelSize;


                int regionId = ((x >> 6) << 8) | (y >> 6);
                String regionText = String.valueOf(regionId);
                FontMetrics fm = graphics.getFontMetrics();
                Rectangle2D textBounds = fm.getStringBounds(regionText, graphics);
                int labelWidth = (int) textBounds.getWidth() + 2 * LABEL_PADDING;
                int labelHeight = (int) textBounds.getHeight() + 2 * LABEL_PADDING;
                //graphics.fillRect(xPos, yPos, labelWidth, labelHeight);
                Rectangle regionRect = new Rectangle(xPos, yPos, regionPixelSize, regionPixelSize);
                if (RegionLocker.hasRegion(regionId) ^ config.invertMapOverlay() || RegionLocker.isUnlockable(regionId)) {

                    Color color;
                    if (RegionLocker.isUnlockable(regionId))
                        color = config.unlockableOverlayColor();
                    else
                        color = config.mapOverlayColor();
                    int alpha = Math.max(0, Math.min(255, config.mapOverlayAlpha()));
                    color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
                    if (regionRect.contains(mousePos.getX(), mousePos.getY()))
                        color = color.brighter();
                    graphics.setColor(color);
                    graphics.fillRect(xPos, yPos, regionPixelSize, regionPixelSize);
                }

                graphics.setColor(new Color(0, 19, 36, 127));

                if (config.drawMapGrid()) graphics.drawRect(xPos, yPos, regionPixelSize, regionPixelSize);

                graphics.setColor(WHITE_TRANSLUCENT);
                if (config.drawRegionId()) graphics.drawString(regionText, xPos + LABEL_PADDING, yPos + (int) textBounds.getHeight() + LABEL_PADDING);
            }
        }
    }

}
