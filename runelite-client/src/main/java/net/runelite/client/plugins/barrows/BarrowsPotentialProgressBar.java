/*
 * Copyright (c) 2026, RuneLite
 * All rights reserved.
 */
package net.runelite.client.plugins.barrows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Locale;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;

final class BarrowsPotentialProgressBar implements LayoutableRenderableEntity
{
	private static final Color BACKGROUND = new Color(160, 20, 20);
	private static final Color FILL = new Color(20, 150, 55);
	private static final Color BORDER = new Color(20, 20, 20);
	private final Rectangle bounds = new Rectangle();
	private Point preferredLocation = new Point();
	private Dimension preferredSize = new Dimension(0, 20);
	private int rewardPotential;
	private int goalPercent = 87;

	void setRewardPotential(int rewardPotential)
	{
		this.rewardPotential = rewardPotential;
	}

	void setGoalPercent(int goalPercent)
	{
		this.goalPercent = goalPercent;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		int width = preferredSize.width;
		int height = preferredSize.height > 0 ? preferredSize.height : 20;
		int goalPoints = BarrowsPotentialPlan.getPotentialGoalPoints(goalPercent);
		int fillWidth = (int) Math.round(width * Math.min(1.0, Math.max(0.0, rewardPotential / (double) goalPoints)));
		int x = preferredLocation.x;
		int y = preferredLocation.y;

		graphics.setColor(BACKGROUND);
		graphics.fillRect(x, y, width, height);
		graphics.setColor(FILL);
		graphics.fillRect(x, y, fillWidth, height);
		graphics.setColor(BORDER);
		graphics.drawRect(x, y, width - 1, height - 1);

		String label = String.format(Locale.ROOT, "%.2f%% / %d%%", rewardPotential * 100.0 / 1012, goalPercent);
		FontMetrics metrics = graphics.getFontMetrics();
		int textX = x + Math.max(4, (width - metrics.stringWidth(label)) / 2);
		int textY = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
		graphics.setColor(Color.WHITE);
		graphics.drawString(label, textX, textY);

		bounds.setBounds(x, y, width, height);
		return new Dimension(width, height);
	}

	@Override
	public Rectangle getBounds()
	{
		return bounds;
	}

	@Override
	public void setPreferredLocation(Point preferredLocation)
	{
		this.preferredLocation = preferredLocation;
	}

	@Override
	public void setPreferredSize(Dimension preferredSize)
	{
		this.preferredSize = preferredSize;
	}
}
