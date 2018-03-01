/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
 * Copyright (c) 2018 Charlie Waters
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
package net.runelite.client.plugins.xptracker;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.PluginPanel;

@Slf4j
class XpPanel extends PluginPanel
{
	private final Map<Skill, XpInfoBox> infoBoxes = new HashMap<>();
	private final JLabel totalXpGained = new JLabel();
	private final JLabel totalXpHr = new JLabel();

	XpPanel(XpTrackerPlugin xpTrackerPlugin, Client client, XpTrackerConfig config, SkillIconManager iconManager)
	{
		super();

		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout(0, 3));
		add(layoutPanel);

		final JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new BorderLayout());
		totalPanel.setBorder(BorderFactory.createLineBorder(getBackground().brighter(), 1, true));

		final JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(4, 1));
		infoPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

		final JButton resetButton = new JButton("Reset All");
		resetButton.addActionListener(e -> resetAllInfoBoxes());
		final JButton setGoalButton = new JButton("Set Goal...");
		setGoalButton.addActionListener(e -> onSetGoal());

		totalXpGained.setText(formatLine(0, "total xp gained"));
		totalXpHr.setText(formatLine(0, "total xp/hr"));

		infoPanel.add(totalXpGained);
		infoPanel.add(totalXpHr);
		infoPanel.add(resetButton);
		infoPanel.add(setGoalButton);
		totalPanel.add(infoPanel, BorderLayout.CENTER);
		layoutPanel.add(totalPanel, BorderLayout.NORTH);

		final JPanel infoBoxPanel = new JPanel();
		infoBoxPanel.setLayout(new GridLayout(0, 1, 0, 3));
		layoutPanel.add(infoBoxPanel, BorderLayout.CENTER);

		try
		{
			for (Skill skill : Skill.values())
			{
				if (skill == Skill.OVERALL)
				{
					break;
				}

				infoBoxes.put(skill, new XpInfoBox(client, config, infoBoxPanel, xpTrackerPlugin.getSkillXpInfo(skill), iconManager));
			}
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}
	}

	void onSetGoal()
	{
		Skill[] skills = {
				Skill.AGILITY,
				Skill.ATTACK,
				Skill.CONSTRUCTION,
				Skill.COOKING,
				Skill.CRAFTING,
				Skill.DEFENCE,
				Skill.FARMING,
				Skill.FIREMAKING,
				Skill.FISHING,
				Skill.FLETCHING,
				Skill.HERBLORE,
				Skill.HITPOINTS,
				Skill.HUNTER,
				Skill.MAGIC,
				Skill.MINING,
				Skill.PRAYER,
				Skill.RANGED,
				Skill.RUNECRAFT,
				Skill.SLAYER,
				Skill.SMITHING,
				Skill.STRENGTH,
				Skill.THIEVING,
				Skill.WOODCUTTING,
		};
		Object[] skillstrs = new String[skills.length];
		Map<String, Skill> skillMap = new HashMap<>();
		for(int i = 0; i < skills.length; ++i)
		{
			skillstrs[i] = skills[i].getName();
			skillMap.put(skills[i].getName(), skills[i]);
		}

		String skillstr = (String) JOptionPane.showInputDialog(this,
				"Select skill:",
				"Set Goal",
				JOptionPane.QUESTION_MESSAGE,
				null,
				skillstrs,
				skills[0].getName()
		);
		if(skillstr == null)
		{
			return;
		}

		String goalstr = (String) JOptionPane.showInputDialog(this,
				"Enter goal level:",
				"Set Goal",
				JOptionPane.QUESTION_MESSAGE,
				null,
				null,
				99
		);
		if(goalstr == null)
		{
			return;
		}

		int goal;
		try
		{
			goal = Integer.parseInt(goalstr);
		}
		catch(NumberFormatException e)
		{
			return;
		}
		if(goal < 1 || goal > Experience.MAX_VIRT_LEVEL)
		{
			JOptionPane.showMessageDialog(this, "Invalid goal level");
			return;
		}

		Skill skill = skillMap.get(skillstr);
		infoBoxes.get(skill).setGoal(goal);
	}

	void resetAllInfoBoxes()
	{
		infoBoxes.forEach((skill, xpInfoBox) -> xpInfoBox.reset());
		updateTotal();
	}

	void updateAllInfoBoxes()
	{
		infoBoxes.forEach((skill, xpInfoBox) -> xpInfoBox.update());
		updateTotal();
	}

	void updateSkillExperience(Skill skill)
	{
		final XpInfoBox xpInfoBox = infoBoxes.get(skill);
		xpInfoBox.update();
		xpInfoBox.init();
		updateTotal();
	}

	private void updateTotal()
	{
		final AtomicInteger totalXpGainedVal = new AtomicInteger();
		final AtomicInteger totalXpHrVal = new AtomicInteger();

		for (XpInfoBox xpInfoBox : infoBoxes.values())
		{
			totalXpGainedVal.addAndGet(xpInfoBox.getXpInfo().getXpGained());
			totalXpHrVal.addAndGet(xpInfoBox.getXpInfo().getXpHr());
		}

		SwingUtilities.invokeLater(() ->
		{
			totalXpGained.setText(formatLine(totalXpGainedVal.get(), "total xp gained"));
			totalXpHr.setText(formatLine(totalXpHrVal.get(), "total xp/hr"));
		});
	}

	static String formatLine(double number, String description)
	{
		return NumberFormat.getInstance().format(number) + " " + description;
	}
}
