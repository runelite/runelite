package net.runelite.client.ui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Overlay
{
	private BufferedImage image; // image to draw
	private Dimension dimension; // dimension of visable overlay
	private OverlayPosition position; // where to draw it
	private OverlayPriority priority; // if multiple overlays exist in the same position, who wins

	public Overlay(BufferedImage image, OverlayPosition position, OverlayPriority priority)
	{
		this.image = image;
		this.position = position;
		this.priority = priority;
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
	}

	public Dimension getDimension()
	{
		return dimension;
	}

	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
	}

	public OverlayPosition getPosition()
	{
		return position;
	}

	public void setPosition(OverlayPosition position)
	{
		this.position = position;
	}

	public OverlayPriority getPriority()
	{
		return priority;
	}

	public void setPriority(OverlayPriority priority)
	{
		this.priority = priority;
	}
}
