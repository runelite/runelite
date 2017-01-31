package net.runelite.client.plugins.fpsinfo;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;

/**
 * Created by bold on 1/13/17.
 */
public class FPSOverlay extends Overlay
{
	private static Client client = RuneLite.getClient();

	public FPSOverlay()
	{
		super(OverlayPosition.TOP_RIGHT, OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		if (client.getGameState() != GameState.LOGGED_IN)
			return null;

		FontMetrics fm = graphics.getFontMetrics();
		String str = String.valueOf(client.getFPS());

		int x = (int) (client.getClientWidth() - fm.getStringBounds(str, graphics).getWidth());
		int y = (fm.getHeight());
		//outline
		graphics.setColor(Color.black);
		graphics.drawString(str, x - 1, y + 1);
		graphics.drawString(str, x - 1, y - 1);
		graphics.drawString(str, x + 1, y + 1);
		graphics.drawString(str, x + 1, y - 1);
		//actual text
		graphics.setColor(Color.white);
		graphics.drawString(str, x, y);

		return new Dimension((int) fm.getStringBounds(str, graphics).getWidth(), (int) (fm.getStringBounds(str, graphics).getHeight()));
	}
}