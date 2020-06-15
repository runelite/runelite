package net.runelite.client.plugins.tzhaartimers;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.Setter;
import net.runelite.api.ItemID;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.InfoBox;

public class CapeTimers extends InfoBox
{
	private final Instant entrytime;
	private LocalTime time;

	@Setter
	public boolean stopped;

	public CapeTimers(Plugin plugin, Instant startTime, BufferedImage cape)
	{
		super(cape, plugin);
		entrytime = startTime;
		stopped = false;
	}

	@Override
	public String getText()
	{
		if (!stopped)
		{
			Duration elapsed = Duration.between(entrytime, Instant.now());
			time = LocalTime.ofSecondOfDay(elapsed.getSeconds());
		}
		return time.format(DateTimeFormatter.ofPattern("mm:ss"));
	}

	@Override
	public Color getTextColor()
	{
		if (stopped)
		{
			return Color.GREEN;
		}

		return Color.WHITE;
	}

	@Override
	public String getTooltip()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Elapsed cave time: ");
		builder.append(time.format(DateTimeFormatter.ofPattern("mm:ss")));

		return builder.toString();
	}

}
