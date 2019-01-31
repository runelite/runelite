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

import lombok.Data;

/**
 * A menu entry in a right-click menu.
 */
@Data
public class MenuEntry
{
	/**
	 * The option text added to the menu (ie. "Walk here", "Use").
	 */
	private String option;
	/**
	 * The target of the action (ie. Item or Actor name).
	 * <p>
	 * If the option does not apply to any target, this field
	 * will be set to empty string.
	 */
	private String target;
	/**
	 * An identifier value for the target of the action.
	 */
	private int identifier;
	/**
	 * The action the entry will trigger.
	 */
	private int type;
	/**
	 * An additional parameter for the action.
	 */
	private int param0;
	/**
	 * A second additional parameter for the action.
	 */
	private int param1;
	/**
	 * If this field is true and you have single mouse button on and this entry is
	 * the top entry the right click menu will not be opened when you left click
	 *
	 * This is used  for shift click
	 */
	private boolean forceLeftClick;
}
