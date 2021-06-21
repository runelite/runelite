package net.runelite.client.plugins.invalue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Query;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.util.QueryRunner;



public class InventoryValueOverlay extends Overlay {
    private final QueryRunner queryRunner;
    private final ItemManager itemManager;
    private final InventoryValuePlugin plugin;

    @Inject
    private InventoryValueOverlay(QueryRunner queryRunner, ItemManager itemManager, InventoryValuePlugin plugin) {
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.queryRunner = queryRunner;
        this.itemManager = itemManager;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        final Query query = new InventoryWidgetItemQuery();
        final WidgetItem[] widgetItems = queryRunner.runQuery(query);
        //Collect inventory
        for (final WidgetItem item : widgetItems) {
            //Check if valid item (Is this necessary?)
            if (item.getId() <= 0 || item.getQuantity() == 0)
            {
                continue;
            }

            //Calculate itemstack value
            final int value = plugin.getValue(item.getId());
            final int stackValue = (value * item.getQuantity());
            //Is it enough to be a low-value stack?
            if (stackValue >= plugin.getLValue() && stackValue < plugin.getMValue()) {
                final Color color = plugin.getLVColor();
                final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
                graphics.drawImage(outline, item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);

            }
            //Repeat for medium to insane;
            if (plugin.getLValue() < stackValue && stackValue >= plugin.getMValue()) {
                final Color color = plugin.getMVColor();
                final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
                graphics.drawImage(outline, item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);

            }
            //Lower and higher limits used: limits .drawImage calls. Probably worth it?
            if (plugin.getMValue() < stackValue && stackValue >= plugin.getHValue()) {
                final Color color = plugin.getHVColor();
                final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
                graphics.drawImage(outline, item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);

            }
            if (plugin.getHValue() < stackValue && stackValue >= plugin.getEValue()) {
                final Color color = plugin.getEVColor();
                final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
                graphics.drawImage(outline, item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);

            }
            if (plugin.getEValue() < stackValue && stackValue >= plugin.getIValue()) {
                final Color color = plugin.getIVColor();
                final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
                graphics.drawImage(outline, item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);

            }


        }

        return null;
    }
}
