/*
 * Copyright (c) 2017-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import com.google.common.collect.ComparisonChain;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.Box;
import javax.swing.JToolBar;

/**
 * Client plugin toolbar.
 */
public class ClientPluginToolbar extends JToolBar
{
	private static final int TOOLBAR_WIDTH = 36, TOOLBAR_HEIGHT = 503;
	private final Map<NavigationButton, Component> componentMap = new TreeMap<>((a, b) ->
		ComparisonChain
			.start()
			.compareTrueFirst(a.isTab(), b.isTab())
			.compare(a.getPriority(), b.getPriority())
			.compare(a.getTooltip(), b.getTooltip())
			.result());

	/**
	 * Instantiates a new Client plugin toolbar.
	 */
	ClientPluginToolbar()
	{
		super(JToolBar.VERTICAL);
		setFloatable(false);
		setSize(new Dimension(TOOLBAR_WIDTH, TOOLBAR_HEIGHT));
		setMinimumSize(new Dimension(TOOLBAR_WIDTH, TOOLBAR_HEIGHT));
		setPreferredSize(new Dimension(TOOLBAR_WIDTH, TOOLBAR_HEIGHT));
		setMaximumSize(new Dimension(TOOLBAR_WIDTH, Integer.MAX_VALUE));
	}

	void addComponent(final NavigationButton button, final Component c)
	{
		if (componentMap.put(button, c) == null)
		{
			update();
		}
	}

	void removeComponent(final NavigationButton button)
	{
		if (componentMap.remove(button) != null)
		{
			update();
		}
	}

	private void update()
	{
		removeAll();
		boolean isDelimited = false;

		for (final Map.Entry<NavigationButton, Component> entry : componentMap.entrySet())
		{
			if (!entry.getKey().isTab() && !isDelimited)
			{
				isDelimited = true;
				add(Box.createVerticalGlue());
				addSeparator();
			}

			add(entry.getValue());
		}

		repaint();
	}
}
