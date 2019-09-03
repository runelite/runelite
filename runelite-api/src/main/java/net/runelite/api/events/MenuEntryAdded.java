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
package net.runelite.api.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.runelite.api.MenuEntry;

/**
 * An event when a new entry is added to a right-click menu.
 */
@Data
@RequiredArgsConstructor
public class MenuEntryAdded implements Event
{
	/**
	 * The MenuEntry object that was actually added
	 */
	private final MenuEntry menuEntry;

	/**
	 * If this is set to true client mixin will update
	 * the menu entry with the modified values.
	 *
	 * Checks if count is the same, but doesn't check if there's
	 * been multiple changes
	 */
	private boolean wasModified;

	public String getOption()
	{
		return menuEntry.getOption();
	}

	public String getTarget()
	{
		return menuEntry.getTarget();
	}

	public int getType()
	{
		return menuEntry.getOpcode();
	}

	public int getIdentifier()
	{
		return menuEntry.getIdentifier();
	}

	public int getActionParam0()
	{
		return menuEntry.getParam0();
	}

	public int getActionParam1()
	{
		return menuEntry.getParam1();
	}

	public boolean isForceLeftClick()
	{
		return menuEntry.isForceLeftClick();
	}
}
