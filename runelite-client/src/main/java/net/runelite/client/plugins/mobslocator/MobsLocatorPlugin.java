package net.runelite.client.plugins.mobslocator;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import java.util.*;
import java.util.stream.Collectors;

@PluginDescriptor(
    name = "Mobs Locator",
    description = "Locate and track mobs around you with search functionality",
    tags = {"mobs", "npc", "locate", "monsters", "search"}
)
public class MobsLocatorPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private MobsLocatorConfig config;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private MobsLocatorOverlay overlay;

    @Inject
    private MobsLocatorMinimapOverlay minimapOverlay;

    private final Set<NPC> trackedNPCs = new HashSet<>();
    private final Map<String, List<NPC>> mobsByName = new HashMap<>();
    private final Map<String, Map<WorldPoint, Integer>> mobLocationCounts = new HashMap<>();

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
        overlayManager.add(minimapOverlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(overlay);
        overlayManager.remove(minimapOverlay);
        trackedNPCs.clear();
        mobsByName.clear();
        mobLocationCounts.clear();
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
        {
            trackedNPCs.clear();
            mobsByName.clear();
            mobLocationCounts.clear();
        }
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned)
    {
        NPC npc = npcSpawned.getNpc();
        if (npc != null && shouldTrackNPC(npc))
        {
            trackedNPCs.add(npc);
            updateMobMaps(npc, true);
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned)
    {
        NPC npc = npcDespawned.getNpc();
        if (trackedNPCs.remove(npc))
        {
            updateMobMaps(npc, false);
        }
    }

    private void updateMobMaps(NPC npc, boolean add)
    {
        String mobName = npc.getName();
        if (mobName == null) return;

        // Update mobsByName map
        if (add)
        {
            mobsByName.computeIfAbsent(mobName, k -> new ArrayList<>()).add(npc);
        }
        else
        {
            List<NPC> npcs = mobsByName.get(mobName);
            if (npcs != null)
            {
                npcs.remove(npc);
                if (npcs.isEmpty())
                {
                    mobsByName.remove(mobName);
                }
            }
        }

        // Update location counts
        WorldPoint location = npc.getWorldLocation();
        if (location != null)
        {
            Map<WorldPoint, Integer> locationCounts = mobLocationCounts.computeIfAbsent(mobName, k -> new HashMap<>());
            
            if (add)
            {
                locationCounts.put(location, locationCounts.getOrDefault(location, 0) + 1);
            }
            else
            {
                int count = locationCounts.getOrDefault(location, 0);
                if (count <= 1)
                {
                    locationCounts.remove(location);
                }
                else
                {
                    locationCounts.put(location, count - 1);
                }
            }
            
            if (locationCounts.isEmpty())
            {
                mobLocationCounts.remove(mobName);
            }
        }
    }

    private boolean shouldTrackNPC(NPC npc)
    {
        if (npc.getName() == null || npc.getCombatLevel() < 1)
        {
            return false;
        }

        // Always track searched mob
        String searchedMob = config.searchedMob().trim().toLowerCase();
        if (!searchedMob.isEmpty() && npc.getName().toLowerCase().contains(searchedMob))
        {
            return true;
        }

        // Track other mobs based on config
        return config.showAllMobs() || 
               (config.showHighLevel() && npc.getCombatLevel() >= config.minCombatLevel());
    }

    public Set<NPC> getTrackedNPCs()
    {
        return trackedNPCs;
    }

    public List<String> getAvailableMobNames()
    {
        return trackedNPCs.stream()
            .map(NPC::getName)
            .filter(Objects::nonNull)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }

    public List<NPC> getSearchedMobs()
    {
        String searchedMob = config.searchedMob().trim().toLowerCase();
        if (searchedMob.isEmpty())
        {
            return Collections.emptyList();
        }

        return trackedNPCs.stream()
            .filter(npc -> npc.getName() != null && 
                          npc.getName().toLowerCase().contains(searchedMob))
            .collect(Collectors.toList());
    }

    public Map<WorldPoint, Integer> getSearchedMobLocations()
    {
        String searchedMob = config.searchedMob().trim().toLowerCase();
        if (searchedMob.isEmpty())
        {
            return Collections.emptyMap();
        }

        Map<WorldPoint, Integer> allLocations = new HashMap<>();
        
        for (Map.Entry<String, Map<WorldPoint, Integer>> entry : mobLocationCounts.entrySet())
        {
            if (entry.getKey().toLowerCase().contains(searchedMob))
            {
                for (Map.Entry<WorldPoint, Integer> locationEntry : entry.getValue().entrySet())
                {
                    allLocations.merge(locationEntry.getKey(), locationEntry.getValue(), Integer::sum);
                }
            }
        }
        
        return allLocations;
    }

    @Provides
    MobsLocatorConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(MobsLocatorConfig.class);
    }
}