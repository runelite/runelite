package net.runelite.client.plugins.alfred.event;

import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.debug.DebugKeyboardEvents;
import net.runelite.client.ui.ClientUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandler extends EventQueue {

    private static boolean blocked;
    private static Canvas gameCanvas;
    private static JFrame gameFrame;

    public EventHandler() {
        blocked = false;
        gameCanvas = Alfred.getClient().getCanvas();
        gameFrame = ClientUI.getFrame();
        DebugKeyboardEvents debugKeyboardEvents = new DebugKeyboardEvents();
        gameFrame.addKeyListener(debugKeyboardEvents);
        gameCanvas.addKeyListener(debugKeyboardEvents);
    }

    public boolean isBlocking() {
        return blocked;
    }

    public void setBlocking(boolean blocking) {
        blocked = blocking;

        if (!(Toolkit.getDefaultToolkit().getSystemEventQueue() instanceof EventHandler)) {
            Toolkit.getDefaultToolkit().getSystemEventQueue().push(this);
        }
    }

    @Override
    protected void dispatchEvent(AWTEvent event) {
        Object eventSource = event.getSource();

        if (eventSource == gameCanvas) {
            handleGameCanvas(event);
        } else if (eventSource == gameFrame) {
            handleGameFrame(event);
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
                super.dispatchEvent(event);
            }
        } else {
            super.dispatchEvent(event);
        }
    }

    private void handleGameFrame(AWTEvent event) {
        if (event instanceof KeyEvent) {
            if (!blocked) {
                super.dispatchEvent(event);
            }
        } else {
            super.dispatchEvent(event);
        }
    }
}
