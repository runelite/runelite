package net.runelite.client.plugins.protectitemreminder;

import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.util.MiscUtils;

import javax.inject.Inject;

@PluginDescriptor(
        name = "! Protect Item Reminder",
        description = "Reminds you to protect item when in the wilderness.",
        tags = { "wilderness", "prayer", "protect", "item", "pking" },
        enabledByDefault = false
)
public class ProtectItemReminderPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private ProtectItemReminderOverlay overlay;

    @Inject
    private ProtectItemReminderConfig config;

    private Player localPlayer;

    public boolean shouldRemind = false;

    @Provides
    ProtectItemReminderConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(ProtectItemReminderConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
        shouldRemind = false;
        localPlayer = null;
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event)
    {
        if (event.getGameState() == GameState.LOGGED_IN)
        {
            localPlayer = client.getLocalPlayer();
        }
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (client.getGameState() == GameState.LOGIN_SCREEN)
            return;

        if (localPlayer == null)
        {
            shouldRemind = false;
            return;
        }
        if (config.skulledOnly() && localPlayer.getSkullIcon() != SkullIcon.SKULL)
        {
            shouldRemind = false;
            return;
        }
        if (MiscUtils.getWildernessLevelFrom(client, localPlayer.getWorldLocation()) <= 0)
        {
            shouldRemind = false;
            return;
        }

        int value = client.getVar(Prayer.PROTECT_ITEM.getVarbit());

        if (value == 0)
            shouldRemind = true;
        else
            shouldRemind = false;
    }
}
