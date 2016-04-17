package net.runelite.inject.callbacks;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.runelite.client.plugins.opponentinfo.OpponentInfo;

public class RSCanvasCallback
{
	private final BufferedImage clientBuffer = new BufferedImage(756, 503, BufferedImage.TYPE_INT_RGB);
	private final BufferedImage gameBuffer = new BufferedImage(756, 503, BufferedImage.TYPE_INT_RGB);
	
	public Graphics getGraphics(Canvas canvas, Graphics superGraphics)
	{
		Graphics clientGraphics = clientBuffer.getGraphics();
		clientGraphics.drawImage(gameBuffer, 0, 0, null);
		//clientGraphics.dispose();

		//clientGraphics = clientBuffer.getGraphics();
		//clientGraphics.drawString("something, something 2", 42, 42);
		new OpponentInfo().draw(clientGraphics);

		superGraphics.drawImage(clientBuffer, 0, 0, null);

		return gameBuffer.getGraphics();
	}
}
