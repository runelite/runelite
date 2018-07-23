/*
 * Copyright (c) 2018, TheStonedTurtle <http://www.github.com/TheStonedTurtle>
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

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import net.runelite.client.ui.ColorScheme;

/**
 * This is an updated version of RuneLite's ComboBoxListRenderer which will
 * add an icon to be displayed. Requires use of ComboBoxIconEntry class to work
 */
public final class ComboBoxIconRenderer extends JLabel implements ListCellRenderer
{
	private String DEFAULT_TEXT = "Select an option...";

	@Override
	public Component getListCellRendererComponent(JList list, Object o, int index, boolean isSelected, boolean cellHasFocus)
	{
		// Pulled from RuneLite's ComboBoxListRenderer
		if (isSelected)
		{
			setBackground(ColorScheme.DARK_GRAY_COLOR);
			setForeground(Color.WHITE);
		}
		else
		{
			setBackground(list.getBackground());
			setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		}

		setBorder(new EmptyBorder(5, 5, 5, 0));

		// If using setSelectedItem(null) or setSelectedIndex(-1) show default text
		// Also only shows if no previous selection
		if (index == -1 && o == null)
		{
			setIcon(null);
			setText(DEFAULT_TEXT);
		}
		else if (o instanceof ComboBoxIconEntry)
		{
			ComboBoxIconEntry item = (ComboBoxIconEntry) o;
			setIcon(item.getIcon());
			setText(item.getText());
		}
		else
		{
			// Not a ComboBoxIconEntry, try to convert Object to string
			setIcon(null);
			setText(o.toString());
		}

		return this;
	}

	public void setDefaultText(String text)
	{
		DEFAULT_TEXT = text;
	}
}