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
package com.runeswag.client.plugins;

import api.Client;
import api.events.ChatMessage;
import api.events.ClientTick;
import api.events.GameTick;
import api.events.MenuOpened;
import api.events.VarbitChanged;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.inject.Provides;
import com.runeswag.client.config.ConfigManager;
import com.runeswag.client.misc.Plugin;
import com.runeswag.client.misc.PluginDescriptor;
import com.runeswag.client.ui.OverlayManager;
import lombok.extern.slf4j.Slf4j;

/**
 * Authors gazivodag longstreet
 */
@PluginDescriptor(
        name = "Test",
        description = "Testing plugin for building functionality",
        tags = {}
)
@Singleton
@Slf4j
public class Test extends Plugin
{

    @Provides
    TestConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TestConfig.class);
    }

    @Inject
    private TestOverlay testOverlay;

    @Inject
    private TestConfig config;

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Override
    public void configure(Binder binder)
    {
    }

    @Override
    protected void startUp() throws Exception
    {
        overlayManager.add(testOverlay);
        System.out.println("Test Plugin started");
    }

    @Override
    protected void shutDown() throws Exception
    {

    }

    @Subscribe
    public void onMenuOpened(MenuOpened event)
    {
        System.out.println("[Test Plugin] Menu Opened");
    }

    @Subscribe
    public void onChatMessage(ChatMessage chatMessage)
    {
        System.out.println("[Test Plugin] Chat Message");
    }

    @Subscribe
    public void onVarbitChanged(VarbitChanged event)
    {
        System.out.println("[Test Plugin] Varbit Changed");
    }
}