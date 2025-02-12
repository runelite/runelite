package net.runelite.client.plugins.toolbox.leveling.woodcutting;

import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.input.MouseManager;
import net.runelite.client.plugins.toolbox.core.MouseTracker;
import net.runelite.client.plugins.toolbox.core.PointTimestamp;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.List;

@Slf4j
public class MouseOverlay extends Overlay {

    private final Client client;
    private final MouseTracker mouseTracker;
    private final AlderRisePlugin plugin;
    private final ModelOutlineRenderer modelOutlineRenderer;
    private final RippleEffect rippleEffect = new RippleEffect();

    @Getter(AccessLevel.PACKAGE)
    private final List<ColorTileObject> objects = new ArrayList<>();
    private final Map<Integer, Set<ObjectPoint>> points = new HashMap<>();

    @Inject
    public MouseOverlay(Client client, MouseTracker mouseTracker, ModelOutlineRenderer modelOutlineRenderer, AlderRisePlugin plugin) {
        this.client = client;
        this.mouseTracker = mouseTracker;
        this.modelOutlineRenderer = modelOutlineRenderer;
        this.plugin = plugin;
        //setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPosition(OverlayPosition.TOOLTIP);
    }

    // Called when a mouse click happens
    public void onMouseClick(MouseEvent mouseEvent) {
        // Add a new ripple effect when the mouse is clicked
        rippleEffect.addRipple(mouseEvent.getPoint());
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        //graphics.setColor(Color.WHITE);
        //graphics.fillRect(0, 0, client.getCanvas().getWidth(), client.getCanvas().getHeight());

        try{

            List<PointTimestamp> movementHistory = mouseTracker.getMovementHistory(2);

            Instant now = Instant.now();

            if (movementHistory != null && !movementHistory.isEmpty()){
                // Render movement trail
                for (PointTimestamp pointTimestamp : movementHistory) {
                    double ageSeconds = Duration.between(pointTimestamp.getTimestamp(), now).toMillis() / 2000.0;
                    float alpha = (float) (1 - ageSeconds); // Fade effect
                    alpha = Math.max(0, Math.min(alpha, 1)); // Keep within 0-1 range

                    Color trailColor = new Color(255, 255, 0, (int) (alpha * 255));
                    drawCircle(graphics, pointTimestamp.getPoint(), 5, trailColor);
                }
            }
        }
        catch (Exception ex){
            log.error("Render Fail1", ex);
        }


        try{
            // Render last known mouse position
            Point lastMousePos = mouseTracker.getLastMousePosition();
            if (lastMousePos != null){
                drawCircle(graphics, lastMousePos, 7, Color.GREEN);

                // Set the font and color for the text
                graphics.setFont(new Font("Arial", Font.BOLD, 14));
                graphics.setColor(Color.BLACK);
                int boxWidth = 150;
                int boxHeight = 30;
                int x = 10;  // Position text box to the right of the mouse cursor
                int y = 10;  // Position text box slightly below the mouse cursor
                graphics.fillRect(x, y, boxWidth, boxHeight);

                String text = "Mouse: (" + lastMousePos.getX() + ", " + lastMousePos.getY() + ")";
                graphics.setColor(Color.WHITE);  // White text color
                graphics.drawString(text, x + 5, y + 20);
            }
        }
        catch (Exception ex){
            log.error("Render Fail2", ex);
        }


        try{
            // Render last left-click position
            Point lastClickPos = mouseTracker.getLastLeftClickPosition();
            if (lastClickPos != null) {
                drawCircle(graphics, lastClickPos, 10, Color.RED);
            }
        }
        catch (Exception ex){
            log.error("Render Fail1", ex);
        }


        renderTreeOutline(graphics, plugin.getCurrentTree() );

        rippleEffect.update(graphics);

        return null;
    }

    private void drawCircle(Graphics2D graphics, Point point, int radius, Color color) {
        graphics.setColor(color);
        graphics.fillOval(point.getX() - radius / 2, point.getY() - radius / 2, radius, radius);
    }

    public void renderTreeOutline(Graphics2D graphics, GameObject gameObject){
        if (gameObject == null) return;

        TileObject tileObject = (TileObject) gameObject;  // Cast to TileObject
        Model model = extractModel(((GameObject) tileObject).getRenderable());

        if (model != null) {
            // Render an outline for the model of the tree object
            modelOutlineRenderer.drawOutline(gameObject, 2, Color.ORANGE, 4);
        }
        else{
            log.info("Model is null in renderTreeOutline");
        }

    }

    private Model extractModel(Renderable renderable) {
        if (renderable == null) {
            return null;
        }
        return renderable instanceof Model ? (Model) renderable : renderable.getModel();
    }
}

