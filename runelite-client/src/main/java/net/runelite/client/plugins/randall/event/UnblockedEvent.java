package net.runelite.client.plugins.randall.event;

import java.awt.*;

public class UnblockedEvent extends AWTEvent {

    private static final long serialVersionUID = -8757905811316817161L;
    public AWTEvent event = null;

    public UnblockedEvent(AWTEvent e) {
        super(e.getSource(), e.getID());
        this.event = e;
    }
}