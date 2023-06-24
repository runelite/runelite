package net.runelite.client.plugins.randall.event;


import net.runelite.client.plugins.randall.device.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandler extends EventQueue {

    private static final EventHandler instance = new EventHandler();
    private static boolean blocked = true;
    private static Component gameCanvas;
    private static JFrame jFrame;

    private EventHandler() {
    }

    public static void setGameCanvas(Component gameCanvas) {
        EventHandler.gameCanvas = gameCanvas;
    }

    public static void setJFrame(JFrame jFrame) {
        EventHandler.jFrame = jFrame;
    }

    public static boolean isBlocking() {
        return blocked;
    }

    public static void setBlocking(boolean blocking) {
        blocked = blocking;

        if (!(Toolkit.getDefaultToolkit().getSystemEventQueue() instanceof EventHandler)) {
            Toolkit.getDefaultToolkit().getSystemEventQueue().push(instance);
        }
    }

    public static void PostEvent(AWTEvent e) {
        if (e != null && e.getSource() != null) {
            instance.postEvent(new UnblockedEvent(e));
        }
    }

    @Override
    protected void dispatchEvent(AWTEvent event) {
        Object eventSource = event.getSource();

        if (event instanceof UnblockedEvent) {
            AWTEvent e = ((UnblockedEvent) event).event;
            ((Component) e.getSource()).dispatchEvent(e);
        } else if (eventSource == gameCanvas) {
            handleGameCanvas(event);
        } else if (eventSource == jFrame) {
            handleJFrame(event);
        } else {
            super.dispatchEvent(event);
        }
    }

    private void handleGameCanvas(AWTEvent event) {
        if (event instanceof KeyEvent || event instanceof MouseWheelEvent || event instanceof FocusEvent || event instanceof WindowEvent) {
            if (!blocked) {
                super.dispatchEvent(event);
            }
        } else if (event instanceof MouseEvent) {
            if (!blocked) {
                Mouse.setMousePos(((MouseEvent) event).getX(), ((MouseEvent) event).getY());
                super.dispatchEvent(event);
            }
        } else {
            super.dispatchEvent(event);
        }
    }

    private void handleJFrame(AWTEvent event) {
        if (event instanceof KeyEvent) {
            if (!blocked) {
                super.dispatchEvent(event);
            }
        } else {
            super.dispatchEvent(event);
        }
    }
}