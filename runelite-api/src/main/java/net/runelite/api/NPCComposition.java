/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
 * Represents the template of a specific NPC type.
 */
public interface NPCComposition
{
	/**
	 * Gets the name of the NPC.
	 *
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the model IDs that compose this NPC.
	 *
	 * @return the NPCs model IDs
	 */
	int[] getModels();

	/**
	 * Gets an array of possible right-click menu actions that can be
	 * performed on the NPC.
	 *
	 * @return the menu actions
	 */
	String[] getActions();

	/**
	 * Gets whether the NPC can be clicked.
	 *
	 * @return true if the NPC can be clicked, false otherwise
	 */
	boolean isClickable();

	/**
	 * Gets whether the NPC is visible on the mini-map.
	 *
	 * @return the mini-map visible state
	 */
	boolean isMinimapVisible();

	/**
	 * Gets whether the NPC is visible.
	 *
	 * @return the visible state
	 */
	boolean isVisible();

	/**
	 * Gets the ID of the NPC.
	 *
	 * @return the ID of the NPC
	 * @see NpcID
	 */
	int getId();

	/**
	 * Gets the combat level of the NPC.
	 *
	 * @return the combat level, -1 if none
	 */
	int getCombatLevel();

	/**
	 * Gets the configuration data for the NPC.
	 *
	 * @return the configuration data
	 */
	int[] getConfigs();

	/**
	 * Transforms this NPC into a new state, which may have a different ID.
	 *
	 * @return the transformed composition
	 */
	NPCComposition transform();

	/**
	 * Gets the size of the NPC.
	 *
	 * @return the NPCs size
	 */
	int getSize();

	/**
	 * Gets the displayed overhead icon of the NPC.
	 *
	 * @return the overhead icon
	 */
	HeadIcon getOverheadIcon();
}
