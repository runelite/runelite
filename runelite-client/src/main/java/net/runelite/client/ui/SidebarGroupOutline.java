/*
 * Copyright (c) 2026
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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;


final class SidebarGroupOutline
{
	private static final int INSET = 2;
	private static final int ARC = 8;

	private SidebarGroupOutline()
	{
	}

	static void paint(Graphics graphics, List<SidebarSlot> slots, int tabCount, IntFunction<Rectangle> tabBounds)
	{
		if (graphics == null)
		{
			return;
		}

		Graphics2D g = (Graphics2D) graphics.create();
		try
		{
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(ColorScheme.LIGHT_GRAY_COLOR);
			for (Rectangle rect : bounds(slots, tabCount, tabBounds))
			{
				g.drawRoundRect(rect.x, rect.y, rect.width - 1, rect.height - 1, ARC, ARC);
			}
		}
		finally
		{
			g.dispose();
		}
	}


	static List<Rectangle> bounds(List<SidebarSlot> slots, int tabCount, IntFunction<Rectangle> tabBounds)
	{
		List<Rectangle> outlines = new ArrayList<>();
		if (slots == null || tabBounds == null)
		{
			return outlines;
		}

		for (int i = 0; i < slots.size(); i++)
		{
			SidebarSlot slot = slots.get(i);
			if (!expandedFolder(slot))
			{
				continue;
			}

			PluginGroup group = slot.getFolder();
			int end = i;
			while (end + 1 < slots.size() && childOf(slots.get(end + 1), group))
			{
				end++;
			}
			if (end == i)
			{
				continue;
			}
			addRuns(outlines, i, end, tabCount, tabBounds);
		}
		return outlines;
	}

	private static void addRuns(List<Rectangle> outlines, int start, int end, int tabCount, IntFunction<Rectangle> tabBounds)
	{
		Rectangle run = null;
		for (int i = start; i <= end; i++)
		{
			Rectangle placed = placedTab(i, tabCount, tabBounds);
			if (placed == null)
			{
				addInset(outlines, run);
				run = null;
				continue;
			}
			if (run == null)
			{
				run = placed;
				continue;
			}
			if (!sameColumn(run, placed))
			{
				addInset(outlines, run);
				run = placed;
				continue;
			}
			run.add(placed);
		}
		addInset(outlines, run);
	}

	private static Rectangle placedTab(int index, int tabCount, IntFunction<Rectangle> tabBounds)
	{
		if (index < 0 || index >= tabCount)
		{
			return null;
		}

		Rectangle bounds = tabBounds.apply(index);
		if (bounds == null || bounds.width <= 0 || bounds.height <= 0)
		{
			return null;
		}
		return new Rectangle(bounds);
	}

	private static boolean sameColumn(Rectangle a, Rectangle b)
	{
		int overlap = Math.min(a.x + a.width, b.x + b.width) - Math.max(a.x, b.x);
		return overlap > Math.min(a.width, b.width) / 2;
	}

	private static void addInset(List<Rectangle> outlines, Rectangle run)
	{
		if (run == null)
		{
			return;
		}

		Rectangle rect = new Rectangle(run);
		rect.grow(-INSET, -INSET);
		if (rect.width >= 2 && rect.height >= 2)
		{
			outlines.add(rect);
		}
	}

	private static boolean expandedFolder(SidebarSlot slot)
	{
		return slot != null && slot.isFolder() && slot.getFolder() != null && slot.getFolder().isExpanded();
	}

	private static boolean childOf(SidebarSlot slot, PluginGroup group)
	{
		return slot != null
			&& slot.isChild()
			&& slot.getFolder() != null
			&& group.getId() != null
			&& group.getId().equals(slot.getFolder().getId());
	}
}
