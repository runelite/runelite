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
		position = 0,
		keyName = "hideDisplayName",
		name = "Hide display name",
		description = "Hides the display name from showing before \"Press Enter to Chat...\""
	)
	default boolean hideDisplayName()
	{
		return false;
	}

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
		description = "Configures whether F-Keys use remapped keys"
	)
	default boolean fkeyRemap()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "f1",
		name = "F1",
		description = "The key which will replace {F1}."
	)
	default ModifierlessKeybind f1()
	{
		return new ModifierlessKeybind(KeyEvent.VK_1, 0);
	}

	@ConfigItem(
		position = 8,
		keyName = "f2",
		name = "F2",
		description = "The key which will replace {F2}."
	)
	default ModifierlessKeybind f2()
	{
		return new ModifierlessKeybind(KeyEvent.VK_2, 0);
	}

	@ConfigItem(
		position = 9,
		keyName = "f3",
		name = "F3",
		description = "The key which will replace {F3}."
	)
	default ModifierlessKeybind f3()
	{
		return new ModifierlessKeybind(KeyEvent.VK_3, 0);
	}

	@ConfigItem(
		position = 10,
		keyName = "f4",
		name = "F4",
		description = "The key which will replace {F4}."
	)
	default ModifierlessKeybind f4()
	{
		return new ModifierlessKeybind(KeyEvent.VK_4, 0);
	}

	@ConfigItem(
		position = 11,
		keyName = "f5",
		name = "F5",
		description = "The key which will replace {F5}."
	)
	default ModifierlessKeybind f5()
	{
		return new ModifierlessKeybind(KeyEvent.VK_5, 0);
	}

	@ConfigItem(
		position = 12,
		keyName = "f6",
		name = "F6",
		description = "The key which will replace {F6}."
	)
	default ModifierlessKeybind f6()
	{
		return new ModifierlessKeybind(KeyEvent.VK_6, 0);
	}

	@ConfigItem(
		position = 13,
		keyName = "f7",
		name = "F7",
		description = "The key which will replace {F7}."
	)
	default ModifierlessKeybind f7()
	{
		return new ModifierlessKeybind(KeyEvent.VK_7, 0);
	}

	@ConfigItem(
		position = 14,
		keyName = "f8",
		name = "F8",
		description = "The key which will replace {F8}."
	)
	default ModifierlessKeybind f8()
	{
		return new ModifierlessKeybind(KeyEvent.VK_8, 0);
	}

	@ConfigItem(
		position = 15,
		keyName = "f9",
		name = "F9",
		description = "The key which will replace {F9}."
	)
	default ModifierlessKeybind f9()
	{
		return new ModifierlessKeybind(KeyEvent.VK_9, 0);
	}

	@ConfigItem(
		position = 16,
		keyName = "f10",
		name = "F10",
		description = "The key which will replace {F10}."
	)
	default ModifierlessKeybind f10()
	{
		return new ModifierlessKeybind(KeyEvent.VK_0, 0);
	}

	@ConfigItem(
		position = 17,
		keyName = "f11",
		name = "F11",
		description = "The key which will replace {F11}."
	)
	default ModifierlessKeybind f11()
	{
		return new ModifierlessKeybind(KeyEvent.VK_MINUS, 0);
	}

	@ConfigItem(
		position = 18,
		keyName = "f12",
		name = "F12",
		description = "The key which will replace {F12}."
	)
	default ModifierlessKeybind f12()
	{
		return new ModifierlessKeybind(KeyEvent.VK_EQUALS, 0);
	}

	@ConfigItem(
		position = 19,
		keyName = "esc",
		name = "ESC",
		description = "The key which will replace {ESC}."
	)
	default ModifierlessKeybind esc()
	{
		return new ModifierlessKeybind(KeyEvent.VK_ESCAPE, 0);
	}

	@ConfigItem(
		position = 20,
		keyName = "ctrl",
		name = "CTRL",
		description = "The key which will replace {CTRL}."
	)
	default ModifierlessKeybind ctrl()
	{
		return new ModifierlessKeybind(KeyEvent.VK_CONTROL, 0);
	}
	
	@ConfigItem(
		position = 21,
		keyName = "alt",
		name = "ALT",
		description = "The key which will replace {ALT}."
	)
	default ModifierlessKeybind alt()
	{
		return new ModifierlessKeybind(KeyEvent.VK_ALT, 0);
	}
	
	@ConfigItem(
		position = 22,
		keyName = "shift",
		name = "SHIFT",
		description = "The key which will replace {SHIFT}."
	)
	default ModifierlessKeybind shift()
	{
		return new ModifierlessKeybind(KeyEvent.VK_SHIFT, 0);
	}
}
