/*
 * Copyright (c) 2018, DennisDeV <https://github.com/DevDennis>
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
package net.runelite.client.plugins.antidrag;

import java.awt.Color;
import java.awt.event.KeyEvent;
import net.runelite.api.Constants;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.ModifierlessKeybind;

@ConfigGroup("antiDrag")
public interface AntiDragConfig extends Config
{
	@ConfigItem(
		keyName = "dragDelay",
		name = "Drag Delay",
		description = "Configures the inventory drag delay in client ticks (20ms)",
		position = 1
	)
	default int dragDelay()
	{
		return Constants.GAME_TICK_LENGTH / Constants.CLIENT_TICK_LENGTH; // one game tick
	}

	@ConfigItem(
		keyName = "keybind",
		name = "keybind",
		description = "The keybind you want to use for antidrag",
		position = 2
	)
	default Keybind key()
	{
		return new ModifierlessKeybind(KeyEvent.VK_SHIFT, 0);
	}

	@ConfigItem(
		keyName = "reqfocus",
		name = "Reset on focus loss",
		description = "Disable antidrag when losing focus (like alt tabbing)",
		position = 3
	)
	default boolean reqfocus()
	{
		return false;
	}

	@ConfigItem(
		keyName = "overlay",
		name = "Enable overlay",
		description = "Do you really need a description?",
		position = 4
	)
	default boolean overlay()
	{
		return false;
	}

	@Alpha
	@ConfigItem(
		keyName = "color",
		name = "Overlay color",
		description = "Change the overlay color, duh",
		hidden = true,
		unhide = "overlay",
		position = 5
	)
	default Color color()
	{
		return new Color(255, 0, 0, 30);
	}

	@ConfigItem(
		keyName = "changeCursor",
		name = "Change Cursor",
		description = "Change cursor when you have anti-drag enabled.",
		position = 6
	)
	default boolean changeCursor()
	{
		return false;
	}

	@ConfigItem(
		keyName = "cursorStyle",
		name = "Cursor",
		description = "Select which cursor you wish to use",
		hidden = true,
		unhide = "changeCursor",
		position = 7
	)
	default CustomCursor selectedCursor()
	{
		return CustomCursor.DRAGON_SCIMITAR;
	}
}
