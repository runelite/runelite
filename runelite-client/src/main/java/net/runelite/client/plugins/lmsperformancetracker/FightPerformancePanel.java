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
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;

// Panel to display fight performance. The first line shows player stats while the second is the opponent.
// There is a skull icon beside a player's name if they died. The usernames are fixed to the left and the
// stats are fixed to the right.
class FightPerformancePanel extends JPanel
{
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss 'on' yyyy/MM/dd");

	FightPerformancePanel(FightPerformance fight)
	{
		setLayout(new BorderLayout(5, 5));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);


		String tooltipText = "Ended at " + DATE_FORMAT.format(Date.from(fight.getTimeFightEnded()));
		setToolTipText(tooltipText);

		Color background = getBackground();
		setBorder(new EmptyBorder(6, 6, 6, 6));

		// load & rescale red skull icon used to show if a player/opponent died in a fight.
		ImageIcon icon = new ImageIcon(new ImageIcon(
			ImageUtil.getResourceStreamFromClass(getClass(), "skull_red.png"))
			.getImage()
			.getScaledInstance(12, 12, Image.SCALE_DEFAULT));
		Image image = icon.getImage();
		Image scaledImg = image.getScaledInstance(12, 12,  Image.SCALE_DEFAULT);
		icon = new ImageIcon(scaledImg);

		// player's stats, always first
		JPanel playerStatsPanel = new JPanel(new BorderLayout());
		playerStatsPanel.setBackground(background);

		JLabel playerStatsName = new JLabel();
		if (fight.isPlayerDied())
		{
			playerStatsName.setIcon(icon);
		}
		playerStatsName.setText(fight.getPlayerName());
		playerStatsName.setForeground(Color.WHITE);
		playerStatsPanel.add(playerStatsName, BorderLayout.WEST);

		JLabel playerStats = new JLabel();
		playerStats.setToolTipText(fight.getPlayerSuccessCount() + " successful off-pray attacks/" +
			fight.getPlayerAttackCount() + " total attacks" +
			(fight.playerWinning() ? " (green due to higher success ratio)" : ""));
		playerStats.setText(fight.getPlayerStatsString());
		playerStats.setForeground(fight.playerWinning() ? Color.GREEN : Color.WHITE);
		playerStatsPanel.add(playerStats, BorderLayout.EAST);

		add(playerStatsPanel, BorderLayout.NORTH);

		// opponent's stats, second
		JPanel opponentStatsPanel = new JPanel(new BorderLayout());
		opponentStatsPanel.setBackground(background);

		JLabel opponentStatsName = new JLabel();
		if (fight.isOpponentDied())
		{
			opponentStatsName.setIcon(icon);
		}
		opponentStatsName.setText(fight.getOpponentName());
		opponentStatsName.setForeground(Color.WHITE);
		opponentStatsPanel.add(opponentStatsName, BorderLayout.WEST);

		JLabel opponentStats = new JLabel();
		opponentStats.setToolTipText(fight.getOpponentSuccessCount() + " successful off-pray attacks/" +
			fight.getOpponentAttackCount() + " total attacks" +
			(fight.opponentWinning() ? " (green due to higher success ratio)" : ""));
		opponentStats.setText(fight.getOpponentStatsString());
		opponentStats.setForeground(fight.opponentWinning() ? Color.GREEN : Color.WHITE);
		opponentStatsPanel.add(opponentStats, BorderLayout.EAST);

		add(opponentStatsPanel, BorderLayout.CENTER);
	}
}