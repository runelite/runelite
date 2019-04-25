/*
 * Copyright (c) 2018, https://runelitepl.us
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
