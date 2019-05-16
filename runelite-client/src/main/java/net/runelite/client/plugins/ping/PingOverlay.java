package net.runelite.client.plugins.ping;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class PingOverlay extends Overlay
{
	private static final int Y_OFFSET = 11;
	private static final int VALUE_X_OFFSET = 1;
	private static final String PING_STRING = " ms";

	private final Client client;
	private final PingPlugin pingPlugin;

	@Inject
	private PingOverlay(Client client, PingPlugin pingPlugin)
	{
		this.client = client;
		this.pingPlugin = pingPlugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
        final String text;

        if (pingPlugin.getCurrentPing() != 0)
        {
            text = pingPlugin.getCurrentPing() + PING_STRING;
        }
        else
        {
            text = "-" + PING_STRING;
        }

		//text = pingPlugin.getCurrentPing() + PING_STRING;
		final int textWidth = graphics.getFontMetrics().stringWidth(text);
		final int textHeight = graphics.getFontMetrics().getAscent() - graphics.getFontMetrics().getDescent();

		final int width = (int) client.getRealDimensions().getWidth();
		final Point point = new Point(width - textWidth - VALUE_X_OFFSET, textHeight + Y_OFFSET);
		OverlayUtil.renderTextLocation(graphics, point, text, Color.yellow);

		return null;
	}
}
