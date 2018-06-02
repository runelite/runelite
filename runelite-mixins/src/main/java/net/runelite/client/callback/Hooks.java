/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.callback;

import com.google.common.eventbus.EventBus;
import java.awt.Graphics;
import net.runelite.api.MainBufferProvider;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import org.slf4j.Logger;

/**
 * Dummy class to make the mixins to compile.
 *
 * @author Adam
 */
public class Hooks
{
	public static Logger log;

	public static EventBus eventBus;
	public static EventBus deferredEventBus;

	public static void draw(MainBufferProvider mainBufferProvider, Graphics graphics, int x, int y)
	{
		throw new IllegalStateException();
	}

	public static MouseEvent mousePressed(MouseEvent mouseEvent)
	{
		throw new RuntimeException();
	}

	public static MouseEvent mouseReleased(MouseEvent mouseEvent)
	{
		throw new RuntimeException();
	}

	public static MouseEvent mouseClicked(MouseEvent mouseEvent)
	{
		throw new RuntimeException();
	}

	public static MouseEvent mouseEntered(MouseEvent mouseEvent)
	{
		throw new RuntimeException();
	}

	public static MouseEvent mouseExited(MouseEvent mouseEvent)
	{
		throw new RuntimeException();
	}

	public static MouseEvent mouseDragged(MouseEvent mouseEvent)
	{
		throw new RuntimeException();
	}

	public static MouseEvent mouseMoved(MouseEvent mouseEvent)
	{
		throw new RuntimeException();
	}

	public static MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
	{
		throw new RuntimeException();
	}

	public static void keyPressed(KeyEvent keyEvent)
	{
		throw new RuntimeException();
	}

	public static void keyReleased(KeyEvent keyEvent)
	{
		throw new RuntimeException();
	}

	public static void keyTyped(KeyEvent keyEvent)
	{
		throw new RuntimeException();
	}

	public static boolean menuActionHook(int actionParam, int widgetId, int menuAction, int id, String menuOption, String menuTarget, int var6, int var7)
	{
		throw new RuntimeException();
	}
}
