package net.runelite.client.plugins.dagannothkings;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.dagannothkings.entity.DagannothKing;
import net.runelite.client.plugins.dagannothkings.overlay.InfoboxOverlay;
import net.runelite.client.plugins.dagannothkings.overlay.PrayerOverlay;
import net.runelite.client.plugins.dagannothkings.overlay.SceneOverlay;
import net.runelite.client.ui.overlay.OverlayManager;

@Singleton
@Slf4j
@PluginDescriptor(
        name = "Dagannoth Kings",
        enabledByDefault = false,
        description = "A plugin for the Dagannoth Kings.",
        tags = {"dagannoth", "kings", "dks", "daggs", "willem" , "fun"}
)
public class DKPlugin extends Plugin
{
    private static final String CONFIG_GROUP = "dagannothkings";

    private static final int WATERBITH_REGION = 11589;

    @Inject
    private Client client;

    @Inject
    private EventBus eventBus;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private PrayerOverlay prayerOverlay;

    @Inject
    private SceneOverlay sceneOverlay;

    @Inject
    private InfoboxOverlay infoboxOverlay;

    @Getter
    private final Set<DagannothKing> dagannothKings = new HashSet<>();

    private boolean atDks;

    @Getter
    private long lastTickTime;

    @Provides
    DKConfig getConfig(final ConfigManager configManager)
    {
        return configManager.getConfig(DKConfig.class);
    }

    @Override
    public void startUp()
    {
        if (client.getGameState() != GameState.LOGGED_IN || !atDks())
        {
            return;
        }

        init();
    }

    private void init()
    {
        atDks = true;

        addOverlays();

        for (final NPC npc : client.getNpcs())
        {
            addNpc(npc);
        }
    }

    @Override
    public void shutDown()
    {
        atDks = false;
        removeOverlays();
        dagannothKings.clear();
    }

    @Subscribe
    private void onConfigChanged(ConfigChanged event)
    {
        if (!event.getGroup().equals(CONFIG_GROUP))
        {
            return;
        }

        if (event.getKey().equals("mirrorMode"))
        {
            updateOverlays();

            if (atDks)
            {
                removeOverlays();
                addOverlays();
            }
        }
    }

    @Subscribe
    private void onGameStateChanged(GameStateChanged event)
    {
        final GameState gameState = event.getGameState();

        switch (gameState)
        {
            case LOGGED_IN:
                if (atDks())
                {
                    if (!atDks)
                    {
                        init();
                    }
                }
                else
                {
                    if (atDks)
                    {
                        shutDown();
                    }
                }
                break;
            case LOGIN_SCREEN:
            case HOPPING:
                shutDown();
                break;
        }
    }
    @Subscribe
    private void onGameTick(GameTick Event)
    {
        lastTickTime = System.currentTimeMillis();

        if (dagannothKings.isEmpty())
        {
            return;
        }

        for (final DagannothKing dagannothKing : dagannothKings)
        {
            dagannothKing.updateTicksUntilNextAnimation();
        }
    }
    @Subscribe
    private void onNpcSpawned(final NpcSpawned event)
    {
        addNpc(event.getNpc());
    }
    @Subscribe
    private void onNpcDespawned(final NpcDespawned event)
    {
        removeNpc(event.getNpc());
    }

    private void addNpc(final NPC npc)
    {
        switch (npc.getId())
        {
            case NpcID.DAGANNOTH_REX:
            case NpcID.DAGANNOTH_SUPREME:
            case NpcID.DAGANNOTH_PRIME:
                dagannothKings.add(new DagannothKing(npc));
                break;
            default:
                break;
        }
    }

    private void removeNpc(final NPC npc)
    {
        switch (npc.getId())
        {
            case NpcID.DAGANNOTH_REX:
            case NpcID.DAGANNOTH_SUPREME:
            case NpcID.DAGANNOTH_PRIME:
                dagannothKings.removeIf(dk -> dk.getNpc() == npc);
                break;
            default:
                break;
        }
    }

    private void addOverlays()
    {
        overlayManager.add(sceneOverlay);
        overlayManager.add(prayerOverlay);
        overlayManager.add(infoboxOverlay);
    }

    private void removeOverlays()
    {
        overlayManager.remove(sceneOverlay);
        overlayManager.remove(prayerOverlay);
        overlayManager.remove(infoboxOverlay);
    }

    private void updateOverlays()
    {
        sceneOverlay.determineLayer();
        prayerOverlay.determineLayer();
        infoboxOverlay.determineLayer();
    }

    private boolean atDks()
    {
        return Arrays.stream(client.getMapRegions()).anyMatch(x -> x == WATERBITH_REGION);
    }
}