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
        return false;
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
            keyName = "removeMonster",
            name = "Remove Monsters",
            description = "",
            position = 5
    )
    default boolean getRemoveMonster() {
        return true;
    }

    @ConfigItem(
            keyName = "removedMonsters",
            name = "Removed Monsters",
            description = "",
            position = 6
    )
    default String getRemovedMonsters() {
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
}
