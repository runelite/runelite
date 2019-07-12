package net.runelite.client.plugins.localattack;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import com.google.inject.Provides;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@PluginDescriptor(
        name = "Player Prayer Flicking",
        description = "Highlight the tile of the player when need to pray",
        tags = {"highlight", "overlay"},
        enabledByDefault = false
)
public class LocalAttackPlugin extends Plugin {

    private int tickCounter, lastAnimation, currentAnimation;
    private int speed = 5;
    private boolean sameAnim, counting;
    public boolean renderPlayer;
    public LocalPoint playerLocation;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private LocalAttackOverlay overlay;

    @Inject
    private Client client;

    @Provides
    LocalAttackConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(LocalAttackConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception
    {

        overlayManager.remove(overlay);
    }

    @Subscribe
    public void onGameTick(GameTick tick)
    {
        playerLocation = client.getLocalPlayer().getLocalLocation();
        renderPlayer = false;
        tickCounter++;
        sameAnim = false;
        if(!isInCombat())
        {
            tickCounter = 0;
            counting = false;
            lastAnimation = client.getLocalPlayer().getAnimation();
            return;
        }
        else{
            //System.out.println("combat");
            currentAnimation = client.getLocalPlayer().getAnimation();
            if(currentAnimation == lastAnimation && lastAnimation != -1){
                sameAnim = true;
                //System.out.println("same anim");
            }
            if(counting){
                if(tickCounter == speed - 1 ||
                    tickCounter == speed - 2){
                    renderPlayer = true;
                    System.out.println("display");
                }
            }
            if(currentAnimation == 1658 && !sameAnim){
                counting = true;
                tickCounter = 1;
                System.out.println("reset");
            }

//            if(!sameAnim){
//                if(counting){
//                    if (tickCounter == 6){
//                        System.out.println("display");
//                        tickCounter = 0;
//                        renderPlayer = true;
//                    }
//                }
//                else{
//                    System.out.println("starting");
//                    tickCounter = 1;
//                    counting = true;
//                }
//            }
        }

        lastAnimation = client.getLocalPlayer().getAnimation();
    }

    private boolean isInCombat(){
        //boolean inCombat;
        Player local = client.getLocalPlayer();
        Actor target = local.getInteracting();
        final boolean isNpc = target instanceof NPC;
        if (!isNpc)
        {
            //System.out.println("not in combat");
            //inCombat = false;
            return false;
        }
        final NPC npc = (NPC) target;
        final NPCComposition npcComposition = npc.getComposition();
        final List<String> npcMenuActions = Arrays.asList(npcComposition.getActions());
        if (npcMenuActions.contains("Attack"))
        {
            //System.out.println("in combat");
            //inCombat = true;
            //System.out.println("combat");
            return true;
        }
        return false;
    }

}
