/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.game.SkillIconManager;

@Slf4j
class XpInfoBox extends JPanel
{

	private static final Color[] PROGRESS_COLORS = new Color[]
	{
		Color.RED, Color.YELLOW, Color.GREEN
	};

	private final Client client;
	private final JPanel panel;
	@Getter(AccessLevel.PACKAGE)
	private final SkillXPInfo xpInfo;

	private final JProgressBar progressBar = new JProgressBar();
	private final JLabel xpHr = new JLabel();
	private final JLabel xpGained = new JLabel();
	private final JLabel actionsHr = new JLabel();
	private final JLabel actions = new JLabel();

	XpInfoBox(Client client, JPanel panel, SkillXPInfo xpInfo, SkillIconManager iconManager) throws IOException
	{
		this.client = client;
		this.panel = panel;
		this.xpInfo = xpInfo;

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(getBackground().brighter(), 1, true));

		final JPanel container = new JPanel();
		container.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		container.setLayout(new BorderLayout(3, 3));

		// Create skill/reset icon
		final JButton resetIcon = new JButton(new ImageIcon(iconManager.getSkillImage(xpInfo.getSkill())));
		resetIcon.setToolTipText("Reset " + xpInfo.getSkill().getName() + " tracker");
		resetIcon.setPreferredSize(new Dimension(64, 64));
		resetIcon.addActionListener(e -> reset());

		// Create info panel
		final JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(4, 1));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
		rightPanel.add(xpHr);
		rightPanel.add(xpGained);
		rightPanel.add(actionsHr);
		rightPanel.add(actions);

		// Create progress bar
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBackground(Color.RED);

		container.add(resetIcon, BorderLayout.LINE_START);
		container.add(rightPanel, BorderLayout.CENTER);
		container.add(progressBar, BorderLayout.SOUTH);
		add(container, BorderLayout.CENTER);
	}

	void reset()
	{
		xpInfo.reset(client.getSkillExperience(xpInfo.getSkill()));
		panel.remove(this);
		panel.revalidate();
	}

	void init()
	{
		if (xpInfo.getStartXp() != -1)
		{
			return;
		}

		xpInfo.setStartXp(client.getSkillExperience(xpInfo.getSkill()));
	}

	void update()
	{
		if (xpInfo.getStartXp() == -1)
		{
			return;
		}

		boolean updated = xpInfo.update(client.getSkillExperience(xpInfo.getSkill()));

		SwingUtilities.invokeLater(() ->
		{
			if (updated)
			{
				if (getParent() != panel)
				{
					panel.add(this);
					panel.revalidate();
				}

				xpHr.setText(XpPanel.formatLine(xpInfo.getXpGained(), "xp gained"));
				actions.setText(XpPanel.formatLine(xpInfo.getActions(), "actions"));

				final int progress = xpInfo.getSkillProgress();

				progressBar.setValue(progress);
				progressBar.setBackground(interpolateColors(PROGRESS_COLORS, (double) progress / 100d));

				progressBar.setToolTipText("<html>"
					+ XpPanel.formatLine(xpInfo.getXpRemaining(), "xp remaining")
					+ "<br/>"
					+ XpPanel.formatLine(xpInfo.getActionsRemaining(), "actions remaining")
					+ "</html>");
			}

			// Always update xp/hr and actions/hr as time always changes
			xpGained.setText(XpPanel.formatLine(xpInfo.getXpHr(), "xp/hr"));
			actionsHr.setText(XpPanel.formatLine(xpInfo.getActionsHr(), "actions/hr"));
		});
	}

	/**
	 * Interpolate between array of colors using Normal (Gaussian)
	 * distribution
	 *
	 * @see
	 * <a href="https://en.wikipedia.org/wiki/Normal_distribution}">Normal
	 * distribution on Wikipedia</a>
	 * @param colors array of colors
	 * @param x distribution factor
	 * @return interpolated color
	 */
	private static Color interpolateColors(Color[] colors, double x)
	{
		double r = 0.0, g = 0.0, b = 0.0;
		double total = 0.0;
		double step = 1.0 / (double) (colors.length - 1);
		double mu = 0.0;
		double sigma2 = 0.035;

		for (Color ignored : colors)
		{
			total += Math.exp(-(x - mu) * (x - mu) / (2.0 * sigma2)) / Math.sqrt(2.0 * Math.PI * sigma2);
			mu += step;
		}

		mu = 0.0;

		for (Color color : colors)
		{
			double percent = Math.exp(-(x - mu) * (x - mu) / (2.0 * sigma2)) / Math.sqrt(2.0 * Math.PI * sigma2);
			mu += step;

			r += color.getRed() * percent / total;
			g += color.getGreen() * percent / total;
			b += color.getBlue() * percent / total;
		}

		return new Color((int) r, (int) g, (int) b);
	}
}
