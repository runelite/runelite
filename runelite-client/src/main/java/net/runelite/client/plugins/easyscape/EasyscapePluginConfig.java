/*
 * Copyright (c) 2018, https://runelitepl.us
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
package net.runelite.client.plugins.easyscape;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("easyscape")
public interface EasyscapePluginConfig extends Config {

    @ConfigItem(
            keyName = "removeExamine",
            name = "Remove Examine",
            description = "",
            position = 0
    )
    default boolean getRemoveExamine() {
        return true;
    }

    @ConfigItem(
            keyName = "swapShop",
            name = "Easy Shop",
            description = "Enables swapping of items in the shop with their buy-50 option.",
            position = 1
    )
    default boolean getSwapShop() {
        return true;
    }

    @ConfigItem(
            keyName = "swappedItems",
            name = "Shop Items",
            description = "Items listed here will have their value and buy-50 options swapped.",
            position = 2
    )
    default String getSwappedItems() {
        return "";
    }

    @ConfigItem(
            keyName = "easyConstruction",
            name = "Easy Construction",
            description = "",
            position = 3
    )

    default boolean getEasyConstruction() {
        return true;
    }

    @ConfigItem(
            keyName = "constructionItems",
            name = "Construction Items",
            description = "",
            position = 4
    )

    default String getConstructionItems() {
        return "";
    }

    @ConfigItem(
            keyName = "removeObjects",
            name = "Remove Objects",
            description = "",
            position = 5
    )
    default boolean getRemoveObjects() {
        return true;
    }

    @ConfigItem(
            keyName = "removedObjects",
            name = "Removed Objects",
            description = "",
            position = 6
    )
    default String getRemovedObjects() {
        return "";
    }

    @ConfigItem(
            keyName = "swapSmithing",
            name = "Swap Smithing",
            description = "Enables swapping of smith-1 and smith-all options.",
            position = 7
    )
    default boolean getSwapSmithing() {
        return true;
    }

    @ConfigItem(
            keyName = "swapTanning",
            name = "Swap Tanning",
            description = "Enables swapping of tan-1 and tan-all options.",
            position = 8
    )
    default boolean getSwapTanning() {
        return true;
    }

    @ConfigItem(
            keyName = "swapCrafting",
            name = "Swap Crafting",
            description = "",
            position = 9
    )
    default boolean getSwapCrafting() {
        return true;
    }

    @ConfigItem(
            keyName = "swapArdougneCape",
            name = "Swap Ardougne Cape",
            description = "Enables swapping of teleport and wear.",
            position = 10
    )
    default boolean getSwapArdougneCape() {
        return true;
    }

    @ConfigItem(
            keyName = "swapStairs",
            name = "Swap Stairs",
            description = "",
            position = 11
    )

    default boolean getSwapStairs() {
        return true;
    }

    @ConfigItem(
            keyName = "swapSawmill",
            name = "Swap Sawmill Operator",
            description = "",
            position = 12
    )
    default boolean getSwapSawmill() {
        return true;
    }

    @ConfigItem(
            keyName = "swapSawmillPlanks",
            name = "Swap Buy Planks",
            description = "",
            position = 13
    )

    default boolean getSwapSawmillPlanks() {
        return true;
    }

    @ConfigItem(
            keyName = "swapPuroPuro",
            name = "Swap Puro Puro Wheat",
            description = "",
            position = 14
    )
    default boolean getSwapPuro() {
        return true;
    }

    @ConfigItem(
            keyName = "swapEssencePounch",
            name = "Swap Essence Pouch",
            description = "Enables swapping of fill and empty for essence pounch.",
            position = 15
    )
    default boolean getSwapEssencePouch() {
        return true;
    }

    @ConfigItem(
            keyName = "essenceMode",
            name = "Essence Pouch Mode",
            description = "Runecrafting or essence mining mode.",
            position = 16
    )

    default EssenceMode getEssenceMode() {
        return EssenceMode.RUNECRAFTING;
    }

    @ConfigItem(
            keyName = "swapGamesNecklace",
            name = "Swap Games Necklace",
            description = "Enables swapping of games necklace.",
            position = 17
    )
    default boolean getGamesNecklace() {
        return true;
    }

    @ConfigItem(
            keyName = "gamesNecklaceMode",
            name = "Games Necklace Mode",
            description = "Teleport location mode.",
            position = 18
    )

    default GamesNecklaceMode getGamesNecklaceMode() {
        return GamesNecklaceMode.BURTHORPE;
    }

    @ConfigItem(
            keyName = "swapDuelingRing",
            name = "Swap Dueling Ring",
            description = "Enables swapping of dueling ring.",
            position = 19
    )
    default boolean getDuelingRing() {
        return true;
    }

    @ConfigItem(
            keyName = "duelingRingMode",
            name = "Dueling Ring Mode",
            description = "Teleport location mode.",
            position = 20
    )

    default DuelingRingMode getDuelingRingMode() {
        return DuelingRingMode.DUEL_ARENA;
    }

    @ConfigItem(
            keyName = "swapGlory",
            name = "Swap Glory",
            description = "Enables swapping of Amulet of Glory.",
            position = 21
    )
    default boolean getGlory() {
        return true;
    }

    @ConfigItem(
            keyName = "gloryMode",
            name = "Glory Mode",
            description = "Teleport location mode.",
            position = 22
    )

    default GloryMode getGloryMode() {
        return GloryMode.EDGEVILLE;
    }
	
	@ConfigItem(
            keyName = "swapWealthRing",
            name = "Swap Ring of Wealth",
            description = "Enables swapping of Ring of Wealth.",
            position = 23
    )
    default boolean getWealthRing() {
        return true;
    }
	@ConfigItem(
            keyName = "WealthRingMode",
            name = "Wealth Ring Mode",
            description = "Teleport location mode.",
            position = 24
    )

    default WealthRingMode getWealthRingMode() {
        return WealthRingMode.GRAND_EXCHANGE;
    }
}

