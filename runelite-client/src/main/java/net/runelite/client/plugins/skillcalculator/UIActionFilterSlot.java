/*
 * Copyright (c) 2018, William Metcalf <https://github.com/williammetcalf>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *	list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *	this list of conditions and the following disclaimer in the documentation
 *	and/or other materials provided with the distribution.
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
package net.runelite.client.plugins.skillcalculator;

import net.runelite.client.input.KeyListener;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.components.IconTextField;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.function.Consumer;

public class UIActionFilterSlot extends JPanel
{
	private static final ImageIcon SEARCH_ICON;
	private final IconTextField uiFilterField;

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				SEARCH_ICON = new ImageIcon(ImageIO.read(IconTextField.class.getResourceAsStream("search.png")));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	UIActionFilterSlot(Consumer<String> onFilter)
	{
		setLayout(new BorderLayout(0, 0));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		final JPanel uiInfo = new JPanel(new GridLayout(1, 1));
		uiInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		uiFilterField = new IconTextField();
		uiFilterField.setPreferredSize(new Dimension(100, 36));
		uiFilterField.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		uiFilterField.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		uiFilterField.setIcon(SEARCH_ICON);
		uiFilterField.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{ }

			@Override
			public void keyPressed(KeyEvent e)
			{ }

			@Override
			public void keyReleased(KeyEvent e)
			{
				onFilter.accept(uiFilterField.getText());
			}
		});

		uiInfo.add(uiFilterField);

		add(uiInfo);
	}

	public String getText()
	{
		return uiFilterField.getText();
	}
}
