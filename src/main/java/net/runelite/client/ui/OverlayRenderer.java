package net.runelite.client.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;

public class OverlayRenderer
{
	private static final int TOP_LEFT_BORDER_TOP = 25;
	private static final int TOP_LEFT_BORDER_LEFT = 10;
	private static final int TOP_LEFT_PADDING = 10;

	public void render(Graphics graphics)
	{
		List<Overlay> overlays = new ArrayList<>();

		for (Plugin plugin : RuneLite.getRunelite().getPluginManager().getPlugins())
		{
			Overlay overlay = plugin.drawOverlay();
			if (overlay != null)
				overlays.add(overlay);
		}

		Overlay[] topLeft = overlays.stream().filter(o -> o.getPosition() == OverlayPosition.TOP_LEFT).sorted((o1, o2) -> o1.getPriority().compareTo(o2.getPriority())).toArray(s -> new Overlay[s]);
		int y = TOP_LEFT_BORDER_TOP;
		
		for (Overlay overlay : topLeft)
		{
			BufferedImage image = overlay.getImage();
			Dimension dimension = overlay.getDimension();

			graphics.drawImage(image, TOP_LEFT_BORDER_LEFT, y, null);
			y += dimension.getHeight() + TOP_LEFT_PADDING;
		}
	}
}
