/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018 Charlie Waters
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

import java.awt.*;
import java.io.IOException;
import java.text.NumberFormat;
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
import net.runelite.api.Experience;
import net.runelite.client.game.SkillIconManager;

@Slf4j
class XpInfoBox extends JPanel
{

	private static final Color[] PROGRESS_COLORS = new Color[]
	{
		Color.RED, Color.YELLOW, Color.GREEN
	};

	private final Client client;
	private final XpTrackerConfig config;
	private final JPanel panel;
	@Getter(AccessLevel.PACKAGE)
	private final SkillXPInfo xpInfo;
	private boolean goalSet = false;

	private final JProgressBar progressBar = new JProgressBar();
	private final JProgressBar lvlProgressBar = new JProgressBar();
	private final JLabel xpHr = new JLabel();
	private final JLabel xpGained = new JLabel();
	private final JLabel actionsHr = new JLabel();
	private final JLabel actions = new JLabel();

	XpInfoBox(Client client, XpTrackerConfig config, JPanel panel, SkillXPInfo xpInfo, SkillIconManager iconManager) throws IOException
	{
		this.client = client;
		this.config = config;
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

		// Create goal progress bar
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setBackground(Color.RED);

		// Create level progress bar
		lvlProgressBar.setStringPainted(false);
		lvlProgressBar.setValue(0);
		lvlProgressBar.setMinimum(0);
		lvlProgressBar.setMaximum(100);
		lvlProgressBar.setBackground(Color.RED);
		lvlProgressBar.setPreferredSize(new Dimension(0, 5));
		lvlProgressBar.setVisible(false);

		// Create panel for progress bars
		final JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = c.gridy = 0;
		c.weightx = 0.5;
		c.weighty = 0.25;
		southPanel.add(progressBar, c);
		c.gridy = 1;
		c.weighty = 0.75;
		southPanel.add(lvlProgressBar, c);

		container.add(resetIcon, BorderLayout.LINE_START);
		container.add(rightPanel, BorderLayout.CENTER);
		container.add(southPanel, BorderLayout.SOUTH);
		add(container, BorderLayout.CENTER);
	}

	void reset()
	{
		goalSet = false;
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

		final int currentXp = client.getSkillExperience(xpInfo.getSkill());
		xpInfo.setStartXp(currentXp);
	}

	void setGoal(int level)
	{
		goalSet = true;
		xpInfo.setGoalXp(Experience.getXpForLevel(level));
		// update the current xp so the level bar is immediately accurate
		xpInfo.updateXp(client.getSkillExperience(xpInfo.getSkill()));
		// force a refresh so the skill is added to the panel
		panelRefresh(true);
	}

	void update()
	{
		if (xpInfo.getStartXp() == -1)
		{
			return;
		}

		final int currentXp = client.getSkillExperience(xpInfo.getSkill());
		final boolean updated = xpInfo.update(currentXp);

		if (currentXp >= xpInfo.getGoalXp() && config.clearOnGoal())
		{
			goalSet = false;
		}

		SwingUtilities.invokeLater(() ->
		{
			panelRefresh(updated);
		});
	}

	private void panelRefresh(boolean updated)
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

			// first progress bar shows goal progress if goal set
			final int progress = goalSet ? xpInfo.getGoalProgress() : xpInfo.getLevelProgress();
			progressBar.setValue(progress);
			progressBar.setBackground(interpolateColors(PROGRESS_COLORS, (double) progress / 100d));

			// second progress bar only visible when goal set
			lvlProgressBar.setVisible(goalSet && config.showLevelProgress());

			if(goalSet) {
				// when goal is set, first bar shows goal, second bar shows level
				progressBar.setToolTipText("<html>"
						+ XpPanel.formatLine(xpInfo.getGoalXpRemaining(), "xp to goal")
						+ "<br/>"
						+ XpPanel.formatLine(xpInfo.getGoalActionsRemaining(), "actions remaining")
						+ "</html>");

				final int lvlProgress = xpInfo.getLevelProgress();
				lvlProgressBar.setValue(lvlProgress);
				lvlProgressBar.setBackground(interpolateColors(PROGRESS_COLORS, (double) lvlProgress / 100d));

				lvlProgressBar.setToolTipText("<html>"
						+ XpPanel.formatLine(xpInfo.getLevelXpRemaining(), "xp to level")
						+ "<br/>"
						+ XpPanel.formatLine(xpInfo.getLevelActionsRemaining(), "actions remaining")
						+ "</html>");
			}
			else
			{
				// when goal is not set, first bar shows level
				progressBar.setToolTipText("<html>"
						+ XpPanel.formatLine(xpInfo.getLevelXpRemaining(), "xp to level")
						+ "<br/>"
						+ XpPanel.formatLine(xpInfo.getLevelActionsRemaining(), "actions remaining")
						+ "</html>");
			}

			final int startXp = xpInfo.getStartXp();
			final int goalXp = xpInfo.getGoalXp();
			if(startXp > 0 && goalXp > 0)
			{
				setToolTipText("<html>"
						+ "start: " + NumberFormat.getInstance().format(Experience.getLevelForXp(startXp)) + " (" + NumberFormat.getInstance().format(startXp) + " xp)"
						+ "<br/>"
						+ "goal: " + NumberFormat.getInstance().format(Experience.getLevelForXp(goalXp)) + " (" + NumberFormat.getInstance().format(goalXp) + " xp)"
						+ "</html>");
			}
		}

		// Always update xp/hr and actions/hr as time always changes
		xpGained.setText(XpPanel.formatLine(xpInfo.getXpHr(), "xp/hr"));
		actionsHr.setText(XpPanel.formatLine(xpInfo.getActionsHr(), "actions/hr"));
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
