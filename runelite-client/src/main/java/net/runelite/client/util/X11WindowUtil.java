package net.runelite.client.util;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.platform.unix.X11;

import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

public final class X11WindowUtil
{
    private X11WindowUtil()
    {
    }

    /**
     * Request window activation via the X11 _NET_ACTIVE_WINDOW protocol.
     */
    public static void forceFocus(Window window)
    {
        if (window == null || !window.isDisplayable())
        {
            return;
        }

        X11 x11 = X11.INSTANCE;

        X11.Display display = x11.XOpenDisplay(null);
        if (display == null)
        {
            return;
        }

        try
        {
            long winId = Native.getWindowID(window);

            X11.Window root = x11.XDefaultRootWindow(display);
            X11.Window win = new X11.Window(winId);

            X11.XClientMessageEvent e = new X11.XClientMessageEvent();
            e.type = X11.ClientMessage;
            e.window = win;
            e.display = display;
            e.message_type = x11.XInternAtom(display, "_NET_ACTIVE_WINDOW", false);
            e.format = 32;

            // https://specifications.freedesktop.org/wm/latest-single/#id-1.4.10
            e.data.setType(NativeLong[].class);
            e.data.l[0] = new NativeLong(1); // source indication (1 = application)
            e.data.l[1] = new NativeLong(0); // timestamp

            X11.XEvent event = new X11.XEvent();
            event.setTypedValue(e);

            x11.XSendEvent(
                    display,
                    root,
                    0,
                    new NativeLong(X11.SubstructureRedirectMask | X11.SubstructureNotifyMask),
                    event
            );

            x11.XFlush(display);
        }
        finally
        {
            x11.XCloseDisplay(display);
        }
    }

    /**
     * Restore and request activation for a Swing window running in X11.
     */
    public static void forceFocus(JFrame frame)
    {
        if (frame == null)
        {
            return;
        }

        EventQueue.invokeLater(() ->
        {
            frame.setExtendedState(Frame.NORMAL);
            forceFocus((Window) frame);
        });
    }
}