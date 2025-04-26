/*
 * Copyright (c) 2025, Hamish <https://github.com/DustyRealm>
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

import com.google.common.primitives.Ints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.RuneLiteFont;
import net.runelite.client.config.FontStyle;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.UnitFormatterFactory;
import net.runelite.client.ui.components.TitleCaseListCellRenderer;
import net.runelite.client.util.SwingUtil;
import net.runelite.client.util.Text;

@AllArgsConstructor
final class TruncatedTitleCaseListCellRenderer extends TitleCaseListCellRenderer
{
	private final int maxLength;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (component instanceof JLabel)
		{
			JLabel label = (JLabel) component;
			if (label.getText().length() > maxLength)
			{
				String shortenedText = label.getText().substring(0, maxLength) + "…";
				label.setText(shortenedText);
			}
		}
		return component;
	}
}

@Slf4j
class FontConfigPanel extends PluginPanel
{
	private final ConfigManager configManager;

	private final JLabel title;
	private final FixedWidthPanel mainPanel;

	private ConfigDescriptor configDescriptor;
	private ConfigItemDescriptor configItemDescriptor;

	@Inject
	private FontConfigPanel(
		ConfigManager configManager,
		PluginListPanel pluginList
	)
	{
		super(false);

		this.configManager = configManager;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		topPanel.setLayout(new BorderLayout(0, BORDER_OFFSET));
		add(topPanel, BorderLayout.NORTH);

		mainPanel = new FixedWidthPanel();
		mainPanel.setBorder(new EmptyBorder(8, 10, 10, 10));
		mainPanel.setLayout(new DynamicGridLayout(0, 1, 0, 5));
		mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel contentsPanel = new FixedWidthPanel();
		contentsPanel.setLayout(new BorderLayout());
		contentsPanel.add(mainPanel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(contentsPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);

		JButton topPanelBackButton = new JButton(ConfigPanel.BACK_ICON);
		SwingUtil.removeButtonDecorations(topPanelBackButton);
		topPanelBackButton.setPreferredSize(new Dimension(22, 0));
		topPanelBackButton.setBorder(new EmptyBorder(0, 0, 0, 5));
		topPanelBackButton.addActionListener(e -> pluginList.getMuxer().popState());
		topPanelBackButton.setToolTipText("Back");
		topPanel.add(topPanelBackButton, BorderLayout.WEST);

		title = new JLabel();
		title.setForeground(Color.WHITE);
		topPanel.add(title, BorderLayout.CENTER);
	}

	private void item(String name, String description, Component component)
	{
		JPanel item = new JPanel();
		item.setLayout(new BorderLayout());
		item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
		JLabel configEntryName = new JLabel(name);
		configEntryName.setForeground(Color.WHITE);
		if (!"".equals(description))
		{
			configEntryName.setToolTipText("<html>" + name + ":<br>" + description + "</html>");
		}
		item.add(configEntryName, BorderLayout.CENTER);
		item.add(component, BorderLayout.EAST);
		mainPanel.add(item);
	}

	private <T> JComboBox<T> combobox(T[] options, T value)
	{
		JComboBox<T> box = new JComboBox<>(options);
		// set renderer prior to calling box.getPreferredSize(), since it will invoke the renderer
		// to build components for each combobox element in order to compute the display size of the
		// combobox
		box.setRenderer(new TruncatedTitleCaseListCellRenderer(28));
		box.setPreferredSize(new Dimension(box.getPreferredSize().width, 22));
		box.setSelectedItem(value);
		// use TitleCaseListCellRenderer capitalization logic for tooltip
		box.setToolTipText(value instanceof Enum ? Text.titleCase((Enum<?>) value) : value.toString());

		box.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				box.setToolTipText(box.getSelectedItem() instanceof Enum ? Text.titleCase((Enum<?>) box.getSelectedItem()) : box.getSelectedItem().toString());
			}
		});

		return box;
	}

	private JSpinner createIntSpinner(int min, int max, int value, String unit)
	{
		// Config may previously have been out of range
		value = Ints.constrainToRange(value, min, max);

		SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
		JSpinner spinner = new JSpinner(model);
		Component editor = spinner.getEditor();
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
		spinnerTextField.setColumns(6);
		spinnerTextField.setFormatterFactory(new UnitFormatterFactory(spinnerTextField.getFormatterFactory(), unit));
		return spinner;
	}

	void init(ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		title.setText(cid.name());

		configDescriptor = cd;
		configItemDescriptor = cid;

		RuneLiteFont runeLiteFont = loadRuneLiteFont();
		rebuild(runeLiteFont);
	}

	private void rebuild(RuneLiteFont runeLiteFont)
	{
		mainPanel.removeAll();

		List<String> fontOptions = new ArrayList<>();
		fontOptions.addAll(FontManager.RUNESCAPE_FONTS);
		fontOptions.add("---");
		fontOptions.addAll(FontManager.CUSTOM_FONTS);
		fontOptions.add("---");
		fontOptions.addAll(FontManager.SYSTEM_FONTS);

		var comboboxFont = combobox(fontOptions.toArray(), runeLiteFont.getFamily());
		comboboxFont.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				var f = loadRuneLiteFont();
				saveRuneLiteFont(f.withFamily((String) comboboxFont.getSelectedItem()));
			}
		});
		item("Font", "Configures the font.", comboboxFont);

		var comboboxStyle = combobox(FontStyle.class.getEnumConstants(), runeLiteFont.getStyle());
		comboboxStyle.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				var f = loadRuneLiteFont();
				saveRuneLiteFont(f.withStyle((FontStyle) comboboxStyle.getSelectedItem()));
			}
		});
		item("Style", "Configures the font style.", comboboxStyle);

		var spinnerSize = createIntSpinner(1, Integer.MAX_VALUE, runeLiteFont.getSize(), "pt");
		spinnerSize.addChangeListener(ce ->
		{
			var f = loadRuneLiteFont();
			saveRuneLiteFont(f.withSize((int) spinnerSize.getValue()));
		});
		item("Size", "Configures the font size.", spinnerSize);
	}

	private RuneLiteFont loadRuneLiteFont()
	{
		return configManager.getConfiguration(configDescriptor.getGroup().value(), configItemDescriptor.getItem().keyName(), RuneLiteFont.class);
	}

	private void saveRuneLiteFont(RuneLiteFont runeLiteFont)
	{
		configManager.setConfiguration(configDescriptor.getGroup().value(), configItemDescriptor.getItem().keyName(), runeLiteFont);
	}
}
