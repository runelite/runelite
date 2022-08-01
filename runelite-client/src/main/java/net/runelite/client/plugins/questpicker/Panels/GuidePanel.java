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

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.client.plugins.questpicker.GuideConfig;
import net.runelite.client.plugins.questpicker.Layouts.CollapsingGridLayout;
import net.runelite.client.plugins.questpicker.QuestInfo;
import net.runelite.client.plugins.questpicker.QuestRequirement;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GuidePanel extends PluginPanel {

    private final Client c;
    private final GuideConfig config;

    private final ErrorPanel ePanel = new ErrorPanel();
    private final IconTextField searchBar = new IconTextField();
    private final HashMap<String, QuestPanel> qMap = new HashMap<>();
    private final HashMap<String, QuestPanel> searchMap = new HashMap<>();

    @Inject
    public GuidePanel(Client c, GuideConfig config, QuestInfo[] infos) {
        super();

        this.c = c;
        this.config = config;

        setLayout(new CollapsingGridLayout(infos.length + 2, 1, 0, 2));

        ePanel.setContent("Random Quest Picker", "Click button below to get a random quest");
        add(ePanel);

        JButton button = new JButton();
        button.setText("Get a quest");
        button.addActionListener(e ->
        {
            if (!qMap.isEmpty()) {
                Map.Entry<String, QuestPanel> entry = qMap.entrySet().iterator().next();
                String key = entry.getKey();
                remove(qMap.get(key));
                qMap.remove(key);
            }

            ArrayList<QuestInfo> uncompletedQuests = new ArrayList<>();

            for (QuestInfo info : infos) {
                if (info.getQuestState() != QuestState.FINISHED) uncompletedQuests.add(info);
            }

            if (uncompletedQuests.size() > 0){
                int randomQuestInt = getRandomNumber(0, uncompletedQuests.size());
                QuestInfo randomQuest = uncompletedQuests.get(randomQuestInt);

                QuestPanel qPanel = new QuestPanel(c, config, randomQuest);

                qMap.put(randomQuest.getName(), qPanel);
                add(qPanel);
                revalidate();
            }
        });
        add(button);

        // Search Bar for filtering quests.
        /*searchBar.setIcon(IconTextField.Icon.SEARCH);
        searchBar.setPreferredSize(new Dimension(PluginPanel.WIDTH - 10, 30));
        searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
        searchBar.addClearListener(this::onSearch);

        // This is new and seems to be what was breaking the plugin. Not sure if this is 100% the right way to do this.
        // It will likely causes some bugs and need to be adjusted.
        net.runelite.client.plugins.questpicker.Listeners.SearchListener searchListener = new net.runelite.client.plugins.questpicker.Listeners.SearchListener(config, qMap, searchMap);
        searchBar.addKeyListener(searchListener);

        add(searchBar);*/

        // Save the object to a HashMap because we want need to build all panels.
        //for (QuestInfo info : infos) {

        //}
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Used for filtering the search results of quests.
     */
    private void onSearch() {
        if (config.searchCompletedQuests() || searchMap.isEmpty()) {
            qMap.forEach((quest, panel) -> {
                panel.setVisible(quest.toLowerCase().contains(searchBar.getText().toLowerCase()));
                revalidate();
            });
        } else {
            searchMap.forEach((quest, panel) -> {
                panel.setVisible(quest.toLowerCase().contains(searchBar.getText().toLowerCase()));
                revalidate();
            });
        }
    }

    /**
     * Called when the panel is updated.
     *
     * @param infos The QuestInfo array.
     */
    public void updateQuests(QuestInfo[] infos) {
        // Prevent updates while the search bar contains text.
        if (!searchBar.getText().isEmpty()) return;

        // Update panels.
        for (QuestInfo info : infos) {
            QuestPanel qPanel = qMap.get(info.getName());
            if (qPanel == null) continue;

            qPanel.update(info);

            if (config.showCompletedQuests()) { // Display all.
                if (qPanel.isVisible()) continue;

                qPanel.setVisible(true);
            } else if (info.getQuestState() == QuestState.NOT_STARTED || info.getQuestState() == QuestState.IN_PROGRESS) { // Display only not completed.
                // Filter by met.
                if (config.filterMetRequirements()) {
                    filterByMet(qPanel, info);
                    continue;
                }

                if (qPanel.isVisible()) continue;

                qPanel.setVisible(true);
            } else { // Remove from the panel if it's not showing all and its finished.
                if (!qPanel.isVisible()) continue;

                qPanel.setVisible(false);
            }
        }

        // Clear the search map before updating.
        searchMap.clear();

        for (Component c : this.getComponents()) {
            if (!c.isVisible()) continue;

            if (c instanceof QuestPanel) {
                QuestPanel qPanel = (QuestPanel) c;
                searchMap.put(qPanel.getQuest().getName(), qPanel);
            }
        }

        revalidate();
    }

    /**
     * Check to see if the player meets a given requirement.
     * This function does not account for boostable skills.
     *
     * @param has  The players current level
     * @param need The needed level
     * @return true if met, false if unmet
     */
    private boolean meetsRequirement(int has, int need) {
        return has >= need;
    }

    /**
     * Displays only the quests that the player has the met requirements for.
     * This is used in both the show all completed, and only by incomplete / in-progress quests.
     *
     * @param qPanel The QuestPanel
     * @param info   The QuestInfo
     */
    private void filterByMet(QuestPanel qPanel, QuestInfo info) {
        // Filter by met requirements only.
        if (config.filterMetRequirements()) {
            // Only run if we have a player.
            if (this.c.getLocalPlayer() == null) return;

            // Loop over all the requirements
            for (QuestRequirement requirement : info.getReqs()) {
                String skill = requirement.getSkill();
                int level = requirement.getLevel();

                // Check for which skill type it is.
                if (skill.equalsIgnoreCase("quest points")) {
                    if (meetsRequirement(this.c.getVarpValue(VarPlayer.QUEST_POINTS.getId()), level)) continue;
                } else if (skill.equalsIgnoreCase("combat level")) {
                    if (meetsRequirement(this.c.getLocalPlayer().getCombatLevel(), level)) continue;
                } else {
                    if (meetsRequirement(this.c.getRealSkillLevel(Skill.valueOf(skill.toUpperCase())), level)) continue;
                }

                // If we don't meet a given requirement, the panel is hidden & break the loop.
                if (qPanel.isVisible()) {
                    qPanel.setVisible(false);
                }

                break;
            }
        }
    }
}
