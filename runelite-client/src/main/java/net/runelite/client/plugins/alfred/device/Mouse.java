package net.runelite.client.plugins.alfred.device;


import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.api.rs.Utility;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Mouse {

    private final Canvas gameCanvas = Alfred.getClient().getCanvas();
    public List<Point> positions = new ArrayList<>();
    private int mousePositionX;
    private int mousePositionY;

    public Mouse() {
        positions.add(new Point(-1, -1));
        mousePositionX = -1;
        mousePositionY = -1;
    }

    private void internalMove(int x, int y) {
        Point point = new Point(x, y);
        Point lastMousePosition = getLastMousePosition();

        boolean mousePreviouslyInCanvas = isInCanvas(lastMousePosition);
        boolean mouseCurrentlyInCanvas = isInCanvas(point);

//        if (dragging) {
//            MouseEvent mouseDrag = new MouseEvent(gameCanvas, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, x, y, 1, false, MouseEvent.BUTTON1);
//            gameCanvas.dispatchEvent(mouseDrag);

//        } else if (mousePreviouslyInCanvas && mouseCurrentlyInCanvas) {

        if (mousePreviouslyInCanvas && mouseCurrentlyInCanvas) {
            dispatchMouseEvent(MouseEvent.MOUSE_MOVED, point, 0);

        } else if (mousePreviouslyInCanvas && !mouseCurrentlyInCanvas) {
            dispatchMouseEvent(MouseEvent.MOUSE_EXITED, point, 0);

        } else if (!mousePreviouslyInCanvas && mouseCurrentlyInCanvas) {
            dispatchMouseEvent(MouseEvent.MOUSE_ENTERED, point, 0);
        }

        addMousePosition(point);
    }

    private void internalDrag(int x, int y) {
        System.out.println("Mouse dragged to (" + x + ", " + y + ")");
    }

    private void internalClick(int x, int y, int button) {
        Point point = new Point(x, y);
        internalWindMouse(x, y);
        Alfred.sleep(75, 125);

        Point lastMousePosition = getLastMousePosition();

//        boolean mousePreviouslyInCanvas = isInCanvas(lastMousePosition);
//        boolean mouseCurrentlyInCanvas = isInCanvas(point);

        dispatchMouseEvent(MouseEvent.MOUSE_MOVED, point, button);
        Alfred.sleep(75, 175);
        dispatchMouseEvent(MouseEvent.MOUSE_PRESSED, point, button);

//        if (!mousePreviouslyInCanvas && mouseCurrentlyInCanvas) {
//            Alfred.sleep(25, 50);
//            dispatchFocusEvent(FocusEvent.FOCUS_GAINED);
//
//        } else if (mousePreviouslyInCanvas && !mouseCurrentlyInCanvas) {
//            Alfred.sleep(25, 50);
//            dispatchFocusEvent(FocusEvent.FOCUS_LOST);
//        }

        dispatchMouseEvent(MouseEvent.MOUSE_RELEASED, point, button);
        dispatchMouseEvent(MouseEvent.MOUSE_CLICKED, point, button);
        addMousePosition(point);
    }

    public void move(int x, int y) {
        internalWindMouse(x, y);
    }

    public void move(double x, double y) {
        internalWindMouse((int) x, (int) y);
    }

    public void move(Point point) {
        internalWindMouse((int) point.getX(), (int) point.getY());
    }

    public void move(net.runelite.api.Point point) {
        internalWindMouse(point.getX(), point.getY());
    }

    public void move(Rectangle rect) {
        Point randomPoint = Utility.getRandomPointFromBounds(rect);
        internalWindMouse((int) randomPoint.getX(), (int) randomPoint.getY());
    }

    public void move(Polygon polygon) {
        Point randomPoint = Utility.getRandomPointFromBounds(polygon);
        internalWindMouse((int) randomPoint.getX(), (int) randomPoint.getY());
    }

//    public void drag(int x, int y) {
//        internalDrag(x, y);
//    }
//
//    public void drag(double x, double y) {
//        internalDrag((int) x, (int) y);
//    }
//
//    public void drag(Point point) {
//        internalDrag((int) point.getX(), (int) point.getY());
//    }
//
//    public void drag(net.runelite.api.Point point) {
//        internalDrag(point.getX(), point.getY());
//    }
//
//    public void drag(Rectangle rect) {
//        internalDrag((int) rect.getX(), (int) rect.getY());
//    }
//
//    public void drag(Polygon polygon) {
//        internalDrag((int) polygon.getBounds().getX(), (int) polygon.getBounds().getY());
//    }


    public void leftClick(int x, int y) {
        internalClick(x, y, MouseEvent.BUTTON1);
    }

    public void leftClick(double x, double y) {
        internalClick((int) x, (int) y, MouseEvent.BUTTON1);
    }

    public void leftClick(Point point) {
        internalClick((int) point.getX(), (int) point.getY(), MouseEvent.BUTTON1);
    }

    public void leftClick(net.runelite.api.Point point) {
        internalClick(point.getX(), point.getY(), MouseEvent.BUTTON1);
    }

    public void leftClick(Rectangle rect) {
        Point randomPoint = Utility.getRandomPointFromBounds(rect);
        internalClick((int) randomPoint.getX(), (int) randomPoint.getY(), MouseEvent.BUTTON1);
    }

    public void leftClick(Polygon polygon) {
        Point randomPoint = Utility.getRandomPointFromBounds(polygon);
        internalClick((int) randomPoint.getX(), (int) randomPoint.getY(), MouseEvent.BUTTON1);
    }

    public void rightClick(int x, int y) {
        internalClick(x, y, MouseEvent.BUTTON3);
    }

    public void rightClick(double x, double y) {
        internalClick((int) x, (int) y, MouseEvent.BUTTON3);
    }

    public void rightClick(Point point) {
        internalClick((int) point.getX(), (int) point.getY(), MouseEvent.BUTTON3);
    }

    public void rightClick(net.runelite.api.Point point) {
        internalClick(point.getX(), point.getY(), MouseEvent.BUTTON3);
    }

    public void rightClick(Rectangle rect) {
        Point randomPoint = Utility.getRandomPointFromBounds(rect);
        internalClick((int) randomPoint.getX(), (int) randomPoint.getY(), MouseEvent.BUTTON3);
    }

    public void rightClick(Polygon polygon) {
        Point randomPoint = Utility.getRandomPointFromBounds(polygon);
        internalClick((int) randomPoint.getX(), (int) randomPoint.getY(), MouseEvent.BUTTON3);
    }


//    public void scrollUp() {
//        System.out.println("Mouse scrolled up");
//    }
//
//    public void scrollDown() {
//        System.out.println("Mouse scrolled down");
//    }
//

    public Point getLastMousePosition() {
        return positions.get(positions.size() - 1);
    }

    public Point getCurrentMousePosition() {
        return new Point(mousePositionX, mousePositionY);
    }

    private void addMousePosition(Point point) {
        positions.add(point);
        mousePositionX = point.x;
        mousePositionY = point.y;
    }

    private boolean isInCanvas(Point point) {
        return gameCanvas.contains(point);
    }

    private void dispatchMouseEvent(int mouseMovementEvent, Point point, int mouseButton) {
        MouseEvent mouseEvent = new MouseEvent(gameCanvas, mouseMovementEvent, System.currentTimeMillis(), 0, (int) point.getX(), (int) point.getY(), 1, false, mouseButton);
        Alfred.getEventHandler().dispatchUnblockedEvent(mouseEvent);
    }

    private void dispatchFocusEvent(int focusEvent) {
        FocusEvent event = new FocusEvent(gameCanvas, focusEvent, false, null);
        Alfred.getEventHandler().dispatchUnblockedEvent(event);
    }

    private synchronized void internalWindMouse(int x, int y) {
//        double speed = (Math.random() * 15D + 15D) / 10D;
//        double speed = (Math.random() * 20D + 20D) / 10D;
        double speed = (Math.random() * 2D + 0.1D) + 3D;

        Point lastMousePosition = getLastMousePosition();
        double xs = lastMousePosition.getX();
        double ys = lastMousePosition.getY();
        double xe = x;
        double ye = y;
        double gravity = 9D;
        double wind = 3D;
        double minWait = 10D / speed;
        double maxWait = 20D / speed;
        double maxStep = 10D * speed;
        double targetArea = 8D * speed;

        final double sqrt3 = Math.sqrt(3);
        final double sqrt5 = Math.sqrt(5);

        double dist, veloX = 0, veloY = 0, windX = 0, windY = 0;
        while ((dist = Math.hypot(xs - xe, ys - ye)) >= 1) {
            wind = Math.min(wind, dist);
            if (dist >= targetArea) {
                windX = windX / sqrt3 + (Math.random() * (wind * 2D + 1D) - wind) / sqrt5;
                windY = windY / sqrt3 + (Math.random() * (wind * 2D + 1D) - wind) / sqrt5;
            } else {
                windX /= sqrt3;
                windY /= sqrt3;
                if (maxStep < 3) {
                    maxStep = Math.random() * 3 + 3D;
                } else {
                    maxStep /= sqrt5;
                }
            }
            veloX += windX + gravity * (xe - xs) / dist;
            veloY += windY + gravity * (ye - ys) / dist;
            double veloMag = Math.hypot(veloX, veloY);
            if (veloMag > maxStep) {
                double randomDist = maxStep / 2D + Math.random() * maxStep / 2D;
                veloX = (veloX / veloMag) * randomDist;
                veloY = (veloY / veloMag) * randomDist;
            }
            xs += veloX;
            ys += veloY;
            int mx = (int) Math.round(xs);
            int my = (int) Math.round(ys);

            if (xe != mx || ye != my) {
                internalMove(mx, my);
            }
            double step = Math.hypot(xs - xe, ys - ye);

            Alfred.sleep((int) Math.round((maxWait - minWait) * (step / maxStep) + minWait));
        }
    }

}
