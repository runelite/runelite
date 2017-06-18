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
package net.runelite.client.plugins.config;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;

import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.PluginPanel;
import static net.runelite.client.ui.PluginPanel.PANEL_HEIGHT;
import static net.runelite.client.ui.PluginPanel.PANEL_WIDTH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigPanel extends PluginPanel
{
	private static final Logger logger = LoggerFactory.getLogger(ConfigPanel.class);

	private final RuneLite runelite = RuneLite.getRunelite();

	private JScrollPane scrollPane;

	public ConfigPanel()
	{
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setLayout(new BorderLayout());
		setVisible(true);
	}

	@Override
	public boolean equals(Object other)
	{
		return other.getClass() == this.getClass();
	}

	public void init()
	{
		add(createConfigPanel(), BorderLayout.NORTH);
	}

	private Collection<ConfigDescriptor> getConfig()
	{
		List<ConfigDescriptor> list = new ArrayList<>();
		for (Object config : runelite.getConfigManager().getConfigProxies())
		{
			ConfigManager configManager = runelite.getConfigManager();
			ConfigDescriptor configDescriptor = configManager.getConfigDescriptor(config);

			list.add(configDescriptor);
		}
		return list;
	}

	private JComponent createConfigPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Plugin configuration"), BorderLayout.NORTH);
		ConfigManager configManager = runelite.getConfigManager();
		Collection<ConfigDescriptor> config = getConfig();
		for (ConfigDescriptor cd : config)
		{
			JPanel groupPanel = new JPanel();
			groupPanel.setLayout(new BorderLayout());
			JButton viewGroupItemsButton = new JButton(cd.getGroup().name());
			viewGroupItemsButton.addActionListener(ae -> openGroupConfigPanel(cd, configManager));
			groupPanel.add(viewGroupItemsButton, BorderLayout.NORTH);
			panel.add(groupPanel);
		}
		//Make the panel scrollable
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); //Otherwise scrollspeed is really slow
		this.scrollPane = scrollPane;
		return scrollPane;
	}

	private void changeConfiguration(ActionEvent ae, JCheckBox checkbox, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		ConfigManager configManager = runelite.getConfigManager();
		configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), "" + checkbox.isSelected());
	}

	private void openGroupConfigPanel (ConfigDescriptor cd, ConfigManager configManager) {
		JPanel itemPanel = new JPanel();
		itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
		itemPanel.add(new JLabel(cd.getGroup().name() + " Configuration"), BorderLayout.NORTH);

		for (ConfigItemDescriptor cid : cd.getItems())
		{
			JPanel item = new JPanel();
			item.setLayout(new BoxLayout(item, BoxLayout.X_AXIS));
			item.add(new JLabel(cid.getItem().name()));

			if (cid.getType() == boolean.class)
			{
				JCheckBox checkbox = new JCheckBox();
				checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
				checkbox.addActionListener(ae -> changeConfiguration(ae, checkbox, cd, cid));

				item.add(checkbox);
			}

			itemPanel.add(item);
		}

		JButton backButton = new JButton("Back");
		backButton.addActionListener(getBackButtonListener());
		itemPanel.add(backButton, BorderLayout.NORTH);

		removeAll();
		updateUI();
		add(itemPanel, BorderLayout.NORTH);
	}

	public ActionListener getBackButtonListener() {
		ConfigPanel self = this;
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				updateUI();

				if (self.scrollPane == null) {
					init();
					return;
				}

				add(self.scrollPane, BorderLayout.NORTH);
			}
		};
	}

}
