// prayeralert - Plugin for the OSRS RuneLite client to alert the player when their prayer is low.
// Copyright (C) 2019  lachlan-smith, mikkikur

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

package net.runelite.client.plugins.prayeralert;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Prayer Alerter",
	description = "Alert the player when prayer is low",
	tags = {"prayer", "overlay"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class PrayerAlertPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PrayerAlertOverlay overlay;

	@Inject
	private PrayerAlertConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private boolean alwaysShowAlert;
	@Getter(AccessLevel.PACKAGE)
	private boolean oldRenderMode;

	@Provides
	PrayerAlertConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PrayerAlertConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		this.alwaysShowAlert = config.alwaysShowAlert();
		this.oldRenderMode = config.oldRenderMode();

		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("prayeralert"))
		{
			this.alwaysShowAlert = config.alwaysShowAlert();
			this.oldRenderMode = config.oldRenderMode();
		}
	}
}
