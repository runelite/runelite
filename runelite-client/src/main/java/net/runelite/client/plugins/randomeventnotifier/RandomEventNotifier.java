/*
 * Copyright (c) 2016-2017, Dylan Vollrath
 * Copyright (c) 2017, dylanvoll <https://github.com/dylanvoll>
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

package net.runelite.client.plugins.randomeventnotifier;

import com.google.inject.Provides;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.NpcSpawned;


@PluginDescriptor(
        name = "Random Event Notifier",
        description = "Send a notification when a random event has spawned",
        tags = {"random", "notifications", "event"}
)
@Slf4j
public class RandomEventNotifier extends Plugin{

    @Inject
    private Notifier notifier;

    @Inject
    private Client client;

    @Inject
    private RandomEventNotifierConfig config;

    private NPC lastRandomEventNpc;

    @Provides
    RandomEventNotifierConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(RandomEventNotifierConfig.class);
    }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (randomEventSpawned())
        {
            notifier.notify("[" + lastRandomEventNpc.getName() + "] has spawned!");
            lastRandomEventNpc = null;
        }
    }

    public boolean randomEventSpawned(){
        if(lastRandomEventNpc != null) return true;
        return false;
    }

    @Subscribe
    public void onNpcSpawned(NpcSpawned event)
    {
        final NPC npc = event.getNpc();
        List<String> npcActions = Arrays.asList(npc.getComposition().getActions());
        if (isRandomEventNPC(npc.getId()) && npcActions.contains("Dismiss"))
        {
            lastRandomEventNpc = npc;
        }
    }

    public boolean isRandomEventNPC(int npcId){
        return (npcId == NpcID.DR_JEKYLL && config.drJekyllEnabled()) ||
                //(npcId == NpcID.DR_JEKYLL_314 ||
                (npcId == NpcID.BEE_KEEPER && config.beeKeeperEnabled()) ||
                //(npcId == NpcID.BEE_KEEPER_6747 && config.beeKeeperEnabled()) ||
                (npcId == NpcID.CAPT_ARNAV && config.captArnavEnabled()) ||
                (npcId == NpcID.SERGEANT_DAMIEN && config.sergeantDamienEnabled()) ||
                //(npcId == NpcID.SERGEANT_DAMIEN_6743 && config.sergeantDamienEnabled()) ||
                (npcId == NpcID.DRUNKEN_DWARF && config.drunkenDwarfEnabled()) ||
                (npcId == NpcID.FREAKY_FORESTER && config.freakyForesterEnabled()) ||
                //(npcId == NpcID.FREAKY_FORESTER_6748 && config.freakyForesterEnabled()) ||
                (npcId == NpcID.FROG_PRINCESS && config.frogPrincessEnabled()) ||
                (npcId == NpcID.FROG_PRINCE && config.frogPrincessEnabled()) ||
                (npcId == NpcID.GENIE && config.genieEnabled()) ||
                //(npcId == NpcID.GENIE_327 && config.genieEnabled()) ||
                (npcId == NpcID.EVIL_BOB && config.evilBobEnabled()) ||
                //(npcId == NpcID.EVIL_BOB_391 && config.evilBobEnabled()) ||
                (npcId == NpcID.POSTIE_PETE && config.postiePeteEnabled()) ||
                (npcId == NpcID.LEO && config.leoEnabled()) ||
                //(npcId == NpcID.LEO_6746 && config.leoEnabled()) ||
                (npcId == NpcID.MYSTERIOUS_OLD_MAN && config.mysteriousOldManEnabled()) ||
                //(npcId == NpcID.MYSTERIOUS_OLD_MAN_6750 && config.mysteriousOldManEnabled()) ||
                //(npcId == NpcID.MYSTERIOUS_OLD_MAN_6751 && config.mysteriousOldManEnabled()) ||
                //(npcId == NpcID.MYSTERIOUS_OLD_MAN_6752 && config.mysteriousOldManEnabled()) ||
                //(npcId == NpcID.MYSTERIOUS_OLD_MAN_6753 && config.mysteriousOldManEnabled()) ||
                (npcId == NpcID.PILLORY_GUARD && config.pilloryGuardEnabled()) ||
                //(npcId == NpcID.PILLORY_GUARD_2122 && config.pilloryGuardEnabled()) ||
                (npcId == NpcID.FLIPPA && config.flippaEnabled()) ||
                //(npcId == NpcID.FLIPPA_6744 && config.flippaEnabled()) ||
                (npcId == NpcID.QUIZ_MASTER && config.quizMasterEnabled()) ||
                //(npcId == NpcID.QUIZ_MASTER_6755 && config.quizMasterEnabled()) ||
                (npcId == NpcID.RICK_TURPENTINE && config.rickTurpentineEnabled()) ||
                //(npcId == NpcID.RICK_TURPENTINE_376 && config.rickTurpentineEnabled()) ||
                (npcId == NpcID.SANDWICH_LADY && config.sandwichLadyEnabled()) ||
                (npcId == NpcID.STRANGE_PLANT && config.strangePlantEnabled()) ||
                (npcId == NpcID.DUNCE && config.dunceEnabled()) ||
                //(npcId == NpcID.DUNCE_6749 && config.dunceEnabled()) ||
                //(npcId == NpcID.DUNCE_7775 && config.dunceEnabled()) ||
                (npcId == NpcID.NILES && config.nilesMilesGilesEnabled()) ||
                //(npcId == NpcID.NILES_5439 && config.nilesMilesGilesEnabled()) ||
                (npcId == NpcID.MILES && config.nilesMilesGilesEnabled()) ||
                //(npcId == NpcID.MILES_5440 && config.nilesMilesGilesEnabled()) ||
                (npcId == NpcID.GILES && config.nilesMilesGilesEnabled());
                //(npcId == NpcID.GILES_5441 && config.nilesMilesGilesEnabled());
    }

}
