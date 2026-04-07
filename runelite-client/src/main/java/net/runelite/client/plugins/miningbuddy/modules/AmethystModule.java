package net.runelite.client.plugins.miningbuddy.modules;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.miningbuddy.MiningBuddyConfig;

import javax.inject.Inject;

@Slf4j
public class AmethystModule
{
    @Inject
    private Client client;

    @Inject
    private MiningBuddyConfig config;

    public void startUp()
    {
        log.debug("Amethyst module started");
    }

    public void shutDown()
    {
        log.debug("Amethyst module stopped");
    }

    public void onGameTick(GameTick event)
    {
        // Amethyst logic comes here
    }
}