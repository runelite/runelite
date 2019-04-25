/*
 * Copyright (c) 2018, runeliteplus
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
package net.runelite.client.plugins.prayeralert;

import java.awt.*;
import javax.inject.Inject;

import net.runelite.api.*;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.itemstats.stats.Stat;
import net.runelite.client.plugins.itemstats.stats.Stats;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class PrayerAlertOverlay extends Overlay
{
    private final Client client;
    private final PrayerAlertConfig config;
    private final PanelComponent panelComponent = new PanelComponent();
    private final ItemManager itemManager;

    private final Stat prayer = Stats.PRAYER;

    @Inject
    private PrayerAlertOverlay(Client client, PrayerAlertConfig config, ItemManager itemManager)
    {
        setPosition(OverlayPosition.TOP_RIGHT);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.client = client;
        this.config = config;
        this.itemManager = itemManager;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();
        int prayerLevel = getPrayerLevel();
        int prayerPoints = getPrayerPoints();
        if (config.oldRenderMode()){
            if (config.alwaysShowAlert()){
                boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
                if (drink) {
                    oldPrayerRestorePanel(graphics);
                }
            }
            else {
                boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
                boolean hasPrayerPotion = checkInventoryForPotion();
                if (drink && hasPrayerPotion) {
                    oldPrayerRestorePanel(graphics);
                }
            }
        }
        else{
            if (config.alwaysShowAlert()){
                boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
                if (drink) {
                    prayerRestorePanel(panelComponent, graphics);
                }
            }
            else {
                boolean drink = drinkPrayerPotion(prayerLevel, prayerPoints);
                boolean hasPrayerPotion = checkInventoryForPotion();
                if (drink && hasPrayerPotion) {
                    prayerRestorePanel(panelComponent, graphics);
                }
            }
        }
        return panelComponent.render(graphics);
    }

    private int getPrayerLevel()
    {
        return prayer.getMaximum(client);
    }

    private int getPrayerPoints()
    {
        return prayer.getValue(client);
    }

    private boolean drinkPrayerPotion(int prayerLevel, int prayerPoints)
    {
        boolean drink = false;
        int prayerPotionRestoreValue = 7;
        double quarterOfPrayerLevel = (0.25) * (double) prayerLevel;

        prayerPotionRestoreValue = prayerPotionRestoreValue + (int) quarterOfPrayerLevel;

        if (prayerPoints < (prayerLevel - prayerPotionRestoreValue))
        {
            drink = true;
        }

        return drink;
    }

    private boolean checkInventoryForPotion()
    {
        ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
        Item[] inventoryItems;
        boolean hasPrayerPotion = false;

        int[] potionID = {ItemID.PRAYER_POTION1, ItemID.PRAYER_POTION2, ItemID.PRAYER_POTION3, ItemID.PRAYER_POTION4, ItemID.PRAYER_POTION1_20396, ItemID.PRAYER_POTION2_20395,
                ItemID.PRAYER_POTION3_20394, ItemID.PRAYER_POTION4_20393, ItemID.PRAYER_MIX1, ItemID.PRAYER_MIX2, ItemID.SUPER_RESTORE1, ItemID.SUPER_RESTORE2,
                ItemID.SUPER_RESTORE3, ItemID.SUPER_RESTORE4, ItemID.SUPER_RESTORE_MIX1, ItemID.SUPER_RESTORE_MIX2};

        if (inventory != null)
        {
            inventoryItems = inventory.getItems();
            for (Item item : inventoryItems)
            {
                for (int prayerPotionId : potionID)
                {
                    if (item.getId() == prayerPotionId)
                    {
                        hasPrayerPotion = true;
                    }
                }
            }
        }

        return hasPrayerPotion;
    }

    private void prayerRestorePanel(PanelComponent panelComponent, Graphics2D graphics){
        panelComponent.getChildren().add(new ImageComponent(itemManager.getImage(ItemID.PRAYER_POTION4)));
        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Drink")
                .color(Color.RED)
                .build());
        panelComponent.setPreferredSize(new Dimension(
                graphics.getFontMetrics().stringWidth("Drink") + 12,0));
    }

    private void oldPrayerRestorePanel(Graphics2D graphics){
        graphics.translate(-100, 15);
        graphics.setColor(new Color(0.2f, 0.2f, 0.2f, 0.5f));
        graphics.fillRect(0, 0, 100, 45);

        graphics.drawImage(itemManager.getImage(ItemID.PRAYER_POTION4), null, 14, 7);

        Font dropShadow1 = FontManager.getRunescapeFont();
        dropShadow1 = dropShadow1.deriveFont(Font.PLAIN);
        graphics.setFont(dropShadow1);
        graphics.setColor(new Color(0f, 0f, 0f, 0.6f));
        graphics.drawString("Drink", 56, 20);

        Font drinkFont1 = FontManager.getRunescapeFont();
        drinkFont1 = drinkFont1.deriveFont(Font.PLAIN);
        graphics.setFont(drinkFont1);
        graphics.setColor(new Color(1.0f, 0.03529412f, 0.0f));
        graphics.translate(-0.8, -0.8);
        graphics.drawString("Drink", 56, 20);

        Font dropShadow2 = FontManager.getRunescapeFont();
        dropShadow2 = dropShadow2.deriveFont(Font.PLAIN);
        graphics.setFont(dropShadow2);
        graphics.setColor(new Color(0f, 0f, 0f, 0.6f));
        graphics.drawString("Potion", 53, 40);

        Font drinkFont2 = FontManager.getRunescapeFont();
        drinkFont2 = drinkFont2.deriveFont(Font.PLAIN);
        graphics.setFont(drinkFont2);
        graphics.setColor(new Color(1.0f, 0.03529412f, 0.0f));
        graphics.translate(-0.8, -0.8);
        graphics.drawString("Potion", 53, 40);
    }
}