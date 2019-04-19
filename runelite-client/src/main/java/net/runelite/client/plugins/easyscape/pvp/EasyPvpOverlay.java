package net.runelite.client.plugins.easy.pvp;

import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import java.awt.*;

public class EasyPvpOverlay extends Overlay {

    private final Client client;
    private final EasyPvpPlugin plugin;
    private final EasyPvpConfig config;

    @Inject
    private EasyPvpOverlay(Client client, EasyPvpPlugin plugin, EasyPvpConfig config) {
        this.client = client;
        this.plugin = plugin;
        this.config = config;

        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (config.getShowAttackablePlayers()) {
            for (Player player : plugin.getTargets()) {
                OverlayUtil.renderPolygon(graphics, player.getConvexHull(), Color.RED);

                Point minimapLocation = player.getMinimapLocation();
                if (minimapLocation != null) {
                    OverlayUtil.renderMinimapLocation(graphics, minimapLocation, Color.RED.darker());
                    OverlayUtil.renderTextLocation(graphics, minimapLocation, player.getName(), Color.RED);
                }
            }
        }

        //


        return null;
    }
}
//    @Override
//    public Dimension render(Graphics2D graphics)
//    {
//        if (config.getShowWildernessRange())
//        {
////            plugin.getDeadNpcsToDisplay().forEach((id, npc) -> renderNpcRespawn(npc, graphics));
//        }
//
//        if (config.getShowAttackablePlayers())
//
//            for (Player player : plugin.getAttackablePlayers()) {
//                if (player != null) {
//                    renderNpcOverlay(graphics, player, player.getName(), Color.RED);
//                } else {
//                    plugin.getAttackablePlayers().remove(player);
//                }
//            }
//
//        return null;
//    }

//    private void renderNpcOverlay(Graphics2D graphics, Player actor, String name, Color color)
//    {
//        LocalPoint lp = actor.getLocalLocation();
////        Polygon tilePoly = Perspective.getCanvasTileAreaPoly(client, lp, 1);
//
//        renderTile(graphics, lp, color);
////        renderMinimap();
//
////        if (config.drawNames())
////        {
////            Point textLocation = actor.getCanvasTextLocation(graphics, name, actor.getLogicalHeight() + 40);
////
////            if (textLocation != null)
////            {
////                OverlayUtil.renderTextLocation(graphics, textLocation, name, color);
////            }
////        }
//    }

//    private void renderTile(final Graphics2D graphics, final LocalPoint dest, final Color color)
//    {
//        if (dest == null)
//        {
//            return;
//        }
//        final Polygon poly = Perspective.getCanvasTilePoly(client, dest);
//        if (poly == null)
//        {
//            return;
//        }
//        OverlayUtil.renderPolygon(graphics, poly, color);
//    }
