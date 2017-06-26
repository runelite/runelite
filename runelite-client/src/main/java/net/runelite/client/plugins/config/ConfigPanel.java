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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;

import javax.swing.border.EmptyBorder;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.PluginPanel;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigPanel extends PluginPanel
{
	private static final Logger logger = LoggerFactory.getLogger(ConfigPanel.class);

	private static final EmptyBorder BORDER_PADDING = new EmptyBorder(6, 6, 6, 6);
	private static final int TEXT_FIELD_WIDTH = 12;
	private static final int SPINNER_FIELD_WIDTH = 10;

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
		panel.setBorder(BORDER_PADDING);
		panel.setLayout(new GridLayout(0, 1, 0, 3));
		panel.add(new JLabel("Plugin Configuration", SwingConstants.CENTER));

		ConfigManager configManager = runelite.getConfigManager();
		Collection<ConfigDescriptor> config = getConfig();
		for (ConfigDescriptor cd : config)
		{
			JPanel groupPanel = new JPanel();
			groupPanel.setLayout(new BorderLayout());
			JButton viewGroupItemsButton = new JButton(cd.getGroup().name());
			viewGroupItemsButton.addActionListener(ae -> openGroupConfigPanel(cd, configManager));
			groupPanel.add(viewGroupItemsButton);
			panel.add(groupPanel);
		}

		//Make the panel scrollable
		scrollPane = new JScrollPane(panel);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); //Otherwise scrollspeed is really slow
		return scrollPane;
	}

	private void changeConfiguration(JComponent component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		ConfigManager configManager = runelite.getConfigManager();
		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), "" + checkbox.isSelected());
		}

		if (component instanceof JSpinner)
		{
			JSpinner spinner = (JSpinner) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), "" + spinner.getValue());
		}

		if (component instanceof JTextField)
		{
			JTextField textField = (JTextField) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), textField.getText());
		}
	}

	private void openGroupConfigPanel(ConfigDescriptor cd, ConfigManager configManager)
	{
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(BORDER_PADDING);
		itemPanel.setLayout(new GridLayout(0, 1, 0, 6));
		itemPanel.add(new JLabel(cd.getGroup().name() + " Configuration", SwingConstants.CENTER));

		for (ConfigItemDescriptor cid : cd.getItems())
		{
			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			item.add(new JLabel(cid.getItem().name()), BorderLayout.CENTER);

			if (cid.getType() == boolean.class)
			{
				JCheckBox checkbox = new JCheckBox();
				checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
				checkbox.addActionListener(ae -> changeConfiguration(checkbox, cd, cid));

				item.add(checkbox, BorderLayout.EAST);
			}

			if (cid.getType() == int.class)
			{
				int value = Integer.parseInt(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));

				SpinnerModel model = new SpinnerNumberModel(value, 0, Integer.MAX_VALUE, 1);
				JSpinner spinner = new JSpinner(model);
				Component editor = spinner.getEditor();
				JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
				spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
				spinner.addChangeListener(ce -> changeConfiguration(spinner, cd, cid));

				item.add(spinner, BorderLayout.EAST);
			}

			if (cid.getType() == String.class)
			{
				JTextField textField = new JTextField("", TEXT_FIELD_WIDTH);
				textField.setText(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName()));
				textField.addFocusListener(new FocusListener()
				{
					@Override
					public void focusGained(FocusEvent e)
					{
					}

					@Override
					public void focusLost(FocusEvent e)
					{
						changeConfiguration(textField, cd, cid);
					}
				});

				item.add(textField, BorderLayout.EAST);
			}

			itemPanel.add(item);
		}

		JButton backButton = new JButton("Back");
		backButton.addActionListener(this::getBackButtonListener);
		itemPanel.add(backButton);

		removeAll();
		updateUI();
		add(itemPanel, BorderLayout.NORTH);
	}

	public void getBackButtonListener(ActionEvent e)
	{
		removeAll();
		updateUI();

		add(scrollPane, BorderLayout.NORTH);
	}

}
