/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
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
package net.runelite.client.plugins.virtuallevels;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;

import javax.inject.Inject;

@PluginDescriptor(
	name = "Virtual Levels"
)
public class VirtualLevelsPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	private VirtualLevelsConfig config;

	@Inject
	private PluginManager pluginManager;

	@Override
	protected void startUp() throws Exception
	{
		postFakeSkillChange();
	}

	@Override
	protected void shutDown() throws Exception
	{
		postFakeSkillChange();
	}

	@Provides
	VirtualLevelsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VirtualLevelsConfig.class);
	}

	@Subscribe
	public void onSkillTabScriptEvent(ScriptCallbackEvent event)
	{
		// check to make sure we should alter the values on skill tab
		if (!config.showOnSkillTab())
		{
			return;
		}

		String eventName = event.getEventName();

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		switch (eventName)
		{
			case "skillTabBaseLevel":
				intStackSize -= 2;

				int skillId = intStack[intStackSize];

				Skill skill = Skill.VALUES[skillId]; // TODO replace with a better way to get Skill from id
				int exp = client.getSkillExperience(skill);

				// alter the local variable containing the level to show
				intStack[intStackSize + 1] = Experience.getLevelForXp(exp);
				break;

			case "skillTabMaxLevel":
				// alter the constant 99 in an if statement so it goes up to 126
				intStack[--intStackSize] = 126;
				break;
		}
	}

	@Subscribe
	public void onConfigChange(ConfigChanged event)
	{
		if (!event.getGroup().equals("virtuallevels"))
		{
			return;
		}

		switch (event.getKey())
		{
			case "skillTab":
				postFakeSkillChange();
				break;
		}
	}

	/**
	 * Check if the plugin is enabled. This is to prevent having to inject the PluginManager into plugins that
	 * depend on this one to check if this plugin is enabled.
	 */
	public boolean isEnabled()
	{
		return pluginManager.isPluginEnabled(this);
	}

	/**
	 * Used to make the client think there was a change to the skill so it reruns scripts that have stat transmit hooks.
	 */
	private void postFakeSkillChange()
	{
		int[] skills = client.getChangedSkills();
		int count = client.getChangedSkillsCount();

		for (Skill ignored : Skill.VALUES)
		{
			skills[++count - 1 & 31] = 0;
		}

		client.setChangedSkillsCount(count);
	}

}
