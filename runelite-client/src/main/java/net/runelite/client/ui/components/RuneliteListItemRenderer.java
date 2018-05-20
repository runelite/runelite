/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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

import net.runelite.client.ui.ColorScheme;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

public class RuneliteListItemRenderer extends JLabel implements ListCellRenderer
{
	@Override
	public Component getListCellRendererComponent(JList jlist, Object o, int index, boolean isSelected, boolean cellHasFocus)
	{
		RuneliteList list = (RuneliteList)jlist;
		if (isSelected)
		{
			setBackground(ColorScheme.BRAND_ORANGE_TRANSPARENT);
			setForeground(Color.WHITE);
			setOpaque(true);
		}
		else
		{
			setForeground(ColorScheme.LIGHT_GRAY_COLOR);
			setOpaque(false);
		}
		if (list.getHoveredIndex() == index)
		{
			setForeground(Color.WHITE);
		}

		setBorder(new EmptyBorder(1, 4, 1, 4));

		String text = o.toString();
		setText(text);

		return this;
	}
}
