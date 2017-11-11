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
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
	private static final int TEXT_FIELD_WIDTH = 7;
	private static final int SPINNER_FIELD_WIDTH = 6;

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

	public void init()
	{
		add(createConfigPanel(), BorderLayout.NORTH);
	}

	private List<ConfigDescriptor> getConfig()
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
		List<ConfigDescriptor> config = getConfig();

		// Sort by name
		Comparator<ConfigDescriptor> comparator = (ConfigDescriptor left, ConfigDescriptor right) -> left.getGroup().name().compareTo(right.getGroup().name());
		config.sort(comparator);

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

		if (component instanceof JColorChooser)
		{
			JColorChooser jColorChooser = (JColorChooser) component;
			configManager.setConfiguration(cd.getGroup().keyName(), cid.getItem().keyName(), String.valueOf(jColorChooser.getColor().getRGB()));
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
			if (cid.getItem().hidden())
			{
				continue;
			}

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

			if (cid.getType() == Color.class)
			{
				JButton colorPicker = new JButton("Pick a color");
				colorPicker.setFocusable(false);
				colorPicker.setBackground(Color.decode(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
				colorPicker.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						final JFrame parent = new JFrame();
						parent.setLocation(RuneLite.getRunelite().getGui().getX(), RuneLite.getRunelite().getGui().getY());
						JColorChooser jColorChooser = new JColorChooser(Color.decode(configManager.getConfiguration(cd.getGroup().keyName(), cid.getItem().keyName())));
						jColorChooser.getSelectionModel().addChangeListener(new ChangeListener()
						{
							@Override
							public void stateChanged(ChangeEvent e)
							{
								colorPicker.setBackground(jColorChooser.getColor());
							}
						});
						parent.addWindowListener(new WindowAdapter()
						{
							@Override
							public void windowClosing(WindowEvent e)
							{
								changeConfiguration(jColorChooser, cd, cid);
							}
						});
						parent.add(jColorChooser);
						parent.pack();
						parent.setVisible(true);
					}
				});
				item.add(colorPicker, BorderLayout.EAST);
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
