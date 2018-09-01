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

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration of right-click menu actions.
 */
public enum MenuAction
{
	/**
	 * Menu action for using an item in your inventory on a tile object (GameObject or GroundObject).
	 */
	ITEM_USE_ON_GAME_OBJECT(1),
	/**
	 * Menu action for casting a spell on a tile object (GameObject or GroundObject).
	 */
	SPELL_CAST_ON_GAME_OBJECT(2),
	/**
	 * First menu action for a game object.
	 */
	GAME_OBJECT_FIRST_OPTION(3),
	/**
	 * Second menu action for a game object.
	 */
	GAME_OBJECT_SECOND_OPTION(4),
	/**
	 * Third menu action for a game object.
	 */
	GAME_OBJECT_THIRD_OPTION(5),
	/**
	 * Fourth menu action for a game object.
	 */
	GAME_OBJECT_FOURTH_OPTION(6),
	/**
	 * Fifth menu action for a game object.
	 */
	GAME_OBJECT_FIFTH_OPTION(1001),

	/**
	 * Menu action for using an item in your inventory on an NPC.
	 */
	ITEM_USE_ON_NPC(7),
	/**
	 * Menu action for casting a spell on an NPC.
	 */
	SPELL_CAST_ON_NPC(8),
	/**
	 * First menu action for an NPC.
	 */
	NPC_FIRST_OPTION(9),
	/**
	 * Second menu action for an NPC.
	 */
	NPC_SECOND_OPTION(10),
	/**
	 * Third menu action for an NPC.
	 */
	NPC_THIRD_OPTION(11),
	/**
	 * Fourth menu action for an NPC.
	 */
	NPC_FOURTH_OPTION(12),
	/**
	 * Fifth menu action for an NPC.
	 */
	NPC_FIFTH_OPTION(13),

	/**
	 * Menu action for using an item on a player.
	 */
	ITEM_USE_ON_PLAYER(14),
	/**
	 * Menu action for casting a spell on a player.
	 */
	SPELL_CAST_ON_PLAYER(15),

	/**
	 * Menu action for using an item on an item on the ground.
	 */
	ITEM_USE_ON_GROUND_ITEM(16),
	/**
	 * Menu action for casting a spell on an item on the ground.
	 */
	SPELL_CAST_ON_GROUND_ITEM(17),
	/**
	 * First menu action for an item on the ground.
	 */
	GROUND_ITEM_FIRST_OPTION(18),
	/**
	 * Second menu action for an item on the ground.
	 */
	GROUND_ITEM_SECOND_OPTION(19),
	/**
	 * Third menu action for an item on the ground.
	 */
	GROUND_ITEM_THIRD_OPTION(20),
	/**
	 * Fourth menu action for an item on the ground.
	 */
	GROUND_ITEM_FOURTH_OPTION(21),
	/**
	 * Fifth menu action for an item on the ground.
	 */
	GROUND_ITEM_FIFTH_OPTION(22),

	/**
	 * Menu action for walking.
	 */
	WALK(23),

	/**
	 * Interaction with widget (type 1).
	 */
	WIDGET_TYPE_1(24),
	/**
	 * Interaction with widget (type 2).
	 */
	WIDGET_TYPE_2(25),
	/**
	 * Interaction with widget (type 3).
	 */
	WIDGET_TYPE_3(26),
	/**
	 * Interaction with widget (type 4).
	 */
	WIDGET_TYPE_4(28),
	/**
	 * Interaction with widget (type 5).
	 */
	WIDGET_TYPE_5(29),
	/**
	 * Interaction with widget (type 6).
	 */
	WIDGET_TYPE_6(30),
	/**
	 * Menu action when using an item on another item inside a widget (inventory).
	 */
	ITEM_USE_ON_WIDGET_ITEM(31),
	/**
	 * Menu action when using an item on a widget.
	 */
	ITEM_USE_ON_WIDGET(32),

	/**
	 * First menu action for an item.
	 */
	ITEM_FIRST_OPTION(33),
	/**
	 * Second menu action for an item.
	 */
	ITEM_SECOND_OPTION(34),
	/**
	 * Third menu action for an item.
	 */
	ITEM_THIRD_OPTION(35),
	/**
	 * Fourth menu action for an item.
	 */
	ITEM_FOURTH_OPTION(36),
	/**
	 * Fifth menu action for an item.
	 */
	ITEM_FIFTH_OPTION(37),
	/**
	 * Menu action to drop an item (identical to ITEM_FIFTH_OPTION).
	 */
	ITEM_DROP(37),
	/**
	 * Menu action to use an item.
	 */
	ITEM_USE(38),

	/**
	 * First menu action for a widget.
	 */
	WIDGET_FIRST_OPTION(39),
	/**
	 * Second menu action for a widget.
	 */
	WIDGET_SECOND_OPTION(40),
	/**
	 * Third menu action for a widget.
	 */
	WIDGET_THIRD_OPTION(41),
	/**
	 * Fourth menu action for a widget.
	 */
	WIDGET_FOURTH_OPTION(42),
	/**
	 * Fifth menu action for a widget.
	 */
	WIDGET_FIFTH_OPTION(43),

	PLAYER_FIRST_OPTION(44),
	PLAYER_SECOND_OPTION(45),
	PLAYER_THIRD_OPTION(46),
	PLAYER_FOURTH_OPTION(47),
	PLAYER_FIFTH_OPTION(48),
	PLAYER_SIXTH_OPTION(49),
	PLAYER_SEVENTH_OPTION(50),
	PLAYER_EIGTH_OPTION(51),

	/**
	 * Default menu action for a widget.
	 */
	WIDGET_DEFAULT(57),

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
	 * Menu action triggered by canceling a menu.
	 */
	CANCEL(1006),
	/**
	 * Menu action triggered by either examining item in bank, examining
	 * item in inventory while having bank open, or examining equipped item.
	 */
	EXAMINE_ITEM_BANK_EQ(1007),

	/**
	 * Menu action injected by runelite for its menu items.
	 */
	RUNELITE(1500),

	FOLLOW(2046),
	TRADE(2047),

	/**
	 * Menu action triggered when the id is not defined in this class.
	 */
	UNKNOWN(-1);

	public static final int MENU_ACTION_DEPRIORITIZE_OFFSET = 2000;

	private static final Map<Integer, MenuAction> map = new HashMap<>();

	static
	{
		for (MenuAction menuAction : values())
		{
			map.put(menuAction.getId(), menuAction);
		}
	}

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
		return map.getOrDefault(id, UNKNOWN);
	}
}
