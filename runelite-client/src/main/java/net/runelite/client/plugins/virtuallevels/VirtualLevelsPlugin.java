/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Virtual Levels",
	description = "Configuration for the virtual levels plugin.",
	tags = {"skill", "total", "max", "f2p", "free"},
	enabledByDefault = false
)

public class VirtualLevelsPlugin extends Plugin
{
	private static final String TOTAL_LEVEL_TEXT_PREFIX = "Total level:<br>";

	private static int
			prayerX = 0,
			prayerY = 0,
			magicX = 0,
			magicY = 0,
			craftingX = 0,
			craftingY = 0,
			runecraftingX = 0,
			runecraftingY = 0,
			woodcuttingX = 0,
			woodcuttingY = 0,
			totalX = 0,
			totalY = 0;

	@Inject
	private VirtualLevelsConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Provides
	VirtualLevelsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VirtualLevelsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		hideMembersSkillsAndShuffle(hideMembersEnabled());
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(this::simulateSkillChange);
		hideMembersSkillsAndShuffle(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged config)
	{
		if (config.getGroup().equals("virtualLevels"))
		{
			clientThread.invoke(this::simulateSkillChange);
			hideMembersSkillsAndShuffle(hideMembersEnabled());
		}
	}

	@Subscribe
	public void onPluginChanged(PluginChanged pluginChanged)
	{
		// this is guaranteed to be called after the plugin has been registered by the eventbus. startUp is not.
		if (pluginChanged.getPlugin() != this)
		{
			return;
		}

		if (config.virtualLevelsEnabled())
		{
			clientThread.invoke(this::simulateSkillChange);
		}
		else if (config.hideMembersSkills())
		{
			hideMembersSkillsAndShuffle(hideMembersEnabled());
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		hideMembersSkillsAndShuffle(hideMembersEnabled());
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		final String eventName = e.getEventName();

		final int[] intStack = client.getIntStack();
		final int intStackSize = client.getIntStackSize();
		final String[] stringStack = client.getStringStack();
		final int stringStackSize = client.getStringStackSize();

		switch (eventName)
		{
			case "skillTabBaseLevel":
				final int skillId = intStack[intStackSize - 2];
				final Skill skill = Skill.values()[skillId];
				final int exp = client.getSkillExperience(skill);

				// alter the local variable containing the level to show
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp);
				break;
			case "skillTabMaxLevel":
				// alter max level constant
				intStack[intStackSize - 1] = Experience.MAX_VIRT_LEVEL;
				break;
			case "skillTabTotalLevel":
				int level = 0;

				for (Skill s : Skill.values())
				{
					if (s == Skill.OVERALL)
					{
						continue;
					}
					if (hideMembersEnabled())
					{
						//only adds to level if the skill if client is in f2p world and is not a members skill
						level += s.getMembersSkill() ? 0 : Experience.getLevelForXp(client.getSkillExperience(s));
					}
					else
					{
						level += Experience.getLevelForXp(client.getSkillExperience(s));
					}
				}
				stringStack[stringStackSize - 1] = TOTAL_LEVEL_TEXT_PREFIX + level;
				break;
		}
	}

	private void simulateSkillChange()
	{
		// this fires widgets listening for all skill changes
		for (Skill skill : Skill.values())
		{
			if (skill != Skill.OVERALL)
			{
				client.queueChangedSkill(skill);
			}
		}
	}

	private ImmutableList<Widget> getMemberSkills()
	{
		return ImmutableList.of(
			client.getWidget(WidgetInfo.SKILL_AGILITY),
			client.getWidget(WidgetInfo.SKILL_CONSTRUCTION),
			client.getWidget(WidgetInfo.SKILL_FARMING),
			client.getWidget(WidgetInfo.SKILL_FLETCHING),
			client.getWidget(WidgetInfo.SKILL_HERBLORE),
			client.getWidget(WidgetInfo.SKILL_HUNTER),
			client.getWidget(WidgetInfo.SKILL_THIEVING),
			client.getWidget(WidgetInfo.SKILL_SLAYER));
	}

	private void hideMembersSkillsAndShuffle(boolean enabled)
	{
		if (client.getWidget(WidgetInfo.SKILL_TOTAL) == null)
		{
			return;
		}
		//sets original location of widgets if not already set
		prayerX = prayerX > 0 ? prayerX : client.getWidget(WidgetInfo.SKILL_PRAYER).getRelativeX();
		prayerY = prayerY > 0 ? prayerY : client.getWidget(WidgetInfo.SKILL_PRAYER).getRelativeY();
		magicX = magicX > 0 ? magicX : client.getWidget(WidgetInfo.SKILL_MAGIC).getRelativeX();
		magicY = magicY > 0 ? magicY : client.getWidget(WidgetInfo.SKILL_MAGIC).getRelativeY();
		craftingX = craftingX > 0 ? craftingX : client.getWidget(WidgetInfo.SKILL_CRAFTING).getRelativeX();
		craftingY = craftingY > 0 ? craftingY : client.getWidget(WidgetInfo.SKILL_CRAFTING).getRelativeY();
		runecraftingX = runecraftingX > 0 ? runecraftingX : client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).getRelativeX();
		runecraftingY = runecraftingY > 0 ? runecraftingY : client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).getRelativeY();
		woodcuttingX = woodcuttingX > 0 ? woodcuttingX : client.getWidget(WidgetInfo.SKILL_WOODCUTTING).getRelativeX();
		woodcuttingY = woodcuttingY > 0 ? woodcuttingY : client.getWidget(WidgetInfo.SKILL_WOODCUTTING).getRelativeY();
		totalX = totalX > 0 ? totalX : client.getWidget(WidgetInfo.SKILL_TOTAL).getRelativeX();
		totalY = totalY > 0 ? totalY : client.getWidget(WidgetInfo.SKILL_TOTAL).getRelativeY();

		for (Widget widget : getMemberSkills())
		{
			if (widget != null)
			{
				widget.setHidden(enabled);
			}
		}
		//move some free-to-play skills into member skill locations to fill the gaps
		if (enabled)
		{
			int agilityX = client.getWidget(WidgetInfo.SKILL_AGILITY).getRelativeX(),
				agilityY = client.getWidget(WidgetInfo.SKILL_AGILITY).getRelativeY(),
				herbloreX = client.getWidget(WidgetInfo.SKILL_HERBLORE).getRelativeX(),
				herbloreY = client.getWidget(WidgetInfo.SKILL_HERBLORE).getRelativeY(),
				thievingX = client.getWidget(WidgetInfo.SKILL_THIEVING).getRelativeX(),
				thievingY = client.getWidget(WidgetInfo.SKILL_THIEVING).getRelativeY();

			setWidgetRelativePosition(WidgetInfo.SKILL_TOTAL, woodcuttingX, woodcuttingY);
			setWidgetRelativePosition(WidgetInfo.SKILL_MAGIC, prayerX, prayerY);
			setWidgetRelativePosition(WidgetInfo.SKILL_WOODCUTTING, craftingX, craftingY);
			setWidgetRelativePosition(WidgetInfo.SKILL_PRAYER, agilityX, agilityY);
			setWidgetRelativePosition(WidgetInfo.SKILL_CRAFTING, herbloreX, herbloreY);
			setWidgetRelativePosition(WidgetInfo.SKILL_RUNECRAFTING, thievingX, thievingY);
		}
		//move all skills back to original positions
		else
		{
			setWidgetRelativePosition(WidgetInfo.SKILL_TOTAL, totalX, totalY);
			setWidgetRelativePosition(WidgetInfo.SKILL_MAGIC, magicX, magicY);
			setWidgetRelativePosition(WidgetInfo.SKILL_WOODCUTTING, woodcuttingX, woodcuttingY);
			setWidgetRelativePosition(WidgetInfo.SKILL_PRAYER, prayerX, prayerY);
			setWidgetRelativePosition(WidgetInfo.SKILL_CRAFTING, craftingX, craftingY);
			setWidgetRelativePosition(WidgetInfo.SKILL_RUNECRAFTING, runecraftingX, runecraftingY);
		}
	}

	private boolean hideMembersEnabled()
	{
		return !client.getWorldType().contains(WorldType.MEMBERS) && config.hideMembersSkills();
	}

	private void setWidgetRelativePosition(WidgetInfo skillWidgetInfo, int x, int y)
	{
		final Widget widget = client.getWidget(skillWidgetInfo);
		if (widget == null)
		{
			return;
		}
		widget.setRelativeX(x);
		widget.setRelativeY(y);
	}
}
