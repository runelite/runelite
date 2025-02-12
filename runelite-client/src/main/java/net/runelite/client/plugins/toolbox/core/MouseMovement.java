package net.runelite.client.plugins.toolbox.core;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.MouseManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Singleton
public class MouseMovement {

    private final Client client;
    private final ClientThread clientThread;
    private final MouseManager mouseManager;
    private final Random random = new Random();

    @Inject
    public MouseMovement(Client client, ClientThread clientThread, MouseManager mouseManager){
        this.client = client;
        this.clientThread = clientThread;
        this.mouseManager = mouseManager;
    }

    public List<Point> generateHumanPath(Point start, Point end) {

        java.util.List<Point> path = new ArrayList<>();

        if (start == null || end == null) return null;

        int startX = start.getX();
        int startY = start.getY();

        int endX = end.getX();
        int endY = end.getY();


        int steps = random.nextInt(20) + 30; // Random step count between 30-50

        for (int i = 0; i < steps; i++) {
            double t = i / (double) steps;
            int x = (int) (startX + t * (endX - startX) + random.nextGaussian() * 5);
            int y = (int) (startY + t * (endY - startY) + random.nextGaussian() * 5);
            path.add(new Point(x, y));
        }

        return path;
    }

    public void smm(Point point) {
        MouseEvent mouseEvent = new MouseEvent(
                client.getCanvas(),
                MouseEvent.MOUSE_MOVED,
                System.currentTimeMillis(),
                0,
                point.getX(), point.getY(),
                0, false
        );
        //mouseManager.processMouseEvent(mouseEvent);
        mouseManager.processMouseMoved(mouseEvent);
    }

    public void sme(Point point){
        MouseEvent mouseEnterEvent = new MouseEvent(
                client.getCanvas(),
                MouseEvent.MOUSE_ENTERED,
                System.currentTimeMillis(),
                0,
                point.getX(),
                point.getY(),
                0,
                false);
        mouseManager.processMouseMoved(mouseEnterEvent);
    }

    public void smlc(Point point){
        long timestamp = System.currentTimeMillis();

        // Press event
        MouseEvent pressEvent = new MouseEvent(
                client.getCanvas(),
                MouseEvent.MOUSE_PRESSED,
                timestamp,
                0,
                point.getX(),
                point.getY(),
                1, false,
                MouseEvent.BUTTON1
        );
        mouseManager.processMousePressed(pressEvent);

        // Randomized delay (simulating human reaction time)
        try {
            Thread.sleep((long) (Math.random() * 150 + 50)); // Random delay between 50ms - 200ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Release event
        MouseEvent releaseEvent = new MouseEvent(
                client.getCanvas(),
                MouseEvent.MOUSE_RELEASED,
                timestamp,
                0,
                point.getX(),
                point.getY(),
                1,
                false,
                MouseEvent.BUTTON1
        );
        mouseManager.processMouseReleased(releaseEvent);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void sleepRandom(int min, int max) {
        try {
            Thread.sleep(min + random.nextInt(max - min));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
