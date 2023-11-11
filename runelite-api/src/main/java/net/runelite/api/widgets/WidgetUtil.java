/*
 * Copyright (c) 2023, Adam <Adam@sigterm.info>
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
package net.runelite.api.widgets;

import net.runelite.api.annotations.Component;
import net.runelite.api.annotations.Interface;

public class WidgetUtil
{
	/**
	 * Utility method that converts a component id to the interface it
	 * belongs to.
	 *
	 * @param c component id
	 * @return the interface id
	 */
	@Interface
	public static int componentToInterface(@Component int c)
	{
		return c >>> 16;
	}

	/**
	 * Utility method that converts a component id to the id it is within
	 * its interface.
	 *
	 * @param c component id
	 */
	public static int componentToId(@Component int c)
	{
		return c & 0xFFFF;
	}

	/**
	 * Utility method that packs a component id from an interface id and child id.
	 * @param interfaceId interface id
	 * @param childId id within the interface
	 * @return the component id
	 */
	@Component
	public static int packComponentId(@Interface int interfaceId, int childId)
	{
		return (interfaceId << 16) | childId;
	}
}
