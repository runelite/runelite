/*
 * Copyright (c) 2018, bheisenberg
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
package net.runelite.client.plugins.raids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.stream.IntStream;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ItemContainer;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.raids.solver.Room;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;

public class RaidsItemsOverlay extends Overlay
{
    private RaidsPlugin plugin;
    private RaidsConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Setter
    private boolean itemsOverlayShown = false;

    @Getter
    private Item[] inventoryItems;

    @Inject
    private Client client;

    @Inject
    private ItemManager itemManager;

    @Inject
    public RaidsItemsOverlay(RaidsPlugin plugin, RaidsConfig config)
    {
        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(OverlayPriority.LOW);
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!config.itemsOverlay() || !itemsOverlayShown)
        {
            return null;
        }

        panelComponent.getChildren().clear();
        inventoryItems = client.getItemContainer(InventoryID.INVENTORY).getItems();

        if (plugin.getRaid() == null || plugin.getRaid().getLayout() == null)
        {
            panelComponent.getChildren().add(TitleComponent.builder()
                    .text("No items found for this raid")
                    .color(Color.RED)
                    .build());

            return panelComponent.render(graphics);
        }


        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Raid items")
                .build());



        for (Room layoutRoom : plugin.getRaid().getLayout().getRooms())
        {
            int position = layoutRoom.getPosition();
            RaidRoom room = plugin.getRaid().getRoom(position);


            if (room == null)
            {
                continue;
            }

            if (room.getItemType() != null)
            {
                Color color = Color.white;
                String itemName = room.getItemType();
                String[] roomItemsInInventory = getRaidItems(room);
                if(roomItemsInInventory.length > 0) {
                    color = Color.green;
                    itemName = roomItemsInInventory[0];
                } else {
                    color = Color.red;
                }
                panelComponent.getChildren().add(LineComponent.builder()
                        .left(itemName)
                        .leftColor(color)
                        .build());
            }

        }
        return panelComponent.render(graphics);
    }

    private String[] getRaidItems(RaidRoom room) {
        int[] inventoryIds = Arrays.stream(inventoryItems).mapToInt(Item::getId).toArray();
        return IntStream.of(inventoryIds).filter(x -> IntStream.of(room.getItemIds()).anyMatch(y -> y == x)).mapToObj(z -> itemManager.getItemComposition(z).getName()).toArray(String[]::new);
    }
}
