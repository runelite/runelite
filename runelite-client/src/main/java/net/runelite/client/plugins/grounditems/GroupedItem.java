/*
 * Copyright (c) 2019, Ricky <https://github.com/RickyLoader>
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
package net.runelite.client.plugins.grounditems;

import net.runelite.api.MenuEntry;
import net.runelite.client.plugins.grounditems.GroundItemsConfig.*;

/**
 * Object used to store a MenuEntry and the quantity. Updates the entry target if necessary
 * e.g Shark to Shark [4].
 */
class GroupedItem
{

	private int count;
	private MenuEntry entry;
	private styleOption style;
	private positionOption pos;
	private boolean includeX;

	/**
	 * Constructor for GroupedItem.
	 *
	 * @param entry The menu entry to be tracked for duplicates
	 */
	GroupedItem(MenuEntry entry, positionOption pos, styleOption style, boolean includeX)
	{
		this.entry = entry;
		this.pos = pos;
		this.style = style;
		this.count = 1;
		this.includeX = includeX;
	}

	/**
	 * Getter for the menu entry, updates the target to reflect the quantity if more than 1
	 * was found.
	 *
	 * @return Updated MenuEntry containing quantity
	 */
	MenuEntry getEntry()
	{
		if (count > 1)
		{
			updateTarget();
		}
		return entry;
	}

	/**
	 * Updates the target of the menu entry to contain the quantity found in the desired style.
	 */
	private void updateTarget()
	{
		String target = entry.getTarget();
		String quantity = "";

		if (includeX)
		{
			quantity = "x";
		}

		quantity += count;

		switch (style)
		{
			case SQUARE:
				quantity = "[" + quantity + "]";
				break;
			case PARENTHESES:
				quantity = "(" + quantity + ")";
				break;
			case CURLY:
				quantity = "{" + quantity + "}";
				break;
		}

		switch (pos)
		{
			case APPEND:
				target = target + " " + quantity;
				break;
			case PREPEND:
				target = quantity + " " + target;
				break;
		}
		entry.setTarget(target);
	}

	/**
	 * Increment count when duplicate entries are found.
	 */
	void incrementCount()
	{
		count += 1;
	}
}
