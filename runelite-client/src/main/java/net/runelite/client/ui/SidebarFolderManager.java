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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;


// Loads and saves sidebar folders under {@code runelite.sidebarFolders}.

@Slf4j
@Singleton
class SidebarFolderManager
{
	static final String CONFIG_GROUP = "runelite";
	static final String CONFIG_KEY = "sidebarFolders";

	private final ConfigManager configManager;
	private final Gson gson;
	private SidebarFolders folders = new SidebarFolders();
	private boolean loaded;
	private String configJson;

	@Inject
	private SidebarFolderManager(ConfigManager configManager, Gson gson)
	{
		this.configManager = configManager;
		this.gson = gson;
	}

	// Config is not available while this manager is constructed. Call this after {@code ConfigManager.load()}.

	void load()
	{
		reloadFromConfig();
	}

	boolean reloadFromConfig()
	{
		try
		{
			String json = configManager.getConfiguration(CONFIG_GROUP, CONFIG_KEY);
			if (loaded && Objects.equals(json, configJson))
			{
				return false;
			}

			folders = SidebarFolders.fromJson(gson, json);
			configJson = json;
			loaded = true;
			return true;
		}
		catch (RuntimeException ex)
		{
			log.warn("Unable to load sidebar folders", ex);
			return false;
		}
	}

	private SidebarFolders model()
	{
		load();
		return folders;
	}

	void save()
	{
		if (!loaded)
		{
			return;
		}

		String json = folders.toJson(gson);
		if (json.equals(configJson))
		{
			return;
		}

		configJson = json;
		configManager.setConfiguration(CONFIG_GROUP, CONFIG_KEY, json);
	}

	void reset()
	{
		commit(() -> model().reset());
	}

	List<PluginGroup> getGroups()
	{
		return Collections.unmodifiableList(model().getGroups());
	}

	PluginGroup groupOf(NavigationButton button)
	{
		return model().groupOf(button);
	}

	List<SidebarSlot> buildSlots(Collection<NavigationButton> buttons)
	{
		return model().buildSlots(buttons);
	}

	boolean reconcile(Collection<NavigationButton> buttons)
	{
		return commit(() -> model().reconcile(buttons));
	}

	PluginGroup createFolder(String name, NavigationButton button)
	{
		PluginGroup group = model().createFolder(name, button);
		if (group != null)
		{
			save();
		}
		return group;
	}

	boolean rename(PluginGroup group, String name)
	{
		return commit(() -> model().rename(group, name));
	}

	void deleteFolder(PluginGroup group, Collection<NavigationButton> buttons)
	{
		commit(() -> model().deleteFolder(group, buttons));
	}

	boolean moveToFolder(PluginGroup group, NavigationButton button)
	{
		return commit(() -> model().moveToFolder(group, button));
	}

	boolean removeFromFolder(NavigationButton button, Collection<NavigationButton> buttons)
	{
		return commit(() -> model().removeFromFolder(button, buttons));
	}

	boolean moveFolder(PluginGroup group, int direction, Collection<NavigationButton> buttons)
	{
		return commit(() -> model().moveFolder(group, direction, buttons));
	}

	boolean moveChild(NavigationButton button, int direction, Collection<NavigationButton> buttons)
	{
		return commit(() -> model().moveChild(button, direction, buttons));
	}

	boolean setFolderIcon(NavigationButton button)
	{
		return commit(() -> model().setFolderIcon(button));
	}

	boolean clearFolderIcon(NavigationButton button)
	{
		return commit(() -> model().clearFolderIcon(button));
	}

	boolean expandIfCollapsed(NavigationButton button)
	{
		return commit(() -> model().expandIfCollapsed(button));
	}

	void toggleExpanded(PluginGroup group)
	{
		commit(() -> model().toggleExpanded(group));
	}

	boolean hasFolderIcon(NavigationButton button)
	{
		return model().hasFolderIcon(button);
	}

	NavigationButton iconSource(PluginGroup group, Collection<NavigationButton> buttons)
	{
		return model().iconSource(group, buttons);
	}

	int topIndex(PluginGroup group, Collection<NavigationButton> buttons)
	{
		return model().topIndex(group, buttons);
	}

	int topCount(Collection<NavigationButton> buttons)
	{
		return model().topCount(buttons);
	}

	int childIndex(NavigationButton button, Collection<NavigationButton> buttons)
	{
		return model().childIndex(button, buttons);
	}

	int childCount(NavigationButton button, Collection<NavigationButton> buttons)
	{
		return model().childCount(button, buttons);
	}

	private boolean commit(BooleanSupplier change)
	{
		if (!change.getAsBoolean())
		{
			return false;
		}
		save();
		return true;
	}

	private void commit(Runnable change)
	{
		change.run();
		save();
	}
}
