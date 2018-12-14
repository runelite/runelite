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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Query;
import net.runelite.api.queries.NPCQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import static net.runelite.client.plugins.pestcontrol.Portal.BLUE;
import static net.runelite.client.plugins.pestcontrol.Portal.PURPLE;
import static net.runelite.client.plugins.pestcontrol.Portal.RED;
import static net.runelite.client.plugins.pestcontrol.Portal.YELLOW;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.util.QueryRunner;

@Slf4j
public class PestControlOverlay extends Overlay
{
	private final QueryRunner queryRunner;
	private final Client client;

	// Pest control game
	@Getter(AccessLevel.PACKAGE)
	private Game game;

	@Inject
	public PestControlOverlay(QueryRunner queryRunner, Client client)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.queryRunner = queryRunner;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// See if we are in a game or not
		if (client.getWidget(WidgetInfo.PEST_CONTROL_BLUE_SHIELD) == null)
		{
			if (game != null)
			{
				log.debug("Pest control game has ended");
				game = null;
			}

			return null;
		}

		if (game == null)
		{
			log.debug("Pest control game has started");
			game = new Game();
		}

		renderSpinners(graphics);
		renderPortalWidgets(graphics);

		return null;
	}

	private void renderSpinners(Graphics2D graphics)
	{
		Query query = new NPCQuery().nameEquals("Spinner");
		NPC[] result = queryRunner.runQuery(query);
		Arrays.stream(result).forEach(npc -> OverlayUtil.renderActorOverlay(graphics, npc, npc.getName(), Color.CYAN));
	}

	private void renderPortalWidgets(Graphics2D graphics)
	{
		PortalContext purple = game.getPurple();
		PortalContext blue = game.getBlue();
		PortalContext yellow = game.getYellow();
		PortalContext red = game.getRed();

		Widget purpleHealth = client.getWidget(PURPLE.getHitpoints());
		Widget blueHealth = client.getWidget(BLUE.getHitpoints());
		Widget yellowHealth = client.getWidget(YELLOW.getHitpoints());
		Widget redHealth = client.getWidget(RED.getHitpoints());

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

		renderProgressWidget(graphics);
	}

	private void renderProgressWidget(Graphics2D graphics)
	{
		Widget bar = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_BAR).getChild(0);
		Rectangle2D bounds = bar.getBounds().getBounds2D();

		Widget prgs = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_PROGRESS).getChild(0);
		int perc = (int) ((prgs.getBounds().getWidth() / bounds.getWidth()) * 100);

		Color color = Color.GREEN;
		if (perc < 25)
		{
			color = Color.RED;
		}

		String text = String.valueOf(perc) + "%";

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);
		int x = (int) (bounds.getX() - textBounds.getWidth());
		int y = (int) (bounds.getY() + fm.getHeight() - 2);

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);
		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}

	private void renderWidgetOverlay(Graphics2D graphics, Portal portal, String text, Color color)
	{
		Widget shield = client.getWidget(portal.getShield());
		Widget icon = client.getWidget(portal.getIcon());
		Widget hp = client.getWidget(portal.getHitpoints());

		Widget bar = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_BAR).getChild(0);

		Rectangle2D barBounds = bar.getBounds().getBounds2D();

		// create one rectangle from two different widget bounds
		Rectangle2D bounds = union(shield.getBounds().getBounds2D(), icon.getBounds().getBounds2D());
		bounds = union(bounds, hp.getBounds().getBounds2D());

		graphics.setColor(color);
		graphics.draw(new Rectangle2D.Double(bounds.getX(), bounds.getY() - 2, bounds.getWidth(), bounds.getHeight() - 3));

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);
		int x = (int) (bounds.getX() + (bounds.getWidth() / 2) - (textBounds.getWidth() / 2));
		int y = (int) (bounds.getY() + bounds.getHeight() + textBounds.getHeight() + barBounds.getHeight());

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 5);
		graphics.setColor(color);
		graphics.drawString(text, x, y + 4);
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
		if (portal.isShielded() || portal.isDead())
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
