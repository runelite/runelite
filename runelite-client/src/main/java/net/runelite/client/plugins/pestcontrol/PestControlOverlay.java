/*
 *  Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 *  Copyright (c) 2017, Adam <Adam@sigterm.info>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.pestcontrol;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.RuneLite;
import static net.runelite.client.plugins.pestcontrol.Portal.BLUE;
import static net.runelite.client.plugins.pestcontrol.Portal.PURPLE;
import static net.runelite.client.plugins.pestcontrol.Portal.RED;
import static net.runelite.client.plugins.pestcontrol.Portal.YELLOW;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PestControlOverlay extends Overlay
{
	private static final Logger logger = LoggerFactory.getLogger(PestControlOverlay.class);

	private final Client client = RuneLite.getClient();
	private final PestControl plugin;

	// Pest control game
	private Game game;

	public PestControlOverlay(PestControl plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return null;
		}

		// See if we are in a game or not
		if (client.getWidget(WidgetInfo.PESTCONTROL_BLUE_SHIELD) == null)
		{
			if (game != null)
			{
				logger.debug("Pest control game has ended");
				game = null;
			}

			return null;
		}

		if (game == null)
		{
			logger.debug("Pest control game has started");
			game = new Game();
		}

		Font font = plugin.getFont();
		if (font != null)
		{
			graphics.setFont(font);
		}

		renderSpinners(graphics);
		renderPortalWidgets(graphics);

		return null;
	}

	private void renderSpinners(Graphics2D graphics)
	{
		NPC[] npcs = client.getNpcs();
		if (npcs == null)
		{
			return;
		}

		for (NPC npc : npcs)
		{
			if (npc == null)
			{
				continue;
			}

			String name = npc.getName();

			if (name.toLowerCase().contains("spinner"))
			{
				renderActorOverlay(graphics, npc, name, Color.CYAN);
			}
		}
	}

	private void renderPortalWidgets(Graphics2D graphics)
	{
		PortalContext purple = game.getPurple();
		PortalContext blue = game.getBlue();
		PortalContext yellow = game.getYellow();
		PortalContext red = game.getRed();

		Widget purpleShield = client.getWidget(PURPLE.getShield());
		Widget blueShield = client.getWidget(BLUE.getShield());
		Widget yellowShield = client.getWidget(YELLOW.getShield());
		Widget redShield = client.getWidget(RED.getShield());

		Widget purpleHealth = client.getWidget(PURPLE.getHitpoints());
		Widget blueHealth = client.getWidget(BLUE.getHitpoints());
		Widget yellowHealth = client.getWidget(YELLOW.getHitpoints());
		Widget redHealth = client.getWidget(RED.getHitpoints());

		assert purpleShield != null;
		assert blueShield != null;
		assert yellowShield != null;
		assert redShield != null;

		// Check for fallen portals
		if (purpleShield.isHidden())
		{
			game.fall(purple);
		}
		if (blueShield.isHidden())
		{
			game.fall(blue);
		}
		if (yellowShield.isHidden())
		{
			game.fall(yellow);
		}
		if (redShield.isHidden())
		{
			game.fall(red);
		}

		// Check for dead portals
		if (isZero(purpleHealth))
		{
			game.die(purple);
		}
		if (isZero(blueHealth))
		{
			game.die(blue);
		}
		if (isZero(yellowHealth))
		{
			game.die(yellow);
		}
		if (isZero(redHealth))
		{
			game.die(red);
		}

		// display "ATK" overlay on recorded portals without shields
		renderAttack(graphics, purple);
		renderAttack(graphics, blue);
		renderAttack(graphics, yellow);
		renderAttack(graphics, red);

		// display "NEXT" overlay on predicted portals
		for (Portal portal : game.getNextPortals())
		{
			renderWidgetOverlay(graphics, portal, "NEXT", Color.ORANGE);
		}
	}

	private void renderActorOverlay(Graphics2D graphics, Actor actor, String text, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			graphics.setColor(color);
			graphics.setStroke(new BasicStroke(2));
			graphics.drawPolygon(poly);
			graphics.setColor(new Color(0, 0, 0, 50));
			graphics.fillPolygon(poly);
		}

		Point minimapLocation = actor.getMinimapLocation();
		if (minimapLocation != null)
		{
			graphics.setColor(color);
			graphics.fillOval(minimapLocation.getX(), minimapLocation.getY(), 5, 5);
			graphics.setColor(Color.WHITE);
			graphics.setStroke(new BasicStroke(1));
			graphics.drawOval(minimapLocation.getX(), minimapLocation.getY(), 5, 5);
		}

		Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getModelHeight() + 40);
		if (textLocation != null)
		{
			int x = textLocation.getX();
			int y = textLocation.getY();

			graphics.setColor(Color.BLACK);
			graphics.drawString(text, x + 1, y + 1);

			graphics.setColor(color);
			graphics.drawString(text, x, y);
		}
	}

	private void renderWidgetOverlay(Graphics2D graphics, Portal portal, String text, Color color)
	{
		Widget shield = client.getWidget(portal.getShield());
		Widget icon = client.getWidget(portal.getIcon());

		// create one rectangle from two different widget bounds
		Rectangle2D bounds = union(shield.getBounds().getBounds2D(), icon.getBounds().getBounds2D());
		graphics.setColor(color);
		graphics.draw(bounds);

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);
		int x = (int) (bounds.getX() + (bounds.getWidth() / 2) - (textBounds.getWidth() / 2));
		int y = (int) (bounds.getY() + bounds.getHeight() + textBounds.getHeight());

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);
		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}

	private static Rectangle2D union(Rectangle2D src1, Rectangle2D src2)
	{
		double x1 = Math.min(src1.getMinX(), src2.getMinX());
		double y1 = Math.min(src1.getMinY(), src2.getMinY());
		double x2 = Math.max(src1.getMaxX(), src2.getMaxX());
		double y2 = Math.max(src1.getMaxY(), src2.getMaxY());

		Rectangle2D result = new Rectangle2D.Double();
		result.setFrameFromDiagonal(x1, y1, x2, y2);

		return result;
	}

	private void renderAttack(Graphics2D graphics, PortalContext portal)
	{
		if (portal.isShielded() || portal.isIsDead())
		{
			return;
		}

		renderWidgetOverlay(graphics, portal.getPortal(), "ATK", Color.RED);
	}

	private static boolean isZero(Widget widget)
	{
		return widget.getText().trim().equals("0");
	}
}
