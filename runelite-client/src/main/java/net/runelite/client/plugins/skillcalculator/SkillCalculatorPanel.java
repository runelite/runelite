/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

package net.runelite.client.plugins.skillcalculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.ComboBoxIconEntry;
import net.runelite.client.ui.components.ComboBoxIconRenderer;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

class SkillCalculatorPanel extends PluginPanel
{
	private final SkillCalculator uiCalculator;
	private final SkillIconManager iconManager;
	private final MaterialTabGroup tabGroup;

	private CalculatorType currentCalc;
	private String currentTab;

	// Mat Tab Custom Borders
	private final Border UNSELECTED_BORDER = new EmptyBorder(5, 3, 5, 3);
	private final Border SELECTED_BORDER = new CompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.BRAND_ORANGE),
			BorderFactory.createEmptyBorder(8, 3, 6, 3));

	SkillCalculatorPanel(SkillIconManager iconManager, Client client)
	{
		super();
		getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		this.iconManager = iconManager;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		tabGroup = new MaterialTabGroup();
		tabGroup.setLayout(new GridLayout(0, 6, 7, 7));
		tabGroup.setBorder(new EmptyBorder(0, 0, 10, 0));

		createTabs();

		final JComboBox<ComboBoxIconEntry> skillSelector = createSkillSelector();

		final UICalculatorInputArea uiInput = new UICalculatorInputArea();
		uiInput.setBorder(new EmptyBorder(15, 0, 15, 0));
		uiInput.setBackground(ColorScheme.DARK_GRAY_COLOR);
		uiCalculator = new SkillCalculator(client, uiInput);

		add(skillSelector, c);
		c.gridy++;

		add(uiInput, c);
		c.gridy++;

		add(tabGroup, c);
		c.gridy++;

		add(uiCalculator, c);
		c.gridy++;
	}

	// Creates all Panel Tabs (Calculator, Planner, Banked)
	private void createTabs()
	{
		tabGroup.removeAll();

		List<String> tabs = new ArrayList<>();
		tabs.add("Calculator");
		tabs.add("Planner");

		// Tab Size
		tabGroup.setLayout(new GridLayout(0, tabs.size(), 7, 7));

		for (String s : tabs)
		{
			MaterialTab matTab = new MaterialTab(s, tabGroup, null);

			matTab.setHorizontalAlignment(SwingUtilities.CENTER);

			// Ensure Background is applied
			matTab.setOpaque(true);
			matTab.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			// Change the border for less blank space between elements
			matTab.setUnselectedBorder(UNSELECTED_BORDER);
			matTab.setSelectedBorder(SELECTED_BORDER);

			// When Clicked
			matTab.setOnSelectEvent(() ->
			{
				selectedTab(s);
				return true;
			});

			tabGroup.addTab(matTab);
		}
		// Select the first tab
		tabGroup.select(tabGroup.getTab(0));
	}


	// Handle switching between the tabs
	private void selectedTab(String s)
	{
		currentTab = s;

		// Only open a panel if a skill is selected
		if (currentCalc == null)
			return;

		switch (s)
		{
			case "Calculator":
				uiCalculator.openCalculator(currentCalc);
				break;
			case "Planner":
				uiCalculator.openPlanner(currentCalc);
				break;
		}
	}

	// Creates the Skill Selection Drop Down
	private JComboBox<ComboBoxIconEntry> createSkillSelector()
	{
		JComboBox<ComboBoxIconEntry> box = new JComboBox<>();

		ComboBoxIconRenderer renderer = new ComboBoxIconRenderer();
		box.setRenderer(renderer);

		for (CalculatorType calculatorType : CalculatorType.values())
		{
			ImageIcon icon = new ImageIcon(iconManager.getSkillImage(calculatorType.getSkill(), true));
			ComboBoxIconEntry dropdownEntry = new ComboBoxIconEntry(icon, calculatorType.getSkill().getName());
			box.addItem(dropdownEntry);
		}

		box.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				// Match Dropdown Skill (text value) to CalculatorType Skill
				ComboBoxIconEntry entry = (ComboBoxIconEntry) e.getItem();
				for (Skill s : Skill.values())
				{
					if (s.getName().equals(entry.getText()))
					{
						for (CalculatorType c : CalculatorType.values())
						{
							if (c.getSkill().equals(s))
							{
								currentCalc = c;
								selectedTab(currentTab);
							}
						}
					}
				}
			}
		});

		box.setSelectedItem(null);

		return box;
	}

	// Refresh the current tab
	public void refreshCurrentCalc()
	{
		if (currentCalc == null)
			return;

		selectedTab(currentTab);
	}
}