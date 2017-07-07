/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
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
package net.runelite.client.plugins.xptracker;

import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.PluginPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;

public class XPPanel extends PluginPanel
{
    private static final Logger logger = LoggerFactory.getLogger(XPPanel.class);
    private static HashMap<Skill, JLabel> labelMap = new HashMap<>();
    private static final XPTracker xpTracker = new XPTracker();

    public XPPanel(RuneLite runelite)
    {
        setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        setVisible(true);

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(24, 1));

        try
        {
            for (Skill skill : Skill.values())
            {
                if (skill == Skill.OVERALL)
                    break;

                JLabel skillLabel = new JLabel("--");
                labelMap.put(skill, skillLabel);
                statsPanel.add(makeSkillPanel(skill, skillLabel));
            }
        } catch (IOException e)
        {
            e.printStackTrace();

        }
        JButton resetButton = new JButton("Reset");

        resetButton.addActionListener((ActionEvent e) ->
        {
            ScheduledExecutorService executor = runelite.getExecutor();
            executor.execute(this::reset);
        });
        statsPanel.add(resetButton);

        add(statsPanel);
    }

    private JPanel makeSkillPanel(Skill skill, JLabel levelLabel) throws IOException
    {
        JPanel iconLevel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        iconLevel.setPreferredSize(new Dimension(PANEL_WIDTH, 32));

        String skillIcon = "/skill_icons/" + skill.getName().toLowerCase() + ".png";
        logger.debug("Loading skill icon from {}", skillIcon);

        JLabel icon = new JLabel(new ImageIcon(ImageIO.read(XPPanel.class.getResourceAsStream(skillIcon))));
        iconLevel.add(icon);

        iconLevel.add(levelLabel);

        return iconLevel;
    }

    private void reset()
    {
        xpTracker.resetAll();
    }

    public void resetSkillXpHr(Skill skill)
    {
        labelMap.get(skill).setText("--");
    }

    public void updateSkillXpHr(Skill skill, Double xp)
    {
        labelMap.get(skill).setText(String.format("%.2f", xp));
    }
}

