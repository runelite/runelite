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
import com.google.common.collect.ObjectArrays;
import com.google.common.eventbus.Subscribe;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Nameable;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NameableNameChanged;
import net.runelite.api.events.RemovedFriend;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ChatboxInputManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(name = "Friend Notes")
public class FriendNotesPlugin extends Plugin
{
	private static final String CONFIG_GROUP = "friendNotes";

	private static final int CHARACTER_LIMIT = 128;

	private static final String ADD_NOTE = "Add Note";
	private static final String EDIT_NOTE = "Edit Note";
	private static final String NOTE_PROMPT_FORMAT = "%s's Notes<br>" +
		"<col=0000AA>(Limit %s Characters)";

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private FriendNoteOverlay overlay;

	@Inject
	private ChatboxInputManager chatboxInputManager;

	@Getter
	private HoveredFriend hoveredFriend = null;

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	/**
	 * Set a friend note, or unset by passing a null/empty note.
	 */
	private void setFriendNote(String displayName, String note)
	{
		if (!Strings.isNullOrEmpty(note))
		{
			configManager.setConfiguration(CONFIG_GROUP, "note_" + displayName, note);
		}
		else
		{
			configManager.unsetConfiguration(CONFIG_GROUP, "note_" + displayName);
		}
	}

	/**
	 * Get the friend note of a display name, or null if no friend note exists for it.
	 */
	@Nullable
	private String getFriendNote(String displayName)
	{
		return configManager.getConfiguration(CONFIG_GROUP, "note_" + displayName);
	}

	/**
	 * Migrate a friend note to a new display name, and remove the previous one.
	 * If current name already has a note, or previous name had none, do nothing.
	 */
	private void migrateFriendNote(String currentDisplayName, String prevDisplayName)
	{
		String currentNote = getFriendNote(currentDisplayName);
		if (currentNote == null)
		{
			String prevNote = getFriendNote(prevDisplayName);
			if (prevNote != null)
			{
				setFriendNote(prevDisplayName, null);
				setFriendNote(currentDisplayName, prevNote);
				log.debug("Updating friends username: '{}' '{}'", currentDisplayName, prevDisplayName);
			}
		}
	}

	/**
	 * Set the currently hovered display name, if a friend note exists for it.
	 */
	private void setHoveredFriend(String target)
	{
		hoveredFriend = null;

		if (!Strings.isNullOrEmpty(target))
		{
			target = Text.removeTags(target);
			String targetNote = getFriendNote(target);
			if (targetNote != null)
			{
				hoveredFriend = new HoveredFriend(target, targetNote);
			}
		}
	}

	/**
	 * Insert "Add Note" or "Edit Note" menu option into friend list menus.
	 */
	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		final int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());

		// look for "Message" on friends list
		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() && event.getOption().equals("Message"))
		{
			setHoveredFriend(event.getTarget());

			final MenuEntry addNote = new MenuEntry();
			addNote.setOption(hoveredFriend == null || hoveredFriend.getNote() == null ? ADD_NOTE : EDIT_NOTE);
			addNote.setType(MenuAction.RUNELITE.getId());
			addNote.setTarget(event.getTarget());
			addNote.setParam0(event.getActionParam0());
			addNote.setParam1(event.getActionParam1());

			// Add menu entry
			MenuEntry[] menuEntries = ObjectArrays.concat(client.getMenuEntries(), addNote);
			client.setMenuEntries(menuEntries);
		}
		else if (hoveredFriend != null)
		{
			hoveredFriend = null;
		}
	}

	/**
	 * Respond to "Add Note" and "Edit Note" menu options by opening the chatbox dialog.
	 */
	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (WidgetInfo.TO_GROUP(event.getWidgetId()) == WidgetInfo.FRIENDS_LIST.getGroupId())
		{
			if (Strings.isNullOrEmpty(event.getMenuTarget()))
			{
				return;
			}

			final String sanitizedTarget = Text.removeTags(event.getMenuTarget());

			if (event.getMenuOption().equals(ADD_NOTE) || event.getMenuOption().equals(EDIT_NOTE))
			{
				event.consume();

				String note = getFriendNote(sanitizedTarget);

				chatboxInputManager.openInputWindow(String.format(NOTE_PROMPT_FORMAT, sanitizedTarget,
					CHARACTER_LIMIT), Strings.nullToEmpty(note), CHARACTER_LIMIT, (content) ->
				{
					if (content == null)
					{
						return;
					}

					content = Text.removeTags(content).trim();
					log.debug("Set note for '{}': '{}'", sanitizedTarget, content);
					setFriendNote(sanitizedTarget, content);
				});
			}
		}

	}

	/**
	 * Migrate a friend's note if they change display names.
	 */
	@Subscribe
	public void onNameableNameChange(NameableNameChanged event)
	{
		Nameable nameable = event.getNameable();

		if (nameable instanceof Friend)
		{
			Friend friend = (Friend) nameable;
			migrateFriendNote(friend.getName(), friend.getPrevName());
		}
	}

	/**
	 * Delete a friend's note if they are removed.
	 */
	@Subscribe
	public void onRemoveFriend(RemovedFriend event)
	{
		String displayName = event.getName();
		log.debug("Removed friend: '{}'", displayName);
		setFriendNote(displayName, null);
	}
}
