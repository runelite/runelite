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
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;


public class AutoSwitcherOverlay extends Overlay {

    public static ArrayList<Integer> preset1Items = new ArrayList<>();
    public static ArrayList<Integer> preset2Items = new ArrayList<>();
    public static ArrayList<Integer> preset3Items = new ArrayList<>();

    public static ArrayList inventoryItems = new ArrayList<WidgetItem>();

    @Inject
    private QueryRunner queryRunner = new QueryRunner();

    private static final Color PurPur = Color.magenta.darker();

    @Inject
    private Client client;

    @Inject
    private AutoSwitcherPlugin plugin;

    @Inject
    private AutoSwitcherConfig config;

    @Inject
    public AutoSwitcherOverlay(@Nullable Client client, AutoSwitcherPlugin plugin, AutoSwitcherConfig config) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.UNDER_WIDGETS);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        Query inventoryQuery = new InventoryWidgetItemQuery();
        WidgetItem[] inventoryWidgetItems = queryRunner.runQuery(inventoryQuery);


        graphics.setFont(FontManager.getRunescapeSmallFont());

        inventoryItems = new ArrayList<WidgetItem>();
        for (WidgetItem item : inventoryWidgetItems) {
            inventoryItems.add(item);
            for (Integer i : preset1Items) {
                if (i == item.getId()) {
                    graphics.setColor(Color.red);
                    final Rectangle bounds = item.getCanvasBounds();
                    graphics.draw(bounds);
                }
            }
            for (Integer i : preset2Items) {
                if (i == item.getId()) {
                    graphics.setColor(Color.BLUE);
                    final Rectangle bounds = item.getCanvasBounds();
                    graphics.draw(bounds);
                }
            }
            for (Integer i : preset3Items) {
                if (i == item.getId()) {
                    graphics.setColor(Color.MAGENTA);
                    final Rectangle bounds = item.getCanvasBounds();
                    graphics.draw(bounds);
                }
            }
        }

        return null;
    }
}
