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
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.util.List;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.runelite.api.Client;
import net.runelite.client.ui.FontManager;

@Singleton
class MissingPlayersJFrame extends JFrame
{

	MissingPlayersJFrame(final Client client, final PvpToolsPlugin pvpToolsPlugin, final List<String> list)
	{
		super();
		int x = client.getCanvas().getLocationOnScreen().x + client.getCanvas().getWidth();
		int y = client.getCanvas().getLocationOnScreen().y;
		JPanel scrollConatiner = new JPanel(new BorderLayout());

		JScrollPane jScrollPane = new JScrollPane(scrollConatiner);
		JButton refreshJButton = new JButton("Refresh");
		refreshJButton.addActionListener(pvpToolsPlugin.playersButtonActionListener);
		JButton copyJButton = new JButton("Copy List");
		JList<Object> missingPlayersJList = new JList<>(list.toArray());
		ActionListener copyButtonActionListener = e ->
		{
			StringSelection stringSelection;
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringBuilder stringBuilder = new StringBuilder();
			list.forEach(s ->
			{
				stringBuilder.append(s);
				stringBuilder.append(System.getProperty("line.separator"));
			});
			stringSelection = new StringSelection(stringBuilder.toString());
			clipboard.setContents(stringSelection, stringSelection);
		};
		copyJButton.addActionListener(copyButtonActionListener);
		this.setTitle("Missing CC Members");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel titleLabel = new JLabel("Missing CC Members");
		titleLabel.setFont(FontManager.getRunescapeFont().deriveFont(Font.BOLD, 18));
		missingPlayersJList.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollConatiner.add(refreshJButton, BorderLayout.NORTH);
		scrollConatiner.add(titleLabel, BorderLayout.CENTER);
		JPanel footerPanel = new JPanel(new BorderLayout());
		footerPanel.add(missingPlayersJList, BorderLayout.NORTH);
		footerPanel.add(copyJButton, BorderLayout.CENTER);
		scrollConatiner.add(footerPanel, BorderLayout.SOUTH);
		this.add(jScrollPane);
		this.setLocation(x, y);
		this.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.pack();
		this.setVisible(true);
	}
}
