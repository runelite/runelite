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

<<<<<<< HEAD

import java.util.EnumSet;

/**
 * Holds data of RuneScape world.
=======
import java.util.EnumSet;

/**
 * Holds data of a RuneScape world.
>>>>>>> upstream/master
 */
public interface World
{
	/**
<<<<<<< HEAD
	 * Gets world types.
	 *
	 * @return the types
=======
	 * Gets all applicable world types for this world.
	 *
	 * @return the world types
>>>>>>> upstream/master
	 */
	EnumSet<WorldType> getTypes();

	/**
	 * Sets world types.
	 *
	 * @param types the types
	 */
	void setTypes(EnumSet<WorldType> types);

	/**
<<<<<<< HEAD
	 * Gets player count.
=======
	 * Gets the current number of players logged in the world.
>>>>>>> upstream/master
	 *
	 * @return the player count
	 */
	int getPlayerCount();

	/**
<<<<<<< HEAD
	 * Sets player count.
	 *
	 * @param playerCount the player count
=======
	 * Sets the player count of the world.
	 *
	 * @param playerCount the new player count
>>>>>>> upstream/master
	 */
	void setPlayerCount(int playerCount);

	/**
<<<<<<< HEAD
	 * Gets location.
	 *
	 * @return the location
=======
	 * Gets the world location value.
	 *
	 * @return the world location
>>>>>>> upstream/master
	 */
	int getLocation();

	/**
<<<<<<< HEAD
	 * Sets location.
=======
	 * Sets the world location value.
>>>>>>> upstream/master
	 *
	 * @param location the location
	 */
	void setLocation(int location);

	/**
<<<<<<< HEAD
	 * Gets index.
=======
	 * Gets the worlds index.
>>>>>>> upstream/master
	 *
	 * @return the index
	 */
	int getIndex();

	/**
<<<<<<< HEAD
	 * Sets index.
=======
	 *  Sets the worlds index.
>>>>>>> upstream/master
	 *
	 * @param index the index
	 */
	void setIndex(int index);

	/**
<<<<<<< HEAD
	 * Gets id.
	 *
	 * @return the id
=======
	 * Gets the world number.
	 *
	 * @return the world number
>>>>>>> upstream/master
	 */
	int getId();

	/**
<<<<<<< HEAD
	 * Sets id.
	 *
	 * @param id the id
=======
	 * Sets the world number.
	 *
	 * @param id the world number
>>>>>>> upstream/master
	 */
	void setId(int id);

	/**
<<<<<<< HEAD
	 * Gets activity.
	 *
	 * @return the activity
=======
	 * Gets the world activity description.
	 * <p>
	 * For example, world 2 would return "Trade - Members".
	 *
	 * @return the world activity
>>>>>>> upstream/master
	 */
	String getActivity();

	/**
<<<<<<< HEAD
	 * Sets activity.
=======
	 * Sets the world activity description.
>>>>>>> upstream/master
	 *
	 * @param activity the activity
	 */
	void setActivity(String activity);

	/**
<<<<<<< HEAD
	 * Gets address.
	 *
	 * @return the address
=======
	 * Gets the address of the world.
	 *
	 * @return the world address
>>>>>>> upstream/master
	 */
	String getAddress();

	/**
<<<<<<< HEAD
	 * Sets address.
=======
	 * Sets the address of the world.
>>>>>>> upstream/master
	 *
	 * @param address the address
	 */
	void setAddress(String address);
}
