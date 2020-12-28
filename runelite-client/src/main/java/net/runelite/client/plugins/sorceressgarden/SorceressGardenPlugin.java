package net.runelite.client.plugins.sorceressgarden;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.*;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.StatChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(
        name = "Sorceress Garden",
        enabledByDefault = false,
        description = "Provides various utilities for the Sorceress's Garden minigame",
        tags = {"sorceress", "garden", "sqirk", "sq'irk", "thieving", "farming","willem","fun"}
)

@PluginDependency(XpTrackerPlugin.class)
public class SorceressGardenPlugin extends Plugin
{
    private static final int GARDEN_REGION = 11605;
    private int newxp ;
    private int lastxp ;

    @Inject
    private SorceressGardenConfig config;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private SorceressGardenOverlay sorceressGardenOverlay;

    @Inject
    private SorceressSqirkOverlay sorceressSqirkOverlay;

    @Inject
    private SorceressSession sorceressSession;

    @Inject
    private Client client;

    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PACKAGE)
    private List<NPC> Targets = new ArrayList<>();

    @Provides
    SorceressGardenConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(SorceressGardenConfig.class);
    }

    @Override
    protected void startUp()
    {
        // runs on plugin startup
        overlayManager.add(sorceressGardenOverlay);
        overlayManager.add(sorceressSqirkOverlay);
        Targets.clear();
        lastxp = client.getSkillExperience(Skill.FARMING);
    }

    @Override
    protected void shutDown()
    {
        // runs on plugin shutdown
        overlayManager.remove(sorceressGardenOverlay);
        overlayManager.remove(sorceressSqirkOverlay);
        Targets.clear();
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!event.getGroup().equals("SorceressGarden"))
        {
            return;
        }

        if (event.getKey().equals("mirrorMode"))
        {
            sorceressGardenOverlay.determineLayer();
            sorceressGardenOverlay.determineLayer();
            overlayManager.remove(sorceressGardenOverlay);
            overlayManager.remove(sorceressSqirkOverlay);
            overlayManager.add(sorceressSqirkOverlay);
            overlayManager.add(sorceressGardenOverlay);
        }
    }

    @Subscribe
    private void onStatChanged(StatChanged event)
    {
        if (!config.showSqirksStats())
        {
            return;
        }
        newxp = client.getSkillExperience(Skill.FARMING);
        int diff = newxp - lastxp;
        // Switch based off of XP gained, this is how we determine which Sqi'rk was picked
        if (event.getSkill() == Skill.FARMING && isInGarden())
        {
            lastxp = newxp;
            switch (event.getXp())
            {
                case 30:
                    sorceressSession.incrementSqirks(ItemID.WINTER_SQIRK);
                    break;
                case 40:
                    sorceressSession.incrementSqirks(ItemID.SPRING_SQIRK);
                    break;
                case 50:
                    sorceressSession.incrementSqirks(ItemID.AUTUMN_SQIRK);
                    break;
                case 60:
                    sorceressSession.incrementSqirks(ItemID.SUMMER_SQIRK);
                    break;
            }
        }
    }
    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned){
        NPC npc = npcSpawned.getNpc();
        int northSummerNPCID = NpcID.SUMMER_ELEMENTAL_1802;
        int southSummerNPCID = NpcID.SUMMER_ELEMENTAL;
        int winterNPCID = NpcID.WINTER_ELEMENTAL;
        if(npc.getId() == northSummerNPCID || npc.getId() == southSummerNPCID || npc.getId() == winterNPCID){
            Targets.add(npc);
        }
    }
    @Subscribe
    public void onNpcDespawned(NpcDespawned npcDespawned){
        NPC npc = npcDespawned.getNpc();
        Targets.remove(npc);
    }

    boolean isInGarden()
    {
        return client.getMapRegions() != null && ArrayUtils.contains(client.getMapRegions(), GARDEN_REGION);
    }
}