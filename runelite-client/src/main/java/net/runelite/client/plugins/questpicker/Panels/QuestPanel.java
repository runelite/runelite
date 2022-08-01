/*
 * Copyright (c) 2020, Christopher Oswald <https://github.com/cesoun>
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
package net.runelite.client.plugins.questpicker.Panels;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.client.plugins.questpicker.GuideConfig;
import net.runelite.client.plugins.questpicker.QuestInfo;
import net.runelite.client.plugins.questpicker.QuestRequirement;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.LinkBrowser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

@Slf4j
public class QuestPanel extends JPanel {

    private final Client c;
    private final GuideConfig config;

    private final JPanel qHeader = new JPanel();
    private final JPanel qRequirements = new JPanel();
    private final JLabel qLabel = new JLabel();

    @Getter
    private final QuestInfo quest;

    private final HashMap<String, JLabel> skillMap = new HashMap<>();

    public QuestPanel(Client c, GuideConfig config, QuestInfo quest) {
        this.c = c;
        this.config = config;
        this.quest = quest;

        setLayout(new GridBagLayout());
        setBackground(ColorScheme.DARKER_GRAY_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.gridx = 0;

        qHeader.setBorder(new EmptyBorder(5, 0, 5, 0));
        qHeader.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        qLabel.setText(quest.getName());
        qLabel.setFont(FontManager.getRunescapeBoldFont());
        qLabel.setHorizontalAlignment(SwingConstants.CENTER);
        qLabel.setVerticalAlignment(SwingConstants.CENTER);

        qHeader.add(qLabel, BorderLayout.NORTH);

        // Menu Item(s)
        JMenuItem openWiki = new JMenuItem("Open Wiki Guide");
        openWiki.addActionListener(e -> LinkBrowser.browse(quest.getUri()));

        // Popup Menu
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
        popupMenu.add(openWiki);

        add(qHeader, gbc);
        gbc.gridy++;

        if (quest.getReqs().length > 0) {
            addSkillReqs(quest.getReqs());
            add(qRequirements, gbc);
        }

        setComponentPopupMenu(popupMenu);
    }

    private void addSkillReqs(QuestRequirement[] requirements) {
        qRequirements.setLayout(new GridBagLayout());
        qRequirements.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.ipadx = 5;
        gbc.ipady = 5;

        for (QuestRequirement requirement : requirements) {
            JPanel reqGroup = new JPanel();
            reqGroup.setLayout(new GridBagLayout());
            reqGroup.setBackground(ColorScheme.DARKER_GRAY_COLOR);

            GridBagConstraints c = new GridBagConstraints();
            c.ipadx = 5;

            JLabel icon = new JLabel(new ImageIcon(requirement.getIcon()));
            icon.setHorizontalAlignment(SwingConstants.CENTER);
            icon.setVerticalAlignment(SwingConstants.CENTER);
            icon.setPreferredSize(new Dimension(25, 25));

            JLabel level = new JLabel();
            level.setFont(FontManager.getRunescapeSmallFont());
            level.setText(String.valueOf(requirement.getLevel()));
            level.setHorizontalAlignment(SwingConstants.CENTER);
            level.setVerticalAlignment(SwingConstants.CENTER);

            reqGroup.add(icon, c);
            reqGroup.add(level, c);

            // Add the level label to the hashmap to be updated later.
            skillMap.put(requirement.getSkill().toLowerCase(), level);

            qRequirements.add(reqGroup, gbc);
            gbc.gridx++;

            if (gbc.gridx > 4) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }
    }

    public void update(QuestInfo quest) {
        SwingUtilities.invokeLater(() -> {
            if (quest == null) return;
            if (quest.getQuestState() == null) return;

            if (quest.getQuestState() == QuestState.IN_PROGRESS)
                qLabel.setForeground(config.getInProgressColor());
            else if (quest.getQuestState() == QuestState.FINISHED)
                qLabel.setForeground(config.getCompletedColor());
            else
                qLabel.setForeground(config.getNotStartedColor());

            for (QuestRequirement requirement : quest.getReqs()) {
                if (this.c.getLocalPlayer() == null) continue;

                String skill = requirement.getSkill();

                if (skill.equalsIgnoreCase("quest points")) {
                    updateRequirement(requirement, skill, this.c.getVarpValue(VarPlayer.QUEST_POINTS.getId()));
                } else if (skill.equalsIgnoreCase("combat level")) {
                    updateRequirement(requirement, skill, this.c.getLocalPlayer().getCombatLevel());
                } else {
                    updateRequirement(requirement, skill, this.c.getRealSkillLevel(Skill.valueOf(skill.toUpperCase())));
                }
            }
        });
    }

    private void updateRequirement(QuestRequirement requirement, String skill, int level) {
        // Get the label from the map.
        JLabel label = skillMap.get(skill.toLowerCase());
        if (label == null) return;

        // Update the label according to the value & boostable status.
        if (level >= requirement.getLevel()) {
            label.setForeground(config.getRequirementMetColor());
        } else if (requirement.isBoostable()) {
            label.setForeground(config.getRequirementBoostableColor());
        } else {
            label.setForeground(config.getRequirementUnmetColor());
        }
    }
}
