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

import net.runelite.api.widgets.Widget;

public interface ScriptEvent
{
	int MOUSE_X = -2147483647;
	int MOUSE_Y = -2147483646;
	int MENU_OP = -2147483644;
	int WIDGET_ID = -2147483645;
	int WIDGET_INDEX = -2147483643;
	int WIDGET_TARGET_ID = -2147483642;
	int WIDGET_TARGET_INDEX = -2147483641;
	int KEY_CODE = -2147483640;
	int KEY_CHAR = -2147483639;
	String NAME = "event_opbase";

	/**
	 * Gets the widget of the event.
	 *
	 * @return the widget
	 * @see Widget
	 */
	Widget getSource();

	/**
	 * Gets the menu index of the event
	 *
	 * @return the index
	 */
	int getOp();

	/**
	 * Gets the target of the menu option
	 *
	 * @return the target
	 * @see net.runelite.api.events.MenuOptionClicked
	 */
	String getOpbase();
}
