package net.runelite.client.plugins.pvpperformancetracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.StackFormatter;

class FightPerformancePanel extends JPanel
{
	private static final Dimension ICON_SIZE = new Dimension(32, 32);

	FightPerformancePanel(FightPerformance fightPerformance, Dimension parentSize)
	{
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		setLayout(layout);
		setToolTipText("");

		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		Color background = getBackground();
		List<JPanel> panels = new ArrayList<>();
		panels.add(this);

//		MouseAdapter itemPanelMouseListener = new MouseAdapter()
//		{
//			@Override
//			public void mouseEntered(MouseEvent e)
//			{
//				for (JPanel panel : panels)
//				{
//					matchComponentBackground(panel, ColorScheme.DARK_GRAY_HOVER_COLOR);
//				}
//				setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e)
//			{
//				for (JPanel panel : panels)
//				{
//					matchComponentBackground(panel, background);
//				}
//				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e)
//			{
//				geLink(name, itemID);
//			}
//		};
//
//		addMouseListener(itemPanelMouseListener);

		setSize(parentSize);
		setBorder(new EmptyBorder(5, 5, 5, 0));

		// Icon
		JLabel itemIcon = new JLabel();
		itemIcon.setPreferredSize(ICON_SIZE);
		//final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "/skill_icons_small/attack.png");
		final ImageIcon icon = new ImageIcon(ImageUtil.getResourceStreamFromClass(getClass(),
			(fightPerformance.isPlayerDied() || fightPerformance.isOpponentDied() ? "skull_red.png" : "skull_white.png")));
		if (icon != null)
		{
			itemIcon.setIcon(icon);
			//icon.addTo(itemIcon);
		}
		add(itemIcon, BorderLayout.LINE_START);

		// Item details panel
		JPanel rightPanel = new JPanel(new GridLayout(2, 1));
		panels.add(rightPanel);
		rightPanel.setBackground(background);

		// player's stats, always first
		JPanel playerStatsPanel = new JPanel(new BorderLayout());
		playerStatsPanel.setBackground(background);

		JLabel playerStatsName = new JLabel();
		playerStatsName.setText(fightPerformance.getPlayerName());
		playerStatsName.setForeground(Color.WHITE);
		playerStatsPanel.add(playerStatsName, BorderLayout.WEST);

		JLabel playerStats = new JLabel();
		playerStats.setText(fightPerformance.getPlayerStatsString());
		playerStats.setForeground(fightPerformance.playerWinning() ? Color.GREEN : Color.WHITE);
		playerStatsPanel.add(playerStats, BorderLayout.EAST);

		rightPanel.add(playerStatsPanel);

		// opponent's stats, second
		JPanel opponentStatsPanel = new JPanel(new BorderLayout());
		opponentStatsPanel.setBackground(background);

		JLabel opponentStatsName = new JLabel();
		opponentStatsName.setText(fightPerformance.getOpponentName());
		opponentStatsName.setForeground(Color.WHITE);
		opponentStatsPanel.add(opponentStatsName, BorderLayout.WEST);

		JLabel opponentStats = new JLabel();
		opponentStats.setText(fightPerformance.getOpponentStatsString());
		opponentStats.setForeground(fightPerformance.opponentWinning() ? Color.GREEN : Color.WHITE);
		opponentStatsPanel.add(opponentStats, BorderLayout.EAST);

		rightPanel.add(opponentStatsPanel);

		add(rightPanel, BorderLayout.CENTER);
	}

//	private void matchComponentBackground(JPanel panel, Color color)
//	{
//		panel.setBackground(color);
//		for (Component c : panel.getComponents())
//		{
//			c.setBackground(color);
//		}
//	}
//
//	private static void geLink(String name, int itemID)
//	{
//		final String url = "http://services.runescape.com/m=itemdb_oldschool/"
//			+ name.replaceAll(" ", "_")
//			+ "/viewitem?obj="
//			+ itemID;
//
//		LinkBrowser.browse(url);
//	}
}