/*
 * Copyright (c) 2019, kThisIsCvpv <https://github.com/kThisIsCvpv>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.gauntlet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Model;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.model.Jarvis;
import net.runelite.api.model.Vertex;
import net.runelite.client.graphics.ModelOutlineRenderer;
import static net.runelite.client.plugins.gauntlet.GauntletConfig.CounterDisplay.BOTH;
import static net.runelite.client.plugins.gauntlet.GauntletConfig.CounterDisplay.ONBOSS;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import static net.runelite.client.util.ImageUtil.resizeImage;

public class GauntletOverlay extends Overlay
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private GauntletCounter GauntletCounter;

	private static final Color FLASH_COLOR = new Color(255, 0, 0, 70);
	private static final int MAX_DISTANCE = 2400;
	private final Client client;
	private final GauntletPlugin plugin;
	private final ModelOutlineRenderer outlineRenderer;
	private int timeout;

	@Inject
	private GauntletOverlay(Client client, GauntletPlugin plugin, ModelOutlineRenderer outlineRenderer)
	{
		this.client = client;
		this.plugin = plugin;
		this.outlineRenderer = outlineRenderer;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		// Save resources. There's nothing to render if the user is not in a raid.

		if (!plugin.startedGauntlet())
		{
			return null;
		}

		if (plugin.fightingBoss())
		{
			// This section handles the visuals when the player is in the boss room.
			// This section handles the projectile overlays.
			Set<Missiles> projectiles = plugin.getProjectiles();
			projectiles.forEach(projectile ->
			{
				BufferedImage icon = resizeImage(projectile.getImage(), plugin.getProjectileIconSize(), plugin.getProjectileIconSize());
				Color color = projectile.getColor();

				Polygon polygon = boundProjectile(projectile.getProjectile());
				if (polygon == null)
				{
					int x = (int) projectile.getProjectile().getX();
					int y = (int) projectile.getProjectile().getY();

					LocalPoint point = new LocalPoint(x, y);
					Point loc = Perspective.getCanvasImageLocation(client, point, icon, -(int) projectile.getProjectile().getZ());

					if (loc == null)
					{
						return;
					}

					if (plugin.isUniqueAttackVisual())
					{
						graphics.drawImage(icon, loc.getX(), loc.getY(), null);
					}
				}
				else
				{
					if (plugin.isAttackVisualOutline())
					{
						graphics.setColor(color);
						graphics.draw(polygon);
						graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 50));
						graphics.fill(polygon);
					}
					if (plugin.isUniqueAttackVisual())
					{
						Rectangle bounds = polygon.getBounds();
						int x = (int) bounds.getCenterX() - (icon.getWidth() / 2);
						int y = (int) bounds.getCenterY() - (icon.getHeight() / 2);
						graphics.drawImage(icon, x, y, null);
					}
				}
			});
			projectiles.removeIf(proj -> proj.getProjectile().getRemainingCycles() <= 0);

			plugin.getTornadoes().forEach(tornado ->
			{
				if (plugin.isOverlayTornadoes())
				{
					if (tornado.getTimeLeft() <= 0)
					{
						return;
					}

					final String textOverlay = Integer.toString(tornado.getTimeLeft());
					final Point textLoc = Perspective.getCanvasTextLocation(client, graphics, tornado.getNpc().getLocalLocation(), textOverlay, 0);
					final LocalPoint lp = LocalPoint.fromWorld(client, tornado.getNpc().getWorldLocation());

					if (lp == null)
					{
						return;
					}

					final Polygon tilePoly = Perspective.getCanvasTilePoly(client, lp);
					OverlayUtil.renderPolygon(graphics, tilePoly, Color.YELLOW);

					if (textLoc == null)
					{
						return;
					}

					Font oldFont = graphics.getFont();
					graphics.setFont(new Font("Arial", Font.BOLD, 20));
					Point pointShadow = new Point(textLoc.getX() + 1, textLoc.getY() + 1);
					OverlayUtil.renderTextLocation(graphics, pointShadow, textOverlay, Color.BLACK);
					OverlayUtil.renderTextLocation(graphics, textLoc, textOverlay, Color.YELLOW);
					graphics.setFont(oldFont);
				}
			});

			if (plugin.getHunllef() != null)
			{
				final Hunllef hunllef = plugin.getHunllef();
				final Hunllef.BossAttackPhase phase = hunllef.getCurrentPhase();
				final NPC boss = hunllef.getNpc();
				final LocalPoint point = boss.getLocalLocation();

				if (plugin.isFlash() && plugin.isFlashOnWrongAttack())
				{
					final Color flash = graphics.getColor();
					graphics.setColor(FLASH_COLOR);
					graphics.fill(new Rectangle(client.getCanvas().getSize()));
					graphics.setColor(flash);
					timeout++;
					if (timeout >= 15)
					{
						timeout = 0;
						plugin.setFlash(false);
					}
				}

				if (plugin.isOverlayBoss())
				{
					Shape polygon = boss.getConvexHull();

					if (polygon == null)
					{
						return null;
					}

					if (phase.getPrayer() != null && !client.isPrayerActive(phase.getPrayer()))
					{
						Color color = phase.getColor();
						outlineRenderer.drawOutline(boss, 12, color, new Color(0, 0, 0, 0));
					}
				}

				if (plugin.isOverlayBossPrayer())
				{
					BufferedImage attackIcon = null;

					switch (phase)
					{
						case MAGIC:
							attackIcon = resizeImage(hunllef.getMage(), plugin.getProjectileIconSize(), plugin.getProjectileIconSize());
							break;
						case RANGE:
							attackIcon = resizeImage(hunllef.getRange(), plugin.getProjectileIconSize(), plugin.getProjectileIconSize());
							break;
						default:
							break;
					}

					if (attackIcon == null)
					{
						return null;
					}

					Point imageLoc = Perspective.getCanvasImageLocation(client, point, attackIcon, boss.getLogicalHeight() / 2);

					if (imageLoc == null)
					{
						return null;
					}

					graphics.drawImage(attackIcon, imageLoc.getX(), imageLoc.getY(), null);
				}

				if (plugin.isHighlightWidget())
				{
					if (phase.getPrayer() == null)
					{
						return null;
					}

					final Rectangle bounds = OverlayUtil.renderPrayerOverlay(graphics, client, phase.getPrayer(), phase.getColor());

					if (bounds != null)
					{
						final Color color = hunllef.getTicksUntilAttack() == 1 ? Color.WHITE : phase.getColor();
						renderTextLocation(graphics, Integer.toString(hunllef.getTicksUntilAttack()), 16, Font.BOLD, color, centerPoint(bounds), false);
					}
				}

				if (plugin.getCountAttacks() == ONBOSS || plugin.getCountAttacks() == BOTH)
				{
					String textOverlay;

					textOverlay = Integer.toString(hunllef.getBossAttacks());

					if (textOverlay.length() > 0)
					{
						textOverlay += " | ";
					}

					textOverlay += Integer.toString(hunllef.getPlayerAttacks());

					if (textOverlay.length() > 0)
					{
						Point textLoc = Perspective.getCanvasTextLocation(client, graphics, point, textOverlay, boss.getLogicalHeight() / 2);

						if (textLoc == null)
						{
							return null;
						}

						textLoc = new Point(textLoc.getX(), textLoc.getY() + 35);

						Font oldFont = graphics.getFont();

						graphics.setFont(new Font("Arial", Font.BOLD, 20));
						Point pointShadow = new Point(textLoc.getX() + 1, textLoc.getY() + 1);

						OverlayUtil.renderTextLocation(graphics, pointShadow, textOverlay, Color.BLACK);
						OverlayUtil.renderTextLocation(graphics, textLoc, textOverlay, phase.getColor());

						graphics.setFont(oldFont);
					}
				}
			}
			if (plugin.getHunllef() == null)
			{
				overlayManager.remove(GauntletCounter);
			}
		}
		else
		{
			// This section overlays all resources.
			final LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();

			final Set<Resources> resources = plugin.getResources();
			resources.forEach(object ->
			{
				if (object.getGameObject().getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE)
				{

					// Don't use Convex Hull click box. As the room start to fill up, your FPS will dip.
					Shape polygon = object.getGameObject().getConvexHull();

					if (polygon == null)
					{
						return;
					}
					// This section will highlight the resource with color.
					if (plugin.isHighlightResources())
					{
						outlineRenderer.drawOutline(object.getGameObject(), 2, plugin.getHighlightResourcesColor());
					}

					// This section will overlay the resource with an icon.
					if (plugin.isHighlightResourcesIcons())
					{
						BufferedImage icon = resizeImage(object.getImage(), plugin.getResourceIconSize(), plugin.getResourceIconSize());
						Rectangle bounds = polygon.getBounds();
						int startX = (int) bounds.getCenterX() - (icon.getWidth() / 2);
						int startY = (int) bounds.getCenterY() - (icon.getHeight() / 2);
						graphics.drawImage(icon, startX, startY, null);
					}
				}
			});
		}
		return null;
	}

	private Polygon boundProjectile(Projectile proj)
	{
		if (proj == null || proj.getModel() == null)
		{
			return null;
		}

		Model model = proj.getModel();
		LocalPoint point = new LocalPoint((int) proj.getX(), (int) proj.getY());
		int tileHeight = Perspective.getTileHeight(client, point, client.getPlane());

		double angle = Math.atan(proj.getVelocityY() / proj.getVelocityX());
		angle = Math.toDegrees(angle) + (proj.getVelocityX() < 0 ? 180 : 0);
		angle = angle < 0 ? angle + 360 : angle;
		angle = 360 - angle - 90;

		double ori = angle * (512d / 90d);
		ori = ori < 0 ? ori + 2048 : ori;

		int orientation = (int) Math.round(ori);

		List<Vertex> vertices = model.getVertices();
		for (int i = 0; i < vertices.size(); ++i)
		{
			vertices.set(i, vertices.get(i).rotate(orientation));
		}

		List<Point> list = new ArrayList<>();

		for (Vertex vertex : vertices)
		{
			final Point localToCanvas = Perspective.localToCanvas(client, point.getX() - vertex.getX(), point.getY() - vertex.getZ(), tileHeight + vertex.getY() + (int) proj.getZ());
			if (localToCanvas != null)
			{
				list.add(localToCanvas);
			}
		}

		final List<Point> convexHull = Jarvis.convexHull(list);
		if (convexHull == null)
		{
			return null;
		}

		final Polygon polygon = new Polygon();
		for (final Point hullPoint : convexHull)
		{
			polygon.addPoint(hullPoint.getX(), hullPoint.getY());
		}

		return polygon;
	}

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint, boolean shadows)
	{
		graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
			final Point canvasCenterPoint = new Point(
				canvasPoint.getX() - 3,
				canvasPoint.getY() + 6);
			final Point canvasCenterPoint_shadow = new Point(
				canvasPoint.getX() - 2,
				canvasPoint.getY() + 7);
			if (shadows)
			{
				OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
			}
			OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
		}
	}

	private Point centerPoint(Rectangle rect)
	{
		int x = (int) (rect.getX() + rect.getWidth() / 2);
		int y = (int) (rect.getY() + rect.getHeight() / 2);
		return new Point(x, y);
	}
}
