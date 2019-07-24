/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.friendtagging;

import com.google.common.base.Strings;
import com.google.common.collect.ObjectArrays;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.Ignore;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Nameable;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.NameableNameChanged;
import net.runelite.api.events.FriendRemoved;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.ArrayUtils;

@Slf4j
@PluginDescriptor(
	name = "Friend Tagging",
	description = "Tag people on your friends list.",
	tags = {"PVP", "friend", "finder", "pk", "pklite"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class FriendTaggingPlugin extends Plugin
{
	public static final ConcurrentHashMap<String, String> taggedFriends = new ConcurrentHashMap<>();

	private static final String CONFIG_GROUP = "friendtagging";
	private static final int CHARACTER_LIMIT = 30;
	private static final String KEY_PREFIX = "tag_";
	private static final String ADD_TAG = "Add Tag";
	private static final String DELETE_TAG = "Delete Tag";
	private final WidgetMenuOption friendsTabMenuOption = new WidgetMenuOption("Copy to", "clipboard",
		WidgetInfo.FIXED_VIEWPORT_FRIENDS_TAB);
	private final WidgetMenuOption ignoreTabMenuOption = new WidgetMenuOption("Copy to", "clipboard",
		WidgetInfo.FIXED_VIEWPORT_IGNORES_TAB);
	private final WidgetMenuOption friendTabResizableOption = new WidgetMenuOption("Copy to", "clipboard",
		WidgetInfo.FIXED_VIEWPORT_FRIENDS_TAB);
	private final WidgetMenuOption ignoreTabResizableOption = new WidgetMenuOption("Copy to", "clipboard",
		WidgetInfo.FIXED_VIEWPORT_IGNORES_TAB);

	@Inject
	private Client client;

	@Inject
	private ConfigManager configManager;

	@Inject
	private MenuManager menuManager;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private EventBus eventBus;

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		menuManager.addManagedCustomMenu(friendsTabMenuOption);
		menuManager.addManagedCustomMenu(ignoreTabMenuOption);
		menuManager.addManagedCustomMenu(friendTabResizableOption);
		menuManager.addManagedCustomMenu(ignoreTabResizableOption);
		loadFriendTags();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		menuManager.removeManagedCustomMenu(friendsTabMenuOption);
		menuManager.removeManagedCustomMenu(ignoreTabMenuOption);
		menuManager.removeManagedCustomMenu(friendTabResizableOption);
		menuManager.removeManagedCustomMenu(ignoreTabResizableOption);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(MenuEntryAdded.class, this, this::onMenuEntryAdded);
		eventBus.subscribe(FriendRemoved.class, this, this::onFriendRemoved);
		eventBus.subscribe(NameableNameChanged.class, this, this::onNameableNameChanged);
		eventBus.subscribe(WidgetMenuOptionClicked.class, this, this::onWidgetMenuOptionClicked);
		eventBus.subscribe(MenuOptionClicked.class, this, this::onMenuOptionClicked);
	}

	private void onMenuEntryAdded(MenuEntryAdded event)
	{
		final int groupId = WidgetInfo.TO_GROUP(event.getActionParam1());

		if (groupId == WidgetInfo.FRIENDS_LIST.getGroupId() && event.getOption().equals("Message"))
		{
			// Friends have color tags
			String friendName = Text.removeTags(event.getTarget());

			// Build "Add Note" or "Edit Note" menu entry
			final MenuEntry entry = new MenuEntry();
			entry.setOption(friendName == null || getTag(friendName) == null ? ADD_TAG : DELETE_TAG);
			entry.setType(MenuAction.RUNELITE.getId());
			entry.setTarget(event.getTarget()); //Preserve color codes here
			entry.setParam0(event.getActionParam0());
			entry.setParam1(event.getActionParam1());

			// Add menu entry
			final MenuEntry[] menuEntries = ObjectArrays.concat(client.getMenuEntries(), entry);
			client.setMenuEntries(menuEntries);
		}
	}

	private void onFriendRemoved(FriendRemoved event)
	{
		final String displayName = event.getName().trim().toLowerCase();
		deleteTag(displayName);
	}

	private void onNameableNameChanged(NameableNameChanged event)
	{
		final Nameable nameable = event.getNameable();

		if (nameable instanceof Friend)
		{
			// Migrate a friend's note to their new display name
			final Friend friend = (Friend) nameable;
			if (friend.getName() != null && friend.getPrevName() != null)
			{
				migrateFriendTag(friend.getName(), friend.getPrevName());
			}
		}
	}

	private void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getWidget().getId() == WidgetInfo.FIXED_VIEWPORT_FRIENDS_TAB.getId() &&
			Text.standardize(event.getMenuTarget()).equals(Text.standardize("clipboard")))
		{
			friendIgnoreToClipboard();
		}
	}

	private void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (WidgetInfo.TO_GROUP(event.getActionParam1()) == WidgetInfo.FRIENDS_LIST.getGroupId())
		{
			if (Strings.isNullOrEmpty(event.getTarget()))
			{
				return;
			}

			final String sanitizedTarget = Text.removeTags(event.getTarget());

			if (event.getOption().equals(ADD_TAG))
			{
				event.consume();
				final ChatboxTextInput build = chatboxPanelManager.openTextInput("Enter the tag").value("")
					.onDone((content) ->
					{
						if (content == null)
						{
							return;
						}
						content = Text.removeTags(content).trim();
						setTag(sanitizedTarget, content);
					}).build();
			}
			if (event.getOption().equals(DELETE_TAG))
			{
				event.consume();
				client.getLogger().info(sanitizedTarget);
				taggedFriends.forEach((k, v) -> client.getLogger().info(k + ": ", v));
				deleteTag(sanitizedTarget);
			}
		}

	}

	/**
	 * Gets a tag from the currently loaded tags
	 *
	 * @param name the username of the player
	 * @return the text of the tag
	 */
	@NonNull
	private String getTag(String name)
	{
		name = name.trim().toLowerCase();
		String keyName = KEY_PREFIX + name;
		return taggedFriends.get(keyName);
	}

	/**
	 * Sets a tag for a friend
	 *
	 * @param name the username of the player to tag
	 * @param tag  the text of the tag
	 */
	private void setTag(String name, String tag)
	{
		client.getLogger().info("SETTING " + name + ": " + tag);
		name = name.trim().toLowerCase();
		String keyName = KEY_PREFIX + name;
		if (tag.length() <= CHARACTER_LIMIT)
		{
			taggedFriends.put(keyName, tag);
			configManager.setConfiguration(CONFIG_GROUP, keyName, tag);
		}
	}

	/**
	 * Deletes a friends tag
	 *
	 * @param name the username of the friend to delete the tag for
	 */
	private void deleteTag(String name)
	{
		name = name.trim().toLowerCase();
		String keyName = KEY_PREFIX + name;
		configManager.unsetConfiguration(CONFIG_GROUP, keyName);
		taggedFriends.remove(keyName);
	}

	/**
	 * Loads all of the friend tags for use with player indicators
	 */
	private void loadFriendTags()
	{
		String prefix = CONFIG_GROUP + "." + KEY_PREFIX;
		for (String key : configManager.getConfigurationKeys(prefix))
		{
			key = key.replace(CONFIG_GROUP + ".", "");
			String result = configManager.getConfiguration(CONFIG_GROUP, key);
			if (Objects.nonNull(result) && !result.equals(""))
			{
				taggedFriends.put(key, configManager.getConfiguration(CONFIG_GROUP, key));
			}
		}
	}

	/**
	 * Migrate a friend note to a new display name, and remove the previous one.
	 * If current name already has a note, or previous name had none, do nothing.
	 */
	private void migrateFriendTag(String currentDisplayName, String prevDisplayName)
	{
		final String currentTag = getTag(currentDisplayName);
		if (currentTag == null)
		{
			final String prevTag = getTag(prevDisplayName);
			if (prevTag != null)
			{
				setTag(prevDisplayName, "");
				setTag(currentDisplayName, prevTag);
			}
		}
	}

	/**
	 * This method combines the list of usernames on local players friend/ignore list into a comma delimited string
	 * and then copies it to the clipboard.
	 */
	private void friendIgnoreToClipboard()
	{
		StringBuilder friendsList = new StringBuilder();
		Friend[] friends = client.getFriends();
		Ignore[] ignores = client.getIgnores();
		String[] friendsIgnores = ArrayUtils.addAll(Arrays.stream(friends).map(Friend::getName).toArray(String[]::new),
			Arrays.stream(ignores).map(Ignore::getName).toArray(String[]::new));
		HashSet<String> names = new HashSet<>(Arrays.asList(friendsIgnores));
		names.forEach(n -> friendsList.append(n.toLowerCase()).append(","));
		StringSelection namesSelection = new StringSelection(friendsList.toString());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(namesSelection, namesSelection);
	}
}
