package net.runelite.inject.callbacks;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.OverlayRenderer;

public class RSCanvasCallback
{
	private final BufferedImage clientBuffer = new BufferedImage(765, 503, BufferedImage.TYPE_INT_RGB);
	private final BufferedImage gameBuffer = new BufferedImage(765, 503, BufferedImage.TYPE_INT_RGB);
	
	public Graphics getGraphics(Canvas canvas, Graphics superGraphics)
	{
		Graphics clientGraphics = clientBuffer.getGraphics();
		clientGraphics.drawImage(gameBuffer, 0, 0, null);
		clientGraphics.dispose();

		RuneLite runelite = RuneLite.getRunelite();
		if (runelite != null)
		{
			OverlayRenderer renderer = runelite.getRenderer();
			if (renderer != null)
			{
				renderer.render(clientBuffer);
			}
		}

		superGraphics.drawImage(clientBuffer, 0, 0, null);

		return gameBuffer.getGraphics();
	}
}
