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
package net.runelite.client.ui.components;

import lombok.Getter;

import javax.swing.JList;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RuneliteList extends JList
{
	private final static int ITEM_HEIGHT = 18;

	@Getter
	private int hoveredIndex;

	public RuneliteList()
	{
		this.hoveredIndex = -1;
		this.setCellRenderer(new RuneliteListItemRenderer());
		this.setFixedCellHeight(ITEM_HEIGHT);
		this.setDragEnabled(false);
		this.addMouseMotionListener(new MouseAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent e)
			{
				hoveredIndex = locationToIndex(e.getPoint());
				if (hoveredIndex != -1)
				{
					super.mouseMoved(e);
				}
				repaint();
			}
		});
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseExited(MouseEvent e)
			{
				super.mouseExited(e);
				hoveredIndex = -1;
				repaint();
			}
		});
	}

	@Override
	protected void processMouseMotionEvent(MouseEvent e)
	{
		// Idk why, but when dragging in the list, an item selection is added/removed
		// for every time the drag event fires. So we prevent that by not forwarding
		// mouse drag events.
		if (MouseEvent.MOUSE_DRAGGED != e.getID())
		{
			super.processMouseMotionEvent(e);
		}
	}

	@Override
	public int locationToIndex(Point p)
	{
		int index = (int)p.getY() / ITEM_HEIGHT;
		if (index < 0 || index >= this.getModel().getSize())
		{
			return -1;
		}
		return index;
	}
}
