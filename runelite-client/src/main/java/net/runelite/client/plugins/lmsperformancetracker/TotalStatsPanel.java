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

// basic panel to show a title and total fight performance stats
public class TotalStatsPanel extends JPanel
{
	private JLabel statsLabel;
	private FightPerformance totalStats;

	TotalStatsPanel(FightPerformance fight)
	{
		totalStats = fight;

		setLayout(new GridLayout(2,1));
		setBorder(new EmptyBorder(8, 8, 8, 8));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JLabel titleLabel = new JLabel();
		titleLabel.setText("LMS Performance Tracker");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		add(titleLabel);

		JPanel statsPanel = new JPanel(new BorderLayout());

		JLabel leftLabel = new JLabel();
		leftLabel.setText("Total Stats:");
		leftLabel.setForeground(Color.WHITE);
		statsPanel.add(leftLabel, BorderLayout.WEST);

		statsLabel = new JLabel();
		statsLabel.setText(fight.getPlayerStatsString());
		statsLabel.setForeground(Color.WHITE);
		statsPanel.add(statsLabel, BorderLayout.EAST);
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		add(statsPanel);
	}

	void addFight(FightPerformance fight)
	{
		totalStats.addAttacks(fight.getPlayerSuccessCount(), fight.getPlayerAttackCount());
		SwingUtilities.invokeLater(() -> statsLabel.setText(totalStats.getPlayerStatsString()));
	}
}
