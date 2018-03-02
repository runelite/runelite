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

import java.awt.*;
import java.io.IOException;
import java.text.NumberFormat;
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

	private final JPanel goalPanel = new JPanel();
	private boolean isShowGoal = false;

	private static final Skill[] skillList = {
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
	private final JComboBox<Skill> skillDropdown = new JComboBox<>(skillList);
	private static final String[] goalTypeList = { "Level", "XP" };
	private final JComboBox<String> goalDropdown = new JComboBox<>(goalTypeList);
	private final JTextField goalField = new JTextField();

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
		infoPanel.setLayout(new GridBagLayout());
		infoPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

		final JButton resetButton = new JButton("Reset All");
		resetButton.addActionListener(e -> resetAllInfoBoxes());
		final JButton setGoalButton = new JButton("Set Goal...");
		setGoalButton.addActionListener(e -> showSetGoal());

		totalXpGained.setText(formatLine(0, "total xp gained"));
		totalXpHr.setText(formatLine(0, "total xp/hr"));

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = c.weighty = 0.5;
		c.ipadx = c.ipady = 1;
		c.gridx = c.gridy = 0;
		infoPanel.add(totalXpGained, c);
		c.gridy = 1;
		infoPanel.add(totalXpHr, c);
		c.gridy = 2;
		infoPanel.add(resetButton, c);
		c.gridx = 2;
		infoPanel.add(setGoalButton, c);
		totalPanel.add(infoPanel, BorderLayout.CENTER);

		Object[] skillstrs = new String[skillList.length];
		Map<String, Skill> skillMap = new HashMap<>();
		for (int i = 0; i < skillList.length; ++i)
		{
			skillstrs[i] = skillList[i].getName();
			skillMap.put(skillList[i].getName(), skillList[i]);
		}

		final JButton goalOK = new JButton("OK");
		goalOK.addActionListener(e -> onSetGoal());

		final JPanel goalConfPanel = new JPanel();
		goalConfPanel.setLayout(new GridLayout(4,1, 0, 1));
		goalConfPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		goalConfPanel.add(skillDropdown);
		goalConfPanel.add(goalDropdown);
		goalConfPanel.add(goalField);
		goalConfPanel.add(goalOK);

		goalPanel.setLayout(new BorderLayout());
		goalPanel.setBorder(BorderFactory.createLineBorder(getBackground().brighter(), 1, true));
		goalPanel.add(goalConfPanel);
		goalPanel.setVisible(false);

		final JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		topPanel.add(totalPanel);
		topPanel.add(Box.createRigidArea(new Dimension(0, 3)));
		topPanel.add(goalPanel);

		layoutPanel.add(topPanel, BorderLayout.NORTH);

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

	void showSetGoal()
	{
		isShowGoal = !isShowGoal;
		goalPanel.setVisible(isShowGoal);
	}

	void onSetGoal()
	{


		int skillsel = skillDropdown.getSelectedIndex();
		Skill skill = skillList[skillsel];
		int goaltypesel = goalDropdown.getSelectedIndex();
		String goalstr = goalField.getText();

		int goal;
		try
		{
			goal = Integer.parseInt(goalstr);
		}
		catch (NumberFormatException e)
		{
			return;
		}

		if (goaltypesel == 0)
		{
			if (goal < 1 || goal > Experience.MAX_VIRT_LEVEL)
			{
				JOptionPane.showMessageDialog(this, "Invalid goal level");
				return;
			}
			goal = Experience.getXpForLevel(goal);
		}
		else
		{
			if (goal < 1 || goal > 200000000l)
			{
				return;
			}
		}

		showSetGoal();
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
