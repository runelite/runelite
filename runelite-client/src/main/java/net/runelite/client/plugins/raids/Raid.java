/*
 * Copyright (c) 2018, Kamiel
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
package net.runelite.client.plugins.raids;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.raids.solver.Layout;
import net.runelite.client.plugins.raids.solver.Room;

public class Raid
{
	@Getter
	private final RaidRoom[] rooms = new RaidRoom[16];

	@Getter
	private Layout layout;

	// The south west tile of the lobby room
	@Getter
	private WorldPoint gridBase;

	// The index of the lobby room in the rooms array
	@Getter
	private int lobbyIndex;

	public Raid(WorldPoint gridBase, int lobbyIndex)
	{
		this.gridBase = gridBase;
		this.lobbyIndex = lobbyIndex;
	}

	void updateLayout(Layout layout)
	{
		if (layout == null)
		{
			return;
		}

		this.layout = layout;

		for (int i = 0; i < rooms.length; i++)
		{
			if (layout.getRoomAt(i) == null)
			{
				continue;
			}

			RaidRoom room = rooms[i];

			if (room == null)
			{
				RoomType type = RoomType.fromCode(layout.getRoomAt(i).getSymbol());
				room = type.getUnsolvedRoom();
				setRoom(room, i);
			}
		}
	}

	public RaidRoom getRoom(int position)
	{
		return rooms[position];
	}

	public void setRoom(RaidRoom room, int position)
	{
		if (position < rooms.length)
		{
			rooms[position] = room;
		}
	}

	RaidRoom[] getCombatRooms()
	{
		List<RaidRoom> combatRooms = new ArrayList<>();

		for (Room room : layout.getRooms())
		{
			if (room == null)
			{
				continue;
			}

			if (rooms[room.getPosition()].getType() == RoomType.COMBAT)
			{
				combatRooms.add(rooms[room.getPosition()]);
			}
		}

		return combatRooms.toArray(new RaidRoom[0]);
	}

	void setCombatRooms(RaidRoom[] combatRooms)
	{
		int index = 0;

		for (Room room : layout.getRooms())
		{
			if (room == null)
			{
				continue;
			}

			if (rooms[room.getPosition()].getType() == RoomType.COMBAT)
			{
				rooms[room.getPosition()] = combatRooms[index];
				index++;
			}
		}
	}

	public String toCode()
	{
		StringBuilder builder = new StringBuilder();

		for (RaidRoom room : rooms)
		{
			if (room != null)
			{
				builder.append(room.getType().getCode());
			}
			else
			{
				builder.append(" ");
			}
		}

		return builder.toString();
	}

	/**
	 * Get the raid rooms in the order they are in the raid
	 * @return
	 */
	List<RaidRoom> getOrderedRooms()
	{
		List<RaidRoom> orderedRooms = new ArrayList<>();
		for (Room r : getLayout().getRooms())
		{
			final int position = r.getPosition();
			final RaidRoom room = getRoom(position);

			if (room == null)
			{
				continue;
			}

			orderedRooms.add(room);
		}

		return orderedRooms;
	}

	String toRoomString()
	{
		final StringBuilder sb = new StringBuilder();

		for (RaidRoom room : getOrderedRooms())
		{
			switch (room.getType())
			{
				case PUZZLE:
				case COMBAT:
					sb.append(room.getName()).append(", ");
					break;
			}
		}

		final String roomsString = sb.toString();
		return roomsString.substring(0, roomsString.length() - 2);
	}
}
