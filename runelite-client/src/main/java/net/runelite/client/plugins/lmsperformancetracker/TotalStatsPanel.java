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

		setLayout(new GridLayout(3,1));
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
