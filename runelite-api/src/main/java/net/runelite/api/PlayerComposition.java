/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import javax.annotation.Nullable;
import net.runelite.api.annotations.VisibleForDevtools;
import net.runelite.api.kit.KitType;

/**
 * Represents the template of a player.
 */
public interface PlayerComposition
{
	int KIT_OFFSET = 256;
	int ITEM_OFFSET = 2048;

	/**
	 * Checks if the player is female.
	 *
	 * @return true if the player is female
	 * @deprecated use getGender
	 */
	@Deprecated
	boolean isFemale();

	/**
	 * Get the player gender
	 *
	 * @return 0 for male, 1 for female
	 */
	int getGender();

	/**
	 * Get the body part colors for this player composition.
	 *
	 * @return an array of the colors, always size 5
	 */
	int[] getColors();

	/**
	 * Gets an array of IDs related to equipment slots.
	 * <p>
	 * IDs between {@link #KIT_OFFSET} and {@link #ITEM_OFFSET} are kits, offset by {@link #KIT_OFFSET}.
	 * IDs greater than or equal to {@link #ITEM_OFFSET} are items, offset by {@link #ITEM_OFFSET}.
	 *
	 * @return the equipment IDs
	 */
	int[] getEquipmentIds();

	/**
	 * Gets the equipment ID of a particular slot.
	 *
	 * @param type equipment slot
	 * @return the equipment ID
	 */
	int getEquipmentId(KitType type);

	/**
	 * Gets the kit ID of a particular slot.
	 *
	 * @param type equipment slot
	 * @return the kit ID
	 */
	int getKitId(KitType type);

	/**
	 * Update the cached hash value for player equipment
	 * Used to cache the player models based on equipment.
	 */
	@VisibleForDevtools
	void setHash();

	/**
	 * Get the ID of the NPC that the player is currently transformed into.
	 * Used natively for cutscenes.
	 * @return the id of the npc that the player is rendering as
	 * @see PlayerComposition#setTransformedNpcId(int)
	 */
	int getTransformedNpcId();

	/**
	 * Set the ID of the NPC that the player should transform into.
	 * Used natively for cutscenes.
	 * @see PlayerComposition#getTransformedNpcId()
	 * @param id the id of the npc that the player should render as
	 */
	@VisibleForDevtools
	void setTransformedNpcId(int id);

	/**
	 * Get the overrides for this player composition, indexed by kit id. The overrides
	 * replace the target color/textures for the item instead of using the target colors/textures
	 * from the item composition. Only works if the kittype is an item.
	 * @return
	 */
	@Nullable
	ColorTextureOverride[] getColorTextureOverrides();
}
