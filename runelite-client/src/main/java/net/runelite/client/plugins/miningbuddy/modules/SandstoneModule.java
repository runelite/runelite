package net.runelite.client.plugins.miningbuddy.modules;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.miningbuddy.MiningBuddyConfig;

import javax.inject.Inject;

@Slf4j
public class SandstoneModule
{
    @Inject
    private Client client;

    @Inject
    private MiningBuddyConfig config;

    public void startUp()
    {
        log.debug("3-tick Sandstone module started");
    }

    public void shutDown()
    {
        log.debug("3-tick Sandstone module stopped");
    }

    public void onGameTick(GameTick event)
    {
        // 3-tick Sandstone logic comes here
    }
}