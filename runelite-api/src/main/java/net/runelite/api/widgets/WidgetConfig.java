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
package net.runelite.api.widgets;


/**
 * Utility class used for defining options to be used on the click mask
 * of a {@link Widget}.
 *
 * @see Widget#getClickMask()
 */
public class WidgetConfig
{
	/**
	 * Enables displaying a ninth option on a menu.
	 */
	public static final int SHOW_MENU_OPTION_NINE = 1 << 9;

	/**
	 * Can this widget be used on a item on the floor
	 */
	public static final int USE_GROUND_ITEM = 1 << 11;

	/**
	 * Can this widget be used on a NPC
	 */
	public static final int USE_NPC = 2 << 11;

	/**
	 * Can this widget be used on a game object
	 */
	public static final int USE_OBJECT = 4 << 11;

	/**
	 * Can this widget be used on a player
	 */
	public static final int USE_PLAYER = 8 << 11;

	/**
	 * Can this widget be used on a item in your inventory
	 */
	public static final int USE_ITEM = 16 << 11;

	/**
	 * Can this widget be used on a widget with the WIDGET_USE_TARGET flag
	 */
	public static final int USE_WIDGET = 32 << 11;

	/**
	 * Controls whether or not a widget can have another dragged onto it.
	 */
	public static final int DRAG_ON = 1 << 17;

	/**
	 * Controls whether or not a widget can be dragged around.
	 */
	public static final int DRAG = 1 << 20;

	/**
	 * Can widgets with USE_WIDGET be used on this widget
	 */
	public static final int WIDGET_USE_TARGET = 1 << 21;

	/**
	 * Is the widget an (inventory?) item
	 */
	public static final int ITEM = 1 << 30;

	/**
	 * Add a USE option
	 *
	 * @see// MenuOpcode#ITEM_USE
	 */
	public static final int ITEM_USE_OP = 1 << 31;
}
