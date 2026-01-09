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

import org.intellij.lang.annotations.MagicConstant;

/**
 * Represents a player entity in the game.
 */
public interface Player extends Actor
{
	/**
	 * Get the ID of the player
	 *
	 * @return
	 */
	int getId();

	@Override
	int getCombatLevel();

	/**
	 * Gets the composition of this player.
	 *
	 * @return the composition
	 */
	PlayerComposition getPlayerComposition();

	/**
	 * Gets the current team cape team number the player is on.
	 *
	 * @return team number, or 0 if not on any team
	 */
	int getTeam();

	/**
	 * Checks whether this player is a member of the same friends chat
	 * the local player.
	 *
	 * @return true if the player is a friends chat member, false otherwise
	 */
	boolean isFriendsChatMember();

	/**
	 * Checks whether this player is a friend of the local player.
	 *
	 * @return true if the player is a friend, false otherwise
	 */
	boolean isFriend();

	/**
	 * Checks whether the player is a member of the same clan as the local player.
	 *
	 * @return
	 */
	boolean isClanMember();

	/**
	 * Gets the displayed overhead icon of the player.
	 *
	 * @return the overhead icon
	 */
	HeadIcon getOverheadIcon();

	/**
	 * Gets the displayed skull icon of the player.
	 *
	 * @return the id skull icon, or -1 if unskulled.
	 * @see SkullIcon
	 */
	@MagicConstant(valuesFromClass = SkullIcon.class)
	int getSkullIcon();

	/**
	 * Sets the displayed skull icon of the player.
	 * @param skullIcon The id of the skull icon, or -1 to remove the skull icon.
	 * @see SkullIcon
	 */
	void setSkullIcon(@MagicConstant(valuesFromClass = SkullIcon.class) int skullIcon);

	/**
	 * Get the player footprint size
	 * @return
	 */
	int getFootprintSize();
}
