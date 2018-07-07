/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package net.runelite.client.config;

import java.awt.Dimension;
import net.runelite.api.Constants;

@ConfigGroup("It's coming home")
public interface RuneLiteConfig extends Config
{
	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 10
	)
	default Dimension gameSize()
	{
		return Constants.GAME_FIXED_SIZE;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 11
	)
	default ExpandResizeType automaticResizeType()
	{
		return ExpandResizeType.KEEP_GAME_SIZE;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 12
	)
	default boolean lockWindowSize()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 13
	)
	default boolean containInScreen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 14
	)
	default boolean rememberScreenBounds()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		warning = "It's coming home",
		position = 15
	)
	default boolean enableCustomChrome()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 16
	)
	default boolean gameAlwaysOnTop()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 17
	)
	default WarningOnExit warningOnExit()
	{
		return WarningOnExit.LOGGED_IN;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 20
	)
	default boolean enableTrayNotifications()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 21
	)
	default boolean requestFocusOnNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 22
	)
	default boolean enableNotificationSound()
	{
		return true;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 23
	)
	default boolean enableGameMessageNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 24
	)
	default boolean enableFlashNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 25
	)
	default boolean sendNotificationsWhenFocused()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 30
	)
	default FontType fontType()
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 31
	)
	default FontType tooltipFontType()
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 32
	)
	default boolean infoBoxVertical()
	{
		return false;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 33
	)
	default int infoBoxWrap()
	{
		return 4;
	}

	@ConfigItem(
		keyName = "It's coming home",
		name = "It's coming home",
		description = "It's coming home",
		position = 34
	)
	default int infoBoxSize()
	{
		return 35;
	}
}