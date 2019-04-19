/*
 * Decompiled with CFR 0.139.
 */
package net.runelite.client.plugins.profiles;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(value="profiles")
public interface ProfilesConfig
extends Config {
    @ConfigItem(keyName="profilesData", name="", description="", hidden=true)
    default public String profilesData() {
        return "";
    }

    @ConfigItem(keyName="profilesData", name="", description="")
    public void profilesData(String var1);

    @ConfigItem(keyName="rememberPassword", name="Remember Password", description="Remembers passwords for accounts")
    default public boolean rememberPassword() {
        return true;
    }

    @ConfigItem(keyName="streamerMode", name="Hide email addresses", description="Hides your account emails")
    default public boolean isStreamerMode() {
        return false;
    }

    @ConfigItem(keyName="switchPanel", name="Auto-open Panel", description="Automatically switch to the account switcher panel on the login screen")
    default public boolean switchPanel() {
        return true;
    }
}

