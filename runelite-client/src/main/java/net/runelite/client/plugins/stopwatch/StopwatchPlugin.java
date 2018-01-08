package net.runelite.client.plugins.stopwatch;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
import java.time.temporal.ChronoUnit;

@PluginDescriptor(
	name = "Stopwatch plugin"
)
public class StopwatchPlugin extends Plugin
{
	@Inject
	ClientUI ui;

	@Inject
	@Nullable
	Client client;

	@Inject
	StopwatchPluginConfig config;

	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;
	private String textHours = "00";
	private String textMinutes = "00";
	private String textSeconds = "00";
	private boolean running = false;
	private NavigationButton navButton;
	private StopwatchPluginPanel stopwatchPanel;

	@Provides
	StopwatchPluginConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StopwatchPluginConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		stopwatchPanel = injector.getInstance(StopwatchPluginPanel.class);
		navButton = new NavigationButton("Stopwatch", () -> stopwatchPanel);

		ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("stopwatch_icon.png")));
		navButton.getButton().setIcon(icon);

		ui.getPluginToolbar().addNavigation(navButton);
	}

	@Schedule(
		period = 1,
		unit = ChronoUnit.SECONDS
	)
	public void updateStopwatch()
	{
		if (client == null)
		{
			return;
		}

		Widget reportWidget = client.getWidget(WidgetInfo.CHATBOX_REPORT);

		if (!config.enabled())
		{
			if (reportWidget != null)
			{
				reportWidget.setText("Report");
			}
			return;
		}

		if (config.ingameOnly() && client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (running)
		{
			++seconds;

			if (seconds >= 60)
			{
				++minutes;
				seconds = 0;
			}
			if (minutes >= 60)
			{
				++hours;
				minutes = 0;
			}

			textSeconds = Integer.toString(seconds);
			textMinutes = Integer.toString(minutes);
			textHours = Integer.toString(hours);

			if (textSeconds.length() == 1)
			{
				textSeconds = "0" + textSeconds;
			}
			if (textMinutes.length() == 1)
			{
				textMinutes = "0" + textMinutes;
			}
			if (textHours.length() == 1)
			{
				textHours = "0" + textHours;
			}
		}

		if (reportWidget != null)
		{
			reportWidget.setText(textHours + ":" + textMinutes + ":" + textSeconds);
		}
	}

	public void startStopwatch()
	{
		running = true;
	}

	public void stopStopwatch()
	{
		running = false;
	}

	public void resetStopwatch()
	{
		if (client == null)
		{
			return;
		}
		
		seconds = 0;
		minutes = 0;
		hours = 0;
		textSeconds = "00";
		textMinutes = "00";
		textHours = "00";
		
		Widget reportWidget = client.getWidget(WidgetInfo.CHATBOX_REPORT);
		if (reportWidget != null)
		{
			reportWidget.setText("00:00:00");
		}
	}
}
