/*
 * Copyright (c) 2018-2019, Woox <https://github.com/wooxsolo>
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
package net.runelite.client.plugins.chatboxperformance;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Chatbox performance",
	hidden = true
)
public class ChatboxPerformancePlugin extends Plugin
{
	private static final int CHATBOX_HEIGHT = 142;
	private static final int CHATBOX_LINES_WIDTH = 505;

	private int iteration;

	@Inject
	private Client client;

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		switch (eventName)
		{
			case "transparentChatboxBgIteration":
			{
				iteration = intStack[intStackSize - 2];
				break;
			}

			case "transparentChatboxBgSize":
			{
				// Can't just set height = 16384 / 25 because rounding makes
				// some segments 1 px higher than others.
				int startY = (16384 / 25 * iteration) * CHATBOX_HEIGHT / 16384;
				int endY = (16384 / 25 * (iteration + 1)) * CHATBOX_HEIGHT / 16384;
				if (iteration == 19)
				{
					endY = CHATBOX_HEIGHT;
				}
				intStack[intStackSize - 3] = endY - startY; // Sets height
				intStack[intStackSize - 1] = WidgetSizeMode.ABSOLUTE;
				break;
			}

			case "transparentChatboxBgPosition":
			{
				intStack[intStackSize - 3] = 16384 / 25 * iteration; // Sets Y-position
				intStack[intStackSize - 1] = WidgetPositionMode.TOP_16384THS;
				break;
			}

			case "transparentChatboxBgOpacity":
			{
				// Rough number, can't get exactly the same as Jagex because their solution rounds it multiple times
				intStack[intStackSize - 1] = 256 - (iteration + 1) * 3; // Sets opacity
				break;
			}

			case "transparentChatboxLinesUpperSize":
			case "transparentChatboxLinesLowerSize":
			{
				// Can't just set width = 16384 / 25 because rounding makes
				// some segments 1 px wider than others.
				int startX = (16384 / 25 * iteration) * CHATBOX_LINES_WIDTH / 16384;
				int endX = (16384 / 25 * (iteration + 1)) * CHATBOX_LINES_WIDTH / 16384;
				if (iteration == 19)
				{
					endX = CHATBOX_LINES_WIDTH;
				}
				intStack[intStackSize - 4] = endX - startX; // Sets width
				intStack[intStackSize - 2] = WidgetSizeMode.ABSOLUTE;
				break;
			}

			case "transparentChatboxLinesUpperPosition":
			case "transparentChatboxLinesLowerPosition":
			{
				intStack[intStackSize - 4] = 16384 / 25 * iteration; // Sets X-position
				intStack[intStackSize - 2] = WidgetPositionMode.RIGHT_16384THS;
				break;
			}

			case "transparentChatboxLinesUpperOpacity":
			{
				// Rough number, can't get exactly the same as Jagex because their solution rounds it multiple times
				intStack[intStackSize - 1] = 256 - (iteration + 1) * 3; // Sets opacity
				break;
			}

			case "transparentChatboxLinesLowerOpacity":
			{
				// Rough number, can't get exactly the same as Jagex because their solution rounds it multiple times
				intStack[intStackSize - 1] = 256 - (iteration + 1) * 4; // Sets opacity
				break;
			}
		}
	}
}
