/*
 * Copyright (c) 2018, https://openosrs.com
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
package net.runelite.client.plugins.pluginsorter;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Plugin Organizer",
	hidden = true
)
@Singleton
public class PluginSorterPlugin extends Plugin
{
	@Inject
	private ConfigManager configManager;

	/**
	 * Migrates configs from plugin organizer to the OpenOSRS global plugin and deletes the old config values.
	 * This method should be removed after a reasonable amount of time.
	 */
	@Deprecated
	private void migrateConfigs()
	{
		migrateConfig("pluginsorter", "pluginSortMode");
		migrateConfig("pluginsorter", "hidePlugins");
		migrateConfig("pluginsorter", "hideExternalPlugins");
		migrateConfig("pluginsorter", "hidePvmPlugins");
		migrateConfig("pluginsorter", "hideSkillingPlugins");
		migrateConfig("pluginsorter", "hidePvpPlugins");
		migrateConfig("pluginsorter", "hideUtilityPlugins");
		migrateConfig("pluginsorter", "externalColor");
		migrateConfig("pluginsorter", "pvmColor");
		migrateConfig("pluginsorter", "pvpColor");
		migrateConfig("pluginsorter", "skillingColor");
		migrateConfig("pluginsorter", "utilityColor");
	}

	/**
	 * Wrapper for migrating individual config options
	 * This method should be removed after a reasonable amount of time.
	 *
	 * @param group old group name
	 * @param key   key name to migrate
	 */
	@Deprecated
	private void migrateConfig(String group, String key)
	{
		String value = configManager.getConfiguration(group, key);
		if (value != null)
		{
			configManager.setConfiguration("openosrs", key, value);
			configManager.unsetConfiguration(group, key);
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		migrateConfigs();
	}
}
