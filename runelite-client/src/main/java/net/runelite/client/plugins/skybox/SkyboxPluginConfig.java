/*
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

package net.runelite.client.plugins.skybox;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;
import net.runelite.client.plugins.skybox.config.SkyOverrideMode;

@ConfigGroup("skybox")
public interface SkyboxPluginConfig extends Config
{
	@ConfigItem(
		keyName = "customColor",
		name = "Custom sky color",
		description = "Set a color here to use it with the options below",
		position = 1
	)
	default Color customColor() { return Color.BLACK; }

	@ConfigItem(
		keyName = "skyOverrideMode",
		name = "Mode",
		description = "Replace the sky color in regions of a certain target color, the overworld, or everywhere",
		position = 2
	)
	default SkyOverrideMode overrideMode()
	{
		return SkyOverrideMode.NONE;
	}
	void setOverrideMode(SkyOverrideMode value);

	@ConfigItem(
		keyName = "pickColorToOverride",
		name = "Set current sky as target",
		description = "Sets target color to current chunk's sky color when switched on",
		position = 3
	)
	default boolean pickColorToOverride() { return false; }

	@ConfigItem(
		keyName = "colorToOverride",
		name = "Target color",
		description = "Changing this manually is not recommended, but copying the value for tweaking is useful. Note that the value will not update when you enable the picker, until you re-enter the config panel.",
		hidden = false,
		position = 4
	)
	default Color colorToOverride() { return Color.BLACK; }

	@ConfigItem(
		keyName = "colorToOverride",
		name = "Target color",
		description = "Changing this manually is not recommended, but copying the value for tweaking is useful. Note that the value will not update when you enable the picker, until you re-enter the config panel.",
		hidden = false,
		position = 4
	)
	void setColorToOverride(Color value);
}
