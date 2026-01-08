/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
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

/**
 * The client minimenu.
 */
public interface Menu
{
	/**
	 * Create a new menu entry
	 * @param idx the index to create the menu entry at. Accepts negative indexes eg. -1 inserts at the end.
	 * @return the newly created menu entry
	 */
	MenuEntry createMenuEntry(int idx);

	/**
	 * Gets the current mini menu entries.
	 *
	 * @return array of menu entries
	 */
	MenuEntry[] getMenuEntries();

	/**
	 * Sets the array of menu entries.
	 * <p>
	 * This method should typically be used in the context of the {@link net.runelite.api.events.MenuOpened}
	 * event, since setting the menu entries will be overwritten the next frame
	 *
	 * @param entries new array of open menu entries
	 */
	void setMenuEntries(MenuEntry[] entries);

	/**
	 * Remove a menu entry
	 * @param entry the menu entry
	 */
	void removeMenuEntry(MenuEntry entry);

	/**
	 * Get the menu x location. Only valid if the menu is open.
	 *
	 * @return the menu x location
	 */
	int getMenuX();

	/**
	 * Get the menu y location. Only valid if the menu is open.
	 *
	 * @return the menu y location
	 */
	int getMenuY();

	/**
	 * Get the menu width. Only valid if the menu is open.
	 *
	 * @return the menu width
	 */
	int getMenuWidth();

	/**
	 * Get the menu height. Only valid if the menu is open.
	 *
	 * @return the menu height
	 */
	int getMenuHeight();
}
