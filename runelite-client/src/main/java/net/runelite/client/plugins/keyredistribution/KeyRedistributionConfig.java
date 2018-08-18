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
package net.runelite.client.plugins.keyredistribution;

import java.awt.event.KeyEvent;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("keyredistribution")
public interface KeyRedistributionConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "up",
		name = "Up key",
		description = "The key which will replace up."
	)
	default Keybind up()
	{
		return new Keybind(KeyEvent.VK_W, 0);
	}

	@ConfigItem(
		position = 2,
		keyName = "down",
		name = "Down key",
		description = "The key which will replace down."
	)
	default Keybind down()
	{
		return new Keybind(KeyEvent.VK_S, 0);
	}

	@ConfigItem(
		position = 3,
		keyName = "left",
		name = "Left key",
		description = "The key which will replace left."
	)
	default Keybind left()
	{
		return new Keybind(KeyEvent.VK_A, 0);
	}

	@ConfigItem(
		position = 4,
		keyName = "right",
		name = "Right key",
		description = "The key which will replace right."
	)
	default Keybind right()
	{
		return new Keybind(KeyEvent.VK_D, 0);
	}

	@ConfigItem(
		position = 5,
		keyName = "esc",
		name = "Esc key",
		description = "The key which will replace esc."
	)
	default Keybind esc()
	{
		return new Keybind(KeyEvent.VK_ESCAPE, 0);
	}

	@ConfigItem(
		position = 6,
		keyName = "f1",
		name = "F1 key",
		description = "The key which will replace F1."
	)
	default Keybind f1()
	{
		return new Keybind(KeyEvent.VK_F1, 0);
	}

	@ConfigItem(
		position = 7,
		keyName = "f2",
		name = "F2 key",
		description = "The key which will replace F2."
	)
	default Keybind f2()
	{
		return new Keybind(KeyEvent.VK_F2, 0);
	}

	@ConfigItem(
		position = 8,
		keyName = "f3",
		name = "F3 key",
		description = "The key which will replace F3."
	)
	default Keybind f3()
	{
		return new Keybind(KeyEvent.VK_F3, 0);
	}

	@ConfigItem(
		position = 9,
		keyName = "f4",
		name = "F4 key",
		description = "The key which will replace F4."
	)
	default Keybind f4()
	{
		return new Keybind(KeyEvent.VK_F4, 0);
	}

	@ConfigItem(
		position = 10,
		keyName = "f5",
		name = "F5 key",
		description = "The key which will replace F5."
	)
	default Keybind f5()
	{
		return new Keybind(KeyEvent.VK_F5, 0);
	}

	@ConfigItem(
		position = 11,
		keyName = "f6",
		name = "F6 key",
		description = "The key which will replace F6."
	)
	default Keybind f6()
	{
		return new Keybind(KeyEvent.VK_F6, 0);
	}

	@ConfigItem(
		position = 12,
		keyName = "f7",
		name = "F7 key",
		description = "The key which will replace F7."
	)
	default Keybind f7()
	{
		return new Keybind(KeyEvent.VK_F7, 0);
	}

	@ConfigItem(
		position = 13,
		keyName = "f8",
		name = "F8 key",
		description = "The key which will replace F8."
	)
	default Keybind f8()
	{
		return new Keybind(KeyEvent.VK_F8, 0);
	}

	@ConfigItem(
		position = 14,
		keyName = "f9",
		name = "F9 key",
		description = "The key which will replace F9."
	)
	default Keybind f9()
	{
		return new Keybind(KeyEvent.VK_F9, 0);
	}

	@ConfigItem(
		position = 15,
		keyName = "f10",
		name = "F10 key",
		description = "The key which will replace F10."
	)
	default Keybind f10()
	{
		return new Keybind(KeyEvent.VK_F10, 0);
	}

	@ConfigItem(
		position = 16,
		keyName = "f11",
		name = "F11 key",
		description = "The key which will replace F11."
	)
	default Keybind f11()
	{
		return new Keybind(KeyEvent.VK_F11, 0);
	}

	@ConfigItem(
		position = 17,
		keyName = "f12",
		name = "F12 key",
		description = "The key which will replace F12."
	)
	default Keybind f12()
	{
		return new Keybind(KeyEvent.VK_F12, 0);
	}
}
