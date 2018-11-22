/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.gpu;

import com.jogamp.nativewindow.awt.JAWTWindow;
import com.jogamp.newt.Window;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.event.TraceKeyAdapter;
import com.jogamp.newt.event.TraceMouseAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import java.awt.Canvas;
import jogamp.newt.awt.event.AWTNewtEventFactory;
import jogamp.newt.awt.event.AWTParentWindowAdapter;
import lombok.Getter;

public class GpuNativeWindow
{
	@Getter
	private final GLWindow window;
	private final Canvas canvas;
	private final AWTParentWindowAdapter adapter;

	public GpuNativeWindow(final GLCapabilities glCaps, final JAWTWindow jawtWindow, final Canvas canvas)
	{
		this.canvas = canvas;
		window = GLWindow.create(glCaps);
		window.setFocusAction(null);
		window.setSize(canvas.getWidth(), canvas.getHeight());
		final float[] reqSurfaceScale = window.getRequestedSurfaceScale(new float[2]);
		jawtWindow.setSurfaceScale(reqSurfaceScale);
		window.reparentWindow(jawtWindow, -1, -1, Window.REPARENT_HINT_BECOMES_VISIBLE);
		window.addSurfaceUpdatedListener(jawtWindow);
		window.setVisible(true);
		window.sendWindowEvent(WindowEvent.EVENT_WINDOW_RESIZED);
		window.addKeyListener(new TraceKeyAdapter());
		window.addMouseListener(new TraceMouseAdapter());

		window.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.MouseEvent event = new java.awt.event.MouseEvent(
					canvas, java.awt.event.MouseEvent.MOUSE_CLICKED, now, 0, e.getX(), e.getY(), 1, false,
					e.getButton());

				for (java.awt.event.MouseListener listener : canvas.getMouseListeners())
				{
					listener.mouseClicked(event);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.MouseEvent event = new java.awt.event.MouseEvent(
					canvas, java.awt.event.MouseEvent.MOUSE_ENTERED, now, 0, e.getX(), e.getY(), 1, false,
					e.getButton());

				for (java.awt.event.MouseListener listener : canvas.getMouseListeners())
				{
					listener.mouseEntered(event);
				}
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.MouseEvent event = new java.awt.event.MouseEvent(
					canvas, java.awt.event.MouseEvent.MOUSE_EXITED, now, 0, e.getX(), e.getY(), 1, false,
					e.getButton());

				for (java.awt.event.MouseListener listener : canvas.getMouseListeners())
				{
					listener.mouseExited(event);
				}
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.MouseEvent event = new java.awt.event.MouseEvent(
					canvas, java.awt.event.MouseEvent.MOUSE_PRESSED, now, 0, e.getX(), e.getY(), 1, false,
					e.getButton());

				for (java.awt.event.MouseListener listener : canvas.getMouseListeners())
				{
					listener.mousePressed(event);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.MouseEvent event = new java.awt.event.MouseEvent(
					canvas, java.awt.event.MouseEvent.MOUSE_RELEASED, now, 0, e.getX(), e.getY(), 1, false,
					e.getButton());

				for (java.awt.event.MouseListener listener : canvas.getMouseListeners())
				{
					listener.mouseReleased(event);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.MouseEvent event = new java.awt.event.MouseEvent(
					canvas, java.awt.event.MouseEvent.MOUSE_MOVED, now, 0, e.getX(), e.getY(), 1, false,
					e.getButton());

				for (java.awt.event.MouseMotionListener listener : canvas.getMouseMotionListeners())
				{
					listener.mouseMoved(event);
				}
			}

			@Override
			public void mouseDragged(MouseEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.MouseEvent event = new java.awt.event.MouseEvent(
					canvas, java.awt.event.MouseEvent.MOUSE_DRAGGED, now, 0, e.getX(), e.getY(), 1, false,
					e.getButton());

				for (java.awt.event.MouseMotionListener listener : canvas.getMouseMotionListeners())
				{
					listener.mouseDragged(event);
				}
			}

			@Override
			public void mouseWheelMoved(MouseEvent e)
			{

			}
		});

		window.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.KeyEvent eventTyped = new java.awt.event.KeyEvent(
					canvas, java.awt.event.KeyEvent.KEY_TYPED,
					now, 0, KeyEvent.VK_UNDEFINED, e.getKeyChar());
				final java.awt.event.KeyEvent event = new java.awt.event.KeyEvent(
					canvas, java.awt.event.KeyEvent.KEY_PRESSED,
					now, 0, AWTNewtEventFactory.newtKeyCode2AWTKeyCode(e.getKeyCode()), e.getKeyChar());

				for (java.awt.event.KeyListener listener : canvas.getKeyListeners())
				{
					listener.keyTyped(eventTyped);
					listener.keyPressed(event);
				}
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				final long now = System.currentTimeMillis();
				final java.awt.event.KeyEvent event = new java.awt.event.KeyEvent(
					canvas, java.awt.event.KeyEvent.KEY_RELEASED,
					now, 0, AWTNewtEventFactory.newtKeyCode2AWTKeyCode(e.getKeyCode()), e.getKeyChar());

				for (java.awt.event.KeyListener listener : canvas.getKeyListeners())
				{
					listener.keyReleased(event);
				}
			}
		});

		adapter = new AWTParentWindowAdapter(jawtWindow, window);
		adapter.addTo(canvas);
	}

	public void destroy()
	{
		adapter.removeFrom(canvas);
		window.destroy();
	}
}
