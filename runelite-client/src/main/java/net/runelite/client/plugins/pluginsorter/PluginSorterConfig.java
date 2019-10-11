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

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("pluginsorter")
public interface PluginSorterConfig extends Config
{
	@ConfigTitleSection(
		keyName = "hidePluginsTitle",
		name = "Hiding",
		description = "",
		position = 0
	)
	default Title hidePluginsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 1,
		keyName = "hidePlugins",
		name = "Hide Plugins",
		description = "Hides all OpenOSRS plugins if checked",
		titleSection = "hidePluginsTitle",
		hide = "hidePvmPlugins || hidePvpPlugins || hideSkillingPlugins || hideUtilityPlugins || hideExternalPlugins"
	)
	default boolean hidePlugins()
	{
		return false;
	}

	@ConfigItem(
		position = 6,
		keyName = "hideExternalPlugins",
		name = "Hide External Plugins",
		description = "Hides all OpenOSRS external plugins if checked",
		titleSection = "hidePluginsTitle",
		hide = "hidePlugins"
	)
	default boolean hideExternalPlugins()
	{
		return false;
	}

	@ConfigItem(
		position = 2,
		keyName = "hidePvmPlugins",
		name = "Hide PvM Plugins",
		description = "Hides all OpenOSRS PvM plugins if checked",
		titleSection = "hidePluginsTitle",
		hide = "hidePlugins"
	)
	default boolean hidePvmPlugins()
	{
		return false;
	}

	@ConfigItem(
		position = 4,
		keyName = "hideSkillingPlugins",
		name = "Hide Skillinh Plugins",
		description = "Hides all OpenOSRS skilling plugins if checked",
		titleSection = "hidePluginsTitle",
		hide = "hidePlugins"
	)
	default boolean hideSkillingPlugins()
	{
		return false;
	}

	@ConfigItem(
		position = 3,
		keyName = "hidePvpPlugins",
		name = "Hide PvP Plugins",
		description = "Hides all OpenOSRS Pvp plugins if checked",
		titleSection = "hidePluginsTitle",
		hide = "hidePlugins"
	)
	default boolean hidePvpPlugins()
	{
		return false;
	}

	@ConfigItem(
		position = 5,
		keyName = "hideUtilityPlugins",
		name = "Hide Utility Plugins",
		description = "Hides all OpenOSRS utility plugins if checked",
		titleSection = "hidePluginsTitle",
		hide = "hidePlugins"
	)
	default boolean hideUtilityPlugins()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "pluginsColorTitle",
		name = "Colors",
		description = "",
		position = 7
	)
	default Title pluginsColorTitle()
	{
		return new Title();
	}

	@Alpha
	@ConfigItem(
		position = 8,
		keyName = "externalColor",
		name = "External color",
		description = "Configure the color of external plugins",
		titleSection = "pluginsColorTitle"
	)
	default Color externalColor()
	{
		return new Color(177, 156, 217, 255);
	}

	@Alpha
	@ConfigItem(
		position = 9,
		keyName = "pvmColor",
		name = "PVM color",
		description = "Configure the color of PVM related plugins",
		titleSection = "pluginsColorTitle"
	)
	default Color pvmColor()
	{
		return new Color(119, 221, 119, 255);
	}

	@Alpha
	@ConfigItem(
		position = 10,
		keyName = "pvpColor",
		name = "PVP color",
		description = "Configure the color of PVP related plugins",
		titleSection = "pluginsColorTitle"
	)
	default Color pvpColor()
	{
		return new Color(255, 105, 97, 255);
	}

	@Alpha
	@ConfigItem(
		position = 11,
		keyName = "skillingColor",
		name = "Skilling color",
		description = "Configure the color of Skilling related plugins",
		titleSection = "pluginsColorTitle"
	)
	default Color skillingColor()
	{
		return new Color(252, 252, 100, 255);
	}

	@Alpha
	@ConfigItem(
		position = 12,
		keyName = "utilityColor",
		name = "Utility color",
		description = "Configure the color of Utility related plugins",
		titleSection = "pluginsColorTitle"
	)
	default Color utilityColor()
	{
		return new Color(144, 212, 237, 255);
	}

}