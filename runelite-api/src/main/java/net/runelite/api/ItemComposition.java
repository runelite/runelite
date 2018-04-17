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

public interface ItemComposition
{
	/**
	 * Returns the item's name as a string.
	 *
	 * @return the name of the item
	 */
	String getName();

	/**
	 * Returns the item's ID. A list of item IDs can be found in
	 * ItemID.
	 *
	 * @return the item's ID as an integer
	 */
	int getId();

	/**
	 * Returns a result that depends on whether the item is in noted form or
	 * not.
	 *
	 * @return 799 if noted, -1 if unnoted
	 */
	int getNote();

	/**
	 * Returns the item ID of the noted/unnoted counterpart. For example, if
	 * you call this on an unnoted monkfish(ID 7946), this method will
	 * return the ID of a noted monkfish(ID 7947), and vice versa.
	 *
	 * @return the ID that is linked to this item in noted/unnoted form.
	 */
	int getLinkedNoteId();

	/**
	 * Returns the item ID of the normal/placeholder counterpart. For example, if
	 * you call this on a monkfish(ID 7946), this method will
	 * return the ID of a placeholder monkfish(ID 17065), and vice versa.
	 *
	 * @return the ID that is linked to this item in normal/placeholder form.
	 */
	int getPlaceholderId();

	/**
	 * Returns a result that depends on whether the item is in placeholder form or
	 * not.
	 *
	 * @return 14401 if placeholder, -1 if normal
	 */
	int getPlaceholderTemplateId();

	/**
	 * Returns the store price of the item. Even if the item cannot be found
	 * in a store, all items have a store price from which the High and Low
	 * Alchemy values are calculated. Multiply the price by 0.6 to get the
	 * High Alchemy value, or 0.4 to get the Low Alchemy value.
	 *
	 * @return the general store value of the item
	 */
	int getPrice();

	/**
	 * Returns whether or not the item is members-only.
	 *
	 * @return true if members-only, false otherwise.
	 */
	boolean isMembers();

	/**
	 * Returns whether or not the item stacks in the players' inventories
	 *
	 * @return true if stackable, false otherwise
	 */
	boolean isStackable();

	/**
	 * Returns the menu actions the item has in a players' inventory
	 *
	 * @return the inventory menu actions
	 */
	String[] getInventoryActions();

	/**
	 * Returns the menu action index of the shift-click action
	 *
	 * @return menu index of the shift-click action
	 */
	int getShiftClickActionIndex();

	void setShiftClickActionIndex(int shiftclickActionIndex);

	void resetShiftClickActionIndex();
}
