/*
 * Copyright (c) 2019, Parker <https://github.com/Judaxx>
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
package net.runelite.client.plugins.kingdomofmiscellania;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("kingdomofmiscellania")
public interface KingdomConfig extends Config
{
	@ConfigItem(
		keyName = "showInfoboxAnywhere",
		name = "Show kingdom infobox anywhere",
		description = "Show the infobox containing your favor/coffer amount even when outside Miscellania",
		position = 0
	)
	default boolean showInfoboxAnywhere()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notifyFavorThreshold",
		name = "Notify chat favor",
		description = "Sends a message to your chatbox when your kingdom favor percentage is below the threshold. Leave at 0 to disable.",
		position = 1

	)
	default int notifyFavorThreshold()
	{
		return 0;
	}

	@ConfigItem(
		keyName = "notifyCofferThreshold",
		name = "Notify chat coffer value",
		description = "Sends a message to your chatbox when your kingdom's coffer is below the threshold. Leave at 0 to disable.",
		position = 2
	)
	default int notifyCofferThreshold()
	{
		return 0;
	}
}
