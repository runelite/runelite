package net.runelite.client.plugins.randall.device;


import net.runelite.client.plugins.randall.Utils;
import net.runelite.client.plugins.randall.event.EventHandler;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Mouse extends BaseDevice {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private final boolean[] mouseClicked = new boolean[3];
    private boolean mouseEntered = false;

    public Mouse(Canvas canvas) {
        super(canvas);
    }

    public static void setMousePos(int x, int y) {
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void reset() {
        super.reset();
        Point position = getMousePos();
        releaseMouse(position.x, position.y, 1);
        releaseMouse(position.x, position.y, 2);
        releaseMouse(position.x, position.y, 3);
    }

    public Point getMousePos() {
        return new Point(mouseX, mouseY);
    }

    private int getButtonMask() {
        return (mouseClicked[0] ? MouseEvent.BUTTON1_DOWN_MASK : 0) | (mouseClicked[2] ? (MouseEvent.BUTTON3_DOWN_MASK | MouseEvent.META_DOWN_MASK) : 0);
    }

    private synchronized Point moveMouseImpl(int x, int y) {
        int btnMask = getButtonMask();

        if (isDragging()) {
            EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), btnMask, x, y, 0, false, 0));

        } else if (x > 0 && x < this.canvas.getWidth() && y > 0 && y < this.canvas.getHeight()) {
            if (mouseEntered) {
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), btnMask, x, y, 0, false, 0));

            } else {
                mouseEntered = true;
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_ENTERED, System.currentTimeMillis(), btnMask, x, y, 0, false, 0));
            }

        } else {
            if (mouseEntered) {
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_EXITED, System.currentTimeMillis(), btnMask, x, y, 0, false, 0));
                mouseEntered = false;
            }

        }

        mouseX = x;
        mouseY = y;
        return new Point(mouseX, mouseY);
    }

    private synchronized Point windMouseImpl(double xs, double ys, double xe, double ye, double gravity, double wind, double minWait, double maxWait, double maxStep, double targetArea) {
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
            if (mouseX != mx || mouseY != my) {
                moveMouseImpl(mx, my);
            }
            double step = Math.hypot(xs - mouseX, ys - mouseY);
            Utils.sleep((int) Math.round((maxWait - minWait) * (step / maxStep) + minWait));
        }
        return new Point(mouseX, mouseY);
    }

    public synchronized Point windMouse(int x, int y) {
        double speed = (Math.random() * 15D + 15D) / 10D;
        return windMouseImpl(mouseX, mouseY, x, y, 9D, 3D, 10D / speed, 20D / speed, 10D * speed, 8D * speed);
    }

    public synchronized Point moveMouse(int x, int y) {
        return moveMouseImpl(x, y);
    }

    public synchronized Point holdMouse(int x, int y, int button) {
        if (canHold(button)) {
            int btnMask = getButtonMask();
            int btn = 0;
            switch (button) {
                case 1:
                    btn = MouseEvent.BUTTON1;
                    break;
                case 2:
                    btn = MouseEvent.BUTTON2;
                    break;
                case 3:
                    btn = MouseEvent.BUTTON3;
                    break;
            }

            Point end = moveMouse(x, y);

            if (mouseEntered) {
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), btnMask, mouseX, mouseY, 1, false, btn));

                if (!isFocused()) {
                    wait(25, 50);
                    getFocus();
                }

                switch (button) {
                    case 1:
                        mouseClicked[0] = true;
                        break;
                    case 2:
                        mouseClicked[1] = true;
                        break;
                    case 3:
                        mouseClicked[2] = true;
                        break;
                }
            }
            return end;
        }
        return null;
    }

    public synchronized Point releaseMouse(int x, int y, int button) {
        if (canRelease(button)) {
            int btnMask = getButtonMask();
            int btn = 0;
            switch (button) {
                case 1:
                    btn = MouseEvent.BUTTON1;
                    break;
                case 2:
                    btn = MouseEvent.BUTTON2;
                    break;
                case 3:
                    btn = MouseEvent.BUTTON3;
                    break;
            }

            Point end = moveMouse(x, y);

            if (mouseEntered) {
                long time = System.currentTimeMillis();
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_RELEASED, time, btnMask, end.x, end.y, 1, false, btn));
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_CLICKED, time, btnMask, end.x, end.y, 1, false, btn));

                switch (button) {
                    case 1:
                        mouseClicked[0] = false;
                        break;
                    case 2:
                        mouseClicked[1] = false;
                        break;
                    case 3:
                        mouseClicked[2] = false;
                        break;
                }

            } else {
                looseFocus();
            }
            return end;
        }
        return null;
    }

    public synchronized Point clickMouse(int x, int y, int button) {
        if (canClick(button)) {
            int btnMask = getButtonMask();
            int btn = 0;
            switch (button) {
                case 1:
                    btn = MouseEvent.BUTTON1;
                    break;
                case 2:
                    btn = MouseEvent.BUTTON2;
                    break;
                case 3:
                    btn = MouseEvent.BUTTON3;
                    break;
            }

            Point end = moveMouse(x, y);

            if (mouseEntered) {
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), btnMask, mouseX, mouseY, 1, false, btn));
                switch (button) {
                    case 1:
                        mouseClicked[0] = true;
                        break;
                    case 2:
                        mouseClicked[1] = true;
                        break;
                    case 3:
                        mouseClicked[2] = true;
                        break;
                }

                if (!isFocused()) {
                    wait(25, 50);
                    getFocus();
                }

                wait((int) (Math.random() * 56 + 90));

                long time = System.currentTimeMillis();
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_RELEASED, time, btnMask, end.x, end.y, 1, false, btn));
                EventHandler.PostEvent(new MouseEvent(this.canvas, MouseEvent.MOUSE_CLICKED, time, btnMask, end.x, end.y, 1, false, btn));

                switch (button) {
                    case 1:
                        mouseClicked[0] = false;
                        break;
                    case 2:
                        mouseClicked[1] = false;
                        break;
                    case 3:
                        mouseClicked[2] = false;
                        break;
                }

            } else {
                looseFocus();
            }
            return end;
        }
        return null;
    }

    public synchronized boolean isMouseButtonHeld(int button) {
        switch (button) {
            case 1:
                return mouseClicked[0];
            case 2:
                return mouseClicked[1];
            case 3:
                return mouseClicked[2];
            default:
                return false;
        }
    }

    public synchronized boolean isDragging() {
        return mouseClicked[0] || mouseClicked[1] || mouseClicked[2];
    }

    public synchronized boolean isDown(int button) {
        switch (button) {
            case 1:
                return mouseClicked[0];
            case 2:
                return mouseClicked[1];
            case 3:
                return mouseClicked[2];
            default:
                return false;
        }
    }

    public synchronized boolean canClick(int button) {
        switch (button) {
            case 1:
                return !mouseClicked[0];
            case 2:
                return !mouseClicked[1];
            case 3:
                return !mouseClicked[2];
            default:
                return false;
        }
    }

    public synchronized boolean canHold(int button) {
        switch (button) {
            case 1:
                return !mouseClicked[0];
            case 2:
                return !mouseClicked[1];
            case 3:
                return !mouseClicked[2];
            default:
                return false;
        }
    }

    public synchronized boolean canRelease(int button) {
        switch (button) {
            case 1:
                return mouseClicked[0];
            case 2:
                return mouseClicked[1];
            case 3:
                return mouseClicked[2];
            default:
                return false;
        }
    }
}
