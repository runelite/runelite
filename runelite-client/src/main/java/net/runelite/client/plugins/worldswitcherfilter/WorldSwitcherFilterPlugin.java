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
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldClient;
import net.runelite.http.api.worlds.WorldResult;

@PluginDescriptor(
	name = "World Switcher Filter",
	enabledByDefault = false
)
@Slf4j
public class WorldSwitcherFilterPlugin extends Plugin
{
	private Map<Integer, Integer> worldPings = new HashMap<>();
	private List<World> pingsToUpdate = new ArrayList<>();
	private WorldResult worlds;
	private boolean needsWorldPingInit = true;

	private final WorldClient worldClient = new WorldClient();
	private final int REGION_SORT_ASC = 4;
	private final int REGION_SORT_DSC = 5;
	private final int WORLD_LIST_INIT_SCRIPT = 892;
	private final String CONFIG_GROUP = "worldSwitcherFilter";

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private WorldSwitcherFilterConfig config;

	@Provides
	WorldSwitcherFilterConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WorldSwitcherFilterConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		worlds = worldClient.lookupWorlds();
		if (worlds != null)
		{
			worlds.getWorlds().forEach(world -> worldPings.put(world.getId(), 0));
			queueWorldsForUpdate();
		}
		else
		{
			log.warn("Unable to look up worlds");
		}
	}

	@Override
	protected void shutDown()
	{
		rebuildWorldSwitcherList();
	}

	@Schedule(
		asynchronous = true,
		period = 1000,
		unit = ChronoUnit.MILLIS
	)
	public void updateWorldPing()
	{
		if (pingsToUpdate.size() < 1)
		{
			return;
		}

		InetAddress host;
		World world = pingsToUpdate.remove(0);
		try
		{
			host = InetAddress.getByName(world.getAddress());
		}
		catch (UnknownHostException he)
		{
			log.warn("Cannot ping host", he);
			worldPings.put(world.getId(), -1);
			return;
		}

		Instant start = Instant.now();
		try (Socket sock = new Socket(host, 443))
		{
			if (sock.isConnected())
			{
				worldPings.put(world.getId(), (int) ChronoUnit.MILLIS.between(start, Instant.now()));
				if (client.getWidget(WidgetInfo.WORLD_SWITCHER_WIDGET_CONTAINER) != null)
				{
					rebuildWorldSwitcherList();
				}
				return;
			}
			log.warn("Host {} is not reachable", host);
		}
		catch (Exception e)
		{
			log.warn("Could not create new socket", e);
			worldPings.put(world.getId(), -1);
		}

	}

	@Schedule(
		asynchronous = true,
		period = 10,
		unit = ChronoUnit.MINUTES
	)
	public void queueWorldsForUpdate()
	{
		// ping worlds when client is started but after that skip if we're not logged in
		if (client.getGameState().equals(GameState.LOGGED_IN) || needsWorldPingInit)
		{
			log.debug("Updating world pings");
			needsWorldPingInit = false;
			pingsToUpdate.addAll(worlds.getWorlds());
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals(CONFIG_GROUP))
		{
			rebuildWorldSwitcherList();
		}
	}

	private void rebuildWorldSwitcherList()
	{
		clientThread.invokeLater(() -> client.runScript(
			WORLD_LIST_INIT_SCRIPT,
			WidgetInfo.WORLD_SWITCHER_WIDGET.getId(),
			WidgetInfo.WORLD_SWITCHER_SCROLLBAR.getId(),
			WidgetInfo.WORLD_SWITCHER_LIST.getId(),
			WidgetInfo.WORLD_SWITCHER_TYPE_SORT.getId(),
			WidgetInfo.WORLD_SWITCHER_ID_SORT.getId(),
			WidgetInfo.WORLD_SWITCHER_REGION_SORT.getId(),
			WidgetInfo.WORLD_SWITCHER_POPULATION_SORT.getId(),
			WidgetInfo.WORLD_SWITCHER_ACTIVITY_SORT.getId(),
			WidgetInfo.WORLD_SWITCHER_FAVOURITE_ONE.getId(),
			WidgetInfo.WORLD_SWITCHER_FAVOURITE_TWO.getId(),
			4522002,
			WidgetInfo.WORLD_SWITCHER_TOOLTIP_CONTAINER.getId()
		));
	}

	@Subscribe
	public void onScriptEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();
		String[] stringStack = client.getStringStack();
		int stringStackSize = client.getStringStackSize();

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		if (eventName.equals("replaceHover") && !config.replaceRegionFlags())
		{
			int worldNum = intStack[intStackSize - 1];
			if (stringStack[stringStackSize - 1].equals("-"))
			{
				stringStack[stringStackSize - 1] = Integer.toString(worldPings.get(worldNum)) + " ms";
			}
			else
			{
				stringStack[stringStackSize - 1] += "<br>" + Integer.toString(worldPings.get(worldNum)) + " ms";
			}

			return;
		}

		// for some reason, some of these callbacks are triggered with nothing on the stack even though we push
		if (eventName.equals("sortRegion") && config.replaceRegionFlags() && intStackSize > 0)
		{
			intStack[intStackSize - 1] = 1;
			int columnSort = client.getVar(Varbits.WORLD_SWITCHER_COLUMN_SORT);

			// sorting just modifies the world list in-place, so we hook before the call to do our own sort
			if (columnSort == REGION_SORT_ASC)
			{
				Arrays.sort(client.getWorldList(), Comparator.comparingInt(a -> worldPings.get(a.getId())));
			}
			else if (columnSort == REGION_SORT_DSC)
			{
				Arrays.sort(client.getWorldList(),
					Comparator.comparingInt((net.runelite.api.World a) ->
						worldPings.get(a.getId())).reversed()
				);
			}

			return;
		}

		if (eventName.equals("replaceRegionCheck") && config.replaceRegionFlags() && intStackSize > 0)
		{
			int worldNum = intStack[intStackSize - 1];
			intStack[intStackSize - 1] = 1;
			stringStack[stringStackSize - 1] = String.valueOf(worldPings.get(worldNum));
			return;
		}

		if (eventName.equals("filterActive") && intStackSize > 0)
		{
			intStack[intStackSize - 1] = 1;
			return;
		}

		if (eventName.equals("hideWorldCheck"))
		{
			int worldTypeFlag = intStack[intStackSize - 1];
			EnumSet<WorldType> worldTypes = WorldType.fromMask(worldTypeFlag);
			// default case, not hiding this world
			intStack[intStackSize - 1] = 0;

			List<String> whitelistedWorlds = Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.splitToList(config.whitelistedWorlds());
			List<String> blacklistedWorlds = Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.splitToList(config.blacklistedWorlds());

			int worldNum = intStack[intStackSize - 3];

			if (formatWorldNumbers(whitelistedWorlds).contains(worldNum))
			{
				return;
			}
			else if (formatWorldNumbers(blacklistedWorlds).contains(worldNum))
			{
				intStack[intStackSize - 1] = 1;
				return;
			}

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

	private List<Integer> formatWorldNumbers(List<String> worldNums)
	{
		return worldNums.stream().map(str ->
		{
			try
			{
				int numInt = Integer.valueOf(str);
				return numInt < 300 ? numInt + 300 : numInt;
			}
			catch (NumberFormatException ex)
			{
				return null;
			}
		}).collect(Collectors.toList());
	}
}
