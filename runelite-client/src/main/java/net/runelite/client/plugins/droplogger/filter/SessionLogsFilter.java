/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.droplogger.filter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.NPCComposition;
import net.runelite.client.plugins.droplogger.data.SessionEventLog;
import net.runelite.client.plugins.droplogger.data.SessionLog;
import net.runelite.client.plugins.droplogger.data.SessionNpcLog;
import net.runelite.client.plugins.droplogger.data.SessionPlayerLog;

public class SessionLogsFilter
{
	@Getter
	@Setter
	private DropTypeFilter dropTypeFilter;

	@Getter
	@Setter
	private DropCollectFilter dropCollectFilter;

	@Getter
	@Setter
	private GroupFilter groupFilter;

	@Getter
	@Setter
	private Set<String> enabledEvents;

	public SessionLogsFilter()
	{
		this.dropTypeFilter = DropTypeFilter.PVM_AND_PVP;
		this.dropCollectFilter = DropCollectFilter.ALL;
		this.groupFilter = GroupFilter.NAME_LEVEL;
		this.enabledEvents = new HashSet<>();
	}

	public String getEventName(SessionLog sessionLog)
	{
		if (sessionLog instanceof SessionNpcLog)
		{
			NPCComposition composition = ((SessionNpcLog) sessionLog).getNpcComposition();
			if (groupFilter == GroupFilter.ID_NAME_LEVEL)
			{
				String name = String.format("[%d] %s",
					composition.getId(),
					composition.getName());
				if (composition.getCombatLevel() > 0)
				{
					name += String.format(" (level-%d)", composition.getCombatLevel());
				}
				return name;
			}
			else if (groupFilter == GroupFilter.NAME)
			{
				return composition.getName();
			}
			else if (groupFilter == GroupFilter.NAME_LEVEL)
			{
				String name = composition.getName();
				if (composition.getCombatLevel() > 0)
				{
					name += String.format(" (level-%d)", composition.getCombatLevel());
				}
				return name;
			}
		}
		else if (sessionLog instanceof SessionEventLog)
		{
			return ((SessionEventLog) sessionLog).getEventName();
		}
		else if (sessionLog instanceof SessionPlayerLog)
		{
			if (groupFilter == GroupFilter.ID_NAME_LEVEL ||
				groupFilter == GroupFilter.NAME_LEVEL)
			{
				return String.format("%s (level-%d)",
					((SessionPlayerLog) sessionLog).getPlayerName(),
					((SessionPlayerLog) sessionLog).getCombatLevel());
			}
			else if (groupFilter == GroupFilter.NAME)
			{
				return ((SessionPlayerLog) sessionLog).getPlayerName();
			}
		}
		return "Unknown";
	}

	public Map<Integer, Integer> getFilteredItems(SessionLog sessionLog)
	{
		if (enabledEvents.size() > 0 && !enabledEvents.contains(getEventName(sessionLog)))
		{
			return null;
		}

		if (sessionLog instanceof SessionNpcLog)
		{
			if (dropTypeFilter == DropTypeFilter.PVP)
			{
				return null;
			}
		}
		else if (sessionLog instanceof SessionEventLog)
		{
			if (dropTypeFilter == DropTypeFilter.PVP)
			{
				return null;
			}
		}
		else if (sessionLog instanceof SessionPlayerLog)
		{
			if (dropTypeFilter == DropTypeFilter.PVM)
			{
				return null;
			}
		}

		if (dropCollectFilter == DropCollectFilter.ALL)
		{
			return sessionLog.getAllItems();
		}
		else if (dropCollectFilter == DropCollectFilter.PICKED_UP)
		{
			return sessionLog.getPickedUpItems();
		}
		else if (dropCollectFilter == DropCollectFilter.LEFT_ON_GROUND)
		{
			return sessionLog.getLeftOnGroundItems();
		}

		return null;
	}
}