/*
 * Copyright (c) 2018 Patrick Beuks (killje) <patrick.beuks@gmail.com>
 * Copyright (c) 2018 CC007 <Coolcat_the_best2@hotmail.com>
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
package net.runelite.client.plugins.itemdatabase.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.border.EmptyBorder;
import net.runelite.client.plugins.itemdatabase.layout.search.SearchBar;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

@Singleton
public class ItemDatabasePanel extends PluginPanel
{

	private static final int OFFSET = 6;
	private static final int SCROLLBAR_WIDTH = 17;
	private static final EmptyBorder BORDER_PADDING
		= new EmptyBorder(OFFSET, OFFSET, OFFSET, OFFSET);
	private static final Dimension OUTER_PREFERRED_SIZE
		= new Dimension(PluginPanel.PANEL_WIDTH + SCROLLBAR_WIDTH, 0);

	@Inject
	public ItemDatabasePanel(SearchBar searchBar, DisplayPanelWrapper displayPanelWrapper)
	{
		super(false);
		setBorder(BORDER_PADDING);
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setPreferredSize(OUTER_PREFERRED_SIZE);
		setLayout(new BorderLayout(0, OFFSET * 2));

		add(searchBar, BorderLayout.NORTH);
		add(displayPanelWrapper, BorderLayout.CENTER);

	}

}
