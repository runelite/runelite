/*
 * Copyright (c) 2018 Abex
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

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import net.runelite.client.callback.ClientThread;

public class AsyncBufferedImage extends BufferedImage
{
	private final ClientThread clientThread;
	private final List<Runnable> listeners = new ArrayList<>();
	private boolean loaded;

	public AsyncBufferedImage(ClientThread clientThread, int width, int height, int imageType)
	{
		super(width, height, imageType);
		this.clientThread = clientThread;
	}

	/**
	 * Call when the image has been loaded
	 */
	public synchronized void loaded()
	{
		loaded = true;
		for (Runnable r : listeners)
		{
			r.run();
		}
		listeners.clear();
	}

	/**
	 * Register a function to be ran when the image has been loaded.
	 * If the image is already loaded the function will be invoked later on the client thread.
	 */
	public synchronized void onLoaded(Runnable r)
	{
		if (loaded)
		{
			clientThread.invokeLater(r);
			return;
		}

		listeners.add(r);
	}

	/**
	 * Calls setIcon on c, ensuring it is repainted when this changes
	 */
	public void addTo(JButton c)
	{
		c.setIcon(makeIcon(c));
	}

	/**
	 * Calls setIcon on c, ensuring it is repainted when this changes
	 */
	public void addTo(JLabel c)
	{
		c.setIcon(makeIcon(c));
	}

	private ImageIcon makeIcon(JComponent c)
	{
		synchronized (this)
		{
			if (!loaded)
			{
				listeners.add(c::repaint);
			}
		}
		return new ImageIcon(this);
	}
}
