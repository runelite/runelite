/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

/**
 * An enumeration of game states the client is in.
 */
public enum GameState
{
	/**
	 * Unknown game state.
	 */
	UNKNOWN(-1),
	/**
	 * The client is starting.
	 */
	STARTING(0),
	/**
	 * The client is at the login screen.
	 */
	LOGIN_SCREEN(10),
	/**
	 * There is a player logging in.
	 */
	LOGGING_IN(20),
	/**
	 * The game is being loaded.
	 */
	LOADING(25),
	/**
	 * The user has successfully logged in.
	 */
	LOGGED_IN(30),
	/**
	 * Connection to the server was lost.
	 */
	CONNECTION_LOST(40),
	/**
	 * A world hop is taking place.
	 */
	HOPPING(45);

	/**
	 * The raw state value.
	 */
	private final int state;

	GameState(int state)
	{
		this.state = state;
	}

	/**
	 * Utility method that maps the rank value to its respective
	 * {@link GameState} value.
	 *
	 * @param state the raw state value
	 * @return the gamestate
	 */
	public static GameState of(int state)
	{
		for (GameState gs : GameState.values())
		{
			if (gs.state == state)
			{
				return gs;
			}
		}
		return UNKNOWN;
	}
}
