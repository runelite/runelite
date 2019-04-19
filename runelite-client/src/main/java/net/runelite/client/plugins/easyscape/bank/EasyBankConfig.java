package net.runelite.client.plugins.easy.bank;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;


@ConfigGroup("easybank")
public interface EasyBankConfig extends Config {

    @ConfigItem(
            keyName = "withdrawOne",
            name = "Withdraw/Deposit One",
            description = "",
            position = 0
    )

    default boolean getWithdrawOne() {
        return true;
    }

    @ConfigItem(
            keyName = "withdrawOneItems",
            name = "Items",
            description = "",
            position = 1
    )

    default String getWithdrawOneItems() {
        return "";
    }

    @ConfigItem(
            keyName = "withdrawFive",
            name = "Withdraw/Deposit Five",
            description = "",
            position = 2
    )

    default boolean getWithdrawFive() {
        return true;
    }

    @ConfigItem(
            keyName = "withdrawFiveItems",
            name = "Items",
            description = "",
            position = 3
    )

    default String getWithdrawFiveItems() {
        return "";
    }

    @ConfigItem(
            keyName = "withdrawTen",
            name = "Withdraw/Deposit Ten",
            description = "",
            position = 4
    )

    default boolean getWithdrawTen() {
        return true;
    }

    @ConfigItem(
            keyName = "withdrawTenItems",
            name = "Items",
            description = "",
            position = 5
    )

    default String getWithdrawTenItems() {
        return "";
    }

    @ConfigItem(
            keyName = "withdrawX",
            name = "Withdraw/Deposit X",
            description = "",
            position = 6
    )

    default boolean getWithdrawX() {
        return true;
    }

    @ConfigItem(
            keyName = "withdrawXAmount",
            name = "Amount",
            description = "",
            position = 7
    )

    default String getWithdrawXAmount() {
        return "";
    }

    @ConfigItem(
            keyName = "withdrawXItems",
            name = "Items",
            description = "",
            position = 8
    )

    default String getWithdrawXItems() {
        return "";
    }

    @ConfigItem(
            keyName = "withdrawAll",
            name = "Withdraw/Deposit All",
            description = "",
            position = 9
    )

    default boolean getWithdrawAll() {
        return true;
    }

    @ConfigItem(
            keyName = "withdrawAllItems",
            name = "Items",
            description = "",
            position = 10
    )

    default String getWithdrawAllItems() {
        return "";
    }


}
