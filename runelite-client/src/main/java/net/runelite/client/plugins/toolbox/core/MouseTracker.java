package net.runelite.client.plugins.toolbox.core;

import lombok.Getter;
import net.runelite.api.Point;
import net.runelite.client.input.MouseAdapter;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class MouseTracker extends MouseAdapter {

    @Getter
    private Point lastMousePosition = null;
    @Getter
    private Point lastLeftClickPosition = null;

    private final List<PointTimestamp> movementHistory = Collections.synchronizedList(new ArrayList<>());

    @Inject
    private MouseTracker() {}

    @Override
    public MouseEvent mouseClicked(MouseEvent mouseEvent)
    {
        return mouseEvent;
    }

    @Override
    public MouseEvent mousePressed(MouseEvent mouseEvent)
    {
        return mouseEvent;
    }

    @Override
    public MouseEvent mouseReleased(MouseEvent mouseEvent)
    {
        return mouseEvent;
    }

    @Override
    public MouseEvent mouseEntered(MouseEvent mouseEvent)
    {
        return mouseEvent;
    }

    @Override
    public MouseEvent mouseExited(MouseEvent mouseEvent)
    {

        return mouseEvent;
    }

    @Override
    public MouseEvent mouseDragged(MouseEvent mouseEvent)
    {
        return mouseEvent;
    }

    @Override
    public MouseEvent mouseMoved(MouseEvent mouseEvent)
    {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        lastMousePosition = new Point(x,y);
        addMovement(x, y);
        return mouseEvent;
    }

    public List<PointTimestamp> getMovementHistory(int expiry) {
        synchronized (movementHistory) {
            Instant now = Instant.now();
            movementHistory.removeIf(
                    p -> Duration.between(now, p.getTimestamp()).getSeconds() > expiry);
            return new ArrayList<>(movementHistory);
        }
    }

    public void addMovement(int x, int y) {
        synchronized (movementHistory) {
            movementHistory.add(new PointTimestamp(x, y));

        }
    }
}
