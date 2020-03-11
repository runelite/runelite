/*
 * Copyright (c) 2018, Shingyx <https://github.com/Shingyx>
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

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.dnd.DragSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;

/**
 * Pane which allows reordering its components via drag and drop.
 * <p>
 * For child components' popup menus, implement the PopupMenuOwner interface in the child components.
 */
public class DragAndDropReorderPane extends JLayeredPane
{
	private Point dragStartPoint;
	private Component draggingComponent;
	private int dragIndex = -1;

	private final Map<Integer, PopupMenuOwner> popupMenuCandidates = new HashMap<>();  // keyed by mouse button

	public DragAndDropReorderPane()
	{
		super();
		setLayout(new DragAndDropReorderLayoutManager());
		MouseAdapter mouseAdapter = new DragAndDropReorderMouseAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}

	@Override
	public void setLayout(LayoutManager layoutManager)
	{
		if (layoutManager != null && !(layoutManager instanceof DragAndDropReorderLayoutManager))
		{
			throw new IllegalArgumentException("DragAndDropReorderPane only supports DragAndDropReorderLayoutManager");
		}
		super.setLayout(layoutManager);
	}

	private void startDragging(Point point)
	{
		draggingComponent = getDefaultLayerComponentAt(dragStartPoint);
		if (draggingComponent == null)
		{
			dragStartPoint = null;
			return;
		}
		dragIndex = getPosition(draggingComponent);
		setLayer(draggingComponent, DRAG_LAYER);
		moveDraggingComponent(point);
	}

	private void drag(Point point)
	{
		moveDraggingComponent(point);

		Component component = getDefaultLayerComponentAt(point);
		if (component != null)
		{
			int index = getPosition(component);
			dragIndex = index < dragIndex ? index : index + 1;
			revalidate();
		}
	}

	private void finishDragging()
	{
		if (draggingComponent != null)
		{
			setLayer(draggingComponent, DEFAULT_LAYER, dragIndex);
			revalidate();
		}
		dragStartPoint = null;
		draggingComponent = null;
		dragIndex = -1;
	}

	private void moveDraggingComponent(Point point)
	{
		// place the center of the dragging component onto the mouse cursor
		int y = point.y - draggingComponent.getHeight() / 2;
		// clamp the height to stay within the pane
		y = Math.max(y, 0);
		y = Math.min(y, getHeight() - draggingComponent.getHeight());

		draggingComponent.setLocation(new Point(0, y));
	}

	private Component getDefaultLayerComponentAt(Point point)
	{
		for (Component component : getComponentsInLayer(DEFAULT_LAYER))
		{
			if (component.contains(point.x - component.getX(), point.y - component.getY()))
			{
				return component;
			}
		}
		return null;
	}

	private class DragAndDropReorderLayoutManager extends BoxLayout
	{
		private DragAndDropReorderLayoutManager()
		{
			super(DragAndDropReorderPane.this, BoxLayout.Y_AXIS);
		}

		@Override
		public void layoutContainer(Container target)
		{
			if (draggingComponent != null)
			{
				// temporarily move the dragging component to the default layer for correct layout calculation
				Point location = draggingComponent.getLocation();
				setLayer(draggingComponent, DEFAULT_LAYER, dragIndex);
				super.layoutContainer(target);
				setLayer(draggingComponent, DRAG_LAYER);
				draggingComponent.setLocation(location);
			}
			else
			{
				super.layoutContainer(target);
			}
		}
	}

	private class DragAndDropReorderMouseAdapter extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			Point point = e.getPoint();
			int mouseButton = e.getButton();

			if (mouseButton == MouseEvent.BUTTON1)
			{
				// candidate for dragging
				if (popupMenuCandidates.isEmpty() && getComponentCount() > 1)
				{
					dragStartPoint = point;
				}
			}
			else
			{
				if (dragStartPoint != null)
				{
					finishDragging();
				}
				else
				{
					// candidate for child popup menu
					Component component = getDefaultLayerComponentAt(point);
					if (component instanceof PopupMenuOwner)
					{
						PopupMenuOwner popupMenuCandidate = (PopupMenuOwner) component;
						if (e.isPopupTrigger())
						{
							popupMenuCandidate.getPopupMenu().show(DragAndDropReorderPane.this, point.x, point.y);
						}
						else
						{
							popupMenuCandidates.put(mouseButton, popupMenuCandidate);
						}
					}
				}
			}
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if (dragStartPoint == null)
			{
				return;
			}
			Point point = e.getPoint();
			if (contains(point))
			{
				if (draggingComponent == null)
				{
					if (point.distance(dragStartPoint) > DragSource.getDragThreshold())
					{
						startDragging(point);
					}
				}
				else
				{
					drag(point);
				}
			}
			else
			{
				finishDragging();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			Point point = e.getPoint();
			int mouseButton = e.getButton();
			if (mouseButton == MouseEvent.BUTTON1)
			{
				finishDragging();
			}
			else
			{
				PopupMenuOwner popupMenuCandidate = popupMenuCandidates.remove(mouseButton);
				if (popupMenuCandidate != null && e.isPopupTrigger())
				{
					popupMenuCandidate.getPopupMenu().show(DragAndDropReorderPane.this, point.x, point.y);
				}
			}
		}
	}
}