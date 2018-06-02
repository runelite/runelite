/*
 * Copyright (c) 2018, Franck Maillot <https://github.com/Franck-M>
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
package net.runelite.client.plugins.kourendlibrary;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

/**
 * The Kourend Library is composed of floors containing rooms. A floor is defined by its level (z coordinate).
 */
class Floor
{
	/**
	 * Full name of the floor. In the case of the Kourend Library Plugin this is representative of the library level
	 * of the floor.
	 */
	@Getter
	private final String name;

	/**
	 * Level of this floor.
	 */
	@Getter
	private final Integer level;

	/**
	 * List of rooms available on this floor. Set when a room register to the floor.
	 * Values are stored in an ArrayList to ensure order is conserved.
	 */
	@Getter
	private List<Room> rooms = new ArrayList<>();

	/**
	 * Constructor for the Floor class. A floor is defined by its level and name.
	 *
	 * @param name Name of the floor.
	 * @param z    z coordinate of the floor.
	 */
	Floor(String name, Integer z)
	{
		this.name = name;
		this.level = z;
	}

	/**
	 * Adding a room to this floor.
	 *
	 * @param room Room to add to this floor.
	 */
	void addRoom(Room room)
	{
		this.rooms.add(room);
	}

	/**
	 * Get a list of bookcases on the floor.
	 *
	 * @return List of bookcases on this floor.
	 */
	List<Bookcase> getBookcases()
	{
		List<Bookcase> bookcases = new ArrayList<>();
		for (Room room : this.getRooms())
		{
			bookcases.addAll(room.getBookcases());
		}
		return bookcases;
	}
}