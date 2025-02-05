package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.*;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "Alder Rise Plugin",
        description = "Toolbox - Woodcutting",
        tags = {"toolbox", "leveling", "woodcutting"},
        enabledByDefault = false
)
@Slf4j
public class AlderRisePlugin extends Plugin{

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private ConfigManager configManager;

    @Inject
    private RuneLiteConfig runeLiteConfig;

    @Inject
    private ChatColorConfig chatColorConfig;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private Notifier notifier;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private AlderRiseConfig config;

    @Inject
    private AlderRiseOverlay toolBoxOverlay;


    @Provides
    AlderRiseConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(AlderRiseConfig.class);
    }

    @Provides
    AlderRiseOverlay provideOverlay()
    {
        return new AlderRiseOverlay(this);
    }

    @Override
    protected void startUp()
    {
        overlayManager.add(toolBoxOverlay);
        log.info("ToolBox Plugin Started.");
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(toolBoxOverlay);
        log.info("ToolBox Plugin Stopped.");
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        log.debug("Toolbox - onGameTick");
    }

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        log.debug("Toolbox - onChatMessage");
    }

    @Subscribe
    public void onPlayerSpawned(PlayerSpawned event)
    {
        log.debug("Toolbox - onPlayerSpawned");
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event)
    {
        log.debug("Toolbox - onItemContainerChanged");
    }

    @Subscribe
    public void onInteractingChanged(InteractingChanged event)
    {
        log.debug("Toolbox - onInteractingChanged");
    }

    @Subscribe
    public void onAnimationChanged(AnimationChanged event)
    {
        log.debug("Toolbox - onAnimationChanged");
    }
}