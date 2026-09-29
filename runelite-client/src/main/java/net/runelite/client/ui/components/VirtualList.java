/*
 * Copyright (c) 2026 Abex
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
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.event.ChangeListener;
import lombok.Getter;
import lombok.Setter;

public abstract class VirtualList<V extends Component, M> extends JPanel
{
	private class ViewItem
	{
		M item;
		int index;

		V view;

		int getIndex()
		{
			if (index >= 0 && index < model.size() && model.get(index) == item)
			{
				return index;
			}

			for (int i = 0; i < model.size(); i++)
			{
				if (model.get(i) == item)
				{
					return index = i;
				}
			}

			return -1;
		}
	}

	@Getter
	private List<M> model = new ArrayList<>();

	private final Deque<ViewItem> recycledVI = new ArrayDeque<>();
	private final Map<M, ViewItem> visible = new IdentityHashMap<>();

	@Setter
	private int keepUnused = 1;

	private JViewport viewport;
	private final ChangeListener changeListener = ev -> this.updateViewport();

	public VirtualList()
	{
		setLayout(null);
	}

	/**
	 * Finds the nearest index to a given y position
	 */
	protected abstract int getIndexNearPosition(int y);

	/**
	 * Gets the bounds for an item at {@code index}. Must be fast enough to call per item per paint.
	 */
	protected abstract Rectangle getItemPosition(int index);

	protected abstract V createView(@Nullable V recycle, M model);

	public void setModel(List<M> model)
	{
		if (model == null)
		{
			visible.clear();
			removeAll();

			model = new ArrayList<>();
		}
		this.model = model;
		revalidate();
		updateViewport();
	}

	@Override
	public Dimension getPreferredSize()
	{
		if (isPreferredSizeSet())
		{
			return super.getPreferredSize();
		}

		for (int i = model.size() - 1; i >= 0; i--)
		{
			var bounds = getItemPosition(i);
			if (bounds != null)
			{
				return new Dimension(Short.MAX_VALUE, bounds.y + bounds.height);
			}
		}

		return new Dimension();
	}

	@Override
	public Dimension getMaximumSize()
	{
		if (isMaximumSizeSet())
		{
			return super.getMaximumSize();
		}

		return new Dimension(Short.MAX_VALUE, 0x1_000_000);
	}

	@Override
	public void addNotify()
	{
		super.addNotify();

		for (Component c = getParent(); c != null; c = c.getParent())
		{
			if (c instanceof JViewport)
			{
				viewport = (JViewport) c;
				viewport.addChangeListener(changeListener);
				updateViewport();

				return;
			}
		}

		viewport = null;
	}

	@Override
	public void removeNotify()
	{
		super.removeNotify();

		if (viewport != null)
		{
			viewport.removeChangeListener(changeListener);

			viewport = null;
		}
	}

	@Override
	public void doLayout()
	{
		updateViewport();
	}

	private void updateViewport()
	{
		int visIndex = -1;
		var visRect = getVisibleRect();
		for (var it = visible.values().iterator(); it.hasNext(); )
		{
			var visItem = it.next();
			int idx = visItem.getIndex();
			if (visItem.view != null && idx != -1)
			{
				var pos = getItemPosition(idx);
				if (pos != null && visRect.intersects(pos))
				{
					visIndex = idx;
					visItem.view.setBounds(pos);
					continue;
				}
			}

			it.remove();
			visItem.item = null;
			if (visItem.view != null)
			{
				recycledVI.offerLast(visItem);
			}
		}

		if (visIndex == -1)
		{
			visIndex = getIndexNearPosition(visRect.y);
		}

		visIndex = Math.max(0, Math.min(model.size() - 1, visIndex));

		for (int i = visIndex; i >= 0 && i < model.size() && addItem(visRect, i); )
		{
			i--;
		}
		for (int i = visIndex + 1; i < model.size() && addItem(visRect, i); )
		{
			i++;
		}

		for (ViewItem vi : recycledVI)
		{
			if (vi.view.getParent() == this)
			{
				remove(vi.view);
			}
		}
		while (recycledVI.size() > keepUnused)
		{
			recycledVI.removeLast();
		}

		repaint();
	}

	private boolean addItem(Rectangle visRect, int idx)
	{
		var bounds = getItemPosition(idx);
		if (bounds == null)
		{
			return true;
		}

		if (!visRect.intersects(bounds))
		{
			return false;
		}

		var item = model.get(idx);
		if (visible.containsKey(item))
		{
			return true;
		}

		var vi = recycledVI.pollLast();
		if (vi == null)
		{
			vi = new ViewItem();
		}

		vi.item = item;
		vi.index = idx;

		var oldView = vi.view;
		vi.view = createView(vi.view, item);
		vi.view.setBounds(bounds);

		visible.put(item, vi);
		if (vi.view != oldView && oldView != null)
		{
			remove(oldView);
		}
		if (vi.view.getParent() != this)
		{
			add(vi.view);
		}
		vi.view.validate();

		return true;
	}
}
