package net.runelite.client.plugins.playerhighlight;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.gameval.ObjectID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.playerhighlight.PlayerHighlightConfig;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.sql.Array;
import java.util.*;

@Slf4j
@PluginDescriptor(
        name = "Player Highlight"
)
public class PlayerHighlightPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private PlayerHighlightConfig config;

    @Inject
    private OverlayManager overlayManager;


    @Inject
    private PlayerHighlightOverlay playerHighlightOverlay;

    final List<Player> players = new ArrayList<Player>();

    @Override
    protected void startUp() throws Exception
    {
        log.info("Player Highlight started!");
        overlayManager.add(playerHighlightOverlay);

    }

    @Override
    protected void shutDown() throws Exception
    {
        log.info("Player Highlight stopped!");
        overlayManager.remove(playerHighlightOverlay);

    }

    @Subscribe
    public void onPlayerSpawned(PlayerSpawned event) {
        if (event.getPlayer() == client.getLocalPlayer())
        {
            return;
        }

        players.add(event.getPlayer());
    }

    @Subscribe
    public void onPlayerDespawned(PlayerDespawned event) {
        players.remove(event.getPlayer());
    }

    @Provides
    PlayerHighlightConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(PlayerHighlightConfig.class);
    }
}

