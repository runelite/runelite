package net.runelite.client.plugins.vanguards;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Varbits;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(name = "Vanguards",
        enabledByDefault = false
)
public class VanguardsPlugin extends Plugin {
final int MAGE = 7529;
final int RANGE = 7528;
final int MELEE = 7527;
final int DOWN = 7526;
public ArrayList<Integer> ids = new ArrayList<Integer>();
public NPC ranger;
public NPC mager;
public NPC meleer;
public boolean inRaid;
public boolean magerFound;
public boolean rangerFound;
public boolean meleeFound;
public int mageHP = -1;
public int rangeHP = -1;
public int meleeHP = -1;
public float percent;
public boolean inVangs;
    @Inject
    private Client client;

    @Inject
    private VanguardsConfig config;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private VanguardsOverlay overlay;

    @Inject
    private VanguardsHighlight highlight;

    @Provides
    VanguardsConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(VanguardsConfig.class);
    }

    @Override
    protected void startUp()
    {
        overlayManager.add(overlay);
        overlayManager.add(highlight);
        ids.add(MAGE);
        ids.add(RANGE);
        ids.add(MELEE);
        ids.add(DOWN);
        inRaid = false;
        inVangs = false;
        meleeFound = false;
        rangerFound = false;
        magerFound = false;
    }

    @Override
    protected void shutDown()
    {
        overlayManager.remove(overlay);
        overlayManager.remove(highlight);
    }

    @Subscribe
    public void onGameTick(GameTick tick){
        if(!inRaid){
            return;
        }
        List<NPC> npcs = client.getNpcs();
        inVangs = false;
        for(NPC npc : npcs){

            if(!ids.contains(npc.getId())){
                continue;
            }
            inVangs = true;
            int currentId = npc.getId();
            switch (currentId) {
                case MAGE:
                    percent = (float)npc.getHealthRatio() / npc.getHealth() * 100;
                    mageHP = (int) percent;
                    mager = npc;
                    break;
                case RANGE:
                    percent = (float)npc.getHealthRatio() / npc.getHealth() * 100;
                    rangeHP = (int) percent;
                    ranger = npc;
                    break;
                case MELEE:
                    percent = (float)npc.getHealthRatio() / npc.getHealth() * 100;
                    meleeHP = (int) percent;
                    meleer = npc;
                    break;
                case DOWN:
                    break;
                default:

            }

        }

    }
    @Subscribe
    public void onVarbitChanged(VarbitChanged bit){
        if(client.getVar(Varbits.IN_RAID) == 1){
            inRaid = true;
        }else{
            inRaid = false;
        }
    }
}
