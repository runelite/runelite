package net.runelite.client.plugins.vorkath;

import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VorkathOverlay extends Overlay {

    @Inject
    private Client client;

    @Inject
    private VorkathPlugin vorkathPlugin;

    private LocalPoint fireballProjectileLocation;
    private LocalPoint spiderProjectileLocation;

    private static BufferedImage FIREBALLS;


    private boolean fireballProjectileEnded = true;
    private boolean spiderProjectileEnded = true;

    static {
        try {
            FIREBALLS = ImageIO.read(VorkathPlugin.class.getResourceAsStream("fireball.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {

        renderFireball(graphics);
        renderSpider(graphics);

        return null;
    }
// y trop grand
    private void renderFireball(Graphics2D graphics) {
        for (Projectile projectile : client.getProjectiles()) {
            if (projectile.getId() == ProjectileID.VORKATH_BOMB_AOE) {
                if (fireballProjectileEnded) {
                    fireballProjectileLocation = new LocalPoint(projectile.getX1() + ((int) (Math.floor((projectile.getVelocityX() * 120))) - ((int)(Math.floor(Math.ceil(projectile.getScalar()) * Math.ceil(projectile.getVelocityX())))))
                            , projectile.getY1() + ((int)(projectile.getVelocityY()) * 120) - 135);
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
                System.out.println();

                Polygon poly = Perspective.getCanvasTilePoly(client, fireballProjectileLocation);
                OverlayUtil.renderTileOverlay(client, graphics, fireballProjectileLocation, FIREBALLS, Color.RED);

                /*if (poly != null)
                    OverlayUtil.renderPolygon(graphics, poly, Color.red);*/
            } else
                fireballProjectileEnded = true;
        }
    }
    // x trop grand
    private void renderSpider(Graphics2D graphics) {
        for (Projectile projectile : client.getProjectiles()) {
            if (projectile.getId() == ProjectileID.VORKATH_SPAWN_AOE) {
                if (spiderProjectileEnded) {
                    spiderProjectileLocation = new LocalPoint(projectile.getX1() + ((int) (Math.floor((projectile.getVelocityX() * 120))) - ((int)(Math.ceil(Math.ceil(projectile.getScalar()) * Math.ceil(projectile.getVelocityX())))))
                            , projectile.getY1() + ((int) (Math.floor(projectile.getVelocityY() * 120))) - ((int)Math.floor(((Math.floor(projectile.getScalar()) * Math.floor(projectile.getVelocityY()))))));
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
                System.out.println();

                //Polygon poly = Perspective.getCanvasTilePoly(client, projectileLocation);
                OverlayUtil.renderTileOverlay(client, graphics, spiderProjectileLocation, FIREBALLS, Color.RED);

                /*if (poly != null)
                    OverlayUtil.renderPolygon(graphics, poly, Color.red);*/
            } else
                spiderProjectileEnded = true;
        }
    }
}
