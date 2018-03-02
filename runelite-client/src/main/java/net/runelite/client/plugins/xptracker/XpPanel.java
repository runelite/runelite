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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.PluginPanel;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@Slf4j
class XpPanel extends PluginPanel
{
	private final Map<Skill, XpInfoBox> infoBoxes = new HashMap<>();
	private final JLabel totalXpGained = new JLabel();
	private final JLabel totalXpHr = new JLabel();

	private final JPanel goalPanel = new JPanel();
	private final Component goalPanelPad = Box.createRigidArea(new Dimension(0, 3));
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
	private static String[] skillStrList = new String[skillList.length];
	private final JComboBox<String> skillDropdown = new JComboBox<>(skillStrList);
	private static final String[] goalTypeList = { "Level", "XP" };
	private final JComboBox<String> goalDropdown = new JComboBox<>(goalTypeList);
	private final JTextField goalField = new JTextField();

	static
	{
		for (int i = 0; i < skillList.length; ++i)
		{
			skillStrList[i] = skillList[i].getName();
		}
	}

	XpPanel(XpTrackerPlugin xpTrackerPlugin, Client client, XpTrackerConfig config, SkillIconManager iconManager)
	{
		super();

		// info panel buttons
		final JButton resetButton = new JButton("Reset All");
		resetButton.addActionListener(e -> resetAllInfoBoxes());
		final JButton setGoalButton = new JButton("Set Goal...");
		setGoalButton.addActionListener(e -> toggleGoalPanel());

		totalXpGained.setText(formatLine(0, "total xp gained"));
		totalXpHr.setText(formatLine(0, "total xp/hr"));

		// create info panel layout
		final JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridBagLayout());
		infoPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = c.weighty = 0.5;
		c.gridx = c.gridy = 0;
		infoPanel.add(totalXpGained, c);
		c.gridy = 1;
		infoPanel.add(totalXpHr, c);
		c.gridy = 2;
		infoPanel.add(resetButton, c);
		c.gridx = 2;
		infoPanel.add(setGoalButton, c);

		// create info panel wrapper
		final JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new BorderLayout());
		totalPanel.setBorder(BorderFactory.createLineBorder(getBackground().brighter(), 1, true));
		totalPanel.add(infoPanel, BorderLayout.CENTER);

		final JButton goalOK = new JButton("OK");
		goalOK.addActionListener(e -> onSetGoal());

		// create goal panel layout
		final JPanel goalConfPanel = new JPanel();
		goalConfPanel.setLayout(new GridBagLayout());
		goalConfPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		c.gridx = c.gridy = 0;
		goalConfPanel.add(skillDropdown, c);
		c.gridx = 1;
		goalConfPanel.add(goalDropdown, c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		goalConfPanel.add(goalField, c);
		c.gridy = 2;
		goalConfPanel.add(goalOK, c);

		// create goal panel wrapper
		goalPanel.setLayout(new BorderLayout());
		goalPanel.setBorder(BorderFactory.createLineBorder(getBackground().brighter(), 1, true));
		goalPanel.add(goalConfPanel);
		goalPanel.setVisible(false);
		goalPanelPad.setVisible(false);

		// create info and goal panel wrapper
		final JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		topPanel.add(totalPanel);
		topPanel.add(goalPanelPad);
		topPanel.add(goalPanel);

		// create panel for xp trackers
		final JPanel infoBoxPanel = new JPanel();
		infoBoxPanel.setLayout(new GridLayout(0, 1, 0, 3));

		// complete plugin panel layout
		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout(0, 3));
		layoutPanel.add(topPanel, BorderLayout.NORTH);
		layoutPanel.add(infoBoxPanel, BorderLayout.CENTER);
		add(layoutPanel);

		// create skill tracker boxes
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

	void toggleGoalPanel()
	{
		isShowGoal = !isShowGoal;
		goalPanel.setVisible(isShowGoal);
		goalPanelPad.setVisible(isShowGoal);
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
			// not a number, just do nothing
			return;
		}

		if (goaltypesel == 0)
		{
			if (goal < 1 || goal > Experience.MAX_VIRT_LEVEL)
			{
				// invalid goal level, just do nothing
				return;
			}
			goal = Experience.getXpForLevel(goal);
		}
		else
		{
			if (goal < 1 || goal > 200000000l)
			{
				// invalid goal xp, just do nothing
				return;
			}
		}

		toggleGoalPanel();
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
