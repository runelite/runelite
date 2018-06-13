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
package net.runelite.rs.api;

import net.runelite.api.ItemComposition;
import net.runelite.mapping.Import;

/**
 * ItemComposition is an interface that represents the various properties of an
 * item. Imports several values from runescape-client/ItemComposition, and allows
 * direct access to them by calling these methods.
 */
public interface RSItemComposition extends ItemComposition
{
	@Import("name")
	@Override
	String getName();

	@Import("id")
	@Override
	int getId();

	@Import("notedTemplate")
	@Override
	int getNote();

	@Import("note")
	@Override
	int getLinkedNoteId();

	@Import("placeholderId")
	@Override
	int getPlaceholderId();

	@Import("placeholderTemplateId")
	@Override
	int getPlaceholderTemplateId();

	@Import("price")
	@Override
	int getPrice();

	@Import("isMembers")
	@Override
	boolean isMembers();

	@Import("isTradable")
	@Override
	boolean isTradeable();

	/**
	 * You probably want {@link #isStackable}
	 * <p>
	 * This is the <b>{@code int}</b> that client code uses internally to represent this true/false value. It appears to only ever be set to 1 or 0
	 * @return 0 when this type of item isn't stackable, 1 otherwise
	 */
	@Import("isStackable")
	int getIsStackable();

	@Import("maleModel")
	int getMaleModel();

	@Import("inventoryActions")
	@Override
	String[] getInventoryActions();

	@Import("getShiftClickActionIndex")
	@Override
	int getShiftClickActionIndex();
}
