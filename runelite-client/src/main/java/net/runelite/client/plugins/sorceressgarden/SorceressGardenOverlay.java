package net.runelite.client.plugins.sorceressgarden;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.*;
import javax.inject.Inject;
import javax.management.Query;

import com.google.common.collect.ImmutableSet;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class SorceressGardenOverlay extends OverlayPanel
{
    final SorceressGardenPlugin plugin;
    private final SorceressGardenConfig config;
    private final Client client;

    @Inject
    public SorceressGardenOverlay(final SorceressGardenPlugin plugin, final SorceressGardenConfig config, Client client)
    {
        this.plugin = plugin;
        this.config = config;
        this.client = client;
        setPosition(OverlayPosition.DYNAMIC);
        determineLayer();
        setPriority(OverlayPriority.HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!plugin.isInGarden())
        {
            return null;
        }

        renderSafeTiles(graphics);

        renderElementals(graphics);

        renderWinterOneClick(graphics);

        renderSummerOneClick(graphics);

        return super.render(graphics);
    }

    public void determineLayer()
    {
        setLayer(config.mirrorMode() ? OverlayLayer.ALWAYS_ON_TOP : OverlayLayer.ABOVE_SCENE);
    }

    private void renderTile(final Graphics2D graphics, final LocalPoint dest, final Color color)
    {
        if (dest == null)
        {
            return;
        }

        final Polygon poly = Perspective.getCanvasTilePoly(client, dest);

        if (poly == null)
        {
            return;
        }

        OverlayUtil.renderPolygon(graphics, poly, color);
    }

    private void renderText(final Graphics2D graphics, final LocalPoint dest, final String text, final Color color)
    {
        if (dest == null)
        {
            return;
        }

        Point textLocation = Perspective.getCanvasTextLocation(client, graphics, dest, text, 0);
        if (textLocation != null)
        {
            OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
        }
    }

    private void renderSafeTiles(Graphics2D graphics)
    {
        if (!config.showSafeTiles())
        {
            return;
        }
        final Set<WorldPoint> SAFE_TILES = ImmutableSet.of(
                // Winter Garden
                new WorldPoint(2900, 5470, 0),
                new WorldPoint(2900, 5476, 0),
                new WorldPoint(2892, 5484, 0),

                // Spring Garden
                new WorldPoint(2923, 5471, 0),
                new WorldPoint(2923, 5472, 0),
                new WorldPoint(2923, 5473, 0),
                new WorldPoint(2923, 5465, 0),
                new WorldPoint(2923, 5466, 0),
                new WorldPoint(2923, 5459, 0),
                new WorldPoint(2924, 5468, 0),
                new WorldPoint(2926, 5468, 0),
                new WorldPoint(2926, 5470, 0),
                new WorldPoint(2927, 5470, 0),
                new WorldPoint(2928, 5470, 0),
                new WorldPoint(2930, 5470, 0),
                new WorldPoint(2933, 5468, 0),

                // Autumn Garden
                new WorldPoint(2910, 5460, 0),
                new WorldPoint(2908, 5461, 0),
                new WorldPoint(2904, 5459, 0),
                new WorldPoint(2902, 5461, 0),
                new WorldPoint(2899, 5457, 0),
                new WorldPoint(2899, 5458, 0),
                new WorldPoint(2899, 5459, 0),
                new WorldPoint(2900, 5458, 0),
                new WorldPoint(2901, 5455, 0),
                new WorldPoint(2901, 5456, 0),
                new WorldPoint(2901, 5457, 0),
                new WorldPoint(2901, 5458, 0),
                new WorldPoint(2899, 5455, 0),
                new WorldPoint(2899, 5453, 0),
                new WorldPoint(2901, 5451, 0),
                new WorldPoint(2903, 5450, 0),
                new WorldPoint(2902, 5453, 0),
                new WorldPoint(2906, 5458, 0),
                new WorldPoint(2907, 5458, 0),
                new WorldPoint(2908, 5456, 0),
                new WorldPoint(2913, 5454, 0),

                // Summer Garden
                new WorldPoint(2908, 5482, 0),
                new WorldPoint(2906, 5483, 0),
                new WorldPoint(2906, 5485, 0),
                new WorldPoint(2906, 5488, 0),
                new WorldPoint(2906, 5489, 0),
                new WorldPoint(2906, 5490, 0),
                new WorldPoint(2906, 5491, 0),
                new WorldPoint(2906, 5492, 0),
                new WorldPoint(2909, 5494, 0),
                new WorldPoint(2909, 5493, 0),
                new WorldPoint(2909, 5492, 0),
                new WorldPoint(2909, 5491, 0),
                new WorldPoint(2909, 5490, 0),
                new WorldPoint(2909, 5488, 0),
                new WorldPoint(2909, 5487, 0),
                new WorldPoint(2909, 5486, 0),
                new WorldPoint(2909, 5485, 0),
                new WorldPoint(2909, 5484, 0),
                new WorldPoint(2910, 5485, 0),
                new WorldPoint(2910, 5484, 0),
                new WorldPoint(2911, 5485, 0),
                new WorldPoint(2911, 5484, 0),
                new WorldPoint(2924, 5485, 0),
                new WorldPoint(2924, 5487, 0),
                new WorldPoint(2920, 5488, 0)
        );
        /*final Set<WorldPoint> SAFE_TILES = Set.of(
                // Winter Garden
                new WorldPoint(2900, 5470, 0),
                new WorldPoint(2900, 5476, 0),
                new WorldPoint(2892, 5484, 0),

                // Spring Garden
                new WorldPoint(2923, 5471, 0),
                new WorldPoint(2923, 5472, 0),
                new WorldPoint(2923, 5473, 0),
                new WorldPoint(2923, 5465, 0),
                new WorldPoint(2923, 5466, 0),
                new WorldPoint(2923, 5459, 0),
                new WorldPoint(2924, 5468, 0),
                new WorldPoint(2926, 5468, 0),
                new WorldPoint(2926, 5470, 0),
                new WorldPoint(2927, 5470, 0),
                new WorldPoint(2928, 5470, 0),
                new WorldPoint(2930, 5470, 0),
                new WorldPoint(2933, 5468, 0),

                // Autumn Garden
                new WorldPoint(2910, 5460, 0),
                new WorldPoint(2908, 5461, 0),
                new WorldPoint(2904, 5459, 0),
                new WorldPoint(2902, 5461, 0),
                new WorldPoint(2899, 5457, 0),
                new WorldPoint(2899, 5458, 0),
                new WorldPoint(2899, 5459, 0),
                new WorldPoint(2900, 5458, 0),
                new WorldPoint(2901, 5455, 0),
                new WorldPoint(2901, 5456, 0),
                new WorldPoint(2901, 5457, 0),
                new WorldPoint(2901, 5458, 0),
                new WorldPoint(2899, 5455, 0),
                new WorldPoint(2899, 5453, 0),
                new WorldPoint(2901, 5451, 0),
                new WorldPoint(2903, 5450, 0),
                new WorldPoint(2902, 5453, 0),
                new WorldPoint(2906, 5458, 0),
                new WorldPoint(2907, 5458, 0),
                new WorldPoint(2908, 5456, 0),
                new WorldPoint(2913, 5454, 0),

                // Summer Garden
                new WorldPoint(2908, 5482, 0),
                new WorldPoint(2906, 5483, 0),
                new WorldPoint(2906, 5485, 0),
                new WorldPoint(2906, 5488, 0),
                new WorldPoint(2906, 5489, 0),
                new WorldPoint(2906, 5490, 0),
                new WorldPoint(2906, 5491, 0),
                new WorldPoint(2906, 5492, 0),
                new WorldPoint(2909, 5494, 0),
                new WorldPoint(2909, 5493, 0),
                new WorldPoint(2909, 5492, 0),
                new WorldPoint(2909, 5491, 0),
                new WorldPoint(2909, 5490, 0),
                new WorldPoint(2909, 5488, 0),
                new WorldPoint(2909, 5487, 0),
                new WorldPoint(2909, 5486, 0),
                new WorldPoint(2909, 5485, 0),
                new WorldPoint(2909, 5484, 0),
                new WorldPoint(2910, 5485, 0),
                new WorldPoint(2910, 5484, 0),
                new WorldPoint(2911, 5485, 0),
                new WorldPoint(2911, 5484, 0),
                new WorldPoint(2924, 5485, 0),
                new WorldPoint(2924, 5487, 0),
                new WorldPoint(2920, 5488, 0)
        );*/

        for (WorldPoint safeTile : SAFE_TILES)
        {
            if (safeTile.getPlane() != client.getPlane())
            {
                return;
            }

            LocalPoint lp = LocalPoint.fromWorld(client, safeTile);
            if (lp == null)
            {
                return;
            }

            Polygon poly = Perspective.getCanvasTilePoly(client, lp);
            if (poly == null)
            {
                return;
            }

            OverlayUtil.renderPolygon(graphics, poly, Color.GREEN);
        }
    }

    private void renderElementals(Graphics2D graphics)
    {
        if (!config.highlightElementals())
        {
            return;
        }

        for (NPC nearbyNPC : client.getNpcs())
        {
            Color color;

            if (nearbyNPC == null)
            {
                continue;
            }

            if (Objects.requireNonNull(nearbyNPC.getName()).contains("Elemental"))
            {
                color = Color.ORANGE;
            }
            else
            {
                continue;
            }

            LocalPoint lp = nearbyNPC.getLocalLocation();
            Polygon poly = Perspective.getCanvasTilePoly(client, lp);

            if (poly != null)
            {
                OverlayUtil.renderPolygon(graphics, poly, color);
            }
        }
    }

    private void renderWinterOneClick(Graphics2D graphics)
    {
        if (!config.showOneClickSync() && !config.showWinterOneClick())
        {
            return;
        }
        WorldPoint winterCheckTile = new WorldPoint(2899, 5468, 0);
        WorldPoint winterStartTile = new WorldPoint(2902, 5470, 0);
        // Start Tile
        final LocalPoint startTileLocal = LocalPoint.fromWorld(client, winterStartTile);

        if (startTileLocal == null){
            return;
        }
        Player localPlayer = client.getLocalPlayer();
        if (localPlayer != null && localPlayer.getWorldLocation().equals(winterStartTile)) {
            renderTile(graphics, startTileLocal, Color.GREEN);
            renderText(graphics, startTileLocal, "Start", Color.GREEN);
        }
        else{
            renderTile(graphics, startTileLocal, Color.RED);
            renderText(graphics, startTileLocal, "Start", Color.RED);
        }

        int winterNPCID = NpcID.WINTER_ELEMENTAL;
        List<NPC> wintertargets = plugin.getTargets();
        int distance = 1000;
        NPC closest  = wintertargets.get(1);
        for(NPC target: wintertargets){
            int away = client.getLocalPlayer().getWorldLocation().distanceTo(target.getWorldLocation());
            if(target.getId() == winterNPCID && distance != 0 && distance > away){
                closest = target;
                distance = away;
            }
        }
        NPC winterNPC = closest;

        if (winterNPC == null)
        {
            return;
        }

        // Sync tile
        final LocalPoint checkTileLocal = LocalPoint.fromWorld(client, winterCheckTile);

        if (checkTileLocal == null)
        {
            return;
        }

        if (winterNPC.getWorldLocation().equals(winterCheckTile) && winterNPC.getOrientation() == 1024)
        {
            renderTile(graphics, checkTileLocal, Color.GREEN);
            renderText(graphics, checkTileLocal, "Check", Color.GREEN);
        }
        else
        {
            renderTile(graphics, checkTileLocal, Color.RED);
            renderText(graphics, checkTileLocal, "Check", Color.RED);
        }


    }

    private void renderSummerOneClick(Graphics2D graphics)
    {

        if (!config.showOneClickSync() && !config.showSummerOneClick())
        {
            return;
        }

        WorldPoint summerSyncTile = new WorldPoint(2907, 5489, 0);
        WorldPoint summerCheckTile = new WorldPoint(2907, 5485, 0);
        WorldPoint summerStartTile = new WorldPoint(2908, 5482, 0);
        int northSummerNPCID = NpcID.SUMMER_ELEMENTAL_1802;
        int southSummerNPCID = NpcID.SUMMER_ELEMENTAL;
        List<NPC> summertargets = plugin.getTargets();
        int distance = 1000;
        NPC northSummerNPC = plugin.getTargets().get(plugin.getTargets().size()-1);
        NPC southSummerNPC = plugin.getTargets().get(plugin.getTargets().size()-1);
        for (NPC target : summertargets) {
            int away = client.getLocalPlayer().getWorldLocation().distanceTo(target.getWorldLocation());
            if (target.getId() == northSummerNPCID && distance != 0 && distance > away) {
                northSummerNPC = target;
                distance = away;
            }
            if (target.getId() == southSummerNPCID && distance != 0 && distance > away) {
                southSummerNPC = target;
                distance = away;
            }
        }
        //NPC northSummerNPC = new NPCQuery().idEquals(northSummerNPCID).result(client).nearestTo(client.getLocalPlayer());
        //NPC southSummerNPC = new NPCQuery().idEquals(southSummerNPCID).result(client).nearestTo(client.getLocalPlayer());

        if (northSummerNPC == null || southSummerNPC == null)
        {
            return;
        }

        // Sync Tile
        final LocalPoint syncTileLocal = LocalPoint.fromWorld(client, summerSyncTile);

        if (syncTileLocal == null)
        {
            return;
        }

        if (summerSyncTile.distanceTo(northSummerNPC.getWorldLocation()) == summerSyncTile.distanceTo(southSummerNPC.getWorldLocation()))
        {
            renderTile(graphics, syncTileLocal, Color.GREEN);
            renderText(graphics, syncTileLocal, "Sync", Color.GREEN);
        }
        else
        {
            renderTile(graphics, syncTileLocal, Color.RED);
            renderText(graphics, syncTileLocal, "Sync", Color.RED);
        }

        // Start Tile
        final LocalPoint startTileLocal = LocalPoint.fromWorld(client, summerStartTile);

        if (startTileLocal == null)
        {
            return;
        }

        Player localPlayer = client.getLocalPlayer();

        if (localPlayer != null && localPlayer.getWorldLocation().equals(summerStartTile))
        {
            renderTile(graphics, startTileLocal, Color.GREEN);
            renderText(graphics, startTileLocal, "Start", Color.GREEN);
        }
        else
        {
            renderTile(graphics, startTileLocal, Color.RED);
            renderText(graphics, startTileLocal, "Start", Color.RED);
        }


        // Check Tile
        final LocalPoint checkTileLocal = LocalPoint.fromWorld(client, summerCheckTile);

        if (checkTileLocal == null)
        {
            return;
        }

        if (southSummerNPC.getWorldLocation().equals(summerCheckTile) && southSummerNPC.getOrientation() == 1024)
        {
            renderTile(graphics, checkTileLocal, Color.GREEN);
            renderText(graphics, checkTileLocal, "Check", Color.GREEN);
        }
        else
        {
            renderTile(graphics, checkTileLocal, Color.RED);
            renderText(graphics, checkTileLocal, "Check", Color.RED);
        }
    }
}
