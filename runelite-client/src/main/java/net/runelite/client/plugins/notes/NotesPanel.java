/*
 * Copyright (c) 2018 Charlie Waters
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2019, whs <https://github.com/whs>
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
package net.runelite.client.plugins.notes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.getRootFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.notes.events.PageAdded;
import net.runelite.client.plugins.notes.events.PageDeleted;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
import net.runelite.client.util.ImageUtil;

@Slf4j
@Singleton
class NotesPanel extends PluginPanel
{
	@Inject
	private NotesManager notesManager;

	@Inject
	private EventBus eventBus;

	private final JPanel display = new JPanel();
	private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);
	private final ImageIcon addIcon = new ImageIcon(ImageUtil.getResourceStreamFromClass(getClass(), "add_icon.png"));
	private MaterialTab addTab;
	private List<MaterialTab> tabs = new ArrayList<>();
	private NotesConfig config;

	void init(final NotesConfig mConfig)
	{
		config = mConfig;

		eventBus.subscribe(PageAdded.class, this, this::onPageAdded);
		eventBus.subscribe(PageDeleted.class, this, this::onPageDeleted);
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);

		// this may or may not qualify as a hack
		// but this lets the editor pane expand to fill the whole parent panel
		getParent().setLayout(new BorderLayout());
		getParent().add(this, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		tabGroup.setBorder(new EmptyBorder(0, 0, 10, 0));

		buildAddTab();

		add(tabGroup, BorderLayout.NORTH);
		add(display, BorderLayout.CENTER);
	}

	private void buildAddTab()
	{
		addTab = new MaterialTab(addIcon, tabGroup, new JPanel());
		addTab.setOnSelectEvent(() -> {
			notesManager.addPage();
			return false;
		});
	}

	void rebuild()
	{
		tabs = new LinkedList<>();
		tabGroup.removeAll();

		int totalNotes = notesManager.getNotes().size();

		for (int i = 0; i < totalNotes; i++)
		{
			MaterialTab tab = buildTab(i);
			tabs.add(tab);
			tabGroup.addTab(tab);
		}

		if (totalNotes < config.maxNotes())
		{
			tabGroup.addTab(addTab);
		}

		if (tabs.size() > 0)
		{
			// select the first tab
			tabGroup.select(tabGroup.getTab(0));
		}

		revalidate();
		repaint();
	}

	private void onConfigChanged(ConfigChanged e)
	{
		if (!e.getGroup().equals(NotesConfig.CONFIG_GROUP))
		{
			return;
		}

		rebuild();
	}

	private void onPageAdded(PageAdded e)
	{
		MaterialTab tab = buildTab(e.getIndex());
		tabs.add(tab);
		tabGroup.addTab(tab);

		// re-add add button to make it last
		tabGroup.removeTab(addTab);
		if (notesManager.getNotes().size() < config.maxNotes())
		{
			tabGroup.addTab(addTab);
		}

		revalidate();
		repaint();
	}

	private void onPageDeleted(PageDeleted e)
	{
		rebuild();
	}

	private MaterialTab buildTab(int index)
	{
		String name = String.valueOf(index + 1);
		NoteTab noteTab = new NoteTab(notesManager, index);

		MaterialTab materialTab = new MaterialTab(name, tabGroup, noteTab);
		materialTab.setPreferredSize(new Dimension(30, 27));
		materialTab.setName(name);

		final JMenuItem deleteMenuItem = new JMenuItem();
		deleteMenuItem.setText(String.format("Delete note %s", name));

		deleteMenuItem.addActionListener(e -> {
			if (JOptionPane.showConfirmDialog(getRootFrame(), String.format("Delete note page %s?", name), "Notes", YES_NO_OPTION) != YES_OPTION)
			{
				return;
			}
			try
			{
				notesManager.deletePage(index);
			}
			catch (DeleteOnlyPageException err)
			{
				SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(getRootFrame(),
					"Cannot delete the last page",
					"Notes", ERROR_MESSAGE));
			}
		});

		final JPopupMenu contextMenu = new JPopupMenu();
		contextMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		contextMenu.add(deleteMenuItem);

		materialTab.setComponentPopupMenu(contextMenu);

		return materialTab;
	}
}
