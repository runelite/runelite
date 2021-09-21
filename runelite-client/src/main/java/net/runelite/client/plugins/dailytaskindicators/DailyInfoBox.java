package net.runelite.client.plugins.dailytaskindicators;

import java.awt.Color;
import java.util.function.BooleanSupplier;
import net.runelite.client.ui.overlay.infobox.InfoBox;
import net.runelite.client.util.AsyncBufferedImage;

public class DailyInfoBox extends InfoBox
{
	private final BooleanSupplier renderCondition;

	public DailyInfoBox(final AsyncBufferedImage image, final String tooltip, final BooleanSupplier renderCondition, final DailyTasksPlugin plugin)
	{
		super(image, plugin);
		this.renderCondition = renderCondition;
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
		return renderCondition.getAsBoolean();
	}
}
