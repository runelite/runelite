package net.runelite.client.plugins.dagannothkings.overlay;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.sun.jna.platform.unix.X11;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.client.plugins.dagannothkings.DKConfig;
import net.runelite.client.plugins.dagannothkings.DKPlugin;
import net.runelite.client.plugins.dagannothkings.entity.DagannothKing;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class PrayerOverlay extends Overlay
{
    private static final int TICK_PIXEL_SIZE = 60;
    private static final int BOX_WIDTH = 10;
    private static final int BOX_HEIGHT = 5;

    private final DKPlugin plugin;
    private final DKConfig config;
    private final Client client;

    private Set<DagannothKing> dagannothKings;

    @Inject
    public PrayerOverlay(final DKPlugin plugin, final DKConfig config, final Client client)
    {
        super(plugin);

        this.plugin = plugin;
        this.config = config;
        this.client = client;

        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        determineLayer();
    }

    @Override
    public Dimension render(final Graphics2D graphics2D)
    {
        dagannothKings = plugin.getDagannothKings();

        if (dagannothKings.isEmpty() || (!config.showPrayerWidgetOverlay() && !config.showGuitarHeroOverlay()))
        {
            return null;
        }

        renderPrayer(graphics2D);

        return null;
    }

    public void determineLayer()
    {
        setLayer(config.mirrorMode() ? OverlayLayer.ALWAYS_ON_TOP : OverlayLayer.ABOVE_WIDGETS);
    }

    private void renderPrayer(final Graphics2D graphics2D)
    {
        final Actor player = client.getLocalPlayer();

        final Map<Prayer, Integer> tickMap = new HashMap<>();

        for (final DagannothKing dagannothKing : dagannothKings)
        {
            final NPC npc = dagannothKing.getNpc();

            final int ticksUntilNextAnimation = dagannothKing.getTicksUntilNextAnimation();

            final DagannothKing.AttackStyle attackStyle = dagannothKing.getAttackStyle();

            if (npc == null || npc.isDead() || ticksUntilNextAnimation <= 0
                    || (config.ignoringNonAttacking() && dagannothKing.getInteractingActor() != player))
            {
                continue;
            }

            if (config.showPrayerWidgetOverlay())
            {
                final Rectangle rectangle = renderPrayerOverlay(graphics2D, client, attackStyle.getPrayer(), attackStyle.getColor());

                if (rectangle == null)
                {
                    continue;
                }

                final String text = String.valueOf(ticksUntilNextAnimation);

                final int fontSize = 16;
                final int fontStyle = Font.BOLD;
                final Color fontColor = ticksUntilNextAnimation == 1 ? Color.WHITE : attackStyle.getColor();

                final int x = (int) (rectangle.getX() + rectangle.getWidth() / 2);
                final int y = (int) (rectangle.getY() + rectangle.getHeight() / 2);

                final Point prayerWidgetPoint = new Point(x, y);

                final Point canvasPoint = new Point(prayerWidgetPoint.getX() - 3, prayerWidgetPoint.getY() + 6);

                OverlayUtil.renderTextLocation(graphics2D, canvasPoint,text, fontColor);
            }

            if (config.showGuitarHeroOverlay())
            {
                tickMap.put(attackStyle.getPrayer(), ticksUntilNextAnimation);
            }
        }

        if (!tickMap.isEmpty())
        {
            for (final Map.Entry<Prayer, Integer> entry : tickMap.entrySet())
            {
                renderDescendingBoxes(graphics2D, entry.getKey(), entry.getValue());
            }
        }
    }

    private void renderDescendingBoxes(final Graphics2D graphics2D, final Prayer prayer, final int tick)
    {
        final Color color = tick == 1 ? Color.RED : Color.ORANGE;
        final Widget prayerWidget = client.getWidget(WidgetID.PRAYER_GROUP_ID);
        if (prayerWidget == null || prayerWidget.isHidden())
        {
            return;
        }

        int baseX = (int) prayerWidget.getBounds().getX();
        baseX += prayerWidget.getBounds().getWidth() / 2;
        baseX -= BOX_WIDTH / 2;

        int baseY = (int) prayerWidget.getBounds().getY() - tick * TICK_PIXEL_SIZE - BOX_HEIGHT;
        baseY += TICK_PIXEL_SIZE - ((plugin.getLastTickTime() + 600 - System.currentTimeMillis()) / 600.0 * TICK_PIXEL_SIZE);

        final Rectangle boxRectangle = new Rectangle(BOX_WIDTH, BOX_HEIGHT);
        boxRectangle.translate(baseX, baseY);

        renderFilledPolygon(graphics2D, boxRectangle, color);
    }
    public static void renderFilledPolygon(Graphics2D graphics, Shape poly, Color color)
    {
        graphics.setColor(color);
        final Stroke originalStroke = graphics.getStroke();
        graphics.setStroke(new BasicStroke(2));
        graphics.draw(poly);
        graphics.fill(poly);
        graphics.setStroke(originalStroke);
    }
    public static Rectangle renderPrayerOverlay(Graphics2D graphics, Client client, Prayer prayer, Color color)
    {
        Widget widget = client.getWidget(WidgetID.PRAYER_GROUP_ID);
        Rectangle bounds = widget.getBounds();
        OverlayUtil.renderPolygon(graphics, rectangleToPolygon(bounds), color);
        return bounds;
    }
    private static Polygon rectangleToPolygon(Rectangle rect)
    {
        int[] xpoints = {rect.x, rect.x + rect.width, rect.x + rect.width, rect.x};
        int[] ypoints = {rect.y, rect.y, rect.y + rect.height, rect.y + rect.height};

        return new Polygon(xpoints, ypoints, 4);
    }
}