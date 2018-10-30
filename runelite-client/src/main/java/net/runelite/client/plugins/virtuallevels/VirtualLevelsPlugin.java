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

import com.google.common.eventbus.Subscribe;
import javax.inject.Inject;

import com.google.inject.Provides;
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
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.ArrayList;

@PluginDescriptor(
	name = "Virtual Levels",
	description = "Configuration for the virtual levels plugin.",
	tags = {"skill", "total", "max", "f2p", "free "},
	enabledByDefault = false
)

public class VirtualLevelsPlugin extends Plugin
{
	private static final String TOTAL_LEVEL_TEXT_PREFIX = "Total level:<br>";

	private static final int
			PRAYER_X = 1,
			PRAYER_Y = 129,
			MAGIC_X = 1,
			MAGIC_Y = 161,
			CRAFTING_X = 64,
			CRAFTING_Y = 129,
			RUNECRAFTING_X = 1,
			RUNECRAFTING_Y = 193,
			WOODCUTTING_X = 127,
			WOODCUTTING_Y = 161,
			TOTAL_X = 127,
			TOTAL_Y = 225;

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
		showMemberOnlySkills(enabledHideMembers());
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(this::simulateSkillChange);
		showMemberOnlySkills(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged config)
	{
		if (config.getGroup().equals("virtualLevels"))
		{
			clientThread.invoke(this::simulateSkillChange);
			showMemberOnlySkills(enabledHideMembers());
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
			showMemberOnlySkills(enabledHideMembers());
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		showMemberOnlySkills(enabledHideMembers());
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
					if (enabledHideMembers())
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

	private ArrayList<Widget> getMemberSkills()
	{
		ArrayList<Widget> membersOnlyWidgets = new ArrayList<>();

		Widget agility = client.getWidget(WidgetInfo.SKILL_AGILITY),
			construction = client.getWidget(WidgetInfo.SKILL_CONSTRUCTION),
			farming = client.getWidget(WidgetInfo.SKILL_FARMING),
			fletching = client.getWidget(WidgetInfo.SKILL_FLETCHING),
			herblore = client.getWidget(WidgetInfo.SKILL_HERBLORE),
			hunter = client.getWidget(WidgetInfo.SKILL_HUNTER),
			thieving = client.getWidget(WidgetInfo.SKILL_THIEVING),
			slayer = client.getWidget(WidgetInfo.SKILL_SLAYER);

		membersOnlyWidgets.add(agility);
		membersOnlyWidgets.add(construction);
		membersOnlyWidgets.add(farming);
		membersOnlyWidgets.add(fletching);
		membersOnlyWidgets.add(herblore);
		membersOnlyWidgets.add(hunter);
		membersOnlyWidgets.add(thieving);
		membersOnlyWidgets.add(slayer);

		return membersOnlyWidgets;
	}

	private void shuffleSkills(boolean enabled)
	{
		if (client.getWidget(WidgetInfo.SKILL_TOTAL) == null)
		{
			return;
		}
		//move some free-to-play skills into member skill locations to fill the gaps
		if (enabled)
		{
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeX(WOODCUTTING_X);
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeY(WOODCUTTING_Y);
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeX(client.getWidget(WidgetInfo.SKILL_AGILITY).getRelativeX());
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeY(client.getWidget(WidgetInfo.SKILL_AGILITY).getRelativeY());
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeX(PRAYER_X);
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeY(PRAYER_Y);
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeX(client.getWidget(WidgetInfo.SKILL_HERBLORE).getRelativeX());
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeY(client.getWidget(WidgetInfo.SKILL_HERBLORE).getRelativeY());
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeX(client.getWidget(WidgetInfo.SKILL_THIEVING).getRelativeX());
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeY(client.getWidget(WidgetInfo.SKILL_THIEVING).getRelativeY());
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeX(CRAFTING_X);
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeY(CRAFTING_Y);
		}
		//move all skills back to original positions
		else
		{
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeX(TOTAL_X);
			client.getWidget(WidgetInfo.SKILL_TOTAL).setRelativeY(TOTAL_Y);
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeX(PRAYER_X);
			client.getWidget(WidgetInfo.SKILL_PRAYER).setRelativeY(PRAYER_Y);
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeX(MAGIC_X);
			client.getWidget(WidgetInfo.SKILL_MAGIC).setRelativeY(MAGIC_Y);
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeX(CRAFTING_X);
			client.getWidget(WidgetInfo.SKILL_CRAFTING).setRelativeY(CRAFTING_Y);
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeX(RUNECRAFTING_X);
			client.getWidget(WidgetInfo.SKILL_RUNECRAFTING).setRelativeY(RUNECRAFTING_Y);
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeX(WOODCUTTING_X);
			client.getWidget(WidgetInfo.SKILL_WOODCUTTING).setRelativeY(WOODCUTTING_Y);
		}
	}

	private void showMemberOnlySkills(boolean enabled)
	{
		for (Widget widget : getMemberSkills())
		{
			if (widget != null)
			{
				widget.setHidden(enabled);
			}
		}
		shuffleSkills(enabled);
	}

	private boolean enabledHideMembers()
	{
		return !client.getWorldType().contains(WorldType.MEMBERS) && config.hideMembersSkills();
	}
}
