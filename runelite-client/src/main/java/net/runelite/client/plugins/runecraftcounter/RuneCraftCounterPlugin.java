/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.runecraftcounter;

import javax.inject.Inject;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.runelite.api.Client;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.StatChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@SuppressWarnings("ALL")
@PluginDescriptor(
        name = "Rune Craft Counter",
        description = "Counts number of crafted runes"
)

public class RuneCraftCounterPlugin extends Plugin
{
    private static final Set<Integer> RUNE_TYPES = ImmutableSet.of(ItemID.FIRE_RUNE, ItemID.WATER_RUNE,
            ItemID.AIR_RUNE, ItemID.EARTH_RUNE, ItemID.MIND_RUNE, ItemID.BODY_RUNE, ItemID.DEATH_RUNE,
            ItemID.NATURE_RUNE, ItemID.CHAOS_RUNE, ItemID.LAW_RUNE, ItemID.COSMIC_RUNE, ItemID.BLOOD_RUNE,
            ItemID.SOUL_RUNE, ItemID.ASTRAL_RUNE, ItemID.WRATH_RUNE);
    private static String RUNECRAFTING = "Runecraft";
    private boolean isRuneCrafting = false;

    @Inject
    private RuneCraftCounterSession session;
    private HashMap<Integer, Integer> inventorySnapshot;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RuneCraftCounterOverlay overlay;

    @Inject
    private Client client;

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
        isRuneCrafting = false;
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        Item[] items = event.getItemContainer().getItems();

        // Build set of current inventory
        HashMap<Integer, Integer> currentInventory = new HashMap<>();
        Arrays.stream(items)
                .filter(item -> RUNE_TYPES.contains(item.getId()))
                .forEach(item -> currentInventory.put(item.getId(), item.getQuantity()));

        if(inventorySnapshot == null)
        {
            inventorySnapshot = new HashMap<>();
            inventorySnapshot = currentInventory;
            isRuneCrafting = false;

            return;
        }

        // Update session with difference between previous and current inventory
        if(isRuneCrafting)
        {
            for(Map.Entry<Integer, Integer> entry : currentInventory.entrySet())
            {
                if(inventorySnapshot.containsKey(entry.getKey()))
                {
                    int delta = entry.getValue() - inventorySnapshot.get(entry.getKey());
                    session.incrementRunesCrafted(entry.getKey(), delta);
                }
                else
                {
                    session.incrementRunesCrafted(entry.getKey(), entry.getValue());
                }
            }
        }

        inventorySnapshot = currentInventory;
        isRuneCrafting = false;
    }

    @Subscribe
    public void onStatChanged(StatChanged statChanged)
    {
        Skill skill = statChanged.getSkill();

        if(skill.getName().equals(RUNECRAFTING))
        {
            isRuneCrafting = true;
        }
    }
}