/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.timestamp;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(TimestampConfig.GROUP)
public interface TimestampConfig extends Config
{
	String GROUP = "timestamp";

	@ConfigItem(
		keyName = "opaqueTimestamp",
		name = "Timestamps (opaque)",
		position = 1,
		description = "Color of timestamps from the Timestamps plugin (opaque)."
	)
	Color opaqueTimestamp();

	@ConfigItem(
		keyName = "transparentTimestamp",
		name = "Timestamps (transparent)",
		position = 2,
		description = "Color of timestamps from the Timestamps plugin (transparent)."
	)
	Color transparentTimestamp();

	@ConfigItem(
		keyName = "format",
		name = "Timestamp format",
		position = 3,
		description = "Customize your timestamp format by using the following characters:<br>" +
			"'yyyy' : year<br>" +
			"'MM' : month<br>" +
			"'dd' : day<br>" +
			"'HH' : hour in 24 hour format<br>" +
			"'hh' : hour in 12 hour format<br>" +
			"'mm' : minute<br>" +
			"'ss' : second<br>" +
			"'a'  : AM/PM"
	)
	default String timestampFormat()
	{
		return "[HH:mm]";
	}
}
