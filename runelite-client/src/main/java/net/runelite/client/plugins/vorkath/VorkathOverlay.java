package net.runelite.client.plugins.vorkath;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VorkathOverlay extends Overlay {

    private final Client client;
    private final VorkathPlugin plugin;
    private final PanelComponent panelComponent = new PanelComponent();

    private LocalPoint fireballProjectileLocation;
    private LocalPoint spiderProjectileLocation;

    private boolean fireballProjectileEnded = true;
    private boolean spiderProjectileEnded = true;

    @Inject
    public VorkathOverlay(Client client, VorkathPlugin plugin) {
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.client = client;
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!plugin.isAtVorkath()) {
            panelComponent.getChildren().clear();
            return null;
        }

        renderProjectiles(graphics);

        panelComponent.getChildren().clear();

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Attacks left: ")
                .color(Color.GREEN)
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(Integer.toString(6 - plugin.getAttacksInARow()))
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Next phase: ")
                .color(Color.GREEN)
                .build());

        panelComponent.getChildren().add(TitleComponent.builder()
                .text(getNextPhaseText())
                .build());

        return panelComponent.render(graphics);
    }

    private String getNextPhaseText() {
        String nextPhase;
        switch (plugin.getNextPhase()) {
            case -1:
                nextPhase = "Unknown";
                break;

            case 1:
                nextPhase = "Poison Pool";
                break;

            case 2:
                nextPhase = "Zombified Spawn";
                break;

            default:
                nextPhase = "Unknown";
                break;
        }

        return nextPhase;
    }

    private void renderProjectiles(Graphics2D graphics) {
        Projectile projectile = plugin.getCurrentProjectile();
        LocalPoint projectileLocation = plugin.getCurrentProjectileLocation();

        if (projectile == null)
            return;

        if (projectile.getId() == ProjectileID.VORKATH_BOMB_AOE) {
            renderFireBall(graphics);
        } else if (projectile.getId() == ProjectileID.VORKATH_SPAWN_AOE) {
            renderSpider(graphics);
        } else {

        }
    }

    private void renderFireBall(Graphics2D graphics) {
        /*if (fireballProjectileEnded) {
            System.out.println(projectile.getX1());
            System.out.println(((int) (projectile.getVelocityX() * 120)));
            System.out.println(((int) (projectile.getScalar() * projectile.getVelocityX())));
            System.out.println(projectile.getY1());
            System.out.println(((int) (projectile.getVelocityY() * 120)) - 135);
            fireballProjectileLocation = new LocalPoint(projectile.getX1() + ((int) (projectile.getVelocityX() * 120)) - ((int) (projectile.getScalar() * projectile.getVelocityX()))
                    , projectile.getY1() + ((int) (projectile.getVelocityY() * 120)) - 135);
            fireballProjectileEnded = false;
        }

        System.out.println("Projectile start X: " + projectile.getX1());
        System.out.println("Projectile start Y: " + projectile.getY1());
        System.out.println("Projectile velocity X: " + projectile.getVelocityX());
        System.out.println("Projectile velocity Y: " + projectile.getVelocityY());
        System.out.println("Projectile expected X: " + fireballProjectileLocation.getX());
        System.out.println("Projectile expected Y: " + fireballProjectileLocation.getY());
        System.out.println("Player X: " + client.getLocalPlayer().getLocalLocation().getX());
        System.out.println("Player Y: " + client.getLocalPlayer().getLocalLocation().getY());
        System.out.println(projectile.getScalar());
        System.out.println();*/

        fireballProjectileLocation = plugin.getCurrentProjectileLocation();

        Polygon poly = Perspective.getCanvasTilePoly(client, fireballProjectileLocation);

        if (poly != null)
            OverlayUtil.renderPolygon(graphics, poly, Color.red);
    }

    // y trop grand
    private void renderSpider(Graphics2D graphics) {
        /*if (spiderProjectileEnded) {
            System.out.println(projectile.getX1());
            System.out.println(((int) (projectile.getVelocityX() * 120)));
            System.out.println(((int) (projectile.getScalar() * projectile.getVelocityX())));
            System.out.println(projectile.getY1());
            System.out.println(((int) (projectile.getVelocityY() * 120)) - 135);

            spiderProjectileLocation = new LocalPoint(projectile.getX1() + ((int) (projectile.getVelocityX() * 120)) - ((int) (projectile.getScalar() * projectile.getVelocityX()))
                    , projectile.getY1() + ((int) (projectile.getVelocityY() * 120)) - ((int) (projectile.getScalar() * projectile.getVelocityY())));
            spiderProjectileEnded = false;
        }

        System.out.println("Projectile start X: " + projectile.getX1());
        System.out.println("Projectile start Y: " + projectile.getY1());
        System.out.println("Projectile velocity X: " + projectile.getVelocityX());
        System.out.println("Projectile velocity Y: " + projectile.getVelocityY());
        System.out.println("Projectile expected X: " + spiderProjectileLocation.getX());
        System.out.println("Projectile expected Y: " + spiderProjectileLocation.getY());
        System.out.println("Projectile cycles: " + projectile.getRemainingCycles());
        System.out.println(projectile.getScalar());
        System.out.println();*/

        spiderProjectileLocation = plugin.getCurrentProjectileLocation();
        Polygon poly = Perspective.getCanvasTilePoly(client, spiderProjectileLocation);

        if (poly != null)
            OverlayUtil.renderPolygon(graphics, poly, Color.red);
    }
}

