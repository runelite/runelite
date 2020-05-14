/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
 * Copyright (c) 2020, ThatGamerBlue <thatgamerblue@gmail.com>
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
package net.runelite.client.ui.overlay.worldmap;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;

@Singleton
public class WorldMapPointManager
{
	@Getter(AccessLevel.PACKAGE)
	private final List<WorldMapPoint> worldMapPoints = new CopyOnWriteArrayList<>();

	@Inject
	private Client client;

	private final int WORLDMAP_SETDISABLEALL_OPCODE = 1;
	private final int WORLDMAP_GETDISABLEALL_OPCODE = 2;
	private final int WORLDMAP_SETDISABLECATEGORY_OPCODE = 3;
	private final int WORLDMAP_GETDISABLECATEGORY_OPCODE = 4;

	public void setCategoryEnabled(int internalId, boolean enabled)
	{
		client.runScript(ScriptID.WORLDMAP_ICON_UTIL, WORLDMAP_SETDISABLECATEGORY_OPCODE, internalId, enabled ? 1 : 0);
	}

	public boolean isCategoryEnabled(int internalId)
	{
		// The -1 here is irrelevant
		client.runScript(ScriptID.WORLDMAP_ICON_UTIL, WORLDMAP_GETDISABLECATEGORY_OPCODE, internalId, -1);
		int newStackSize = client.getIntStackSize() - 1;
		try
		{
			return client.getIntStack()[newStackSize] == 1;
		}
		finally
		{
			client.setIntStackSize(newStackSize);
		}
	}

	public void setAllElementsEnabled(boolean enabled)
	{
		// The -1 here is irrelevant
		client.runScript(ScriptID.WORLDMAP_ICON_UTIL, WORLDMAP_SETDISABLEALL_OPCODE, -1, enabled ? 1 : 0);
	}

	public boolean getAllElementsEnabled()
	{
		// The -1s here are irrelevant
		client.runScript(ScriptID.WORLDMAP_ICON_UTIL, WORLDMAP_GETDISABLEALL_OPCODE, -1, -1);
		int newStackSize = client.getIntStackSize() - 1;
		try
		{
			return client.getIntStack()[newStackSize] == 1;
		}
		finally
		{
			client.setIntStackSize(newStackSize);
		}
	}

	public void add(WorldMapPoint worldMapPoint)
	{
		worldMapPoints.add(worldMapPoint);
	}

	public void remove(WorldMapPoint worldMapPoint)
	{
		worldMapPoints.remove(worldMapPoint);
	}

	public void removeIf(Predicate<WorldMapPoint> filter)
	{
		worldMapPoints.removeIf(filter);
	}
}
