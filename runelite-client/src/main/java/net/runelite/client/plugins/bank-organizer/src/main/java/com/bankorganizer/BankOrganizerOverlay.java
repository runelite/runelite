package com.bankorganizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class BankOrganizerOverlay extends Overlay
{
    private static final int DEFAULT_FILL_ALPHA = 50;

    private final Client client;
    private final BankOrganizerConfig config;
    private final Map<Integer, List<Color>> markedItems = new HashMap<>();

    @Inject
    public BankOrganizerOverlay(Client client, BankOrganizerConfig config)
    {
        this.client = client;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    public void markItem(int itemId, List<Color> colors)
    {
        if (colors == null || colors.isEmpty())
        {
            return;
        }
        markedItems.put(itemId, colors);
    }

    public void clearMarks()
    {
        markedItems.clear();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.showBoxes())
        {
            return null;
        }

        Widget bankContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER);
        if (bankContainer == null || bankContainer.isHidden())
        {
            return null;
        }

        // Clip drawing to the bank container
        Rectangle bankClip = bankContainer.getBounds();
        Shape oldClip = graphics.getClip();
        graphics.setClip(bankClip);

        int inset = 1;

        for (Widget slot : bankContainer.getDynamicChildren())
        {
            if (slot == null || slot.isHidden())
            {
                continue;
            }

            int itemId = slot.getItemId();
            List<Color> colors = markedItems.get(itemId);
            if (itemId <= 0 || colors == null)
            {
                continue;
            }

            Point loc = slot.getCanvasLocation();
            if (loc == null)
            {
                continue;
            }

            int x = loc.getX() + inset;
            int y = loc.getY() + inset;
            int w = Math.max(0, slot.getWidth() - inset * 2);
            int h = Math.max(0, slot.getHeight() - inset * 2);

            drawMultiColorBox(graphics, x, y, w, h, colors);
        }

        graphics.setClip(oldClip);
        return null;
    }

    private void drawMultiColorBox(Graphics2D g, int x, int y, int w, int h, List<Color> colors)
    {
        int n = Math.max(1, colors.size());
        int base = (n == 0) ? w : w / n;
        int used = 0;

        for (int i = 0; i < n; i++)
        {
            // Ensure the last segment consumes any leftover pixels to avoid gaps
            int segW = (i == n - 1) ? (w - used) : base;
            int segX = x + used;
            used += segW;

            Color c = colors.get(i);
            // Outline (Change?)
            g.setColor(c);
            g.drawRect(segX, y, Math.max(0, segW - 1), Math.max(0, h - 1));
            // Fill (Change?)
            Color fill = new Color(c.getRed(), c.getGreen(), c.getBlue(), DEFAULT_FILL_ALPHA);
            g.setColor(fill);
            g.fillRect(segX, y, segW, h);
        }
    }
}
