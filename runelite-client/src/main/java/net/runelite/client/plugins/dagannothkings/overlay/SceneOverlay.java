package net.runelite.client.plugins.dagannothkings.overlay;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.dagannothkings.DKConfig;
import net.runelite.client.plugins.dagannothkings.DKPlugin;
import net.runelite.client.plugins.dagannothkings.entity.DagannothKing;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

@Singleton
public class SceneOverlay extends Overlay
{
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0);

    private final DKPlugin plugin;
    private final DKConfig config;
    private final Client client;

    private Set<DagannothKing> dagannothKings;

    @Inject
    public SceneOverlay(final DKPlugin plugin, final DKConfig config, final Client client)
    {
        super(plugin);

        this.plugin = plugin;
        this.config = config;
        this.client = client;

        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.UNDER_WIDGETS);
    }

    @Override
    public Dimension render(final Graphics2D graphics2D)
    {
        dagannothKings = plugin.getDagannothKings();

        if (dagannothKings.isEmpty())
        {
            return null;
        }

        renderNpcTickCount(graphics2D);
        renderNpcTile(graphics2D);

        return null;
    }

    public void determineLayer()
    {
        setLayer(config.mirrorMode() ? OverlayLayer.ALWAYS_ON_TOP : OverlayLayer.UNDER_WIDGETS);
    }

    private void renderNpcTickCount(final Graphics2D graphics2D)
    {
        final Actor player = client.getLocalPlayer();

        if (!config.showNpcTickCounter() || player == null)
        {
            return;
        }

        for (final DagannothKing dagannothKing : dagannothKings)
        {
            final NPC npc = dagannothKing.getNpc();

            final int ticksUntilNextAnimation = dagannothKing.getTicksUntilNextAnimation();

            if (npc == null || npc.isDead() || ticksUntilNextAnimation <= 0 || (config.ignoringNonAttacking()
                    && dagannothKing.getInteractingActor() != player))
            {
                continue;
            }

            final String text = String.valueOf(ticksUntilNextAnimation);

            final Point npcPoint = npc.getCanvasTextLocation(graphics2D, text, 0);

            if (npcPoint == null)
            {
                return;
            }
            OverlayUtil.renderTextLocation(graphics2D,npcPoint, text,
                    ticksUntilNextAnimation == 1 ? Color.WHITE : dagannothKing.getColor());
        }
    }

    private void renderNpcTile(final Graphics2D graphics2D)
    {
        if (!config.showNpcTileOutline())
        {
            return;
        }

        for (final DagannothKing armadylNpc : dagannothKings)
        {
            drawNpcTile(graphics2D, armadylNpc.getNpc(), armadylNpc.getColor());
        }
    }

    private void drawNpcTile(final Graphics2D graphics2D, final NPC npc, final Color color)
    {
        if (npc == null || npc.isDead())
        {
            return;
        }

        int size = 1;
        final NPCComposition npcDefinition = npc.getComposition();

        if (npcDefinition != null)
        {
            size = npcDefinition.getSize();
        }

        final LocalPoint localPoint = npc.getLocalLocation();

        final int x = localPoint.getX() - ((size - 1) * Perspective.LOCAL_TILE_SIZE / 2);
        final int y = localPoint.getY() - ((size - 1) * Perspective.LOCAL_TILE_SIZE / 2);

        final Polygon tile = Perspective.getCanvasTileAreaPoly(client, localPoint, size);

        if (tile == null)
        {
            return;
        }

        final Polygon southWestTile = Perspective.getCanvasTilePoly(client, new LocalPoint(x, y));

        drawOutlineAndFill(graphics2D, color, southWestTile);
        drawOutlineAndFill(graphics2D, color, tile);
    }

    private static void drawOutlineAndFill(final Graphics2D graphics2D, final Color outlineColor, final Shape shape)
    {
        final Color originalColor = graphics2D.getColor();
        final Stroke originalStroke = graphics2D.getStroke();

        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.setColor(outlineColor);
        graphics2D.draw(shape);

        graphics2D.setColor(SceneOverlay.TRANSPARENT);
        graphics2D.fill(shape);

        graphics2D.setColor(originalColor);
        graphics2D.setStroke(originalStroke);
    }
}