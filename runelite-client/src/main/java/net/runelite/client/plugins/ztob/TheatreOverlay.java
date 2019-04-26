/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.ztob;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GroundObject;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.NpcID;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class TheatreOverlay extends Overlay {
    private final Client client;
    private final TheatrePlugin plugin;
    private final TheatreConfig config;

    @Inject
    private TheatreOverlay(Client client, TheatrePlugin plugin, TheatreConfig config) {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.isRunMaiden())
		{
			if (config.MaidenBlood())
			{
				for (WorldPoint point : plugin.getMaiden_BloodSpatters())
				{
                    drawTile(graphics, point, new Color(36, 248, 229), 2, 150, 10);
                }
            }

			if (config.MaidenSpawns())
			{
				for (WorldPoint point : plugin.getMaiden_SpawnLocations())
				{
                    drawTile(graphics, point, new Color(36, 248, 229), 2, 180, 20);
                }
				for (WorldPoint point : plugin.getMaiden_SpawnLocations2())
				{
					drawTile(graphics, point, new Color(36, 248, 229), 1, 120, 10);
                }
            }
        }

		if (plugin.isRunBloat() && config.BloatIndicator())
		{
			if (config.bloatFeetIndicator())
			{
				if (plugin.getTemp().size() > 0)
				{
					if (plugin.isTempFlag())
					{
						for (WorldPoint point : plugin.getTemp())
						{

							drawTile(graphics, point, Color.black, 4, 255, 0);

						}

					}
				}
				else if (plugin.getTemp2().size() > 0)
				{
					if (plugin.isTemp2Flag())
					{
						for (WorldPoint point : plugin.getTemp2())
						{

							drawTile(graphics, point, Color.black, 4, 255, 0);


						}

					}
				}
            }
            NPC bloat = plugin.getBloat_NPC();
            int state = plugin.getBloat_State();
			if (bloat == null)
			{
                return null;
            }
			switch (state)
			{
                case 2:
                    renderNpcOverlay(graphics, bloat, Color.GREEN, 3, 150, 0);
                    break;
                case 3:
                    renderNpcOverlay(graphics, bloat, Color.YELLOW, 3, 150, 0);
                    break;
                default:
                    renderNpcOverlay(graphics, bloat, new Color(223, 109, 255), 3, 150, 0);
                    break;
            }
        }

		if (plugin.isRunNylocas())
		{
			if (config.NyloPillars())
			{
                Map<NPC, Integer> pillars = plugin.getNylocas_Pillars();
                for (NPC npc : pillars.keySet()) {
                    final int health = pillars.get(npc);
                    final String healthStr = health + "%";
                    WorldPoint p = npc.getWorldLocation();
                    LocalPoint lp = LocalPoint.fromWorld(client, p.getX() + 1, p.getY() + 1);
                    final double rMod = 130.0 * health / 100.0;
                    final double gMod = 255.0 * health / 100.0;
                    final double bMod = 125.0 * health / 100.0;
                    final Color c = new Color((int) (255 - rMod), (int) (0 + gMod), (int) (0 + bMod));
                    Point canvasPoint = Perspective.localToCanvas(client, lp, client.getPlane(),
                            65);
                    renderTextLocation(graphics, healthStr, 13, Font.BOLD, c, canvasPoint);
                }
            }

			if (config.NyloBlasts())
			{
                final Map<NPC, Integer> npcMap = plugin.getNylocas_Map();
				for (NPC npc : npcMap.keySet())
				{
                    int ticksLeft = npcMap.get(npc);
                    if (ticksLeft > -1) {
                        if (ticksLeft <= 6) {
							Color color = new Color(255, 255, 0, 180);
                            int outlineWidth = 2;
                            int outlineAlpha = 150;
                            renderNpcOverlay(graphics, npc, color, outlineWidth, outlineAlpha, 15);
                        }
                    }
                }
            }
        }

		if (plugin.isRunSotetseg())
		{
			if (config.SotetsegMaze1())
			{
                int i = 1;
				for (GroundObject o : plugin.getRedTiles().keySet())
				{
                    Polygon poly = o.getCanvasTilePoly();
					if (poly != null)
					{
                        graphics.setColor(Color.WHITE);
                        graphics.setStroke(new BasicStroke(2));
                        graphics.draw(poly);
                    }
                    Point textLocation = o.getCanvasTextLocation(graphics, String.valueOf(i), 0);
					if (textLocation != null)
					{
                        OverlayUtil.renderTextLocation(graphics, textLocation, String.valueOf(i), Color.WHITE);
                    }

                    i++;
                }
            }

			if (config.SotetsegMaze2())
			{
				for (WorldPoint p : plugin.getRedTilesOverworld())
				{
                    drawTile(graphics, p, Color.WHITE, 2, 255, 10);
                }
            }
        }


		if (plugin.isRunXarpus())
		{
            NPC boss = plugin.getXarpus_NPC();

			if (boss.getId() == NpcID.XARPUS_8340 && !plugin.isXarpus_Stare() && config.XarpusTick())
			{
                int tick = plugin.getXarpus_TicksUntilShoot();
				if (tick < 1)
				{
                    tick = tick % 4 + 4;
                }
                final String ticksLeftStr = String.valueOf(tick);
                Point canvasPoint = boss.getCanvasTextLocation(graphics, ticksLeftStr, 130);
                renderTextLocation(graphics, ticksLeftStr, 12, Font.BOLD, Color.WHITE, canvasPoint);
            }
			if (boss.getId() == NpcID.XARPUS_8339 && config.XarpusExhumed())
			{
				for (GroundObject o : plugin.getXarpus_Exhumeds().keySet())
				{



                    Polygon poly = o.getCanvasTilePoly();
					if (poly != null)
					{
                        graphics.setColor(new Color(0, 255, 0, 130));
                        graphics.setStroke(new BasicStroke(1));
                        graphics.draw(poly);
                    }
                }
				for (Map.Entry<GroundObject, Integer> exhumes : plugin.getXarpusExhumedsTimer().entrySet())
				{
                    final String ticksremaining = String.valueOf(exhumes.getValue());
					if (Integer.valueOf(ticksremaining) > 0)
					{
                        GroundObject ex = exhumes.getKey();
                        Point point = ex.getCanvasTextLocation(graphics, ticksremaining, 0);
                        renderTextLocation(graphics, ticksremaining, 12, Font.BOLD, Color.white, point);
                    }

                }


            }

        }


		if (plugin.isRunVerzik())
		{


			if (config.VerzikCupcakes())
			{
				for (WorldPoint p : plugin.getVerzik_RangeProjectiles().values())
				{
                    drawTile(graphics, p, Color.RED, 2, 180, 50);
                }
            }

			if (config.VerzikYellow())
			{
				for (WorldPoint p : plugin.getVerzik_YellowTiles())
				{
					drawTile(graphics, p, Color.YELLOW, 3, 255, 0);
                    Projectile yellowBall = plugin.getVerzik_YellowBall();
					if (yellowBall != null)
					{
						final int ticksToImpact = yellowBall.getRemainingCycles() / 30;
                        final String countdownStr = String.valueOf(ticksToImpact);
                        Point canvasPoint = Perspective.getCanvasTextLocation(client, graphics, LocalPoint.fromWorld(client, p), countdownStr, 0);
                        renderTextLocation(graphics, countdownStr, 12, Font.BOLD, Color.WHITE, canvasPoint);

                    }
                }
            }

            final NPC boss = plugin.getVerzik_NPC();
			if (boss.getId() == NpcID.VERZIK_VITUR_8374)
			{
				if (config.verzikTankTile())
				{
					renderNpcOverlay(graphics, boss, new Color(75, 0, 130), 1, 255, 0);
                }

				if (config.VerzikTick())
				{
                    final int ticksLeft = plugin.getP3_TicksUntilAttack();
					if (ticksLeft > 0 && ticksLeft < 8)
					{
                        final String ticksLeftStr = String.valueOf(ticksLeft);
                        Point canvasPoint = boss.getCanvasTextLocation(graphics, ticksLeftStr, 60);
                        renderTextLocation(graphics, ticksLeftStr, 15, Font.BOLD, Color.WHITE, canvasPoint);
                    }
                }

				if (config.VerzikMelee())
				{
                    List<WorldPoint> meleeRange = getHitSquares(boss.getWorldLocation(), 7, 1, false);

					for (WorldPoint p : meleeRange)
					{
						drawTile(graphics, p, Color.WHITE, 1, 155, 10);
                    }
                }
            }

			if (boss.getAnimation() == 8117)
			{
                final int ticksLeft = plugin.getRedCrabsTimer();
				if (ticksLeft > 0)
				{
                    final String ticksLeftStr = String.valueOf(ticksLeft);
                    Point canvasPoint = boss.getCanvasTextLocation(graphics, ticksLeftStr, 60);
                    renderTextLocation(graphics, ticksLeftStr, 15, Font.BOLD, Color.WHITE, canvasPoint);
                }
            }

        }

        return null;
    }

    private void drawTile(Graphics2D graphics, WorldPoint point, Color color, int strokeWidth, int outlineAlpha, int fillAlpha) {
        WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
        if (point.distanceTo(playerLocation) >= 32) {
            return;
        }
        LocalPoint lp = LocalPoint.fromWorld(client, point);
        if (lp == null) {
            return;
        }

        Polygon poly = Perspective.getCanvasTilePoly(client, lp);
        if (poly == null) {
            return;
        }
        //OverlayUtil.renderPolygon(graphics, poly, color);
        graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
        graphics.setStroke(new BasicStroke(strokeWidth));
        graphics.draw(poly);
        graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
        graphics.fill(poly);
    }

	private void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color, int outlineWidth, int outlineAlpha, int fillAlpha)
	{
        int size = 1;
        NPCComposition composition = actor.getTransformedComposition();
		if (composition != null)
		{
            size = composition.getSize();
        }
        LocalPoint lp = actor.getLocalLocation();
        Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, size);

		if (tilePoly != null)
		{
            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), outlineAlpha));
            graphics.setStroke(new BasicStroke(outlineWidth));
            graphics.draw(tilePoly);
            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), fillAlpha));
            graphics.fill(tilePoly);
        }
    }

	private void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
	{
        graphics.setFont(new Font("Arial", fontStyle, fontSize));
		if (canvasPoint != null)
		{
            final Point canvasCenterPoint = new Point(
                    canvasPoint.getX(),
                    canvasPoint.getY());
            final Point canvasCenterPoint_shadow = new Point(
                    canvasPoint.getX() + 1,
				canvasPoint.getY() + 1);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint_shadow, txtString, Color.BLACK);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
        }
    }

	private List<WorldPoint> getHitSquares(WorldPoint npcLoc, int npcSize, int thickness, boolean includeUnder)
	{
        List<WorldPoint> little = new WorldArea(npcLoc, npcSize, npcSize).toWorldPointList();
		List<WorldPoint> big = new WorldArea(npcLoc.getX() - thickness, npcLoc.getY() - thickness, npcSize + (thickness * 2), npcSize + (thickness * 2), npcLoc.getPlane()).toWorldPointList();
		if (!includeUnder)
		{
			for (Iterator<WorldPoint> it = big.iterator(); it.hasNext(); )
			{
                WorldPoint p = it.next();
				if (little.contains(p))
				{
                    it.remove();
                }
            }
        }
        return big;
    }
}