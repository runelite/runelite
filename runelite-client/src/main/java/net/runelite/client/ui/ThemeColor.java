package net.runelite.client.ui;

import java.awt.Color;

public class ThemeColor
{
	private String htmlName;
	private String hexCode;
	private Color color;

	ThemeColor(String htmlName, Color color)
	{
		this.htmlName = htmlName;
		this.color = color;
		this.hexCode = "#" + Integer.toHexString(color.getRGB()).substring(2);
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
