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

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ModifierlessKeybind;

@ConfigGroup("keyremapping")
public interface KeyRemappingConfig extends Config
{
	@ConfigSection(
		name = "Camera remapping",
		description = "Settings for remapping the camera.",
		position = 0
	)
	String cameraSection = "camera";

	@ConfigSection(
		name = "F-key remapping",
		description = "Settings for remapping the F-keys.",
		position = 1
	)
	String fKeySection = "fKeys";

	@ConfigItem(
		position = 1,
		keyName = "cameraRemap",
		name = "Remap camera",
		description = "Configures whether the camera movement uses remapped keys.",
		section = cameraSection
	)
	default boolean cameraRemap()
	{
		return true;
	}

	@ConfigItem(
		position = 2,
		keyName = "up",
		name = "Camera up key",
		description = "The key which will replace up.",
		section = cameraSection
	)
	default ModifierlessKeybind up()
	{
		return new ModifierlessKeybind(KeyEvent.VK_W, 0);
	}

	@ConfigItem(
		position = 3,
		keyName = "down",
		name = "Camera down key",
		description = "The key which will replace down.",
		section = cameraSection
	)
	default ModifierlessKeybind down()
	{
		return new ModifierlessKeybind(KeyEvent.VK_S, 0);
	}

	@ConfigItem(
		position = 4,
		keyName = "left",
		name = "Camera left key",
		description = "The key which will replace left.",
		section = cameraSection
	)
	default ModifierlessKeybind left()
	{
		return new ModifierlessKeybind(KeyEvent.VK_A, 0);
	}

	@ConfigItem(
		position = 5,
		keyName = "right",
		name = "Camera right key",
		description = "The key which will replace right.",
		section = cameraSection
	)
	default ModifierlessKeybind right()
	{
		return new ModifierlessKeybind(KeyEvent.VK_D, 0);
	}

	@ConfigItem(
		position = 6,
		keyName = "fkeyRemap",
		name = "Remap F-keys",
		description = "Configures whether f-keys use remapped keys.",
		section = fKeySection
	)
	default boolean fkeyRemap()
	{
		return false;
	}

	@ConfigItem(
		position = 7,
		keyName = "f1",
		name = "F1",
		description = "The key which will replace F1.",
		section = fKeySection
	)
	default ModifierlessKeybind f1()
	{
		return new ModifierlessKeybind(KeyEvent.VK_1, 0);
	}

	@ConfigItem(
		position = 8,
		keyName = "f2",
		name = "F2",
		description = "The key which will replace F2.",
		section = fKeySection
	)
	default ModifierlessKeybind f2()
	{
		return new ModifierlessKeybind(KeyEvent.VK_2, 0);
	}

	@ConfigItem(
		position = 9,
		keyName = "f3",
		name = "F3",
		description = "The key which will replace F3.",
		section = fKeySection
	)
	default ModifierlessKeybind f3()
	{
		return new ModifierlessKeybind(KeyEvent.VK_3, 0);
	}

	@ConfigItem(
		position = 10,
		keyName = "f4",
		name = "F4",
		description = "The key which will replace F4.",
		section = fKeySection
	)
	default ModifierlessKeybind f4()
	{
		return new ModifierlessKeybind(KeyEvent.VK_4, 0);
	}

	@ConfigItem(
		position = 11,
		keyName = "f5",
		name = "F5",
		description = "The key which will replace F5.",
		section = fKeySection
	)
	default ModifierlessKeybind f5()
	{
		return new ModifierlessKeybind(KeyEvent.VK_5, 0);
	}

	@ConfigItem(
		position = 12,
		keyName = "f6",
		name = "F6",
		description = "The key which will replace F6.",
		section = fKeySection
	)
	default ModifierlessKeybind f6()
	{
		return new ModifierlessKeybind(KeyEvent.VK_6, 0);
	}

	@ConfigItem(
		position = 13,
		keyName = "f7",
		name = "F7",
		description = "The key which will replace F7.",
		section = fKeySection
	)
	default ModifierlessKeybind f7()
	{
		return new ModifierlessKeybind(KeyEvent.VK_7, 0);
	}

	@ConfigItem(
		position = 14,
		keyName = "f8",
		name = "F8",
		description = "The key which will replace F8.",
		section = fKeySection
	)
	default ModifierlessKeybind f8()
	{
		return new ModifierlessKeybind(KeyEvent.VK_8, 0);
	}

	@ConfigItem(
		position = 15,
		keyName = "f9",
		name = "F9",
		description = "The key which will replace F9.",
		section = fKeySection
	)
	default ModifierlessKeybind f9()
	{
		return new ModifierlessKeybind(KeyEvent.VK_9, 0);
	}

	@ConfigItem(
		position = 16,
		keyName = "f10",
		name = "F10",
		description = "The key which will replace F10.",
		section = fKeySection
	)
	default ModifierlessKeybind f10()
	{
		return new ModifierlessKeybind(KeyEvent.VK_0, 0);
	}

	@ConfigItem(
		position = 17,
		keyName = "f11",
		name = "F11",
		description = "The key which will replace F11.",
		section = fKeySection
	)
	default ModifierlessKeybind f11()
	{
		return new ModifierlessKeybind(KeyEvent.VK_MINUS, 0);
	}

	@ConfigItem(
		position = 18,
		keyName = "f12",
		name = "F12",
		description = "The key which will replace F12.",
		section = fKeySection
	)
	default ModifierlessKeybind f12()
	{
		return new ModifierlessKeybind(KeyEvent.VK_EQUALS, 0);
	}

	@ConfigItem(
		position = 19,
		keyName = "esc",
		name = "ESC",
		description = "The key which will replace ESC.",
		section = fKeySection
	)
	default ModifierlessKeybind esc()
	{
		return new ModifierlessKeybind(KeyEvent.VK_ESCAPE, 0);
	}

	@ConfigItem(
		position = 20,
		keyName = "space",
		name = "Space",
		description = "The key which will replace space when dialogs are open."
	)
	default ModifierlessKeybind space()
	{
		return new ModifierlessKeybind(KeyEvent.VK_SPACE, 0);
	}

	@ConfigItem(
		position = 21,
		keyName = "control",
		name = "Control",
		description = "The key which will replace control."
	)
	default ModifierlessKeybind control()
	{
		return new ModifierlessKeybind(KeyEvent.VK_UNDEFINED, InputEvent.CTRL_DOWN_MASK);
	}
}
