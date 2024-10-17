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
package net.runelite.client.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.TreeMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.SwingUtil;

/**
 * non-tab toolbar items, in the title bar or bottom of the sidebar
 */
class ClientToolbarPanel extends JPanel
{
	private final TreeMap<NavigationButton, Component> entries = new TreeMap<>(NavigationButton.COMPARATOR);

	ClientToolbarPanel(boolean isInSidebar)
	{
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		if (isInSidebar)
		{
			setLayout(new DynamicGridLayout(0, 1, 0, 4));
		}
		else
		{
			setLayout(new DynamicGridLayout(1, 0, 4, 0));
		}

		revalidate();
	}

	JButton add(NavigationButton nb, boolean resize)
	{
		Icon icon = new ImageIcon(resize ? ImageUtil.resizeImage(nb.getIcon(), 16, 16) : nb.getIcon());
		JButton jb = new JButton(icon);
		SwingUtil.removeButtonDecorations(jb);
		jb.setToolTipText(nb.getTooltip());
		jb.setFocusable(false);
		jb.setPreferredSize(new Dimension(23, 23));
		jb.setAlignmentX(.5f);
		jb.setAlignmentY(.5f);

		jb.addActionListener(l ->
		{
			if (nb.getOnClick() != null)
			{
				nb.getOnClick().run();
			}
		});

		if (nb.getPopup() != null)
		{
			var menu = new JPopupMenu();
			nb.getPopup().forEach((name, cb) ->
			{
				var menuItem = new JMenuItem(name);
				menuItem.addActionListener(e -> cb.run());
				menu.add(menuItem);
			});
			jb.setComponentPopupMenu(menu);
		}

		if (entries.putIfAbsent(nb, jb) != null)
		{
			return null;
		}
		add(jb, entries.headMap(nb).size());
		revalidate();
		revalidateMaxSize();
		return jb;
	}

	void remove(NavigationButton btn)
	{
		Component c = entries.remove(btn);
		if (c != null)
		{
			remove(c);
			revalidate();
			revalidateMaxSize();
		}
	}

	private void revalidateMaxSize()
	{
		setMaximumSize(getPreferredSize());
	}

	public JPanel createSidebarPanel()
	{
		JPanel wrap = new JPanel();
		wrap.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		wrap.setLayout(new BorderLayout());
		wrap.add(this, BorderLayout.SOUTH);
		return wrap;
	}
}
