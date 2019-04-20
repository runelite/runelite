package net.runelite.client.plugins.freezetimers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.HeadIcon;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class FreezeTimersOverlay
        extends Overlay {
    private final FreezeTimersService FreezeTimersService;
    private final FreezeTimersConfig config;
    private final FreezeTimersPlugin plugin;
    private final SpriteManager spriteManager;
    private final Client client;

    @Inject
    private FreezeTimersOverlay(FreezeTimersConfig config, FreezeTimersService FreezeTimersService2, FreezeTimersPlugin plugin, Client client, SpriteManager spriteManager) {
        this.config = config;
        this.FreezeTimersService = FreezeTimersService2;
        this.plugin = plugin;
        this.client = client;
        this.spriteManager = spriteManager;
        this.setPosition(OverlayPosition.DYNAMIC);
        this.setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (!this.config.EnableFreezeTimers()) {
            return null;
        }
        this.FreezeTimersService.forEachPlayer((player, color) -> this.renderPlayerOverlay(graphics, (Player)player, (Color)color));
        return null;
    }

    private void renderPlayerOverlay(Graphics2D graphics, Player actor, Color color) {
        BufferedImage clanchatImage;
        int timer = 0;
        String name = actor.getName();
        int freezetype = this.plugin.freezetype(name);
        boolean frozenoverlay = false;
        int offset = 5;
        long dtime = this.plugin.opponentfreezetime(name);
        long tbed = plugin.istbed(name);
        Point textLocation = null;
        HeadIcon headIcon = actor.getOverheadIcon();
        int freezetime = 0;
        if (freezetype == 1 || freezetype == 4) {
            freezetime = 5000;
        } else if (freezetype == 2 || freezetype == 5) {
            freezetime = 10000;
        } else if (freezetype == 3 || freezetype == 6) {
            freezetime = 15000;
        } else if (freezetype == 7) {
            freezetime = 20000;
        } else if (freezetype == 8) {
            freezetime = 2500;
        } else if (freezetype == 9) {
            freezetime = 5000;
        } else if (freezetype == 10) {
            freezetime = 7500;
        }
        long currenttime = System.currentTimeMillis();
        long timediff = currenttime - dtime;
        timer = (freezetime - (int)timediff) / 1000;
        if (timediff < (long)freezetime) {
            textLocation = actor.getCanvasTextLocation(graphics, String.valueOf(timer), actor.getLogicalHeight() + config.FreezeTimerPos());
            textLocation = new Point(textLocation.getX(), textLocation.getY() - config.FreezeTimerPos());
        } else if (timediff < (long)(freezetime + 3000)) {
            timer = Math.abs(timer);
            ++timer;
            if (this.config.refreezeTimer()) {
                textLocation = actor.getCanvasTextLocation(graphics, String.valueOf(timer), actor.getLogicalHeight() + config.FreezeTimerPos());
                textLocation = new Point(textLocation.getX(), textLocation.getY() - config.FreezeTimerPos());
                graphics.setFont(FontManager.getRunescapeBoldFont());
                if (headIcon != null) {
                    textLocation = new Point(textLocation.getX(), textLocation.getY() - config.FreezeTimerPos());
                }
                frozenoverlay = true;
                OverlayUtil.renderTextLocation(graphics, textLocation, String.valueOf(timer), this.config.RefreezeTimerColor());
                return;
            }
        } else {
            this.plugin.deleteopponent(name);
        }
        if (textLocation != null && (clanchatImage = this.plugin.GetFreezeIcon(freezetype - 1)) != null) {
            int width = clanchatImage.getWidth();
            int textHeight = graphics.getFontMetrics().getHeight() - graphics.getFontMetrics().getMaxDescent();
            Point imageLocation = new Point(textLocation.getX(), textLocation.getY() - (config.FreezeTimerPos() / 2));
            graphics.setFont(FontManager.getRunescapeFont());
            graphics.setStroke(new BasicStroke(3.0f));
            if (this.config.spellIcon()) {
                frozenoverlay = true;
                graphics.drawOval(imageLocation.getX(), imageLocation.getY(), clanchatImage.getWidth(), clanchatImage.getHeight());
                OverlayUtil.renderImageLocation(graphics, imageLocation, clanchatImage);
                OverlayUtil.renderTextLocation(graphics, textLocation, String.valueOf(timer), color);
            } else {
                graphics.setColor(Color.cyan);
                graphics.drawOval(textLocation.getX() - 3, textLocation.getY() - 15, clanchatImage.getWidth(), graphics.getFontMetrics().getHeight());
                graphics.setColor(Color.blue);
                graphics.fillOval(textLocation.getX() - 3, textLocation.getY() - 15, clanchatImage.getWidth(), graphics.getFontMetrics().getHeight());
                OverlayUtil.renderTextLocation(graphics, textLocation, String.valueOf(timer), Color.WHITE);
            }
        }

        if (config.TBTimer()) {
            if (tbed > 0) {
                int type = plugin.tbtype(name);
                int tbexpiry;
                if (type > 0) {
                    if (type == 1) {
                        tbexpiry = 300000;
                    } else if (type == 2) {
                        tbexpiry = 150000;
                    } else {
                        return;
                    }
                    long tbtime = currenttime - tbed;
                    int tbtimer = (tbexpiry - (int) tbtime) / 1000;
                    if (tbtime < tbexpiry) {
                        textLocation = actor.getCanvasTextLocation(graphics, Integer.toString(tbtimer), actor.getLogicalHeight() + config.FreezeTimerPos());
                        if (frozenoverlay) {
                            textLocation = new Point(textLocation.getX() + 40, textLocation.getY() - config.FreezeTimerPos());
                        } else {
                            textLocation = new Point(textLocation.getX(), textLocation.getY() - config.FreezeTimerPos());
                        }
                    } else {
                        plugin.deletetb(name);
                    }
                }

            }
        }
    }
}

