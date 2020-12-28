package net.runelite.client.plugins.nightmare;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GraphicsObject;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import static net.runelite.api.Perspective.getCanvasTileAreaPoly;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.geometry.Geometry;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
@Slf4j
class NightmareOverlay extends Overlay
{
    private static final int NIGHTMARE_REGION_ID = 15256;
    // Nightmare's NPC IDs
    private static final int NIGHTMARE_PHASE1 = 9425;
    private static final int NIGHTMARE_PHASE2 = 9426;
    private static final int NIGHTMARE_PHASE3 = 9427;
    private static final int NIGHTMARE_PILLAR1 = 9428;
    private static final int NIGHTMARE_PILLAR2 = 9429;
    private static final int NIGHTMARE_PHASE10Z = 9432;
    // Non-Nightmare Objects
    private static final int NIGHTMARE_WALKER_1 = 9446;
    private static final int NIGHTMARE_WALKER_2 = 9447;
    private static final int NIGHTMARE_WALKER_3 = 9448;
    private static final int NIGHTMARE_WALKER_4 = 9449;
    private static final int NIGHTMARE_WALKER_5 = 9450;
    private static final int NIGHTMARE_WALKER_6 = 9451;
    private static final int NIGHTMARE_PARASITE = 9452;
    private static final int NIGHTMARE_HUSK = 9454;
    private static final int NIGHTMARE_SHADOW = 1767;   // graphics object
    private static final int NIGHTMARE_MUSHROOM = 37739;
    private static final int NM_PRE_REGION = 15256;
    private final Client client;
    private final NightmarePlugin plugin;
    private final NightmareConfig config;
    private int timeout;


    @Inject
    private NightmareOverlay(final Client client, final NightmarePlugin plugin, final NightmareConfig config)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        determineLayer();
        setPriority(OverlayPriority.LOW);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!client.isInInstancedRegion() || !plugin.isInFight())
        {
            return null;
        }

        if (config.highlightShadows())
        {
            for (GraphicsObject graphicsObject : client.getGraphicsObjects())
            {
                Color color;

                if (graphicsObject.getId() == NIGHTMARE_SHADOW)
                {
                    color = Color.ORANGE;
                }
                else
                {
                    continue;
                }

                LocalPoint lp = graphicsObject.getLocation();
                Polygon poly = Perspective.getCanvasTilePoly(client, lp);

                if (poly != null)
                {
                    OverlayUtil.renderPolygon(graphics, poly, color);
                }
            }
            if (plugin.isShadowsSpawning())
            {
                if (plugin.getNm() != null)
                {
                    Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, plugin.getNm().getLocalLocation(), 5);
                    OverlayUtil.renderPolygon(graphics, tilePoly, Color.ORANGE);
                }
            }
        }

        int ticksUntilNext = plugin.getTicksUntilNextAttack();
        if (config.ticksCounter() && ticksUntilNext > 0 && plugin.getNm() != null)
        {
            String str = Integer.toString(ticksUntilNext);

            LocalPoint lp = plugin.getNm().getLocalLocation();
            Point point = Perspective.getCanvasTextLocation(client, graphics, lp, str, 0);

            Color tickColor = Color.WHITE;

            NightmareAttack nextAttack = plugin.getPendingNightmareAttack();
            if (ticksUntilNext >= 4 && nextAttack != null)
            {
                tickColor = nextAttack.getTickColor();
            }

            renderTextLocation(graphics, str, 20, Font.BOLD, tickColor, point);
        }

        int ticksUntilNextParasite = plugin.getTicksUntilParasite();
        if (config.showTicksUntilParasite() && ticksUntilNextParasite > 0)
        {
            String str = Integer.toString(ticksUntilNextParasite);

            for (Player player : plugin.getParasiteTargets().values())
            {
                LocalPoint lp = player.getLocalLocation();
                Point point = Perspective.getCanvasTextLocation(client, graphics, lp, str, 0);

                renderTextLocation(graphics, str, 14, Font.BOLD, Color.RED, point);
            }
        }

        if (config.highlightTotems())
        {
            for (MemorizedTotem totem : plugin.getTotems().values())
            {
                if (totem.getCurrentPhase().isActive())
                {
                    final Shape polygon;
                    polygon = totem.getNpc().getConvexHull();
                    if(polygon != null){
                        OverlayUtil.renderPolygon(graphics,polygon,totem.getCurrentPhase().getColor());
                    }
                    
                    //replaced this with overlayutil bullshit
                    //outliner.drawOutline(totem.getNpc(), config.totemOutlineSize(), totem.getCurrentPhase().getColor());
                }
            }
        }

        if (config.highlightSpores())
        {
            drawPoisonArea(graphics, plugin.getSpores());
        }

        if (config.highlightHuskTarget())
        {
            drawHuskTarget(graphics, plugin.getHuskTarget());
        }

        if (config.highlightNightmareHitboxOnCharge())
        {
            drawNightmareHitboxOnCharge(graphics, plugin.getNm(), plugin.isNightmareCharging());
        }

        if (config.highlightNightmareChargeRange())
        {
            drawNightmareChargeRange(graphics, plugin.getNm(), plugin.isNightmareCharging());
        }

        if (config.huskHighlight())
        {
            renderHuskHighlights(graphics);
        }

        if (plugin.isFlash() && config.flash())
        {
            final Color flash = graphics.getColor();
            graphics.setColor(new Color(255, 0, 0, 70));
            graphics.fill(new Rectangle(client.getCanvas().getSize()));
            graphics.setColor(flash);
            timeout++;
            if (timeout >= 50)
            {
                timeout = 0;
                plugin.setFlash(false);
            }
        }

        return null;
    }

    protected void renderTextLocation(Graphics2D graphics, String txtString, int fontSize, int fontStyle, Color fontColor, Point canvasPoint)
    {
        graphics.setFont(new Font("Arial", fontStyle, fontSize));
        if (canvasPoint != null)
        {
            final Point canvasCenterPoint = new Point(canvasPoint.getX(), canvasPoint.getY());
            final Point canvasCenterPointShadow = new Point(canvasPoint.getX() + 1, canvasPoint.getY() + 1);

            OverlayUtil.renderTextLocation(graphics, canvasCenterPointShadow, txtString, Color.BLACK);
            OverlayUtil.renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor);
        }
    }

    private void renderNpcOverlay(Graphics2D graphics, NPC actor, Color color)
    {
        final Shape objectClickbox = actor.getConvexHull();
        graphics.setColor(color);
        graphics.draw(objectClickbox);
    }

    private void drawPoisonArea(Graphics2D graphics, Map<LocalPoint, GameObject> spores)
    {
        if (spores.size() < 1)
        {
            return;
        }

        Area poisonTiles = new Area();

        for (Map.Entry<LocalPoint, GameObject> entry : spores.entrySet())
        {
            LocalPoint point = entry.getKey();
            Polygon poly = getCanvasTileAreaPoly(client, point, 3);

            if (poly != null)
            {
                poisonTiles.add(new Area(poly));
            }
        }

        graphics.setPaintMode();
        graphics.setColor(config.poisonBorderCol());
        graphics.draw(poisonTiles);
        graphics.setColor(config.poisonCol());
        graphics.fill(poisonTiles);
    }

    private void drawNightmareHitboxOnCharge(Graphics2D graphics, NPC nm, boolean isNmCharging)
    {
        if (!isNmCharging)
        {
            return;
        }

        if (plugin.getNm() != null)
        {
            Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, plugin.getNm().getLocalLocation(), 5);
            OverlayUtil.renderPolygon(graphics, tilePoly, Color.ORANGE);
        }
    }

    private void drawNightmareChargeRange(Graphics2D graphics, NPC nm, boolean isNmCharging)
    {
        if (!isNmCharging)
        {
            return;
        }

        LocalPoint nmLocalPoint = nm.getLocalLocation();
        int nmX = nmLocalPoint.getX();
        int nmY = nmLocalPoint.getY();
        Area areaAddPoints = new Area();
        Polygon polyAddPoints = new Polygon();

        // if nightmare is at the gates, there are extra dangerous squares
        int offset = 1792;
        if (nmX == 6208)
        {
            offset = 2048;
        }

        // facing west
        if (nmX == 5312)
        {
            polyAddPoints.addPoint(nmX + offset + 256 + 64, nmY + 256 + 64);
            polyAddPoints.addPoint(nmX - 256 - 64, nmY + 256 + 64);
            polyAddPoints.addPoint(nmX - 256 - 64, nmY - 256 - 64);
            polyAddPoints.addPoint(nmX + offset + 256 + 64, nmY - 256 - 64);
        }
        // facing east
        else if (nmX == 7104)
        {
            polyAddPoints.addPoint(nmX + 256 + 64, nmY + 256 + 64);
            polyAddPoints.addPoint(nmX - offset - 256 - 64, nmY + 256 + 64);
            polyAddPoints.addPoint(nmX - offset - 256 - 64, nmY - 256 - 64);
            polyAddPoints.addPoint(nmX + 256 + 64, nmY - 256 - 64);
        }
        // facing north
        else if (nmY == 8000 || nmY == 8128)
        {
            polyAddPoints.addPoint(nmX + 256 + 64, nmY + 256 + 64);
            polyAddPoints.addPoint(nmX - 256 - 64, nmY + 256 + 64);
            polyAddPoints.addPoint(nmX - 256 - 64, nmY - offset - 256 - 64);
            polyAddPoints.addPoint(nmX + 256 + 64, nmY - offset - 256 - 64);
        }
        //facing south
        else if (nmY == 6080 || nmY == 6208)
        {
            polyAddPoints.addPoint(nmX + 256 + 64, nmY + offset + 256 + 64);
            polyAddPoints.addPoint(nmX - 256 - 64, nmY + offset + 256 + 64);
            polyAddPoints.addPoint(nmX - 256 - 64, nmY - 256 - 64);
            polyAddPoints.addPoint(nmX + 256 + 64, nmY - 256 - 64);
        }

        areaAddPoints.add(new Area(polyAddPoints));
        GeneralPath path = new GeneralPath(areaAddPoints);

        renderPath(graphics, path);

    }

    private void renderPath(Graphics2D graphics, GeneralPath path)
    {
        graphics.setPaintMode();
        graphics.setColor(config.nightmareChargeBorderCol());
        graphics.setStroke(new BasicStroke(1));

        path = Geometry.filterPath(path, (p1, p2) ->
                Perspective.localToCanvas(client, new LocalPoint((int) p1[0], (int) p1[1]), client.getPlane()) != null &&
                        Perspective.localToCanvas(client, new LocalPoint((int) p2[0], (int) p2[1]), client.getPlane()) != null);
        path = Geometry.transformPath(path, coords ->
        {
            Point point = Perspective.localToCanvas(client, new LocalPoint((int) coords[0], (int) coords[1]), client.getPlane());
            if (point != null)
            {
                coords[0] = point.getX();
                coords[1] = point.getY();
            }
        });

        graphics.draw(path);
        graphics.setColor(config.nightmareChargeCol());
        graphics.fill(path);

    }

    private void renderHuskHighlights(Graphics2D graphics)
    {
        client.getNpcs().forEach((npc) ->
        {
            int id = npc.getId();
            Color color;
            switch (id)
            {
                case 9454:
                    color = Color.CYAN;
                    break;
                case 9455:
                    color = Color.GREEN;
                    break;
                default:
                    return;
            }

            if (!npc.isDead())
            {
                OverlayUtil.renderPolygon(graphics, npc.getConvexHull(), color);
            }
        });
    }

    private void drawHuskTarget(Graphics2D graphics, Map<Polygon, Player> huskTarget)
    {
        if (huskTarget.size() < 1)
        {
            return;
        }

        for (Map.Entry<Polygon, Player> entry : huskTarget.entrySet())
        {
            Polygon playerPolygon = entry.getKey();
            OverlayUtil.renderPolygon(graphics, playerPolygon, config.huskBorderCol());
        }
    }

    public void determineLayer()
    {
        if (config.mirrorMode())
        {
            setLayer(OverlayLayer.ALWAYS_ON_TOP);
        }
        if (!config.mirrorMode())
        {
            setLayer(OverlayLayer.ABOVE_SCENE);
        }
    }
}