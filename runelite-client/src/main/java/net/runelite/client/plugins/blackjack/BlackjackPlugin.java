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
package net.runelite.client.plugins.blackjack;

import com.google.inject.Binder;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

/**
 * Authors gazivodag longstreet
 */
@PluginDescriptor(
        name = "Blackjack",
        description = "Uses chat messages and tick timers instead of animations to read",
        tags = {"blackjack", "thieving"},
        type = PluginType.UTILITY
)
@Singleton
@Slf4j
public class BlackjackPlugin extends Plugin {

    @Inject
    Client client;

    private static long timeSinceKnockout;
    private static long timeSinceAggro;

    @Getter
    private static long currentGameTick;

    @Override
    public void configure(Binder binder) {
    }

    @Override
    protected void startUp() throws Exception {
        currentGameTick = 0;
    }

    @Override
    protected void shutDown() throws Exception {
        currentGameTick = 0;
    }

    @Subscribe
    public void onGameTick(GameTick gameTick) {
        currentGameTick++;
    }


    @Subscribe
    public void onChatMessage(ChatMessage chatMessage) {
        if (chatMessage.getType() == ChatMessageType.SPAM) {
            if (chatMessage.getMessage().equals("You smack the bandit over the head and render them unconscious.")) {
                timeSinceKnockout = getCurrentGameTick();
            }
            if (chatMessage.getMessage().equals("Your blow only glances off the bandit's head.")) {
                timeSinceAggro = getCurrentGameTick();
            }
        }
    }

    @Subscribe
    public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded) {
        String target = menuEntryAdded.getTarget().toLowerCase();
        if ((target.contains("bandit") | target.contains("menaphite thug"))) {
            Quest quest = Quest.THE_FEUD;
            if (quest.getState(client) == QuestState.FINISHED) {
                if (currentGameTick < (timeSinceKnockout + 4)) {
                    stripSpecificEntries("pickpocket");
                }
                if (currentGameTick < (timeSinceAggro + 4)) {
                    stripSpecificEntries("pickpocket");
                }
                stripSpecificEntries("knock-out");
            }
        }
    }

    private void stripSpecificEntries(String exceptFor) {
        MenuEntry[] currentEntires = client.getMenuEntries();
        MenuEntry[] newEntries = new MenuEntry[2];

        for (MenuEntry currentEntry : currentEntires) {
            if (currentEntry.getOption().toLowerCase().equals(exceptFor.toLowerCase())) {
                newEntries[1] = currentEntry;
            }
            if (currentEntry.getOption().toLowerCase().equals("lure")) {
                newEntries[0] = currentEntry;
            }
        }

        if (newEntries[0] != null && newEntries[1] != null) {
            client.setMenuEntries(newEntries);
        }
    }
}