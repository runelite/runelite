/*
 * Copyright (c) 2018 Robin Withes
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
package net.runelite.client.plugins.oxygenalert;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("oxygenalert")
public interface OxygenAlertConfig extends Config
{
	@ConfigItem(
		keyName = "oxygenChatAlert",
		name = "Chat Message Warning",
		position = 0,
		description = "Get a text message warning you when your oxygen is about to run out")
	default boolean oxygenChatAlert()
	{
		return true;
	}

	@ConfigItem(
		keyName = "oxygenChatAlertCooldown",
		name = "Chat Message Cooldown",
		position = 1,
		description = "Configure whether the chat message should have a cooldown")
	default boolean oxygenChatAlertCooldown()
	{
		return false;
	}

	@ConfigItem(
		keyName = "oxygenNotifyAlert",
		name = "Notifier Message Warning",
		position = 2,
		description = "Get a notifier even when not in runelite when your oxygen is about to run out")
	default boolean oxygenNotifyAlert()
	{
		return true;
	}

	@ConfigItem(
		keyName = "oxygenNotifyAlertCooldown",
		name = "Notifier Message Cooldown",
		position = 3,
		description = "Configure whether the notify message should have a cooldown")
	default boolean oxygenNotifyAlertCooldown()
	{
		return true;
	}

	@ConfigItem(
		keyName = "oxygenThreshold",
		name = "Oxygen Threshold",
		position = 4,
		description = "Configure the % of oxygen you should get a warning for surpassing (1-99) Any value lower or higher will result in the default value.")
	default int oxygenAlertAmount()
	{
		return 20;
	}
}
