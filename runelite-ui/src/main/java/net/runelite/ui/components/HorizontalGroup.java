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

public class HorizontalGroup extends ComponentGroup {
	private int prefWidth, prefHeight, lastPrefHeight;
	private boolean sizeInvalid = true;
	private List<Integer> rowSizes; // row width, row height, ...

	@Getter
	@Setter
	private int align = Align.left;

	@Getter
	@Setter
	private int rowAlign;

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
		prefHeight = 0;
		if (wrap) {
			prefWidth = 0;
			if (rowSizes == null)
				rowSizes = new ArrayList<>();
			else
				rowSizes.clear();
			List<Integer> rowSizes = this.rowSizes;
			int space = this.space, wrapSpace = this.wrapSpace;
			int pad = padLeft + padRight, groupWidth = getWidth() - pad, x = 0, y = 0, rowHeight = 0;
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

				int incrX = width + (x > 0 ? space : 0);
				if (x + incrX > groupWidth && x > 0) {
					rowSizes.add(x);
					rowSizes.add(rowHeight);
					prefWidth = Math.max(prefWidth, x + pad);
					if (y > 0) y += wrapSpace;
					y += rowHeight;
					rowHeight = 0;
					x = 0;
					incrX = width;
				}
				x += incrX;
				rowHeight = Math.max(rowHeight, height);
			}
			rowSizes.add(x);
			rowSizes.add(rowHeight);
			prefWidth = Math.max(prefWidth, x + pad);
			if (y > 0) y += wrapSpace;
			prefHeight = Math.max(prefHeight, y + rowHeight);
		} else {
			prefWidth = padLeft + padRight + space * (n - 1);
			for (int i = 0; i < n; i++) {
				Actor child = children.get(i);
				if (child instanceof Layout) {
					Layout layout = (Layout)child;
					prefWidth += layout.getPrefWidth();
					prefHeight = Math.max(prefHeight, layout.getPrefHeight());
				} else {
					prefWidth += child.getWidth();
					prefHeight = Math.max(prefHeight, child.getHeight());
				}
			}
		}
		prefHeight += padTop + padBottom;
	}

	@Override
	public void layout () {
		if (sizeInvalid) computeSize();

		if (wrap) {
			layoutWrapped();
			return;
		}

		int align = this.align;
		int space = this.space, padBottom = this.padBottom, fill = this.fill;
		int rowHeight = (expand ? getHeight() : prefHeight) - padTop - padBottom, x = padLeft;

		if ((align & Align.right) != 0)
			x += getWidth() - prefWidth;
		else if ((align & Align.left) == 0) // center
			x += (getWidth() - prefWidth) / 2;

		int startY;
		if ((align & Align.bottom) != 0)
			startY = padBottom;
		else if ((align & Align.top) != 0)
			startY = getHeight() - padTop - rowHeight;
		else
			startY = padBottom + (getHeight() - padBottom - padTop - rowHeight) / 2;

		align = rowAlign;

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

			if (fill > 0) height = rowHeight * fill;

			if (layout != null) {
				height = Math.max(height, layout.getMinHeight());
				int maxHeight = layout.getMaxHeight();
				if (maxHeight > 0 && height > maxHeight) height = maxHeight;
			}

			int y = startY;
			if ((align & Align.top) != 0)
				y += rowHeight - height;
			else if ((align & Align.bottom) == 0) // center
				y += (rowHeight - height) / 2;

			child.setBounds(x, y, width, height);
			x += width + space;

			if (layout != null) layout.validate();
		}
	}

	private void layoutWrapped () {
		int prefHeight = getPrefHeight();
		if (prefHeight != lastPrefHeight) {
			lastPrefHeight = prefHeight;
			invalidateHierarchy();
		}

		int align = this.align;
		int space = this.space, padBottom = this.padBottom, fill = this.fill, wrapSpace = this.wrapSpace;
		int maxWidth = prefWidth - padLeft - padRight;
		int rowY = prefHeight - padTop, groupWidth = getWidth(), xStart = padLeft, x = 0, rowHeight = 0;

		if ((align & Align.top) != 0)
			rowY += getHeight() - prefHeight;
		else if ((align & Align.bottom) == 0) // center
			rowY += (getHeight() - prefHeight) / 2;

		if ((align & Align.right) != 0)
			xStart += groupWidth - prefWidth;
		else if ((align & Align.left) == 0) // center
			xStart += (groupWidth - prefWidth) / 2;

		groupWidth -= padRight;
		align = this.rowAlign;

		List<Integer> rowSizes = this.rowSizes;
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

			if (x + width > groupWidth || r == 0) {
				x = xStart;
				if ((align & Align.right) != 0)
					x += maxWidth - rowSizes.get(r);
				else if ((align & Align.left) == 0) // center
					x += (maxWidth - rowSizes.get(r)) / 2;
				rowHeight = rowSizes.get(r + 1);
				if (r > 0) rowY -= wrapSpace;
				rowY -= rowHeight;
				r += 2;
			}

			if (fill > 0) height = rowHeight * fill;

			if (layout != null) {
				height = Math.max(height, layout.getMinHeight());
				int maxHeight = layout.getMaxHeight();
				if (maxHeight > 0 && height > maxHeight) height = maxHeight;
			}

			int y = rowY;
			if ((align & Align.top) != 0)
				y += rowHeight - height;
			else if ((align & Align.bottom) == 0) // center
				y += (rowHeight - height) / 2;

			child.setBounds(x, y, width, height);
			x += width + space;

			if (layout != null) layout.validate();
		}
	}

	@Override
	public int getPrefWidth () {
		if (wrap) return 0;
		if (sizeInvalid) computeSize();
		return prefWidth;
	}

	@Override
	public int getPrefHeight () {
		if (sizeInvalid) computeSize();
		return prefHeight;
	}
}
