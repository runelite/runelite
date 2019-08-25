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

@ConfigGroup("runeliteplus")
public interface RuneLitePlusConfig extends Config
{
	@ConfigItem(
		keyName = "enableOpacity",
		name = "Enable opacity",
		description = "Enables opacity for the whole window.<br>NOTE: This only stays enabled if your pc supports this!",
		position = 0
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
		position = 1
	)
	default int opacityPercentage()
	{
		return 100;
	}

	@ConfigItem(
		keyName = "keyboardPin",
		name = "Keyboard bank pin",
		description = "Enables you to type your bank pin",
		position = 2
	)
	default boolean keyboardPin()
	{
		return false;
	}

	@ConfigItem(
		keyName = "enablePlugins",
		name = "Enable loading of external plugins",
		description = "Enable loading of external plugins",
		position = 3
	)
	default boolean enablePlugins()
	{
		return false;
	}

	@ConfigItem(
		keyName = "detachHotkey",
		name = "Detach Cam",
		description = "Detach Camera hotkey, press this and it will activate detatched camera.",
		position = 4
	)
	default Keybind detachHotkey()
	{
		return Keybind.NOT_SET;
	}
}