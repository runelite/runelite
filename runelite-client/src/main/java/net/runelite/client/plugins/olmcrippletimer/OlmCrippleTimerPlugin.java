package net.runelite.client.plugins.olmcrippletimer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name="Olm Cripple Timer",
        description = "Shows a timer over the olm hand cripple",
        tags = {"cox", "raid", "clench", "melee", "hand"},
        type = PluginType.PVM
)

public class OlmCrippleTimerPlugin extends Plugin{

    private static final String OLM_HAND_CRIPPLE = "The Great Olm\'s left claw clenches to protect itself temporarily.";
    @Inject
    private Client client;
    @Getter(AccessLevel.PACKAGE)
    private boolean HandCripple;
    @Getter(AccessLevel.PACKAGE)
    private int timer = 45;
    @Getter(AccessLevel.PACKAGE)
    private NPC hand;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private OlmCrippleTimerOverlay olmCrippleTimerOverlay;

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(olmCrippleTimerOverlay);
    }
    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(olmCrippleTimerOverlay);
        HandCripple = false;
        timer = 45;
        hand = null;

    }
    @Subscribe
    public void onChatMessage(ChatMessage event)
    {

        String message = event.getMessage();
        if(message.startsWith(OLM_HAND_CRIPPLE)){
            HandCripple = true;
            timer = 45;
        }
    }
    @Subscribe
    public void onNpcDespawned(NpcDespawned npcdespawned){
        if(npcdespawned.getNpc().getId() == NpcID.GREAT_OLM_RIGHT_CLAW_7553 || npcdespawned.getNpc().getId() == NpcID.GREAT_OLM_RIGHT_CLAW){
            HandCripple = false;
        }
    }
    @Subscribe
    public void onNpcSpawned(NpcSpawned npcSpawned)
    {
        if(npcSpawned.getNpc().getId() == NpcID.GREAT_OLM_LEFT_CLAW_7555 || npcSpawned.getNpc().getId() == NpcID.GREAT_OLM_LEFT_CLAW){
            hand = npcSpawned.getNpc();
        }
    }
    @Subscribe
    public void onGameTick(GameTick event)
    {
        if(HandCripple) {
            timer--;
            if (timer <= 0) {
                HandCripple = false;
                timer = 45;
            }
        }
    }
}
