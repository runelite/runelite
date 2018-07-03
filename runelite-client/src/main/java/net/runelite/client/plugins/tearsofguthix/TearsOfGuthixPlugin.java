/*
 * Copyright (c) 2018, Johanna Jennekvist <https://github.com/aquivers>
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
package net.runelite.client.plugins.tearsofguthix;

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameTick;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "Tears of Guthix",
        enabledByDefault = true
)

@Slf4j
public class TearsOfGuthixPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private TearsOfGuthixOverlay overlay;

    private int tearsOfGuthixRegionID = 12948;

    public Skill playerLowestSkill;

    public boolean overlayActivated = false;

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
    public void onGameTick(GameTick gameTick)
    {
        if(client.getGameState() != GameState.LOGGED_IN)
        {
            return;
        }

        if(client.getLocalPlayer().getWorldLocation().getRegionID() == tearsOfGuthixRegionID)
        {
            activateTearsOverlay();
        }
        else
        {
            disableTearsOverlay();
        }
    }

    private void activateTearsOverlay()
    {
        if(!overlayActivated)
        {
            //Check to make sure player experience is loaded
            if(client.getSkillExperience(Skill.HITPOINTS) > 0)
            {
                playerLowestSkill = getLowestPlayerSkill();
                overlayActivated = true;
            }
        }
    }

    private void disableTearsOverlay()
    {
        if(overlayActivated)
        {
            overlayActivated = false;
        }
    }

    private Skill getLowestPlayerSkill()
    {
        Skill[] playerSkills = Skill.values();

        Skill lowestExperienceSkill = null;
        int lowestExperienceAmount = Integer.MAX_VALUE;

        for(Skill skill : playerSkills)
        {
            int currentSkillExp = client.getSkillExperience(skill);
            if(currentSkillExp < lowestExperienceAmount)
            {
                lowestExperienceAmount = currentSkillExp;
                lowestExperienceSkill = skill;
            }
        }
        return lowestExperienceSkill;
    }

    public Client getClient(){
        return client;
    }

}
