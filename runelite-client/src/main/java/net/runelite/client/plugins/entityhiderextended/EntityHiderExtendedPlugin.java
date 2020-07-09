///*
// * Copyright (c) 2018, Lotto <https://github.com/devLotto>
// * Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
// * All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions are met:
// *
// * 1. Redistributions of source code must retain the above copyright notice, this
// *   list of conditions and the following disclaimer.
// *
// * 2. Redistributions in binary form must reproduce the above copyright notice,
// *   this list of conditions and the following disclaimer in the documentation
// *   and/or other materials provided with the distribution.
// *
// * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
// * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// */
//package net.runelite.client.plugins.entityhiderextended;
//
//import com.google.inject.Provides;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//import javax.inject.Inject;
//import net.runelite.api.Client;
//import net.runelite.api.GameState;
//import net.runelite.api.events.GameStateChanged;
//import net.runelite.api.util.Text;
//import net.runelite.client.config.ConfigManager;
//import net.runelite.client.eventbus.Subscribe;
//import net.runelite.client.events.ConfigChanged;
//import net.runelite.client.plugins.Plugin;
//import net.runelite.client.plugins.PluginDescriptor;
//import net.runelite.client.plugins.PluginType;
//
//
//
//@PluginDescriptor(
//	name = "Entity Hider Extended",
//	enabledByDefault = false,
//	description = "Hide players, NPCs, and/or projectiles",
//	tags = {"npcs", "players", "projectiles"}
//
//)
//public class EntityHiderExtendedPlugin extends Plugin
//{
//	@Inject
//	private Client client;
//
//	@Inject
//	private EntityHiderExtendedConfig config;
//
//	@Provides
//	EntityHiderExtendedConfig provideConfig(ConfigManager configManager)
//	{
//		return configManager.getConfig(EntityHiderExtendedConfig.class);
//	}
//
//	@Override
//	protected void startUp()
//	{
//		client.setIsHidingEntities(true);
//		client.setDeadNPCsHidden(config.hideDeadNPCs());
//		Text.fromCSV(config.hideNPCsOnDeath()).forEach(client::addHiddenNpcDeath);
//	}
//
//	@Subscribe
//	public void onConfigChanged(ConfigChanged event)
//	{
//		if (!event.getGroup().equals("entityhiderextended"))
//		{
//			return;
//		}
//			client.setIsHidingEntities(true);
//			client.setDeadNPCsHidden(config.hideDeadNPCs());
//
//			final Set<Integer> blacklist = new HashSet<>();
//
//			for (String s : Text.COMMA_SPLITTER.split(config.blacklistDeadNpcs()))
//			{
//				try
//				{
//					blacklist.add(Integer.parseInt(s));
//				}
//				catch (NumberFormatException ignored)
//				{
//				}
//
//			}
//
//			client.setBlacklistDeadNpcs(blacklist);
//
//			if (event.getOldValue() == null || event.getNewValue() == null)
//			{
//				return;
//			}
//
//			if (event.getKey().equals("hideNPCsOnDeath"))
//			{
//				List<String> oldList = Text.fromCSV(event.getOldValue());
//				List<String> newList = Text.fromCSV(event.getNewValue());
//
//				ArrayList<String> removed = oldList.stream().filter(s -> !newList.contains(s)).collect(Collectors.toCollection(ArrayList::new));
//				ArrayList<String> added = newList.stream().filter(s -> !oldList.contains(s)).collect(Collectors.toCollection(ArrayList::new));
//
//				removed.forEach(client::removeHiddenNpcDeath);
//				added.forEach(client::addHiddenNpcDeath);
//			}
//
//	}
//
//	@Subscribe
//	public void onGameStateChanged(GameStateChanged event)
//	{
//		if (event.getGameState() == GameState.LOGGED_IN)
//		{
//			client.setIsHidingEntities(true);
//		}
//	}
//
//	@Override
//	protected void shutDown()
//	{
//		client.setIsHidingEntities(false);
//		client.setDeadNPCsHidden(false);
//		Text.fromCSV(config.hideNPCsOnDeath()).forEach(client::removeHiddenNpcDeath);
//	}
//}