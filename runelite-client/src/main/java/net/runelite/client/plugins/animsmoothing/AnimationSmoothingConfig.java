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
package net.runelite.client.plugins.animsmoothing;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(AnimationSmoothingPlugin.CONFIG_GROUP)
public interface AnimationSmoothingConfig extends Config
{

	@ConfigItem(
		keyName = "smoothPlayerAnimations",
		name = "Smooth Player Animations",
		description = "Configures whether the player animations are smooth or not",
		position = 1
	)
	default boolean smoothPlayerAnimations()
	{
		return true;
	}

	@ConfigItem(
		keyName = "smoothNpcAnimations",
		name = "Smooth NPC Animations",
		description = "Configures whether the npc animations are smooth or not",
		position = 2
	)
	default boolean smoothNpcAnimations()
	{
		return true;
	}

	@ConfigItem(
		keyName = "smoothObjectAnimations",
		name = "Smooth Object Animations",
		description = "Configures whether the object animations are smooth or not",
		position = 3
	)
	default boolean smoothObjectAnimations()
	{
		return true;
	}

}
