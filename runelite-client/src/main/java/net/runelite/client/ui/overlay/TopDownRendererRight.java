package net.runelite.client.ui.overlay;

import net.runelite.api.Client;
import net.runelite.client.RuneLite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bold on 1/31/17.
 */
public class TopDownRendererRight
{
	private static final int BORDER_TOP = 0;
	private static final int BORDER_RIGHT = 0;
	private static final int PADDING = 10;

	private final List<Overlay> overlays = new ArrayList<>();

	public void add(Overlay overlay)
	{
		overlays.add(overlay);
	}

	public void render(BufferedImage clientBuffer)
	{
		Client client = RuneLite.getClient();
		overlays.sort((o1, o2) -> o2.getPriority().compareTo(o1.getPriority()));
		int y = BORDER_TOP;

		for (Overlay overlay : overlays)
		{
			BufferedImage image = clientBuffer.getSubimage(BORDER_RIGHT, BORDER_TOP, client.getClientWidth(), 25);

			Graphics2D graphics = image.createGraphics();
			Dimension dimension = overlay.render(graphics);
			graphics.dispose();

			if (dimension == null)
				continue;

			//y += dimension.getHeight() + PADDING; //uneeded for now.
		}
	}

}
