/*
 * Copyright (c) 2018, Psikoi <https://github.com/Psikoi>
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
package net.runelite.client.plugins.worldhopper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.annotation.Nonnull;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;

class WorldTableHeader extends JPanel
{
	private static final ImageIcon ARROW_DOWN;
	private static final ImageIcon ARROW_UP;
	private static final ImageIcon ARROW_UP_FADED;

	static
	{
		final BufferedImage arrowDown = ImageUtil.getResourceStreamFromClass(WorldHopperPlugin.class, "arrow_down.png");
		final BufferedImage arrowUp = ImageUtil.rotateImage(arrowDown, Math.PI);
		final BufferedImage arrowUpFaded = ImageUtil.grayscaleOffset(arrowUp, -80);
		ARROW_DOWN = new ImageIcon(arrowDown);
		ARROW_UP = new ImageIcon(arrowUp);
		ARROW_UP_FADED = new ImageIcon(arrowUpFaded);
	}

	private final JLabel textLabel = new JLabel();
	private final JLabel arrowLabel = new JLabel();
	// Determines if this header column is being used to order the list
	private boolean ordering = false;

	WorldTableHeader(String title, boolean ordered, boolean ascending, @Nonnull Runnable onRefresh)
	{
		setLayout(new BorderLayout(5, 0));
		setBorder(new CompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 0, 1, ColorScheme.MEDIUM_GRAY_COLOR),
			new EmptyBorder(0, 5, 0, 2)));
		setBackground(ColorScheme.SCROLL_TRACK_COLOR);

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				textLabel.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				if (ordering)
				{
					textLabel.setForeground(Color.WHITE);
					return;
				}

				textLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			}
		});

		textLabel.setText(title);
		textLabel.setFont(FontManager.getRunescapeSmallFont());

		final JMenuItem refresh = new JMenuItem("Refresh worlds");
		refresh.addActionListener(e ->
		{
			onRefresh.run();
		});

		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(refresh);

		textLabel.setComponentPopupMenu(popupMenu);
		setComponentPopupMenu(popupMenu);

		highlight(ordered, ascending);

		add(textLabel, BorderLayout.WEST);
		add(arrowLabel, BorderLayout.EAST);
	}

	/**
	 * The labels inherit the parent's mouse listeners.
	 */
	@Override
	public void addMouseListener(MouseListener mouseListener)
	{
		super.addMouseListener(mouseListener);
		textLabel.addMouseListener(mouseListener);
		arrowLabel.addMouseListener(mouseListener);
	}

	/**
	 * If this column header is being used to order, then it should be
	 * highlighted, changing it's font color and icon.
	 */
	public void highlight(boolean on, boolean ascending)
	{
		ordering = on;
		arrowLabel.setIcon(on ? (ascending ? ARROW_DOWN : ARROW_UP) : ARROW_UP_FADED);
		textLabel.setForeground(on ? Color.WHITE : ColorScheme.LIGHT_GRAY_COLOR);
	}
}
