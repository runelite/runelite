/*
 * Copyright (c) 2019, Abiyaz C <chowdh2@cooper.edu>
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

package net.runelite.client.plugins.driftnet;

import com.google.inject.Provides;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.HashSet;

@PluginDescriptor(
        name = "DriftNet Helper",
        description = "Provides various overlays to assist with underwater driftnet fishing.",
        tags = {"overlay", "fishing"}
)

public class DriftNetPlugin extends Plugin {
    private final int NORTH_NET_ID = 31433;
    private final int SOUTH_NET_ID = 31434;

    DriftNet northNet = new DriftNet();
    DriftNet southNet = new DriftNet();

    private NPC interacting = null;

    @Getter
    private HashMap<NPC,Long> fishes = new HashMap<>();

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private DriftNetConfig config;

    @Inject
    private DriftNetOverlay driftNetOverlay;

    @Inject
    private InfoBoxOverlay infoBoxOverlay;


    @Inject
    private Client client;

    @Getter
    private HashSet<NPC> bosses = new HashSet<>();

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(driftNetOverlay);
        overlayManager.add(infoBoxOverlay);
    }

    @Override
    protected void shutDown() throws Exception
    {
        overlayManager.remove(driftNetOverlay);
        overlayManager.remove(infoBoxOverlay);
    }

    @Provides
    DriftNetConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(DriftNetConfig.class);
    }

    @Subscribe
    public void onGameObjectSpawned(GameObjectSpawned event)
    {
        GameObject gameObject = event.getGameObject();
        //ObjectComposition objectComposition = client.getObjectDefinition(gameObject.getId());
        if (event.getGameObject().getId() == SOUTH_NET_ID){
            southNet.setDriftNet(gameObject);
        }else if (event.getGameObject().getId() == NORTH_NET_ID) {
            northNet.setDriftNet(gameObject);
        }
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded event){
        DriftNet net = null;
        if (event.getIdentifier() == SOUTH_NET_ID){
            net = southNet;
        }else if (event.getIdentifier() == NORTH_NET_ID) {
            net = northNet;
        }
        if (net != null) {
            if (event.getOption() != null) {
                if (event.getTarget().toLowerCase().contains("(full)")) {
                    net.setNetStatus(DriftNet.DriftNetStatus.FULL);
                } else if (event.getOption().toLowerCase().contains("set")) {
                    net.setNetStatus(DriftNet.DriftNetStatus.UNSET);
                } else {
                    net.setNetStatus(DriftNet.DriftNetStatus.SET);
                }
            }
        }
    }

    @Subscribe
    public void onGameObjectDespawned(GameObjectDespawned event)
    {
        if (event.getGameObject().getId() == SOUTH_NET_ID){
            southNet.setDriftNet(null);
        }else if (event.getGameObject().getId() == NORTH_NET_ID) {
            northNet.setDriftNet(null);
        }
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned event){
        NPC npc = event.getNpc();
        if (npc.getId() == NpcID.FISH_SHOAL){
            fishes.put(npc,-1L);
        }
    }

    @Subscribe
    public void onNpcDespawned(NpcDespawned event){
        NPC npc = event.getNpc();
        if (npc.getId() == NpcID.FISH_SHOAL){
            fishes.remove(npc);
        }
    }

    @Subscribe
    public void onInteractingChanged(InteractingChanged event){
        if (event.getSource() == client.getLocalPlayer()){
            if (event.getTarget() instanceof NPC){
                if (((NPC)event.getTarget()).getId() == NpcID.FISH_SHOAL){
                    interacting = (NPC) event.getTarget();
                }
            }
        }

    }

    @Subscribe
    public void onGameTick(GameTick tick){
        for (NPC fish: fishes.keySet()){
            if (fishes.get(fish) > 0){
                if (System.currentTimeMillis() - fishes.get(fish) > 1000*config.highlightDuration()){
                    fishes.put(fish,-1L);
                }
            }
        }
    }

    @Subscribe
    public void onChatMessage(ChatMessage event){
        if (event.getType() != ChatMessageType.SPAM && event.getType() != ChatMessageType.GAMEMESSAGE)
        {
            return;
        }
        if (event.getMessage().toLowerCase().contains("prod at")){
        	fishes.put(interacting,System.currentTimeMillis());
        }
    }

}