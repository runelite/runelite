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
 * Holds data of RuneScape world.
 */
public interface World
{
	/**
	 * Gets world types.
	 *
	 * @return the types
	 */
	EnumSet<WorldType> getTypes();

	/**
	 * Sets world types.
	 *
	 * @param types the types
	 */
	void setTypes(EnumSet<WorldType> types);

	/**
	 * Gets player count.
	 *
	 * @return the player count
	 */
	int getPlayerCount();

	/**
	 * Sets player count.
	 *
	 * @param playerCount the player count
	 */
	void setPlayerCount(int playerCount);

	/**
	 * Gets location.
	 *
	 * @return the location
	 */
	int getLocation();

	/**
	 * Sets location.
	 *
	 * @param location the location
	 */
	void setLocation(int location);

	/**
	 * Gets index.
	 *
	 * @return the index
	 */
	int getIndex();

	/**
	 * Sets index.
	 *
	 * @param index the index
	 */
	void setIndex(int index);

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	int getId();

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	void setId(int id);

	/**
	 * Gets activity.
	 *
	 * @return the activity
	 */
	String getActivity();

	/**
	 * Sets activity.
	 *
	 * @param activity the activity
	 */
	void setActivity(String activity);

	/**
	 * Gets address.
	 *
	 * @return the address
	 */
	String getAddress();

	/**
	 * Sets address.
	 *
	 * @param address the address
	 */
	void setAddress(String address);
}
