package net.runelite.client.plugins.randall.device;


import net.runelite.client.plugins.randall.Utils;
import net.runelite.client.plugins.randall.event.EventHandler;

import java.awt.*;
import java.awt.event.FocusEvent;

public class BaseDevice {

    Canvas canvas;
    boolean isFocused;

    public BaseDevice(Canvas canvas) {
        this.canvas = canvas;
    }

    public void reset() {

    }

    public boolean isFocused() {
        return this.isFocused; //return this.canvas != null && this.canvas.isFocusOwner();
    }

    public void getFocus() {
        if (!isFocused()) {
            EventHandler.PostEvent(new FocusEvent(this.canvas, FocusEvent.FOCUS_GAINED, false, null));
            this.isFocused = true;
            wait(100, 200);
        }
    }

    public void looseFocus() {
        if (isFocused()) {
            EventHandler.PostEvent(new FocusEvent(this.canvas, FocusEvent.FOCUS_LOST, false, null));
            this.isFocused = false;
            wait(100, 200);
        }
    }

    public void wait(int min, int max) {
        int time = min == max ? min : (int) ((Math.random() * Math.abs(max - min)) + Math.min(min, max));
        Utils.sleep(time);
    }

    public void wait(int mills) {
        wait(mills, mills);
    }
}
