package net.runelite.client.plugins.mobslocator;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

public class MobsLocatorOverlay extends Overlay
{
    private final Client client;
    private final MobsLocatorPlugin plugin;
    private final MobsLocatorConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public MobsLocatorOverlay(Client client, MobsLocatorPlugin plugin, MobsLocatorConfig config)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPriority(OverlayPriority.HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        Player localPlayer = client.getLocalPlayer();
        if (localPlayer == null)
        {
            return null;
        }

        panelComponent.getChildren().clear();
        panelComponent.setBackgroundColor(config.backgroundColor());

        String searchedMob = config.searchedMob().trim();
        
        if (!searchedMob.isEmpty() && config.showSearchResults())
        {
            renderSearchResults(localPlayer.getWorldLocation());
        }
        else if (config.showAllMobs() || config.showHighLevel())
        {
            renderNearbyMobs(localPlayer.getWorldLocation());
        }

        // If panel is empty, don't render
        if (panelComponent.getChildren().isEmpty())
        {
            return null;
        }

        return panelComponent.render(graphics);
    }

    private void renderSearchResults(WorldPoint playerLocation)
    {
        String searchedMob = config.searchedMob().trim();
        
        // Add search title
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Search Results: " + searchedMob)
            .leftColor(Color.YELLOW)
            .build());

        Map<WorldPoint, Integer> locations = plugin.getSearchedMobLocations();
        
        if (locations.isEmpty())
        {
            panelComponent.getChildren().add(LineComponent.builder()
                .left("No '" + searchedMob + "' found nearby")
                .leftColor(Color.GRAY)
                .build());
            return;
        }

        // Sort locations by distance
        locations.entrySet().stream()
            .sorted((a, b) -> Integer.compare(
                playerLocation.distanceTo(a.getKey()),
                playerLocation.distanceTo(b.getKey())
            ))
            .limit(10) // Show max 10 locations
            .forEach(entry -> {
                WorldPoint location = entry.getKey();
                int count = entry.getValue();
                int distance = playerLocation.distanceTo(location);
                
                StringBuilder locationInfo = new StringBuilder();
                locationInfo.append(String.format("(%d,%d) - %d mob%s", 
                    location.getX(), location.getY(), count, count > 1 ? "s" : ""));
                
                if (config.showDistance())
                {
                    locationInfo.append(" - ").append(distance).append(" tiles");
                }

                Color textColor = distance <= 10 ? Color.GREEN : 
                                distance <= 25 ? Color.YELLOW : config.textColor();

                panelComponent.getChildren().add(LineComponent.builder()
                    .left(locationInfo.toString())
                    .leftColor(textColor)
                    .build());
            });
    }

    private void renderNearbyMobs(WorldPoint playerLocation)
    {
        // Add title
        panelComponent.getChildren().add(LineComponent.builder()
            .left("Nearby Mobs")
            .leftColor(config.textColor())
            .build());

        // Add tracked NPCs
        plugin.getTrackedNPCs().stream()
            .filter(npc -> npc != null && npc.getName() != null && npc.getWorldLocation() != null)
            .filter(npc -> playerLocation.distanceTo(npc.getWorldLocation()) <= 50)
            .sorted((a, b) -> Integer.compare(
                playerLocation.distanceTo(a.getWorldLocation()),
                playerLocation.distanceTo(b.getWorldLocation())
            ))
            .limit(15) // Show max 15 mobs
            .forEach(npc -> {
                int distance = playerLocation.distanceTo(npc.getWorldLocation());
                
                StringBuilder mobInfo = new StringBuilder();
                mobInfo.append(npc.getName());

                if (config.showCombatLevel())
                {
                    mobInfo.append(" (").append(npc.getCombatLevel()).append(")");
                }

                if (config.showDistance())
                {
                    mobInfo.append(" - ").append(distance).append(" tiles");
                }

                panelComponent.getChildren().add(LineComponent.builder()
                    .left(mobInfo.toString())
                    .leftColor(config.textColor())
                    .build());
            });

        // If no mobs found, show message
        if (plugin.getTrackedNPCs().isEmpty())
        {
            panelComponent.getChildren().add(LineComponent.builder()
                .left("No mobs detected")
                .leftColor(Color.GRAY)
                .build());
        }
    }
}