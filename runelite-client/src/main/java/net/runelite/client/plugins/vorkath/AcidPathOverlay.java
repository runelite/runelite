package net.runelite.client.plugins.vorkath;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class AcidPathOverlay extends Overlay
{
    private static final Color ACID_SPOTS_COLOR = Color.GREEN;
    private static final Color ACID_FREE_PATH_COLOR = Color.PINK;
    private static final Color WOOXWALK_ATTACK_SPOT_COLOR = Color.YELLOW;
    private static final Color WOOXWALK_OUT_OF_REACH_SPOT_COLOR = Color.RED;
    private static final int BAR_INDICATOR_SPACER = 5;

    private final Client client;
    private final VorkathPlugin plugin;
    private final VorkathConfig config;

    @Inject
    public AcidPathOverlay(final Client client, final VorkathPlugin plugin, final VorkathConfig config)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        determineLayer();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (plugin.getVorkath() == null || plugin.getVorkath().getVorkath().getLocalLocation() == null)
        {
            return null;
        }

        if (config.indicateAcidPools() && plugin.getAcidSpots() != null
                && !plugin.getAcidSpots().isEmpty())
        {
            for (WorldPoint acidWorldPoint : plugin.getAcidSpots())
            {
                LocalPoint acidLocalPoint = LocalPoint.fromWorld(client, acidWorldPoint);
                if (acidLocalPoint == null)
                {
                    continue;
                }
                OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
                        acidLocalPoint), ACID_SPOTS_COLOR);
            }
        }

        if (config.indicateAcidFreePath() && plugin.getAcidFreePath() != null
                && !plugin.getAcidFreePath().isEmpty())
        {
            for (WorldPoint acidFreeWorldPoint : plugin.getAcidFreePath())
            {
                LocalPoint acidFreeLocalPoint = LocalPoint.fromWorld(client, acidFreeWorldPoint);
                if (acidFreeLocalPoint == null)
                {
                    continue;
                }

                OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
                        acidFreeLocalPoint), ACID_FREE_PATH_COLOR);
            }
        }

        if (config.indicateWooxWalkPath() && plugin.getWooxWalkPath()[0] != null
                && plugin.getWooxWalkPath()[1] != null)
        {
            LocalPoint attackLocalPoint = LocalPoint.fromWorld(client, plugin.getWooxWalkPath()[0]);
            LocalPoint outOfReachLocalPoint = LocalPoint.fromWorld(client, plugin.getWooxWalkPath()[1]);

            if (attackLocalPoint != null && outOfReachLocalPoint != null)
            {
                OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
                        attackLocalPoint), Color.YELLOW);
                OverlayUtil.renderPolygon(graphics, Perspective.getCanvasTilePoly(client,
                        outOfReachLocalPoint), Color.RED);

                if (config.indicateWooxWalkTick() && plugin.getWooxWalkBar() != null
                        && plugin.getWooxWalkTimer() != -1)
                {
                    int[] xpointsAttack = {
                            (int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2.0 + 1),
                            (int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth()),
                            (int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth()),
                            (int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2 + 1)
                    };
                    int[] xpointsOutOfReach = {
                            (int) plugin.getWooxWalkBar().getX(),
                            (int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2.0),
                            (int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getWidth() / 2.0),
                            (int) plugin.getWooxWalkBar().getX()
                    };
                    int[] ypointsBoth = {
                            (int) plugin.getWooxWalkBar().getY(),
                            (int) plugin.getWooxWalkBar().getY(),
                            (int) (plugin.getWooxWalkBar().getY() + plugin.getWooxWalkBar().getHeight()),
                            (int) (plugin.getWooxWalkBar().getY() + plugin.getWooxWalkBar().getHeight())
                    };
                    Polygon wooxWalkAttack = new Polygon(xpointsAttack, ypointsBoth, 4);
                    Polygon wooxWalkOutOfReach = new Polygon(xpointsOutOfReach, ypointsBoth, 4);
                    OverlayUtil.renderPolygon(graphics, wooxWalkAttack, WOOXWALK_ATTACK_SPOT_COLOR);
                    OverlayUtil.renderPolygon(graphics, wooxWalkOutOfReach, WOOXWALK_OUT_OF_REACH_SPOT_COLOR);

                    long timeLeft = (System.currentTimeMillis() - plugin.getWooxWalkTimer()) % 1200;
                    double timeScale;
                    if (timeLeft <= 600)
                    {
                        timeScale = 1 - timeLeft / 600.0;
                    }
                    else
                    {
                        timeLeft -= 600;
                        timeScale = timeLeft / 600.0;
                    }
                    int progress = (int) Math.round(plugin.getWooxWalkBar().getWidth() * timeScale);

                    int[] xpointsIndicator = {
                            (int) (plugin.getWooxWalkBar().getX() - plugin.getWooxWalkBar().getHeight() / 2 + progress),
                            (int) (plugin.getWooxWalkBar().getX() + plugin.getWooxWalkBar().getHeight() / 2 + progress),
                            (int) plugin.getWooxWalkBar().getX() + progress
                    };
                    int[] ypointsIndicator = {
                            (int) (plugin.getWooxWalkBar().getY() - plugin.getWooxWalkBar().getHeight() - BAR_INDICATOR_SPACER),
                            (int) (plugin.getWooxWalkBar().getY() - plugin.getWooxWalkBar().getHeight() - BAR_INDICATOR_SPACER),
                            (int) (plugin.getWooxWalkBar().getY() - BAR_INDICATOR_SPACER)
                    };
                    Polygon indicator = new Polygon(xpointsIndicator, ypointsIndicator, 3);
                    OverlayUtil.renderPolygon(graphics, indicator, Color.WHITE);
                }
            }
        }
        return null;
    }

    public void determineLayer()
    {
        if (config.mirrorMode())
        {
            //setLayer(OverlayLayer.AFTER_MIRROR);
            setLayer(OverlayLayer.ABOVE_SCENE);
        }
        if (!config.mirrorMode())
        {
            setLayer(OverlayLayer.ABOVE_SCENE);
        }
    }
}