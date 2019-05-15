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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("prayeralert")
public interface PrayerAlertConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "alwaysShowAlert",
		name = "Always show prayer alert",
		description = "Show the alert, even without prayer restore in inventory"
	)
	default boolean alwaysShowAlert()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "oldRenderMode",
		name = "Render using old method",
		description = "Render the prayer alert using the old method"
	)
	default boolean oldRenderMode()
	{
		return false;
	}
}
