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

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.iconcombobox.ComboBoxIconEntry;
import net.runelite.client.ui.components.iconcombobox.ComboBoxIconRenderer;

class SkillCalculatorPanel extends PluginPanel
{
	private final SkillCalculator uiCalculator;

	SkillCalculatorPanel(SkillIconManager iconManager, Client client, SpriteManager spriteManager, ItemManager itemManager)
	{
		super();
		getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		JComboBox<ComboBoxIconEntry> skillSelector = new JComboBox<>();
		skillSelector.setFocusable(false); // To prevent an annoying "focus paint" effect
		skillSelector.setForeground(Color.WHITE);
		skillSelector.setRenderer(new ComboBoxIconRenderer());

		// Populate the combo box entries
		for (CalculatorType calculatorType : CalculatorType.values())
		{
			ImageIcon icon = new ImageIcon(iconManager.getSkillImage(calculatorType.getSkill(), true));
			ComboBoxIconEntry dropdownEntry = new ComboBoxIconEntry(icon, calculatorType.getSkill().getName(), calculatorType);
			skillSelector.addItem(dropdownEntry);
		}

		final UICalculatorInputArea uiInput = new UICalculatorInputArea();
		uiInput.setBorder(new EmptyBorder(15, 0, 15, 0));
		uiInput.setBackground(ColorScheme.DARK_GRAY_COLOR);
		uiCalculator = new SkillCalculator(client, uiInput, spriteManager, itemManager);

		skillSelector.addItemListener(e ->
		{
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				ComboBoxIconEntry entry = (ComboBoxIconEntry) e.getItem();

				if (entry.getObject() != null && entry.getObject() instanceof CalculatorType)
				{
					uiCalculator.openCalculator((CalculatorType) entry.getObject());
				}
			}
		});

		add(skillSelector, c);
		c.gridy++;

		add(uiInput, c);
		c.gridy++;

		add(uiCalculator, c);
		c.gridy++;
	}
}