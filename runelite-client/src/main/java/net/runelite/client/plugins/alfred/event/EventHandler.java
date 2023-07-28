package net.runelite.client.plugins.alfred.event;

import lombok.Getter;
import lombok.Setter;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.ui.ClientUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class EventHandler extends EventQueue {

    static class UnblockedEvent extends AWTEvent {

        public AWTEvent event;

        public UnblockedEvent(AWTEvent event) {
            super(event.getSource(), event.getID());
            this.event = event;
        }
    }

    @Getter
    @Setter
    private boolean blocked;
    private final Canvas gameCanvas;
    private final JFrame gameFrame;

    public EventHandler() {
        blocked = false;
        gameCanvas = Alfred.getClient().getCanvas();
        gameFrame = ClientUI.getFrame();

        if (!(Toolkit.getDefaultToolkit().getSystemEventQueue() instanceof EventHandler)) {
            Toolkit.getDefaultToolkit().getSystemEventQueue().push(this);
        }
    }

    public void dispatchUnblockedEvent(AWTEvent event) {
        if (event != null && event.getSource() != null) {
            postEvent(new UnblockedEvent(event));
        }
    }

    @Override
    protected void dispatchEvent(AWTEvent event) {
        if (event instanceof UnblockedEvent) {
            handleDispatchedEvent(((UnblockedEvent) event).event, true);
        } else {
            handleDispatchedEvent(event, false);
        }
    }

    private void handleDispatchedEvent(AWTEvent event, boolean isUnblockedEvent) {
        Object eventSource = event.getSource();

        if (blocked && event instanceof FocusEvent) {
            return;
        }

        if (isUnblockedEvent) {
            ((Component) eventSource).dispatchEvent(event);

        } else if (eventSource == gameCanvas && (event instanceof KeyEvent || event instanceof WindowEvent || event instanceof MouseEvent)) {
            if (!blocked) {
                super.dispatchEvent(event);
            }

        } else if (eventSource == gameFrame && event instanceof KeyEvent) {
            if (!blocked) {
                super.dispatchEvent(event);
            }

        } else {
            super.dispatchEvent(event);
        }
    }
}
