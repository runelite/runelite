/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

@Slf4j
class SkillCalculatorPanel extends PluginPanel
{
	private final SkillCalculator uiCalculator;
	private final SkillIconManager iconManager;
	private final SkillCalculatorConfig config;
	private final BankedCalculator bankedCalculator;

	private CalculatorType currentCalc;
	private final MaterialTabGroup skillGroup;
	private final MaterialTabGroup tabGroup;
	private String currentTab;
	private ArrayList<String> tabs = new ArrayList<>();
	@Getter
	private Map<Integer, Integer> bankMap = new HashMap<>();
	private GridBagConstraints c;

	SkillCalculatorPanel(SkillIconManager iconManager, Client client, SkillCalculatorConfig config, SpriteManager spriteManager, ItemManager itemManager)
	{
		super();
		getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		this.iconManager = iconManager;
		this.config = config;

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		skillGroup = new MaterialTabGroup();
		skillGroup.setLayout(new GridLayout(0, 6, 7, 7));

		addCalculatorButtons();

		final UICalculatorInputArea uiInput = new UICalculatorInputArea();
		uiInput.setBorder(new EmptyBorder(15, 0, 15, 0));
		uiInput.setBackground(ColorScheme.DARK_GRAY_COLOR);
		uiCalculator = new SkillCalculator(client, uiInput, spriteManager, itemManager);

		bankedCalculator = new BankedCalculator(this, client, uiInput, config, itemManager);

		tabGroup = new MaterialTabGroup();
		tabGroup.setBorder(new EmptyBorder(0, 0, 10, 0));

		addTabButtons();

		add(skillGroup, c);
		c.gridy++;

		add(uiInput, c);
		c.gridy++;

		add(tabGroup, c);
		c.gridy++;

		add(uiCalculator, c);
	}

	private void addCalculatorButtons()
	{
		for (CalculatorType calculatorType : CalculatorType.values())
		{
			ImageIcon icon = new ImageIcon(iconManager.getSkillImage(calculatorType.getSkill(), true));
			MaterialTab tab = new MaterialTab(icon, skillGroup, null);
			tab.setOnSelectEvent(() ->
			{
				if (currentCalc == calculatorType)
				{
					return true;
				}
				currentCalc = calculatorType;
				selectedTab(currentTab, true);
				return true;
			});

			skillGroup.addTab(tab);
		}
	}

	private void addTabButtons()
	{
		tabGroup.removeAll();
		tabs.clear();

		tabs.add("Calculator");
		if (config.showBankedXp())
		{
			tabs.add("Banked Xp");
		}
		// Only show if both options are visible
		tabGroup.setVisible(tabs.size() > 1);

		tabGroup.setLayout(new GridLayout(0, tabs.size(), 7, 7));

		for (String s : tabs)
		{
			MaterialTab matTab = new MaterialTab(s, tabGroup, null);

			matTab.setHorizontalAlignment(SwingUtilities.CENTER);

			// Ensure Background is applied
			matTab.setOpaque(true);
			matTab.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			// When Clicked
			matTab.setOnSelectEvent(() ->
			{
				selectedTab(s, false);
				return true;
			});

			tabGroup.addTab(matTab);
		}

		MaterialTab selected = tabGroup.getTab(0);
		if (tabs.contains(currentTab))
		{
			selected = tabGroup.getTab(tabs.indexOf(currentTab));
		}

		tabGroup.select(selected);
		currentTab = selected.getText();
	}

	private void selectedTab(String s, boolean force)
	{
		// Do not refresh the panel if they clicked the same tab, unless they selected a new skill
		if (Objects.equals(currentTab, s) && !force)
		{
			return;
		}

		currentTab = s;

		// Only open a panel if a skill is selected
		if (currentCalc == null)
		{
			return;
		}

		switch (s)
		{
			case "Calculator":
				remove(bankedCalculator);
				add(uiCalculator, c);
				uiCalculator.openCalculator(currentCalc);
				break;
			case "Banked Xp":
				remove(uiCalculator);
				add(bankedCalculator, c);
				bankedCalculator.openBanked(currentCalc);
				break;
		}

		this.revalidate();
		this.repaint();
	}

	// Refresh entire panel
	void refreshPanel()
	{
		// Recreate Tabs (in case of Config change) and selects the first tab
		addTabButtons();

		// Ensure reload
		selectedTab(currentTab, true);

		this.revalidate();
		this.repaint();
	}

	// Wrapper function for updating SkillCalculator's bankMap
	void updateBankMap(Map<Integer, Integer> bank)
	{
		bankMap = bank;
		if (currentCalc != null & currentTab.equals("Banked Xp"))
		{
			bankedCalculator.updateBankMap(bankMap);
		}
	}

	void updateSkillCalculator(Skill skill)
	{
		uiCalculator.updateSkillCalculator(skill);
	}
}