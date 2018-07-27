/*
 * Copyright (c) 2018, Matevz <https://github.com/MatevzFa>
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
package net.runelite.client.plugins.config;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconButton;
import net.runelite.client.ui.components.IconTextField;

class ConfigSearchBar extends IconTextField
{
	private static final int SEARCH_BAR_SIZE = 30;

	private static final ImageIcon SEARCH;
	private static final ImageIcon CLEAR;
	private static final ImageIcon CLEAR_HOVER;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				SEARCH = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search.png")));
				CLEAR = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("clear.png")));
				CLEAR_HOVER = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("clear_hover.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	ConfigSearchBar()
	{
		setIcon(SEARCH);
		setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, SEARCH_BAR_SIZE));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);
		setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);

		IconButton clearButton = new IconButton(CLEAR, CLEAR_HOVER);
		clearButton.setPreferredSize(new Dimension(SEARCH_BAR_SIZE, SEARCH_BAR_SIZE));
		clearButton.addActionListener(e -> this.setText(""));

		add(clearButton, BorderLayout.EAST);
	}
}
