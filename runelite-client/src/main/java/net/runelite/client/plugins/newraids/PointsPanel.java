package net.runelite.client.plugins.newraids;

import com.google.inject.Provides;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;

public class PointsPanel extends PluginPanel
{

	static final JPanel infoBoxPanel = new JPanel();
	public static ArrayList<data> raids = new ArrayList<data>();
	@Inject
	private static RaidsPlugin raidsPlugin;
	@Inject
	private static Client client;
	@Inject
	private static SkillIconManager iconManager;
	final JMenuItem pausePopup = new JMenuItem("Pause Timer");
	final JButton pauseButton = new JButton("Pause Timer");
	final JPanel overallInfo = new JPanel();
	private final Map<data, XpInfoBox> infoBoxes = new HashMap<>();
	private final JLabel overallPointsGained = new JLabel(XpInfoBox.htmlLabel("Personal Points: ", 0));
	private final JLabel overallPointsPerHour = new JLabel(XpInfoBox.htmlLabel("Per Hour: ", 0));
	private final JLabel teamPointsGained = new JLabel(XpInfoBox.htmlLabel("Team Points: ", 0));
	private final JLabel teamPointsPerHour = new JLabel(XpInfoBox.htmlLabel("Per Hour: ", 0));
	private final JLabel raidsCompleted = new JLabel(XpInfoBox.htmlLabel("Raids Done: ", 0));
	private final JLabel averageTime = new JLabel(XpInfoBox.htmlLabel("Avg. Raid Time: ", "00:00:00"));
	private final JLabel averagePoints = new JLabel(XpInfoBox.htmlLabel("Avg. Points: ", 0));
	private final JLabel averagePointsTeam = new JLabel(XpInfoBox.htmlLabel("Avg. Points: ", 0));
	private final JLabel elapsedTime = new JLabel(XpInfoBox.htmlLabel("Elapsed Time: ", "00:00:00"));
	private final JLabel blankline1 = new JLabel("<html><br></html>");
	private final JLabel blankline = new JLabel("<html><br></html>");
	private final JLabel blankline2 = new JLabel("<html><br></html>");
	private final JPanel overallPanel = new JPanel();
	public Date finalTime = new Date();
	public Date tempTime = new Date();
	public boolean paused = false;
	public boolean soloMode;
	timerSpecial timer = new timerSpecial();
	ActionListener action = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			updateTime();
		}
	};
	@Inject
	private RaidsConfig raidsConfig;

	PointsPanel(RaidsPlugin raidsPlugin, RaidsConfig raidsConfig, Client client, SkillIconManager iconManager)
	{

		super();
		setBorder(new EmptyBorder(6, 6, 6, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		final JPanel layoutPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(layoutPanel, BoxLayout.Y_AXIS);
		layoutPanel.setLayout(boxLayout);
		add(layoutPanel, BorderLayout.NORTH);

		overallPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());
		overallPanel.setVisible(true); // this will only become visible when the player gets exp

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset Tracker");
		reset.addActionListener(e -> resetAll(true));

		pausePopup.addActionListener(e -> pauseTime());
		pauseButton.addActionListener(e -> pauseTime());


		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(reset);
		popupMenu.add(pausePopup);
		overallPanel.setComponentPopupMenu(popupMenu);
		final BufferedImage image = ImageUtil.getResourceStreamFromClass(this.getClass(), "cox.png");
		ImageIcon i = new ImageIcon(image);
		final JLabel overallIcon = new JLabel(i);


		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(12, 1));
		overallInfo.setBorder(new EmptyBorder(0, 10, 0, 0));
		pauseButton.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(pauseButton);
		overallPointsGained.setFont(FontManager.getRunescapeSmallFont());
		overallPointsPerHour.setFont(FontManager.getRunescapeSmallFont());
		teamPointsGained.setFont(FontManager.getRunescapeSmallFont());
		raidsCompleted.setFont(FontManager.getRunescapeSmallFont());
		averagePoints.setFont(FontManager.getRunescapeSmallFont());
		averageTime.setFont(FontManager.getRunescapeSmallFont());
		teamPointsPerHour.setFont(FontManager.getRunescapeSmallFont());
		blankline1.setFont(FontManager.getRunescapeSmallFont());
		blankline.setFont(FontManager.getRunescapeSmallFont());
		blankline2.setFont(FontManager.getRunescapeSmallFont());
		averagePointsTeam.setFont(FontManager.getRunescapeSmallFont());
		elapsedTime.setFont(FontManager.getRunescapeSmallFont());
		overallInfo.add(teamPointsGained);
		overallInfo.add(teamPointsPerHour);
		overallInfo.add(averagePointsTeam);

		overallInfo.add(blankline1);
		overallInfo.add(overallPointsGained);

		overallInfo.add(overallPointsPerHour);

		overallInfo.add(averagePoints);
		overallInfo.add(blankline2);
		overallInfo.add(raidsCompleted);

		overallInfo.add(averageTime);
		overallInfo.add(elapsedTime);

		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);


		infoBoxPanel.setLayout(new BoxLayout(infoBoxPanel, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(infoBoxPanel);

		try
		{
			for (data d : raids)
			{
				infoBoxPanel.add(new XpInfoBox(raidsPlugin, raidsConfig, client, infoBoxPanel, d, iconManager));
			}
		}
		catch (IOException e)
		{

		}


	}

	/*
	for(data d : raids){
		try {
			infoBoxPanel.add(new XpInfoBox(raidsPlugin, raidsConfig, client, infoBoxPanel, Skill.AGILITY, iconManager));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit)
	{
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
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

	@Provides
	RaidsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsConfig.class);
	}

	XpInfoBox test(data d)
	{
		try
		{
			XpInfoBox x;
			x = new XpInfoBox(raidsPlugin, raidsConfig, client, infoBoxPanel, d, iconManager);
			return x;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	SoloBox testS(data d)
	{
		try
		{
			SoloBox x;
			x = new SoloBox(raidsPlugin, raidsConfig, client, infoBoxPanel, d, iconManager);
			return x;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	void init()
	{

	}

	void update()
	{
		int totalPoints = 0;
		int totalTeamPoints = 0;
		float teamperhour = 0;
		infoBoxPanel.removeAll();
		Date startTime = null;
		Date finishTime = null;
		int totalTime = 0;
		float difference = 0;
		int raidsDone = 0;
		for (data d : raids)
		{
			SwingUtilities.invokeLater(() -> infoBoxPanel.add(test(d)));
			totalPoints = totalPoints + d.personal;
			totalTeamPoints = totalTeamPoints + d.total;
			raidsDone++;
			totalTime = totalTime + d.timeTaken;
		}
		if (timer.getElapsedTime() > 0)
		{
			difference = timer.getElapsedTime();
			teamperhour = (totalTeamPoints / difference) * 3600;
			difference = (totalPoints / difference) * 3600;
		}

		overallInfo.removeAll();
		overallInfo.setLayout(new GridLayout(12, 1));
		teamPointsPerHour.setVisible(true);
		teamPointsGained.setVisible(true);
		overallInfo.add(pauseButton);
		overallInfo.add(teamPointsGained);
		overallInfo.add(teamPointsPerHour);
		overallInfo.add(averagePointsTeam);

		overallInfo.add(blankline1);
		overallInfo.add(overallPointsGained);

		overallInfo.add(overallPointsPerHour);

		overallInfo.add(averagePoints);
		overallInfo.add(blankline2);
		overallInfo.add(raidsCompleted);

		overallInfo.add(averageTime);
		overallInfo.add(elapsedTime);
		overallPointsGained.setText(XpInfoBox.htmlLabel("Personal Points: ", totalPoints));
		overallPointsPerHour.setText(XpInfoBox.htmlLabel("Per Hour: ", (int) difference));
		teamPointsGained.setText(XpInfoBox.htmlLabel("Team Points: ", totalTeamPoints));
		teamPointsPerHour.setText(XpInfoBox.htmlLabel("Per Hour: ", (int) teamperhour));

		raidsCompleted.setText(XpInfoBox.htmlLabel("Raids Done: ", raidsDone));
		if (raidsDone > 0)
		{
			elapsedTime.setText(XpInfoBox.htmlLabel("Elapsed Time: ", formatSeconds((int) timer.getElapsedTime())));
			averageTime.setText(XpInfoBox.htmlLabel("Avg. Raid Time: ", formatSeconds(totalTime / raidsDone)));
			averagePoints.setText(XpInfoBox.htmlLabel("Avg. Points: ", totalPoints / raidsDone));
			averagePointsTeam.setText(XpInfoBox.htmlLabel("Avg. Points: ", totalTeamPoints / raidsDone));
		}
		else
		{
			elapsedTime.setText(XpInfoBox.htmlLabel("Elapsed Time: ", "00:00:00"));
			averageTime.setText(XpInfoBox.htmlLabel("Avg. Raid Time: ", "00:00:00"));
			averagePoints.setText(XpInfoBox.htmlLabel("Avg. Points: ", 0));
			averagePointsTeam.setText(XpInfoBox.htmlLabel("Avg. Points: ", 0));
		}


		infoBoxPanel.revalidate();
	}

	void updateSolo()
	{
		int totalPoints = 0;
		int totalTeamPoints = 0;
		float teamperhour = 0;
		infoBoxPanel.removeAll();
		Date startTime = null;
		Date finishTime = null;
		int totalTime = 0;
		float difference = 0;
		int raidsDone = 0;
		if (raids.size() > 0)
		{
			startTime = raids.get(0).start;
			finishTime = raids.get(raids.size() - 1).finish;
			difference = getDateDiff(startTime, finishTime, TimeUnit.SECONDS);
		}
		for (data d : raids)
		{
			SwingUtilities.invokeLater(() -> infoBoxPanel.add(testS(d)));
			totalPoints = totalPoints + d.personal;
			totalTeamPoints = totalTeamPoints + d.total;
			raidsDone++;
			totalTime = totalTime + d.timeTaken;
		}

		if (timer.getElapsedTime() > 0)
		{
			difference = timer.getElapsedTime();
			teamperhour = (totalTeamPoints / difference) * 3600;
			difference = (totalPoints / difference) * 3600;
		}
		overallInfo.removeAll();
		overallInfo.setLayout(new GridLayout(7, 1));
		overallInfo.add(pauseButton);
		overallInfo.add(overallPointsGained);
		overallInfo.add(overallPointsPerHour);
		overallInfo.add(blankline);
		overallInfo.add(raidsCompleted);
		overallInfo.add(averageTime);
		overallInfo.add(elapsedTime);
		overallPointsGained.setText(XpInfoBox.htmlLabel("Personal Points: ", totalPoints));
		overallPointsPerHour.setText(XpInfoBox.htmlLabel("Per Hour: ", (int) difference));
		teamPointsGained.setText(XpInfoBox.htmlLabel("Team Points: ", totalTeamPoints));
		teamPointsPerHour.setText(XpInfoBox.htmlLabel("Per Hour: ", (int) teamperhour));

		raidsCompleted.setText(XpInfoBox.htmlLabel("Raids Done: ", raidsDone));
		if (raidsDone > 0)
		{
			elapsedTime.setText(XpInfoBox.htmlLabel("Elapsed Time: ", formatSeconds((int) timer.getElapsedTime())));
			averageTime.setText(XpInfoBox.htmlLabel("Avg. Raid Time: ", formatSeconds(totalTime / raidsDone)));
			averagePoints.setText(XpInfoBox.htmlLabel("Avg. Points: ", totalPoints / raidsDone));
			averagePointsTeam.setText(XpInfoBox.htmlLabel("Avg. Points: ", totalTeamPoints / raidsDone));
		}
		else
		{
			elapsedTime.setText(XpInfoBox.htmlLabel("Elapsed Time: ", "00:00:00"));
			averageTime.setText(XpInfoBox.htmlLabel("Avg. Raid Time: ", "00:00:00"));
			averagePoints.setText(XpInfoBox.htmlLabel("Avg. Points: ", 0));
			averagePointsTeam.setText(XpInfoBox.htmlLabel("Avg. Points: ", 0));
		}
		teamPointsPerHour.setVisible(false);
		teamPointsGained.setVisible(false);
		infoBoxPanel.revalidate();
	}

	void unpauseTime()
	{
		if (!timer.started)
		{
			return;
		}
		timer.unpause();
		pausePopup.setText("Pause Timer");
		pauseButton.setText("Pause Timer");
		for (ActionListener d : pausePopup.getActionListeners())
		{
			pausePopup.removeActionListener(d);
		}
		for (ActionListener d : pauseButton.getActionListeners())
		{
			pauseButton.removeActionListener(d);
		}
		pausePopup.addActionListener(e -> pauseTime());
		pauseButton.addActionListener(e -> pauseTime());
	}

	public void updateTime()
	{
		finalTime = new Date();
		int totalPoints = 0;
		int totalTeamPoints = 0;
		int raidsDone = 0;
		int totalTime = 0;
		if (raids.size() > 0)
		{
			int difference;
			int teamperhour;
			for (data d : raids)
			{
				totalPoints = totalPoints + d.personal;
				totalTeamPoints = totalTeamPoints + d.total;
				raidsDone++;
				totalTime = totalTime + d.timeTaken;
			}
			if (timer.getElapsedTime() > 0)
			{
				difference = (int) timer.getElapsedTime();
				teamperhour = (int) ((totalTeamPoints / (float) difference) * 3600);
				difference = (int) ((totalPoints / (float) difference) * 3600);
				overallPointsGained.setText(XpInfoBox.htmlLabel("Personal Points: ", totalPoints));
				overallPointsPerHour.setText(XpInfoBox.htmlLabel("Per Hour: ", difference));
				teamPointsGained.setText(XpInfoBox.htmlLabel("Team Points: ", totalTeamPoints));
				teamPointsPerHour.setText(XpInfoBox.htmlLabel("Per Hour: ", teamperhour));
			}

			elapsedTime.setText(XpInfoBox.htmlLabel("Elapsed Time: ", formatSeconds((int) timer.getElapsedTime())));
			revalidate();
		}

	}

	void pauseTime()
	{

		if (!timer.started)
		{
			return;
		}
		timer.pause();
		pausePopup.setText("Resume Timer");
		pauseButton.setText("Resume Timer");
		for (ActionListener d : pausePopup.getActionListeners())
		{
			pausePopup.removeActionListener(d);
		}
		for (ActionListener d : pauseButton.getActionListeners())
		{
			pauseButton.removeActionListener(d);
		}
		pausePopup.addActionListener(e -> unpauseTime());
		pauseButton.addActionListener(e -> unpauseTime());
	}

	void resetAll(boolean solo)
	{
		timer = new timerSpecial();
		pausePopup.setText("Pause Timer");
		pauseButton.setText("Pause Timer");
		for (ActionListener d : pausePopup.getActionListeners())
		{
			pausePopup.removeActionListener(d);
		}
		for (ActionListener d : pauseButton.getActionListeners())
		{
			pauseButton.removeActionListener(d);
		}
		pausePopup.addActionListener(e -> pauseTime());
		pauseButton.addActionListener(e -> pauseTime());
		raids.clear();
		if (soloMode)
		{
			updateSolo();
		}
		else
		{
			update();
		}

	}

	void setSolo(boolean solo)
	{
		soloMode = solo;
	}

}
