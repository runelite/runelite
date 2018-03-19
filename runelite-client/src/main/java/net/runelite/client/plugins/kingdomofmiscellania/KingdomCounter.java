package net.runelite.client.plugins.kingdomofmiscellania;

import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import net.runelite.client.ui.overlay.infobox.Counter;

public class KingdomCounter extends Counter
{
	private final KingdomPlugin plugin;

	public KingdomCounter(BufferedImage image, KingdomPlugin plugin)
	{
		super(image, String.valueOf(plugin.getFavor()));
		this.plugin = plugin;
	}

	@Override
	public String getText()
	{
		return getFavorPercent(plugin.getFavor());
	}

	@Override
	public String getTooltip()
	{
		return String.format("Favor: " + plugin.getFavor() + "/127" + "</br>Coffer: " + NumberFormat.getInstance().format(plugin.getCoffer()));
	}

	public static String getFavorPercent(int favor)
	{
		return (favor * 100) / 127 + "%";
	}
}
