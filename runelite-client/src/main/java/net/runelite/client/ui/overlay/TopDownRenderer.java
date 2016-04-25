package net.runelite.client.ui.overlay;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TopDownRenderer
{
	private static final int BORDER_TOP = 25;
	private static final int BORDER_LEFT = 10;
	private static final int PADDING = 10;

	private final List<Overlay> overlays = new ArrayList<>();

	public void add(Overlay overlay)
	{
		overlays.add(overlay);
	}

	public void render(BufferedImage clientBuffer)
	{
		overlays.sort((o1, o2) -> o2.getPriority().compareTo(o1.getPriority()));
		int y = BORDER_TOP;

		for (Overlay overlay : overlays)
		{
			BufferedImage image = clientBuffer.getSubimage(BORDER_LEFT, y, clientBuffer.getWidth() - BORDER_LEFT, clientBuffer.getHeight() - y);//(int) dimension.getWidth(), (int) dimension.getHeight());
			Graphics2D graphics = image.createGraphics();
			Dimension dimension = overlay.render(graphics);
			graphics.dispose();

			if (dimension == null)
				continue;
			
			y += dimension.getHeight() + PADDING;
		}
	}
}
