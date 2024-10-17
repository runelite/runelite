/*
 * Copyright (c) 2023 Abex
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
package net.runelite.client.plugins.config;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;
import net.runelite.client.util.ImageUtil;

@Singleton
class TopLevelConfigPanel extends PluginPanel
{
	private final MaterialTabGroup tabGroup;
	private final CardLayout layout;
	private final JPanel content;

	private final EventBus eventBus;
	private final PluginListPanel pluginListPanel;
	private final MaterialTab pluginListPanelTab;

	private boolean active = false;
	private PluginPanel current;
	private boolean removeOnTabChange;

	@Inject
	TopLevelConfigPanel(
		EventBus eventBus,
		PluginListPanel pluginListPanel,
		ProfilePanel profilePanel,
		Provider<PluginHubPanel> pluginHubPanelProvider
	)
	{
		super(false);

		this.eventBus = eventBus;

		tabGroup = new MaterialTabGroup();
		tabGroup.setLayout(new GridLayout(1, 0, 7, 7));
		tabGroup.setBorder(new EmptyBorder(10, 10, 0, 10));

		content = new JPanel();
		layout = new CardLayout();
		content.setLayout(layout);

		setLayout(new BorderLayout());
		add(tabGroup, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);

		this.pluginListPanel = pluginListPanel;
		pluginListPanelTab = addTab(pluginListPanel.getMuxer(), "config_icon_lg.png", "Configuration");

		addTab(profilePanel, "profile_icon.png", "Profiles");

		addTab(pluginHubPanelProvider, "plugin_hub_icon.png", "Plugin Hub");

		tabGroup.select(pluginListPanelTab);
	}

	private MaterialTab addTab(PluginPanel panel, String image, String tooltip)
	{
		MaterialTab mt = new MaterialTab(
			new ImageIcon(ImageUtil.loadImageResource(TopLevelConfigPanel.class, image)),
			tabGroup, null);
		mt.setToolTipText(tooltip);
		tabGroup.addTab(mt);

		content.add(image, panel.getWrappedPanel());
		eventBus.register(panel);

		mt.setOnSelectEvent(() ->
		{
			switchTo(image, panel, false);
			return true;
		});
		return mt;
	}

	private MaterialTab addTab(Provider<? extends PluginPanel> panelProvider, String image, String tooltip)
	{
		MaterialTab mt = new MaterialTab(
			new ImageIcon(ImageUtil.loadImageResource(TopLevelConfigPanel.class, image)),
			tabGroup, null);
		mt.setToolTipText(tooltip);
		tabGroup.addTab(mt);

		mt.setOnSelectEvent(() ->
		{
			PluginPanel panel = panelProvider.get();
			content.add(image, panel.getWrappedPanel());
			eventBus.register(panel);
			switchTo(image, panel, true);
			return true;
		});
		return mt;
	}

	private void switchTo(String cardName, PluginPanel panel, boolean removeOnTabChange)
	{
		boolean doRemove = this.removeOnTabChange;
		PluginPanel prevPanel = current;
		if (active)
		{
			prevPanel.onDeactivate();
			panel.onActivate();
		}

		current = panel;
		this.removeOnTabChange = removeOnTabChange;

		layout.show(content, cardName);

		if (doRemove)
		{
			content.remove(prevPanel.getWrappedPanel());
			eventBus.unregister(prevPanel);
		}

		content.revalidate();
	}

	@Override
	public void onActivate()
	{
		active = true;
		current.onActivate();
	}

	@Override
	public void onDeactivate()
	{
		active = false;
		current.onDeactivate();
	}

	public void openConfigurationPanel(String name)
	{
		tabGroup.select(pluginListPanelTab);
		pluginListPanel.openConfigurationPanel(name);
	}

	public void openConfigurationPanel(Plugin plugin)
	{
		tabGroup.select(pluginListPanelTab);
		pluginListPanel.openConfigurationPanel(plugin);
	}

	public void openWithFilter(String filter)
	{
		tabGroup.select(pluginListPanelTab);
		pluginListPanel.openWithFilter(filter);
	}
}
