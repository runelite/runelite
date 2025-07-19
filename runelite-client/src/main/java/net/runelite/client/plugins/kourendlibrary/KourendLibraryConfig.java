/*
 * Copyright (c) 2018 Abex
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

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("kourendLibrary")
public interface KourendLibraryConfig extends Config
{
	String GROUP_KEY = "kourendLibrary";

	@ConfigItem(
		keyName = "hideButton",
		name = "Hide when outside of the library",
		description = "Don't show the button in the sidebar when you're not in the library."
	)
	default boolean hideButton()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideDuplicateBook",
		name = "Hide duplicate book",
		description = "Don't show the duplicate book locations in the library."
	)
	default boolean hideDuplicateBook()
	{
		return true;
	}

	@ConfigItem(
		keyName = "alwaysShowVarlamoreEnvoy",
		name = "Show Varlamore envoy",
		description = "Varlamore envoy is only needed during the depths of despair, and is never asked for."
	)
	default boolean alwaysShowVarlamoreEnvoy()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showTutorialOverlay",
		name = "Show tutorial overlay",
		description = "Whether to show an overlay to help understand how to use the plugin."
	)
	default boolean showTutorialOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showTargetHintArrow",
		name = "Show target book arrow",
		description = "Show a hint arrow pointing to the target bookcase."
	)
	default boolean showTargetHintArrow()
	{
		return true;
	}
}
