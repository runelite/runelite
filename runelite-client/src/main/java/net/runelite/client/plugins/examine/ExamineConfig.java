/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.examine;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "examine",
	name = "Examine",
	description = "Configuration for examine plugin"
)
public interface ExamineConfig extends Config
{
	@ConfigItem(
		position = 2,
		keyName = "hexColorExamine",
		name = "Examine messages",
		description = "Color of examine messages"
	)
	default Color getExamineRecolor()
	{
		return Color.decode("#000000");
	}

	@ConfigItem(
		position = 3,
		keyName = "hexColorExamineH",
		name = "Examine messages highlight",
		description = "Color of examine messages highlight"
	)
	default Color getExamineHRecolor()
	{
		return Color.decode("#0000FF");
	}

	@ConfigItem(
		position = 4,
		keyName = "transparentHexColorExamine",
		name = "Transparent examine messages",
		description = "Color of examine messages"
	)
	default Color getTransparentExamineRecolor()
	{
		return Color.decode("#FFFFFF");
	}

	@ConfigItem(
		position = 5,
		keyName = "transparentHexColorExamineH",
		name = "Transparent examine messages highlight",
		description = "Color of examine messages highlight"
	)
	default Color getTransparentExamineHRecolor()
	{
		return Color.decode("#9090FF");
	}
}
