/*
 * Copyright (c) 2020, cgati <https://github.com/cgati>
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
package net.runelite.client.plugins.tearsofguthix;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.util.ColorUtil;

@ConfigGroup("tearsofguthix")
public interface TearsOfGuthixConfig extends Config
{
	@ConfigItem(
		keyName = "showGreenTearsTimer",
		name = "Enable Green Tears Timer",
		description = "Configures whether to display a timer for green tears or not",
		position = 1
	)
	default boolean showGreenTearsTimer()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		keyName = "blueTearsColor",
		name = "Blue Tears Color",
		description = "Color of Blue Tears timer",
		position = 2
	)
	default Color getBlueTearsColor()
	{
		return ColorUtil.colorWithAlpha(Color.CYAN, 100);
	}

	@Alpha
	@ConfigItem(
		keyName = "greenTearsColor",
		name = "Green Tears Color",
		description = "Color of Green Tears timer",
		position = 3
	)
	default Color getGreenTearsColor()
	{
		return ColorUtil.colorWithAlpha(Color.GREEN, 100);
	}

}
