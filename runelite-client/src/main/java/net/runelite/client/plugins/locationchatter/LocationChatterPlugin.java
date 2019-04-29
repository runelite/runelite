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
package net.runelite.client.plugins.locationchatter;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.wildernesslocations.WildernessLocationsPlugin;
import net.runelite.client.util.HotkeyListener;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Location Chatter", 
	tags = {"location", "exilent", "pklite", "spammer"},
	type = PluginType.PVP
	)
public class LocationChatterPlugin extends Plugin
{
	@Inject
	private Client client;
	
	@Inject
	private ClientThread clientThread;
	
	@Inject
	LocationChatterConfig config;
	
	@Inject
	private KeyManager keyManager;
	
	@Inject
	private PluginManager pluginManager;
	
	private WildernessLocationsPlugin wildyLocsPlugin;
	
	private String oldChat = "";
	private int currentCooldown = 0;
	private final int COOLDOWN_TICKS = 30;
	
	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> config.keybind())
	{
		@Override
		public void hotkeyPressed()
		{
			sendLocToCC();
		}
	};
	
	@Override
	public void startUp()
	{
		for (Plugin pl : pluginManager.getPlugins())
		{
			if (pl instanceof WildernessLocationsPlugin)
			{
				wildyLocsPlugin = (WildernessLocationsPlugin) pl;
			}
		}
		keyManager.registerKeyListener(hotkeyListener);
	}
	
	@Override
	public void shutDown()
	{
		keyManager.unregisterKeyListener(hotkeyListener);
	}
	
	@Provides
	LocationChatterConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LocationChatterConfig.class);
	}
	
	@Subscribe
	public void onGameTick(GameTick tickEvent)
	{
		if (currentCooldown != 0)
		{
			currentCooldown--;
		}
	}
	
	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged varClient)
	{
		String newChat = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT);
		if (varClient.getIndex() == VarClientStr.CHATBOX_TYPED_TEXT.getIndex() && !newChat.equals(oldChat))
		{
			oldChat = newChat;
		}
	}
	
	private boolean inClanChat()
	{
		return client.getWidget(WidgetInfo.CLAN_CHAT_TITLE) != null;
	}
	
	private void sendMessage(String text)
	{
		int mode = 0;
		if (inClanChat() && text.startsWith("/"))
		{
			mode = 2;
		}
		int finalMode = mode;
		Runnable r = () ->
		{
			String cached = oldChat;
			client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, text);
			client.runScript(ScriptID.CHATBOX_INPUT, finalMode, text);
			oldChat = cached;
			client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, oldChat);
		};
		clientThread.invoke(r);
	}
	
	private void sendLocToCC()
	{
		if (currentCooldown != 0)
		{
			return;
		}
		
		String location = wildyLocsPlugin.getLocationString();
		if (location.equals(""))
		{
			return;
		}
		sendMessage("/World: " + client.getWorld() + " Location: " + location);
		currentCooldown = COOLDOWN_TICKS;
	}
}
