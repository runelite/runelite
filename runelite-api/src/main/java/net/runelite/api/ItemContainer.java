/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents an inventory that contains items.
 */
public interface ItemContainer extends Node
{
	/**
	 * Get the item container id
	 *
	 * @return
	 * @see InventoryID
	 */
	int getId();

	/**
	 * Gets an array of all items in the container.
	 *
	 * @return the items held
	 */
	@Nonnull
	Item[] getItems();

	/**
	 * Gets an item from the container at the given slot.
	 *
	 * @param slot
	 * @return the item
	 * @see Item
	 */
	@Nullable
	Item getItem(int slot);

	/**
	 * Check if this item container contains the given item
	 *
	 * @param itemId
	 * @return
	 * @see ItemID
	 */
	boolean contains(int itemId);

	/**
	 * Counts how many of an item this item container contains
	 *
	 * @param itemId
	 * @return
	 * @see ItemID
	 */
	int count(int itemId);

	/**
	 * Get the number of items in this item container. May include empty slots.
	 * @return
	 */
	int size();
}
