/*
 * Copyright (c) 2018, trimbe <https://github.com/trimbe>
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

package net.runelite.client.plugins.worldswitcherfilter;

import com.google.common.base.Splitter;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.WorldType;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "World Switcher Filter",
	enabledByDefault = false
)
@Slf4j
public class WorldSwitcherFilterPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private WorldSwitcherFilterConfig config;

	@Provides
	WorldSwitcherFilterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldSwitcherFilterConfig.class);
	}

	@Subscribe
	public void onScriptEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();
		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		if (eventName.equals("filterActive"))
		{
			intStack[intStackSize - 1] = 1;
		}

		if (eventName.equals("hideWorldCheck"))
		{
			int worldTypeFlag = intStack[intStackSize - 1];
			EnumSet<WorldType> worldTypes = WorldType.fromMask(worldTypeFlag);
			// default case, not hiding this world
			intStack[intStackSize - 1] = 0;

			if (worldTypes.contains(WorldType.PVP) && config.hidePvp())
			{
				intStack[intStackSize - 1] = 1;
				return;
			}
			if (worldTypes.contains(WorldType.SKILL_TOTAL) && config.hideIneligibleTotal())
			{
				String worldDescription = stringStack[stringStackSize - 1];
				List<String> descriptionWords = Splitter.on(' ')
					.omitEmptyStrings()
					.splitToList(worldDescription);

				if (descriptionWords.size() > 0)
				{
					try
					{
						int requiredSkillTotal = Integer.parseInt(descriptionWords.get(0));
						// getTotalLevel doesn't appear to populate ever, and getRealSkillLevel(Skill.OVERALL) is 1
						// getRealSkillLevels returns an array with two 1s at the end, these are useless
						int[] skillLevels = Arrays.copyOf(client.getRealSkillLevels(),
							client.getRealSkillLevels().length - 2);
						int totalLevel = Arrays.stream(skillLevels).sum();

						if (totalLevel < requiredSkillTotal)
						{
							intStack[intStackSize - 1] = 1;
							return;
						}
					}
					catch (NumberFormatException ex)
					{
						log.debug("Error parsing int from world description: {}", descriptionWords.get(0));
					}
				}
			}
			if (worldTypes.contains(WorldType.MEMBERS) && config.hideMember())
			{
				intStack[intStackSize - 1] = 1;
				return;
			} 
			if (!worldTypes.contains(WorldType.MEMBERS) && config.hideF2p())
			{
				intStack[intStackSize - 1] = 1;
				return;
			}
			if (worldTypes.contains(WorldType.DEADMAN) && config.hideDeadman())
			{
				intStack[intStackSize - 1] = 1;
				return;
			}
			if (worldTypes.contains(WorldType.SEASONAL_DEADMAN) && config.hideDeadmanSeasonal())
			{
				intStack[intStackSize - 1] = 1;
				return;
			}

			int regionId = intStack[intStackSize - 2];

			if (regionId == WorldRegions.AUSTRALIA.getRegionId() && config.hideAus())
			{
				intStack[intStackSize - 1] = 1;
				return;
			}
			if (regionId == WorldRegions.GERMANY.getRegionId() && config.hideGermany())
			{
				intStack[intStackSize - 1] = 1;
				return;
			}
			if (regionId == WorldRegions.UK.getRegionId() && config.hideUk())
			{
				intStack[intStackSize - 1] = 1;
				return;
			}
			if (regionId == WorldRegions.USA.getRegionId() && config.hideUsa())
			{
				intStack[intStackSize - 1] = 1;
			}
		}
	}
}
