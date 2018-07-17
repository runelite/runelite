package net.runelite.client.plugins.vorkath;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VorkathSceneOverlay extends Overlay {

    private final Client client;
    private final VorkathPlugin plugin;
    private final Color BOMB_AOE_COLOR = new Color(150, 10, 40);
    private final Color SPAWN_COLOR = new Color(20, 60, 220);

    @Inject
    public VorkathSceneOverlay(Client client, VorkathPlugin plugin) {
        this.client = client;
        this.plugin = plugin;

        setLayer(OverlayLayer.ABOVE_SCENE);
        setPosition(OverlayPosition.DYNAMIC);
    }

    @Override
    public Dimension render(Graphics2D graphics) {

        if (!plugin.isInVorkathArea()) {
            return null;
        }

        if (plugin.getVorkathState() == VorkathState.FIRE_BOMB_ATTACK) {
            renderFireBombAOE(graphics, plugin.getFireBombHitLocation());
        }

        if (plugin.isZombieSpawnAlive){
            renderSpawnOverlay(graphics);
        }
        return null;
    }

    private void renderSpawnOverlay(Graphics2D graphics) {
        LocalPoint spawnLocation = plugin.getSpawnNpc().getLocalLocation();
        if (spawnLocation == null)
        {
            return;
        }
        renderTileOverlay(graphics, spawnLocation, SPAWN_COLOR);
        return;
    }

    private void renderFireBombAOE(Graphics2D graphics, LocalPoint hitLocation) {
        Player player = client.getLocalPlayer();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                calculateAndRenderBombOverlay(graphics, player, hitLocation, dx, dy);
            }
        }
    }

    private void calculateAndRenderBombOverlay(Graphics2D graphics, Player player, LocalPoint lp, int dx, int dy) {

        WorldArea area = player.getWorldArea();
        if (area == null){
            return;
        }

        if (area.canTravelInDirection(client, dx, dy)) {
            if (lp == null){
                return;
            }
            lp = new LocalPoint(
                    lp.getX() + dx * Perspective.LOCAL_TILE_SIZE + dx * Perspective.LOCAL_TILE_SIZE * (area.getWidth() - 1) / 2,
                    lp.getY() + dy * Perspective.LOCAL_TILE_SIZE + dy * Perspective.LOCAL_TILE_SIZE * (area.getHeight() - 1) / 2);
        }
        renderTileOverlay(graphics, lp, BOMB_AOE_COLOR);
    }

    private void renderTileOverlay(Graphics2D graphics, LocalPoint lp, Color color){
        Polygon poly = Perspective.getCanvasTilePoly(client, lp);
        if (poly == null)
        {
            return;
        }
        OverlayUtil.renderPolygon(graphics, poly, color);
    }

}


