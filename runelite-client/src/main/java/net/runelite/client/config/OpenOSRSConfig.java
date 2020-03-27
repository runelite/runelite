/*
 *
 *   Copyright (c) 2019, Zeruth <TheRealNull@gmail.com>
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice, this
 *      list of conditions and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *   ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package net.runelite.client.config;

import java.awt.Color;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ConfigGroup("openosrs")
public interface OpenOSRSConfig extends Config
{
	@Getter(AccessLevel.PUBLIC)
	@AllArgsConstructor
	enum SortStyle
	{
		CATEGORY("Category"),
		ALPHABETICALLY("Alphabetically");

		private String name;

		@Override
		public String toString()
		{
			return getName();
		}
	}

	@ConfigTitleSection(
		keyName = "logTitle",
		name = "Error data",
		description = "",
		position = 1
	)
	default Title logTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 3,
		keyName = "shareLogs",
		name = "Share anonymous error data",
		description = "Share anonymous error data with the OpenOSRS developers",
		titleSection = "logTitle"
	)
	default boolean shareLogs()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "pluginsTitle",
		name = "Plugins",
		description = "",
		position = 1
	)
	default Title pluginsTitle()
	{
		return new Title();
	}

	@ConfigTitleSection(
		keyName = "pluginSortingTitle",
		name = "Sorting",
		description = "",
		position = 2,
		titleSection = "pluginsTitle"
	)
	default Title pluginSortingTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 3,
		keyName = "pluginSortMode",
		name = "Sorting mode",
		description = "Sorts plugins ",
		titleSection = "pluginSortingTitle"
	)
	default SortStyle pluginSortMode()
	{
		return SortStyle.CATEGORY;
	}

	@ConfigItem(
		position = 4,
		keyName = "enableCategories",
		name = "Categorize plugins",
		description = "Show sections in the plugin list for each plugin type",
		titleSection = "pluginSortingTitle",
		hidden = true,
		unhide = "pluginSortMode",
		unhideValue = "Category"
	)
	default boolean enableCategories()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "pluginsColorTitle",
		name = "Colors",
		description = "",
		position = 5,
		titleSection = "pluginsTitle"
	)
	default Title pluginsColorTitle()
	{
		return new Title();
	}

	@ConfigItem(
		position = 6,
		keyName = "enabledColors",
		name = "Enable plugin colors",
		description = "Configure whether or not the plugins list should be colorcoded",
		titleSection = "pluginsColorTitle"
	)
	default boolean enabledColors()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 7,
		keyName = "pvmColor",
		name = "PvM color",
		description = "Configure the color of PvM related plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color pvmColor()
	{
		return new Color(119, 221, 119, 255);
	}

	@Alpha
	@ConfigItem(
		position = 8,
		keyName = "skillingColor",
		name = "Skilling color",
		description = "Configure the color of skilling related plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color skillingColor()
	{
		return new Color(252, 252, 100, 255);
	}

	@Alpha
	@ConfigItem(
		position = 9,
		keyName = "pvpColor",
		name = "PvP color",
		description = "Configure the color of PvP related plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color pvpColor()
	{
		return new Color(255, 105, 97, 255);
	}

	@Alpha
	@ConfigItem(
		position = 10,
		keyName = "utilityColor",
		name = "Utility color",
		description = "Configure the color of utility related plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color utilityColor()
	{
		return new Color(144, 212, 237, 255);
	}

	@Alpha
	@ConfigItem(
		position = 11,
		keyName = "minigameColor",
		name = "Minigame color",
		description = "Configure the color of minigame related plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color minigameColor()
	{
		return new Color(235, 130, 66, 255);
	}

	@Alpha
	@ConfigItem(
		position = 12,
		keyName = "miscellaneousColor",
		name = "Miscellaneous color",
		description = "Configure the color of miscellaneous related plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color miscellaneousColor()
	{
		return new Color(243,  85,  136, 255);
	}

	@Alpha
	@ConfigItem(
		position = 13,
		keyName = "gamemodeColor",
		name = "Gamemode color",
		description = "Configure the color of gamemode plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color gamemodeColor()
	{
		return new Color(244, 239, 211, 255);
	}

	@Alpha
	@ConfigItem(
		position = 14,
		keyName = "externalColor",
		name = "External color",
		description = "Configure the color of external plugins",
		titleSection = "pluginsColorTitle",
		hidden = true,
		unhide = "enabledColors"
	)
	default Color externalColor()
	{
		return new Color(177, 156, 217, 255);
	}

	@ConfigTitleSection(
		keyName = "externalPluginsTitle",
		name = "External",
		description = "",
		position = 15,
		titleSection = "pluginsTitle"
	)
	default Title externalPluginsTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "enablePlugins",
		name = "Enable loading of legacy external plugins",
		description = "Enable loading of legacy external plugins",
		position = 16,
		titleSection = "externalPluginsTitle"
	)
	default boolean enablePlugins()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "opacityTitle",
		name = "Opacity",
		description = "",
		position = 17
	)
	default Title opacityTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "enableOpacity",
		name = "Enable opacity",
		description = "Enables opacity for the whole window.<br>NOTE: This only stays enabled if your pc supports this!",
		position = 18,
		titleSection = "opacityTitle"
	)
	default boolean enableOpacity()
	{
		return false;
	}

	@Range(
		min = 15,
		max = 100
	)
	@ConfigItem(
		keyName = "opacityPercentage",
		name = "Opacity percentage",
		description = "Changes the opacity of the window if opacity is enabled",
		position = 19,
		titleSection = "opacityTitle"
	)
	@Units(Units.PERCENT)
	default int opacityPercentage()
	{
		return 100;
	}

	@ConfigTitleSection(
		keyName = "miscTitle",
		name = "Miscellaneous",
		description = "",
		position = 20
	)
	default Title miscTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "localSync",
		name = "Sync local instances",
		description = "Enables multiple local instances of OpenOSRS to communicate (this enables syncing plugin state and config options)",
		position = 21,
		titleSection = "miscTitle"
	)
	default boolean localSync()
	{
		return true;
	}

	@ConfigItem(
		keyName = "keyboardPin",
		name = "Keyboard bank pin",
		description = "Enables you to type your bank pin",
		position = 22,
		titleSection = "miscTitle"
	)
	default boolean keyboardPin()
	{
		return false;
	}

	@ConfigItem(
		keyName = "detachHotkey",
		name = "Detach Cam",
		description = "Detach Camera hotkey, press this and it will activate detatched camera.",
		position = 23,
		titleSection = "miscTitle"
	)
	default Keybind detachHotkey()
	{
		return Keybind.NOT_SET;
	}

	@ConfigItem(
		keyName = "externalRepositories",
		name = "",
		description = "",
		hidden = true
	)
	default String getExternalRepositories()
	{
		return "OpenOSRS:https://raw.githubusercontent.com/open-osrs/plugin-hosting/master/";
	}

	@ConfigItem(
		keyName = "externalRepositories",
		name = "",
		description = "",
		hidden = true
	)
	void setExternalRepositories(String val);
}