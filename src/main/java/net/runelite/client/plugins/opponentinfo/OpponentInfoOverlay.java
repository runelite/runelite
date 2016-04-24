package net.runelite.client.plugins.opponentinfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

class OpponentInfoOverlay extends Overlay
{
	private static final int WIDTH = 140;

	private static final int TOP_BORDER = 2;
	private static final int BOTTOM_BORDER = 2;

	private static final int BAR_WIDTH = 124;
	private static final int BAR_HEIGHT = 20;

	private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);

	OpponentInfoOverlay()
	{
		super(OverlayPosition.TOP_LEFT, OverlayPriority.HIGH);
	}

	private Actor getOpponent()
	{
		Client client = RuneLite.getClient();

		Player player = client.getLocalPlayer();
		if (player == null)
			return null;

		return player.getInteracting();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Actor opponent = getOpponent();

		if (opponent == null)
			return null;

		int cur = opponent.getHealth();
		int max = opponent.getMaxHealth();

		FontMetrics fm = graphics.getFontMetrics();

		int height = TOP_BORDER
			+ fm.getHeight(); // opponent name
		if (max > 0)
			height += 1 // between name and hp bar
				+ BAR_HEIGHT; // bar
		height += BOTTOM_BORDER;

		graphics.setColor(BACKGROUND);
		graphics.fillRect(0, 0, WIDTH, height);

		String str = opponent.getName();

		int x = (WIDTH - fm.stringWidth(str)) / 2;
		graphics.setColor(Color.white);
		graphics.drawString(str, x, fm.getHeight() + TOP_BORDER);

		// hp bar

		if (max > 0)
		{
			float percent = (float) cur / (float) max;
			if (percent > 100f)
				percent = 100f;

			int barWidth = (int) (percent * (float) BAR_WIDTH);
			int barY = TOP_BORDER + fm.getHeight() + 1;

			graphics.setColor(HP_GREEN);
			graphics.fillRect((WIDTH - BAR_WIDTH) / 2, barY, barWidth, BAR_HEIGHT);

			graphics.setColor(HP_RED);
			graphics.fillRect(((WIDTH - BAR_WIDTH) / 2) + barWidth, barY, BAR_WIDTH - barWidth, BAR_HEIGHT);

			str = cur + " / " + max;
			x = (WIDTH - fm.stringWidth(str)) / 2;
			graphics.setColor(Color.white);
			graphics.drawString(str, x, barY + fm.getHeight());
		}

		return new Dimension(WIDTH, height);
	}
}
