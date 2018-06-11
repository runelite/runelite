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

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * The Kourend Library is composed of 11 rooms, this class is used to make a distinction between such rooms.
 * Rooms are defined their level as well as max and min x/y coordinates.
 * The minimum and maximum (x, y) coordinate is hard coded for each room as there are differences between the
 * different floors, this also serve to force the library bookcases to actually be inside the library.
 */
class Room
{
	/**
	 * Name of the room used on the user's interface. As the important information for each room in the library is
	 * its location, in this case the name of the room is its location (Northeast, center, ...) in the library.
	 */
	@Getter
	private final String name;

	/**
	 * Minimum x-axis coordinate of the room.
	 */
	@Getter
	private final Integer minX;

	/**
	 * Maximum x-axis coordinate of the room.
	 */
	@Getter
	private final int maxX;

	/**
	 * Minimum y-axis coordinate of the room.
	 */
	@Getter
	private final int minY;

	/**
	 * Maximum y-axis coordinate of the room.
	 */
	@Getter
	private final int maxY;

	/**
	 * z coordinate of the room.
	 */
	@Getter
	private final int z;

	/**
	 * List of bookcases in this room. This list is filled when the bookcases are created.
	 */
	@Getter
	private List<Bookcase> bookcases;

	// Variables initialization
	{
		bookcases = new ArrayList<>();
	}

	/**
	 * Constructor for the Room class. Rooms are defined by their floor and ordinal. When a room is created it
	 * will add itself to its floor for easier access.
	 *
	 * @param name      Name of the floor.
	 * @param minX      Minimum x coordinate of the room.
	 * @param maxX      Maximum x coordinate of the room.
	 * @param minY      Minimum y coordinate of the room.
	 * @param maxY      Maximum y coordinate of the room.
	 * @param z         z coordinate of the room.
	 */
	Room(String name, int minX, int maxX, int minY, int maxY, int z)
	{
		this.name = name;
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		this.z = z;
	}

	/**
	 * Register a bookcase to this room list of bookcases.
	 *
	 * @param bookcase Bookcase to add to the room.
	 */
	void addBookcase(Bookcase bookcase)
	{
		this.bookcases.add(bookcase);
	}
}