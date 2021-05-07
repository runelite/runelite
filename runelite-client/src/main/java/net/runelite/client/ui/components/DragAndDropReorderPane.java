/*
 * Copyright (c) 2020, Shingyx <https://github.com/Shingyx>
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
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

/**
 * Pane which allows reordering its components via drag and drop.
 */
public class DragAndDropReorderPane extends JLayeredPane
{
	private Point dragStartPoint;
	private Component draggingComponent;
	private int dragYOffset = 0;
	private int dragIndex = -1;

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
		dragYOffset = SwingUtilities.convertPoint(this, dragStartPoint, draggingComponent).y;
		dragIndex = getPosition(draggingComponent);
		setLayer(draggingComponent, DRAG_LAYER);
		moveDraggingComponent(point);
	}

	private void drag(Point point)
	{
		moveDraggingComponent(point);

		final Point draggingComponentTopPoint = SwingUtilities.convertPoint(
			draggingComponent,
			new Point(draggingComponent.getWidth() / 2, 0),
			this
		);
		final Component topComponent = getDefaultLayerComponentAt(draggingComponentTopPoint);
		final Component bottomComponent = getDefaultLayerComponentAt(new Point(draggingComponentTopPoint.x, draggingComponentTopPoint.y + draggingComponent.getHeight()));
		final int initialDragIndex = dragIndex;

		if (topComponent == null && bottomComponent == null)
		{
			// Dragging component either has no siblings or has not been dragged vertically to overlap other components
			return;
		}

		// Drag reordering is handled in three cases: the dragged component being fully on top of some component larger
		// than it, or the dragged component having one edge (top or bottom) partially over another component.
		if (topComponent == bottomComponent)
		{
			// Dragging component is dragged fully over some larger neighboring component
			final int topComponentBottom = topComponent.getY() + topComponent.getHeight();
			final int draggingComponentBottom = draggingComponent.getY() + draggingComponent.getHeight();
			final int index = getPosition(topComponent);

			dragIndex = draggingComponent.getY() - topComponent.getY() < topComponentBottom - draggingComponentBottom
				// Dragging component is closer to the top than the bottom of larger component
				? index
				: index + 1;
		}
		else if (topComponent != null)
		{
			// Dragging component is dragged partially over one of its previous neighbors
			final int index = getPosition(topComponent);

			dragIndex = draggingComponent.getY() < topComponent.getY() + topComponent.getHeight() / 2
				? index
				: index + 1;
		}
		else
		{
			// Dragging component is dragged partially over one of its following neighbors
			final int draggingComponentBottom = draggingComponent.getY() + draggingComponent.getHeight();
			final int index = getPosition(bottomComponent);

			dragIndex = draggingComponentBottom > bottomComponent.getY() + bottomComponent.getHeight() / 2
				? index + 1
				: index;
		}

		if (dragIndex != initialDragIndex)
		{
			revalidate();
		}
	}

	private void finishDragging()
	{
		if (draggingComponent != null)
		{
			setLayer(draggingComponent, DEFAULT_LAYER, dragIndex);
			draggingComponent = null;
			dragYOffset = 0;
			dragIndex = -1;
			revalidate();
		}
		dragStartPoint = null;
	}

	private void moveDraggingComponent(Point point)
	{
		// shift the dragging component to match it's earlier y offset with the mouse
		int y = point.y - dragYOffset;
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
				// Without revalidating before this temporary layout, Swing will cause draggingComponent to take on the
				// size of whatever component is present at dragIndex. This can result in it being cut off or being
				// rendered with excessive "white space" covering components below it when this component contains
				// draggable items of mixed sizes.
				revalidate();
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
			if (SwingUtilities.isLeftMouseButton(e) && getComponentCount() > 1)
			{
				dragStartPoint = e.getPoint();
			}
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if (SwingUtilities.isLeftMouseButton(e) && dragStartPoint != null)
			{
				Point point = e.getPoint();
				if (draggingComponent != null)
				{
					drag(point);
				}
				else if (point.distance(dragStartPoint) > DragSource.getDragThreshold())
				{
					startDragging(point);
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			if (SwingUtilities.isLeftMouseButton(e))
			{
				finishDragging();
			}
		}
	}
}
