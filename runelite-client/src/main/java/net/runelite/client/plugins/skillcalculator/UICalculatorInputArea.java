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

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import static net.runelite.client.plugins.skillcalculator.SkillCalculator.MAX_XP_MULTIPLIER;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.UnitFormatterFactory;
import net.runelite.client.ui.components.FlatTextField;

@Getter
@Singleton
class UICalculatorInputArea extends JPanel
{
	private static final Pattern NON_NUMERIC = Pattern.compile("\\D");
	private final JTextField uiFieldCurrentLevel;
	private final JTextField uiFieldCurrentXP;
	private final JTextField uiFieldTargetLevel;
	private final JTextField uiFieldTargetXP;
	private final JSpinner uiFieldXPMultiplier;

	@Inject
	UICalculatorInputArea()
	{
		setLayout(new GridLayout(3, 2, 7, 7));
		uiFieldCurrentLevel = addComponent("Current Level");
		uiFieldCurrentXP = addComponent("Current Experience");
		uiFieldTargetLevel = addComponent("Target Level");
		uiFieldTargetXP = addComponent("Target Experience");
		uiFieldXPMultiplier = addMultiplicationSpinnerComponent("XP Multiplier", MAX_XP_MULTIPLIER);
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

	int getXPMultiplierInput()
	{
		return getInput(uiFieldXPMultiplier);
	}

	void setXPMultiplier(Object value)
	{
		setInput(uiFieldXPMultiplier, value);
	}

	void setNeededXP(Object value)
	{
		uiFieldTargetXP.setToolTipText((String) value);
	}

	private static int getInput(JTextField field)
	{
		try
		{
			return Integer.parseInt(NON_NUMERIC.matcher(field.getText()).replaceAll(""));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}

	private static int getInput(JSpinner field)
	{
		try
		{
			return Integer.parseInt(NON_NUMERIC.matcher(field.getModel().getValue().toString()).replaceAll(""));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}

	private static void setInput(JTextField field, Object value)
	{
		field.setText(String.valueOf(value));
	}

	private static void setInput(JSpinner field, Object value)
	{
		((JSpinner.DefaultEditor) field.getEditor()).getTextField().setValue(value);
	}

	private JTextField addComponent(String label)
	{
		final JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		final JLabel uiLabel = new JLabel(label);
		final FlatTextField uiInput = new FlatTextField();

		uiInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		uiInput.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		uiInput.setBorder(new EmptyBorder(5, 7, 5, 7));

		uiLabel.setFont(FontManager.getRunescapeSmallFont());
		uiLabel.setBorder(new EmptyBorder(0, 0, 4, 0));
		uiLabel.setForeground(Color.WHITE);

		container.add(uiLabel, BorderLayout.NORTH);
		container.add(uiInput, BorderLayout.CENTER);

		add(container);

		return uiInput.getTextField();
	}

	private JSpinner addMultiplicationSpinnerComponent(String label, int max)
	{
		final JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		final JLabel uiLabel = new JLabel(label);

		SpinnerModel model = new SpinnerNumberModel(1, 1, max, 1);
		final JSpinner uiInput = new JSpinner(model);

		JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) uiInput.getEditor();
		JFormattedTextField spinnerTextField = editor.getTextField();
		spinnerTextField.setHorizontalAlignment(JTextField.LEFT);
		spinnerTextField.setFormatterFactory(new UnitFormatterFactory(spinnerTextField.getFormatterFactory(), "x"));
		uiInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		uiInput.setBorder(new EmptyBorder(5, 7, 5, 7));

		uiLabel.setFont(FontManager.getRunescapeSmallFont());
		uiLabel.setBorder(new EmptyBorder(0, 0, 4, 0));
		uiLabel.setForeground(Color.WHITE);

		container.add(uiLabel, BorderLayout.NORTH);
		container.add(uiInput, BorderLayout.CENTER);

		add(container);

		return uiInput;
	}
}
