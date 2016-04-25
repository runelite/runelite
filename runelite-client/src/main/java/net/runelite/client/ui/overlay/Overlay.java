package net.runelite.client.ui.overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;

public abstract class Overlay
{
	private OverlayPosition position; // where to draw it
	private OverlayPriority priority; // if multiple overlays exist in the same position, who wins

	public Overlay(OverlayPosition position, OverlayPriority priority)
	{
		this.position = position;
		this.priority = priority;
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

	public abstract Dimension render(Graphics2D graphics);
}
