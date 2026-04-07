package net.runelite.client.plugins.miningbuddy;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.miningbuddy.modules.AmethystModule;
import net.runelite.client.plugins.miningbuddy.modules.MotherloadMineModule;
import net.runelite.client.plugins.miningbuddy.modules.SandstoneModule;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
        name = "MiningBuddy",
        description = "Mining assistant for various activities",
        tags = {"mining", "motherload", "amethyst", "sandstone", "buddy"},
        enabledByDefault = false,
        hidden = true
)
public class MiningBuddyPlugin extends Plugin
{
    @Inject private MiningBuddyConfig config;
    @Inject private MotherloadMineModule motherloadModule;
    @Inject private AmethystModule amethystModule;
    @Inject private SandstoneModule sandstoneModule;
    @Inject private EventBus eventBus;

    @Override
    protected void startUp()
    {
        eventBus.register(motherloadModule);
        eventBus.register(amethystModule);
        eventBus.register(sandstoneModule);

        motherloadModule.startUp();
        amethystModule.startUp();
        sandstoneModule.startUp();

        log.info("MiningBuddy started");
    }

    @Override
    protected void shutDown()
    {
        eventBus.unregister(motherloadModule);
        eventBus.unregister(amethystModule);
        eventBus.unregister(sandstoneModule);

        motherloadModule.shutDown();
        amethystModule.shutDown();
        sandstoneModule.shutDown();

        log.info("MiningBuddy stopped");
    }

    @Provides
    MiningBuddyConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(MiningBuddyConfig.class);
    }
}