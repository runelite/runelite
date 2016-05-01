package net.runelite.inject.callbacks;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.OverlayRenderer;

public class RSCanvasCallback
{
	private static final int WIDTH = 765, HEIGHT = 503;
	
	private BufferedImage clientBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage gameBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public Graphics getGraphics(Canvas canvas, Graphics superGraphics)
	{
		if (canvas.getHeight() != clientBuffer.getHeight() || canvas.getWidth() != gameBuffer.getWidth())
		{
			clientBuffer = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
			gameBuffer = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
		}

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
