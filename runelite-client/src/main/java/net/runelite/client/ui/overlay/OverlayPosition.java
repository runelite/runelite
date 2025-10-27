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
package net.runelite.client.ui.overlay;

import java.util.Arrays;
import java.util.List;

public enum OverlayPosition
{
	/**
	 * Not attached anywhere, but still movable
	 * Deprecated. Use DYNAMIC and setMovable(true)
	 */
	@Deprecated
	DETACHED,
	/**
	 * Overlay places itself where it wants
	 */
	DYNAMIC,
	/**
	 * Place overlay in the top left viewport area
	 */
	TOP_LEFT,
	/**
	 * Place overlay in the top center viewport area
	 */
	TOP_CENTER,
	/**
	 * Place overlay in the top right viewport area
	 */
	TOP_RIGHT,
	/**
	 * Place overlay in the bottom left viewport area
	 */
	BOTTOM_LEFT(Arrays.asList("RESIZABLE_VIEWPORT_CHATBOX_PARENT", "RESIZABLE_VIEWPORT_BOTTOM_LINE_CHATBOX_PARENT")),
	/**
	 * Place overlay in the bottom right viewport area
	 */
	BOTTOM_RIGHT,
	/**
	 * Place overlay directly above right side of chatbox
	 */
	ABOVE_CHATBOX_RIGHT(Arrays.asList("RESIZABLE_VIEWPORT_CHATBOX_PARENT", "RESIZABLE_VIEWPORT_BOTTOM_LINE_CHATBOX_PARENT")),
	/**
	 * Place overlay in the top right most area possible
	 */
	CANVAS_TOP_RIGHT,
	/**
	 * Tooltip overlay
	 */
	TOOLTIP;

	/**
	 * A list of overlays that must not be snapped to the OverlayPosition, used when an OverlayPosition is tied to the
	 * location of an Overlay (chatbox, for example)
	 */
	private final List<String> componentNameBlacklist;

	OverlayPosition()
	{
		this.componentNameBlacklist = null;
	}

	OverlayPosition(List<String> componentNameBlacklist)
	{
		this.componentNameBlacklist = componentNameBlacklist;
	}

	boolean isOverlayBlacklisted(String overlayName)
	{
		return componentNameBlacklist != null && componentNameBlacklist.contains(overlayName);
	}
}
