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

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SidebarGroupOutlineTest
{
	@Test
	public void expandedFolderOutlinesItsPlugins()
	{
		PluginGroup group = folder("stuff", true);
		List<SidebarSlot> slots = List.of(
			SidebarSlot.plugin(NavigationButton.builder().tooltip("A").build(), null),
			SidebarSlot.folder(group),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("B").build(), group),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("C").build(), group),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("D").build(), null));

		List<Rectangle> outlines = SidebarGroupOutline.bounds(slots, slots.size(), this::verticalTabs);

		assertEquals(List.of(new Rectangle(102, 28, 22, 74)), outlines);
	}

	@Test
	public void collapsedAndEmptyFoldersAreNotOutlined()
	{
		PluginGroup collapsed = folder("collapsed", false);
		PluginGroup empty = folder("empty", true);
		List<SidebarSlot> slots = List.of(
			SidebarSlot.folder(collapsed),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("A").build(), collapsed),
			SidebarSlot.folder(empty));

		assertTrue(SidebarGroupOutline.bounds(slots, slots.size(), this::verticalTabs).isEmpty());
	}

	@Test
	public void wrappedColumnsAreOutlinedSeparately()
	{
		PluginGroup group = folder("stuff", true);
		List<SidebarSlot> slots = List.of(
			SidebarSlot.folder(group),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("B").build(), group),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("C").build(), group));

		Rectangle[] tabs = {
			new Rectangle(100, 0, 26, 26),
			new Rectangle(100, 26, 26, 26),
			new Rectangle(70, 0, 26, 26)
		};

		List<Rectangle> outlines = SidebarGroupOutline.bounds(slots, slots.size(), index -> new Rectangle(tabs[index]));

		assertEquals(List.of(new Rectangle(102, 2, 22, 48), new Rectangle(72, 2, 22, 22)), outlines);
	}

	@Test
	public void missingTabBoundsSplitTheOutline()
	{
		PluginGroup group = folder("stuff", true);
		List<SidebarSlot> slots = List.of(
			SidebarSlot.folder(group),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("B").build(), group),
			SidebarSlot.plugin(NavigationButton.builder().tooltip("C").build(), group));

		List<Rectangle> outlines = SidebarGroupOutline.bounds(slots, slots.size(), index ->
		{
			if (index == 1)
			{
				return null;
			}
			return verticalTabs(index);
		});

		assertEquals(List.of(new Rectangle(102, 2, 22, 22), new Rectangle(102, 54, 22, 22)), outlines);
	}

	@Test
	public void paintAcceptsAnEmptyStrip()
	{
		BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		try
		{
			SidebarGroupOutline.paint(g, List.of(), 0, index -> null);
		}
		finally
		{
			g.dispose();
		}
	}

	private Rectangle verticalTabs(int index)
	{
		return new Rectangle(100, index * 26, 26, 26);
	}

	private static PluginGroup folder(String id, boolean expanded)
	{
		PluginGroup group = new PluginGroup();
		group.setId(id);
		group.setName(id);
		group.setExpanded(expanded);
		return group;
	}
}
