/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package net.runelite.client.ui;

import java.awt.Color;

/**
 * This class serves to hold colors used in Oldschool RuneScape that are also used in client code.
 */
public class JagexColors
{
	/*
	 * Colors of chat text when displayed on an opaque background.
	 */
	public static final Color CHAT_PUBLIC_TEXT_OPAQUE_BACKGROUND = Color.BLUE;
	public static final Color CHAT_PRIVATE_MESSAGE_TEXT_OPAQUE_BACKGROUND = Color.CYAN;
	public static final Color CHAT_CLAN_TEXT_OPAQUE_BACKGROUND = new Color(127, 0, 0);
	public static final Color CHAT_CLAN_NAME_OPAQUE_BACKGROUND = Color.BLUE;
	public static final Color CHAT_GAME_EXAMINE_TEXT_OPAQUE_BACKGROUND = Color.BLACK;
	public static final Color CHAT_TYPED_TEXT_OPAQUE_BACKGROUND = Color.BLUE;

	/*
	 * Colors of chat text when displayed on a transparent background.
	 */
	public static final Color CHAT_PUBLIC_TEXT_TRANSPARENT_BACKGROUND = new Color(144, 144, 255);
	public static final Color CHAT_PRIVATE_MESSAGE_TEXT_TRANSPARENT_BACKGROUND = Color.CYAN;
	public static final Color CHAT_CLAN_TEXT_TRANSPARENT_BACKGROUND = new Color(239, 80, 80);
	public static final Color CHAT_CLAN_NAME_TRANSPARENT_BACKGROUND = new Color(144, 112, 255);
	public static final Color CHAT_GAME_EXAMINE_TEXT_TRANSPARENT_BACKGROUND = Color.WHITE;
	public static final Color CHAT_TYPED_TEXT_TRANSPARENT_BACKGROUND = new Color(144, 144, 255);

	/*
	 * Colors relating to right-click menus.
	 */
	public static final Color MENU_TARGET = new Color(255, 144, 64);

	/*
	 * Colors relating to tooltips.
	 */
	public static final Color TOOLTIP_BACKGROUND = new Color(255, 255, 160);
	public static final Color TOOLTIP_BORDER = Color.BLACK;
	public static final Color TOOLTIP_TEXT = Color.BLACK;

	/*
	 * Colors used in interfaces
	 */
	public static final Color DARK_ORANGE_INTERFACE_TEXT = new Color(255, 152, 31);
	public static final Color YELLOW_INTERFACE_TEXT = Color.YELLOW;
}
