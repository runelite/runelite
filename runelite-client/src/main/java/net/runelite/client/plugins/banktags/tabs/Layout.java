/*
 * Copyright (c) 2024, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.banktags.tabs;

import java.util.Arrays;
import lombok.Getter;
import lombok.NonNull;

public class Layout
{
	@Getter
	private final String tag;
	private int[] layout;

	public Layout(String tag)
	{
		this.tag = tag;
		this.layout = new int[0];
	}

	public Layout(String tag, @NonNull int[] layout)
	{
		this.tag = tag;
		this.layout = layout;
	}

	public Layout(Layout other)
	{
		tag = other.tag;
		layout = other.layout.clone();
	}

	public int[] getLayout()
	{
		return layout.clone();
	}

	public int getItemAtPos(int pos)
	{
		if (pos < 0 || pos >= layout.length)
		{
			return -1;
		}

		return layout[pos];
	}

	public void setItemAtPos(int itemId, int pos)
	{
		if (pos < 0)
		{
			return;
		}

		if (layout == null)
		{
			layout = new int[pos + 1];
			Arrays.fill(layout, -1);
		}
		else if (pos >= layout.length)
		{
			int[] n = Arrays.copyOf(layout, pos + 1);
			Arrays.fill(n, layout.length, n.length, -1);
			layout = n;
		}

		layout[pos] = itemId;
	}

	public void addItem(int itemId)
	{
		addItemAfter(itemId, 0);
	}

	public void addItemAfter(int itemId, int pos)
	{
		int i;
		for (i = pos; i < layout.length; ++i)
		{
			if (layout[i] == -1)
			{
				layout[i] = itemId;
				return;
			}
		}

		resize(Math.max(pos + 1, layout.length + 1));
		layout[i] = itemId;
	}

	public void removeItem(int itemId)
	{
		for (int i = 0; i < layout.length; ++i)
		{
			if (layout[i] == itemId)
			{
				layout[i] = -1;
			}
		}
	}

	public void removeItemAtPos(int pos)
	{
		if (pos < 0 || pos >= layout.length)
		{
			return;
		}

		layout[pos] = -1;
	}

	void swap(int sidx, int tidx)
	{
		int sid = layout[sidx];
		layout[sidx] = layout[tidx];
		layout[tidx] = sid;
	}

	void insert(int sidx, int tidx)
	{
		int sid = layout[sidx];
		if (sidx < tidx)
		{
			// Shift items down to the next blank spot
			int i = tidx;
			while (i > sidx && layout[i] > -1)
			{
				--i;
			}

			layout[sidx] = -1;
			System.arraycopy(layout, i + 1, layout, i, tidx - i);
			layout[tidx] = sid;
		}
		else if (sidx > tidx)
		{
			// Shift items up to the next blank spot
			int i = tidx;
			while (i < sidx && layout[i] > -1)
			{
				++i;
			}

			layout[sidx] = -1;
			System.arraycopy(layout, tidx, layout, tidx + 1, i - tidx);
			layout[tidx] = sid;
		}
	}

	public int count(int itemId)
	{
		int c = 0;
		for (int value : layout)
		{
			if (value == itemId)
			{
				++c;
			}
		}
		return c;
	}

	public int size()
	{
		return layout.length;
	}

	public void resize(int size)
	{
		int[] n = Arrays.copyOf(layout, size);
		if (size > layout.length)
		{
			Arrays.fill(n, layout.length, size, -1);
		}
		layout = n;
	}
}
