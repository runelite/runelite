/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.api;

import java.util.EnumSet;

/**
 * Holds data of a RuneScape world.
 */
public interface World
{
	/**
	 * Gets all applicable world types for this world.
	 *
	 * @return the world types
	 */
	EnumSet<WorldType> getTypes();

	/**
	 * Sets world types.
	 *
	 * @param types the types
	 */
	void setTypes(EnumSet<WorldType> types);

	/**
	 * Gets the current number of players logged in the world.
	 *
	 * @return the player count
	 */
	int getPlayerCount();

	/**
	 * Sets the player count of the world.
	 *
	 * @param playerCount the new player count
	 */
	void setPlayerCount(int playerCount);

	/**
	 * Gets the world location value.
	 *
	 * @return the world location
	 */
	int getLocation();

	/**
	 * Sets the world location value.
	 *
	 * @param location the location
	 */
	void setLocation(int location);

	/**
	 * Gets the worlds index.
	 *
	 * @return the index
	 */
	int getIndex();

	/**
	 *  Sets the worlds index.
	 *
	 * @param index the index
	 */
	void setIndex(int index);

	/**
	 * Gets the world number.
	 *
	 * @return the world number
	 */
	int getId();

	/**
	 * Sets the world number.
	 *
	 * @param id the world number
	 */
	void setId(int id);

	/**
	 * Gets the world activity description.
	 * <p>
	 * For example, world 2 would return "Trade - Members".
	 *
	 * @return the world activity
	 */
	String getActivity();

	/**
	 * Sets the world activity description.
	 *
	 * @param activity the activity
	 */
	void setActivity(String activity);

	/**
	 * Gets the address of the world.
	 *
	 * @return the world address
	 */
	String getAddress();

	/**
	 * Sets the address of the world.
	 *
	 * @param address the address
	 */
	void setAddress(String address);
}
