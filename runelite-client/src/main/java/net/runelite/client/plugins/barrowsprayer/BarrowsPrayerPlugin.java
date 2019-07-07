package net.runelite.client.plugins.barrowsprayer;

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
        name = "Barrows Prayer Flicking",
        description = "Highlight the tile of the barrows brothers when need to pray",
        tags = {"highlight", "overlay"},
        enabledByDefault = false
)
public class BarrowsPrayerPlugin extends Plugin
{



    //key value pairs of attack speeds for brothers
    private final BarrowsBrother ahrim = new BarrowsBrother(1672,6,1167, "Ahrim");
    private final BarrowsBrother dharok = new BarrowsBrother(1673,7,2067, "Dharok");
    private final BarrowsBrother guthan = new BarrowsBrother(1674,5,2080,"Guthan");
    private final BarrowsBrother karil = new BarrowsBrother(1675,4,2075,"Karil");
    private final BarrowsBrother torag = new BarrowsBrother(1676,5,2068,"Torag");
    private final BarrowsBrother verac = new BarrowsBrother(1677,5,2062,"Verac");

    private BarrowsBrother[] brothers = {ahrim,dharok,guthan,karil,torag,verac};

    public int tickCounter, npcAnimation, npcAttkSpeed, lastNpcAnim, countdown, npcID;
    public String brotherName = "";
    private boolean renderNpcTile = false; //do we render tile
    private boolean readyToDisplay = false; //we have animation and tick count
    private boolean counting = false;
    private boolean ahrimAnim = false;
    private int[] ahrimAttkAnim ={1163,1164,1165,1166,1167};
    private LocalPoint npcLocation;
    private boolean inCombat = false;
    public boolean getInCombat(){
        return  inCombat;
    }

    //accessors and mutators
    public LocalPoint getNpcLocation(){
        return npcLocation;
    }
    public boolean getRenderNpcTile() {
        return renderNpcTile;
    }

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private BarrowsPrayerOverlay overlay;

    @Inject
    private BarrowsBoxOverlay boxOverlay;

    @Inject
    private Client client;


    @Provides
    BarrowsPrayerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(BarrowsPrayerConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(overlay);
        overlayManager.add(boxOverlay);
    }

    @Override
    protected void shutDown() throws Exception
    {

        overlayManager.remove(overlay);
        overlayManager.remove(boxOverlay);
    }

    @Subscribe
    public void onGameTick(GameTick tick){
        renderNpcTile = false;
        tickCounter++;
        ahrimAnim = false;
        if(!isInCombat()){
            readyToDisplay = false;
            npcAttkSpeed = -1;
        }
        else{
            NPC npc = (NPC) client.getLocalPlayer().getInteracting();
            npcLocation = npc.getLocalLocation();
            if(readyToDisplay){
                if(tickCounter >= npcAttkSpeed+1){
                    //renderNpcTile = true;
                    tickCounter = 1;
                }
                if(tickCounter == npcAttkSpeed ||
                    tickCounter == npcAttkSpeed - 1){
                    renderNpcTile = true;
                }
            }
            else{
                for(BarrowsBrother b : brothers){
                    if(b.getNpcID() == npc.getId()){
                        if(b.getNpcID() == 1672){
                            if(checkAhrimAnim(npc)){
                                ahrimAnim = true;
                            }
                        }
                        if((npc.getAnimation() == b.getAttkAnim() && npc.getAnimation() != lastNpcAnim)
                            || ahrimAnim){
                            tickCounter = 1;
                            readyToDisplay = true;
                            npcAttkSpeed = b.getAttkSpeed();
                        }
                    }
                }
            }
        }
        lastNpcAnim = client.getLocalPlayer().getInteracting().getAnimation();
    }

    private boolean checkAhrimAnim(NPC npc){
        for(int a : ahrimAttkAnim){
            if(npc.getAnimation() == a && npc.getAnimation() != lastNpcAnim){
                return true;
            }
        }
        return false;
    }

//    @Subscribe
//    public void onHitsplatApplied(HitsplatApplied event){
//        if (event.getActor() != client.getLocalPlayer()){return;}
//        renderNpcTile = true;
//        System.out.println("display");
//        NPC npc = (NPC) client.getLocalPlayer().getInteracting();
//        npcLocation = npc.getLocalLocation();
//        for(BarrowsBrother b : brothers){
//            if(b.getNpcID() == npc.getId()){
//                //System.out.println("display");
//                //renderNpcTile = true;
//                counting = true;
//                tickCounter = 1;//0;
//                npcAttkSpeed = b.getAttkSpeed();
//
//            }
//        }
//    }

    //gets the player animation
    private int getInteractNpcAnimation(NPC npc){
        int animation;

        animation = npc.getAnimation();

        return animation;
    }
    //something has gone wrong and we need to reset and try again
//    private void resetAll(){
//        //reset variables to default values
//        tickCounter = 0;
//        renderNpcTile = false;
//        readyToDisplay = false;
//    }

    private boolean isInCombat(){
        //boolean inCombat;
        Player local = client.getLocalPlayer();
        Actor target = local.getInteracting();
        final boolean isNpc = target instanceof NPC;
        if (!isNpc)
        {
            //System.out.println("not in combat");
            inCombat = false;
            return false;
        }
        final NPC npc = (NPC) target;
        final NPCComposition npcComposition = npc.getComposition();
        final List<String> npcMenuActions = Arrays.asList(npcComposition.getActions());
        if (npcMenuActions.contains("Attack"))
        {
            //System.out.println("in combat");
            inCombat = true;
            //System.out.println("combat");
            return true;
        }
        return false;
    }





}


//    @Subscribe
//    public void onGameTick(GameTick tick)
//    {
//        //by default want playerTile not be rendered
//        renderNpcTile = false;
//        //increment counter
//        tickCounter++;
//        //System.out.println(tickCounter);
//        npcID = -1;
//
//        Player player = client.getLocalPlayer();
//
//        if (!isInCombat()){
//            inCombat = false;
//            counting = false;
//            npcAttkSpeed = -1;
//        }
//        else{
//            npcLocation = client.getLocalPlayer().getInteracting().getLocalLocation();
//            if(counting){
//                if(tickCounter == npcAttkSpeed -2 ||
//                    tickCounter == npcAttkSpeed -1){
//                    renderNpcTile = true;
//                }
//                if(tickCounter >= npcAttkSpeed){
//                    tickCounter = 0;
//                }
//
//            }
//        }
//
//        //we aren't in combat so we don't need to do anything
//        //System.out.println("pls print");
//        if (!isInCombat()){
//            //System.out.println("returning");
//            readyToDisplay = false;
//            counting = false;
//            lastNpcAnim = -1;
//            npcAttkSpeed = -1;
//            brotherName = "";
//            countdown = -1;
//            return;
//        }
//        else {//in combat
//
//            NPC npc = (NPC) client.getLocalPlayer().getInteracting();
//            npcLocation = npc.getLocalLocation();
//            //System.out.println("npc get");
//            for (BarrowsBrother b: brothers) {
//                //we are fighting barrows brother
//                if (npc.getId() == b.getNpcID()){
//                    //System.out.println("barrows brother");
//                    npcAnimation = npc.getAnimation();
//                    //not started counting for the next attack
//                    countdown--;
//                    npcID = b.getNpcID();
//                    if (!counting){
//                        //if they are starting their animation, this is when take dmg
//                        if (npcAnimation == b.getAttkAnim() &&
//                            npcAnimation != lastNpcAnim){
//                            brotherName = b.getName();
//                            counting = true;
//                            tickCounter = 1;
//                            npcAttkSpeed = b.getAttkSpeed();
//                            countdown = npcAttkSpeed;
//                        }
//                    }
//                    //we are counting to next attack
//                    else{
////                        if (tickCounter == npcAttkSpeed) {
////                            readyToDisplay = true;
////                            tickCounter = 1;
////                        }
//                        if(tickCounter == npcAttkSpeed ||
//                            tickCounter == npcAttkSpeed-1){
//                            renderNpcTile = true;
//                        }
//                        if (tickCounter >= npcAttkSpeed + 1 &&//npcAnimation == b.getAttkAnim() &&
//                                npcAnimation != lastNpcAnim){
//                            tickCounter = 1;
//                            countdown = npcAttkSpeed;
//                        }
//                    }
//                    if (npcID == karil.getNpcID()){renderNpcTile = !renderNpcTile;}
//                }
//            }
//        }
//        lastNpcAnim = client.getLocalPlayer().getInteracting().getAnimation();
//
//
//    }