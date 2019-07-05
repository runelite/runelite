/*
 * Copyright (c) 2018, terminatusx <jbfleischman@gmail.com>
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
package net.runelite.client.plugins.wintertodt;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;
import net.runelite.client.plugins.wintertodt.config.WintertodtNotifyMode;

@ConfigGroup("wintertodt")
public interface WintertodtConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "notifyCondition",
		name = "Notify When",
		description = "Configures when to send notifications"
	)
	default WintertodtNotifyMode notifyCondition()
	{
		return WintertodtNotifyMode.ONLY_WHEN_INTERRUPTED;
	}

	@ConfigItem(
		position = 2,
		keyName = "damageNotificationColor",
		name = "Damage Notification Color",
		description = "Color of damage notification text in chat"
	)
	default Color damageNotificationColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		position = 3,
		keyName = "roundNotification",
		name = "Wintertodt round notification",
		description = "Notifies you before the round starts (in seconds)"
	)
	@Range(
		max = 60
	)
	default int roundNotification()
	{
		return 5;
	}
}