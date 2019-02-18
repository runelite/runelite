/*
 * Copyright (c) 2019, halworsen <mwh@halvorsenfamilien.com>
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
package net.runelite.client.plugins.itemgoals;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.concurrent.ScheduledExecutorService;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

/*
 * The structure of this can be a bit confusing, here's an explanation:
 * A main container (plain JPanel) holds a panel container (tied to a CardLayout).
 * That panel container shows two cards:
 * 	1. A not logged in error panel. This is shown while you're logged out
 * 	2. The actual content of the plugin panel (contentContainer)
 * The contentContainer contains the tab group at the top of the panel,
 * and the actual content of the plugin panel (held in currentViewContainer)
 * currentViewContainer contains both the goals listing panel and the add goal panel. It is controlled by the tab group.
 *
 * In the goals list view, goalsCardLayout controls whether an error panel is shown (when there are no goals) and
 * when the actual list is shown.
 */
@Singleton
public class ItemGoalsPanel extends PluginPanel
{
	private final String GOALS_PANEL = "GOALS_PANEL";
	private final String NO_GOALS_PANEL = "NO_GOALS_PANEL";

	private final String CONTENT_PANEL = "CONTENT_PANEL";
	private final String NOT_LOGGED_IN_PANEL = "NOT_LOGGED_IN_PANEL";

	private final CardLayout panelCardLayout = new CardLayout();
	private final CardLayout goalsCardLayout = new CardLayout();

	// Holds everything in the panel
	private final JPanel mainContainer = new JPanel();
	// Holds the content container & not logged in panel
	private final JPanel panelContainer = new JPanel(panelCardLayout);
	private final PluginErrorPanel notLoggedInPanel = new PluginErrorPanel();

	// Holds the tabgroup & current view (goals or edit tab)
	private final JPanel contentContainer = new JPanel();
	// Holds the goal list or the add goal panel
	private final JPanel currentViewContainer = new JPanel();

	private final PluginErrorPanel noGoalsPanel = new PluginErrorPanel();
	// Contains the actual goals panel and the no goals error panel
	private final JPanel goalsContainer = new JPanel(goalsCardLayout);
	// Holds all the goal cards
	private final JPanel goalListPanel = new JPanel();

	private ItemGoalsAddPanel addGoalPanel;

	private final MaterialTabGroup tabGroup = new MaterialTabGroup(currentViewContainer);

	@Inject
	private ClientThread clientThread;

	@Inject
	private ItemGoalsPlugin plugin;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	ItemGoalsPanel(ItemGoalsPlugin plugin, ClientThread clientThread, ItemManager itemManager, ScheduledExecutorService executor)
	{
		// Disable wrapping since we make our own scrollpanes for the goals/item search results
		super(false);

		this.plugin = plugin;
		this.clientThread = clientThread;
		this.itemManager = itemManager;
		this.executor = executor;

		init();
	}

	private void init()
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		mainContainer.setLayout(new BorderLayout());

		contentContainer.setLayout(new BorderLayout());

		currentViewContainer.setLayout(new BorderLayout());
		currentViewContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

		goalListPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		goalListPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		// Wrapper for the not logged in error panel
		JPanel notLoggedInWrapper = new JPanel();
		notLoggedInWrapper.setLayout(new BorderLayout());
		notLoggedInPanel.setContent("Item Goals", "Log in to view and edit your item goals.");
		notLoggedInWrapper.add(notLoggedInPanel, BorderLayout.NORTH);

		// Wrapper for the goals list
		JPanel goalsWrapper = new JPanel();
		goalsWrapper.setLayout(new BorderLayout());
		goalsWrapper.add(goalListPanel, BorderLayout.NORTH);

		// Give the goals list a scrollbar
		JScrollPane goalsScrollWrapper = new JScrollPane(goalsWrapper);
		goalsScrollWrapper.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		goalsScrollWrapper.getVerticalScrollBar().setBorder(new EmptyBorder(0, 5, 0, 0));
		goalsScrollWrapper.setBackground(ColorScheme.DARK_GRAY_COLOR);
		goalsScrollWrapper.setVisible(false);

		// Wrapper for the no goals error panel
		JPanel noGoalsWrapper = new JPanel();
		noGoalsWrapper.setLayout(new BorderLayout());
		noGoalsPanel.setContent("Item Goals", "You have not set any item goals.");
		noGoalsWrapper.add(noGoalsPanel, BorderLayout.NORTH);

		// Add goal panel / "Edit" tab
		addGoalPanel = new ItemGoalsAddPanel(plugin, itemManager, clientThread, executor);

		rebuildGoals();

		goalsContainer.add(goalsScrollWrapper, GOALS_PANEL);
		goalsContainer.add(noGoalsWrapper, NO_GOALS_PANEL);
		goalsCardLayout.show(goalsContainer, plugin.hasNoGoals() ? NO_GOALS_PANEL : GOALS_PANEL);

		MaterialTab goalsTab = new MaterialTab("Goals", tabGroup, goalsContainer);
		MaterialTab editTab = new MaterialTab("Edit", tabGroup, addGoalPanel);

		tabGroup.setBorder(new EmptyBorder(5, 0, 0, 0));
		tabGroup.addTab(goalsTab);
		tabGroup.addTab(editTab);
		tabGroup.select(goalsTab);

		contentContainer.add(tabGroup, BorderLayout.NORTH);
		contentContainer.add(currentViewContainer, BorderLayout.CENTER);

		panelContainer.add(contentContainer, CONTENT_PANEL);
		panelContainer.add(notLoggedInWrapper, NOT_LOGGED_IN_PANEL);
		panelCardLayout.show(panelContainer, NOT_LOGGED_IN_PANEL);

		mainContainer.add(panelContainer, BorderLayout.CENTER);
		add(mainContainer, BorderLayout.CENTER);
	}

	protected void setLoggedIn(boolean isLoggedIn)
	{
		panelCardLayout.show(panelContainer, isLoggedIn ? CONTENT_PANEL : NOT_LOGGED_IN_PANEL);
	}

	protected void rebuildGoals()
	{
		goalListPanel.removeAll();

		for (ItemGoal goal : plugin.getUserGoals())
		{
			ItemGoalsGoalPanel goalPanel = new ItemGoalsGoalPanel(plugin, goal, itemManager);
			goalListPanel.add(goalPanel);
		}

		// Rebuild the search results too, since they appear differently based on if there's an active goal for the item
		addGoalPanel.rebuildResults(true);

		goalListPanel.revalidate();
		goalListPanel.repaint();

		goalsCardLayout.show(goalsContainer, plugin.hasNoGoals() ? NO_GOALS_PANEL : GOALS_PANEL);
	}

	protected void fullReset()
	{
		goalListPanel.removeAll();
		addGoalPanel.reset();
		goalListPanel.revalidate();
		goalListPanel.repaint();

		goalsCardLayout.show(goalsContainer, NO_GOALS_PANEL);
	}
}
