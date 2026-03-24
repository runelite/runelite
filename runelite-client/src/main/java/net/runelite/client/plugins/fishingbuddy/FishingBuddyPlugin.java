package net.runelite.client.plugins.fishingbuddy;

import com.google.inject.Provides;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@PluginDescriptor(
        name = "FishingBuddy",
        description = "Automatically catches minnows by switching fishing spots",
        tags = {"fishing", "minnow", "buddy", "auto"},
        enabledByDefault = false,
        hidden = true
)
public class FishingBuddyPlugin extends Plugin
{
    private static final Set<Integer> MINNOW_SPOT_IDS = Set.of(7730, 7731, 7732, 7733);
    private static final String FLYING_FISH_MESSAGE = "A flying fish jumps up and eats some of your minnows!";

    @Inject private Client client;
    @Inject private ClientThread clientThread;
    @Inject private FishingBuddyConfig config;
    @Inject private OverlayManager overlayManager;
    @Inject private FishingBuddyOverlay overlay;

    @Getter private boolean active = false;
    @Getter private boolean flyingFishDetected = false;
    @Getter private int spotSwitchCount = 0;

    private NPC currentSpot = null;
    private WorldPoint lastSpotLocation = null;
    private final List<NPC> minnowSpots = new ArrayList<>();
    private final Map<Integer, WorldPoint> lastSpotLocations = new HashMap<>();
    private final Random random = new Random();
    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
        resetState();
        log.info("FishingBuddy started");
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
        resetState();
        log.info("FishingBuddy stopped");
    }

    private void resetState()
    {
        active = false;
        flyingFishDetected = false;
        spotSwitchCount = 0;
        currentSpot = null;
        lastSpotLocation = null;
        minnowSpots.clear();
        lastSpotLocations.clear();
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned event)
    {
        NPC npc = event.getNpc();
        if (MINNOW_SPOT_IDS.contains(npc.getId()))
        {
            minnowSpots.add(npc);
            log.debug("Minnow spot spawned: {}", npc.getId());
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned event)
    {
        NPC npc = event.getNpc();
        if (MINNOW_SPOT_IDS.contains(npc.getId()))
        {
            minnowSpots.remove(npc);
            lastSpotLocations.remove(npc.getIndex());

            if (npc == currentSpot)
            {
                log.debug("Current spot despawned, switching...");
                handleSpotSwitch();
            }
        }
    }

    @Subscribe
    public void onInteractingChanged(InteractingChanged event)
    {
        if (!config.enabled())
        {
            return;
        }

        if (event.getSource() == client.getLocalPlayer())
        {
            Actor target = event.getTarget();
            if (target instanceof NPC)
            {
                NPC npc = (NPC) target;
                if (MINNOW_SPOT_IDS.contains(npc.getId()))
                {
                    currentSpot = npc;
                    lastSpotLocation = npc.getWorldLocation();
                    active = true;
                    flyingFishDetected = false;
                    log.debug("Player started fishing at minnow spot: {}", npc.getId());
                }
                else
                {
                    // Player clicked a non-minnow NPC — stop
                    active = false;
                    currentSpot = null;
                    lastSpotLocation = null;
                    log.debug("Player clicked non-minnow NPC, stopping");
                }
            }

        }
    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event)
    {
        if (!active || !config.enabled())
        {
            return;
        }

        // Stop als speler op een tile klikt (Walk here)
        if (event.getMenuAction() == MenuAction.WALK)
        {
            active = false;
            currentSpot = null;
            lastSpotLocation = null;
            log.debug("Player walked away, stopping");
        }
    }

    @Subscribe
    public void onChatMessage(ChatMessage event)
    {
        if (!active || !config.enabled())
        {
            return;
        }

        if (event.getMessage().equals(FLYING_FISH_MESSAGE))
        {
            flyingFishDetected = true;
            log.debug("Flying fish detected! Switching spot...");
            handleSpotSwitch();
        }
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (!active || !config.enabled() || currentSpot == null)
        {
            return;
        }

        WorldPoint currentLocation = currentSpot.getWorldLocation();

        if (lastSpotLocation != null && !lastSpotLocation.equals(currentLocation))
        {
            log.debug("Our minnow spot moved! Switching...");
            spotSwitchCount++;
            lastSpotLocation = currentLocation;

            if (spotSwitchCount >= config.spotSwitchLimit())
            {
                log.info("Spot switch limit reached ({}), stopping.", config.spotSwitchLimit());
                active = false;
                currentSpot = null;
                return;
            }

            handleSpotSwitch();
        }
        else
        {
            lastSpotLocation = currentLocation;
        }
    }

    private void handleSpotSwitch()
    {
        NPC nextSpot = minnowSpots.stream()
                .filter(npc -> npc != currentSpot)
                .findFirst()
                .orElse(null);

        if (nextSpot == null)
        {
            log.debug("No valid minnow spot found to switch to");
            active = false;
            return;
        }

        NPC spotToClick = nextSpot;
        currentSpot = spotToClick;
        lastSpotLocation = spotToClick.getWorldLocation();
        flyingFishDetected = false;

        int minDelay = config.reactionDelayMin();
        int maxDelay = config.reactionDelayMax();
        int delay = minDelay + random.nextInt(Math.max(1, maxDelay - minDelay));

        scheduler.schedule(() ->
        {
            clientThread.invokeLater(() ->
            {
                client.menuAction(
                        0,
                        0,
                        MenuAction.NPC_FIRST_OPTION,
                        spotToClick.getIndex(),
                        spotToClick.getId(),
                        "Net",
                        "<col=ffff00>" + spotToClick.getName() + "</col>"
                );

                log.debug("Switched to minnow spot (switch #{}, delay {}ms)", spotSwitchCount, delay);
            });
        }, delay, TimeUnit.MILLISECONDS);
    }

    @Provides
    FishingBuddyConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(FishingBuddyConfig.class);
    }
}