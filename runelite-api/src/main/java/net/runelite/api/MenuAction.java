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

public enum MenuAction
{
	/**
	 * Menu action triggered by examining an object.
	 */
	EXAMINE_OBJECT(1002),
	
	/**
	 * Menu action triggered by examining an NPC.
	 */
	EXAMINE_NPC(1003),
	
	/**
	 * Menu action triggered by examining item on ground.
	 */
	EXAMINE_ITEM_GROUND(1004),
	
	/**
	 * Menu action triggered by examining item in inventory.
	 */
	EXAMINE_ITEM(1005),
	
	/**
	 * Menu action triggered by either examining item in bank, examining
	 * item in inventory while having bank open, or examining equipped item.
	 */
	EXAMINE_ITEM_BANK_EQ(1007),
	
	/**
	 * Menu action triggered by using an item in inventory on an item thats
	 * on the ground.
	 */
	USE_ON_ITEM_GROUND(1),
	
	/**
	 * Menu action triggered when checking a trap while hunting.
	 */
	CHECK(3),
	
	/**
	 * Menu action triggered when checking a trap while hunting.
	 */
	DISMANTLE(3),
	
	/**
	 * Menu action triggered by using an item in inventory on an NPC.
	 */
	USE_ON_NPC(7),
	
	/**
	 * Menu action triggered when clicking "Dismiss" on a random event NPC.
	 */
	DISSMISS(13),
	
	/**
	 * Menu action triggered by using an item in inventory on another
	 * player.
	 */
	USE_ON_PLAYER(14),
	
	/**
	 * Menu action triggered when laying a trap that is already on the
	 * ground.
	 */
	LAY_GROUND(21),
	
	/**
	 * Menu action triggered when clicking "CLICK HERE TO PLAY" just after
	 * login.
	 */
	PLAY_RUNESCAPE(24),
	
	/**
	 * Menu action triggered by using an item in your inventory on another
	 * item in your inventory.
	 */
	USE_ON_ITEM_INV(31),
	
	/**
	 * Menu action triggered when laying a trap that is in your inventory.
	 */
	LAY_INV(33),
	
	/**
	 * Menu action triggered when cleaning a herb.
	 */
	CLEAN(33),
	
	/**
	 * Menu action triggered when clicking on a wieldable item in your
	 * inventory.
	 */
	WIELD(34),
	
	/**
	 * Menu action triggered when clicking on a wieldable item in your
	 * inventory.
	 */
	WEAR(34),
	
	/**
	 * Menu action triggered when dropping an item from your inventory.
	 */
	DROP(37),
	
	/**
	 * Menu action triggered clicking on an item in your inventory to "Use"
	 * it, and select it to use it on something else.
	 */
	USE(38),
	
	/**
	 * Menu action injected by runelite for its menu items.
	 */
	RUNELITE(1500),
	
	/**
	 * Menu action triggered when the id is not defined in this class.
	 */
	UNKNOWN(-1);

	private final int id;

	MenuAction(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public static MenuAction of(int id)
	{
		for (MenuAction action : values())
		{
			if (action.id == id)
			{
				return action;
			}
		}
		return UNKNOWN;
	}
}
