package net.runelite.client.plugins.slayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.Collections;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.ProgressBar;
import net.runelite.client.util.QuantityFormatter;

@Singleton
class TaskBox extends JPanel
{
	private static final long MILLIS_PER_SECOND = 1000;
	private static final long SECONDS_PER_MINUTE = 60;
	private static final long MINUTES_PER_HOUR = 60;
	private static final long MILLIS_PER_HOUR = MILLIS_PER_SECOND * SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

	private static final DecimalFormat TWO_DECIMAL_FORMAT = new DecimalFormat("0.00");


	// Templates
	private static final String HTML_TOOL_TIP_TEMPLATE =
		"<html>%.1f Kills/hr<br/>" +
			"%02d:%02d:%02d per kill</html>";
	private static final String HTML_LABEL_TEMPLATE =
		"<html><body style='color:white'>%s</body></html>";
	private static final String HTML_TIME_LABEL_TEMPLATE =
		"<html><body style='color:white'>%02d:%02d:%02d</span></body></html>";

	// Instance members
	private final JPanel panel;

	@Getter(AccessLevel.PACKAGE)
	private final TaskData taskData;

	/* Contains the task icon and the stats panel */
	private final JPanel headerPanel = new JPanel();

	/* Contains the overall stats of the slayer task */
	private final JPanel statsPanel = new JPanel();

	private final ProgressBar progressBar = new ProgressBar();

	private final JLabel elapsed = new JLabel("Elapsed:");
	private final JLabel remaining = new JLabel("Remaining:");
	private final JLabel duration = new JLabel("Time:");
	private final JLabel currentDuration = new JLabel();
	private final JLabel remainingDuration = new JLabel();
	private final JLabel kills = new JLabel("Kills:");
	private final JLabel currentKills = new JLabel();
	private final JLabel remainingKills = new JLabel();
	private final JLabel xp = new JLabel("XP:");
	private final JLabel currentXp = new JLabel();
	private final JLabel remainingXp = new JLabel();

	private boolean paused = false;

	TaskBox(SlayerPlugin slayerPlugin, JPanel panel, TaskData taskData)
	{
		this.panel = panel;
		this.taskData = taskData;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 0, 0, 0));

		/* This task's wrapping container */
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		SwingUtilities.invokeLater(() ->
		{
			BufferedImage taskImg = slayerPlugin.getImageForTask(Task.getTask(taskData.getTaskName()));
			JLabel taskIcon = new JLabel(new ImageIcon(taskImg));
			taskIcon.setHorizontalAlignment(SwingConstants.CENTER);
			taskIcon.setVerticalAlignment(SwingConstants.CENTER);
			taskIcon.setPreferredSize(new Dimension(35, 35));

			statsPanel.setLayout(new DynamicGridLayout(4, 3));
			statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
			statsPanel.setBorder(new EmptyBorder(9, 2, 9, 2));

			elapsed.setFont(FontManager.getRunescapeSmallFont());
			remaining.setFont(FontManager.getRunescapeSmallFont());
			duration.setFont(FontManager.getRunescapeSmallFont());
			currentDuration.setFont(FontManager.getRunescapeSmallFont());
			remainingDuration.setFont(FontManager.getRunescapeSmallFont());
			kills.setFont(FontManager.getRunescapeSmallFont());
			currentKills.setFont(FontManager.getRunescapeSmallFont());
			remainingKills.setFont(FontManager.getRunescapeSmallFont());
			xp.setFont(FontManager.getRunescapeSmallFont());
			currentXp.setFont(FontManager.getRunescapeSmallFont());
			remainingXp.setFont(FontManager.getRunescapeSmallFont());

			statsPanel.add(new JLabel());
			statsPanel.add(elapsed);
			statsPanel.add(remaining);
			statsPanel.add(duration);
			statsPanel.add(currentDuration);
			statsPanel.add(remainingDuration);
			statsPanel.add(kills);
			statsPanel.add(currentKills);
			statsPanel.add(remainingKills);
			statsPanel.add(xp);
			statsPanel.add(currentXp);
			statsPanel.add(remainingXp);

			headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
			headerPanel.setLayout(new BorderLayout());

			headerPanel.add(statsPanel, BorderLayout.CENTER);
			headerPanel.add(taskIcon, BorderLayout.WEST);
		});

		JPanel progressWrapper = new JPanel();
		progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		progressWrapper.setLayout(new BorderLayout());
		progressWrapper.setBorder(new EmptyBorder(0, 7, 7, 7));

		progressBar.setMaximumValue(100);
		progressBar.setBackground(new Color(61, 56, 49));

		progressWrapper.add(progressBar, BorderLayout.NORTH);

		final JPanel logTitle = new JPanel(new BorderLayout(5, 0));
		logTitle.setBorder(new EmptyBorder(7, 7, 7, 7));
		logTitle.setBackground(ColorScheme.DARKER_GRAY_COLOR.darker());

		String taskName = taskData.getTaskName();
		taskName = taskName.substring(0, 1).toUpperCase() + taskName.substring(1);
		final JLabel titleLabel = new JLabel(taskName);
		titleLabel.setFont(FontManager.getRunescapeSmallFont());
		titleLabel.setForeground(Color.WHITE);

		logTitle.add(titleLabel, BorderLayout.WEST);

		final JLabel subTitleLabel = new JLabel("x " + taskData.getInitialAmount());
		subTitleLabel.setFont(FontManager.getRunescapeSmallFont());
		subTitleLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

		logTitle.add(subTitleLabel, BorderLayout.CENTER);

		if (taskData.getTaskLocation() != null && !taskData.getTaskLocation().equals(""))
		{
			final JLabel locationLabel = new JLabel(taskData.getTaskLocation());
			locationLabel.setFont(FontManager.getRunescapeSmallFont());
			locationLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

			logTitle.add(locationLabel, BorderLayout.EAST);
		}

		container.add(logTitle, BorderLayout.NORTH);
		container.add(headerPanel, BorderLayout.CENTER);
		container.add(progressWrapper, BorderLayout.SOUTH);

		add(container, BorderLayout.NORTH);
	}

	void update(boolean updated, boolean paused, TaskData newData)
	{
		SwingUtilities.invokeLater(() -> rebuildAsync(updated, paused, newData));
	}

	private void rebuildAsync(boolean updated, boolean taskPaused, TaskData newData)
	{
		if (updated)
		{
			if (getParent() != panel)
			{
				panel.add(this, 0);
				panel.revalidate();
			}

			// Update data
			taskData.setElapsedKills(newData.getElapsedKills());
			taskData.setAmount(newData.getAmount());
			taskData.setElapsedXp(newData.getElapsedXp());

			// Update information labels
			int kills = taskData.getInitialAmount() - taskData.getAmount();
			currentKills.setText(htmlLabel(taskData.getElapsedKills()));
			remainingKills.setText(htmlLabel(taskData.getAmount()));

			currentXp.setText(htmlLabel(taskData.getElapsedXp()));
			double xpPerKill = ((double) taskData.getElapsedXp()) / ((double) taskData.getElapsedKills());
			double xpLeft = xpPerKill * taskData.getAmount();
			remainingXp.setText(htmlLabel((int) xpLeft));

			// Update progress bar
			double percentComplete = ((double) kills) / ((double) taskData.getInitialAmount());
			progressBar.setForeground(new Color(98, 70, 70));
			progressBar.setValue((int) (percentComplete * 100));
			progressBar.setCenterLabel(TWO_DECIMAL_FORMAT.format(percentComplete * 100) + "%");
			progressBar.setLeftLabel("0 Kc");
			progressBar.setRightLabel(taskData.getInitialAmount() + " Kc");
			progressBar.setPositions(Collections.emptyList());

			double killsPerMillis = ((double) taskData.getElapsedKills() - 1) / ((double) taskData.getElapsedTime());
			if (killsPerMillis > 0)
			{
				double killsPerHour = killsPerMillis * MILLIS_PER_HOUR;
				double millisPerKill = 1.0 / killsPerMillis;
				long seconds = ((long) millisPerKill) / MILLIS_PER_SECOND;
				long minutes = seconds / SECONDS_PER_MINUTE;
				seconds %= 60;
				long hours = minutes / MINUTES_PER_HOUR;
				minutes %= 60;
				progressBar.setToolTipText(String.format(
					HTML_TOOL_TIP_TEMPLATE,
					killsPerHour,
					hours,
					minutes,
					seconds
				));
			}

			if (taskData.getAmount() == 0 && taskData.getElapsedXp() == 0)
			{
				progressBar.setDimmedText("Skipped");
				progressBar.setForeground(new Color(128, 0, 0));
			}
			else if ((taskData.getAmount() == 0 && taskData.getElapsedXp() > 0) || (int) (percentComplete * 100) >= 100)
			{
				progressBar.setDimmedText("Finished");
				progressBar.setForeground(new Color(0, 128, 0));
			}
			else
			{
				progressBar.setDimmedText("Paused");
			}

			progressBar.setDimmed(taskPaused);
			progressBar.repaint();
		}
		else if (!paused && taskPaused)
		{
			progressBar.setDimmedText("Paused");
			progressBar.setDimmed(true);
			progressBar.repaint();
			paused = true;
		}
		else if (paused && !taskPaused)
		{
			progressBar.setDimmed(false);
			progressBar.repaint();
			paused = false;
		}

		// Update duration separately, every time (not only when there's an update)
		taskData.setElapsedTime(newData.getElapsedTime());
		currentDuration.setText(htmlLabel(taskData.getElapsedTime()));
		remainingDuration.setText(htmlLabel(estimateRemainingTime(taskData)));

		repaint();
	}

	private static long estimateRemainingTime(TaskData taskData)
	{
		int kills = taskData.getElapsedKills();
		int killsInElapsedTime = kills - 1; // b/c time only elapses after 1st slayer drop
		if (killsInElapsedTime < 1)
		{
			return Long.MAX_VALUE;
		}
		double timePerKill = ((double) taskData.getElapsedTime()) / ((double) killsInElapsedTime);

		return (long) timePerKill * taskData.getAmount();
	}

	private static String htmlLabel(long timeMillis)
	{
		if (timeMillis == Long.MAX_VALUE)
		{
			String valueStr = "N/A";
			return String.format(HTML_LABEL_TEMPLATE, valueStr);
		}
		else
		{
			long seconds = timeMillis / MILLIS_PER_SECOND;
			long minutes = seconds / SECONDS_PER_MINUTE;
			seconds %= 60;
			long hours = minutes / MINUTES_PER_HOUR;
			minutes %= 60;
			return String.format(HTML_TIME_LABEL_TEMPLATE, (int) hours, (int) minutes, (int) seconds);
		}
	}

	private static String htmlLabel(int value)
	{
		String valueStr = QuantityFormatter.quantityToRSDecimalStack(value);
		return String.format(HTML_LABEL_TEMPLATE, valueStr);
	}
}