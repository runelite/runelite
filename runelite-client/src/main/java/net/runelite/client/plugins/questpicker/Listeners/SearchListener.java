/*
 * Copyright (c) 2021, Christopher Oswald <https://github.com/cesoun>
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
package net.runelite.client.plugins.questpicker.Listeners;

import net.runelite.client.input.KeyListener;
import net.runelite.client.plugins.questpicker.GuideConfig;
import net.runelite.client.plugins.questpicker.Panels.QuestPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class SearchListener implements KeyListener {

    private final GuideConfig config;

    private final HashMap<String, QuestPanel> qMap;
    private final HashMap<String, QuestPanel> searchMap;

    public SearchListener(GuideConfig config, HashMap<String, QuestPanel> qMap, HashMap<String, QuestPanel> searchMap) {
        this.config = config;
        this.qMap = qMap;
        this.searchMap = searchMap;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField searchBar = (JTextField) e.getSource();
        this.onSearch(searchBar);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Used for filtering the search results of quests.
     */
    public void onSearch(JTextField searchBar) {
        String input = searchBar.getText().toLowerCase();

        if (config.searchCompletedQuests() || searchMap.isEmpty()) {
            qMap.forEach((quest, panel) -> {
                panel.setVisible(quest.toLowerCase().contains(input));
                searchBar.revalidate();
            });
        } else {
            searchMap.forEach((quest, panel) -> {
                panel.setVisible(quest.toLowerCase().contains(input));
                searchBar.revalidate();
            });
        }
    }
}

