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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.runelite.api.MenuEntry;

/**
 * An event when a new entry is added to a right-click menu.
 */
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class MenuEntryAdded
{
	@Getter
	private final MenuEntry menuEntry;

	/**
	 * The option text added to the menu. (ie. "Walk here", "Use")
	 */
	@EqualsAndHashCode.Include
	@ToString.Include
	public String getOption()
	{
		return menuEntry.getOption();
	}

	/**
	 * The target of the action. (ie. Item or Actor name)
	 * <p>
	 * If the option does not apply to any target, this field
	 * will be set to empty string.
	 */
	@EqualsAndHashCode.Include
	@ToString.Include
	public String getTarget()
	{
		return menuEntry.getTarget();
	}

	/**
	 * The action type that will be triggered.
	 */
	@EqualsAndHashCode.Include
	@ToString.Include
	public int getType()
	{
		return menuEntry.getType().getId();
	}

	/**
	 * An identifier value for the target of the action
	 */
	@EqualsAndHashCode.Include
	@ToString.Include
	public int getIdentifier()
	{
		return menuEntry.getIdentifier();
	}

	/**
	 * An additional parameter for the action.
	 */
	@EqualsAndHashCode.Include
	@ToString.Include
	public int getActionParam0()
	{
		return menuEntry.getParam0();
	}

	/**
	 * A second additional parameter for the action.
	 */
	@EqualsAndHashCode.Include
	@ToString.Include
	public int getActionParam1()
	{
		return menuEntry.getParam1();
	}

	@EqualsAndHashCode.Include
	@ToString.Include
	public int getItemId()
	{
		return menuEntry.getItemId();
	}
}
