package net.runelite.client.plugins.logindetails;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;



@ConfigGroup("logindetails")
    public interface logindetailsConfig extends Config
    {
        @ConfigItem(
                position = 1,
                keyName = "storeUsername",
                name = "Username",
                description = "Save your username."
        )
        default String storeUsername() { return ""; }

        @ConfigItem(
                position = 2,
                keyName = "storePassword",
                name = "Password",
                description = "Save your password."
        )
        default String storePassword() { return ""; }

        @ConfigItem
                (
                        position = 3,
                        keyName = "saveDetails",
                        name = "Store details",
                        description = "Toggle saving login info."
                )
        default boolean toggleDetails() { return true; }
    }


