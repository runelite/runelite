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

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import javax.swing.JToolBar;

public class PluginToolbar extends JToolBar
{
	public static final int TOOLBAR_WIDTH = 36, TOOLBAR_HEIGHT = 503;

	private final ClientUI ui;
	private final List<NavigationButton> buttons = new ArrayList<>();

	private NavigationButton current;

	public PluginToolbar(ClientUI ui)
	{
		super(JToolBar.VERTICAL);
		this.ui = ui;

		super.setFloatable(false);
		super.setSize(new Dimension(TOOLBAR_WIDTH, TOOLBAR_HEIGHT));
		super.setMinimumSize(new Dimension(TOOLBAR_WIDTH, TOOLBAR_HEIGHT));
		super.setPreferredSize(new Dimension(TOOLBAR_WIDTH, TOOLBAR_HEIGHT));
		super.setMaximumSize(new Dimension(TOOLBAR_WIDTH, Integer.MAX_VALUE));
	}

	public void addNavigation(NavigationButton button)
	{
		button.addActionListener((ae) -> onClick(button));
		button.setToolTipText(button.getName());

		buttons.add(button);
		add(button);
		revalidate();
	}

	public void removeNavigation(NavigationButton button)
	{
		buttons.remove(button);
		remove(button);
		revalidate();
	}

	private void onClick(NavigationButton button)
	{
		Supplier<PluginPanel> panelSupplier = button.getPanelSupplier();
		if (panelSupplier == null)
		{
			return;
		}

		if (current != null)
		{
			current.setSelected(false);
		}

		if (current == button)
		{
			ui.contract();
			current = null;
		}
		else
		{
			current = button;
			current.setSelected(true);

			PluginPanel pluginPanel = panelSupplier.get();
			ui.expand(pluginPanel);
		}
	}
}
