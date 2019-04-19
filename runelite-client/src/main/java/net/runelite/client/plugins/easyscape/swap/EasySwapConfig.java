package net.runelite.client.plugins.easy.swap;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.plugins.easy.util.DuelingRingMode;
import net.runelite.client.plugins.easy.util.EssenceMode;
import net.runelite.client.plugins.easy.util.GamesNecklaceMode;
import net.runelite.client.plugins.easy.util.GloryMode;

@ConfigGroup("easyswap")
public interface EasySwapConfig extends Config {

    @ConfigItem(
            keyName = "easyConstruction",
            name = "Easy Construction",
            description = "Makes \"Remove\" the default option for listed items in build mode.",
            position = 0
    )

    default boolean getEasyConstruction() {
        return true;
    }

    @ConfigItem(
            keyName = "constructionItems",
            name = "Construction Items",
            description = "Items listed here will have the default option set to \"Removed\" in build mode.",
            position = 1
    )

    default String getConstructionItems() {
        return "";
    }


    @ConfigItem(
            keyName = "swapSmithing",
            name = "Swap Smithing",
            description = "Enables swapping of smith-1 and smith-all options.",
            position = 2
    )

    default boolean getSwapSmithing() {
        return true;
    }

    @ConfigItem(
            keyName = "swapTanning",
            name = "Swap Tanning",
            description = "Enables swapping of tan-1 and tan-all options.",
            position = 3
    )

    default boolean getSwapTanning() {
        return true;
    }

    @ConfigItem(
            keyName = "swapCrafting",
            name = "Swap Crafting",
            description = "Enables swapping of Make-1 and Make-all options.",
            position = 4
    )

    default boolean getSwapCrafting() {
        return true;
    }

    @ConfigItem(
            keyName = "swapArdougneCape",
            name = "Swap Ardougne Cape",
            description = "Enables swapping of teleport and wear.",
            position = 5
    )

    default boolean getSwapArdougneCape() {
        return true;
    }

    @ConfigItem(
            keyName = "swapSawmill",
            name = "Swap Sawmill Operator",
            description = "Makes Buy-plank the default option on the sawmill operator.",
            position = 6
    )

    default boolean getSwapSawmill() {
        return true;
    }

    @ConfigItem(
            keyName = "swapSawmillPlanks",
            name = "Swap Buy Planks",
            description = "Makes Buy All the default option in buy planks.",
            position = 7
    )

    default boolean getSwapSawmillPlanks() {
        return true;
    }

    @ConfigItem(
            keyName = "swapPuroPuro",
            name = "Swap Puro Puro Wheat",
            description = "",
            position = 8
    )

    default boolean getSwapPuro() {
        return true;
    }

    @ConfigItem(
            keyName = "swapEssencePounch",
            name = "Swap Essence Pouch",
            description = "",
            position = 9
    )

    default boolean getSwapEssencePouch() {
        return true;
    }

    @ConfigItem(
            keyName = "essenceMode",
            name = "Mode",
            description = "",
            position = 10
    )

    default EssenceMode getEssenceMode() {
        return EssenceMode.RUNECRAFTING;
    }

    @ConfigItem(
            keyName = "swapGamesNecklace",
            name = "Swap Games Necklace",
            description = "",
            position = 11
    )
    default boolean getGamesNecklace() {
        return true;
    }

    @ConfigItem(
            keyName = "gamesNecklaceMode",
            name = "Mode",
            description = "",
            position = 12
    )

    default GamesNecklaceMode getGamesNecklaceMode() {
        return GamesNecklaceMode.BURTHORPE;
    }

    @ConfigItem(
            keyName = "swapDuelingRing",
            name = "Swap Dueling Ring",
            description = "",
            position = 13
    )

    default boolean getDuelingRing() {
        return true;
    }

    @ConfigItem(
            keyName = "duelingRingMode",
            name = "Mode",
            description = "",
            position = 14
    )

    default DuelingRingMode getDuelingRingMode() {
        return DuelingRingMode.DUEL_ARENA;
    }

    @ConfigItem(
            keyName = "swapGlory",
            name = "Swap Glory",
            description = "",
            position = 15
    )

    default boolean getGlory() {
        return true;
    }

    @ConfigItem(
            keyName = "gloryMode",
            name = "Mode",
            description = "",
            position = 16
    )

    default GloryMode getGloryMode() {
        return GloryMode.EDGEVILLE;
    }

}
