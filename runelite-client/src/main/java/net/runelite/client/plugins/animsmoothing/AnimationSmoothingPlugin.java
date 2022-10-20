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

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Animation Smoothing",
	description = "Show smoother player, NPC, and object animations",
	tags = {"npcs", "objects", "players"},
	enabledByDefault = false
)
public class AnimationSmoothingPlugin extends Plugin
{
	static final String CONFIG_GROUP = "animationSmoothing";

	@Inject
	private Client client;

	@Inject
	private AnimationSmoothingConfig config;

	@Provides
	AnimationSmoothingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(AnimationSmoothingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		update();
	}

	@Override
	protected void shutDown() throws Exception
	{
		client.setInterpolatePlayerAnimations(false);
		client.setInterpolateNpcAnimations(false);
		client.setInterpolateObjectAnimations(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP))
		{
			update();
		}
	}

	private void update()
	{
		client.setInterpolatePlayerAnimations(config.smoothPlayerAnimations());
		client.setInterpolateNpcAnimations(config.smoothNpcAnimations());
		client.setInterpolateObjectAnimations(config.smoothObjectAnimations());
	}
}
