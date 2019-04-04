/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.aaautoswitcherbeta;

import net.runelite.api.Client;
import net.runelite.api.Query;
import net.runelite.api.queries.InventoryWidgetItemQuery;
import net.runelite.api.queries.WidgetItemQuery;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class AutoSwitcherOverlay extends Overlay {

    public static ArrayList<Integer> preset1Items = new ArrayList<>();
    public static ArrayList<Integer> preset2Items = new ArrayList<>();
    public static ArrayList<Integer> preset3Items = new ArrayList<>();
    public static ArrayList<Integer> preset4Items = new ArrayList<>();
    public static ArrayList inventoryItems = new ArrayList<WidgetItem>();
    private final ItemManager itemManager;
    @Inject
    private QueryRunner queryRunner = new QueryRunner();

    @Inject
    private Client client;

    @Inject
    private AutoSwitcherPlugin plugin;

    @Inject
    private AutoSwitcherConfig config;

    @Inject
    public AutoSwitcherOverlay(@Nullable Client client, AutoSwitcherPlugin plugin, ItemManager itemManager, AutoSwitcherConfig config) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.itemManager = itemManager;
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        final Query query = new InventoryWidgetItemQuery();

        final WidgetItem[] widgetItems = queryRunner.runQuery(query);

        for (final WidgetItem item : widgetItems) {
            for (int i : preset1Items) {
                if (item.getId() == i)
                    renderOutline(item, graphics);
            }
            for (int i : preset2Items) {
                if (item.getId() == i)
                    renderOutline(item, graphics);
            }
            for (int i : preset3Items) {
                if (item.getId() == i)
                    renderOutline(item, graphics);
            }
            for (int i : preset4Items) {
                if (item.getId() == i)
                    renderOutline(item, graphics);
            }

        }

        return null;
    }

    public void renderOutline(WidgetItem item, Graphics graphics) {
        final String group = plugin.getTag(item.getId());

        if (group != null) {
            final Color color = plugin.getGroupNameColor(group);
            if (color != null) {
                final BufferedImage outline = itemManager.getItemOutline(item.getId(), item.getQuantity(), color);
                graphics.drawImage(outline, item.getCanvasLocation().getX() + 1, item.getCanvasLocation().getY() + 1, null);
            }
        }
    }
}
