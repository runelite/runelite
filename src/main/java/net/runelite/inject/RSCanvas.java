package net.runelite.inject;

import java.awt.Canvas;
import java.awt.Graphics;
import net.runelite.inject.callbacks.RSCanvasCallback;

public abstract class RSCanvas extends Canvas
{
	private RSCanvasCallback callback = new RSCanvasCallback();
	
	@Override
	public Graphics getGraphics()
	{
		Graphics superGraphics = super.getGraphics();
		return callback.getGraphics(this, superGraphics);
	}
}
