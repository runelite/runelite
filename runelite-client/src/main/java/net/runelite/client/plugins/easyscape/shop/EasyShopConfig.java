package net.runelite.client.plugins.easy.shop;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("easyshop")
public interface EasyShopConfig extends Config {

    @ConfigItem(
            keyName = "swapBuyOne",
            name = "Swappable Buy One",
            description = "",
            position = 0
    )

    default boolean getSwapBuyOne() {
        return true;
    }

    @ConfigItem(
            keyName = "buyOneItems",
            name = "Items",
            description = "",
            position = 1
    )

    default String getBuyOneItems() {
        return "";
    }

    @ConfigItem(
            keyName = "swapBuyFive",
            name = "Swappable Buy Five",
            description = "",
            position = 2
    )

    default boolean getSwapBuyFive() {
        return true;
    }

    @ConfigItem(
            keyName = "buyFiveItems",
            name = "Items",
            description = "",
            position = 3
    )

    default String getBuyFiveItems() {
        return "";
    }

    @ConfigItem(
            keyName = "swapBuyTen",
            name = "Swappable Buy Ten",
            description = "",
            position = 4
    )

    default boolean getSwapBuyTen() {
        return true;
    }

    @ConfigItem(
            keyName = "buyTenItems",
            name = "Items",
            description = "",
            position = 5
    )

    default String getBuyTenItems() {
        return "";
    }

    @ConfigItem(
            keyName = "swapBuyFifty",
            name = "Swappable Buy Fifty",
            description = "",
            position = 6
    )

    default boolean getSwapBuyFifty() {
        return true;
    }

    @ConfigItem(
            keyName = "buyFiftyItems",
            name = "Items",
            description = "",
            position = 7
    )

    default String getBuyFiftyItems() {
        return "";
    }

    @ConfigItem(
            keyName = "swapSellOne",
            name = "Swappable Sell One",
            description = "",
            position = 8
    )

    default boolean getSwapSellOne() {
        return true;
    }

    @ConfigItem(
            keyName = "sellOneItems",
            name = "Items",
            description = "",
            position = 9
    )

    default String getSellOneItems() {
        return "";
    }

    @ConfigItem(
            keyName = "swapSellFive",
            name = "Swappable Sell Five",
            description = "",
            position = 10
    )

    default boolean getSwapSellFive() {
        return true;
    }

    @ConfigItem(
            keyName = "sellFiveItems",
            name = "Items",
            description = "",
            position = 11
    )

    default String getSellFiveItems() {
        return "";
    }

    @ConfigItem(
            keyName = "swapSellTen",
            name = "Swappable Sell Ten",
            description = "",
            position = 12
    )

    default boolean getSwapSellTen() {
        return true;
    }

    @ConfigItem(
            keyName = "sellTenItems",
            name = "Items",
            description = "",
            position = 13
    )

    default String getSellTenItems() {
        return "";
    }

    @ConfigItem(
            keyName = "swapSellFifty",
            name = "Swappable Sell Fifty",
            description = "",
            position = 14
    )

    default boolean getSwapSellFifty() {
        return true;
    }

    @ConfigItem(
            keyName = "sellFiftyItems",
            name = "Items",
            description = "",
            position = 15
    )

    default String getSellFiftyItems() {
        return "";
    }

}
