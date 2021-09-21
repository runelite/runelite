package net.runelite.client.plugins.dailytaskindicators.infoboxes;

import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.dailytaskindicators.DailyTasksConfig;
import net.runelite.client.plugins.dailytaskindicators.DailyTasksPlugin;
import net.runelite.client.ui.overlay.infobox.InfoBox;

import java.awt.*;
import net.runelite.client.util.AsyncBufferedImage;

public class DailyInfoBox extends InfoBox
{
	private final BooleanSupplier check;

	public DailyInfoBox(final AsyncBufferedImage image, final String tooltip, final BooleanSupplier check, final DailyTasksPlugin plugin)
	{
		super(image, plugin);
		this.check = check;
		setTooltip(tooltip);
	}

	@Override
	public String getText()
	{
		return null;
	}

	@Override
	public Color getTextColor()
	{
		return null;
	}

	@Override
	public boolean render()
	{
		return check.getAsBoolean();
	}
}
