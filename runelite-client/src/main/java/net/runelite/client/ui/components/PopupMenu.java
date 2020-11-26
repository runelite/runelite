/*
 * Copyright (c) 2018, Daniel Teo <https://github.com/takuyakanbr>
 * Copyright (c) 2020, Adam Davies <https://github.com/adamdavies001>
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
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;

public class PopupMenu
{
	/**
	 * Adds the passed menu items to a popup menu shown when the component is clicked, and
	 * adds a mouseover effect to change the text of a passed label to {@link ColorScheme#BRAND_ORANGE} color
	 *
	 * @param component The component to attach the mouseover and click effects to
	 * @param trigger   The MouseEvent.BUTTON to trigger the popup
	 * @param menuItems The menu items to be shown when the label is clicked
	 */
	public static <T extends JComponent> void create(T component, Integer trigger, JMenuItem... menuItems)
	{
		final boolean isLabel = component instanceof JLabel;
		final JPopupMenu menu = new JPopupMenu();
		menu.setBorder(new EmptyBorder(5, 5, 5, 5));

		for (final JMenuItem menuItem : menuItems)
		{
			if (menuItem == null)
			{
				continue;
			}

			// Some machines register mouseEntered through a popup menu, and do not register mouseExited when a popup
			// menu item is clicked, so reset the label's color when we click one of these options.
			if (isLabel)
			{
				final Color labelForeground = component.getForeground();
				menuItem.addActionListener(e -> component.setForeground(labelForeground));
			}

			menu.add(menuItem);
		}

		component.addMouseListener(new MouseAdapter()
		{
			private Color lastForeground;

			@Override
			public void mouseClicked(MouseEvent mouseEvent)
			{
				if (trigger == null || mouseEvent.getButton() == trigger)
				{
					Component source = (Component) mouseEvent.getSource();
					Point location = MouseInfo.getPointerInfo().getLocation();
					SwingUtilities.convertPointFromScreen(location, source);
					menu.show(source, location.x, location.y);
				}
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				if (isLabel)
				{
					lastForeground = component.getForeground();
					component.setForeground(ColorScheme.BRAND_ORANGE);
				}
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				if (isLabel)
				{
					component.setForeground(lastForeground);
				}
			}
		});
	}
}
