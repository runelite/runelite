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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class UICalculatorInputArea extends JPanel
{
	private final GridBagLayout uiLayout;
	private final GridBagConstraints uiConstraints;

	private int gridX = 0;
	private int gridY = 0;

	JTextField uiFieldCurrentLevel;
	JTextField uiFieldCurrentXP;
	JTextField uiFieldTargetLevel;
	JTextField uiFieldTargetXP;

	UICalculatorInputArea()
	{
		uiLayout = new GridBagLayout();
		uiConstraints = new GridBagConstraints();
		uiConstraints.insets = new Insets(3, 9, 3, 9);
		setLayout(uiLayout);

		uiFieldCurrentLevel = addComponent("Current Level");
		uiFieldCurrentXP = addComponent("Current XP");
		uiFieldTargetLevel = addComponent("Target Level");
		uiFieldTargetXP = addComponent("Target XP");
	}

	int getCurrentLevelInput()
	{
		return getInput(uiFieldCurrentLevel);
	}

	void setCurrentLevelInput(int value)
	{
		setInput(uiFieldCurrentLevel, value);
	}

	int getCurrentXPInput()
	{
		return getInput(uiFieldCurrentXP);
	}

	void setCurrentXPInput(Object value)
	{
		setInput(uiFieldCurrentXP, value);
	}

	int getTargetLevelInput()
	{
		return getInput(uiFieldTargetLevel);
	}

	void setTargetLevelInput(Object value)
	{
		setInput(uiFieldTargetLevel, value);
	}

	int getTargetXPInput()
	{
		return getInput(uiFieldTargetXP);
	}

	void setTargetXPInput(Object value)
	{
		setInput(uiFieldTargetXP, value);
	}

	private int getInput(JTextField field)
	{
		try
		{
			return Integer.parseInt(field.getText());
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}

	private void setInput(JTextField field, Object value)
	{
		field.setText(String.valueOf(value));
	}

	private JTextField addComponent(String label)
	{
		final JLabel uiLabel = new JLabel(label);
		final JTextField uiField = new JTextField(6);

		uiConstraints.gridx = gridX;
		uiConstraints.gridy = gridY;

		uiLayout.setConstraints(uiLabel, uiConstraints);
		add(uiLabel);

		uiConstraints.gridy++;
		uiLayout.setConstraints(uiField, uiConstraints);
		add(uiField);

		gridX++;
		if (gridX % 2 == 0)
		{
			gridY += 2;
			gridX = 0;
		}

		return uiField;
	}
}