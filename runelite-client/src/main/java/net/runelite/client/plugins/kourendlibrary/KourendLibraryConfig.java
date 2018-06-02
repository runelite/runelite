/*
 * Copyright (c) 2018, Franck Maillot <https://github.com/Franck-M>
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
package net.runelite.client.plugins.kourendlibrary;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "kourendlibrary",
	name = "Kourend Library",
	description = "Configuration for the Kourend library plugin"
)
public interface KourendLibraryConfig extends Config
{
	@ConfigItem(
		keyName = "unknownBook",
		name = "Unknown book",
		description = "Configures the color of bookcases for which we do not know the books",
		position = 0
	)
	default Color unknownBook()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "requestedBook",
		name = "Requested book",
		description = "Configures the color of the bookcase containing the requested book",
		position = 1
	)
	default Color requestedBook()
	{
		return Color.GREEN;
	}

	@ConfigItem(
		keyName = "darkManuscriptColor",
		name = "Dark manuscripts",
		description = "Configures the color used for dark manuscript bookcases and their name",
		position = 2
	)
	default Color darkManuscriptColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		keyName = "availableActionColor",
		name = "Available action",
		description = "Configures the color used for bookcases containing a book not in the player's inventory and for "
			+ "the customer if the book is in the player's inventory",
		position = 3
	)
	default Color availableActionColor()
	{
		return Color.CYAN;
	}

	@ConfigItem(
		keyName = "noAvailableActionColor",
		name = "No available action",
		description = "Configures the color used for bookcases containing a book in the player's inventory and for "
			+ "the customer if the book is not in the player's inventory",
		position = 4
	)
	default Color noAvailableActionColor()
	{
		return Color.ORANGE;
	}

	@ConfigItem(
		keyName = "showAvailableBooksOnly",
		name = "Display available only",
		description = "Configures whether or not to displays something if the bookcase is currently empty (i.e. "
			+ "do not put a display on bookcases if you have the book in your inventory or if we already checked it "
			+ "for dark manuscript)",
		position = 5
	)
	default boolean showAvailableBooksOnly()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideDarkManuscripts",
		name = "Hide dark manuscripts",
		description = "Configures whether or not to hide dark manuscripts once the library is completed",
		position = 6
	)
	default boolean hideDarkManuscripts()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBookName",
		name = "Display book name",
		description = "Configures whether or not to display the book name",
		position = 7
	)
	default boolean showBookName()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showBookIcon",
		name = "Display book icons",
		description = "Configures whether or not to display the book icons",
		position = 8
	)
	default boolean showBookIcon()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMinimapDot",
		name = "Display dot on minimap",
		description = "Configures whether or not to display a dot for bookcases with book on the minimap",
		position = 9
	)
	default boolean showMinimapDot()
	{
		return true;
	}
}