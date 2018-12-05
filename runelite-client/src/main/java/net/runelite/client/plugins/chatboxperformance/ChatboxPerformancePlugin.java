/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
import net.runelite.api.WidgetType;
import net.runelite.api.events.WidgetPositioned;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
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
	@Inject
	private Client client;

	@Subscribe
	public void onWidgetPositioned(WidgetPositioned event)
	{
		if (!areWidgetsFixed())
		{
			fixChatbox();
		}
	}

	private boolean areWidgetsFixed()
	{
		Widget widget = client.getWidget(WidgetInfo.CHATBOX_TRANSPARENT_BACKGROUND);
		if (widget == null)
		{
			return true;
		}

		Widget[] widgets = widget.getChildren();

		if (widgets != null && widgets.length > 0)
		{
			Widget last = widgets[widgets.length - 1];
			return last != null && last.getOpacity() < 254;
		}

		return false;
	}

	private void fixChatbox()
	{
		fixDarkBackground();
		fixWhiteLines(true);
		fixWhiteLines(false);
	}

	private void fixDarkBackground()
	{
		int currOpacity = 256;
		int prevY = 0;
		Widget[] children = client.getWidget(WidgetInfo.CHATBOX_TRANSPARENT_BACKGROUND).getDynamicChildren();
		Widget prev = null;
		for (Widget w : children)
		{
			if (w.getType() != WidgetType.RECTANGLE)
			{
				continue;
			}

			if (prev != null)
			{
				int relY = w.getRelativeY();
				prev.setHeightMode(WidgetSizeMode.ABSOLUTE);
				prev.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
				prev.setRelativeY(prevY);
				prev.setOriginalY(prev.getRelativeY());
				prev.setHeight(relY - prevY);
				prev.setOriginalHeight(prev.getHeight());
				prev.setOpacity(currOpacity);
			}

			prevY = w.getRelativeY();
			currOpacity -= 3; // Rough number, can't get exactly the same as Jagex because of rounding
			prev = w;
		}
		if (prev != null)
		{
			prev.setOpacity(currOpacity);
		}
	}

	private void fixWhiteLines(boolean upperLine)
	{
		int currOpacity = 256;
		int prevWidth = 0;
		Widget[] children = client.getWidget(WidgetInfo.CHATBOX_TRANSPARENT_LINES).getDynamicChildren();
		Widget prev = null;
		for (Widget w : children)
		{
			if (w.getType() != WidgetType.RECTANGLE)
			{
				continue;
			}

			if ((w.getRelativeY() == 0 && !upperLine) ||
				(w.getRelativeY() != 0 && upperLine))
			{
				continue;
			}

			if (prev != null)
			{
				int width = w.getWidth();
				prev.setWidthMode(WidgetSizeMode.ABSOLUTE);
				prev.setRelativeX(width);
				prev.setOriginalX(width);
				prev.setWidth(prevWidth - width);
				prev.setOriginalWidth(prev.getWidth());
				prev.setOpacity(currOpacity);
			}

			prevWidth = w.getWidth();

			currOpacity -= upperLine ? 3 : 4; // Rough numbers, can't get exactly the same as Jagex because of rounding
			prev = w;
		}
		if (prev != null)
		{
			prev.setOpacity(currOpacity);
		}
	}
}
