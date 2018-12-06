/*
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

import java.text.DecimalFormat;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.game.ItemManager;

@Slf4j
public class BankedCalculator extends JPanel
{
	private static final DecimalFormat XP_FORMAT_COMMA = new DecimalFormat("#,###.#");

	private final SkillCalculatorPanel parent;
	private final UICalculatorInputArea uiInput;
	private final SkillCalculatorConfig config;
	private final ItemManager itemManager;

	BankedCalculator(SkillCalculatorPanel parent, UICalculatorInputArea uiInput, SkillCalculatorConfig config, ItemManager itemManager)
	{
		this.parent = parent;
		this.uiInput = uiInput;
		this.config = config;
		this.itemManager = itemManager;
	}

	void openBanked(CalculatorType calculatorType)
	{
		// clean slate for creating the required panel
		removeAll();

		// Only adds Banked Experience portion if enabled for this SkillCalc and have seen their bank
		if (!calculatorType.isBankedXpFlag())
		{
			add(new JLabel("<html><div style='text-align: center;'>Banked Experience is not enabled for this skill.</div></html>", JLabel.CENTER));
		}
		else if (parent.getBankMap().size() <= 0)
		{
			add(new JLabel( "Please visit a bank!", JLabel.CENTER));
		}
		else
		{
			// Prevent editing of the target level/exp since we automagically adjust them
			uiInput.getUiFieldTargetLevel().setEditable(false);
			uiInput.getUiFieldTargetXP().setEditable(false);

			// Todo:
			add(new JLabel("TODO"), JLabel.CENTER);
		}

		revalidate();
		repaint();

	}

	void updateBankMap(Map<Integer, Integer> map)
	{
		log.info("Bank Map Updated while open");
	}
}
