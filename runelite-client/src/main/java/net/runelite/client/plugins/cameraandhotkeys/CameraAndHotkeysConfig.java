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
package net.runelite.client.plugins.cameraandhotkeys;

import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ModifierlessKeybind;

@ConfigGroup("cameraandhotkeys")
public interface CameraAndHotkeysConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "up",
		name = "Up key",
		description = "The key which will replace up."
	)
	default ModifierlessKeybind up()
	{
		return new ModifierlessKeybind(KeyEvent.VK_W, 0);
	}

	@ConfigItem(
		position = 2,
		keyName = "down",
		name = "Down key",
		description = "The key which will replace down."
	)
	default ModifierlessKeybind down()
	{
		return new ModifierlessKeybind(KeyEvent.VK_S, 0);
	}

	@ConfigItem(
		position = 3,
		keyName = "left",
		name = "Left key",
		description = "The key which will replace left."
	)
	default ModifierlessKeybind left()
	{
		return new ModifierlessKeybind(KeyEvent.VK_A, 0);
	}

	@ConfigItem(
		position = 4,
		keyName = "right",
		name = "Right key",
		description = "The key which will replace right."
	)
	default ModifierlessKeybind right()
	{
		return new ModifierlessKeybind(KeyEvent.VK_D, 0);
	}

	@ConfigItem(
		position = 5,
		keyName = "F1",
		name = "F1 key",
		description = "The key which will replace F1."
	)
	default ModifierlessKeybind f1()
	{
		return new ModifierlessKeybind(KeyEvent.VK_1, 0);
	}

	@ConfigItem(
		position = 6,
		keyName = "F2",
		name = "F2 key",
		description = "The key which will replace F2."
	)
	default ModifierlessKeybind f2()
	{
		return new ModifierlessKeybind(KeyEvent.VK_2, 0);
	}

	@ConfigItem(
		position = 7,
		keyName = "F3",
		name = "F3 key",
		description = "The key which will replace F3."
	)
	default ModifierlessKeybind f3()
	{
		return new ModifierlessKeybind(KeyEvent.VK_3, 0);
	}

	@ConfigItem(
		position = 8,
		keyName = "F4",
		name = "F4 key",
		description = "The key which will replace F4."
	)
	default ModifierlessKeybind f4()
	{
		return new ModifierlessKeybind(KeyEvent.VK_4, 0);
	}

	@ConfigItem(
		position = 9,
		keyName = "F5",
		name = "F5 key",
		description = "The key which will replace F5."
	)
	default ModifierlessKeybind f5()
	{
		return new ModifierlessKeybind(KeyEvent.VK_5, 0);
	}

	@ConfigItem(
		position = 10,
		keyName = "F6",
		name = "F6 key",
		description = "The key which will replace F6."
	)
	default ModifierlessKeybind f6()
	{
		return new ModifierlessKeybind(KeyEvent.VK_6, 0);
	}

	@ConfigItem(
		position = 11,
		keyName = "F7",
		name = "F7 key",
		description = "The key which will replace F7."
	)
	default ModifierlessKeybind f7()
	{
		return new ModifierlessKeybind(KeyEvent.VK_7, 0);
	}

	@ConfigItem(
		position = 12,
		keyName = "F8",
		name = "F8 key",
		description = "The key which will replace F8."
	)
	default ModifierlessKeybind f8()
	{
		return new ModifierlessKeybind(KeyEvent.VK_8, 0);
	}

	@ConfigItem(
		position = 13,
		keyName = "F9",
		name = "F9 key",
		description = "The key which will replace F9."
	)
	default ModifierlessKeybind f9()
	{
		return new ModifierlessKeybind(KeyEvent.VK_9, 0);
	}

	@ConfigItem(
		position = 14,
		keyName = "F10",
		name = "F10 key",
		description = "The key which will replace F10."
	)
	default ModifierlessKeybind f10()
	{
		return new ModifierlessKeybind(KeyEvent.VK_0, 0);
	}
}
