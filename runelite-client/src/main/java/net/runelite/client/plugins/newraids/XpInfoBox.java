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
package net.runelite.client.plugins.newraids;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.ImageUtil;

class XpInfoBox extends JPanel
{
	static final DecimalFormat POINTS_FORMAT = new DecimalFormat("#,###");
	private static final DecimalFormat TWO_DECIMAL_FORMAT = new DecimalFormat("0.00");
	// Templates
	private static final String HTML_TOOL_TIP_TEMPLATE =
		"<html>%s %s done<br/>"
			+ "%s %s/hr<br/>"
			+ "%s till goal lvl</html>";
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

	// Instance members
	private final JPanel panel;

	@Getter(AccessLevel.PACKAGE)
	private final data raid;

	/* The tracker's wrapping container */
	private final JPanel container = new JPanel();

	/* Contains the skill icon and the stats panel */
	private final JPanel headerPanel = new JPanel();

	/* Contains all the skill information (exp gained, per hour, etc) */
	private final JPanel statsPanel = new JPanel();


	private final JLabel personalPoints = new JLabel();
	private final JLabel hourlyPoints = new JLabel();
	private final JLabel totalPoints = new JLabel();
	private final JLabel raidTime = new JLabel();
	private final JLabel layout = new JLabel();
	private final JLabel teamHour = new JLabel();
	private final JLabel killCount = new JLabel();
	private final JMenuItem pauseSkill = new JMenuItem("Pause");

	private RaidsConfig raidsConfig;

	private boolean paused = false;

	XpInfoBox(RaidsPlugin raidsPlugin, RaidsConfig raidsConfig, Client client, JPanel panel, data raid, SkillIconManager iconManager) throws IOException
	{
		this.raidsConfig = raidsConfig;
		this.panel = panel;
		this.raid = raid;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 0, 0, 0));

		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);


		// Create reset others menu
		//pauseSkill.addActionListener(e -> raidsPlugin.pauseSkill(skill, !paused));

		BufferedImage image = ImageUtil.getResourceStreamFromClass(this.getClass(), "cox.png");
		ImageIcon i = new ImageIcon(image);

		JLabel skillIcon = new JLabel(i);
		skillIcon.setHorizontalAlignment(SwingConstants.CENTER);
		skillIcon.setVerticalAlignment(SwingConstants.CENTER);
		skillIcon.setPreferredSize(new Dimension(35, 35));

		headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		headerPanel.setLayout(new BorderLayout());


		statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		statsPanel.setBorder(new EmptyBorder(9, 2, 9, 2));
		statsPanel.setLayout(new DynamicGridLayout(3, 2));
		personalPoints.setFont(FontManager.getRunescapeSmallFont());
		personalPoints.setText("Personal: " + POINTS_FORMAT.format(raid.personal));
		hourlyPoints.setFont(FontManager.getRunescapeSmallFont());
		hourlyPoints.setText("Points/Hr: " + POINTS_FORMAT.format(raid.hr));
		totalPoints.setFont(FontManager.getRunescapeSmallFont());
		totalPoints.setText("Total: " + POINTS_FORMAT.format(raid.total));
		teamHour.setFont(FontManager.getRunescapeSmallFont());
		teamHour.setText("Points/Hr: " + POINTS_FORMAT.format((((float) raid.total / raid.timeTaken) * 3600)));
		killCount.setFont(FontManager.getRunescapeSmallFont());
		killCount.setText("KC: " + raid.kc);
		raidTime.setFont(FontManager.getRunescapeSmallFont());
		raidTime.setText("Time: " + formatSeconds(raid.timeTaken));
		//maybe add drop rate
		statsPanel.add(personalPoints);
		statsPanel.add(totalPoints);
		statsPanel.add(hourlyPoints);
		statsPanel.add(teamHour);
		statsPanel.add(killCount);
		statsPanel.add(raidTime);


		headerPanel.add(skillIcon, BorderLayout.WEST);
		headerPanel.add(statsPanel, BorderLayout.CENTER);

		JPanel progressWrapper = new JPanel();
		progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		progressWrapper.setLayout(new BorderLayout());
		progressWrapper.setBorder(new EmptyBorder(0, 7, 7, 7));
		layout.setFont(FontManager.getRunescapeSmallFont());
		if (raid.cm)
		{
			layout.setText("<html><p>Challenge Mode</p></html>");
		}
		else
		{
			layout.setText("<html><p>" + raid.raid + "</p></html>");
		}


		progressWrapper.add(layout, BorderLayout.NORTH);

		container.add(headerPanel, BorderLayout.NORTH);
		container.add(progressWrapper, BorderLayout.SOUTH);


		add(container, BorderLayout.NORTH);
	}


	static String htmlLabel(String key, int value)
	{
		String valueStr = POINTS_FORMAT.format(value);
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}

	static String htmlLabel(String key, String value)
	{
		String valueStr = value;
		return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
	}

	public static String formatSeconds(int timeInSeconds)
	{
		int hours = timeInSeconds / 3600;
		int secondsLeft = timeInSeconds - hours * 3600;
		int minutes = secondsLeft / 60;
		int seconds = secondsLeft - minutes * 60;

		String formattedTime = "";
		if (hours < 10)
		{
			formattedTime += "0";
		}
		formattedTime += hours + ":";

		if (minutes < 10)
		{
			formattedTime += "0";
		}
		formattedTime += minutes + ":";

		if (seconds < 10)
		{
			formattedTime += "0";
		}
		formattedTime += seconds;

		return formattedTime;
	}
}
