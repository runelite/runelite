/*
 * Copyright (c) 2019, Matsyir <https://github.com/Matsyir>
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
package net.runelite.client.plugins.lmsperformancetracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;

// basic panel with 3 rows to show a title, total fight performance stats, and kills/deaths
public class TotalStatsPanel extends JPanel
{
	private JLabel statsLabel;
	private JLabel killsLabel;
	private JLabel deathsLabel;
	private FightPerformance totalStats;
	private int numKills = 0;
	private int numDeaths = 0;

	TotalStatsPanel()
	{
		totalStats = new FightPerformance("Player", "");

		setLayout(new GridLayout(3, 1));
		setBorder(new EmptyBorder(8, 8, 8, 8));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// basic label to display a title.
		JLabel titleLabel = new JLabel();
		titleLabel.setText("LMS Performance Tracker");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		add(titleLabel);

		// panel to show the total fight stats (successful hits/total attacks)
		JPanel statsPanel = new JPanel(new BorderLayout());

		JLabel leftLabel = new JLabel();
		leftLabel.setText("Total Stats:");
		leftLabel.setForeground(Color.WHITE);
		statsPanel.add(leftLabel, BorderLayout.WEST);

		statsLabel = new JLabel();
		statsLabel.setToolTipText(totalStats.getPlayerSuccessCount() + " successful off-pray attacks/" +
			totalStats.getPlayerAttackCount() + " total attacks");
		statsLabel.setText(totalStats.getPlayerStatsString());
		statsLabel.setForeground(Color.WHITE);
		statsPanel.add(statsLabel, BorderLayout.EAST);
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		add(statsPanel);

		// panel to show total kills/deaths
		JPanel killDeathPanel = new JPanel(new BorderLayout());

		killsLabel = new JLabel();
		killsLabel.setText(numKills + " Kills");
		killsLabel.setForeground(Color.WHITE);
		killDeathPanel.add(killsLabel, BorderLayout.WEST);

		deathsLabel = new JLabel();
		deathsLabel.setText(numDeaths + " Deaths");
		deathsLabel.setForeground(Color.WHITE);
		killDeathPanel.add(deathsLabel, BorderLayout.EAST);

		killDeathPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		add(killDeathPanel);
	}

	public void addFight(FightPerformance fight)
	{
		if (fight.isPlayerDied())
		{
			numDeaths++;
		}
		if (fight.isOpponentDied())
		{
			numKills++;
		}
		totalStats.addAttacks(fight.getPlayerSuccessCount(), fight.getPlayerAttackCount());
		SwingUtilities.invokeLater(() ->
		{
			statsLabel.setText(totalStats.getPlayerStatsString());
			killsLabel.setText(numKills + " Kill" + (numKills != 1 ? "s" : ""));
			deathsLabel.setText(numDeaths + " Death"  + (numDeaths != 1 ? "s" : ""));
			statsLabel.setToolTipText(totalStats.getPlayerSuccessCount() + " successful off-pray attacks/" +
				totalStats.getPlayerAttackCount() + " total attacks");
		});
	}

	public void reset()
	{
		numDeaths = 0;
		numKills = 0;
		totalStats = new FightPerformance("Player", "");
		SwingUtilities.invokeLater(() ->
		{
			statsLabel.setText(totalStats.getPlayerStatsString());
			killsLabel.setText(numKills + " Kills");
			deathsLabel.setText(numDeaths + " Deaths");
		});
	}
}
