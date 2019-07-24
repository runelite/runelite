/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.pvptools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.inject.Singleton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.info.JRichTextPane;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;

@Slf4j
@Singleton
class PvpToolsPanel extends PluginPanel
{

	private final JLabel loggedLabel = new JLabel();
	private final JRichTextPane emailLabel = new JRichTextPane();
	final JLabel numCC = new JLabel();
	final JLabel numOther = new JLabel();
	final JLabel numMageJLabel = new JLabel(" ");
	final JLabel numRangeJLabel = new JLabel(" ");
	final JLabel numMeleeJLabel = new JLabel(" ");
	final JLabel totalRiskLabel = new JLabel(" ");
	final JLabel riskProtectingItem = new JLabel(" ");
	final JLabel biggestItemLabel = new JLabel("Protected Item: ");
	final JButton missingPlayers = new JButton("Show missing CC members");
	final JButton currentPlayers = new JButton("Show current CC members");
	private final JLabel numBrews = new JLabel();
	private final JPanel missingPlayersPanel = new JPanel();


	public static String htmlLabel(String key, String value)
	{
		return "<html><body style = 'color:#a5a5a5'>" + key + "<span style = 'color:white'>" + value + "</span></body></html>";
	}

	void init()
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(10, 10, 10, 10));


		JPanel versionPanel = new JPanel();
		versionPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		versionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		versionPanel.setLayout(new GridLayout(0, 1));

		JPanel riskPanel = new JPanel();
		riskPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		riskPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		riskPanel.setLayout(new GridLayout(0, 1));

		final Font smallFont = FontManager.getRunescapeSmallFont();

		numCC.setText(htmlLabel("Friendly Player Count: ", "0"));
		numOther.setText(htmlLabel("Other Player Count: ", "0"));
		numBrews.setText(htmlLabel("Player brew count: ", "0"));
		numMageJLabel.setText(htmlLabel("Enemies Praying Mage: ", "0"));
		numMageJLabel.setFont(FontManager.getRunescapeFont());
		numRangeJLabel.setText(htmlLabel("Enemies Praying Range: ", "0"));
		numRangeJLabel.setFont(FontManager.getRunescapeFont());
		numMeleeJLabel.setText(htmlLabel("Enemies Praying Melee: ", "0"));
		numMeleeJLabel.setFont(FontManager.getRunescapeFont());

		totalRiskLabel.setText(htmlLabel("Total risk: ", "0"));
		totalRiskLabel.setFont(FontManager.getRunescapeFont());
		riskProtectingItem.setText(htmlLabel("Risk Protecting Item: ", "0"));
		riskProtectingItem.setFont(FontManager.getRunescapeFont());
		biggestItemLabel.setText("Most Valuable Item: ");


		JLabel revision = new JLabel();
		revision.setFont(smallFont);

		revision.setText("Oldschool revision: ");

		loggedLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		loggedLabel.setFont(smallFont);

		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(smallFont);

		versionPanel.add(numCC);
		versionPanel.add(numOther);
		versionPanel.add(numBrews);
		versionPanel.add(numMageJLabel);
		versionPanel.add(numRangeJLabel);
		versionPanel.add(numMeleeJLabel);

		versionPanel.add(Box.createGlue());
		versionPanel.add(loggedLabel);
		versionPanel.add(emailLabel);

		riskPanel.add(totalRiskLabel);
		riskPanel.add(riskProtectingItem);
		riskPanel.add(biggestItemLabel);

		add(versionPanel, BorderLayout.NORTH);
		add(riskPanel, BorderLayout.CENTER);

		currentPlayers.setVisible(false);
		missingPlayers.setVisible(false);
		missingPlayersPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		missingPlayersPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		missingPlayersPanel.setLayout(new GridLayout(0, 1));
		missingPlayersPanel.add(missingPlayers, BorderLayout.AFTER_LAST_LINE);
		missingPlayersPanel.add(currentPlayers, BorderLayout.AFTER_LAST_LINE);
		add(missingPlayersPanel, BorderLayout.AFTER_LAST_LINE);

	}

	void disablePlayerCount()
	{
		this.numOther.setText("Disabled");
		this.numCC.setText("Disabled");
		this.numCC.repaint();
		this.numOther.repaint();
	}

	void disablePrayerCount()
	{
		this.numMageJLabel.setText("disabled");
		this.numRangeJLabel.setText("disabled");
		this.numMeleeJLabel.setText("disabled");
		this.numMageJLabel.repaint();
		this.numRangeJLabel.repaint();
		this.numMeleeJLabel.repaint();
	}

	void disableRiskCalculator()
	{
		this.totalRiskLabel.setText("disabled");
		this.riskProtectingItem.setText("disabled");
		this.biggestItemLabel.setText("disabled");
		this.totalRiskLabel.repaint();
		this.riskProtectingItem.repaint();
		this.biggestItemLabel.repaint();
	}
}
