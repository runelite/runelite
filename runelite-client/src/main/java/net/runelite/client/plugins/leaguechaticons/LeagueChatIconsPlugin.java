/*
 * Copyright (c) 2019, hsamoht <https://github.com/hsamoht>
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.leaguechaticons;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatPlayer;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberManager;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.GameState;
import net.runelite.api.IconID;
import net.runelite.api.IndexedSprite;
import net.runelite.api.MessageNode;
import net.runelite.api.NameableContainer;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.WorldService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldResult;
import net.runelite.http.api.worlds.WorldType;

@PluginDescriptor(
	name = "League Chat Icons",
	description = "Changes the chat icon for players on league worlds",
	enabledByDefault = false
)
@Slf4j
public class LeagueChatIconsPlugin extends Plugin
{
	private static final String SCRIPT_EVENT_SET_CHATBOX_INPUT = "setChatboxInput";
	private static final String IRONMAN_PREFIX = "<img=" + IconID.IRONMAN.getIndex() + ">";

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private WorldService worldService;

	@Inject
	private ClientThread clientThread;

	private int leagueIconOffset = -1; // offset for league icon
	private boolean onLeagueWorld;

	@Override
	protected void startUp()
	{
		onLeagueWorld = false;

		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN)
			{
				loadLeagueIcon();
				onLeagueWorld = isLeagueWorld(client.getWorld());
				if (onLeagueWorld)
				{
					setChatboxName(getNameChatbox());
				}
			}
		});
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(() ->
		{
			if (client.getGameState() == GameState.LOGGED_IN && onLeagueWorld)
			{
				setChatboxName(getNameDefault());
			}
		});
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			loadLeagueIcon();
			onLeagueWorld = isLeagueWorld(client.getWorld());
		}
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent)
	{
		if (scriptCallbackEvent.getEventName().equals(SCRIPT_EVENT_SET_CHATBOX_INPUT) && onLeagueWorld)
		{
			setChatboxName(getNameChatbox());
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage)
	{
		if (client.getGameState() != GameState.LOADING && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		switch (chatMessage.getType())
		{
			case PRIVATECHAT:
			case MODPRIVATECHAT:
				// Note this is unable to change icon on PMs if they are not a friend or in clan chat
			case FRIENDSCHAT:
				String name = Text.removeTags(chatMessage.getName());
				if (isChatPlayerOnLeague(name))
				{
					addLeagueIconToMessage(chatMessage);
				}
				break;
			case PUBLICCHAT:
			case MODCHAT:
				if (onLeagueWorld)
				{
					addLeagueIconToMessage(chatMessage);
				}
				break;
		}
	}

	/**
	 * Adds the League Icon in front of player names chatting from a league world.
	 *
	 * @param chatMessage chat message to edit sender name on
	 */
	private void addLeagueIconToMessage(ChatMessage chatMessage)
	{
		String name = chatMessage.getName();
		if (!name.startsWith(IRONMAN_PREFIX))
		{
			// don't replace non-ironman icons, like mods
			return;
		}

		name = Text.removeTags(name);

		final MessageNode messageNode = chatMessage.getMessageNode();
		messageNode.setName(getNameWithIcon(leagueIconOffset, name));

		chatMessageManager.update(messageNode);
		client.refreshChat();
	}

	/**
	 * Update the player name in the chatbox input
	 */
	private void setChatboxName(String name)
	{
		Widget chatboxInput = client.getWidget(WidgetInfo.CHATBOX_INPUT);
		if (chatboxInput != null)
		{
			String text = chatboxInput.getText();
			int idx = text.indexOf(':');
			if (idx != -1)
			{
				String newText = name + text.substring(idx);
				chatboxInput.setText(newText);
			}
		}
	}

	/**
	 * Gets the league name, including possible icon, of the local player.
	 *
	 * @return String of icon + name
	 */
	private String getNameChatbox()
	{
		Player player = client.getLocalPlayer();
		if (player != null)
		{
			return getNameWithIcon(leagueIconOffset, player.getName());
		}
		return null;
	}

	/**
	 * Gets the default name, including possible icon, of the local player.
	 *
	 * @return String of icon + name
	 */
	private String getNameDefault()
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		int iconIndex;
		switch (client.getAccountType())
		{
			case IRONMAN:
				iconIndex = IconID.IRONMAN.getIndex();
				break;
			case HARDCORE_IRONMAN:
				iconIndex = IconID.HARDCORE_IRONMAN.getIndex();
				break;
			case ULTIMATE_IRONMAN:
				iconIndex = IconID.ULTIMATE_IRONMAN.getIndex();
				break;
			default:
				return player.getName();
		}

		return getNameWithIcon(iconIndex, player.getName());
	}

	/**
	 * Get a name formatted with icon
	 *
	 * @param iconIndex index of the icon
	 * @param name      name of the player
	 * @return String of icon + name
	 */
	private static String getNameWithIcon(int iconIndex, String name)
	{
		String icon = "<img=" + iconIndex + ">";
		return icon + name;
	}

	/**
	 * Checks if a player name is a friend or clan member on a league world.
	 *
	 * @param name name of player to check.
	 * @return boolean true/false.
	 */
	private boolean isChatPlayerOnLeague(String name)
	{
		ChatPlayer player = getChatPlayerFromName(name);

		if (player == null)
		{
			return false;
		}

		int world = player.getWorld();
		return isLeagueWorld(world);
	}

	/**
	 * Checks if the world is a League world.
	 *
	 * @param worldNumber number of the world to check.
	 * @return boolean true/false if it is a league world or not.
	 */
	private boolean isLeagueWorld(int worldNumber)
	{
		WorldResult worlds = worldService.getWorlds();
		if (worlds == null)
		{
			return false;
		}

		World world = worlds.findWorld(worldNumber);
		return world != null && world.getTypes().contains(WorldType.LEAGUE);
	}

	/**
	 * Loads the league icon into the client.
	 */
	private void loadLeagueIcon()
	{
		final IndexedSprite[] modIcons = client.getModIcons();

		if (leagueIconOffset != -1 || modIcons == null)
		{
			return;
		}

		BufferedImage image = ImageUtil.getResourceStreamFromClass(getClass(), "league_icon.png");
		IndexedSprite indexedSprite = ImageUtil.getImageIndexedSprite(image, client);

		leagueIconOffset = modIcons.length;

		final IndexedSprite[] newModIcons = Arrays.copyOf(modIcons, modIcons.length + 1);
		newModIcons[newModIcons.length - 1] = indexedSprite;

		client.setModIcons(newModIcons);
	}

	/**
	 * Gets a ChatPlayer object from a clean name by searching clan and friends list.
	 *
	 * @param name name of player to find.
	 * @return ChatPlayer if found, else null.
	 */
	private ChatPlayer getChatPlayerFromName(String name)
	{
		// Search clan members first, because if a friend is in the clan chat but their private
		// chat is 'off', then we won't know the world
		ClanMemberManager clanMemberManager = client.getClanMemberManager();
		if (clanMemberManager != null)
		{
			ClanMember clanMember = clanMemberManager.findByName(name);
			if (clanMember != null)
			{
				return clanMember;
			}
		}

		NameableContainer<Friend> friendContainer = client.getFriendContainer();
		return friendContainer.findByName(name);
	}
}
