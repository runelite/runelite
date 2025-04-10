/*
 * Copyright (c) 2018, Rheon <https://github.com/Rheon-D>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.plugins.friendnotes;

import com.google.common.base.Strings;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.GameState;
import net.runelite.api.Ignore;
import net.runelite.api.MenuAction;
import net.runelite.api.Nameable;
import net.runelite.api.ScriptID;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.NameableNameChanged;
import net.runelite.api.events.RemovedFriend;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ChatIconManager;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Friend Notes",
	description = "Store notes about your friends"
)
public class FriendNotesPlugin extends Plugin
{
	static final String CONFIG_GROUP = "friendNotes";
	private static final int CHARACTER_LIMIT = 128;
	private static final String KEY_PREFIX = "note_";
	private static final String ADD_NOTE = "Add Note";
	private static final String EDIT_NOTE = "Edit Note";
	private static final String NOTE_PROMPT_FORMAT = "%s's Notes<br>" +
		ColorUtil.prependColorTag("(Limit %s Characters)", new Color(0, 0, 170));
	private static final int ICON_WIDTH = 14;
	private static final int ICON_HEIGHT = 12;

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private FriendNoteOverlay overlay;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private FriendNotesConfig config;

	@Inject
	private ChatIconManager chatIconManager;

	@Getter
	private HoveredFriend hoveredFriend = null;

	private int iconId = -1;
	private String currentlyLayouting;

	@Provides
	private FriendNotesConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FriendNotesConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		loadIcon();
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			rebuildFriendsList();
			rebuildIgnoreList();
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			rebuildFriendsList();
			rebuildIgnoreList();
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CONFIG_GROUP))
		{
			return;
		}

		switch (event.getKey())
		{
			case "showIcons":
				if (client.getGameState() == GameState.LOGGED_IN)
				{
					rebuildFriendsList();
					rebuildIgnoreList();
				}
				break;
		}
	}

	/**
	 * Set a friend note, or unset by passing a null/empty note.
	 */
	private void setFriendNote(String displayName, String note)
	{
		if (Strings.isNullOrEmpty(note))
		{
			configManager.unsetConfiguration(CONFIG_GROUP, KEY_PREFIX + displayName);
		}
		else
		{
			configManager.setConfiguration(CONFIG_GROUP, KEY_PREFIX + displayName, note);
		}
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			rebuildFriendsList();
			rebuildIgnoreList();
		}
	}

	/**
	 * Get the friend note of a display name, or null if no friend note exists for it.
	 */
	@Nullable
	private String getFriendNote(String displayName)
	{
		return configManager.getConfiguration(CONFIG_GROUP, KEY_PREFIX + displayName);
	}

	/**
	 * Migrate a friend note to a new display name, and remove the previous one.
	 * If current name already has a note, or previous name had none, do nothing.
	 */
	private void migrateFriendNote(String currentDisplayName, String prevDisplayName)
	{
		final String currentNote = getFriendNote(currentDisplayName);
		if (currentNote == null)
		{
			final String prevNote = getFriendNote(prevDisplayName);
			if (prevNote != null)
			{
				log.debug("Update friend's username: '{}' -> '{}'", prevDisplayName, currentDisplayName);
				setFriendNote(prevDisplayName, null);
				setFriendNote(currentDisplayName, prevNote);
			}
		}
	}

	/**
	 * Set the currently hovered display name, if a friend note exists for it.
	 */
	private void setHoveredFriend(String displayName)
	{
		hoveredFriend = null;

		if (!Strings.isNullOrEmpty(displayName))
		{
			final String note = getFriendNote(displayName);
			if (note != null)
			{
				hoveredFriend = new HoveredFriend(displayName, note);
			}
		}
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		final int groupId = WidgetUtil.componentToInterface(event.getActionParam1());

		// Look for "Message" on friends list
		if ((groupId == InterfaceID.FRIENDS && event.getOption().equals("Message")) ||
				(groupId == InterfaceID.IGNORE && event.getOption().equals("Delete")))
		{
			// Friends have color tags
			setHoveredFriend(Text.toJagexName(Text.removeTags(event.getTarget())));

			// Build "Add Note" or "Edit Note" menu entry
			client.createMenuEntry(-1)
				.setOption(hoveredFriend == null || hoveredFriend.getNote() == null ? ADD_NOTE : EDIT_NOTE)
				.setType(MenuAction.RUNELITE)
				.setTarget(event.getTarget()) //Preserve color codes here
				.onClick(e ->
				{
					//Friends have color tags
					final String sanitizedTarget = Text.toJagexName(Text.removeTags(e.getTarget()));
					final String note = getFriendNote(sanitizedTarget);

					// Open the new chatbox input dialog
					chatboxPanelManager.openTextInput(String.format(NOTE_PROMPT_FORMAT, sanitizedTarget, CHARACTER_LIMIT))
						.value(Strings.nullToEmpty(note))
						.onDone((content) ->
						{
							if (content == null)
							{
								return;
							}

							content = Text.removeTags(content).trim();
							log.debug("Set note for '{}': '{}'", sanitizedTarget, content);
							setFriendNote(sanitizedTarget, content);
						}).build();
				});
		}
		else if (hoveredFriend != null)
		{
			hoveredFriend = null;
		}
	}

	@Subscribe
	public void onNameableNameChanged(NameableNameChanged event)
	{
		final Nameable nameable = event.getNameable();

		if (nameable instanceof Friend || nameable instanceof Ignore)
		{
			// Migrate a friend's note to their new display name
			String name = nameable.getName();
			String prevName = nameable.getPrevName();

			if (prevName != null)
			{
				migrateFriendNote(
					Text.toJagexName(name),
					Text.toJagexName(prevName)
				);
			}
		}
	}

	@Subscribe
	public void onRemovedFriend(RemovedFriend event)
	{
		// Delete a friend's note if they are removed
		final String displayName = Text.toJagexName(event.getNameable().getName());
		log.debug("Remove friend: '{}'", displayName);
		setFriendNote(displayName, null);
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		if (!config.showIcons() || iconId == -1)
		{
			return;
		}

		switch (event.getEventName())
		{
			case "friendsChatSetText":
				String[] stringStack = client.getStringStack();
				int stringStackSize = client.getStringStackSize();
				final String rsn = stringStack[stringStackSize - 1];
				final String sanitized = Text.toJagexName(Text.removeTags(rsn));
				currentlyLayouting = sanitized;
				if (getFriendNote(sanitized) != null)
				{
					stringStack[stringStackSize - 1] = rsn + " <img=" + chatIconManager.chatIconIndex(iconId) + ">";
				}
				break;
			case "friendsChatSetPosition":
				if (currentlyLayouting == null || getFriendNote(currentlyLayouting) == null)
				{
					return;
				}

				int[] intStack = client.getIntStack();
				int intStackSize = client.getIntStackSize();
				int xpos = intStack[intStackSize - 4];
				xpos += ICON_WIDTH + 1;
				intStack[intStackSize - 4] = xpos;
				break;
		}
	}

	private void rebuildFriendsList()
	{
		clientThread.invokeLater(() ->
		{
			log.debug("Rebuilding friends list");
			client.runScript(
				ScriptID.FRIENDS_UPDATE,
				InterfaceID.Friends.LIST_CONTAINER,
				InterfaceID.Friends.SORT_NAME,
				InterfaceID.Friends.SORT_RECENT,
				InterfaceID.Friends.SORT_WORLD,
				InterfaceID.Friends.SORT_LEGACY,
				InterfaceID.Friends.LIST,
				InterfaceID.Friends.SCROLLBAR,
				InterfaceID.Friends.LOADING,
				InterfaceID.Friends.TOOLTIP
			);
		});
	}

	private void rebuildIgnoreList()
	{
		clientThread.invokeLater(() ->
		{
			log.debug("Rebuilding ignore list");
			client.runScript(
				ScriptID.IGNORE_UPDATE,
				InterfaceID.Ignore.LIST_CONTAINER,
				InterfaceID.Ignore.SORT_NAME,
				InterfaceID.Ignore.SORT_LEGACY,
				InterfaceID.Ignore.LIST,
				InterfaceID.Ignore.SCROLLBAR,
				InterfaceID.Ignore.LOADING,
				InterfaceID.Ignore.TOOLTIP
			);
		});
	}

	private void loadIcon()
	{
		if (iconId != -1)
		{
			return;
		}

		final BufferedImage iconImg = ImageUtil.loadImageResource(getClass(), "note_icon.png");
		if (iconImg == null)
		{
			throw new RuntimeException("unable to load icon");
		}

		final BufferedImage resized = ImageUtil.resizeImage(iconImg, ICON_WIDTH, ICON_HEIGHT);
		iconId = chatIconManager.registerChatIcon(resized);
	}

}
