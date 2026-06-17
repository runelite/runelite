/*
 * Copyright (c) 2026, syslogdaemon <290098959+syslogdaemon@users.noreply.github.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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