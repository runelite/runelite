/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.grounditems;

import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import java.awt.*;
import java.util.*;

public class GroundItemsOverlay extends Overlay
{
    GroundItemsOverlay()
    {
        super(OverlayPosition.DYNAMIC);
    }
    private final Client client = RuneLite.getClient();
    private final StringBuilder itemStringBuilder = new StringBuilder();
    @Override
    public Dimension render(Graphics2D graphics)
    {

        if(client.getGameState() != GameState.LOGGED_IN)
        {
            return null;
        }


        /*Widget[] bank = client.getWidgets()[12];
        if(bank != null && bank[0] != null && !bank[0].isHidden())
        {
            return null;
        } */


        Region region = client.getRegion();
        Tile[][][] tiles = region.getTiles();
        FontMetrics fm = graphics.getFontMetrics();

        int z = client.getPlane();

        int REGION_SIZE = 104;
        for(int x = 0; x < REGION_SIZE; ++x)
        {
            for(int y = 0; y < REGION_SIZE; ++y)
            {
               Tile tile = tiles[z][x][y];
               if(tile == null)
               {
                   continue;
               }
                Player player = client.getLocalPlayer();
               if(player == null)
               {
                   continue;
               }

                ItemLayer itemLayer = tile.getItemLayer();
               if (itemLayer != null)
               {
                   if(player.getLocalLocation().distanceTo(itemLayer.getLocalLocation()) < 2400)
                   {
                      Node current = itemLayer.getBottom();
                      ArrayList<Integer> itemIds = new ArrayList<>();
                      Map<Integer, Integer> itemQuantities = new HashMap<>();
                      while(current instanceof Item)
                      {
                          Item item = (Item) current;
                          addItemToMap(item, itemIds, itemQuantities);
                          current = current.getNext();
                      }

                       Collections.reverse(itemIds);

                      for(int i = 0; i < itemIds.size(); ++i)
                      {
                          Integer id = itemIds.get(i);
                          Integer qty = itemQuantities.get(id);
                          if(qty == null)
                          {
                              continue;
                          }
                          String itemName;
                          if(id == 995)
                          {
                              itemName = "Coins";
                              itemStringBuilder.append(qty).append(" x ").append(itemName);
                          } else {
                              if (qty > 1)
                              {
                                if(qty == 65535)
                                {
                                    itemStringBuilder.append("Lots of ");
                                } else {
                                    itemStringBuilder.append(qty).append("x ");
                                }
                              }
                              itemName = client.getItemDefinition(id).getName();
                              itemStringBuilder.append(itemName);
                          }
                          String itemString = itemStringBuilder.toString();
                          itemStringBuilder.setLength(0);
                          Point point = itemLayer.getCanvasLocation();
                          int screenX = point.getX() + 2 - (fm.stringWidth(itemString) / 2);

                          graphics.setColor(Color.BLACK);
                          graphics.drawString(itemString, screenX + 1, point.getY() - (15 * i) + 1);
                          graphics.setColor(Color.WHITE);
                          graphics.drawString(itemString, screenX, point.getY() - (15 * i));
                      }
                   }
               }
            }
        }
        return null;
    }

    private void addItemToMap(Item item, ArrayList<Integer> itemIds, Map<Integer, Integer> itemQuantities)
    {
        int id = item.getId();
        if(itemIds.contains(id))
        {
            itemQuantities.put(id, itemQuantities.get(id) + item.getQuantity());
        } else {
            itemIds.add(id);
            itemQuantities.put(id, item.getQuantity());
        }
    }
}
