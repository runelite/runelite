package net.runelite.client.plugins.opponentinfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.Overlay;
import net.runelite.client.ui.OverlayPosition;
import net.runelite.client.ui.OverlayPriority;

public class OpponentInfo extends Plugin
{
	private static final int WIDTH = 140;
	private static final int HEIGHT = 75;

	private static final int TOP_BORDER = 2;
	private static final int BOTTOM_BORDER = 2;

	private static final int BAR_WIDTH = 124;
	private static final int BAR_HEIGHT = 20;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);

	private final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private final Overlay overlay = new Overlay(image, OverlayPosition.TOP_LEFT, OverlayPriority.HIGH);

	private Actor getOpponent()
	{
		Client client = RuneLite.getClient();

		Player player = client.getLocalPlayer();
		if (player == null)
			return null;

		return player.getInteracting();
	}

	@Override
	public Overlay drawOverlay()
	{
		Actor opponent = getOpponent();

		if (opponent == null)
			return null;

		int cur = opponent.getHealth();
		int max = opponent.getMaxHealth();

		Graphics g = image.getGraphics();
		FontMetrics fm = g.getFontMetrics();
		
		int height = TOP_BORDER
			+ fm.getHeight(); // opponent name
		if (max > 0)
			height += 1 // between name and hp bar
				+ BAR_HEIGHT; // bar
		height += BOTTOM_BORDER;

		g.setColor(BACKGROUND);
		g.fillRect(0, 0, image.getWidth(), height);
		
		String str = opponent.getName();

		int x = (image.getWidth() - fm.stringWidth(str)) / 2;
		g.setColor(Color.white);
		g.drawString(str, x, fm.getHeight() + TOP_BORDER);

		// hp bar

		if (max > 0)
		{
			float percent = (float) cur / (float) max;
			if (percent > 100f)
				percent = 100f;

			int barWidth = (int) (percent * (float) BAR_WIDTH);
			int barY = TOP_BORDER + fm.getHeight() + 1;

			g.setColor(HP_GREEN);
			g.fillRect((WIDTH - BAR_WIDTH) / 2, barY, barWidth, BAR_HEIGHT);
			
			g.setColor(HP_RED);
			g.fillRect(((WIDTH - BAR_WIDTH) / 2) + barWidth, barY, BAR_WIDTH - barWidth, BAR_HEIGHT);

			str = cur + " / " + max;
			x = (image.getWidth() - fm.stringWidth(str)) / 2;
			g.setColor(Color.white);
			g.drawString(str, x, barY + fm.getHeight());
		}

		g.dispose();

		overlay.setDimension(new Dimension(height, image.getWidth()));

		return overlay;
	}
}
