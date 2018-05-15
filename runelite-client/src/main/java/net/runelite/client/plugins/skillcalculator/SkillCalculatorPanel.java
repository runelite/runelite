/*
 * Copyright (c) 2018, Kruithne <kruithne@gmail.com>
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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.PluginPanel;

class SkillCalculatorPanel extends PluginPanel
{
	private JButton activeButton;
	private int uiButtonIndex = 0;
	private final SkillCalculator uiCalculator;
	private final SkillIconManager iconManager;
	private final JPanel uiButtonGrid = new JPanel();
	private final GridBagLayout uiButtonGridLayout = new GridBagLayout();
	private final GridBagConstraints uiButtonGridConstraints = new GridBagConstraints();

	SkillCalculatorPanel(SkillIconManager iconManager, Client client)
	{
		super();
		this.iconManager = iconManager;

		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		uiButtonGridConstraints.fill = GridBagConstraints.BOTH;
		uiButtonGridConstraints.weightx = 1;
		uiButtonGridConstraints.ipady = 12;
		uiButtonGridConstraints.insets = new Insets(2, 2, 2, 2);

		uiButtonGrid.setLayout(uiButtonGridLayout);
		uiButtonGrid.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		addCalculatorButtons();

		final UICalculatorInputArea uiInput = new UICalculatorInputArea();
		uiCalculator = new SkillCalculator(client, uiInput);

		add(uiButtonGrid);
		add(Box.createRigidArea(new Dimension(0, 8)));
		add(uiInput);
		add(Box.createRigidArea(new Dimension(0, 14)));
		add(uiCalculator);
	}

	private void addCalculatorButtons()
	{
		for (CalculatorType calculatorType : CalculatorType.values())
		{
			final JButton uiButton = new JButton();
			final BufferedImage icon = iconManager.getSkillImage(calculatorType.getSkill());
			uiButton.addActionListener(e -> openCalculator(calculatorType, uiButton));

			uiButton.setIcon(new ImageIcon(icon));
			uiButton.setToolTipText(calculatorType.getSkill().getName());
			uiButton.setFocusPainted(false);

			uiButtonGridConstraints.gridx = uiButtonIndex % 4;
			uiButtonGridLayout.setConstraints(uiButton, uiButtonGridConstraints);
			uiButtonGrid.add(uiButton);
			uiButtonIndex++;
		}
	}

	private void openCalculator(CalculatorType calculatorType, JButton button)
	{
		// Remove highlight from existing button..
		if (activeButton != null)
			activeButton.setSelected(false);

		// Set the new button as selected..
		button.setSelected(true);
		activeButton = button;

		// Invoke the calculator component..
		uiCalculator.openCalculator(calculatorType);

		// Refresh rendering..
		revalidate();
		repaint();
	}
}