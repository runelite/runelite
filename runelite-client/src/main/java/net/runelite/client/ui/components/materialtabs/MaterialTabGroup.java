/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.ui.components.materialtabs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * This class will be a container (group) for the new Material Tabs. It will
 * contain a list of tabs and a display (JPanel). When a tab is selected, the
 * JPanel "display" will display the content associated with that tab.
 * <p>
 * How to use these tabs:
 * <ol>
 * <li>1 - Create displays (JPanels) for each tab</li>
 * <li>2 - Create an empty JPanel to serve as the group's display</li>
 * <li>3 - Create a new MaterialGroup, passing the panel in step 2 as a param</li>
 * <li>4 - Create new tabs, passing the group in step 3 and one of the panels in
 * step 1 as params</li>
 * <li>5 - Add the tabs to the group using the MaterialTabGroup#addTab method</li>
 * <li>6 - Select one of the tabs using the MaterialTab#select method</li>
 * </ol>
 *
 * @author Psikoi
 */
public class MaterialTabGroup extends JPanel
{
	/* The panel on which the content tab's content will be displayed on. */
	private final JPanel display;
	/* A list of all the tabs contained in this group. */
	private final List<MaterialTab> tabs = new ArrayList<>();

	public MaterialTabGroup(JPanel display)
	{
		this.display = display;
		if (display != null)
		{
			this.display.setLayout(new BorderLayout());
		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 8, 0));
		setOpaque(false);
	}

	public MaterialTabGroup()
	{
		this(null);
	}

	/* Returns the tab on a certain index. */
	public MaterialTab getTab(int index)
	{

		if (tabs.isEmpty())
		{
			return null;
		}

		return tabs.get(index);
	}

	public void addTab(MaterialTab tab)
	{
		tabs.add(tab);
		add(tab, BorderLayout.NORTH);

		invalidate();
		repaint();
	}

	public void removeTab(MaterialTab tab)
	{
		tabs.remove(tab);
		remove(tab);

		invalidate();
		repaint();
	}

	/***
	 * Selects a tab from the group, and sets the display's content to the
	 * tab's associated content.
	 * @param selectedTab - The tab to select
	 */
	public boolean select(MaterialTab selectedTab)
	{
		if (!tabs.contains(selectedTab))
		{
			return false;
		}

		// If the OnTabSelected returned false, exit the method to prevent tab switching
		if (!selectedTab.select())
		{
			return false;
		}

		// If the display is available, switch from the old to the new display
		if (display != null)
		{
			display.removeAll();
			display.add(selectedTab.getContent());
			display.revalidate();
			display.repaint();
		}

		// Unselected all other tabs
		for (MaterialTab tab : tabs)
		{
			if (!tab.equals(selectedTab))
			{
				tab.unselect();
			}
		}

		return true;
	}

	@Override
	public void removeAll()
	{
		super.removeAll();
		tabs.clear();
	}
}