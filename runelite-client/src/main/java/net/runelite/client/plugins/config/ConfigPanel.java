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

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.text.JTextComponent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.util.Text;
import net.runelite.client.config.Button;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.ModifierlessKeybind;
import net.runelite.client.config.Range;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ComboBoxListRenderer;
import net.runelite.client.ui.components.MinimumSizedPanel;
import net.runelite.client.ui.components.colorpicker.ColorPickerManager;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.MiscUtils;
import net.runelite.client.util.SwingUtil;

@Slf4j
class ConfigPanel extends PluginPanel
{
	private static final int SPINNER_FIELD_WIDTH = 6;
	private static final int OFFSET = 6;

	private static final ImageIcon BACK_ICON;
	private static final ImageIcon BACK_ICON_HOVER;
	private static final ImageIcon SECTION_EXPAND_ICON;
	private static final ImageIcon SECTION_EXPAND_ICON_HOVER;
	private static final ImageIcon SECTION_RETRACT_ICON;
	private static final ImageIcon SECTION_RETRACT_ICON_HOVER;

	private final JScrollPane scrollPane;
	private final FixedWidthPanel mainPanel;
	private final JLabel title;
	private final PluginToggleButton pluginToggle;

	@Inject
	private PluginListPanel pluginList;

	@Inject
	private ConfigManager configManager;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ColorPickerManager colorPickerManager;

	private PluginConfigurationDescriptor pluginConfig = null;
	private final Map<String, JPanel> sectionWidgets = new HashMap<>();
	private final Map<String, JPanel> titleSectionWidgets = new HashMap<>();

	static
	{
		final BufferedImage backIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "config_back_icon.png");
		BACK_ICON = new ImageIcon(backIcon);
		BACK_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(backIcon, -100));

		final BufferedImage orangeBackIcon = ImageUtil.fillImage(backIcon, ColorScheme.BRAND_BLUE);

		final BufferedImage sectionRetractIcon = ImageUtil.rotateImage(orangeBackIcon, Math.PI * 1.5);
		SECTION_RETRACT_ICON = new ImageIcon(sectionRetractIcon);
		SECTION_RETRACT_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(sectionRetractIcon, -100));

		final BufferedImage sectionExpandIcon = ImageUtil.rotateImage(orangeBackIcon, Math.PI);
		SECTION_EXPAND_ICON = new ImageIcon(sectionExpandIcon);
		SECTION_EXPAND_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(sectionExpandIcon, -100));
	}

	public ConfigPanel()
	{
		super(false);

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

		JPanel northPanel = new FixedWidthPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(mainPanel, BorderLayout.NORTH);

		scrollPane = new JScrollPane(northPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);

		JButton topPanelBackButton = new JButton(BACK_ICON);
		topPanelBackButton.setRolloverIcon(BACK_ICON_HOVER);
		SwingUtil.removeButtonDecorations(topPanelBackButton);
		topPanelBackButton.setPreferredSize(new Dimension(22, 0));
		topPanelBackButton.setBorder(new EmptyBorder(0, 0, 0, 5));
		topPanelBackButton.addActionListener(e -> pluginList.getMuxer().popState());
		topPanelBackButton.setToolTipText("Back");
		topPanel.add(topPanelBackButton, BorderLayout.WEST);

		pluginToggle = new PluginToggleButton();
		topPanel.add(pluginToggle, BorderLayout.EAST);
		title = new JLabel();
		title.setForeground(Color.WHITE);

		topPanel.add(title);
	}

	void init(PluginConfigurationDescriptor pluginConfig)
	{
		assert this.pluginConfig == null;
		this.pluginConfig = pluginConfig;

		String name = pluginConfig.getName();
		title.setText(name);
		title.setForeground(Color.WHITE);
		title.setToolTipText("<html>" + name + ":<br>" + pluginConfig.getDescription() + "</html>");

		if (pluginConfig.getPlugin() != null)
		{
			pluginToggle.setSelected(pluginManager.isPluginEnabled(pluginConfig.getPlugin()));
			pluginToggle.addItemListener(i ->
			{
				if (pluginToggle.isSelected())
				{
					pluginList.startPlugin(pluginConfig.getPlugin());
				}
				else
				{
					pluginList.stopPlugin(pluginConfig.getPlugin());
				}
			});
		}
		else
		{
			pluginToggle.setVisible(false);
		}

		rebuild(false);
	}

	private void getSections(ConfigDescriptor cd)
	{
		for (ConfigSection cs : cd.getSections())
		{
			final MinimumSizedPanel section = new MinimumSizedPanel();
			section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
			section.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

			String name = cs.name();
			String description = cs.description();

			JLabel headerLabel = new JLabel(cs.name());
			headerLabel.setFont(FontManager.getRunescapeFont());
			headerLabel.setForeground(ColorScheme.BRAND_BLUE);
			if (!description.equals(""))
			{
				headerLabel.setToolTipText("<html>" + name + ":<br>" + description + "</html>");
			}
			headerLabel.setPreferredSize(new Dimension(PANEL_WIDTH, (int) headerLabel.getPreferredSize().getHeight()));

			final boolean state = Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().value(), cs.keyName()));

			final JToggleButton collapse = new JToggleButton(SECTION_EXPAND_ICON, state);

			SwingUtil.removeButtonDecorations(collapse);
			collapse.setRolloverIcon(SECTION_EXPAND_ICON_HOVER);
			collapse.setSelectedIcon(SECTION_RETRACT_ICON);
			collapse.setRolloverSelectedIcon(SECTION_RETRACT_ICON_HOVER);
			collapse.setToolTipText(state ? "Retract" : "Expand");
			collapse.setPreferredSize(new Dimension(20, 20));
			collapse.setFont(collapse.getFont().deriveFont(16.0f));
			collapse.setBorder(null);
			collapse.setMargin(new Insets(0, 0, 0, 0));

			headerLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

			item.add(collapse, BorderLayout.WEST);
			item.add(headerLabel, BorderLayout.CENTER);

			final JPanel sectionContents = new JPanel();
			sectionContents.setLayout(new DynamicGridLayout(0, 1, 0, 5));
			sectionContents.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
			sectionContents.setBorder(new EmptyBorder(OFFSET, 5, 0, 0));
			section.add(item, BorderLayout.NORTH);
			section.add(sectionContents, BorderLayout.SOUTH);

			sectionContents.setVisible(state);

			// Add listeners to each part of the header so that it's easier to toggle them
			final MouseAdapter adapter = new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					toggleSection(cd, cs, collapse, sectionContents);
				}
			};
			collapse.addActionListener(e -> toggleSection(cd, cs, collapse, sectionContents));
			headerLabel.addMouseListener(adapter);

			sectionWidgets.put(cs.keyName(), sectionContents);

			// Allow for sub-sections
			JPanel parentSection = sectionWidgets.get(cs.section());
			if (parentSection == null)
			{
				mainPanel.add(section);
			}
			else
			{
				parentSection.add(section);
			}
		}
	}

	private void getTitleSections(ConfigDescriptor cd)
	{
		for (ConfigTitleSection cs : cd.getTitleSections())
		{
			final MinimumSizedPanel titleSection = new MinimumSizedPanel();
			titleSection.setLayout(new BoxLayout(titleSection, BoxLayout.Y_AXIS));
			titleSection.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));

			Border border = item.getBorder();
			Border margin = new EmptyBorder(10, 0, 0, 0);
			item.setBorder(new CompoundBorder(border, margin));

			JLabel configEntryName = new JLabel(cs.name());
			configEntryName.setPreferredSize(new Dimension(PANEL_WIDTH, (int) configEntryName.getPreferredSize().getHeight()));
			configEntryName.setForeground(ColorScheme.BRAND_BLUE);
			item.add(configEntryName, BorderLayout.NORTH);

			final JPanel sectionContents = new JPanel();
			sectionContents.setLayout(new DynamicGridLayout(0, 1, 0, 5));
			sectionContents.setMinimumSize(new Dimension(0, 0));
			sectionContents.setBorder(new EmptyBorder(OFFSET, 5, 0, 0));

			titleSection.add(item, BorderLayout.NORTH);
			titleSection.add(sectionContents, BorderLayout.SOUTH);

			titleSectionWidgets.put(cs.keyName(), sectionContents);

			// Allow for sub-sections
			JPanel parentTitleSection = titleSectionWidgets.get(cs.titleSection());
			JPanel parentSection = sectionWidgets.get(cs.section());

			if (parentTitleSection != null)
			{
				parentTitleSection.add(titleSection);
			}
			else if (parentSection != null)
			{
				parentSection.add(titleSection);
			}
			else
			{
				mainPanel.add(titleSection);
			}
		}
	}


	private Boolean parse(ConfigItem item, String value)
	{
		try
		{
			Method parse = item.clazz().getMethod(item.method(), String.class);

			return (boolean) parse.invoke(null, value);
		}
		catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex)
		{
			log.error("Parsing failed: {}", ex.getMessage());
		}

		return null;
	}

	private void parseLabel(ConfigItem item, JLabel label, String value)
	{
		Boolean result = parse(item, value);

		if (result == null)
		{
			label.setForeground(Color.RED);
			label.setText("Parsing failed");
		}
		else if (result)
		{
			label.setForeground(Color.GREEN);
			label.setText("Valid input");
		}
		else
		{
			label.setForeground(Color.RED);
			label.setText("Invalid input");
		}
	}

	private void toggleSection(ConfigDescriptor cd, ConfigSection cs, JToggleButton button, JPanel contents)
	{
		boolean newState = !contents.isVisible();
		button.setSelected(newState);
		contents.setVisible(newState);
		configManager.setConfiguration(cd.getGroup().value(), cs.keyName(), newState);
		button.setToolTipText(newState ? "Retract" : "Expand");
		SwingUtilities.invokeLater(() ->
		{
			contents.revalidate();
			contents.repaint();
		});
	}

	private void rebuild(boolean refresh)
	{
		int scrollBarPosition = scrollPane.getVerticalScrollBar().getValue();

		mainPanel.removeAll();

		ConfigDescriptor cd = pluginConfig.getConfigDescriptor();
		assert cd != null;

		getSections(cd);
		getTitleSections(cd);

		List<JButton> buttons = new ArrayList<>();

		for (ConfigItemDescriptor cid : cd.getItems())
		{
			if (cid == null)
			{
				continue; // Ignore main 'parent'
			}

			Boolean unhide = cid.getItem().hidden();
			Boolean hide = !cid.getItem().hide().isEmpty();

			if (unhide || hide)
			{
				boolean show = false;

				List<String> itemHide = Splitter
					.onPattern("\\|\\|")
					.trimResults()
					.omitEmptyStrings()
					.splitToList(String.format("%s || %s", cid.getItem().unhide(), cid.getItem().hide()));

				for (ConfigItemDescriptor cid2 : cd.getItems())
				{
					if (itemHide.contains(cid2.getItem().keyName()))
					{
						if (cid2.getType() == boolean.class)
						{
							show = Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().value(), cid2.getItem().keyName()));
						}
						else if (cid2.getType().isEnum())
						{
							@SuppressWarnings("unchecked") Class<? extends Enum> type = (Class<? extends Enum>) cid2.getType();
							try
							{
								@SuppressWarnings("unchecked") Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().value(), cid2.getItem().keyName()));
								if (!cid.getItem().unhideValue().equals(""))
								{
									List<String> unhideValue = Splitter
										.onPattern("\\|\\|")
										.trimResults()
										.omitEmptyStrings()
										.splitToList(cid.getItem().unhideValue());

									show = unhideValue.contains(selectedItem.toString());
								}
								else if (!cid.getItem().hideValue().equals(""))
								{
									List<String> hideValue = Splitter
										.onPattern("\\|\\|")
										.trimResults()
										.omitEmptyStrings()
										.splitToList(cid.getItem().hideValue());

									show = !hideValue.contains(selectedItem.toString());
								}
							}
							catch (IllegalArgumentException ex)
							{
								log.info("So bad, so sad: {}", ex.toString());
							}
						}
					}

					if (show)
					{
						break;
					}
				}

				if ((unhide && !show) || (hide && show))
				{
					continue;
				}
			}

			if (cid.getType() == Button.class)
			{
				try
				{
					ConfigItem item = cid.getItem();

					JButton button = new JButton(item.name());

					Class<ActionListener> actionListener = (Class<ActionListener>) item.clazz();

					button.addActionListener(actionListener.newInstance());
					buttons.add(button);
				}
				catch (IllegalAccessException | InstantiationException ex)
				{
					log.error("Adding action listener failed: {}", ex.getMessage());
				}

				continue;
			}

			JPanel item = new JPanel();
			item.setLayout(new BorderLayout());
			item.setMinimumSize(new Dimension(PANEL_WIDTH, 0));
			String name = cid.getItem().name();
			JLabel configEntryName = new JLabel(name);
			configEntryName.setForeground(Color.WHITE);
			configEntryName.setToolTipText("<html>" + name + ":<br>" + cid.getItem().description() + "</html>");
			item.add(configEntryName, cid.getType() != String.class ? BorderLayout.CENTER : BorderLayout.NORTH);

			if (cid.getType() == boolean.class)
			{
				JCheckBox checkbox = new JCheckBox();
				checkbox.setBackground(ColorScheme.LIGHT_GRAY_COLOR);
				checkbox.setSelected(Boolean.parseBoolean(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName())));
				checkbox.addActionListener(ae -> changeConfiguration(checkbox, cd, cid));

				item.add(checkbox, BorderLayout.EAST);
			}

			if (cid.getType() == int.class)
			{
				int value = Integer.parseInt(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));

				Range range = cid.getRange();
				int min = 0, max = Integer.MAX_VALUE;
				if (range != null)
				{
					min = range.min();
					max = range.max();
				}

				// Config may previously have been out of range
				value = MiscUtils.clamp(value, min, max);

				if (max < Integer.MAX_VALUE)
				{
					JLabel sliderValueLabel = new JLabel();
					JSlider slider = new JSlider(min, max, value);
					sliderValueLabel.setText(String.valueOf(slider.getValue()));
					slider.setPreferredSize(new Dimension(80, 25));
					slider.setBackground(Color.WHITE);
					slider.addChangeListener((l) ->
						{
							sliderValueLabel.setText(String.valueOf(slider.getValue()));
							if (!slider.getValueIsAdjusting())
							{
								changeConfiguration(slider, cd, cid);
							}
						}
					);

					SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
					JSpinner spinner = new JSpinner(model);
					Component editor = spinner.getEditor();
					JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
					spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
					spinner.setUI(new BasicSpinnerUI()
					{
						protected Component createNextButton()
						{
							return null;
						}

						protected Component createPreviousButton()
						{
							return null;
						}
					});

					JPanel subPanel = new JPanel();
					subPanel.setPreferredSize(new Dimension(110, 25));
					subPanel.setLayout(new BorderLayout());

					spinner.addChangeListener((ce) ->
					{
						changeConfiguration(spinner, cd, cid);

						sliderValueLabel.setText(String.valueOf(spinner.getValue()));
						slider.setValue((Integer) spinner.getValue());

						subPanel.add(sliderValueLabel, BorderLayout.WEST);
						subPanel.add(slider, BorderLayout.EAST);
						subPanel.remove(spinner);

						validate();
						repaint();
					});

					sliderValueLabel.addMouseListener(new MouseAdapter()
					{
						public void mouseClicked(MouseEvent e)
						{
							spinner.setValue(slider.getValue());

							subPanel.remove(sliderValueLabel);
							subPanel.remove(slider);
							subPanel.add(spinner, BorderLayout.EAST);

							validate();
							repaint();

							final JTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
							tf.requestFocusInWindow();
							SwingUtilities.invokeLater(tf::selectAll);
						}
					});

					subPanel.add(sliderValueLabel, BorderLayout.WEST);
					subPanel.add(slider, BorderLayout.EAST);

					item.add(subPanel, BorderLayout.EAST);
				}
				else
				{
					SpinnerModel model = new SpinnerNumberModel(value, min, max, 1);
					JSpinner spinner = new JSpinner(model);
					Component editor = spinner.getEditor();
					JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
					spinnerTextField.setColumns(SPINNER_FIELD_WIDTH);
					spinner.addChangeListener(ce -> changeConfiguration(spinner, cd, cid));

					item.add(spinner, BorderLayout.EAST);
				}
			}

			if (cid.getType() == String.class)
			{
				JTextComponent textField;

				if (cid.getItem().secret())
				{
					textField = new JPasswordField();
				}
				else
				{
					final JTextArea textArea = new JTextArea();
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
					textField = textArea;
				}

				textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				textField.setText(configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));

				DeferredDocumentChangedListener listener = new DeferredDocumentChangedListener();
				listener.addChangeListener(e ->
				{
					ConfigItem configItem = cid.getItem();
					if (configItem.parse())
					{
						Boolean result = parse(configItem, textField.getText());

						if (result != null && result)
						{
							changeConfiguration(textField, cd, cid);
						}
					}
					else
					{
						changeConfiguration(textField, cd, cid);
					}
				});
				textField.getDocument().addDocumentListener(listener);

				if (cid.getItem().parse())
				{
					JLabel parsingLabel = new JLabel();
					parsingLabel.setHorizontalAlignment(SwingConstants.CENTER);
					parsingLabel.setPreferredSize(new Dimension(PANEL_WIDTH, 15));

					listener = new DeferredDocumentChangedListener();
					listener.addChangeListener(e ->
					{
						if (cid.getItem().parse())
						{
							parseLabel(cid.getItem(), parsingLabel, textField.getText());
						}
					});
					textField.getDocument().addDocumentListener(listener);

					item.add(textField, BorderLayout.CENTER);

					parseLabel(cid.getItem(), parsingLabel, textField.getText());
					item.add(parsingLabel, BorderLayout.SOUTH);
				}
				else
				{
					item.add(textField, BorderLayout.SOUTH);
				}
			}

			if (cid.getType() == Color.class)
			{
				String existing = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());

				Color existingColor;
				JButton colorPickerBtn;

				if (existing == null)
				{
					existingColor = Color.BLACK;
					colorPickerBtn = new JButton("Pick a color");
				}
				else
				{
					existingColor = ColorUtil.fromString(existing);
					colorPickerBtn = new JButton(ColorUtil.toHexColor(existingColor).toUpperCase());
				}

				colorPickerBtn.setFocusable(false);
				colorPickerBtn.setBackground(existingColor);
				colorPickerBtn.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						RuneliteColorPicker colorPicker = colorPickerManager.create(
							SwingUtilities.windowForComponent(ConfigPanel.this),
							colorPickerBtn.getBackground(),
							cid.getItem().name(),
							cid.getAlpha() == null);
						colorPicker.setLocation(getLocationOnScreen());
						colorPicker.setOnColorChange(c ->
						{
							colorPickerBtn.setBackground(c);
							colorPickerBtn.setText(ColorUtil.toHexColor(c).toUpperCase());
						});
						colorPicker.setOnClose(c -> changeConfiguration(colorPicker, cd, cid));
						colorPicker.setVisible(true);
					}
				});

				item.add(colorPickerBtn, BorderLayout.EAST);
			}

			if (cid.getType() == Dimension.class)
			{
				JPanel dimensionPanel = new JPanel();
				dimensionPanel.setLayout(new BorderLayout());

				String str = configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName());
				String[] splitStr = str.split("x");
				int width = Integer.parseInt(splitStr[0]);
				int height = Integer.parseInt(splitStr[1]);

				SpinnerModel widthModel = new SpinnerNumberModel(width, 0, Integer.MAX_VALUE, 1);
				JSpinner widthSpinner = new JSpinner(widthModel);
				Component widthEditor = widthSpinner.getEditor();
				JFormattedTextField widthSpinnerTextField = ((JSpinner.DefaultEditor) widthEditor).getTextField();
				widthSpinnerTextField.setColumns(4);

				SpinnerModel heightModel = new SpinnerNumberModel(height, 0, Integer.MAX_VALUE, 1);
				JSpinner heightSpinner = new JSpinner(heightModel);
				Component heightEditor = heightSpinner.getEditor();
				JFormattedTextField heightSpinnerTextField = ((JSpinner.DefaultEditor) heightEditor).getTextField();
				heightSpinnerTextField.setColumns(4);

				ChangeListener listener = e ->
					configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), widthSpinner.getValue() + "x" + heightSpinner.getValue());

				widthSpinner.addChangeListener(listener);
				heightSpinner.addChangeListener(listener);

				dimensionPanel.add(widthSpinner, BorderLayout.WEST);
				dimensionPanel.add(new JLabel(" x "), BorderLayout.CENTER);
				dimensionPanel.add(heightSpinner, BorderLayout.EAST);

				item.add(dimensionPanel, BorderLayout.EAST);
			}

			if (cid.getType().isEnum())
			{
				Class<? extends Enum> type = (Class<? extends Enum>) cid.getType();
				JComboBox box = new JComboBox(type.getEnumConstants());
				box.setPreferredSize(new Dimension(box.getPreferredSize().width, 25));
				box.setRenderer(new ComboBoxListRenderer());
				box.setForeground(Color.WHITE);
				box.setFocusable(false);
				box.setPrototypeDisplayValue("XXXXXXXX"); //sorry but this is the way to keep the size of the combobox in check.
				try
				{
					Enum selectedItem = Enum.valueOf(type, configManager.getConfiguration(cd.getGroup().value(), cid.getItem().keyName()));
					box.setSelectedItem(selectedItem);
					box.setToolTipText(Text.titleCase(selectedItem));
				}
				catch (IllegalArgumentException ex)
				{
					log.debug("invalid seleced item", ex);
				}
				box.addItemListener(e ->
				{
					if (e.getStateChange() == ItemEvent.SELECTED)
					{
						changeConfiguration(box, cd, cid);
						box.setToolTipText(Text.titleCase((Enum) box.getSelectedItem()));
					}
				});
				item.add(box, BorderLayout.EAST);
			}

			if (cid.getType() == Keybind.class || cid.getType() == ModifierlessKeybind.class)
			{
				Keybind startingValue = configManager.getConfiguration(cd.getGroup().value(),
					cid.getItem().keyName(),
					(Class<? extends Keybind>) cid.getType());

				HotkeyButton button = new HotkeyButton(startingValue, cid.getType() == ModifierlessKeybind.class);

				button.addFocusListener(new FocusAdapter()
				{
					@Override
					public void focusLost(FocusEvent e)
					{
						changeConfiguration(button, cd, cid);
					}
				});

				item.add(button, BorderLayout.EAST);
			}
			else if (cid.getType() == EnumSet.class)
			{
				Class enumType = cid.getItem().enumClass();

				EnumSet enumSet = configManager.getConfiguration(cd.getGroup().value(),
					cid.getItem().keyName(), EnumSet.class);
				if (enumSet == null || enumSet.contains(null))
				{
					enumSet = EnumSet.noneOf(enumType);
				}

				JPanel enumsetLayout = new JPanel(new GridLayout(0, 2));
				List<JCheckBox> jcheckboxes = new ArrayList<>();

				for (Object obj : enumType.getEnumConstants())
				{
					String option = String.valueOf(obj).toLowerCase().replace("_", " ");

					JCheckBox checkbox = new JCheckBox(option);
					checkbox.setBackground(ColorScheme.LIGHT_GRAY_COLOR);
					checkbox.setSelected(enumSet.contains(obj));
					jcheckboxes.add(checkbox);

					enumsetLayout.add(checkbox);
				}

				jcheckboxes.forEach(checkbox -> checkbox.addActionListener(ae -> changeConfiguration(jcheckboxes, cd, cid)));

				item.add(enumsetLayout, BorderLayout.SOUTH);
			}

			JPanel titleSection = titleSectionWidgets.get(cid.getItem().titleSection());
			JPanel section = sectionWidgets.get(cid.getItem().section());

			if (titleSection != null)
			{
				titleSection.add(item);
			}
			else if (section != null)
			{
				section.add(item);
			}
			else
			{
				mainPanel.add(item);
			}
		}

		buttons.forEach(mainPanel::add);

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener((e) ->
		{
			final int result = JOptionPane.showOptionDialog(resetButton, "Are you sure you want to reset this plugin's configuration?",
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result == JOptionPane.YES_OPTION)
			{
				configManager.setDefaultConfiguration(pluginConfig.getConfig(), true);

				rebuild(false);
			}
		});
		mainPanel.add(resetButton);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> pluginList.getMuxer().popState());
		mainPanel.add(backButton);

		if (refresh)
		{
			scrollPane.getVerticalScrollBar().setValue(scrollBarPosition);
		}
		else
		{
			scrollPane.getVerticalScrollBar().setValue(0);
		}

		revalidate();
	}

	private void changeConfiguration(List<JCheckBox> components, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		Class<? extends Enum> enumType = cid.getItem().enumClass();
		EnumSet enumSet = configManager.getConfiguration(cd.getGroup().value(),
			cid.getItem().keyName(), EnumSet.class);
		if (enumSet == null)
		{
			//noinspection unchecked
			enumSet = EnumSet.noneOf(enumType);
		}
		enumSet.clear();

		EnumSet finalEnumSet = enumSet;

		//noinspection unchecked
		components.forEach(value ->
		{
			if (value.isSelected())
			{
				finalEnumSet.add(Enum.valueOf(cid.getItem().enumClass(), String.valueOf(value.getText()).toUpperCase().replace(" ", "_")));
			}
		});

		configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), finalEnumSet);
	}

	private void changeConfiguration(Component component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		final ConfigItem configItem = cid.getItem();

		if (!Strings.isNullOrEmpty(configItem.warning()))
		{
			final int result = JOptionPane.showOptionDialog(component, configItem.warning(),
				"Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, new String[]{"Yes", "No"}, "No");

			if (result != JOptionPane.YES_OPTION)
			{
				rebuild(false);
				return;
			}
		}

		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + checkbox.isSelected());
		}
		else if (component instanceof JSpinner)
		{
			JSpinner spinner = (JSpinner) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), "" + spinner.getValue());
		}
		else if (component instanceof JSlider)
		{
			JSlider slider = (JSlider) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), slider.getValue());
		}
		else if (component instanceof JTextComponent)
		{
			JTextComponent textField = (JTextComponent) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), textField.getText());
		}
		else if (component instanceof RuneliteColorPicker)
		{
			RuneliteColorPicker colorPicker = (RuneliteColorPicker) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), colorPicker.getSelectedColor().getRGB() + "");
		}
		else if (component instanceof JComboBox)
		{
			JComboBox jComboBox = (JComboBox) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), ((Enum) jComboBox.getSelectedItem()).name());
		}
		else if (component instanceof HotkeyButton)
		{
			HotkeyButton hotkeyButton = (HotkeyButton) component;
			configManager.setConfiguration(cd.getGroup().value(), cid.getItem().keyName(), hotkeyButton.getValue());
		}

		hideUnhide(component, cd, cid);
	}

	private void hideUnhide(Component component, ConfigDescriptor cd, ConfigItemDescriptor cid)
	{
		if (component instanceof JCheckBox)
		{
			JCheckBox checkbox = (JCheckBox) component;

			for (ConfigItemDescriptor cid2 : cd.getItems())
			{
				if (cid2.getItem().hidden() || !cid2.getItem().hide().isEmpty())
				{
					List<String> itemHide = Splitter
						.onPattern("\\|\\|")
						.trimResults()
						.omitEmptyStrings()
						.splitToList(String.format("%s || %s", cid2.getItem().unhide(), cid2.getItem().hide()));

					if (itemHide.contains(cid.getItem().keyName()))
					{
						rebuild(true);
					}
				}

				if (checkbox.isSelected())
				{
					if (cid2.getItem().enabledBy().contains(cid.getItem().keyName()))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "true");
						rebuild(true);
					}
					else if (cid2.getItem().disabledBy().contains(cid.getItem().keyName()))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "false");
						rebuild(true);
					}
				}
			}
		}
		else if (component instanceof JComboBox)
		{
			JComboBox jComboBox = (JComboBox) component;

			for (ConfigItemDescriptor cid2 : cd.getItems())
			{
				if (cid2.getItem().hidden() || !cid2.getItem().hide().isEmpty())
				{
					List<String> itemHide = Splitter
						.onPattern("\\|\\|")
						.trimResults()
						.omitEmptyStrings()
						.splitToList(String.format("%s || %s", cid2.getItem().unhide(), cid2.getItem().hide()));

					if (itemHide.contains(cid.getItem().keyName()))
					{
						rebuild(true);
					}

					String changedVal = ((Enum) jComboBox.getSelectedItem()).name();

					if (cid2.getItem().enabledBy().contains(cid.getItem().keyName()) && cid2.getItem().enabledByValue().equals(changedVal))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "true");
						rebuild(true);
					}
					else if (cid2.getItem().disabledBy().contains(cid.getItem().keyName()) && cid2.getItem().disabledByValue().equals(changedVal))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "false");
						rebuild(true);
					}
				}
			}
		}
		else if (component instanceof JList)
		{
			JList jList = (JList) component;

			for (ConfigItemDescriptor cid2 : cd.getItems())
			{
				if (cid2.getItem().hidden() || !cid2.getItem().hide().isEmpty())
				{
					List<String> itemHide = Splitter
						.onPattern("\\|\\|")
						.trimResults()
						.omitEmptyStrings()
						.splitToList(String.format("%s || %s", cid2.getItem().unhide(), cid2.getItem().hide()));

					if (itemHide.contains(cid.getItem().keyName()))
					{
						rebuild(true);
					}

					String changedVal = String.valueOf((jList.getSelectedValues()));

					if (cid2.getItem().enabledBy().contains(cid.getItem().keyName()) && cid2.getItem().enabledByValue().equals(changedVal))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "true");
						rebuild(true);
					}
					else if (cid2.getItem().disabledBy().contains(cid.getItem().keyName()) && cid2.getItem().disabledByValue().equals(changedVal))
					{
						configManager.setConfiguration(cd.getGroup().value(), cid2.getItem().keyName(), "false");
						rebuild(true);
					}
				}
			}
		}
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(PANEL_WIDTH + SCROLLBAR_WIDTH, super.getPreferredSize().height);
	}

	@Subscribe
	public void onPluginChanged(PluginChanged event)
	{
		if (event.getPlugin() == this.pluginConfig.getPlugin())
		{
			SwingUtilities.invokeLater(() ->
			{
				pluginToggle.setSelected(event.isLoaded());
			});
		}
	}
}