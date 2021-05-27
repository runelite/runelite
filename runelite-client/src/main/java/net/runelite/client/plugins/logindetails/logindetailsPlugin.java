package net.runelite.client.plugins.logindetails;

import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


import javax.inject.Inject;

@PluginDescriptor(
        name = "Login Details",
        description = "Allows you to save both Username & Password on RuneLite.",
        tags = {"password", "username", "login", "details"},
        loadWhenOutdated = true,
        enabledByDefault = false
)



public class logindetailsPlugin extends Plugin {

    @Inject
    private logindetailsConfig config;
    @Inject
    private Client client;

    @Provides
    logindetailsConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(logindetailsConfig.class);
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
    }


    @Subscribe
    public void onGameTick(GameTick event)
    {
    }



    @Override
    protected void shutDown() throws Exception
    {
    }

    @Override
    protected void startUp() throws Exception
    {

    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
        {
            if (config.toggleDetails()) {
                client.setUsername(config.storeUsername());
                client.setPassword(config.storePassword());
            }
            else
            {

            }
        }
    }
}