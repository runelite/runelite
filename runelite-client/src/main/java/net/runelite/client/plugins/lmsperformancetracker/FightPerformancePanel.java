package net.runelite.client.plugins.lmsperformancetracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.loottracker.LootTrackerClient;

// Panel to display fight performance. The first line shows player stats while the second is the opponent.
// There is a skull icon beside a player's name if they died. The usernames are fixed to the left and the
// stats are fixed to the right.
class FightPerformancePanel extends JPanel
{
	private static final Dimension ICON_SIZE = new Dimension(32, 32);

	FightPerformancePanel(FightPerformance fight)
	{
		setLayout(new BorderLayout(5, 5));
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		String tooltipText;
		if (fight.isPlayerDied() && fight.isOpponentDied())
		{
			tooltipText = "Both players died";
		}
		else if (fight.isPlayerDied())
		{
			tooltipText = "You died";
		}
		else if (fight.isOpponentDied())
		{
			tooltipText = "Your opponent died";
		}
		else
		{
			tooltipText = "Nobody died";
		}
		setToolTipText(tooltipText);

		Color background = getBackground();
		setBorder(new EmptyBorder(6, 6, 6, 6));

		// load & rescale icon used to show if a player/opponent died in a fight.
		ImageIcon icon = new ImageIcon(ImageUtil.getResourceStreamFromClass(getClass(), "skull_white.png"));
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(12, 12,  Image.SCALE_DEFAULT);
		icon = new ImageIcon(newimg);

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
		opponentStats.setText(fight.getOpponentStatsString());
		opponentStats.setForeground(fight.opponentWinning() ? Color.GREEN : Color.WHITE);
		opponentStatsPanel.add(opponentStats, BorderLayout.EAST);

		add(opponentStatsPanel, BorderLayout.CENTER);

		// initialize context menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setComponentPopupMenu(popupMenu);
		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e ->
		{
			getParent().removeAll();
			updateUI();
		});

		popupMenu.add(reset);
	}
}