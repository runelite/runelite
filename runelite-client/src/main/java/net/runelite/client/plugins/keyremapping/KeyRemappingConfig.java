/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.keyremapping;

import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ModifierlessKeybind;

@ConfigGroup("keyremapping")
public interface KeyRemappingConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "cameraRemap",
		name = "Remap Camera",
		description = "Configures whether the camera movement uses remapped keys"
	)
	default boolean cameraRemap()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "up",
		name = "Camera Up key",
		description = "The key which will replace up."
	)
	default ModifierlessKeybind up()
	{
		return new ModifierlessKeybind(KeyEvent.VK_W, 0);
	}

	@ConfigItem(
		position = 3,
		keyName = "down",
		name = "Camera Down key",
		description = "The key which will replace down."
	)
	default ModifierlessKeybind down()
	{
		return new ModifierlessKeybind(KeyEvent.VK_S, 0);
	}

	@ConfigItem(
		position = 4,
		keyName = "left",
		name = "Camera Left key",
		description = "The key which will replace left."
	)
	default ModifierlessKeybind left()
	{
		return new ModifierlessKeybind(KeyEvent.VK_A, 0);
	}

	@ConfigItem(
		position = 5,
		keyName = "right",
		name = "Camera Right key",
		description = "The key which will replace right."
	)
	default ModifierlessKeybind right()
	{
		return new ModifierlessKeybind(KeyEvent.VK_D, 0);
	}

	@ConfigItem(
		position = 6,
		keyName = "fkeyRemap",
		name = "Remap F Keys",
		description = "Configures whether F-Keys are Remapped to 1 (F1) through 0 (F10), '-' (F11), and '=' (F12)"
	)
	default boolean fkeyRemap()
	{
		return false;
	}
}
