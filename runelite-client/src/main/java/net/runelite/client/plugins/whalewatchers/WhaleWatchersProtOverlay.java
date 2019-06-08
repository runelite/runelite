/*******************************************************************************
 * Copyright (c) 2019. PKLite
 *  Redistributions and modifications of this software are permitted as long as this notice remains in its original unmodified state at the top of this file.
 *  If there are any questions comments, or feedback about this software, please direct all inquiries directly to the following authors:
 *
 *   PKLite discord: https://discord.gg/Dp3HuFM
 *   Written by PKLite(ST0NEWALL, others) <stonewall@stonewall@pklite.xyz>, 2019
 *
 ******************************************************************************/

package net.runelite.client.plugins.whalewatchers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;


public class WhaleWatchersProtOverlay extends Overlay
{

	private Client client;
	private final WhaleWatchersConfig config;
	private WhaleWatchersPlugin plugin;

	@Inject
	public WhaleWatchersProtOverlay(WhaleWatchersConfig config, Client client, WhaleWatchersPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		setPriority(OverlayPriority.HIGH);
		setPosition(OverlayPosition.DYNAMIC);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.enableOverlay && config.protectItemWarning())
		{
			Rectangle rectangle = new Rectangle();
			rectangle.setBounds(client.getCanvas().getBounds());
			rectangle.setLocation(client.getCanvas().getLocation());
			Stroke oldStroke = graphics.getStroke();
			graphics.setStroke(new BasicStroke(10));
			graphics.setColor(Color.RED);
			graphics.draw(rectangle);
			Font font = FontManager.getRunescapeBoldFont().deriveFont(Font.BOLD, 72);
			graphics.setFont(font);
			OverlayUtil.renderTextLocation(graphics, new Point((int) rectangle.getCenterX() - 50, font.getSize()), "Protect item prayer disabled!!!", Color.red);
			graphics.setStroke(oldStroke);
		}
		return null;
	}
}
