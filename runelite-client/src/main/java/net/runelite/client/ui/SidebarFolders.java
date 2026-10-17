/*
 * Copyright (c) 2026
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
package net.runelite.client.ui;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;


final class SidebarFolders
{
	private static final int MAX_NAME_LENGTH = 48;

	private static final String FOLDER_PREFIX = "folder:";
	private static final String PLUGIN_PREFIX = "plugin:";

	@Getter
	private List<PluginGroup> groups = new ArrayList<>();
	private boolean customOrder;
	private List<String> topLevel = new ArrayList<>();

	static String keyOf(NavigationButton button)
	{
		if (button.getSidebarId() != null && !button.getSidebarId().isEmpty())
		{
			return button.getSidebarId();
		}
		return button.getPanel().getClass().getName();
	}

	private static String classNameOf(NavigationButton button)
	{
		return button.getPanel().getClass().getName();
	}

	private static String cleanName(String name)
	{
		if (name == null)
		{
			return null;
		}

		String trimmed = name.trim();
		if (trimmed.isEmpty())
		{
			return null;
		}
		if (trimmed.length() > MAX_NAME_LENGTH)
		{
			trimmed = trimmed.substring(0, MAX_NAME_LENGTH);
		}
		return trimmed;
	}

	String toJson(Gson gson)
	{
		return gson.toJson(this);
	}

	static SidebarFolders fromJson(Gson gson, String json)
	{
		if (json == null || json.trim().isEmpty())
		{
			return new SidebarFolders();
		}

		try
		{
			SidebarFolders folders = gson.fromJson(json, SidebarFolders.class);
			if (folders == null)
			{
				return new SidebarFolders();
			}
			folders.normalize();
			return folders;
		}
		catch (JsonSyntaxException ex)
		{
			return new SidebarFolders();
		}
	}

	PluginGroup groupOf(NavigationButton button)
	{
		if (button == null || button.getPanel() == null)
		{
			return null;
		}

		String key = keyOf(button);
		String className = classNameOf(button);
		for (PluginGroup group : groups)
		{
			if (group.getChildren().contains(key) || group.getChildren().contains(className))
			{
				return group;
			}
		}
		return null;
	}

	private boolean migrateKeys(Collection<NavigationButton> buttons)
	{
		if (buttons == null)
		{
			return false;
		}

		boolean changed = false;
		for (NavigationButton button : buttons)
		{
			if (button == null || button.getPanel() == null || button.getSidebarId() == null || button.getSidebarId().isEmpty())
			{
				continue;
			}

			String preferred = button.getSidebarId();
			String className = classNameOf(button);
			if (preferred.equals(className))
			{
				continue;
			}

			for (PluginGroup group : groups)
			{
				List<String> children = group.getChildren();
				int childIndex = children.indexOf(className);
				if (childIndex >= 0)
				{
					if (children.contains(preferred))
					{
						children.remove(childIndex);
					}
					else
					{
						children.set(childIndex, preferred);
					}
					changed = true;
				}
				if (className.equals(group.getIconKey()))
				{
					group.setIconKey(preferred);
					changed = true;
				}
			}

			String oldToken = PLUGIN_PREFIX + className;
			String newToken = PLUGIN_PREFIX + preferred;
			for (int i = 0; i < topLevel.size(); i++)
			{
				if (!oldToken.equals(topLevel.get(i)))
				{
					continue;
				}
				if (topLevel.contains(newToken))
				{
					topLevel.remove(i);
					i--;
				}
				else
				{
					topLevel.set(i, newToken);
				}
				changed = true;
			}
		}
		return changed;
	}

	void reset()
	{
		groups.clear();
		topLevel.clear();
		customOrder = false;
	}

	private PluginGroup live(PluginGroup group)
	{
		if (group == null)
		{
			return null;
		}
		return groupById(group.getId());
	}

	private PluginGroup groupById(String id)
	{
		if (id == null)
		{
			return null;
		}
		for (PluginGroup candidate : groups)
		{
			if (id.equals(candidate.getId()))
			{
				return candidate;
			}
		}
		return null;
	}

	PluginGroup createFolder(String rawName, NavigationButton button)
	{
		String name = cleanName(rawName);
		if (name == null || button == null || button.getPanel() == null)
		{
			return null;
		}

		String key = keyOf(button);
		removeKey(key);
		removeKey(classNameOf(button));

		PluginGroup group = new PluginGroup();
		group.setId(UUID.randomUUID().toString());
		group.setName(name);
		group.setExpanded(true);
		group.addPlugin(key);
		groups.add(group);

		if (customOrder)
		{
			String pluginToken = pluginToken(key);
			int index = topLevel.indexOf(pluginToken);
			if (index >= 0)
			{
				topLevel.set(index, folderToken(group));
			}
			else
			{
				topLevel.add(folderToken(group));
			}
		}
		return group;
	}

	boolean rename(PluginGroup group, String rawName)
	{
		PluginGroup live = live(group);
		String name = cleanName(rawName);
		if (live == null || name == null)
		{
			return false;
		}
		live.setName(name);
		return true;
	}

	void deleteFolder(PluginGroup group, Collection<NavigationButton> buttons)
	{
		PluginGroup live = live(group);
		if (live == null)
		{
			return;
		}

		Map<String, NavigationButton> byKey = index(buttons);
		List<String> childKeys = displayKeys(live, byKey);

		groups.removeIf(candidate -> candidate.getId().equals(live.getId()));
		if (!customOrder)
		{
			return;
		}

		int index = topLevel.indexOf(folderToken(live));
		if (index < 0)
		{
			index = topLevel.size();
		}
		else
		{
			topLevel.remove(index);
		}

		for (String key : childKeys)
		{
			String token = pluginToken(key);
			topLevel.remove(token);
			topLevel.add(index, token);
			index++;
		}
	}

	boolean moveToFolder(PluginGroup group, NavigationButton button)
	{
		PluginGroup live = live(group);
		if (live == null || button == null || button.getPanel() == null)
		{
			return false;
		}

		String key = keyOf(button);
		PluginGroup current = groupOf(button);
		if (current == live)
		{
			return false;
		}

		removeKey(key);
		removeKey(classNameOf(button));
		live.addPlugin(key);
		live.setExpanded(true);
		if (customOrder)
		{
			topLevel.remove(pluginToken(key));
		}
		return true;
	}

	boolean removeFromFolder(NavigationButton button, Collection<NavigationButton> buttons)
	{
		PluginGroup group = groupOf(button);
		if (group == null)
		{
			return false;
		}

		group.removePlugin(keyOf(button));
		if (customOrder)
		{
			insertPluginToken(button, index(buttons));
		}
		return true;
	}

	boolean moveFolder(PluginGroup group, int direction, Collection<NavigationButton> buttons)
	{
		PluginGroup live = live(group);
		if (live == null || direction == 0)
		{
			return false;
		}

		Map<String, NavigationButton> byKey = index(buttons);
		List<String> order = new ArrayList<>();
		if (customOrder)
		{
			order.addAll(topLevel);
		}
		else
		{
			for (TopItem item : visibleDefault(byKey))
			{
				order.add(item.token());
			}
		}

		int from = order.indexOf(folderToken(live));
		int to = neighbor(order, from, direction, byKey);
		if (from < 0 || to < 0)
		{
			return false;
		}

		Collections.swap(order, from, to);
		topLevel.clear();
		topLevel.addAll(order);
		customOrder = true;
		return true;
	}

	boolean moveChild(NavigationButton button, int direction, Collection<NavigationButton> buttons)
	{
		PluginGroup group = groupOf(button);
		if (group == null || direction == 0)
		{
			return false;
		}

		Map<String, NavigationButton> byKey = index(buttons);
		List<NavigationButton> visible = orderedChildren(group, byKey);
		int index = visible.indexOf(button);
		int swapWith = index + direction;
		if (index < 0 || swapWith < 0 || swapWith >= visible.size())
		{
			return false;
		}

		if (!group.isChildOrderCustom())
		{
			group.setChildren(displayKeys(group, byKey));
			group.setChildOrderCustom(true);
		}

		List<String> keys = group.getChildren();
		int from = keys.indexOf(keyOf(visible.get(index)));
		int to = keys.indexOf(keyOf(visible.get(swapWith)));
		if (from < 0 || to < 0)
		{
			return false;
		}

		Collections.swap(keys, from, to);
		return true;
	}

	boolean setFolderIcon(NavigationButton button)
	{
		PluginGroup group = groupOf(button);
		if (group == null)
		{
			return false;
		}

		String key = keyOf(button);
		if (key.equals(group.getIconKey()))
		{
			return false;
		}
		group.setIconKey(key);
		return true;
	}

	boolean hasFolderIcon(NavigationButton button)
	{
		PluginGroup group = groupOf(button);
		return group != null && iconKeyMatches(group, button);
	}

	boolean clearFolderIcon(NavigationButton button)
	{
		PluginGroup group = groupOf(button);
		if (group == null || !iconKeyMatches(group, button))
		{
			return false;
		}

		group.setIconKey(null);
		return true;
	}

	boolean expandIfCollapsed(NavigationButton button)
	{
		PluginGroup group = groupOf(button);
		if (group == null || group.isExpanded())
		{
			return false;
		}

		group.setExpanded(true);
		return true;
	}

	boolean toggleExpanded(PluginGroup group)
	{
		PluginGroup live = live(group);
		if (live == null)
		{
			return false;
		}
		live.toggleExpanded();
		return true;
	}

	NavigationButton iconSource(PluginGroup group, Collection<NavigationButton> buttons)
	{
		if (group == null || group.getIconKey() == null)
		{
			return null;
		}

		for (NavigationButton button : buttons)
		{
			if (iconKeyMatches(group, button))
			{
				return button;
			}
		}
		return null;
	}

	boolean reconcile(Collection<NavigationButton> buttons)
	{
		boolean changed = migrateKeys(buttons);
		if (!customOrder)
		{
			return changed;
		}

		List<String> before = new ArrayList<>(topLevel);
		Map<String, NavigationButton> byKey = index(buttons);
		Map<String, PluginGroup> grouped = groupsByChild();
		Set<String> folderIds = new HashSet<>();
		for (PluginGroup group : groups)
		{
			folderIds.add(group.getId());
		}

		topLevel.removeIf(token ->
		{
			if (token == null)
			{
				return true;
			}
			if (token.startsWith(FOLDER_PREFIX))
			{
				return !folderIds.contains(token.substring(FOLDER_PREFIX.length()));
			}
			String key = pluginKeyFromToken(token);
			return key == null || grouped.containsKey(key);
		});

		for (PluginGroup group : groups)
		{
			String token = folderToken(group);
			if (!topLevel.contains(token))
			{
				topLevel.add(token);
			}
		}

		List<NavigationButton> missing = new ArrayList<>();
		for (NavigationButton button : byKey.values())
		{
			if (grouped.containsKey(keyOf(button)))
			{
				continue;
			}
			if (!topLevel.contains(pluginToken(button)))
			{
				missing.add(button);
			}
		}
		missing.sort(NavigationButton.COMPARATOR);
		for (NavigationButton button : missing)
		{
			insertPluginToken(button, byKey);
		}

		return changed || !before.equals(topLevel);
	}

	List<SidebarSlot> buildSlots(Collection<NavigationButton> buttons)
	{
		Map<String, NavigationButton> byKey = index(buttons);
		List<SidebarSlot> slots = new ArrayList<>();
		for (TopItem item : visibleTopLevel(byKey))
		{
			if (item.folder != null)
			{
				slots.add(SidebarSlot.folder(item.folder));
				if (item.folder.isExpanded())
				{
					for (NavigationButton child : orderedChildren(item.folder, byKey))
					{
						slots.add(SidebarSlot.plugin(child, item.folder));
					}
				}
			}
			else
			{
				slots.add(SidebarSlot.plugin(item.button, null));
			}
		}
		return slots;
	}

	int topIndex(PluginGroup group, Collection<NavigationButton> buttons)
	{
		if (group == null)
		{
			return -1;
		}

		int index = 0;
		for (TopItem item : visibleTopLevel(index(buttons)))
		{
			if (item.folder != null && group.getId().equals(item.folder.getId()))
			{
				return index;
			}
			index++;
		}
		return -1;
	}

	int topCount(Collection<NavigationButton> buttons)
	{
		return visibleTopLevel(index(buttons)).size();
	}

	int childIndex(NavigationButton button, Collection<NavigationButton> buttons)
	{
		PluginGroup group = groupOf(button);
		if (group == null)
		{
			return -1;
		}
		return orderedChildren(group, index(buttons)).indexOf(button);
	}

	int childCount(NavigationButton button, Collection<NavigationButton> buttons)
	{
		PluginGroup group = groupOf(button);
		if (group == null)
		{
			return 0;
		}
		return orderedChildren(group, index(buttons)).size();
	}

	private void normalize()
	{
		if (groups == null)
		{
			groups = new ArrayList<>();
		}

		for (PluginGroup group : groups)
		{
			if (group != null)
			{
				group.normalize();
			}
		}
		groups.removeIf(group -> group == null);

		if (topLevel == null)
		{
			topLevel = new ArrayList<>();
		}
		topLevel.removeIf(token -> token == null || token.isEmpty());
	}

	private List<TopItem> visibleTopLevel(Map<String, NavigationButton> byKey)
	{
		if (!customOrder)
		{
			return visibleDefault(byKey);
		}
		return visibleCustom(byKey);
	}

	private List<TopItem> visibleDefault(Map<String, NavigationButton> byKey)
	{
		List<NavigationButton> sorted = new ArrayList<>(byKey.values());
		sorted.sort(NavigationButton.COMPARATOR);
		Map<String, PluginGroup> grouped = groupsByChild();
		Set<String> seen = new HashSet<>();
		List<TopItem> items = new ArrayList<>();

		for (NavigationButton button : sorted)
		{
			PluginGroup group = grouped.get(keyOf(button));
			if (group == null)
			{
				items.add(TopItem.plugin(button));
			}
			else if (seen.add(group.getId()))
			{
				items.add(TopItem.folder(group));
			}
		}

		for (PluginGroup group : groups)
		{
			if (!seen.contains(group.getId()))
			{
				items.add(TopItem.folder(group));
			}
		}
		return items;
	}

	private List<TopItem> visibleCustom(Map<String, NavigationButton> byKey)
	{
		Map<String, PluginGroup> grouped = groupsByChild();
		Set<String> seen = new HashSet<>();
		List<TopItem> items = new ArrayList<>();

		for (String token : topLevel)
		{
			if (!isVisibleToken(token, byKey, grouped) || !seen.add(token))
			{
				continue;
			}

			PluginGroup folder = folderFromToken(token);
			if (folder != null)
			{
				items.add(TopItem.folder(folder));
				continue;
			}

			NavigationButton button = byKey.get(pluginKeyFromToken(token));
			if (button != null)
			{
				items.add(TopItem.plugin(button));
			}
		}
		return items;
	}

	private List<String> displayKeys(PluginGroup group, Map<String, NavigationButton> byKey)
	{
		List<String> keys = new ArrayList<>();
		for (NavigationButton child : orderedChildren(group, byKey))
		{
			keys.add(keyOf(child));
		}
		for (String key : group.getChildren())
		{
			if (!keys.contains(key))
			{
				keys.add(key);
			}
		}
		return keys;
	}

	private boolean iconKeyMatches(PluginGroup group, NavigationButton button)
	{
		String iconKey = group.getIconKey();
		if (iconKey == null || button == null || button.getPanel() == null)
		{
			return false;
		}
		return iconKey.equals(keyOf(button)) || iconKey.equals(classNameOf(button));
	}

	private List<NavigationButton> orderedChildren(PluginGroup group, Map<String, NavigationButton> byKey)
	{
		List<NavigationButton> children = new ArrayList<>();
		for (String key : group.getChildren())
		{
			NavigationButton button = byKey.get(key);
			if (button != null)
			{
				children.add(button);
			}
		}
		if (!group.isChildOrderCustom())
		{
			children.sort(NavigationButton.COMPARATOR);
		}
		return children;
	}

	private void removeKey(String key)
	{
		for (PluginGroup group : groups)
		{
			group.removePlugin(key);
		}
	}

	private void insertPluginToken(NavigationButton button, Map<String, NavigationButton> byKey)
	{
		String token = pluginToken(button);
		topLevel.remove(token);

		int insertAt = topLevel.size();
		for (int i = 0; i < topLevel.size(); i++)
		{
			String key = pluginKeyFromToken(topLevel.get(i));
			if (key == null)
			{
				continue;
			}

			NavigationButton existing = byKey.get(key);
			if (existing != null && NavigationButton.COMPARATOR.compare(existing, button) > 0)
			{
				insertAt = i;
				break;
			}
		}
		topLevel.add(insertAt, token);
	}

	private int neighbor(List<String> order, int from, int direction, Map<String, NavigationButton> byKey)
	{
		if (from < 0)
		{
			return -1;
		}

		Map<String, PluginGroup> grouped = groupsByChild();
		int index = from + direction;
		while (index >= 0 && index < order.size())
		{
			if (isVisibleToken(order.get(index), byKey, grouped))
			{
				return index;
			}
			index += direction;
		}
		return -1;
	}

	private boolean isVisibleToken(String token, Map<String, NavigationButton> byKey, Map<String, PluginGroup> grouped)
	{
		PluginGroup folder = folderFromToken(token);
		if (folder != null)
		{
			return true;
		}

		String key = pluginKeyFromToken(token);
		return key != null && byKey.containsKey(key) && !grouped.containsKey(key);
	}

	private PluginGroup folderFromToken(String token)
	{
		if (token == null || !token.startsWith(FOLDER_PREFIX))
		{
			return null;
		}
		return groupById(token.substring(FOLDER_PREFIX.length()));
	}

	private static String pluginKeyFromToken(String token)
	{
		if (token == null || !token.startsWith(PLUGIN_PREFIX))
		{
			return null;
		}
		return token.substring(PLUGIN_PREFIX.length());
	}

	static String tabId(SidebarSlot slot)
	{
		if (slot.isFolder())
		{
			return folderToken(slot.getFolder());
		}
		return pluginToken(slot.getButton());
	}

	private static String folderToken(PluginGroup group)
	{
		return FOLDER_PREFIX + group.getId();
	}

	private static String pluginToken(NavigationButton button)
	{
		return pluginToken(keyOf(button));
	}

	private static String pluginToken(String key)
	{
		return PLUGIN_PREFIX + key;
	}

	private Map<String, PluginGroup> groupsByChild()
	{
		Map<String, PluginGroup> map = new HashMap<>();
		for (PluginGroup group : groups)
		{
			for (String key : group.getChildren())
			{
				map.putIfAbsent(key, group);
			}
		}
		return map;
	}

	private static Map<String, NavigationButton> index(Collection<NavigationButton> buttons)
	{
		Map<String, NavigationButton> byKey = new HashMap<>();
		if (buttons == null)
		{
			return byKey;
		}

		for (NavigationButton button : buttons)
		{
			if (button != null && button.getPanel() != null)
			{
				byKey.put(keyOf(button), button);
			}
		}
		return byKey;
	}

	private static final class TopItem
	{
		private final PluginGroup folder;
		private final NavigationButton button;

		private TopItem(PluginGroup folder, NavigationButton button)
		{
			this.folder = folder;
			this.button = button;
		}

		private static TopItem folder(PluginGroup folder)
		{
			return new TopItem(folder, null);
		}

		private static TopItem plugin(NavigationButton button)
		{
			return new TopItem(null, button);
		}

		private String token()
		{
			if (folder != null)
			{
				return folderToken(folder);
			}
			return pluginToken(button);
		}
	}
}
