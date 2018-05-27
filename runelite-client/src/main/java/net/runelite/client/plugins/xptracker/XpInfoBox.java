/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.ProgressBar;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.StackFormatter;
import net.runelite.client.util.SwingUtil;

@Slf4j
class XpInfoBox extends JPanel
{
	private final JPanel panel;

	@Getter(AccessLevel.PACKAGE)
	private final Skill skill;

	/* The tracker's wrapping container */
	private final JPanel container = new JPanel();

	/* Contains the skill icon and the stats panel */
	private final JPanel headerPanel = new JPanel();

	/* Contains all the skill information (exp gained, per hour, etc) */
	private final JPanel statsPanel = new JPanel();

	private final ProgressBar progressBar = new ProgressBar();

	private final JLabel expGained = new JLabel();
	private final JLabel expHour = new JLabel();
	private final JLabel expLeft = new JLabel();
	private final JLabel actionsLeft = new JLabel();

	XpInfoBox(XpTrackerPlugin xpTrackerPlugin, Client client, JPanel panel, Skill skill, SkillIconManager iconManager) throws IOException
	{
		this.panel = panel;
		this.skill = skill;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 0, 0, 0));

		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		// Create open xp tracker menu
		final JMenuItem openXpTracker = new JMenuItem("Open online tracker");
		openXpTracker.addActionListener(e -> LinkBrowser.browse(XpPanel.buildXpTrackerUrl(client.getLocalPlayer(), skill)));

		// Create reset menu
		final JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(e -> xpTrackerPlugin.resetSkillState(skill));

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(openXpTracker);
		popupMenu.add(reset);

		JLabel skillIcon = new JLabel(new ImageIcon(iconManager.getSkillImage(skill)));
		skillIcon.setHorizontalAlignment(SwingConstants.CENTER);
		skillIcon.setVerticalAlignment(SwingConstants.CENTER);
		skillIcon.setPreferredSize(new Dimension(35, 35));

		headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		headerPanel.setLayout(new BorderLayout());

		statsPanel.setLayout(new BorderLayout());
		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		statsPanel.setBorder(new EmptyBorder(9, 5, 9, 10));

		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		leftPanel.setLayout(new GridLayout(2, 1));

		expGained.setFont(FontManager.getRunescapeSmallFont());
		expHour.setFont(FontManager.getRunescapeSmallFont());

		leftPanel.add(expGained);
		leftPanel.add(expHour);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		rightPanel.setLayout(new GridLayout(2, 1));

		expLeft.setFont(FontManager.getRunescapeSmallFont());
		actionsLeft.setFont(FontManager.getRunescapeSmallFont());

		rightPanel.add(expLeft);
		rightPanel.add(actionsLeft);

		statsPanel.add(leftPanel, BorderLayout.WEST);
		statsPanel.add(rightPanel, BorderLayout.EAST);

		headerPanel.add(skillIcon, BorderLayout.WEST);
		headerPanel.add(statsPanel, BorderLayout.CENTER);

		JPanel progressWrapper = new JPanel();
		progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		progressWrapper.setLayout(new BorderLayout());
		progressWrapper.setBorder(new EmptyBorder(0, 7, 7, 7));

		progressBar.setMaximumValue(100);
		progressBar.setBackground(new Color(61, 56, 49));
		progressBar.setForeground(SkillColor.values()[skill.ordinal()].getColor());

		progressWrapper.add(progressBar, BorderLayout.NORTH);

		container.add(headerPanel, BorderLayout.NORTH);
		container.add(progressWrapper, BorderLayout.SOUTH);

		container.setComponentPopupMenu(popupMenu);
		progressBar.setComponentPopupMenu(popupMenu);

		add(container, BorderLayout.NORTH);
	}

	void reset()
	{
		container.remove(statsPanel);
		panel.remove(this);
		panel.revalidate();
	}

	void update(boolean updated, XpSnapshotSingle xpSnapshotSingle)
	{
		SwingUtilities.invokeLater(() -> rebuildAsync(updated, xpSnapshotSingle));
	}

	private void rebuildAsync(boolean updated, XpSnapshotSingle xpSnapshotSingle)
	{
		if (updated)
		{
			if (getParent() != panel)
			{
				panel.add(this);
				panel.revalidate();
			}

			// Update information labels
			expGained.setText(htmlLabel("XP Gained: ", xpSnapshotSingle.getXpGainedInSession()));
			expLeft.setText(htmlLabel("XP Left: ", xpSnapshotSingle.getXpRemainingToGoal()));
			actionsLeft.setText(htmlLabel("Actions: ", xpSnapshotSingle.getActionsRemainingToGoal()));

			// Update progress bar
			progressBar.setValue(xpSnapshotSingle.getSkillProgressToGoal());
			progressBar.setCenterLabel(xpSnapshotSingle.getSkillProgressToGoal() + "%");
			progressBar.setLeftLabel("Lvl. " + xpSnapshotSingle.getStartLevel());
			progressBar.setRightLabel("Lvl. " + (xpSnapshotSingle.getEndLevel()));

			progressBar.setToolTipText("<html>"
				+ xpSnapshotSingle.getActionsInSession() + " actions done"
				+ "<br/>"
				+ xpSnapshotSingle.getActionsPerHour() + " actions/hr"
				+ "<br/>"
				+ xpSnapshotSingle.getTimeTillGoal() + " till goal lvl"
				+ "</html>");

			progressBar.repaint();
		}

		// Update exp per hour seperately, everytime (not only when there's an update)
		expHour.setText(htmlLabel("XP/Hour: ", xpSnapshotSingle.getXpPerHour()));
	}

	public static String htmlLabel(String key, int value)
	{
		String valueStr = StackFormatter.quantityToRSDecimalStack(value);

		return "<html><body style = 'color:" + SwingUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR) + "'>" + key + "<span style = 'color:white'>" + valueStr + "</span></body></html>";
	}

}
