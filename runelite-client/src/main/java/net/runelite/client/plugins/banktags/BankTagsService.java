/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.banktags;

import javax.annotation.Nullable;
import net.runelite.client.plugins.banktags.tabs.Layout;

/**
 * API for the bank tags plugin
 *
 * @see TagManager
 * @see net.runelite.client.plugins.banktags.tabs.TabManager
 * @see net.runelite.client.plugins.banktags.tabs.LayoutManager
 */
public interface BankTagsService
{
	/**
	 * Bank tag is allowed to be modified
	 */
	int OPTION_ALLOW_MODIFICATIONS = 0x1;
	/**
	 * Option to hide the tag name.
	 */
	int OPTION_HIDE_TAG_NAME = 0x2;
	/**
	 * Option to prevent {@link #openBankTag(String, int)} from performing a layout
	 */
	int OPTION_NO_LAYOUT = 0x4;

	/**
	 * Open the given bank tag. The tag may have an associated {@link net.runelite.client.plugins.banktags.tabs.TagTab},
	 * but this isn't required. If the tag has an associated {@link net.runelite.client.plugins.banktags.tabs.Layout},
	 * the layout will be applied.
	 *
	 * @param tag the tag name
	 * @param options
	 * @see #OPTION_ALLOW_MODIFICATIONS
	 * @see #OPTION_HIDE_TAG_NAME
	 */
	void openBankTag(String tag, int options);

	/**
	 * Close the currently open {@link BankTag}.
	 */
	void closeBankTag();

	/**
	 * Get the currently active bank tag
	 * @return
	 */
	@Nullable
	String getActiveTag();

	/**
	 * Get the currently open {@link BankTag}
	 * @return
	 */
	@Nullable
	BankTag getActiveBankTag();

	/**
	 * Get the currently active {@link Layout}
	 * @return
	 */
	@Nullable
	Layout getActiveLayout();
}
