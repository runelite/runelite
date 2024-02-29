/*
 * Copyright (c) 2022 Abex
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
package net.runelite.client.ui.laf;

import com.formdev.flatlaf.ui.FlatStylingSupport;
import com.formdev.flatlaf.ui.FlatTabbedPaneUI;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

public class RuneLiteTabbedPaneUI extends FlatTabbedPaneUI
{
	public static ComponentUI createUI(JComponent c)
	{
		return new RuneLiteTabbedPaneUI();
	}

	@FlatStylingSupport.Styleable
	protected boolean expandWrappedTabs = UIManager.getBoolean("TabbedPane.expandWrappedTabs");

	@FlatStylingSupport.Styleable
	protected boolean evenlyWrapTabs = UIManager.getBoolean("TabbedPane.evenlyWrapTabs");

	/**
	 * If the tabs are always a single size
	 */
	@FlatStylingSupport.Styleable
	protected boolean variableSize = false;

	/**
	 * If the there can be no tab selected
	 */
	@FlatStylingSupport.Styleable
	protected boolean deselectable = false;

	@Override
	protected LayoutManager createLayoutManager()
	{
		if (tabPane.getTabLayoutPolicy() == JTabbedPane.WRAP_TAB_LAYOUT)
		{
			return new RuneLiteTabbedPaneLayout();
		}

		return super.createLayoutManager();
	}

	protected class RuneLiteTabbedPaneLayout extends FlatTabbedPaneLayout
	{
		@Override
		protected void normalizeTabRuns(int tabPlacement, int tabCount, int start, int max)
		{
			if (!evenlyWrapTabs)
			{
				return;
			}

			// the jdk's method to do this iteratively moves stuff around until its close enough,
			// however this means that with 16 equally sized tabs you get 2 runs of 7 and 9 tabs
			// each, which looks wrong

			// XXX this assumes all tabs are the same size

			boolean verticalTabRuns = tabPlacement == LEFT || tabPlacement == RIGHT;

			int tab = 0;
			for (int run = 0; run < runCount; run++)
			{
				tabRuns[run] = tab;
				int remainingTabs = tabCount - tab;
				int remainingRuns = runCount - run;
				int nextRun = tab + (remainingTabs + remainingRuns - 1) / remainingRuns;
				for (int i = tab, off = start; i < nextRun; i++)
				{
					if (verticalTabRuns)
					{
						rects[i].y = off;
						off += rects[i].height;
					}
					else
					{
						rects[i].x = off;
						off += rects[i].width;
					}
				}
				tab = nextRun;
			}
		}

		@Override
		protected Dimension calculateSize(boolean minimum)
		{
			if (!variableSize)
			{
				return super.calculateSize(minimum);
			}

			// assume the directions the tabs are running is a fixed size
			// and we want to calculate the size of the tab bar + our current
			// content only in the perpendicular axis

			int tabPlacement = tabPane.getTabPlacement();
			boolean verticalTabRuns = tabPlacement == LEFT || tabPlacement == RIGHT;

			int width = 0;
			int height = 0;

			Insets contentInsets = getContentBorderInsets(tabPlacement);
			Insets insets = tabPane.getInsets();
			Insets tabAreaInsets = getTabAreaInsets(tabPlacement);
			int xInsets = insets.left + insets.right + contentInsets.left + contentInsets.right;
			int yInsets = insets.bottom + insets.top + contentInsets.top + contentInsets.bottom;

			Component component = tabPane.getSelectedComponent();
			if (component != null)
			{
				Dimension size = minimum
					? component.getMinimumSize()
					: component.getPreferredSize();

				if (size != null)
				{
					width = Math.max(0, size.width);
					height = Math.max(0, size.height);
				}
			}

			if (verticalTabRuns)
			{
				height = Math.max(height, calculateMaxTabHeight(tabPlacement));
				width += preferredTabAreaWidth(tabPlacement, tabPane.getHeight() - yInsets - tabAreaInsets.top - tabAreaInsets.bottom);
			}
			else
			{
				width = Math.max(width, calculateMaxTabWidth(tabPlacement));
				height += preferredTabAreaHeight(tabPlacement, tabPane.getWidth() - xInsets - tabAreaInsets.left - tabAreaInsets.right);
			}

			return new Dimension(width + xInsets, height + yInsets);
		}
	}

	@Override
	protected boolean shouldPadTabRun(int tabPlacement, int run)
	{
		return expandWrappedTabs && super.shouldPadTabRun(tabPlacement, run);
	}

	@Override
	protected MouseListener createMouseListener()
	{
		MouseListener delegate = super.createMouseListener();
		return new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				delegate.mouseClicked(e);
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				hackUpdateRollover(e);

				if (!deselectable)
				{
					delegate.mousePressed(e);
					return;
				}

				if (!tabPane.isEnabled() || e.getButton() != MouseEvent.BUTTON1)
				{
					return;
				}

				int tabIndex = tabForCoordinate(tabPane, e.getX(), e.getY());
				if (tabIndex < 0 || !tabPane.isEnabledAt(tabIndex))
				{
					return;
				}

				tabPane.setSelectedIndex(tabPane.getSelectedIndex() == tabIndex ? -1 : tabIndex);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				delegate.mouseClicked(e);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				delegate.mouseEntered(e);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				delegate.mouseExited(e);
			}

			private void hackUpdateRollover(MouseEvent e)
			{
				delegate.mouseEntered(e);
			}
		};
	}
}
