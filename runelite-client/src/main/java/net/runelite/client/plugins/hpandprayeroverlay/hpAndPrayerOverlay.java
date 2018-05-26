/*
 * Copyright (c) 2018, Jos <Malevolentdev@gmail.com>
 * Creation date : 26-5-2018
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
package net.runelite.client.plugins.hpandprayeroverlay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class hpAndPrayerOverlay extends Overlay
{
    private final Client client;
    private hpAndPrayerPlugin plugin;
    private hpAndPrayerConfig config;

    @Inject
    public hpAndPrayerOverlay(Client client, hpAndPrayerPlugin plugin, hpAndPrayerConfig config)
    {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        this.client = client;
        this.plugin = plugin;
        this.config = config;
    }
    @Inject
    private SkillIconManager iconManager;


    @Override
    public Dimension render(Graphics2D g) {

        int realHpLevel = client.getRealSkillLevel(Skill.HITPOINTS);
        int realPrayerLevel = client.getRealSkillLevel(Skill.PRAYER);
        int boostedHpLevel = client.getBoostedSkillLevel(Skill.HITPOINTS);
        int boostedPrayerLevel = client.getBoostedSkillLevel(Skill.PRAYER);
        int healthBarheight = (boostedHpLevel * 224) / realHpLevel;
        int prayerBarheight = (boostedPrayerLevel * 224) / realPrayerLevel;
        int healthBarPosition = 455 - healthBarheight;
        int prayerBarPosition = 453 - prayerBarheight;

        if (config.enableHP()){

            // Fixed bars for fixed client
            g.setColor(Color.BLACK);
            g.fillRect(530, 229,13,228);
            g.setColor(Color.red);
            g.fillRect(532, 231,9,224);
            g.drawImage(iconManager.getSkillImage(Skill.HITPOINTS),527,209,20,18,null);

            // dynamic bar
            g.setColor(Color.GREEN);
            g.fillRect(532, healthBarPosition,9, healthBarheight);
        }

        if (config.enablePray()){

            // Fixed bars for fixed client
            g.setColor(Color.BLACK);
            g.fillRect(741, 227,13,228);
            g.setColor(Color.BLUE);
            g.fillRect(743, 229,9,224);
            g.drawImage(iconManager.getSkillImage(Skill.PRAYER),736,204,23,23,null);

            //dynamic bar
            g.setColor(Color.CYAN);
            g.fillRect(743, prayerBarPosition,9,prayerBarheight);

        }

        // Resizable position settings are changed here
        if (client.isResized()){
            setPosition(OverlayPosition.BOTTOM_RIGHT);

            Color c=new Color(90,91,94,127 );
            g.setColor(c);
            g.fillRect(-43, -133,53,258);

            if (config.enableHP()){

                // Fixed bars for fixed client
                g.setColor(Color.BLACK);
                g.fillRect(-34, -106,13,228);
                g.setColor(Color.red);
                g.fillRect(-32, -104,9,224);
                g.drawImage(iconManager.getSkillImage(Skill.HITPOINTS),-37,-125,20,18,null);

                // dynamic bar
                g.setColor(Color.GREEN);
                g.fillRect(-32, 120 - healthBarheight,9, healthBarheight);
            }

            if (config.enablePray()){
                // Fixed bars for fixed client
                g.setColor(Color.BLACK);
                g.fillRect(-10, -106,13,228);
                g.setColor(Color.BLUE);
                g.fillRect(-8, -104,9,224);
                g.drawImage(iconManager.getSkillImage(Skill.PRAYER),-15,-130,23,23,null);

                //dynamic bar
                g.setColor(Color.CYAN);
                g.fillRect(0 - 8,  120 - prayerBarheight,9,prayerBarheight);
            }
        }
        else
            setPosition(OverlayPosition.DYNAMIC);
        return null;
    }
}

