package net.runelite.inject;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class RSCanvas extends Canvas
{
	private final BufferedImage clientBuffer = new BufferedImage(756, 503, BufferedImage.TYPE_INT_RGB);
	private final BufferedImage gameBuffer = new BufferedImage(756, 503, BufferedImage.TYPE_INT_RGB);
	
	@Override
	public Graphics getGraphics()
	{
		Graphics clientGraphics = clientBuffer.getGraphics();
		clientGraphics.drawImage(gameBuffer, 0, 0, null);
		//clientGraphics.dispose();
		
		//clientGraphics = clientBuffer.getGraphics();
		clientGraphics.drawString("something, something", 42, 42);

		Graphics superGraphics = super.getGraphics();
		superGraphics.drawImage(clientBuffer, 0, 0, null);
		
		return gameBuffer.getGraphics();
	}
}
