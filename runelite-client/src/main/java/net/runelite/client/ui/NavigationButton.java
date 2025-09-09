/*
 * Copyright (c) 2017-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.con>
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

import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.Map;
import lombok.Builder;
import lombok.Value;

/**
 * UI navigation button.
 */
@Value
@Builder
public class NavigationButton
{
	static final Comparator<NavigationButton> COMPARATOR = Comparator.comparing(NavigationButton::getPriority)
		.thenComparing(NavigationButton::getTooltip);

	/**
	 * Icon of button.
	 */
	private final BufferedImage icon;

	/**
	 * Tooltip to show when hovered.
	 */
	@Builder.Default
	private final String tooltip = "";

	/**
	 * On click action of the button.
	 */
	private final Runnable onClick;

	/**
	 * Plugin panel, used when expanding and contracting sidebar.
	 */
	private final PluginPanel panel;

	/**
	 * The order in which the button should be displayed in the side bar. (from lower to higher)
	 */
	private final int priority;

	/**
	 * Map of key-value pairs for setting the popup menu
	 */
	private final Map<String, Runnable> popup;
}
