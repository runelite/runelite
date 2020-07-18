/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.gauntlet;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.Tile;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GauntletOverlay extends Overlay {

    private final Client client;
    private final GauntletPlugin plugin;
    private final GauntletConfig config;

    private static final int MAX_DISTANCE = 2350;

    @Inject
    private GauntletOverlay(Client client, GauntletPlugin plugin, GauntletConfig config) {
        this.client = client;
        this.plugin = plugin;
        this.config = config;

        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        // Save resources. There's nothing to render if the user is not in a raid.
        if (!GauntletUtils.inRaid(client))
            return null;

        if (GauntletUtils.inBoss(client)) { // This section handles the visuals when the player is in the boss room.
            BufferedImage attackIconStatic = null;
            switch (plugin.currentPhase) {
                case MAGIC:
                    attackIconStatic = plugin.imageAttackMage;
                    break;
                case RANGE:
                    attackIconStatic = plugin.imageAttackRange;
                    break;
                default:
                    break;
            }
            if (attackIconStatic != null) {
                graphics.drawImage(attackIconStatic, 350, 420, null);
            }

            // This section handles the projectile overlays.
            for (Projectile projectile : this.client.getProjectiles()) {
                int id = projectile.getId();

                BufferedImage icon = null;
                Color color = null;

                if (GauntletUtils.arrayContainsInteger(GauntletUtils.PROJECTILE_MAGIC, id) && config.uniqueAttackVisual()) {
                    icon = plugin.imageAttackMage;
                    color = Color.CYAN;
                } else if (GauntletUtils.arrayContainsInteger(GauntletUtils.PROJECTILE_RANGE, id) && config.uniqueAttackVisual()) {
                    icon = plugin.imageAttackRange;
                    color = Color.GREEN;
                } else if (GauntletUtils.arrayContainsInteger(GauntletUtils.PROJECTILE_PRAYER, id) && config.uniquePrayerVisual()) {
                    icon = plugin.imageAttackPrayer;
                    color = Color.MAGENTA;
                }

                if (icon == null)
                    continue;

                Polygon polygon = GauntletUtils.boundProjectile(client, projectile);
                if (polygon == null) {
                    int x = (int) projectile.getX();
                    int y = (int) projectile.getY();

                    LocalPoint point = new LocalPoint(x, y);
                    Point loc = Perspective.getCanvasImageLocation(client, point, icon, -(int) projectile.getZ());

                    if (loc == null)
                        continue;

                    graphics.drawImage(icon, loc.getX(), loc.getY(), null);
                } else {
                    graphics.setColor(color);
                    graphics.draw(polygon);
                    graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 50));
                    graphics.fill(polygon);

                    Rectangle bounds = polygon.getBounds();
                    int x = (int) bounds.getCenterX() - (icon.getWidth() / 2);
                    int y = (int) bounds.getCenterY() - (icon.getHeight() / 2);
                    graphics.drawImage(icon, x, y, null);
                }
            }

            for (NPC npc : this.client.getNpcs()) {
                // Draws graphics on tornadoes.
                if (config.overlayTornadoes() && plugin.tornadoesActive && GauntletUtils.isTornado(npc)) {
                    String textOverlay = Integer.toString(plugin.tornadoTicks);

                    Point textLoc = Perspective.getCanvasTextLocation(client, graphics, npc.getLocalLocation(), textOverlay, 0);

                    if (textLoc == null)
                        continue;

                    Font oldFont = graphics.getFont();

                    graphics.setFont(new Font("Arial", Font.BOLD, 20));
                    Point pointShadow = new Point(textLoc.getX() + 1, textLoc.getY() + 1);

                    OverlayUtil.renderTextLocation(graphics, pointShadow, textOverlay, Color.BLACK);
                    OverlayUtil.renderTextLocation(graphics, textLoc, textOverlay, Color.YELLOW);

                    graphics.setFont(oldFont);
                }

                // Draws the graphics on the boss.
                if (GauntletUtils.isBoss(npc)) {

                    final LocalPoint point = npc.getLocalLocation();

                    // Overlay the boss with a color on it's convex hull.
                    if (config.overlayBoss()) {
                        Shape polygon = npc.getConvexHull();

                        if (polygon != null) {
                            Color color;
                            switch (plugin.currentPhase) {
                                case MAGIC:
                                    color = Color.CYAN;
                                    break;
                                case RANGE:
                                    color = Color.GREEN;
                                    break;
                                default:
                                    color = Color.WHITE;
                                    break;
                            }

                            graphics.draw(polygon);
                            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 50));
                            graphics.fill(polygon);
                        }
                    }

                    // Overlay of the boss with an icon denoting it's current attack style.
                    if (config.overlayBossPrayer()) {
                        BufferedImage attackIcon = null;

                        switch (plugin.currentPhase) {
                            case MAGIC:
                                attackIcon = plugin.imageAttackMage;
                                break;
                            case RANGE:
                                attackIcon = plugin.imageAttackRange;
                                break;
                            default:
                                break;
                        }

                        if (attackIcon != null) {
                            Point imageLoc = Perspective.getCanvasImageLocation(client, point, attackIcon, npc.getLogicalHeight() / 2);

                            if (imageLoc == null){
                                continue;
                            }
                            graphics.drawImage(attackIcon, imageLoc.getX(), imageLoc.getY(), null);
                        }
                    }

                    // This section handles any text overlays.
                    String textOverlay = "";

                    // Handles the counter for the boss.
                    if (config.countBossAttacks()) {
                        textOverlay = Integer.toString(plugin.bossCounter);
                    }

                    // Handles the counter for the player.
                    if (config.countPlayerAttacks()) {
                        if (textOverlay.length() > 0)
                            textOverlay += " | ";
                        textOverlay += Integer.toString(plugin.playerCounter);
                    }

                    // Handles drawing the text onto the boss.
                    if (textOverlay.length() > 0) {
                        Point textLoc = Perspective.getCanvasTextLocation(client, graphics, point, textOverlay, npc.getLogicalHeight() / 2);

                        if (textLoc == null)
                            continue;

                        textLoc = new Point(textLoc.getX(), textLoc.getY() + 35);

                        Font oldFont = graphics.getFont();

                        graphics.setFont(new Font("Arial", Font.BOLD, 20));
                        Point pointShadow = new Point(textLoc.getX() + 1, textLoc.getY() + 1);

                        OverlayUtil.renderTextLocation(graphics, pointShadow, textOverlay, Color.BLACK);
                        OverlayUtil.renderTextLocation(graphics, textLoc, textOverlay, Color.CYAN);

                        graphics.setFont(oldFont);
                    }
                }
            }
        } else {
            // This section overlays all resources.
            LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();

            for (GameObject object : plugin.resources.keySet()) {
                Tile tile = plugin.resources.get(object);
                if (tile.getPlane() == client.getPlane()
                        && object.getLocalLocation().distanceTo(playerLocation) < MAX_DISTANCE) {

                    // Don't use Convex Hull click box. As the room start to fill up, your FPS will dip.
                    Polygon polygon = object.getCanvasTilePoly();

                    if (polygon != null) {
                        // This section will highlight the resource with color.
                        if (config.highlightResourcesColor()) {
                            Color color = SystemColor.YELLOW;

                            graphics.setColor(color);
                            graphics.draw(polygon);
                            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 50));
                            graphics.fill(polygon);
                        }

                        // This section will overlay the resource with an icon.
                        if (config.highlightResourcesIcons()) {
                            int id = object.getId();
                            BufferedImage icon = null;

                            if (GauntletUtils.arrayContainsInteger(GauntletUtils.CRYSTAL_DEPOSIT, id)) {
                                icon = plugin.imageCrystalDeposit;
                            } else if (GauntletUtils.arrayContainsInteger(GauntletUtils.PHREN_ROOTS, id)) {
                                icon = plugin.imagePhrenRoots;
                            } else if (GauntletUtils.arrayContainsInteger(GauntletUtils.FISHING_SPOTS, id)) {
                                icon = plugin.imageFishingSpot;
                            } else if (GauntletUtils.arrayContainsInteger(GauntletUtils.GRYM_ROOTS, id)) {
                                icon = plugin.imageGrymRoot;
                            } else if (GauntletUtils.arrayContainsInteger(GauntletUtils.LINUM_TIRINUM, id)) {
                                icon = plugin.imageLinumTirinum;
                            }

                            if (icon != null) {
                                Rectangle bounds = polygon.getBounds();
                                int startX = (int) bounds.getCenterX() - (icon.getWidth() / 2);
                                int startY = (int) bounds.getCenterY() - (icon.getHeight() / 2);
                                graphics.drawImage(icon, startX, startY, null);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
}
