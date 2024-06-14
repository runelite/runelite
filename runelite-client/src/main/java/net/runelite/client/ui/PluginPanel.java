/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;

public abstract class PluginPanel extends JPanel implements Activatable
{
	public static final int PANEL_WIDTH = 225;
	public static final int SCROLLBAR_WIDTH = 17;
	public static final int BORDER_OFFSET = 6;
	private static final EmptyBorder BORDER_PADDING = new EmptyBorder(BORDER_OFFSET, BORDER_OFFSET, BORDER_OFFSET, BORDER_OFFSET);
	private static final Dimension OUTER_PREFERRED_SIZE = new Dimension(PluginPanel.PANEL_WIDTH + SCROLLBAR_WIDTH, 0);

	@Getter(AccessLevel.PROTECTED)
	private final JScrollPane scrollPane;

	@Getter
	private final JPanel wrappedPanel;

	protected PluginPanel()
	{
		this(true);
	}

	protected PluginPanel(boolean wrap)
	{
		super();
		if (wrap)
		{
			setBorder(BORDER_PADDING);
			setLayout(new DynamicGridLayout(0, 1, 0, 3));
			setBackground(ColorScheme.DARK_GRAY_COLOR);

			final JPanel northPanel = new JPanel();
			northPanel.setLayout(new BorderLayout());
			northPanel.add(this, BorderLayout.NORTH);
			northPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

			scrollPane = new JScrollPane(northPanel);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			wrappedPanel = new JPanel();

			// Adjust the preferred size to expand to width of scrollbar to
			// prevent scrollbar overlapping over contents
			wrappedPanel.setPreferredSize(OUTER_PREFERRED_SIZE);
			wrappedPanel.setLayout(new BorderLayout());
			wrappedPanel.add(scrollPane, BorderLayout.CENTER);
		}
		else
		{
			scrollPane = null;
			wrappedPanel = this;
		}
	}

	@Override
	public Dimension getPreferredSize()
	{
		int width = this == wrappedPanel ? PANEL_WIDTH + SCROLLBAR_WIDTH : PANEL_WIDTH;
		return new Dimension(width, super.getPreferredSize().height);
	}

	@Override
	public Dimension getMinimumSize()
	{
		int width = this == wrappedPanel ? PANEL_WIDTH + SCROLLBAR_WIDTH : PANEL_WIDTH;
		return new Dimension(width, super.getMinimumSize().height);
	}
}
