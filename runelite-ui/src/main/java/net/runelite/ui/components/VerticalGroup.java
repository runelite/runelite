/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.ui.components;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import net.runelite.ui.Actor;
import net.runelite.ui.util.Align;
import net.runelite.ui.util.Layout;

public class VerticalGroup extends ComponentGroup {
	private int prefWidth, prefHeight, lastPrefWidth;
	private boolean sizeInvalid = true;
	private List<Integer> columnSizes; // column height, column width, ...

	@Getter
	@Setter
	private int align = Align.top;

	@Getter
	@Setter
	private int columnAlign;

	@Getter
	@Setter
	private boolean reverse;

	@Getter
	@Setter
	private boolean wrap;

	@Getter
	@Setter
	private boolean expand;

	@Getter
	@Setter
	private int space;

	@Getter
	@Setter
	private int wrapSpace;

	@Getter
	@Setter
	private int fill;

	@Getter
	@Setter
	private int padTop;

	@Getter
	@Setter
	private int padLeft;

	@Getter
	@Setter
	private int padBottom;

	@Getter
	@Setter
	private int padRight;

	@Override
	public void invalidate () {
		super.invalidate();
		sizeInvalid = true;
	}

	private void computeSize () {
		sizeInvalid = false;
		List<Actor> children = getChildren();
		int n = children.size();
		prefWidth = 0;
		if (wrap) {
			prefHeight = 0;
			if (columnSizes == null)
				columnSizes = new ArrayList<>();
			else
				columnSizes.clear();
			List<Integer> columnSizes = this.columnSizes;
			int space = this.space, wrapSpace = this.wrapSpace;
			int pad = padTop + padBottom, groupHeight = getHeight() - pad, x = 0, y = 0, columnWidth = 0;
			int i = 0, incr = 1;
			if (reverse) {
				i = n - 1;
				n = -1;
				incr = -1;
			}
			for (; i != n; i += incr) {
				Actor child = children.get(i);

				int width, height;
				if (child instanceof Layout) {
					Layout layout = (Layout)child;
					width = layout.getPrefWidth();
					height = layout.getPrefHeight();
				} else {
					width = child.getWidth();
					height = child.getHeight();
				}

				int incrY = height + (y > 0 ? space : 0);
				if (y + incrY > groupHeight && y > 0) {
					columnSizes.add(y);
					columnSizes.add(columnWidth);
					prefHeight = Math.max(prefHeight, y + pad);
					if (x > 0) x += wrapSpace;
					x += columnWidth;
					columnWidth = 0;
					y = 0;
					incrY = height;
				}
				y += incrY;
				columnWidth = Math.max(columnWidth, width);
			}
			columnSizes.add(y);
			columnSizes.add(columnWidth);
			prefHeight = Math.max(prefHeight, y + pad);
			if (x > 0) x += wrapSpace;
			prefWidth = Math.max(prefWidth, x + columnWidth);
		} else {
			prefHeight = padTop + padBottom + space * (n - 1);
			for (int i = 0; i < n; i++) {
				Actor child = children.get(i);
				if (child instanceof Layout) {
					Layout layout = (Layout)child;
					prefWidth = Math.max(prefWidth, layout.getPrefWidth());
					prefHeight += layout.getPrefHeight();
				} else {
					prefWidth = Math.max(prefWidth, child.getWidth());
					prefHeight += child.getHeight();
				}
			}
		}
		prefWidth += padLeft + padRight;
	}

	@Override
	public void layout () {
		if (sizeInvalid) computeSize();

		if (wrap) {
			layoutWrapped();
			return;
		}

		int align = this.align;
		int space = this.space, padLeft = this.padLeft, fill = this.fill;
		int columnWidth = (expand ? getWidth() : prefWidth) - padLeft - padRight, y = prefHeight - padTop + space;

		if ((align & Align.top) != 0)
			y += getHeight() - prefHeight;
		else if ((align & Align.bottom) == 0) // center
			y += (getHeight() - prefHeight) / 2;

		int startX;
		if ((align & Align.left) != 0)
			startX = padLeft;
		else if ((align & Align.right) != 0)
			startX = getWidth() - padRight - columnWidth;
		else
			startX = padLeft + (getWidth() - padLeft - padRight - columnWidth) / 2;

		align = columnAlign;

		List<Actor> children = getChildren();
		int i = 0, n = children.size(), incr = 1;
		if (reverse) {
			i = n - 1;
			n = -1;
			incr = -1;
		}
		for (int r = 0; i != n; i += incr) {
			Actor child = children.get(i);

			int width, height;
			Layout layout = null;
			if (child instanceof Layout) {
				layout = (Layout)child;
				width = layout.getPrefWidth();
				height = layout.getPrefHeight();
			} else {
				width = child.getWidth();
				height = child.getHeight();
			}

			if (fill > 0) width = columnWidth * fill;

			if (layout != null) {
				width = Math.max(width, layout.getMinWidth());
				int maxWidth = layout.getMaxWidth();
				if (maxWidth > 0 && width > maxWidth) width = maxWidth;
			}

			int x = startX;
			if ((align & Align.right) != 0)
				x += columnWidth - width;
			else if ((align & Align.left) == 0) // center
				x += (columnWidth - width) / 2;

			y -= height + space;
			child.setBounds(x, y, width, height);

			if (layout != null) layout.validate();
		}
	}

	private void layoutWrapped () {
		int prefWidth = getPrefWidth();
		if (prefWidth != lastPrefWidth) {
			lastPrefWidth = prefWidth;
			invalidateHierarchy();
		}

		int align = this.align;
		int space = this.space, padLeft = this.padLeft, fill = this.fill, wrapSpace = this.wrapSpace;
		int maxHeight = prefHeight - padTop - padBottom;
		int columnX = padLeft, groupHeight = getHeight();
		int yStart = prefHeight - padTop + space, y = 0, columnWidth = 0;

		if ((align & Align.right) != 0)
			columnX += getWidth() - prefWidth;
		else if ((align & Align.left) == 0) // center
			columnX += (getWidth() - prefWidth) / 2;

		if ((align & Align.top) != 0)
			yStart += groupHeight - prefHeight;
		else if ((align & Align.bottom) == 0) // center
			yStart += (groupHeight - prefHeight) / 2;

		groupHeight -= padTop;
		align = columnAlign;

		List<Integer> columnSizes = this.columnSizes;
		List<Actor> children = getChildren();
		int i = 0, n = children.size(), incr = 1;
		if (reverse) {
			i = n - 1;
			n = -1;
			incr = -1;
		}
		for (int r = 0; i != n; i += incr) {
			Actor child = children.get(i);

			int width, height;
			Layout layout = null;
			if (child instanceof Layout) {
				layout = (Layout)child;
				width = layout.getPrefWidth();
				height = layout.getPrefHeight();
			} else {
				width = child.getWidth();
				height = child.getHeight();
			}

			if (y - height - space < padBottom || r == 0) {
				y = yStart;
				if ((align & Align.bottom) != 0)
					y -= maxHeight - columnSizes.get(r);
				else if ((align & Align.top) == 0) // center
					y -= (maxHeight - columnSizes.get(r)) / 2;
				if (r > 0) {
					columnX += wrapSpace;
					columnX += columnWidth;
				}
				columnWidth = columnSizes.get(r + 1);
				r += 2;
			}

			if (fill > 0) width = columnWidth * fill;

			if (layout != null) {
				width = Math.max(width, layout.getMinWidth());
				int maxWidth = layout.getMaxWidth();
				if (maxWidth > 0 && width > maxWidth) width = maxWidth;
			}

			int x = columnX;
			if ((align & Align.right) != 0)
				x += columnWidth - width;
			else if ((align & Align.left) == 0) // center
				x += (columnWidth - width) / 2;

			y -= height + space;
			child.setBounds(x, y, width, height);

			if (layout != null) layout.validate();
		}
	}

	@Override
	public int getPrefWidth () {
		if (sizeInvalid) computeSize();
		return prefWidth;
	}

	@Override
	public int getPrefHeight () {
		if (wrap) return 0;
		if (sizeInvalid) computeSize();
		return prefHeight;
	}
}
