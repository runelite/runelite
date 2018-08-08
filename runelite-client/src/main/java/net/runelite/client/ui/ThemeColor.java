package net.runelite.client.ui;

import java.awt.Color;
import net.runelite.client.util.ColorUtil;

public class ThemeColor
{
	private String htmlName;
	private String hexCode;
	private Color color;

	ThemeColor(String htmlName, Color color)
	{
		this.htmlName = htmlName;
		this.color = color;
		this.hexCode = ColorUtil.toHexColor(color);
	}

	public String getHtmlName()
	{
		return htmlName;
	}

	public String getHexCode()
	{
		return hexCode;
	}

	public Color getColor()
	{
		return color;
	}

}
